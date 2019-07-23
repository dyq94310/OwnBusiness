package com.own.business.qrcode.controller;

import com.own.business.qrcode.cmd.QrCmd;
import com.own.business.qrcode.entity.QrImage;
import com.own.business.qrcode.exception.TestException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 二维码Controller
 *
 * @author DengYongQi
 * @date 2018-12-25 15:47
 **/
@RestController
@Slf4j
@RequestMapping(value = "/qr")
public class QrController {

    private Map<Long, QrImage> map = Collections.synchronizedMap(new HashMap<>());

    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    @ApiOperation(value = "错误测试")
    @GetMapping(value = "/exception")
    public void testException() throws Exception {
        throw new Exception("出错了");
    }

    @ApiOperation(value = "错误测试")
    @PostMapping(value = "/jexception")
    public void testJsonException() throws TestException {
        throw new TestException("出错了JSON");
    }


    @ApiOperation(value = "获取所有二维码")
    @GetMapping(value = "/")
    public List<QrImage> getQrImages() {
        return new ArrayList<>(map.values());
    }


    @ApiOperation(value = "插入二维码实体")
    @ApiImplicitParam(name = "cmd", value = "二维码指令类", required = true, dataType = "QrCmd")
    @PostMapping(value = "/image/")
    public String getQrImage(@RequestBody QrCmd cmd) {
        QrImage qrImage = new QrImage();
        qrImage.setContents(cmd.getContents());
        map.put(cmd.getIndex(), qrImage);
        return SUCCESS;
    }

    @ApiOperation(value = "获取单个二维码实体")
    @ApiImplicitParam(name = "index", value = "序号", required = true, dataType = "Long")
    @GetMapping(value = "/{index}")
    public QrImage getQrImages(@PathVariable Long index) {
        return map.get(index);
    }

    @ApiOperation(value = "更新单个二维码实体")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "index", value = "序号", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "cmd", value = "二维码指令类", required = true, dataType = "QrCmd")}
    )
    @PutMapping(value = "/{index}")
    public String putQrImage(@PathVariable Long index, @RequestBody QrCmd cmd) {
        QrImage qrImage = map.get(index);
        if (qrImage == null) {
            return ERROR;
        }
        qrImage.setContents(cmd.getContents());
        return SUCCESS;
    }

    @ApiOperation(value = "删除单个二维码实体")
    @ApiImplicitParam(name = "index", value = "序号", required = true, dataType = "Long")
    @DeleteMapping(value = "/{index}")
    public String deleteQrImage(@PathVariable Long index) {
        map.remove(index);
        return SUCCESS;
    }
}

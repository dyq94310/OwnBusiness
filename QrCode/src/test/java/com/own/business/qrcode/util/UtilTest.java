package com.own.business.qrcode.util;

import com.google.zxing.WriterException;
import com.own.business.util.QrUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 工具测试类
 *
 * @author DengYongQi
 * @date 2018-12-23 10:32
 **/
@Slf4j
@SpringBootTest
public class UtilTest {

    @Test
    public void testQr() {
        try (FileOutputStream outputStream = new FileOutputStream("helloWorlds", false);) {
            byte[] bytes = QrUtil.creatImage("helloWorlds", 200, 200);
            outputStream.write(bytes);
        } catch (WriterException | IOException e) {
            log.error(e.toString());
        }

    }
}

package com.own.business.qrcode.cmd;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 二维码指令
 *
 * @author DengYongQi
 * @date 2018-12-26 16:52
 **/
@Data
@NoArgsConstructor
public class QrCmd {
    private Long index;
    private String contents;
    private int width;
    private int height;
}

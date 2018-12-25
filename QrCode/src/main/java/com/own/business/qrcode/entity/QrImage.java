package com.own.business.qrcode.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 二维码实体
 *
 * @author DengYongQi
 * @date 2018-12-26 16:55
 **/
@Data
@NoArgsConstructor
public class QrImage {
    private String path;
    private String contents;
}

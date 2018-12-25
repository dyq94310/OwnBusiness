package com.own.business.qrcode.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * 二维码工具
 *
 * @author DengYongQi
 * @date 2018-12-22 17:39
 **/
@Slf4j
public class QrUtil {

    private QrUtil() {

    }

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    private static final String JPEG = "JPEG";

    /**
     * 生成二维码
     *
     * @param contents 文本
     * @param width    w
     * @param height   h
     * @return 二进制数组
     * @throws WriterException e
     */
    public static byte[] creatImage(String contents, int width, int height) throws WriterException, IOException {

        HashMap<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();) {
            return ImageIO.write(toBufferedImage(bitMatrix), JPEG, outputStream) ? outputStream.toByteArray() : new byte[0];
        }

    }


    /**
     * BitMatri 二维数组转为BufferedImage
     *
     * @param matrix BitMatri
     * @return 图片
     */
    private static BufferedImage toBufferedImage(BitMatrix matrix) {

        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bufferedImage.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return bufferedImage;
    }
}

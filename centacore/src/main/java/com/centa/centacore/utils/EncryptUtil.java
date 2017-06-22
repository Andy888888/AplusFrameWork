package com.centa.centacore.utils;

import android.text.TextUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yanwenqiang on 2017/6/22.
 * <p>
 * 描述:加密工具
 */
public class EncryptUtil {

    /**
     * MD5加密（不加盐／不加密钥）
     *
     * @param text 加密原始串
     * @return 加密结果
     */
    public static String md5(final String text) {
        StringBuilder result = new StringBuilder();
        if (TextUtils.isEmpty(text))
            return result.toString();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] input = text.getBytes();
            byte[] buff = messageDigest.digest(input);

            for (int digital : buff) {
                if (digital < 0) {
                    digital += 256;
                }
                if (digital < 16) {
                    result.append("0");
                }
                result.append(Integer.toHexString(digital));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}

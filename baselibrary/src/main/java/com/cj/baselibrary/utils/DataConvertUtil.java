package com.cj.baselibrary.utils;

/**
 * @author superFan
 * date: 2019/9/19/019 10:30
 * Copyright (c) 2019 hezhongweiqi.Co.Ltd. All rights reserved.
 * description: 数据转换工具类
 */
public class DataConvertUtil {

    /**
     * 将16进制字符串转换成byte数组
     *
     * @param value 待转换字符串
     * @return 转换完成的字符串-正确 null-错误
     */
    public static byte[] toBytes(String value) {
        // 确保传入数据有效
        if (value == null || value.trim().length() <= 0) {
            return null;
        }
        value = value.trim();
        // 确保有效数据长度有效（为2的倍数）
        if (value.length() % 2 != 0) {
            return null;
        }
        byte[] ret = new byte[value.length() / 2];
        for (int i = 0; i < ret.length; i++) {
            try {
                /*
                前面的逻辑已经保证了字符串长度是byte数组长度的2倍
                这里没有进行数组越界的判断
                 */
                String tmp = value.substring(i * 2, i * 2 + 2);
                int a = Integer.parseInt(tmp, 16);
                int b = a & 0xFF;
                byte c = (byte) b;
                ret[i] = (byte) (Integer.parseInt(tmp, 16) & 0xFF);
            } catch (Exception e) {
                return null;
            }
        }
        return ret;
    }

    /**
     * 将byte数组转化为HEX字符串
     *
     * @param value  带转化byte数组
     * @param offset 数组开始位置
     * @param length 解析长度
     * @return 转化后的字符串-正确 null-错误
     */
    public static String toHexString(byte[] value, int offset, int length) {
        /*
        确保带转化数组有效
        确保传入的数组位置和长度信息没有越界
         */
        if (value == null || offset < 0 || length < 0 || offset + length > value.length) {
            return null;
        }

        StringBuilder retBuffer = new StringBuilder();

        for (int i = offset; i < offset + length; i++) {
            retBuffer.append(toHexString(value[i]));
        }

        return retBuffer.toString();
    }

    /**
     * 将byte值转化为HEX字符串
     *
     * @param value 带转化值
     * @return 转化后的HEX字符串-正确 null-错误
     */
    public static String toHexString(byte value) {
        String tmp = Integer.toHexString(value & 0xFF);
        /*
        为保证返回的字符串能够正确转化为byte数组
        保证字符串长度为2的倍数
         */
        return tmp.length() % 2 == 1 ? "0" + tmp : tmp;
    }
}

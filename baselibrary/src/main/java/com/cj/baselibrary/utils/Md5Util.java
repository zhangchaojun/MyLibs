package com.cj.baselibrary.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
    /**
     * 获取一个文件的md5值(可处理大文件)
     *
     * @return md5 value
     */

    public static String getMD5(String filePath) {
        BigInteger bigInt = null;
        try (FileInputStream fis = new FileInputStream(filePath)) {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fis.read(buffer, 0, 1024)) != -1) {
                md.update(buffer, 0, length);
            }
            bigInt = new BigInteger(1, md.digest());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bigInt != null) {
            String s = bigInt.toString(16);
            if (s.length() != 32) {
                int lack = 32 - s.length();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < lack; i++) {
                    stringBuilder.append("0");
                }
                s = stringBuilder.toString() + s;
            }
            return s;
        }
        return "";
    }
}
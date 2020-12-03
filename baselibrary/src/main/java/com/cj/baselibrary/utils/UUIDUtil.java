package com.cj.baselibrary.utils;

/**
 * Created by cj on 2020/3/7.
 */
public class UUIDUtil {

    public static boolean isValidUUID(String uuid) {
        // UUID校验
        if (uuid == null) {
            System.out.println("uuid is null");
        }
        String regex = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$";
        if (uuid.matches(regex)) {
            return true;
        }
        return false;
    }
}

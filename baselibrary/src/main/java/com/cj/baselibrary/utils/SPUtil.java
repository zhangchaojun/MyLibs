package com.cj.baselibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;


import com.cj.baselibrary.application.MyKernel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cj on 2020/8/25.
 */
public class SPUtil {

    private static Map<String, SPUtil> instanceMap = new HashMap<>();
    private SharedPreferences sp;

    /**
     * 获取SP实例
     */
    public static SPUtil getInstance() {
        return getInstance("config");
    }

    /**
     * 获取SP实例
     *
     * @param spName sp名
     * @return {@link SPUtil}
     */
    public static SPUtil getInstance(String spName) {
        if (instanceMap.containsKey(spName)) {
            return instanceMap.get(spName);
        } else {
            SPUtil sp = new SPUtil(spName);
            instanceMap.put(spName, sp);
            return sp;
        }
    }

    private SPUtil(String spName) {
        sp = MyKernel.getInstance().getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
    }


    public void put(String key, String value) {
        sp.edit().putString(key, value).apply();
    }

    public String getString(String key, String defaultValue) {
        return sp.getString(key, defaultValue);
    }

    public void put(String key, int value) {
        sp.edit().putInt(key, value).apply();
    }

    public int getInt(String key, int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

    public void put(String key, long value) {
        sp.edit().putLong(key, value).apply();
    }

    public long getLong(String key, long defaultValue) {
        return sp.getLong(key, defaultValue);
    }

    public void put(String key, float value) {
        sp.edit().putFloat(key, value).apply();
    }

    public float getFloat(String key, float defaultValue) {
        return sp.getFloat(key, defaultValue);
    }

    public void put(String key, boolean value) {
        sp.edit().putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return sp.getBoolean(key, defaultValue);
    }

    public void remove(String key) {
        sp.edit().remove(key).apply();
    }

    public boolean contains(String key) {
        return sp.contains(key);
    }

    public void clear() {
        sp.edit().clear().apply();
    }

}

package com.cj.baselibrary.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * toast提示工具类
 */
public class ToastUtils {
    private static long lastShowTime = 01;
    private static String lastShowMsg = null;
    private static String curShowMsg = null;
    private static final int TOAST_DURATION = 2000;


    public static void showToast(Context context, int resId) {
        if (!ActivityCheckUtil.isActive(context))
            return;
        if (TextUtils.isEmpty(context.getString(resId)))
            return;

        show(context, context.getString(resId));
    }

    public static void showToast(Context context, String str) {
        //如果上下文已经销货  则终止运行
        if (!ActivityCheckUtil.isActive(context) || TextUtils.isEmpty(str))
            return;
        show(context, str);

    }

    public static void show(Context context, String str) {
        //以下代码是为了避免多次点击弹窗的bug
        long curShowTime = System.currentTimeMillis();
        curShowMsg = str == null ? "" : str;
        if (curShowMsg.equals(lastShowMsg)) {
            if (curShowTime - lastShowTime > TOAST_DURATION) {
                Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
                lastShowTime = curShowTime;
                lastShowMsg = curShowMsg;
            }
        } else {
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
            lastShowTime = curShowTime;
            lastShowMsg = curShowMsg;
        }
    }
}

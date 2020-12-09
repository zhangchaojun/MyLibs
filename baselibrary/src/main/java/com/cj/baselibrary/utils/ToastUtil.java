package com.cj.baselibrary.utils;

import android.widget.Toast;

import com.cj.baselibrary.application.MyKernel;


/**
 * toast提示工具类
 */
public class ToastUtil {

    private static ToastUtil instance;

    private Toast mToast;

    private ToastUtil() {
        mToast = Toast.makeText(MyKernel.getInstance().getContext(), "", Toast.LENGTH_SHORT);
    }

    private static ToastUtil getInstance() {
        if (instance == null) {
            synchronized (ToastUtil.class) {
                if (instance == null) {
                    instance = new ToastUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 调用直接替换，覆盖上一个内容
     */
    public static void show(String msg) {
        getInstance().showToast(msg);
    }

    /**
     * 调用不替换上一个，等上一个结束才出现
     */
    public static void ensureShow(String msg) {
        getInstance().ensureShowToast(msg);
    }

    private void showToast(String msg) {
        mToast.setText(msg);
        mToast.show();
    }


    private void ensureShowToast(String msg) {
        Toast.makeText(MyKernel.getInstance().getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}

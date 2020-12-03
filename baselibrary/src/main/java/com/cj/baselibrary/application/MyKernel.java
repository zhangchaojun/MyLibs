package com.cj.baselibrary.application;

import android.content.Context;

/**
 * Created by cj on 2020/8/25.
 */
public class MyKernel {

    private static MyKernel instance;
    private Context mContext;

    public static MyKernel getInstance() {
        if (instance == null) {
            synchronized (MyKernel.class) {
                if (instance == null) {
                    instance = new MyKernel();
                }
            }
        }
        return instance;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return mContext;
    }


}

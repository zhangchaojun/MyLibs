package com.cj.baselibrary.application;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;


import com.cj.baselibrary.utils.LogUtil;

import java.util.Iterator;
import java.util.List;

/**
 * Created by cj on 2020/1/21.
 */
public class MyBaseApplication extends Application {

    private static final String TAG = "HZBaseApplication";
    private static MyBaseApplication instance;
    private Activity mTopActivity;
    private int mActivityCount = 0;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        registerActivityLifecycleCallbacks(callbacks);
        MyKernel.getInstance().init(this);

    }

    public static MyBaseApplication getInstance() {
        return instance;
    }


    Application.ActivityLifecycleCallbacks callbacks = new Application.ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(Activity activity) {


        }

        @Override
        public void onActivityResumed(Activity activity) {
            mTopActivity = activity;
            mActivityCount++;
            LogUtil.i(TAG, "topActivity == "+activity.getLocalClassName());
        }

        @Override
        public void onActivityPaused(Activity activity) {
            mTopActivity = null;
            mActivityCount--;

        }

        @Override
        public void onActivityStopped(Activity activity) {


        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    };

    /**
     * 获取当前栈顶activity
     */
    public Activity getTopActivity() {
        return mTopActivity;
    }

    /**
     * 判断应用是否在前台
     */
    public boolean isAppForeground(){
        return (mActivityCount & 1) == 1;
    }

    /**
     * 获取当前进程名字
     *
     * @return
     */
    public String getProcesssName() {
        int pid = android.os.Process.myPid();
        String processName = "";
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List lst = am.getRunningAppProcesses();
        if (lst == null) {
            return getPackageName();
        }
        Iterator i = lst.iterator();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pid) {
                    processName = info.processName;
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return processName;
    }

    public boolean isRemoteService() {
        String processName = getProcesssName();
        if (!processName.equals(getPackageName())) {
            Log.d(TAG, "exit onCreate, Remote service : " + processName);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        unregisterActivityLifecycleCallbacks(callbacks);
    }
}

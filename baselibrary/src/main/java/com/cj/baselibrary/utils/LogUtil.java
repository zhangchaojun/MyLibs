package com.cj.baselibrary.utils;

import android.annotation.SuppressLint;
import android.util.Log;


/**
 * Log日志输出工具类
 */
public class LogUtil {

    /**
     * library的提供的是release包，需自己定义flag传入。
     */
    private static boolean isDebug = false;
    //是否已初始化
    private static boolean initFlag = false;

    private static final String TAG = "com.sgcc.pda";

    public static void init(boolean debugFlag) {
        isDebug = debugFlag;
        initFlag = true;
    }


    public static void v(String tag, String content) {
        LOG(tag, content, Log.VERBOSE);
    }

    public static void v(String content) {
        LOG(TAG, content, Log.VERBOSE);
    }

    public static void d(String tag, String content) {
        LOG(tag, content, Log.DEBUG);
    }

    public static void d(String content) {
        LOG(TAG, content, Log.DEBUG);
    }

    public static void i(String tag, String content) {
        LOG(tag, content, Log.INFO);
    }

    public static void i(String content) {
        LOG(TAG, content, Log.INFO);
    }

    public static void w(String tag, String content) {
        LOG(tag, content, Log.WARN);
    }

    public static void w(String content) {
        LOG(TAG, content, Log.WARN);
    }

    public static void e(String tag, String content) {
        LOG(tag, content, Log.ERROR);
    }

    public static void e(String content) {
        LOG(TAG, content, Log.ERROR);
    }


    /**
     * @param tag     log的tag
     * @param content log的内容
     * @param logType log的类型
     */
    @SuppressLint("DefaultLocale")
    private static void LOG(String tag, String content, int logType) {
        if (!initFlag) {
            Log.e("LogUtil", "LogUtil没有初始化，请先初始化后使用，如果未初始化Log将不会输出显示");
        }

        //debug包才打印日志，release不打印
        if (isDebug) {
            Throwable throwable = new Throwable();
            //LogUtil.LOG()的depth是0, LogUtil.e()函数的depth是1, 调用者的depth是2,调用者的调用者是3
            int methodDepth = 2;
            StackTraceElement[] stackTraceElements = throwable.getStackTrace();
            if (methodDepth < stackTraceElements.length) {
                StackTraceElement element = stackTraceElements[methodDepth];
                if (element != null && element.getFileName() != null) {
                    String className = element.getFileName().substring(0, element.getFileName().lastIndexOf("."));
                    content = String.format("[(%s:%d).%s()] %s", element.getFileName(), element.getLineNumber(), element.getMethodName(), content);
                }
            }

            switch (logType) {
                case Log.VERBOSE:
                    Log.v(tag, "===>" + content);
                    break;
                case Log.DEBUG:
                    Log.d(tag, "===>" + content);
                    break;
                case Log.INFO:
                    Log.i(tag, "===>" + content);
                    break;
                case Log.WARN:
                    Log.w(tag, "===>" + content);
                    break;
                case Log.ERROR:
                    FullLogUtil.e(tag, "===>" + content);
                    break;
                default:
                    break;
            }
        }

    }
}

package com.cj.baselibrary.utils;

import android.util.Log;

/**
 * 长日志分段打印
 */
public class FullLogUtil {
    /**
     * 截断输出日志
     *
     * @param msg
     */
    public static void e(String tag, String msg) {
        if (tag == null || tag.length() == 0
                || msg == null || msg.length() == 0)
            return;

        int segmentSize = 3 * 1024;//一次打印3K数据
        long length = msg.length();//log总长度
        long totalBlock = length % segmentSize == 0 ? length / segmentSize : length / segmentSize + 1;
        if (length <= segmentSize) {// 长度小于等于限制直接打印
            Log.e(tag, msg);
        } else {
            int flag = 0;
            for (int i = 0; i < (length / segmentSize); i++) {
                flag = i + 1;
                String logContent = msg.substring(i * segmentSize, flag * segmentSize);
                Log.e(tag, "(" + flag + "/" + totalBlock + "):" + logContent);
            }
            Log.e(tag, "(" + (flag + 1) + "/" + totalBlock + "):" + msg.substring(flag * segmentSize));// 打印剩余日志
        }
    }
}

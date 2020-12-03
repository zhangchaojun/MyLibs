package com.cj.baselibrary.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.os.Build;

import com.cj.baselibrary.application.MyKernel;


public class FlashlightUtil {

    private static FlashlightUtil instance = null;

    private Context context;
    private CameraManager manager;
    private Camera mCamera;
    private boolean isOpenLight = false;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FlashlightUtil() {
        this.context = MyKernel.getInstance().getContext();
        manager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
    }

    public static FlashlightUtil getInstance() {
        if (instance == null) {
            instance = new FlashlightUtil();
        }
        return instance;
    }

    /**
     * 手电筒控制方法
     *
     * @param lightStatus true打开 false关闭
     * @return
     */
    public boolean lightSwitch(boolean lightStatus) {
        if (!lightStatus) { // 关闭手电筒
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                try {
                    manager.setTorchMode("0", false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                if (mCamera != null) {
                    mCamera.stopPreview();
                    mCamera.release();
                    mCamera = null;
                }
            }
            return true;
        } else { // 打开手电筒
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                try {
                    manager.setTorchMode("0", true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                final PackageManager pm = context.getPackageManager();
                final FeatureInfo[] features = pm.getSystemAvailableFeatures();
                for (final FeatureInfo f : features) {
                    if (PackageManager.FEATURE_CAMERA_FLASH.equals(f.name)) { // 判断设备是否支持闪光灯
                        if (null == mCamera) {
                            mCamera = Camera.open();
                        }
                        final Camera.Parameters parameters = mCamera.getParameters();
                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        mCamera.setParameters(parameters);
                        mCamera.startPreview();
                    }
                }
            }
            return false;
        }
    }
}

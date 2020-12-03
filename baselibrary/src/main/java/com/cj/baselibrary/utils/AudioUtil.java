package com.cj.baselibrary.utils;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by  rzh
 * on 2019/10/12
 */


public class AudioUtil {
    public static void play(Context context, int raw) {
        MediaPlayer mpMediaPlayer = MediaPlayer.create(context, raw);
        try {
            mpMediaPlayer.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mpMediaPlayer.start();

    }
}

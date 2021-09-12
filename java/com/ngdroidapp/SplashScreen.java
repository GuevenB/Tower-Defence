package com.ngdroidapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.VideoView;

import com.nitragames.evilrush.GameActivity;
import com.nitragames.evilrush.R;


/**
 * Created by noyan on 27.06.2016.
 * Nitra Games Ltd.
 */

public class SplashScreen extends Activity {
    private long start;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        try {
            VideoView videoView = new VideoView(this);
            setContentView(videoView);
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.logo01));
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    jump();
                }
            });
            start = System.currentTimeMillis();
            videoView.start();
        } catch (Exception e) {
            jump();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (System.currentTimeMillis() - start > 1000) {
            jump();
        }
        return super.onTouchEvent(event);
    }

    private void jump() {
        if (isFinishing())
            return;
        startActivity(new Intent(this, GameActivity.class));
        finish();
    }
}

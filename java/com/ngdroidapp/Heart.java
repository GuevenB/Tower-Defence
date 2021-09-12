package com.ngdroidapp;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.ngdroidapp.Objects.NgObjectDrawable;

import istanbul.gamelab.ngdroid.util.Log;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 9.07.2018.
 */
@SuppressWarnings("SameParameterValue")
public class Heart extends NgObjectDrawable {
    private int live;
    private Paint painter;

    public Heart(NgApp ngApp)   {
        super(ngApp, "heart.png", 1820, 112, 80, 80);
        painter = new Paint();
        painter.setColor(Properties.COLOR_GOLD);
        painter.setTypeface(Typeface.createFromAsset(ngApp.activity.getAssets(), Properties.INGAME_FONT));
        painter.setTextSize(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * Properties.INGAME_FONT_SIZE);
        Log.i("asssd", Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * Properties.INGAME_FONT_SIZE + "");
        this.live = 20;
    }

    public Heart(Heart h, NgApp ngApp) {
        super(ngApp, "heart.png", 1820, 112, 80, 80);
        painter = h.painter;
        painter.setTextSize(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * Properties.INGAME_FONT_SIZE);
        live = h.live;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawText(live + " ",
                Destination().right - (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * (192)),
                Destination().bottom,
                painter
        );
        Log.i("assd", Destination().right + " " + (Destination().right - (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * (192))) + " " + NgApp.SCREEN_WIDTH + " " + Destination().bottom);
    }

    public void Down()  {
        this.live--;
    }

    public int Life() { return this.live; }

    public void Life(long num) { this.live = (int)num; }
}

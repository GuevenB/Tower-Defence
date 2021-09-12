package com.ngdroidapp;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.ngdroidapp.Objects.NgObjectDrawable;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 01.07.2018.
 */

public class TowerOptions extends NgObjectDrawable{
    public TowerOption option[];

    // Constructor
    public TowerOptions(NgApp ngApp, String path, Rect destination) {
        super(ngApp, path, destination);
        Destination(destination.left - (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * (destination.width() / 3)),
                    destination.top -  (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * (destination.height() / 3)),
                    destination.right +  (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * (destination.width() / 3)),
                    destination.bottom +  (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * (destination.height() / 3)), false);
        option = new TowerOption[4];
        // X 0 Y 17
        option[0] = new TowerOption(ngApp, "Options/0_Option_0.png",0, Destination().left, Destination().top + (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * 24));
        // X 0 Y 137
        option[1] = new TowerOption(ngApp, "Options/1_Option_0.png",1, Destination().left, Destination().bottom - (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * 109));
        // X 148 Y 17
        option[2] = new TowerOption(ngApp, "Options/2_Option_0.png",2,Destination().right - (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * 115), Destination().top + (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * 24));
        // X 148 Y 137
        option[3] = new TowerOption(ngApp, "Options/3_Option_0.png",3,Destination().right - (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * 115), Destination().bottom - (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * 109));
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        for (int i = 0; i < 4; i++) {
            option[i].draw(canvas);
        }
    }
}

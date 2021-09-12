package com.ngdroidapp.GUI;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.ngdroidapp.NgApp;
import com.ngdroidapp.Objects.NgObjectClickable;

import istanbul.gamelab.ngdroid.util.Utils;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 2.07.2018.
 */

public class NgButton extends NgObjectClickable {
    private boolean hover;
    private Bitmap onHover, locked;
    public NgButton(NgApp ngApp, String path, String onClickPath, int x, int y, int w, int h)   {
        super(ngApp, path, x, y, w, h);
        onHover = Utils.loadImage(ngApp, onClickPath);
    }

    public NgButton(NgApp ngApp, String path, String onClickPath, String lockedPath, int x, int y, int w, int h)   {
        super(ngApp, path, x, y, w, h);
        onHover = Utils.loadImage(ngApp, onClickPath);
        locked = Utils.loadImage(ngApp, lockedPath);
    }

    @Override
    public void draw(Canvas canvas) {
        if(hover)   {
            canvas.drawBitmap(onHover, SourceLocation(), Destination(), null);
        }
        else
            super.draw(canvas);
    }

    public void draw(Canvas canvas, boolean on) {
        if(hover)   {
            canvas.drawBitmap(onHover, SourceLocation(), Destination(), null);
        }
        else if (on) {
            canvas.drawBitmap(locked, SourceLocation(), Destination(), null);
        }
        else
            super.draw(canvas);
    }

    public void onHover(int x, int y)   {
        hover = Destination().intersects(x,y,x,y);
    }

    public void onHover() { hover = false; }
}

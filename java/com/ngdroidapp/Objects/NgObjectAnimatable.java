package com.ngdroidapp.Objects;

import android.graphics.Rect;

import com.ngdroidapp.NgApp;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 01.07.2018.
 */

public class NgObjectAnimatable extends NgObjectDrawable {

    private int frame;

    public int ix, iy;

    public int vx, vy;

    public NgObjectAnimatable(NgApp ngApp, String path, int dx, int dy, int dw, int dh) {
        super(ngApp, path, dx, dy, dw, dh);
    }

    public NgObjectAnimatable(NgApp ngApp, String path, int dx, int dy, int dw, int dh,  int sx, int sy, int sw, int sh) {
        super(ngApp, path, dx, dy, dw, dh, sx, sy, sw, sh);
        ix = 0;
        iy = 1;
        vx = 4;
        vy = 4;
    }

    public NgObjectAnimatable(NgApp ngApp, String path, Rect destination) {
        super(ngApp, path, destination);
    }

    public NgObjectAnimatable(NgApp ngApp, String path, Rect sourcelocation, Rect destination) {
        super(ngApp, path, sourcelocation, destination);
    }

    public void update()    {
        frame++;
        if (frame >= 7) {
            frame = 0;
        }
        SourceLocation(frame * SourceLocation().width(), SourceLocation().top, SourceLocation().width(), SourceLocation().height());
        Destination(vx * ix , vy * iy);
    }

     public void Frame(int num) { this.frame = num; }
     public int Frame() { return this.frame;}
}

package com.ngdroidapp.Objects;

import android.graphics.Rect;

import com.ngdroidapp.NgApp;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 01.07.2018.
 */

public class NgObjectClickable extends NgObjectDrawable {
    private boolean isClicked;

    public NgObjectClickable(NgApp ngApp, String path, int dx, int dy, int dw, int dh) {
        super(ngApp, path, dx, dy, dw, dh);
        this.isClicked = false;
    }

    public NgObjectClickable(NgApp ngApp, String path, int dx, int dy, int dw, int dh,  int sx, int sy, int sw, int sh) {
        super(ngApp, path, dx, dy, dw, dh, sx, sy, sw, sh);
        this.isClicked = false;
    }

    public NgObjectClickable(NgApp ngApp, String path, Rect destination) {
        super(ngApp, path, destination);
        this.isClicked = false;
    }

    public NgObjectClickable(NgApp ngApp, String path, Rect sourcelocation, Rect destination) {
        super(ngApp, path, sourcelocation, destination);
        this.isClicked = false;
    }

    public boolean IsClicked(int x, int y) { this.isClicked = intersects(x, y); return this.isClicked; }
    public boolean IsClicked() { return this.isClicked; }
    public void onReleased() { this.isClicked = false; }
}

package com.ngdroidapp.Objects;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.ngdroidapp.NgApp;

import istanbul.gamelab.ngdroid.util.Log;
import istanbul.gamelab.ngdroid.util.Utils;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 01.07.2018.
 */

public class NgObjectDrawable extends NgObject {
    private Rect sourcelocation;
    private Bitmap source;

    private final String TAG = this.getClass().getName();

    public NgObjectDrawable(NgApp ngApp, String path, int dx, int dy, int dw, int dh) {
        super(dx, dy, dw, dh);
        this.source = Utils.loadImage(ngApp, path);
        try {
            this.sourcelocation = new Rect(0, 0, this.source.getWidth(), this.source.getHeight());
        }
        catch (NullPointerException e)
        {
            Log.i(TAG, e.getMessage());
            this.source = Utils.loadImage(ngApp, "error.png");
            this.sourcelocation = new Rect(0, 0, this.source.getWidth(), this.source.getHeight());
        }
    }

    public NgObjectDrawable(NgApp ngApp, String path, int dx, int dy, int dw, int dh,  int sx, int sy, int sw, int sh) {
        super(dx, dy, dw, dh);
        this.source = Utils.loadImage(ngApp, path);
        try {
            this.sourcelocation = new Rect(sx, sy, sx + sw, sy + sh);
        }
        catch (NullPointerException e)
        {
            Log.i(TAG, e.getMessage());
            this.source = Utils.loadImage(ngApp, "error.png");
            this.sourcelocation = new Rect(0, 0, this.source.getWidth(), this.source.getHeight());
        }
    }

    public NgObjectDrawable(NgApp ngApp, String path, Rect destination) {
        super(destination);
        this.source = Utils.loadImage(ngApp, path);
        try {
            this.sourcelocation = new Rect(0, 0, this.source.getWidth(), this.source.getHeight());
        }
        catch (NullPointerException e)
        {
            Log.i(TAG, e.getMessage());
            this.source = Utils.loadImage(ngApp, "error.png");
            this.sourcelocation = new Rect(0, 0, this.source.getWidth(), this.source.getHeight());
        }
    }

    public NgObjectDrawable(NgApp ngApp, String path, Rect sourcelocation, Rect destination) {
        super(destination);
        this.source = Utils.loadImage(ngApp, path);
        try {
            this.sourcelocation = new Rect(sourcelocation);
        }
        catch (NullPointerException e)
        {
            Log.i(TAG, e.getMessage());
            this.source = Utils.loadImage(ngApp, "error.png");
            this.sourcelocation = new Rect(0,0, this.source.getWidth(), this.source.getHeight());
        }
    }

    /**
     * @return The Location of the Source Sprite as Rectangle
     */
    public Rect SourceLocation() { return this.sourcelocation; }

    /**
     * @param dx The amount to add to the right and left coordinates of Source Sprite
     * @param dy The amount to add to the top and bottom coordinates of Source Sprite
     */
    public void SourceLocation(int dx, int dy) { this.sourcelocation.offset(dx, dy); }

    /**
     * @param x The X coordinate of the Source Sprite
     * @param y The Y coordinate of the Source Sprite
     * @param w The Width of the Source Sprite
     * @param h The Height of the Source Sprite
     */
    public void SourceLocation(int x, int y, int w, int h) { this.sourcelocation.set(x, y, x + w, y + h); }

    public Bitmap Source() { return this.source; }

    public void Source(NgApp ngApp, String path) { this.source = Utils.loadImage(ngApp, path); }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.source, this.sourcelocation, Destination(), null);
    }
}

package com.ngdroidapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.ngdroidapp.Objects.NgObject;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 3.07.2018.
 */

public class TowerRange extends NgObject {
    private int centerX, centerY;
    private float radius;
    private Paint painter;
    private boolean isinvaded;
    public TowerRange(int x, int y, int radius) {
        super(x - radius, y - radius, 2*radius, 2*radius);
        this.centerX = x;
        this.centerY = y;
        this.radius = radius;
        this.painter = new Paint();
        this.painter.setStyle(Paint.Style.STROKE);
        this.painter.setColor(Color.BLUE);
        this.isinvaded = false;
    }

    private int deltaX(int left, int right) {
        return this.centerX - Math.max(left, Math.min(this.centerX, right));
    }

    private int deltaY(int top, int bottom) {
        return this.centerY - Math.max(top, Math.min(this.centerY, bottom));
    }

    public boolean IsInvaded()  { return this.isinvaded; }

    @Override
    public boolean intersects(int x, int y, int r, int b) {
        this.isinvaded = (deltaX(x, r) * deltaX(x, r) + deltaY(y, b) * deltaY(y, b)) < (this.radius * this.radius);
        return this.isinvaded;
    }

    @Override
    public boolean intersects(Rect b) {
        return this.intersects(b.left, b.top, b.right, b.bottom);
    }

    @Override
    public boolean intersects(int x, int y) {
        return intersects(x, y, x, y);
    }

    @Override
    public boolean intersects(Point point) {
        return intersects(point.x, point.y);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(centerX, centerY, radius, painter);
    }
}

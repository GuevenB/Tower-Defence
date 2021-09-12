package com.ngdroidapp;

import android.graphics.Canvas;
import android.graphics.Point;

import com.ngdroidapp.Objects.NgObject;
import com.ngdroidapp.Objects.NgObjectDrawable;

/**
 * Created by PC LAB on 15.08.2018.
 */
// BITMEDI
public class Tank extends NgObjectDrawable {

    private NgObjectDrawable ammo;

    private TowerRange range;

    public long attackStart;

    private boolean released = false;

    private Point point;

    private double angle, ammoangle;

    private int ix = 0, iy = 0, vx = 4, vy = 4;

    public Tank(NgApp ngApp, int dx, int dy, int angle) {
        super(ngApp, "Tank.png", dx, dy, 128, 128);
        this.angle = angle;
        if (angle != 0) {
            this.iy = -1;
            Destination(0, -200);
        }
        else {
            this.ix = -1;
            Destination(-200, 0);
        }

        ammo = new NgObjectDrawable(ngApp, "Ammo.png", X(), Y(), 96, 96);
        point = new Point();
        range = new TowerRange(Destination().centerX(), Destination().centerY(), Destination().width() * 3);
    }

    public void update() {
        if (released) {
            if (point != null) {
                int difx = this.point.x - Destination().centerX();
                int dify = this.point.y - Destination().centerY();
                if (difx > 32)
                    ix = 1;
                else if (difx < -32)
                    ix = -1;
                else
                    ix = 0;
                if (dify > 32)
                    iy = 1;
                else if (dify < -32)
                    iy = -1;
                else
                    iy = 0;
                angle = Math.atan2(Destination().centerY() - point.y, Destination().centerX() - point.x) * 180 / Math.PI;
                ammoangle = Math.atan2(ammo.Destination().centerY() - point.y, ammo.Destination().centerX() - point.x) * 180 / Math.PI;
                ammo.Destination(vx * ix, vy * iy);
            }
            if (ammo.intersects(point)) {
                Released(false);
            }
            if (!Range().intersects(ammo.Destination())) {
                Released(false);
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.rotate((float)angle, Destination().centerX(), Destination().centerY());
        super.draw(canvas);
        canvas.restore();
        if (released) {
            canvas.save();
            canvas.rotate((float)ammoangle, ammo.Destination().centerX(), ammo.Destination().centerY());
            ammo.draw(canvas);
            canvas.restore();
        }
    }

    public void Released(boolean state) {
        if (!state) {
            ammo.Destination(X(), Y(), X() + 96, Y() + 96);
        }
        if (state) {
            attackStart = System.currentTimeMillis();
        }
        this.released = state;
    }

    public boolean Released() { return this.released; }

    public void setPoint(int x, int y) {
        this.point.set(x, y);
    }

    public TowerRange Range() { return this.range; }

    public NgObjectDrawable Ammo() { return this.ammo; }
}

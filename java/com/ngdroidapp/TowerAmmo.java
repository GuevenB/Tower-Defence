package com.ngdroidapp;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import com.ngdroidapp.Objects.NgObjectDrawable;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 5.07.2018.
 */

public class TowerAmmo extends NgObjectDrawable {
    private int ix, iy;
    private int velocity;
    private Rect mainDestination;
    private boolean released;
    private Point point;
    private int damage, TYPE;
    private Rect wiev;
    private double angleDeg;

    public TowerAmmo(NgApp ngApp, int type, Rect destination)    {
        super(ngApp, Properties.AMMOSHEET, destination);
        Destination(destination.left, destination.top, destination.left + (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * 128), destination.top + (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * 128), false);
        wiev = new Rect(0, 0, ngApp.getWidth(), ngApp.getHeight());
        switch (type) {
            case 2:
            case 0:
                this.TYPE = 0;
                break;
            case 1:
                this.TYPE = 1;
                break;
            case 3:
                this.TYPE = 2;
                break;
        }
        this.damage = Properties.TOWER_ATTACK_DAMAGE[type][0];
        SourceLocation(Properties.AMMO[TYPE][0]);
        this.mainDestination = new Rect(Destination());
        this.velocity = (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * 12);
    }

    public boolean Released() { return this.released; }
    public void Released(boolean state, Point point) {
        this.point = point;
        this.released = state;
        Destination(mainDestination.left, mainDestination.top, mainDestination.right, mainDestination.bottom, false);
    }

    public void update(Monster monster, int i, TowerRange range)   {
        if(this.released) {
            if (point != null && i == 0) {
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
                angleDeg = Math.atan2(Destination().centerY() - point.y, Destination().centerX() - point.x) * 180 / Math.PI;
                Destination(velocity * ix, velocity * iy);
            }
            if (monster.intersects(Destination())) {
                Released(false, null);
                monster.HpBar().update(this.damage);
            } else if (!Rect.intersects(Destination(), wiev)) {
                Released(false, null);
            } else if (intersects(point)) {
                Released(false, null);
            } else if (!range.intersects(Destination())) {
                Released(false, null);
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.rotate((float)angleDeg, Destination().centerX(), Destination().centerY());
        super.draw(canvas);
        canvas.restore();
    }

    public void SourceLocation(Point p) { this.SourceLocation(p.x, p.y, 64, 64); }

    public int IX() { return this.ix; }
    public int IY() { return this.iy; }

    public void Damage(int damage) { this.damage = damage; }
}

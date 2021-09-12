package com.ngdroidapp;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import com.ngdroidapp.Objects.NgObjectAnimatable;

public class Monster extends NgObjectAnimatable {
    private HealthBar hpbar;
    private boolean isEscaped, isDied, isSpawned;
    private int prize;
    private int TYPE;

    public Monster(NgApp ngApp, int dx, int dy, int type, int prize) {
        super(ngApp, Properties.SPRITESHEET, dx, dy, 96, 96, 0, 0, 0, 0);
        Destination(dx, dy, dx + (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * 96), dy + (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * 96), false);
        this.TYPE = type;
        HpBar(ngApp, Destination());
        this.isEscaped = false;
        this.isDied = false;
        this.prize = prize;
    }

    @Override
    public void update() {
        if(HpBar().CurrentHP() > 0) {
            hpbar.update(X(), Y() - 20);
            Destination(vx * ix ,vy * iy);
        } else{
            this.isSpawned = false;
            this.isDied = true;
        }
        if (ix == 1) {
            SourceLocation(Properties.SPRITE[TYPE][Properties.POSITION_E]);
        }
        else if (iy == 1) {
            SourceLocation(Properties.SPRITE[TYPE][Properties.POSITION_S]);
        }
        else if (ix == -1) {
            SourceLocation(Properties.SPRITE[TYPE][Properties.POSITION_W]);
        }
        else if (iy == -1) {
            SourceLocation(Properties.SPRITE[TYPE][Properties.POSITION_N]);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        if(!IsDied()) {
            super.draw(canvas);
            hpbar.draw(canvas);
        }
    }

    public void HpBar(NgApp ngApp, Rect destination) { this.hpbar = new HealthBar(ngApp, 100, destination.left, destination.top, destination.width()); }
    public HealthBar HpBar() { return hpbar; }
    public void IsEscaped(Rect b, Heart heart) {
        if (!IsEscaped() && intersects(b))  {
            heart.Down();
            this.isEscaped = true;
        }
    }
    public boolean IsEscaped() { return this.isEscaped; }

    public boolean IsSpawned() { return this.isSpawned; }
    public void Spawn() { this.isSpawned = true; }

    public boolean IsDied() { return this.isDied; }

    public int Prize() { return this.prize * -1; }

    public void SourceLocation(Point p) { this.SourceLocation(p.x, p.y, 32, 32); }

}

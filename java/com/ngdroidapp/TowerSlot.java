package com.ngdroidapp;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import com.ngdroidapp.Objects.NgObjectClickable;

import istanbul.gamelab.ngdroid.util.Log;


/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 29.06.2018.
 */

public class TowerSlot extends NgObjectClickable {
    private TowerOptions options;
    private TowerRange range;
    private int framenum, level;
    private String type;
    private int TYPE, TOWER_MAX_FRAMENUM;
    private TowerAmmo ammo;
    private Point point;
    Monster monster;
    private NgApp root;
    private long counter = System.currentTimeMillis();
    private double angleDeg = 0;

    // Constructor
    public TowerSlot(NgApp ngApp, int x, int y)    {
        super(ngApp, Properties.TOWERSHEET, x, y, 192, 192);
        Options(ngApp, Properties.TOWER_SLOT_ONCLICKPATH);
        Range(Destination());
        this.root = ngApp;
        this.level = 0;
        this.type = "-";
        this.framenum = 1;
        SourceLocation(Properties.TOWER_SLOT);
        point = new Point();
    }

    // X 62 Y 77

    public TowerOptions Options() { return this.options; }
    public void Options(NgApp ngApp, String path) { options = new TowerOptions(ngApp, path, Destination()); }

    public TowerRange Range() { return this.range; }
    public void Range(Rect destination) { this.range = new TowerRange(destination.centerX(), destination.centerY(), destination.width() * 2); }

    public void Type(String type) {
        switch (Integer.parseInt(type)) {
            case 0:
            case 2:
            case 3:
                TOWER_MAX_FRAMENUM = 2;
                break;
            case 1:
                TOWER_MAX_FRAMENUM = 1;
                break;
        }
        this.TYPE = Integer.parseInt(type);
        this.type = type;
    }
    public String  Type() { return this.type; }

    public void Level(int level) { this.level = level; }
    public int Level() {return this.level; }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.rotate((float)angleDeg, Destination().centerX(), Destination().centerY());
        super.draw(canvas);
        canvas.restore();
        if (IsClicked()) {
            range.draw(canvas);
        }
        if (!this.type.equals("-")) {
            if (Ammo() != null && Ammo().Released())
                Ammo().draw(canvas);
        }
    }

    public void update(Monster monster, int i) {
        if (!this.type.equals("-") && Ammo() != null) {
            angleDeg = Math.atan2(Destination().centerY() - point.y, Destination().centerX() - point.x) * 180 / Math.PI;
            if ((range.IsInvaded() || Ammo().Released()) && monster != null) {
                if (!Ammo().Released() && counter <= System.currentTimeMillis() - Properties.TOWER_ATTACK_SPEED[TYPE]) {
                    point.set(monster.Destination().centerX(), monster.Destination().centerY());
                    Ammo().Released(true, point);
                    counter = System.currentTimeMillis();
                } else if (Ammo().Released()) {
                    Ammo().update(monster, i, Range());
                    attack();
                }
            } else
                idle();
        }
    }

    private void attack()    {
        if (Ammo() != null && !Ammo().Released() && counter <= System.currentTimeMillis() - Properties.TOWER_ATTACK_SPEED[TYPE])
            framenum++;
        if (framenum > TOWER_MAX_FRAMENUM)
            framenum = 0;
    }

    private void idle()  {
        framenum = 0;
    }

    public TowerAmmo Ammo() { return this.ammo; }
    public void Ammo(int type) { this.ammo = new TowerAmmo(root, type, Destination()); }

    public void SourceLocation(Point p) { this.SourceLocation(p.x, p.y, 64, 64); }
}

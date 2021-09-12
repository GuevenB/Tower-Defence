package com.ngdroidapp;

import android.graphics.Rect;
import android.support.annotation.Nullable;

import istanbul.gamelab.ngdroid.util.Log;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 29.06.2018.
 */

enum Direction  {
    Right,
    Left,
    Up,
    Down;
}

public class Checkpoint {
    private Rect rectToCheck;
    private int ix, iy;
    private Direction direction;

    public Checkpoint(int x, int y, Direction direction, Checkpoint old) {
        this.direction = direction;
        switch (old.direction) {
            case Up:
                this.rectToCheck = new Rect((int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * x),
                        (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * y),
                        (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * (x + 200)),
                        (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * (y + 80)));
                break;
            case Down:
                this.rectToCheck = new Rect((int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * x),
                        (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * y),
                        (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * (x + 200)),
                        (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * (y + 80)));
                break;
            case Left:
                this.rectToCheck = new Rect((int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * x),
                        (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * y),
                        (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * (x + 100)),
                        (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * (y + 160)));
                break;
            case Right:
                this.rectToCheck = new Rect((int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * (x + 100)),
                    (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * y),
                    (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * (x + 200)),
                    (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * (y + 160)));
                break;
            default:
                break;
        }

        switch (direction)  {
            case Up:
                this.iy = -1;
                this.ix = 0;
                break;
            case Down:
                this.iy = 1;
                this.ix = 0;
                break;
            case Left:
                this.iy = 0;
                this.ix = -1;
                break;
            case Right:
                this.iy = 0;
                this.ix = 1;
                break;
        }
    }

    public Checkpoint(int x, int y, Direction direction, Direction old) {
        this.direction = direction;
        switch (old) {
            case Up:
                this.rectToCheck = new Rect((int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * (x)),
                        (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * y + 80),
                        (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * (x + 200)),
                        (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * (y + 80)));
                break;
            case Down:
                this.rectToCheck = new Rect((int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * x),
                        (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * y),
                        (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * (x + 200)),
                        (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * (y + 80)));
                break;
            case Left:
                this.rectToCheck = new Rect((int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * x),
                        (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * y),
                        (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * (x + 100)),
                        (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * (y + 160)));
                break;
            case Right:
                this.rectToCheck = new Rect((int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * (x + 100)),
                        (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * y),
                        (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * (x + 200)),
                        (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * (y + 160)));
                break;
        }

        switch (direction)  {
            case Up:
                this.iy = -1;
                this.ix = 0;
                break;
            case Down:
                this.iy = 1;
                this.ix = 0;
                break;
            case Left:
                this.iy = 0;
                this.ix = -1;
                break;
            case Right:
                this.iy = 0;
                this.ix = 1;
                break;
        }
    }

    public int Ix() { return this.ix; }
    public int Iy() { return this.iy; }
    public Rect RectToCheck() { return this.rectToCheck; }
}

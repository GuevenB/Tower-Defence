package com.ngdroidapp;

import com.ngdroidapp.Objects.NgObject;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 10.07.2018.
 */

public class WaveStart extends NgObject {
    private int ix;
    private int iy;
    public WaveStart(int dx, int dy, int ix, int iy)   {
        super(dx, dy, 192, 128);
        this.ix = ix;
        this.iy = iy;
    }

    public int IX() { return this.ix; }
    public int IY() { return this.iy; }
}
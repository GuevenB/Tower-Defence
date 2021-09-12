package com.ngdroidapp;

import android.graphics.Canvas;

import com.ngdroidapp.GUI.NgButton;
import com.ngdroidapp.Objects.NgObjectClickable;
import com.ngdroidapp.Objects.NgObjectDrawable;

import istanbul.gamelab.ngdroid.util.Log;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 10.07.2018.
 */

public class WaveEnd extends NgObjectClickable {
    private NgObjectDrawable onclick;

    private NgApp root;

    NgButton doomButton, freezeButton, slowButton, tankButton;

    public  int angle;

    public WaveEnd(NgApp ngApp, int dx, int dy, int angle)   {
        super(ngApp, "Castle.png", dx, dy, 201, 251);

        root = ngApp;

        String context = "Market/";

        if (angle != 0) {
            onclick = new NgObjectDrawable(ngApp, "CastleOnClick2.png", dx, dy - 200, 277, 150);
            doomButton = new NgButton(ngApp, context + "Doom.png", context + "DoomClicked.png", context + "DoomLocked.png", dx + 213, dy - 200 + 52, 64, 64);
            freezeButton = new NgButton(ngApp, context + "Freeze.png", context + "FreezeClicked.png", context + "FreezeLocked.png", dx + 155, dy - 200, 64, 64);
            slowButton = new NgButton(ngApp, context + "Slow.png", context + "SlowClicked.png", context + "SlowLocked.png", dx + 57, dy - 200, 64, 64);
            tankButton = new NgButton(ngApp, context + "Tank.png", context + "TankClicked.png", context + "TankLocked.png", dx, dy - 200 + 52, 64, 64);
        }
        else {
            onclick = new NgObjectDrawable(ngApp, "CastleOnClick.png", dx - 200, dy, 150, 277);
            doomButton = new NgButton(ngApp, context + "Doom.png", context + "DoomClicked.png", context + "DoomLocked.png", dx - 200 + 52, dy, 64, 64);
            freezeButton = new NgButton(ngApp, context + "Freeze.png", context + "FreezeClicked.png", context + "FreezeLocked.png",dx - 200, dy + 58, 64, 64);
            slowButton = new NgButton(ngApp, context + "Slow.png", context + "SlowClicked.png", context + "SlowLocked.png", dx - 200, dy + 156, 64, 64);
            tankButton = new NgButton(ngApp, context + "Tank.png", context + "TankClicked.png", context + "TankLocked.png",dx - 200 + 52, dy + 213, 64, 64);
        }
        this.angle = angle;
    }

    public void update() {

    }

    public void touchDown(int x, int y, int id) {
        if (IsClicked()) {
            doomButton.onHover(x, y);
            freezeButton.onHover(x, y);
            slowButton.onHover(x, y);
            tankButton.onHover(x, y);
        }
    }

    public void touchMove(int x, int y, int id) {
        if (IsClicked()) {
            doomButton.onHover(x, y);
            freezeButton.onHover(x, y);
            slowButton.onHover(x, y);
            tankButton.onHover(x, y);
        }
    }

    public boolean touchUp(int x, int y, int id) {
        if (IsClicked()) {
            if(doomButton.IsClicked(x, y)) {
                Log.e("assd", "doom");
                return true;
            }
            else if(freezeButton.IsClicked(x, y)) {
                Log.e("assd", "freeze");
                return true;
            }
            else if(slowButton.IsClicked(x, y)) {
                Log.e("assd", "slow");
                return true;
            }
            else if(tankButton.IsClicked(x, y)) {
                Log.e("assd", "tank");
                return true;
            }
        }
        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        if (angle != 0) {
            canvas.save();
            canvas.rotate(angle, Destination().centerX(), Destination().centerY());
            super.draw(canvas);
            canvas.restore();
            if (IsClicked()) {
                onclick.draw(canvas);
                doomButton.draw(canvas, root.doom);
                slowButton.draw(canvas, root.slow);
                freezeButton.draw(canvas, root.freeze);
                tankButton.draw(canvas, root.tank);
            }

        }
        else {
            super.draw(canvas);
            if(IsClicked()) {
                onclick.draw(canvas);
                doomButton.draw(canvas);
                slowButton.draw(canvas);
                freezeButton.draw(canvas);
                tankButton.draw(canvas);
            }
        }
    }

    public boolean Tank() { return tankButton.IsClicked(); }
    public boolean Freeze() { return freezeButton.IsClicked(); }
    public boolean Slow() { return slowButton.IsClicked(); }
    public boolean Doom() { return doomButton.IsClicked(); }

    public void Release() {
        doomButton.IsClicked(-1, -1);
        freezeButton.IsClicked(-1, -1);
        slowButton.IsClicked(-1, -1);
        tankButton.IsClicked(-1, -1);
    }
}
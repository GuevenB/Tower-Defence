package com.ngdroidapp;

import android.graphics.Canvas;

import com.ngdroidapp.GUI.NgBackground;
import com.ngdroidapp.GUI.NgButton;
import com.ngdroidapp.Objects.NgObjectDrawable;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.util.Log;

/**
 * Created by noyan on 27.06.2016.
 * Nitra Games Ltd.
 */

public class MarketCanvas extends BaseCanvas {

    private NgButton doomButton;
    private NgButton slowButton;
    private NgButton freezeButton;
    private NgButton heartButton;
    private NgButton tankButton;
    private NgButton yesButton;
    private NgButton noButton;
    private NgButton exitButton;
    private NgBackground menu;
    private NgObjectDrawable doomText;
    private NgObjectDrawable slowText;
    private NgObjectDrawable freezeText;
    private NgObjectDrawable heartText;
    private NgObjectDrawable tankText;
    private NgBackground background;
    private boolean backpress, doom, freeze, slow, heart, tank;

    public MarketCanvas(NgApp ngApp) {
        super(ngApp);
    }

    public void setup() {
        String context = "Market/";
        doomButton = new NgButton(root, context + "Doom.png", context + "DoomClicked.png", 323, 728, 105, 112);
        exitButton = new NgButton(root, context + "Exit.png", context + "ExitClicked.png", 1659, 81, 105, 112);
        slowButton = new NgButton(root, context + "Slow.png", context + "SlowClicked.png", 323, 477, 105, 112);
        freezeButton = new NgButton(root, context + "Freeze.png",context + "FreezeClicked.png", 323, 603, 105, 112);
        heartButton = new NgButton(root, context + "Heart.png",context + "HeartClicked.png", 323, 351, 105, 112);
        tankButton = new NgButton(root, context + "Tank.png",context + "TankClicked.png", 323, 219, 105, 112);
        yesButton = new NgButton(root, context + "Yes.png", context + "YesClicked.png", 498 , 876, 363, 178);
        noButton = new NgButton(root, context + "No.png", context + "NoClicked.png", 989, 876, 363, 178);
        menu = new NgBackground(root, context + "Menu.png");
        doomText = new NgObjectDrawable(root, context + "DoomText.png", 687, 384, 550, 190);
        slowText = new NgObjectDrawable(root, context + "SlowText.png", 687, 384, 550, 190);
        freezeText = new NgObjectDrawable(root, context + "FreezeText.png", 687, 384, 550, 190);
        heartText = new NgObjectDrawable(root, context + "HeartText.png", 687, 384, 550, 190);
        tankText = new NgObjectDrawable(root, context + "TankText.png", 687, 384, 550, 190);
        background = new NgBackground(root, context + "Background.png");
    }

    public void update() {
        if (doomButton.IsClicked()) {
            doom = true;
        }
        else if(freezeButton.IsClicked()) {
            freeze = true;
        }
        else if(slowButton.IsClicked()) {
            slow = true;
        }
        else if(tankButton.IsClicked()) {
            tank = true;
        }
        else if(heartButton.IsClicked()) {
            heart = true;
        }
        else if (yesButton.IsClicked()) {
            if (doom) {
                if(root.coin.Down(3000)) {
                    root.doom = true;
                }
            }
            else if(freeze) {
                if(root.coin.Down(1250)) {
                    root.freeze = true;
                }
            }
            else if(slow) {
                if(root.coin.Down(850)) {
                    root.slow = true;
                }
            }
            else if(tank) {
                if(root.coin.Down(500)) {
                    root.tank = true;
                }
            }
            else if(heart) {
                if(root.coin.Down(600)) {
                    root.heart.Life(root.heart.Life() + 5);
                }
            }
            doom = false;
            freeze = false;
            slow = false;
            heart = false;
            tank = false;
            yesButton.onHover();
            yesButton.onReleased();
        }
        else if (noButton.IsClicked()) {
            noButton.onHover();
            noButton.onReleased();
            doom = false;
            freeze = false;
            slow = false;
            heart = false;
            tank = false;
        }
        else if (exitButton.IsClicked()) {
            root.canvasManager.setCurrentCanvas(root.menu);
        }
    }

    public void draw(Canvas canvas) {
        background.draw(canvas);
        doomButton.draw(canvas);
        slowButton.draw(canvas);
        freezeButton.draw(canvas);
        heartButton.draw(canvas);
        tankButton.draw(canvas);
        exitButton.draw(canvas);
        if (doom) {
            menu.draw(canvas);
            yesButton.draw(canvas);
            noButton.draw(canvas);
            doomText.draw(canvas);
        }
        else if (freeze) {
            menu.draw(canvas);
            yesButton.draw(canvas);
            noButton.draw(canvas);
            freezeText.draw(canvas);
        }
        else if (slow) {
            menu.draw(canvas);
            yesButton.draw(canvas);
            noButton.draw(canvas);
            slowText.draw(canvas);
        }
        else if (tank) {
            menu.draw(canvas);
            yesButton.draw(canvas);
            noButton.draw(canvas);
            tankText.draw(canvas);
        }
        else if (heart) {
            menu.draw(canvas);
            yesButton.draw(canvas);
            noButton.draw(canvas);
            heartText.draw(canvas);
        }
    }

    public void keyPressed(int key) {
    }

    public void keyReleased(int key) {
    }

    public boolean backPressed() {
        return false;
    }

    public void touchDown(int x, int y, int id) {
        doomButton.onHover(x,y);
        slowButton.onHover(x,y);
        freezeButton.onHover(x,y);
        heartButton.onHover(x,y);
        tankButton.onHover(x,y);
        exitButton.onHover(x,y);
        if (doom || freeze || slow || tank || heart) {
            yesButton.onHover(x,y);
            noButton.onHover(x,y);
        }
    }

    public void touchMove(int x, int y, int id) {
        doomButton.onHover(x,y);
        slowButton.onHover(x,y);
        freezeButton.onHover(x,y);
        heartButton.onHover(x,y);
        tankButton.onHover(x,y);
        exitButton.onHover(x,y);
        if (doom || freeze || slow || tank || heart) {
            yesButton.onHover(x,y);
            noButton.onHover(x,y);
        }
    }

    public void touchUp(int x, int y, int id) {
        doomButton.IsClicked(x,y);
        slowButton.IsClicked(x,y);
        freezeButton.IsClicked(x,y);
        heartButton.IsClicked(x,y);
        tankButton.IsClicked(x,y);
        exitButton.IsClicked(x,y);
        if (doom || freeze || slow || tank || heart) {
            yesButton.IsClicked(x,y);
            noButton.IsClicked(x,y);
        }
    }

    public void surfaceChanged(int width, int height) {
    }

    public void surfaceCreated() {
    }

    public void surfaceDestroyed() {
    }

    public void pause() {
    }

    public void resume() {
    }

    public void reloadTextures() {
    }

    public void showNotify() {
    }

    public void hideNotify() {
    }
}

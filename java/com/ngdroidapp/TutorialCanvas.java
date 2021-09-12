package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.ngdroidapp.GUI.NgBackground;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.util.Utils;

/**
 * Created by Bahadir Yalin & Emrullah Sahin & Guven Boz & Yunus Derici on 20.07.2018
 */

public class TutorialCanvas extends BaseCanvas {
    private NgBackground[] tutorial;
    private int counter = 0;

    public TutorialCanvas(NgApp ngApp) {
        super(ngApp);
    }

    @Override
    public void setup() {
        tutorial = new NgBackground[4];
        String context = "HowToPlay/";
        for (int i = 0; i < 4; i++) {
            tutorial[i] = new NgBackground(root, context + i + ".png");
        }
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Canvas canvas) {
        tutorial[counter].draw(canvas);
    }

    @Override
    public void keyPressed(int key) {
    }

    @Override
    public void keyReleased(int key) {
    }

    @Override
    public boolean backPressed() {
        root.canvasManager.setCurrentCanvas(new MenuCanvas(root));
        return true;
    }

    @Override
    public void touchDown(int x, int y, int id) {
    }

    @Override
    public void touchMove(int x, int y, int id) {
    }

    @Override
    public void touchUp(int x, int y, int id) {
        counter++;
        if (counter > 3) {
            root.canvasManager.setCurrentCanvas(new MenuCanvas(root));
        }
    }

    @Override
    public void surfaceChanged(int width, int height) {
    }

    @Override
    public void surfaceCreated() {
    }

    @Override
    public void surfaceDestroyed() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void reloadTextures() {
    }

    @Override
    public void showNotify() {
    }

    @Override
    public void hideNotify() {
    }
}

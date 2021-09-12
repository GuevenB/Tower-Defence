package com.ngdroidapp;

import android.graphics.Canvas;

import com.ngdroidapp.GUI.NgBackground;
import com.ngdroidapp.Objects.NgObjectDrawable;

import istanbul.gamelab.ngdroid.base.BaseCanvas;

/**
 * Created by Bahadir Yalin & Emrullah Sahin & Guven Boz & Yunus Derici on 20.07.2018
 */

public class LoadingCanvas extends BaseCanvas {
    private NgObjectDrawable[] animation;
    private NgBackground background;
    private int framenum = 0;
    public GameCanvas gc;

    public LoadingCanvas(NgApp ngApp) {
        super(ngApp);
    }

    @Override
    public void setup() {
        animation = new NgObjectDrawable[24];
        String context = "LoadScreen/";
        background = new NgBackground(root, context + "Background.png");
        for (int i = 0; i < 24; i++) {
            animation[i] = new NgObjectDrawable(root, context + (i + 1) + ".png", 366, 334, 1191, 414);
        }
        gc = new GameCanvas(root);
    }

    @Override
    public void update() {
        framenum++;
        if (gc.Loaded() && framenum == 72) {
            root.canvasManager.setCurrentCanvas(gc);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        background.draw(canvas);
        animation[framenum % 24].draw(canvas);
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

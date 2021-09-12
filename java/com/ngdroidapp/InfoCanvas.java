package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.util.Utils;

/**
 * Created by Bahadir Yalin & Emrullah Sahin & Guven Boz & Yunus Derici on 20.07.2018
 */

public class InfoCanvas extends BaseCanvas {
    private Bitmap arkaplan;
    private Rect arkaplankaynak, arkaplanhedef;
    private String hakkinda[];
    private Paint font;
    private int konum, kaymahizi, satiraraligi, satirsayisi;


    public InfoCanvas(NgApp ngApp) {
        super(ngApp);

    }

    @Override
    public void setup() {
        arkaplan = Utils.loadImage(root, "Credits.png");
        arkaplankaynak = new Rect(0, 0, arkaplan.getWidth(), arkaplan.getHeight());
        arkaplanhedef = new Rect(0, 0, getWidth(), getHeight());
        satirsayisi = 30;
        font = new Paint();
        font.setTextSize((50));
        font.setTextAlign(Paint.Align.CENTER);
        font.setARGB(255, 255, 255, 255);
        hakkinda = new String[satirsayisi];
        hakkinda[0] = "PROGRAMMERS(In Alphabetic Order)";
        hakkinda[1] = "";
        hakkinda[2] = "Bahadir Yalin";
        hakkinda[3] = "Emrullah Sahin";
        hakkinda[4] = "Guven Boz";
        hakkinda[5] = "Yunus Derici";
        hakkinda[6] = "";
        hakkinda[7] = "LEAD PROGRAMMER";
        hakkinda[8] = "";
        hakkinda[9] = "Emrullah Sahin";
        hakkinda[10] = "";
        hakkinda[11] = "SOUND FX";
        hakkinda[12] = "";
        hakkinda[13] = "Bahadir Yalin";
        hakkinda[14] = "Yunus Derici";
        hakkinda[15] = "";
        hakkinda[16] = "GAME DESIGNER";
        hakkinda[17] = "";
        hakkinda[18] = "Bahadir Yalin";
        hakkinda[19] = "Guven Boz";
        hakkinda[20] = "Yunus Derici";
        hakkinda[21] = "INSTRUCTORS";
        hakkinda[22] = "";
        hakkinda[23] = "Ali Melik Ersoy";
        hakkinda[24] = "Mukaddes Demirtaş";
        hakkinda[25] = "Songül Atam";
        hakkinda[26] = "";
        hakkinda[27] = "ALL RIGHTS RESERVED";
        hakkinda[28] = "";
        hakkinda[29] = "Gamelab Istanbul \u00A9 2018";
        konum = getHeight() + (100);
        kaymahizi = (10);
        satiraraligi = (70);



    }

    @Override
    public void update() {
        konum -= kaymahizi;
        if (konum <= - satirsayisi * satiraraligi + (150)) {
            konum = getHeight() + (150);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(arkaplan, arkaplankaynak, arkaplanhedef, null);
        for (int i = 0; i < satirsayisi; i++){
            canvas.drawText(hakkinda[i], getWidthHalf(), konum + i * satiraraligi, font);
        }
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

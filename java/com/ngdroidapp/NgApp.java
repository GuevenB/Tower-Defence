package com.ngdroidapp;

import android.graphics.Canvas;

import istanbul.gamelab.ngdroid.base.BaseActivity;
import istanbul.gamelab.ngdroid.core.AppManager;
import istanbul.gamelab.ngdroid.base.BaseApp;
import istanbul.gamelab.ngdroid.core.NgMediaPlayer;
import istanbul.gamelab.ngdroid.util.Log;

import com.ngdroidaddons.ngaencryptedpreferences.NgaEncryptedPreferences;
import com.nitragames.evilrush.R;

/**
 * Created by noyan on 24.06.2016.
 * Nitra Games Ltd.
 */

public class NgApp extends BaseApp {

    public NgaEncryptedPreferences log;

    private boolean first = true;

    public Boolean freeze = false, doom = false, tank = false, slow = false, life = false;

    public static int SCREEN_WIDTH;

    public static int SCREEN_HEIGHT;

    public Heart heart = new Heart(this);

    public Coin coin = new Coin(this);

    public int stage = 1, score = 0;

    public boolean effect = true, music = true;

    public NgMediaPlayer musicPlayer, effectPlayer;

    public NgMediaPlayer bgmusic, WLmusic;

    public LoadingCanvas lc;

    public MenuCanvas menu;

    public NgApp(BaseActivity nitraBaseActivity, AppManager appManager) {
        super(nitraBaseActivity, appManager);
    }

    public void setup() {
        appManager.setUnitResolution(AppManager.RESOLUTION_QHD);
        appManager.setFrameRateTarget(24);
        log = new NgaEncryptedPreferences(this);
        log.initialize("1234");
        musicPlayer = new NgMediaPlayer(this);
        musicPlayer.load(R.raw.mainmenu);
        musicPlayer.setLooping(true);
        effectPlayer = new NgMediaPlayer(this);
        effectPlayer.load(R.raw.mainmenu);

        effectPlayer = new NgMediaPlayer(this);
        SCREEN_WIDTH = getWidth();
        SCREEN_HEIGHT = getHeight();
        if (log.getBoolean("First", first)) {
            Log.e("assd", "First!");
            saveGameState();
            saveSoundPrefences();
            log.putBoolean("First", !first);
        }
        else {
            Log.e("assd", "Second!");
            getGameState();
            getSoundPreferences();
        }

        bgmusic = new NgMediaPlayer(this);
        WLmusic = new NgMediaPlayer(this);

        menu = new MenuCanvas(this);
        canvasManager.setCurrentCanvas(menu);
    }

    public void saveSoundPrefences() {
        log.putBoolean("Music", music);
        log.putBoolean("Effect", effect);
    }

    public void saveGameState() {
        log.putLong("Coin", coin.Currency());
        log.putLong("Heart", (long)heart.Life());
        log.putLong("Stage", (long)stage);
        log.putBoolean("Doom", doom);
        log.putBoolean("Tank", tank);
        log.putBoolean("Slow", slow);
        log.putBoolean("Freeze", freeze);
        log.putLong("Score", (long)score);
    }

    public void getGameState() {
        coin.Currency(log.getLong("Coin", (long)0));
        heart.Life(log.getLong("Heart", (long)0));
        stage = (int)(long)(log.getLong("Stage", (long)0));
        doom = log.getBoolean("Doom", doom);
        tank =log.getBoolean("Tank", tank);
        slow = log.getBoolean("Slow", slow);
        freeze = log.getBoolean("Freeze", freeze);
        score = (int)(long)log.getLong("Score", (long)score);
    }

    public void getSoundPreferences() {
        music = log.getBoolean("Music", music);
        effect = log.getBoolean("Effect", effect);
    }

    public void update() {

    }

    public void draw(Canvas canvas) {

    }

    public void keyPressed(int key) {

    }

    public void keyReleased(int key) {

    }

    public boolean backPressed() {
        return true;
    }

    public void touchDown(int x, int y, int id) {

    }

    public void touchMove(int x, int y, int id) {

    }

    public void touchUp(int x, int y, int id) {

    }

    public void surfaceChanged(int width, int height) {

    }

    public void surfaceCreated() {

    }

    public void surfaceDestroyed() {
        saveSoundPrefences();
        saveGameState();
    }

    public void pause() {
        Log.i("NGAPP", "pause");
    }

    public void resume() {
        Log.i("NGAPP", "resume");
    }

    public void reloadTextures() {
        Log.i("NGAPP", "reloadTextures");
    }
}

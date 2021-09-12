package com.ngdroidapp;

import android.graphics.Canvas;

import com.nitragames.evilrush.R;
import com.ngdroidapp.GUI.NgBackground;
import com.ngdroidapp.GUI.NgButton;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.core.NgMediaPlayer;

/**
 * Created by noyan on 27.06.2016.
 * Nitra Games Ltd.
 */

public class MenuCanvas extends BaseCanvas {

    private NgButton playButton;
    private NgButton howToPlayButton;
    private NgButton creditsButton;
    private NgButton musicButton;
    private NgButton effectButton;
    private NgButton marketButton;
    private NgBackground background;
    private String context;

    private float musicVolume = 1, effectVolume = 1;
    public MenuCanvas(NgApp ngApp) {
        super(ngApp);
    }

    public void setup() {
        this.context = "GUI/";
        playButton = new NgButton(root, context + "Play.png", context + "PlayClicked.png", 1317, 480, 363, 178);
        howToPlayButton = new NgButton(root, context + "HowToPlay.png", context + "HowToPlayClicked.png", 1317, 680, 363, 178);
        marketButton = new NgButton(root, context + "Market.png", context + "MarketClicked.png", 1317, 880, 363, 178);
        creditsButton = new NgButton(root, context + "Credits.png",context + "CreditsHover.png", 366, 0, 151, 151);
        musicButton = new NgButton(root, context + "MusicOn.png",context + "MusicHover.png", context + "MusicOff.png", 40, 0, 151, 151);
        effectButton = new NgButton(root, context + "EffectOn.png",context + "EffectHover.png", context + "EffectOff.png", 203, 0, 151, 151);
        background = new NgBackground(root, context + "background.png");
    }

    public void update() {
        if (playButton.IsClicked()) {
            root.musicPlayer.stop();
            root.lc = new LoadingCanvas(root);
            root.canvasManager.setCurrentCanvas(root.lc);
        }
        else if(howToPlayButton.IsClicked()) {
            root.canvasManager.setCurrentCanvas(new TutorialCanvas(root));
        }
        else if(marketButton.IsClicked()) {
            root.canvasManager.setCurrentCanvas(new MarketCanvas(root));
        }
        if (!root.musicPlayer.isPlaying())   {
            root.musicPlayer.start();
        }
        if (musicButton.IsClicked())    {
            if (musicVolume == 0)
                musicVolume = 1;
            else
                musicVolume = 0;
            root.music = !root.music;
            root.musicPlayer.setVolume(musicVolume);
            musicButton.onHover();
            musicButton.IsClicked(-1, -1);
        }
        if (effectButton.IsClicked())    {
            if (effectVolume == 0)
                effectVolume = 1;
            else
                effectVolume = 0;
            root.effect = !root.effect;
            root.effectPlayer.setVolume(effectVolume);
            effectButton.onHover();
            effectButton.IsClicked(-1, -1);
        }
        if(creditsButton.IsClicked()) {
            InfoCanvas ic = new InfoCanvas(root);
            root.canvasManager.setCurrentCanvas(ic);
        }
    }

    public void draw(Canvas canvas) {
        background.draw(canvas);
        playButton.draw(canvas);
        howToPlayButton.draw(canvas);
        marketButton.draw(canvas);
        musicButton.draw(canvas, !root.music);
        effectButton.draw(canvas, !root.effect);
        creditsButton.draw(canvas);
    }

    public void keyPressed(int key) {
    }

    public void keyReleased(int key) {
    }

    public boolean backPressed() { return false; }

    public void touchDown(int x, int y, int id) {
        playButton.onHover(x,y);
        musicButton.onHover(x,y);
        effectButton.onHover(x,y);
        howToPlayButton.onHover(x,y);
        marketButton.onHover(x,y);
        creditsButton.onHover(x,y);
    }

    public void touchMove(int x, int y, int id) {
        playButton.onHover(x,y);
        howToPlayButton.onHover(x,y);
        musicButton.onHover(x,y);
        effectButton.onHover(x,y);
        marketButton.onHover(x,y);
        creditsButton.onHover(x,y);
    }

    public void touchUp(int x, int y, int id) {
        playButton.IsClicked(x, y);
        howToPlayButton.IsClicked(x,y);
        musicButton.IsClicked(x, y);
        effectButton.IsClicked(x, y);
        marketButton.IsClicked(x, y);
        creditsButton.IsClicked(x, y);
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

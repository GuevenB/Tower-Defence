package com.ngdroidapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.ngdroidapp.GUI.NgBackground;
import com.ngdroidapp.GUI.NgButton;
import com.ngdroidapp.Objects.NgObjectDrawable;
import com.nitragames.evilrush.R;

import java.util.Random;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.util.Log;

/**
 * Created by noyan on 24.06.2016.
 * Nitra Games Ltd.
 */

public class GameCanvas extends BaseCanvas {

    private int lastTower, score = 0, stage = 1;

    private Map map;

    private Heart heart;

    private Coin coin;

    private boolean paused = false, youwon = false, youlose = false, loaded = false;

    private NgButton resumeButton, restartButton, exitButton, homeButton, nextButton, shopButton;

    private NgBackground menu, menu2;

    private NgObjectDrawable star1, star2, bigstar;

    private Paint paint = new Paint();

    private Random rand = new Random();

    private int RAW[];

    private boolean tf = true, slow = false;

    private int result_star, mapStartLife = 20;

    private int currentStage;

    private long freezeTime, slowTime;

    private boolean tank = false;

    public GameCanvas(NgApp ngApp) {
        super(ngApp);
        RAW = new int[4];
        RAW[0] = R.raw.bg0;
        RAW[1] = R.raw.bg1;
        RAW[2] = R.raw.bg2;
        RAW[3] = R.raw.bg3;
        String context = "Pause/";
        int buttonWidth = 363;
        int buttonHeight = 178;
        int buttonX = 770;
        resumeButton = new NgButton(root, context + "resume.png", context + "resume_onclick.png", buttonX, 224, buttonWidth, buttonHeight);
        restartButton = new NgButton(root, context + "restart.png", context + "restart_onclick.png", buttonX, 451, buttonWidth, buttonHeight);
        exitButton = new NgButton(root, context + "exit.png", context + "exit_onclick.png", buttonX, 678, buttonWidth, buttonHeight);
        menu = new NgBackground(root, context + "menu.png");
        menu2 = new NgBackground(root, "End_Game/Menu.png");

        homeButton = new NgButton(root, "End_Game/Home.png", "End_Game/Home_onclick.png", 730, 930, 136, 136);
        nextButton = new NgButton(root, "End_Game/Play.png", "End_Game/Play_onclick.png", "End_Game/Play_locked.png", 1050, 930, 136, 136);
        shopButton = new NgButton(root, "End_Game/Shop.png", "End_Game/Shop_onclick.png", 890, 930, 136, 136);
        star1 = new NgObjectDrawable(root, "End_Game/Star.png", 702, 472, 185, 162);
        star2 = new NgObjectDrawable(root, "End_Game/Star.png", 1032, 472, 185, 162);
        bigstar = new NgObjectDrawable(root, "End_Game/Big_Star.png", 856, 414, 207, 190);

        paint.setColor(Properties.COLOR_GRAY);
        paint.setTypeface(Typeface.createFromAsset(root.activity.getAssets(), Properties.END_GAME_FONT));
        paint.setTextSize((int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * Properties.END_GAME_FONT_SIZE));

        heart = new Heart(root.heart, root);
        coin = new Coin(root.coin, root);

        if (stage > 14) {
            currentStage = rand.nextInt(14) + 1;
            map = new Map(root, "map" + currentStage + ".png");
        }
        else
            map = new Map(root, "map" + root.stage + ".png");

        root.bgmusic.load(RAW[rand.nextInt(4)]);
        root.bgmusic.prepareAsync();
        root.WLmusic.load(R.raw.waveend);
        root.WLmusic.setLooping(false);

        lastTower = -1;
        loaded = true;
    }

    public void setup() {
    }

    public void update() {
        if (paused) {
            root.bgmusic.pause();
            map.Wave().timer.pause();
            if (resumeButton.IsClicked()) {
                resumeButton.IsClicked(-1, -1);
                resumeButton.onHover();
                paused = false;
                root.bgmusic.prepareAsync();
                root.bgmusic.start();
                map.Wave().timer.resume();
            }
            else if (restartButton.IsClicked()) {
                if (stage > 14) {
                    map = new Map(root, "map" + currentStage + ".png");
                }
                else
                    map = new Map(root, "map" + root.stage + ".png");
                root.bgmusic.reset();
                root.bgmusic.load(RAW[rand.nextInt(4)]);
                root.bgmusic.prepareAsync();
                root.bgmusic.start();
                paused = false;
                restartButton.onReleased();
            }
            else if (exitButton.IsClicked()) {
                MenuCanvas mc = new MenuCanvas(root);
                root.canvasManager.setCurrentCanvas(mc);
            }
        }
        else if (youwon || youlose) {
            if(youlose) {
                root.stage = 0;
            }
            root.bgmusic.stop();
            if (homeButton.IsClicked()) {
                MenuCanvas mc = new MenuCanvas(root);
                root.canvasManager.setCurrentCanvas(mc);
                root.stage++;
                root.saveGameState();
            }
            else if (shopButton.IsClicked()) {
                shopButton.onReleased();
                shopButton.onHover();
                root.canvasManager.setCurrentCanvas(new MarketCanvas(root));
            }
            else if (nextButton.IsClicked()) {
                lastTower = -1;
                root.stage++;
                root.saveGameState();
                root.bgmusic.reset();
                tf = true;
                root.bgmusic.load(RAW[rand.nextInt(4)]);
                root.bgmusic.start();
                if (coin.Currency() < 500) {
                    coin.Currency(500);
                }
                if (root.stage > 14) {
                    map = new Map(root, "map" + (rand.nextInt(14) + 1) + ".png");
                }
                else
                    map = new Map(root, "map" + root.stage + ".png");
                youwon = false;
                nextButton.onReleased();
            }
        }
        else {
            if (!root.bgmusic.isPlaying())
                root.bgmusic.start();
            map.Wave().timer.update();
            if (map.Wave().WaveEnd().Freeze()) {
                freezeTime = System.currentTimeMillis();
                root.freeze = false;
            }
            if (map.Wave().WaveEnd().Slow()) {
                slowTime = System.currentTimeMillis();
                root.slow = false;
            }
            if (map.Wave().WaveEnd().Tank()) {
                tank = true;
            }
            for (int i = 0; i < map.Monsters().size(); i++) {
                if (map.Monster(i).IsSpawned()) {
                    for (int j = 0; j < map.Checkpoints().size(); j++) {
                        if (map.Monster(i).intersects(map.Checkpoint(j).RectToCheck())) {
                            map.Monster(i).ix = map.Checkpoint(j).Ix();
                            map.Monster(i).iy = map.Checkpoint(j).Iy();
                        }
                    }
                    if (slowTime > System.currentTimeMillis() - 5000) {
                        if (map.Monster(i).vx == 4) {
                            map.Monster(i).vx = map.Monster(i).vx / 2;
                            map.Monster(i).vy = map.Monster(i).vy / 2;
                        }
                    }
                    if (freezeTime > System.currentTimeMillis() - 7000) {
                        map.Monster(i).vx = 0;
                        map.Monster(i).vy = 0;
                    }
                    if (!(freezeTime > System.currentTimeMillis() - 7000) && !(slowTime > System.currentTimeMillis() - 5000)) {
                        map.Monster(i).vx = 4;
                        map.Monster(i).vy = 4;
                    }
                    if (map.Wave().WaveEnd().Doom() && map.Monster(i).IsSpawned()) {
                        map.Monster(i).HpBar().update(map.Monster(i).HpBar().CurrentHP() + 1);
                        Log.e("assd", i + " " + map.Monsters().size());
                    }
                        map.Monster(i).update();
                    if (map.tank.intersects(map.Monster(i).Destination()) && tank) {
                        map.Monster(i).HpBar().update(map.Monster(i).HpBar().CurrentHP() + 1);
                        tank = false;
                    }
                }

                if (map.Monster(i).IsSpawned())
                    map.Monster(i).IsEscaped(map.Wave().WaveEnd().Destination(), heart);
                for (int j = 0; j < map.Slots().size(); j++) {
                    if(map.Monster(i).IsSpawned() && map.Slot(j).Range().intersects(map.Monster(i).Destination())) {
                        map.Slot(j).monster = map.Monster(i);
                    }
                    map.Slot(j).update(map.Monster(i), i);
                }
                if (tank && map.tank.Range().intersects(map.Monster(i).Destination()) && map.tank.attackStart < System.currentTimeMillis() - 1000) {
                    map.tank.Released(true);
                    if(i == 0) {
                        map.tank.setPoint(map.Monster(i).Destination().centerX(), map.Monster(i).Destination().centerY());
                    }

                }
                map.tank.update();
                if (map.tank.Ammo().intersects(map.Monster(i).Destination()) && map.tank.Released()) {
                    map.tank.Released(false);
                    map.Monster(i).HpBar().update(40);
                }
                if (map.Monster(i).IsDied() || map.Monster(i).IsEscaped()) {
                    if (map.Monster(i).IsDied() || map.Wave().WaveEnd().Doom()) {
                        coin.Down(map.Monster(i).Prize());
                        score += 50 + rand.nextInt(50);
                    }
                    else if (map.Monster(i).IsEscaped())
                        result_star++;

                    map.Monsters().remove(i);

                    if (map.Monsters().size() == 1 && map.Wave().WaveEnd().Doom() && map.Monster(0).IsSpawned()) {
                        map.Monsters().remove(0);
                    }

                    if (i != 0)
                        i--;
                }
                if (heart.Life() <= 0) {
                    youlose = true;
                    root.WLmusic.reset();
                    root.WLmusic.load(R.raw.youlost);
                    if(tf)
                        root.WLmusic.start();
                    tf = false;
                }

                if (map.Monsters().isEmpty() && map.Wave().CURRENT_WAVE == map.Wave().WAVE) {
                    youwon = true;
                    root.WLmusic.reset();
                    root.WLmusic.load(R.raw.waveend);
                    if(tf)
                        root.WLmusic.start();
                    tf = false;
                }

            }
            for (int i = 0; i < map.Slots().size(); i++) {
                map.Slot(i).update(null, -1);
            }
            map.Wave().WaveEnd().Release();
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        if (paused) {
            menu.draw(canvas);
            resumeButton.draw(canvas);
            restartButton.draw(canvas);
            exitButton.draw(canvas);
        }
        else if (youwon || youlose) {
            menu2.draw(canvas);
            homeButton.draw(canvas);
            nextButton.draw(canvas, youlose);
            shopButton.draw(canvas);
            star1.draw(canvas);
            if (result_star < 3) {

                bigstar.draw(canvas);
            }
            if (heart.Life() >= mapStartLife) {
                star2.draw(canvas);
            }
            canvas.drawText(root.score + "", Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * 960, Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * 735, paint);
            canvas.drawText(root.stage + "", Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * 960, Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * 845, paint);
        }
        else {
            map.draw(canvas);
            for (int i = 0; i < map.Monsters().size(); i++) {
                if (!map.Monster(i).IsEscaped() && map.Monster(i).IsSpawned())
                    map.Monster(i).draw(canvas);
            }
            for (int i = 0; i < map.Slots().size(); i++) {
                map.Slot(i).draw(canvas);
                if (map.Slot(i).IsClicked()) {
                    map.Slot(i).Options().draw(canvas);
                }
            }
            if (tank) {
                map.tank.draw(canvas);
            }
            heart.draw(canvas);
            coin.draw(canvas);
            map.Wave().WaveEnd().draw(canvas);
            canvas.drawText("Wave : " + map.Wave().CURRENT_WAVE + "/" + map.Wave().WAVE, (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * 100),(int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * 100), paint);
        }
    }


    public void keyPressed(int key) {

    }

    public void keyReleased(int key) {

    }

    public boolean backPressed() {
        paused = !paused;
        return true;
    }

    public void surfaceChanged(int width, int height) {

    }

    public void surfaceCreated() {

    }

    public void surfaceDestroyed() {

    }

    public void touchDown(int x, int y, int id) {
        if (paused) {
            resumeButton.onHover(x, y);
            restartButton.onHover(x, y);
            exitButton.onHover(x, y);
        }
        else if (youwon || youlose) {
            homeButton.onHover(x, y);
            shopButton.onHover(x, y);
            if (!youlose)
                nextButton.onHover(x, y);
        }
    }

    public void touchMove(int x, int y, int id) {
        if (paused) {
            resumeButton.onHover(x, y);
            restartButton.onHover(x, y);
            exitButton.onHover(x, y);
        }
        else if (youwon || youlose) {
            homeButton.onHover(x, y);
            shopButton.onHover(x, y);
            if (!youlose)
                nextButton.onHover(x, y);
        }
        else
            map.Wave().WaveEnd().touchMove(x, y, id);
    }

    public void touchUp(int x, int y, int id) {
        if (paused) {
            resumeButton.IsClicked(x, y);
            restartButton.IsClicked(x, y);
            exitButton.IsClicked(x, y);
        }
        else if (youwon || youlose) {
            homeButton.IsClicked(x, y);
            shopButton.IsClicked(x, y);
            if (!youlose)
                nextButton.IsClicked(x, y);
        }
        else {
            if (map.Wave().WaveEnd().touchUp(x, y, id)) {

            }
            else if (lastTower != -1 && map.Slot(lastTower).IsClicked()) {
                for (int j = 0; j < 4; j++) {
                    if (map.Slot(lastTower).Options().option[j].IsClicked(x, y, root, map.Slot(lastTower), coin)) {
                        map.Slot(lastTower).onReleased();
                    }
                }
                map.Slot(lastTower).onReleased();
            } else {
                for (int i = 0; i < map.Slots().size(); i++) {
                    if (map.Slot(i).IsClicked(x, y)) {
                        if (lastTower != -1 && lastTower != i)
                            map.Slot(lastTower).onReleased();
                        lastTower = i;
                        break;
                    } else {
                        if (lastTower != -1)
                            map.Slot(lastTower).onReleased();
                    }
                }
            }
            map.Wave().WaveEnd().IsClicked(x, y);
        }

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

    public boolean Loaded() { return this.loaded; }
}
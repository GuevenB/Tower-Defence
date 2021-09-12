package com.ngdroidapp;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 10.07.2018.
 */

class Wave {
    private ArrayList<WaveStart> waveStarts = new ArrayList<>();
    private WaveEnd waveEnd;
    int WAVE, CURRENT_WAVE;
    Timer timer = new Timer(this);
    private Map map;

    Wave(NgApp ngApp, String path, Map map) {
        this.map = map;
        Random rand = new Random();
        int MIN_WAVE = 1, MAX_WAVE = 2, MIN_MONSTER = 5, MAX_MONSTER = 10, MONSTER[], CURRENT_MONSTER = 0;
        this.CURRENT_WAVE = 0;
        switch (path) {
            case "map1.png":
                waveEnd = new WaveEnd(ngApp,1486, 850, 90);
                waveStarts.add(new WaveStart(128, 96, 0, 1));
                break;
            case "map2.png":
                waveEnd = new WaveEnd(ngApp,896, 930, 90);
                waveStarts.add(new WaveStart(490, 0, 0, 1));
                waveStarts.add(new WaveStart(1260, 0, 0, 1));
                break;
            case "map3.png":
                waveEnd = new WaveEnd(ngApp,1790, 700, 0);
                waveStarts.add(new WaveStart(0, 56, 1, 0));
                waveStarts.add(new WaveStart(0, 900, 1, 0));
                break;
            case "map4.png":
                waveEnd = new WaveEnd(ngApp,1670, 950, 90);
                waveStarts.add(new WaveStart(260, 0, 0, 1));
                waveStarts.add(new WaveStart(620, 950, 0, -1));
                break;
            case "map5.png":
                waveEnd = new WaveEnd(ngApp,1800, 400, 0);
                waveStarts.add(new WaveStart(160, 0, 0, 1));
                waveStarts.add(new WaveStart(800, 990, 0, -1));
                break;
            case "map6.png":
                waveEnd = new WaveEnd(ngApp,1840, 480, 0);
                waveStarts.add(new WaveStart(170, 980, 0, -1));
                waveStarts.add(new WaveStart(1010, 0, 0, 1));
                break;
            case "map7.png":
                waveEnd = new WaveEnd(ngApp,1316, 990, 90);
                waveStarts.add(new WaveStart(50, 0, 0, 1));
                break;
            case "map8.png":
                waveEnd = new WaveEnd(ngApp,1830, 650, 0);
                waveStarts.add(new WaveStart(360, 0, 0, 1));
                break;
            case "map9.png":
                waveEnd = new WaveEnd(ngApp,1830, 730, 0);
                waveStarts.add(new WaveStart(170, 0, 0, 1));
                break;
            case "map10.png":
                waveEnd = new WaveEnd(ngApp,1750, 950, 90);
                waveStarts.add(new WaveStart(0, 380, 1, 0));
                waveStarts.add(new WaveStart(500, 0, 0, 1));
                break;
            case "map11.png":
                waveEnd = new WaveEnd(ngApp,1420, 960, 90);
                waveStarts.add(new WaveStart(60, 0, 0, 1));
                waveStarts.add(new WaveStart(1400, 0, 0, 1));
                break;
            case "map12.png":
                waveEnd = new WaveEnd(ngApp,1400, 970, 90);
                waveStarts.add(new WaveStart(0, 370, 1, 0));
                waveStarts.add(new WaveStart(580, 0, 0, 1));
                break;
            case "map13.png":
                waveEnd = new WaveEnd(ngApp,1800, 780, 0);
                waveStarts.add(new WaveStart(0, 225, 1, 0));
                break;
            case "map14.png":
                waveEnd = new WaveEnd(ngApp,870, 980, 90);
                waveStarts.add(new WaveStart(550, 0, 0, 1));
                waveStarts.add(new WaveStart( 1140, 0, 0, 1));
                break;
        }
        WAVE = rand.nextInt(MAX_WAVE + 1 - MIN_WAVE) + MIN_WAVE;
        MONSTER = new int[WAVE];
        for (int i = 0; i < WAVE; i++) {
            MONSTER[i] = rand.nextInt(MAX_MONSTER - MIN_MONSTER) + MIN_MONSTER;
            for (int j = 0; j < MONSTER[i]; j++) {
                int size = WaveStarts().size();
                int randStart = rand.nextInt(size);
                int dx = WaveStarts(randStart).X() + (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * (j * rand.nextInt(5) * 2));
                int dy = WaveStarts(randStart).Y() -  (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * (j * rand.nextInt(5) * 2));
                int ix = WaveStarts(randStart).IX();
                int iy = WaveStarts(randStart).IY();
                this.map.Monsters().add(new Monster(this.map.ngApp, dx, dy, rand.nextInt(4), 40 + rand.nextInt(20)));
                this.map.Monster(CURRENT_MONSTER).ix = ix;
                this.map.Monster(CURRENT_MONSTER).iy = iy;
                if (j == 0)
                    timer.push_back(new Timer(this.map.Monster(CURRENT_MONSTER), null, 8000));
                else
                    timer.push_back(new Timer(this.map.Monster(CURRENT_MONSTER), null, 1000));
                CURRENT_MONSTER++;
            }
        }
    }

    WaveEnd WaveEnd() { return this.waveEnd; }
    private ArrayList<WaveStart> WaveStarts() { return this.waveStarts; }
    private WaveStart WaveStarts(int index) { return this.waveStarts.get(index); }
}

package com.ngdroidapp;

import istanbul.gamelab.ngdroid.util.Log;

/**
 * Created by PC LAB on 1.08.2018.
 */

public class Timer {
    private Monster monster;
    private Timer next, current;
    private long interval, start, baseinterval;
    private boolean isPaused;
    private Wave parent;

    public Timer(Wave wave) {parent=wave;}

    public Timer(Monster monster, Timer next, long interval) {
        this.interval = interval;
        this.baseinterval = interval;
        this.monster = monster;
        this.next = next;
        this.start = 0;
        this.isPaused = false;
        current = this;
    }

    public void push_back(Timer timer) {
        Timer iter = this;
        if (iter.monster == null) {
            this.monster = timer.monster;
            this.interval = timer.interval;
            this.next = timer.next;
            this.start = 0;
            this.isPaused = false;
            current = this;
        }
        else  {
            while (iter.next != null) {
                iter = iter.next;
            }
            iter.next = timer;
        }
    }

    public void update() {
        if (current != null) {
            if (current.start == 0) {
                current.start = System.currentTimeMillis();
            } else if (current.start <= System.currentTimeMillis() - current.interval) {
                if (current.interval == 8000 || current.baseinterval == 8000) {
                    parent.CURRENT_WAVE++;
                }
                current.monster.Spawn();
                current = current.next;
            }
        }
    }

    public void pause() {
        if(!isPaused && current != null) {
            current.interval -= (System.currentTimeMillis() - current.start);
        }
        isPaused = true;
    }

    public void resume() {
        if (current != null)
            current.start = System.currentTimeMillis();
        isPaused = false;
    }
}

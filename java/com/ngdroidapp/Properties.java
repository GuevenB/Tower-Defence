package com.ngdroidapp;

import android.graphics.Point;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 18.07.2018.
 */

public class Properties {

    public static float getScreenWidthRatio(int screenWidth) {return screenWidth / 1920.0f;}

    public static float getScreenHeightRatio(int screenHeight) {return screenHeight / 1080.0f;}

    static final int COLOR_GRAY = 0xFF666666;

    static final int COLOR_GOLD = 0xFFFF9C01;

    static final int END_GAME_FONT_SIZE = 56;

    static final String END_GAME_FONT = "fonts/ocr-a-std.ttf";

    static final int INGAME_FONT_SIZE = 96;

    static final String INGAME_FONT = "fonts/chisel-mark.ttf";

    static final String TOWERSHEET = "Towersheet.png";

    static final String TOWER_SLOT_ONCLICKPATH = "Options/Menu.png";

    static final Point TOWER_SLOT = new Point(128, 64);

    static final Point[][] TOWER;

    private static final int TOWER_TYPE[];

    static {
        TOWER_TYPE = new int[] {
                3, 2, 3, 3
        };
        TOWER = new Point[4][];
        for (int i = 0; i < 4; i++) {
            TOWER[i] = new Point[TOWER_TYPE[i]];
            for (int j = 0; j < TOWER_TYPE[i]; j++) {
                TOWER[i][j] = new Point(j * 64, i * 64);
            }
        }
    }

    static final String SPRITESHEET = "Spritesheet.png";

    static final Point SPRITE[][];

    static final int POSITION_E = 0;

    static final int POSITION_S = 1;

    static final int POSITION_N = 2;

    static final int POSITION_W = 3;

    static  {
        SPRITE = new Point[4][];
        for (int i = 0; i < 4; i++) {
            SPRITE[i] = new Point[4];
            for (int j = 0; j < 4; j++) {
                SPRITE[i][j] = new Point(j * 32, i * 32);
            }
        }
    }

    static final String AMMOSHEET = "Ammosheet.png";

    static final Point AMMO[][];

    static {
        AMMO = new Point[3][];
        AMMO[0] = new Point[] {
                new Point(0,0),
        };

        AMMO[1] = new Point[] {
                new Point(0,64),
        };

        AMMO[2] = new Point[] {
                new Point(0,128),
        };
    }

    static final int TOWER_PRICE[][];

    static {
        TOWER_PRICE = new int[4][];
        for (int i = 0; i < 4; i++) {
            TOWER_PRICE[i] = new int[3];
        }
        TOWER_PRICE[0][0] = 225;
        TOWER_PRICE[0][1] = 275;
        TOWER_PRICE[0][2] = 350;
        TOWER_PRICE[1][0] = 150;
        TOWER_PRICE[1][1] = 200;
        TOWER_PRICE[1][2] = 275;
        TOWER_PRICE[2][0] = 175;
        TOWER_PRICE[2][1] = 225;
        TOWER_PRICE[2][2] = 300;
        TOWER_PRICE[3][0] = 100;
        TOWER_PRICE[3][1] = 150;
        TOWER_PRICE[3][2] = 250;
    }

    static final long TOWER_ATTACK_SPEED[];

    static {
        TOWER_ATTACK_SPEED = new long[4];
        TOWER_ATTACK_SPEED[0] = 1250;
        TOWER_ATTACK_SPEED[1] = 750;
        TOWER_ATTACK_SPEED[2] = 1000;
        TOWER_ATTACK_SPEED[3] = 500;
    }

    static final int TOWER_ATTACK_DAMAGE[][];

    static {
        TOWER_ATTACK_DAMAGE = new int[4][];
        for (int i = 0; i < 4; i++) {
            TOWER_ATTACK_DAMAGE[i] = new int[3];
        }
        TOWER_ATTACK_DAMAGE[0][0] = 30;
        TOWER_ATTACK_DAMAGE[0][1] = 40;
        TOWER_ATTACK_DAMAGE[0][2] = 50;
        TOWER_ATTACK_DAMAGE[1][0] = 20;
        TOWER_ATTACK_DAMAGE[1][1] = 25;
        TOWER_ATTACK_DAMAGE[1][2] = 30;
        TOWER_ATTACK_DAMAGE[2][0] = 25;
        TOWER_ATTACK_DAMAGE[2][1] = 30;
        TOWER_ATTACK_DAMAGE[2][2] = 35;
        TOWER_ATTACK_DAMAGE[3][0] = 15;
        TOWER_ATTACK_DAMAGE[3][1] = 20;
        TOWER_ATTACK_DAMAGE[3][2] = 25;
    }
}

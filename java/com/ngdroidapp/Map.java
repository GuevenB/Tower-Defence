package com.ngdroidapp;

import com.ngdroidapp.Objects.NgObjectDrawable;

import java.util.ArrayList;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 13.07.2018.
 */

public class Map extends NgObjectDrawable {
    private ArrayList<Checkpoint> checkpoints;
    private ArrayList<TowerSlot> slots;
    private ArrayList<Monster> monsters;
    private Wave wave;
    public NgApp ngApp;
    public Tank tank;

    public Map(NgApp ngApp, String path) {
        super(ngApp, "Maps/" + path, 0,0,1920, 1080);
        this.checkpoints = new ArrayList<>();;
        this.slots = new ArrayList<>();
        this.monsters = new ArrayList<>();
        this.ngApp = ngApp;
        this.wave = new Wave(ngApp, path, this);
        this.tank = new Tank(ngApp, wave.WaveEnd().X(), wave.WaveEnd().Y(), wave.WaveEnd().angle);
        switch (path) {
            case "map1.png":
                slots.add(new TowerSlot(ngApp, 280, 285));
                slots.add(new TowerSlot(ngApp,115, 635));
                slots.add(new TowerSlot(ngApp,660, 285));
                slots.add(new TowerSlot(ngApp,1050, 390));
                slots.add(new TowerSlot(ngApp,1685, 375));
                checkpoints.add(new Checkpoint(96,  480, Direction.Right, Direction.Up));
                checkpoints.add(new Checkpoint(846, 480, Direction.Up, checkpoints.get(0)));
                checkpoints.add(new Checkpoint(846, 226, Direction.Right, checkpoints.get(1)));
                checkpoints.add(new Checkpoint(1486, 226, Direction.Down, checkpoints.get(2)));
                break;
            case "map2.png":
                slots.add(new TowerSlot(ngApp, 280, 133));
                slots.add(new TowerSlot(ngApp, 280, 505));
                slots.add(new TowerSlot(ngApp, 571,739));
                slots.add(new TowerSlot(ngApp, 763, 315));
                slots.add(new TowerSlot(ngApp, 1050,209));
                slots.add(new TowerSlot(ngApp, 1430,64));
                slots.add(new TowerSlot(ngApp, 1430, 625));
                slots.add(new TowerSlot(ngApp, 1170, 739));
                checkpoints.add(new Checkpoint(480, 630, Direction.Right,  Direction.Up));
                checkpoints.add(new Checkpoint(1254,630, Direction.Left, Direction.Up));
                checkpoints.add(new Checkpoint(855, 630, Direction.Down, checkpoints.get(0)));
                break;
            case "map3.png":
                slots.add(new TowerSlot(ngApp,490, 36));
                slots.add(new TowerSlot(ngApp,198, 302));
                slots.add(new TowerSlot(ngApp,512, 425));
                slots.add(new TowerSlot(ngApp,999, 355));
                slots.add(new TowerSlot(ngApp,1388, 355));
                slots.add(new TowerSlot(ngApp,196, 659));
                slots.add(new TowerSlot(ngApp,1051, 659));
                slots.add(new TowerSlot(ngApp,1574, 816));
                checkpoints.add(new Checkpoint(490,80,Direction.Down, Direction.Left));
                checkpoints.add(new Checkpoint(354, 662, Direction.Right, checkpoints.get(0)));
                checkpoints.add(new Checkpoint(858, 574, Direction.Up, checkpoints.get(1)));
                checkpoints.add(new Checkpoint(790, 30, Direction.Right, checkpoints.get(2)));
                checkpoints.add(new Checkpoint(1240, 50, Direction.Down, checkpoints.get(3)));
                checkpoints.add(new Checkpoint(1240, 790, Direction.Right, checkpoints.get(4)));
                checkpoints.add(new Checkpoint(1340, 843, Direction.Up, Direction.Left));
                break;
            case "map4.png":
                slots.add(new TowerSlot(ngApp,35,161));
                slots.add(new TowerSlot(ngApp,325,525));
                slots.add(new TowerSlot(ngApp,490,0));
                slots.add(new TowerSlot(ngApp,410,850));
                slots.add(new TowerSlot(ngApp,832,130));
                slots.add(new TowerSlot(ngApp,1081,495));
                slots.add(new TowerSlot(ngApp,1592,140));
                slots.add(new TowerSlot(ngApp,1440,637));
                checkpoints.add(new Checkpoint(259,  415, Direction.Right, Direction.Up));
                checkpoints.add(new Checkpoint(1675, 348, Direction.Down, checkpoints.get(0)));
                checkpoints.add(new Checkpoint(600, 215, Direction.Right, Direction.Down));
                break;
            case "map5.png":
                slots.add(new TowerSlot(ngApp,290,511));
                slots.add(new TowerSlot(ngApp,590,170));
                slots.add(new TowerSlot(ngApp,590,770));
                slots.add(new TowerSlot(ngApp,960,770));
                slots.add(new TowerSlot(ngApp,1165,170));
                slots.add(new TowerSlot(ngApp,1206, 568));
                slots.add(new TowerSlot(ngApp,1718,170));
                checkpoints.add(new Checkpoint(190,  410, Direction.Right, Direction.Up));
                checkpoints.add(new Checkpoint(804, 274, Direction.Right, Direction.Down));
                break;
            case "map6.png":
                slots.add(new TowerSlot(ngApp,271,859));
                slots.add(new TowerSlot(ngApp,312,452));
                slots.add(new TowerSlot(ngApp,801,52));
                slots.add(new TowerSlot(ngApp,882,541));
                slots.add(new TowerSlot(ngApp,1154,751));
                slots.add(new TowerSlot(ngApp,1405,274));
                checkpoints.add(new Checkpoint(150, 525, Direction.Right, Direction.Down));
                checkpoints.add(new Checkpoint(550, 600, Direction.Up, checkpoints.get(0)));
                checkpoints.add(new Checkpoint(500, 250, Direction.Right, checkpoints.get(1)));
                checkpoints.add(new Checkpoint(1100, 300, Direction.Down, checkpoints.get(2)));
                checkpoints.add(new Checkpoint(1100, 725, Direction.Right, checkpoints.get(3)));
                checkpoints.add(new Checkpoint(1300, 675, Direction.Up, checkpoints.get(4)));
                checkpoints.add(new Checkpoint(1300, 425, Direction.Right, checkpoints.get(5)));
                checkpoints.add(new Checkpoint(900, 400, Direction.Right, checkpoints.get(6)));
                break;
            case "map7.png":
                slots.add(new TowerSlot(ngApp, 126,126));
                slots.add(new TowerSlot(ngApp, 136,580));
                slots.add(new TowerSlot(ngApp, 560,164));
                slots.add(new TowerSlot(ngApp, 676,728));
                slots.add(new TowerSlot(ngApp, 996,544));
                slots.add(new TowerSlot(ngApp, 1092,926));
                slots.add(new TowerSlot(ngApp, 1338,544));
                checkpoints.add(new Checkpoint(40,435, Direction.Right, Direction.Up));
                checkpoints.add(new Checkpoint(860, 382, Direction.Down, checkpoints.get(0)));
                checkpoints.add(new Checkpoint(860, 795, Direction.Right, checkpoints.get(1)));
                checkpoints.add(new Checkpoint(1290, 795, Direction.Down, checkpoints.get(2)));
                break;
            case "map8.png":
                slots.add(new TowerSlot(ngApp,164,330));
                slots.add(new TowerSlot(ngApp,516,138));
                slots.add(new TowerSlot(ngApp,900, 132));
                slots.add(new TowerSlot(ngApp,792,542));
                slots.add(new TowerSlot(ngApp,1152,424));
                slots.add(new TowerSlot(ngApp,1500,430));
                slots.add(new TowerSlot(ngApp,1694,730));
                checkpoints.add(new Checkpoint(360, 360, Direction.Right, Direction.Up));
                checkpoints.add(new Checkpoint(1027,354, Direction.Down, checkpoints.get(0)));
                checkpoints.add(new Checkpoint(1027, 704, Direction.Right, checkpoints.get(1)));
                break;
            case "map9.png":
                slots.add(new TowerSlot(ngApp,100,490));
                slots.add(new TowerSlot(ngApp,302,109));
                slots.add(new TowerSlot(ngApp,532,249));
                slots.add(new TowerSlot(ngApp,960,29));
                slots.add(new TowerSlot(ngApp,1230,358));
                slots.add(new TowerSlot(ngApp,1548,478));
                slots.add(new TowerSlot(ngApp,1728,832));
                checkpoints.add(new Checkpoint(200, 455, Direction.Right,Direction.Up));
                checkpoints.add(new Checkpoint(900, 495, Direction.Up, checkpoints.get(0)));
                checkpoints.add(new Checkpoint(900,160,Direction.Right, checkpoints.get(1)));
                checkpoints.add(new Checkpoint(1430, 237, Direction.Down, checkpoints.get(2)));
                checkpoints.add(new Checkpoint(1430,801, Direction.Right,checkpoints.get(3)));
                break;
            case "map10.png":
                slots.add(new TowerSlot(ngApp,68,169));
                slots.add(new TowerSlot(ngApp,82,534));
                slots.add(new TowerSlot(ngApp,724-50, 196));
                slots.add(new TowerSlot(ngApp,858-50,414));
                slots.add(new TowerSlot(ngApp,1018,782));
                slots.add(new TowerSlot(ngApp,1238,414));
                slots.add(new TowerSlot(ngApp,568,772));
                slots.add(new TowerSlot(ngApp,1422,772));
                checkpoints.add(new Checkpoint(625,300,Direction.Down,Direction.Left));
                checkpoints.add(new Checkpoint(500, 720, Direction.Right, checkpoints.get(0)));
                checkpoints.add(new Checkpoint(1725, 600, Direction.Down, checkpoints.get(1)));
                break;
            case "map11.png":
                slots.add(new TowerSlot(ngApp,52,390));
                slots.add(new TowerSlot(ngApp,484,420));
                slots.add(new TowerSlot(ngApp,390, 62));
                slots.add(new TowerSlot(ngApp,1106,62));
                slots.add(new TowerSlot(ngApp,484,770));
                slots.add(new TowerSlot(ngApp,900,390));
                slots.add(new TowerSlot(ngApp,1282,390));
                slots.add(new TowerSlot(ngApp,1082,580));
                slots.add(new TowerSlot(ngApp,1540,815));
                checkpoints.add(new Checkpoint(75,300, Direction.Right, Direction.Up));
                checkpoints.add(new Checkpoint(700, 314, Direction.Down, checkpoints.get(0)));
                checkpoints.add(new Checkpoint(700,835, Direction.Right, checkpoints.get(1)));
                checkpoints.add(new Checkpoint(1400,300, Direction.Left, Direction.Up));
                checkpoints.add(new Checkpoint(1500, 750, Direction.Down, checkpoints.get(1)));
                break;
            case "map12.png":
                slots.add(new TowerSlot(ngApp,76, 500));
                slots.add(new TowerSlot(ngApp,384,500));
                slots.add(new TowerSlot(ngApp,384,156));
                slots.add(new TowerSlot(ngApp,560,720));
                slots.add(new TowerSlot(ngApp,724,154));
                slots.add(new TowerSlot(ngApp,724,408));
                slots.add(new TowerSlot(ngApp,920,720));
                slots.add(new TowerSlot(ngApp,1200,720));
                slots.add(new TowerSlot(ngApp,1420,408));
                slots.add(new TowerSlot(ngApp,1526,760));
                checkpoints.add(new Checkpoint(700, 330, Direction.Down, Direction.Left));
                checkpoints.add(new Checkpoint(575,690, Direction.Right, checkpoints.get(0)));
                checkpoints.add(new Checkpoint(1400,640, Direction.Down, checkpoints.get(1)));
                break;
            case "map13.png":
                slots.add(new TowerSlot(ngApp,104,20));
                slots.add(new TowerSlot(ngApp,60,364));
                slots.add(new TowerSlot(ngApp,744, 364));
                slots.add(new TowerSlot(ngApp,1090,50));
                slots.add(new TowerSlot(ngApp,1272,580));
                slots.add(new TowerSlot(ngApp,774,800));
                slots.add(new TowerSlot(ngApp,1665,580));
                slots.add(new TowerSlot(ngApp,1300,900));
                checkpoints.add(new Checkpoint(1100, 200, Direction.Down, Direction.Left));
                checkpoints.add(new Checkpoint(920,850, Direction.Right, checkpoints.get(0)));
                break;
            case "map14.png":
                slots.add(new TowerSlot(ngApp,300, 38));
                slots.add(new TowerSlot(ngApp,300, 400));
                slots.add(new TowerSlot(ngApp,376, 668));
                slots.add(new TowerSlot(ngApp,600, 828));
                slots.add(new TowerSlot(ngApp,842, 400));
                slots.add(new TowerSlot(ngApp,1396, 38));
                slots.add(new TowerSlot(ngApp,1396, 400));
                slots.add(new TowerSlot(ngApp,1294, 668));
                slots.add(new TowerSlot(ngApp,1110, 828));
                checkpoints.add(new Checkpoint(550,562, Direction.Right, Direction.Up));
                checkpoints.add(new Checkpoint(800,562, Direction.Down, checkpoints.get(0)));
                checkpoints.add(new Checkpoint(1128, 562, Direction.Left, Direction.Up));
                checkpoints.add(new Checkpoint(800,562, Direction.Down, checkpoints.get(0)));
                break;
        }
    }

    public Checkpoint Checkpoint(int index) { return this.checkpoints.get(index); }
    public TowerSlot Slot(int index) { return this.slots.get(index); }
    public Monster Monster(int index) { return this.monsters.get(index); }
    public ArrayList<Monster> Monsters() { return this.monsters; }
    public ArrayList<Checkpoint> Checkpoints() { return this.checkpoints; }
    public ArrayList<TowerSlot> Slots() { return this.slots; }
    public Wave Wave() { return this.wave; }
}

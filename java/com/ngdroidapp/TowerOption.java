package com.ngdroidapp;

import com.ngdroidapp.Objects.NgObjectClickable;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 02.07.2018.
 */

public class TowerOption extends NgObjectClickable {
    private int price;
    private String path;
    private String type;
    private int TYPE;

    public TowerOption(NgApp ngApp, String path, int type, int x, int y)  {
        super(ngApp, path, x, y, 0,0);
        Destination(x, y, x + (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * 115), y + (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * 109), false);
        this.path = path;
        this.type = type+"";
        this.TYPE = type;
        Price(Properties.TOWER_PRICE[TYPE][0]);
    }

    public void Price(int price) { this.price = price; }
    public int Price() { return this.price; }

    public boolean IsClicked(int x, int y, NgApp ngApp, TowerSlot slot, Coin currency) {
        if (IsClicked(x, y))    {
            if(this.type.equals(slot.Type())) {
                if (slot.Level() < 3 && currency.Down(price)) {
                    slot.Ammo().Damage(Properties.TOWER_ATTACK_DAMAGE[TYPE][slot.Level()]);
                    Price(Properties.TOWER_PRICE[TYPE][slot.Level()]);
                    slot.Level(slot.Level() + 1);
                    if (slot.Level() != 3)
                        Source(ngApp, this.path.replace("0.png", slot.Level() + ".png"));
                    else
                        Source(ngApp, "Options/Locked.png");
                }
            }
            else {
                if (!this.type.equals("locked") && currency.Down(price)) {
                    slot.Type(this.type);
                    slot.Ammo(Integer.parseInt(this.type));
                    Price(Properties.TOWER_PRICE[TYPE][slot.Level()]);
                    for (int i = 0; i < 4; i++) {
                        if (!this.type.equals(slot.Options().option[i].type)) {
                            slot.Options().option[i].Source(ngApp, "Options/Locked.png");
                            slot.Options().option[i].type = "locked";
                        }
                    }
                    slot.Ammo().Damage(Properties.TOWER_ATTACK_DAMAGE[TYPE][slot.Level()]);
                    slot.Level(slot.Level() + 1);
                    Source(ngApp, this.path.replace("0.png", slot.Level() + ".png"));
                    slot.SourceLocation(Properties.TOWER[Integer.parseInt(type)][0]);
                }
            }
        }
        return IsClicked();
    }
}

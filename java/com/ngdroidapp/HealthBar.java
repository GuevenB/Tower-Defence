package com.ngdroidapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.ngdroidapp.Objects.NgObjectDrawable;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 26.06.2018.
 */

public class HealthBar extends NgObjectDrawable{
    private Paint painter;
    private int currentHP;
    private float percentage;
    private boolean canDraw;
    private int i = 0;

    public HealthBar(NgApp ngApp, int maxHP, int x, int y, int w)  {
        super(ngApp, "Outside.png", x, y, w, 16);

        this.currentHP = maxHP;
        this.percentage = maxHP / w;
        this.painter = new Paint();
        this.painter.setColor(Color.RED);
        this.painter.setStyle(Paint.Style.FILL);
        this.canDraw = false;
    };

    @Override
    public void draw(Canvas canvas) {
        if (canDraw) {
            super.draw(canvas);
            canvas.drawRect(X(), Y(), X() + (int) (currentHP * percentage), Destination().bottom, painter);
            if (i > 20) {
                canDraw = false;
                i = 0;
            }
            else
                i++;
        }
    }

    public void update(int x, int y)    {
        Destination(x, y, x + W(), y + H(), false);
    };

    public void update(int damage)   {
        this.currentHP -= damage;
        this.canDraw = true;
        i = 0;
    }

    public int CurrentHP() { return this.currentHP; }
}

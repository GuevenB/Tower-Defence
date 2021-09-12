package com.ngdroidapp;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import com.ngdroidapp.Objects.NgObjectDrawable;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 11.07.2018.
 */

public class Coin extends NgObjectDrawable {
    private int currency;
    private Paint painter;

    public Coin(NgApp ngApp)   {
        super(ngApp, "coin.png", 1820, 24, 80, 80);
        painter = new Paint();
        painter.setColor(Properties.COLOR_GOLD);
        painter.setTypeface(Typeface.createFromAsset(ngApp.activity.getAssets(), Properties.INGAME_FONT));
        painter.setTextSize((int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * Properties.INGAME_FONT_SIZE));
        this.currency = 750;
    }

    public Coin(Coin c, NgApp ngApp) {
        super(ngApp, "coin.png", 1820, 24, 80, 80);
        painter = c.painter;
        painter.setTextSize(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * Properties.INGAME_FONT_SIZE);
        currency = c.currency;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawText(currency + " ", Destination().right -(int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) *  224), Destination().bottom, painter);
    }

    public long Currency() { return this.currency; }

    public void Currency(long currency) { this.currency = (int)currency; }

    public boolean Down(int price) {
        if (currency - price < 0)
            return false;
        else
            currency -= price;
        return true;
    }
}

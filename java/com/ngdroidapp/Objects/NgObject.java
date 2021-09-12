package com.ngdroidapp.Objects;

import android.graphics.Point;
import android.graphics.Rect;

import com.ngdroidapp.NgApp;
import com.ngdroidapp.Properties;

/**
 * Created by Emrullah Şahin & Güven Boz & Bahadır Yalın & Yunus Derici on 01.07.2018.
 */

public class NgObject {
    private Rect destination;

    public NgObject(int dstx, int dsty, int dstw, int dsth)  {
        this.destination = new Rect();
        Destination(dstx, dsty, dstx + dstw, dsty + dsth);
    }

    public NgObject(Rect destination)  {
        this.destination = new Rect();
        Destination(destination);
    }

    // Getter Methods

    /**
     * @return The X Coordinate of the Object.
     */
    public int X() { return destination.left; }

    /**
     * @return The Y Coordinate of the Object.
     */
    public int Y() { return destination.top; }

    /**
     * @return The Width of the Object.
     */
    public int W() { return destination.width(); }

    /**
     * @return The Height of the Object.
     */
    public int H() { return destination.height(); }

    /**
     * @return The Location of the Object on Canvas as Rectangle.
     */
    public Rect Destination() { return this.destination; }

    // Setter Methods

    /**
     * @param x The X coordinate of the Object on Canvas.
     */
    public void X(int x) { this.destination.left = x; }

    /**
     * @param y The Y coordinate of the Object on Canvas.
     */
    public void Y(int y) { this.destination.top = y; }

    /**
     * @param w The Width of the Object on Canvas.
     */
    public void W(int w) { this.destination.right = X() + w; }

    /**
     * @param h The Height of the Object on Canvas.
     */
    public void H(int h) { this.destination.bottom = Y() + h; }

    /**
     * @param dx The amount to add to the right and left coordinates of Object on Canvas.
     * @param dy The amount to add to the top and bottom coordinates of Object on Canvas.
     */
    public void Destination(int dx, int dy) { this.destination.offset((int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * dx), (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * dy)); }

    /**
     * @param x The X1 coordinate of the Object on Canvas.
     * @param y The Y1 coordinate of the Object on Canvas.
     * @param r The X2 coordinate of the Object on Canvas.
     * @param b The Y2 coordinate of the Object on Canvas.
     */
    public void Destination(int x, int y, int r, int b) {
        this.destination.set((int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH)* x),
                (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * y),
                (int)(Properties.getScreenWidthRatio(NgApp.SCREEN_WIDTH) * r),
                (int)(Properties.getScreenHeightRatio(NgApp.SCREEN_HEIGHT) * b));
    }


    public void Destination(int x, int y, int r, int b, boolean state) {
        this.destination.set(x, y, r, b);
    }


    /**
     * @param rect
     */
    public void Destination(Rect rect) { Destination(rect.left, rect.top, rect.right, rect.bottom); }

    // Helper Functions

    /**
     * @param b The Rectangle being tested for intersection.
     * @return true iff the specified rectangle and Object on Canvas intersect.
     */
    public boolean intersects(Rect b) { return Rect.intersects(this.destination, b); }

    /**
     * @param x The left side of the rectangle being tested for intersection.
     * @param y The top of the rectangle being tested for intersection.
     * @param r The right side of the rectangle being tested for intersection.
     * @param b The bottom of the rectangle being tested for intersection.
     * @return true iff the specified rectangle intersects this rectangle.
     */
    public boolean intersects(int x, int y, int r, int b) { return this.destination.intersects(x, y, r, b); }

    /**
     * @param x The X coordinate of the point being tested for intersection.
     * @param y The Y coordinate of the point being tested for intersection.
     * @return true iff the specified point intersects this rectangle.
     */
    public boolean intersects(int x, int y) { return this.destination.intersects(x, y, x, y); }

    /**
     * @param point The point being tested for intersection.
     * @return true iff the specified point intersects this rectangle.
     */
    public boolean intersects(Point point) { return intersects(point.x, point.y); }
}

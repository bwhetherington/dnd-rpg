package com.bwh.game.util;

import java.awt.Point;

/**
 * Created by bwh on 11/10/16.
 */
public abstract class AbstractLayer<T> implements Layer<T> {
    private int width, height;

    public AbstractLayer(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int width() {
        return width;
    }

    @Override
    public int height() {
        return height;
    }

    @Override
    public T get(Point point) {
        return get(point.x, point.y);
    }

    @Override
    public T set(Point point, T value) {
        return set(point.x, point.y, value);
    }

    protected boolean isValid(Point point) {
        return isValid(point.x, point.y);
    }

    protected boolean isValid(int x, int y) {
        return 0 <= x && x < width()
                && 0 <= y && y < height();
    }

    protected void checkPoint(Point point) {
        checkPoint(point.x, point.y);
    }

    protected void checkPoint(int x, int y) {
        if (!isValid(x, y)) {
            throw new IllegalArgumentException();
        }
    }
}

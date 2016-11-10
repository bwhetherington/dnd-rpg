package com.bwh.game.util;

import java.awt.Point;

/**
 * @author Benjamin Hetherington
 * @since 11/10/2016
 */
public abstract class AbstractLayer<T> implements Layer<T> {
    private int width, height;

    /**
     * @param width the width of the layer
     * @param height the height of the layer
     */
    public AbstractLayer(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the width of the layer.
     * @return the width of the layer
     */
    @Override
    public int width() {
        return width;
    }

    /**
     * Returns the height of the layer.
     * @return the height of the layer
     */
    @Override
    public int height() {
        return height;
    }

    /**
     * Returns the value at the specified point.
     * @param point the point
     * @return the value at the point
     */
    @Override
    public T get(Point point) {
        return get(point.x, point.y);
    }

    /**
     * Sets the value at the specified point to the specified value and returns
     * the value previously occupying the point.
     * @param point the point
     * @param value the value at the point
     * @return the previous value
     */
    @Override
    public T set(Point point, T value) {
        return set(point.x, point.y, value);
    }

    /**
     * Determines whether or not the specified point is within the bounds of
     * the layer.
     * @param point the point
     * @return whether or not the point is in bounds
     */
    protected boolean isValid(Point point) {
        return isValid(point.x, point.y);
    }

    /**
     * Determines whether or not the specified coordinates are within the
     * bounds of the layer.
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return whether or not the coordinates are in bounds
     */
    protected boolean isValid(int x, int y) {
        return 0 <= x && x < width()
                && 0 <= y && y < height();
    }

    /**
     * Throws an exception if the point is not within the bounds of the layer.
     * @param point the point to check
     */
    protected void checkPoint(Point point) {
        checkPoint(point.x, point.y);
    }

    /**
     * Throws an exception if the coordinates are not within the bounds of the
     * layer.
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    protected void checkPoint(int x, int y) {
        if (!isValid(x, y)) {
            throw new IllegalArgumentException();
        }
    }
}

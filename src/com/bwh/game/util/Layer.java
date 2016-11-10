package com.bwh.game.util;

import java.awt.Point;

/**
 * @author Benjamin Hetherington
 * @since 11/10/2016
 */
public interface Layer<T> {
    /**
     * Returns the width of the layer.
     * @return the width of the layer
     */
    int width();

    /**
     * Returns the height of the layer.
     * @return the height of the layer
     */
    int height();

    /**
     * Sets the value at the specified point to the specified value and returns
     * the value previously occupying the point.
     * @param point the point
     * @param value the value at the point
     * @return the previous value
     */
    T set(Point point, T value);

    /**
     * Sets the value at the specified coordinates to the specified value and
     * returns the value previously occupying the coordinates.
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param value the value at the coordinates
     * @return the previous value
     */
    T set(int x, int y, T value);

    /**
     * Returns the value at the specified point.
     * @param point the point
     * @return the value at the point
     */
    T get(Point point);

    /**
     * Returns the value at the specified coordinates.
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return the value at the coordinates
     */
    T get(int x, int y);

    /**
     * Clears the layer, setting all cells' values to null.
     */
    void clear();
}

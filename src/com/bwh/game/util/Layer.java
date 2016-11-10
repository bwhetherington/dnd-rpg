package com.bwh.game.util;

import java.awt.Point;

/**
 * @author Benjamin Hetherington
 * @since 11/10/2016
 */
public interface Layer<T> {
    int width();
    int height();

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

    T get(Point point);
    T get(int x, int y);
}

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
    T set(int x, int y, T value);

    T get(Point point);
    T get(int x, int y);
}

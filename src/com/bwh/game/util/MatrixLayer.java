package com.bwh.game.util;

import java.util.Arrays;

/**
 * @author Benjamin Hetherington
 * @since 11/10/2016
 */
public class MatrixLayer<T> extends AbstractLayer<T> {
    private Object[][] matrix;
    private int width, height;

    /**
     * @param width the width of the layer
     * @param height the height of the layer
     */
    public MatrixLayer(int width, int height) {
        super(width, height);
        matrix = new Object[width][height];
    }

    /**
     * Returns the value at the specified coordinates.
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return the value at the coordinates
     */
    @SuppressWarnings("unchecked")
    @Override
    public T get(int x, int y) {
        checkPoint(x, y);
        return (T) matrix[x][y];
    }

    /**
     * Sets the value at the specified coordinates to the specified value and
     * returns the value previously occupying the coordinates.
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param value the value at the coordinates
     * @return the previous value
     */
    @Override
    public T set(int x, int y, T value) {
        checkPoint(x, y);
        final T prev = get(x, y);
        matrix[x][y] = value;
        return prev;
    }

    /**
     * Clears the layer, setting all cells' values to null.
     */
    @Override
    public void clear() {
        for (int x = 0; x < width(); x++) {
            Arrays.fill(matrix[x], null);
        }
    }
}

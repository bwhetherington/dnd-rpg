package com.bwh.game.util;

/**
 * Created by bwh on 11/10/16.
 */
public class MatrixLayer<T> extends AbstractLayer<T> {
    private Object[][] matrix;
    private int width, height;

    public MatrixLayer(int width, int height) {
        super(width, height);
        matrix = new Object[width][height];
    }

    @Override
    public T get(int x, int y) {
        checkPoint(x, y);
        return (T) matrix[x][y];
    }

    @Override
    public T set(int x, int y, T value) {
        checkPoint(x, y);
        final T prev = get(x, y);
        matrix[x][y] = value;
        return prev;
    }
}

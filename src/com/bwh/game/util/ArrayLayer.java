package com.bwh.game.util;

import java.util.Arrays;

/**
 * An implementation of <tt>Layer</tt> that uses a one-dimensional array to
 * store elements.
 * @author Benjamin Hetherington
 * @since 11/10/2016
 */
public class ArrayLayer<T> extends AbstractLayer<T> {
	private Object[] array;
	
    /**
     * @param width the width of the layer
     * @param height the height of the layer
     */
	public ArrayLayer(int width, int height) {
		super(width, height);
		array = new Object[width * height];
	}
	
	/**
	 * Converts an x-coordinate and y-coordinate into a one-dimensional index
	 * representing the two-dimensional coordinates in the internal array.
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 * @return the index
	 */
	private int convertToIndex(int x, int y) {
		return y * height() + x;
	}
	
	/**
	 * Returns the value stored at the specified index in the internal array.
	 * @param index the index
	 * @return the value at the index
	 */
	@SuppressWarnings("unchecked")
	private T get(int index) {
		return (T) array[index];
	}
	
	/**
     * Returns the value at the specified coordinates.
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return the value at the coordinates
     */
	@Override
	public T get(int x, int y) {
		checkPoint(x, y);
		final int index = convertToIndex(x, y);
		return get(index);
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
		final int index = convertToIndex(x, y);
		final T prev = get(index);
		array[index] = value;
		return prev;
	}
	
	/**
     * Clears the layer, setting all cells' values to null.
     */
	@Override
	public void clear() {
		Arrays.fill(array, null);
	}
}

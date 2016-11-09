package com.bwh.game.util;

/**
 * Created by bwh on 11/7/16.
 */
public class Vector {
    private final int x, y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Vector multiply(int scalar) {
        return new Vector(scalar * x, scalar * y);
    }

    /**
     * Returns the sum of this vector and a specified vector.
     * @param vec The other vector
     * @return The sum of the vectors
     */
    public Vector add(Vector vec) {
        return new Vector(x + vec.x, y + vec.y);
    }

    /**
     * Returns the dot product of this vector with a specified vector. The dot
     * product is define as the sum of the products of the terms of each
     * vector.
     * @param vec The other vector
     * @return The dot product of the vectors
     */
    public int dotProduct(Vector vec) {
        return x * vec.x + y * vec.y;
    }

    /**
     * Returns a string representation of a vector in the form:
     * <pre><x,y></pre>
     */
    @Override
    public String toString() {
        return String.format("<%d, %d>", x, y);
    }

    @Override
    public int hashCode() {
        return 17 * x + 31 * y;
    }

    /**
     * Returns whether or not the vector is equal to the specified object. A
     * vector is equal to another object if and only if the other object is a
     * vector and the components of each of the vectors are equal.
     * @param obj The object to check equality against
     * @return Whether or not the two objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        // If they are the same object, they are equal
        if (this == obj) {
            return true;
        }

        // If the other object is null, they must not be equal
        if (obj == null) {
            return false;
        }

        // If they are not the same class, they must not be equal
        if (getClass() != obj.getClass()) {
            return false;
        }

        // They are both Vectors, compare components
        final Vector vec = (Vector) obj;
        return x == vec.x && y == vec.y;
    }

    public static void main(String[] args) {
        Vector vec = new Vector(3, 4);
        System.out.println(vec);
    }
}

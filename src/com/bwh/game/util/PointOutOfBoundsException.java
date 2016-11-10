package com.bwh.game.util;

import java.awt.Point;

/**
 * Created by bwh on 11/10/16.
 */
public class PointOutOfBoundsException extends Exception {
    public PointOutOfBoundsException() {}

    public PointOutOfBoundsException(String str) {
        super(str);
    }

    public PointOutOfBoundsException(Throwable cause) {
        super(cause);
    }

    public PointOutOfBoundsException(String str, Throwable cause) {
        super(str, cause);
    }
}

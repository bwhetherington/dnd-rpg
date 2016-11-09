package com.bwh.game.graphics;

import java.awt.*;

/**
 * Created by bwh on 11/6/16.
 */
public interface Sprite extends Renderable {
    /**
     * Generates an image representing the current frame of the sprite as an
     * image.
     * @return The current frame
     */
    Image getCurrentFrame();
}

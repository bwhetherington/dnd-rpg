package com.bwh.game.graphics;

import java.awt.*;

/**
 * Created by bwh on 11/6/16.
 */
public interface Renderable {

    /**
     * Renders the object onto the specified graphics context.
     * @param g The graphics context
     */
    void render(Graphics2D g);
}

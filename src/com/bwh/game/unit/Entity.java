package com.bwh.game.unit;

import java.awt.Graphics2D;
import java.awt.Point;

import com.bwh.game.graphics.Renderable;
import com.bwh.game.graphics.Sprite;

/**
 * @author Benjamin Hetherington
 * @since 11/10/2016
 */
public class Entity implements Renderable {
    private Point location;
    private Sprite sprite;

    public Entity(Point location, Sprite sprite) {
        this.location = location;
        this.sprite = sprite;
    }

    public Entity(Sprite sprite) {
        this(new Point(0, 0), sprite);
    }

    public Point getLocation() {
        return location;
    }

    @Override
    public void render(Graphics2D g) {
        sprite.render(g);
    }

    public void kill() {}
}

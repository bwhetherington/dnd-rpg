package com.bwh.game.unit;

import com.bwh.game.graphics.Renderable;
import com.bwh.game.graphics.Sprite;

import java.awt.*;

/**
 * Created by bwh on 11/6/16.
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

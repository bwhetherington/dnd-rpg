package com.bwh.game.effect;

/**
 * AbstractEffect
 * @author Benjamin Hetherington
 * @since 11/9/2016
 */
public class AbstractEffect implements Effect {
    @Override
    public boolean canExecute() {
        return true;
    }

    @Override
    public void execute() {}
}

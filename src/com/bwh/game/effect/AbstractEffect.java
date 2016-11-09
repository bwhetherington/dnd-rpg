package com.bwh.game.effect;

/**
 * Created by bwh on 11/9/16.
 */
public class AbstractEffect implements Effect {
    @Override
    public boolean canExecute() {
        return true;
    }

    @Override
    public void execute() {}
}

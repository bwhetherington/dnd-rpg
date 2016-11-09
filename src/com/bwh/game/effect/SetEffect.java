package com.bwh.game.effect;

import java.util.Set;

/**
 * Created by bwh on 11/8/16.
 */
public class SetEffect extends AbstractEffect {
    private Set<Effect> effects;

    public SetEffect(Set<Effect> effects) {
        this.effects = effects;
    }

    @Override
    public void execute() {
        for (Effect eff : effects) {
            eff.execute();
        }
    }
}

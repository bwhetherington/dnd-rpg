package com.bwh.game.effect;

import java.util.Set;

/**
 * Contains a set of effects to be executed.
 * @author Benjamin Hetherington
 * @since 11/9/2016
 */
public class SetEffect extends AbstractEffect {
    private Set<Effect> effects;

    /**
     * @param effects the set of effects to execute
     */
    public SetEffect(Set<Effect> effects) {
        this.effects = effects;
    }

    /**
     * Executes every effect contained in the set.
     */
    @Override
    public void execute() {
        for (Effect eff : effects) {
            eff.execute();
        }
    }
}

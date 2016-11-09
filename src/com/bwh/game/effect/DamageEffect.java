package com.bwh.game.effect;

import com.bwh.game.unit.Allegiance;
import com.bwh.game.unit.Unit;
import com.bwh.game.util.MathUtil;

/**
 * Created by bwh on 11/8/16.
 */
public class DamageEffect extends AbstractEffect {
    private Unit source, target;
    private int amountMin, amountMax;

    public DamageEffect(Unit source, Unit target, int amountMin, int amountMax) {
        this.target = target;
        this.amountMin = amountMin;
        this.amountMax = amountMax;
    }

    public DamageEffect(Unit target, int amountMin, int amountMax) {
        this(null, target, amountMin, amountMax);
    }

    public DamageEffect(Unit source, Unit target, int amount) {
        this(source, target, amount, amount);
    }

    public DamageEffect(Unit target, int amount) {
        this(null, target, amount);
    }

    @Override
    public boolean canExecute() {
        if (target == null) {
            return false;
        }
        if (source == null) {
            return true;
        }
        return source.allegianceTo(target) != Allegiance.ALLY;
    }

    @Override
    public void execute() {
        final int amount = MathUtil.randomInt(amountMin, amountMax);
        target.damage(amount);
    }

}

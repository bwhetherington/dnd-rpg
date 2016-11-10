package com.bwh.game.effect;

import com.bwh.game.unit.Allegiance;
import com.bwh.game.unit.Unit;
import com.bwh.game.util.MathUtil;

/**
 * A DamageEffect is an effect that deals damage to a unit. That damage may be
 * defined either as a range of damages to deal or as a single value.
 * @author Benjamin Hetherington
 * @since 11/9/2016
 */
public class DamageEffect extends AbstractEffect {
    private Unit source, target;
    private int amountMin, amountMax;

    /**
     * @param source the source unit
     * @param target the target unit
     * @param amountMin the minimum damage
     * @param amountMax the maximum damage
     */
    public DamageEffect(Unit source, Unit target, int amountMin, int amountMax) {
        this.target = target;
        this.amountMin = amountMin;
        this.amountMax = amountMax;
    }

    /**
     * @param target the target unit
     * @param amountMin the minimum damage
     * @param amountMax the maximum damage
     */
    public DamageEffect(Unit target, int amountMin, int amountMax) {
        this(null, target, amountMin, amountMax);
    }

    /**
     * @param source the source unit
     * @param target the target unit
     * @param amount the damage to deal
     */
    public DamageEffect(Unit source, Unit target, int amount) {
        this(source, target, amount, amount);
    }

    /**
     * @param target the target unit
     * @param amount the damage to deal
     */
    public DamageEffect(Unit target, int amount) {
        this(null, target, amount);
    }

    /**
     * Determines whether or not the damage effect may be executed. It may be
     * executed if the two units are not allied.
     * @return whether or not the effect may be executed
     */
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

    /**
     * Deals a random amount of damage, bounded inclusively by the specified
     * minimum and maximum amounts, to the target unit.
     */
    @Override
    public void execute() {
        final int amount = MathUtil.randomInt(amountMin, amountMax);
        target.damage(amount);
    }

}

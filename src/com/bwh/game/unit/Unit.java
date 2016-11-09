package com.bwh.game.unit;

import com.bwh.game.graphics.Sprite;
import com.bwh.game.util.MathUtil;

import java.awt.*;
import java.util.EnumMap;
import java.util.Map;

/**
 * Created by bwh on 11/7/16.
 */
public class Unit extends Entity {
    private int
        life, lifeMax,
        mana, manaMax,
        xp, xpMax, level;
    private Map<Attribute, Integer> attributes;
    private Faction faction;
    private Profession profession;

    public Unit(Point location, Sprite sprite, Faction faction) {
        super(location, sprite);
        attributes = new EnumMap<>(Attribute.class);
        for (Attribute att : Attribute.values()) {
            attributes.put(att, 0);
        }
        this.faction = faction;
    }

    public Unit(Point location, Sprite sprite) {
        this(location, sprite, Faction.NEUTRAL);
    }

    public Unit(Sprite sprite, Faction faction) {
        this(MathUtil.ORIGIN, sprite, faction);
    }

    public Unit(Sprite sprite) {
        this(sprite, Faction.NEUTRAL);
    }

    /**
     * Sets the specified attribute to the specified value.
     * @param att The attribute
     * @param val The value
     */
    public void setAttribute(Attribute att, int val) {
        attributes.put(att, val);
    }

    /**
     * Returns the unit's specified attribute value.
     * @param att The attribute to check
     * @return The attribute's value
     */
    public int getAttribute(Attribute att) {
        return attributes.get(att);
    }

    /**
     * Reduces the unit's health by the specified amount. If the life drops
     * below 0, the unit is killed.
     * @param amount The amount to reduce the healthy by
     */
    public void damage(int amount) {
        life -= amount;
        if (life < 0) {
            life = 0;
            kill();
        }
    }

    /**
     * Attempts to use the specified ability, and returns whether or not the
     * ability was successfully used.
     * @param ability The specified ability
     * @return Whether or not the ability was used
     */
    public boolean useAbility(Ability ability) {
        final int cost = ability.getCost();
        if (cost > mana) {
            return false;
        } else {
            mana -= cost;
            return ability.execute();
        }
    }

    /**
     * Returns the allegiance of this unit with respect to the other unit.
     * @param other The unit to check allegiance to
     * @return The allegiance to the other unit
     */
    public Allegiance allegianceTo(Unit other) {
        return faction.allegianceTo(other.faction);
    }

    /**
     * Sets the unit's attributes to the specified attribute set.
     * @param atts The attribute set
     */
    public void setAttributes(Map<Attribute, Integer> atts) {
        attributes.clear();
        for (Map.Entry<Attribute, Integer> attPair : atts.entrySet()) {
            attributes.put(attPair.getKey(), attPair.getValue());
        }
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }
}

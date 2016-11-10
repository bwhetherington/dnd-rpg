package com.bwh.game.unit;

import com.bwh.game.graphics.Sprite;
import com.bwh.game.util.MathUtil;
import com.bwh.game.util.UnitUtil;

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
	 * @return the life
	 */
	public int getLife() {
		return life;
	}

	/**
	 * @param life the life to set
	 */
	public void setLife(int life) {
		this.life = life;
	}

	/**
	 * @return the lifeMax
	 */
	public int getLifeMax() {
		return lifeMax;
	}

	/**
	 * @param lifeMax the lifeMax to set
	 */
	public void setLifeMax(int lifeMax) {
		this.lifeMax = lifeMax;
	}

	/**
	 * @return the mana
	 */
	public int getMana() {
		return mana;
	}

	/**
	 * @param mana the mana to set
	 */
	public void setMana(int mana) {
		this.mana = mana;
	}

	/**
	 * @return the manaMax
	 */
	public int getManaMax() {
		return manaMax;
	}

	/**
	 * @param manaMax the manaMax to set
	 */
	public void setManaMax(int manaMax) {
		this.manaMax = manaMax;
	}

	/**
	 * @return the xp
	 */
	public int getXP() {
		return xp;
	}

	/**
	 * @param xp the xp to set
	 */
	public void setXP(int xp) {
		this.xp = xp;
	}

	/**
	 * @return the xpMax
	 */
	public int getXPMax() {
		return xpMax;
	}

	/**
	 * @param xpMax the xpMax to set
	 */
	public void setXPMax(int xpMax) {
		this.xpMax = xpMax;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
     * Sets the specified attribute to the specified value.
     * @param att the attribute
     * @param val the value
     */
    public void setAttribute(Attribute att, int val) {
        attributes.put(att, val);
    }

    /**
     * Returns the unit's specified attribute value.
     * @param att the attribute to check
     * @return the attribute's value
     */
    public int getAttribute(Attribute att) {
        return attributes.get(att) + getProfessionAttributeBonus(att);
    }
    
    public int getAttributeModifier(Attribute att) {
    	return UnitUtil.calculateModifier(getAttribute(att));
    }
    
    private int getProfessionAttributeBonus(Attribute att) {
    	if (profession == null) {
    		return 0;
    	}
    	return profession.getAttributeBonus(att);
    }

    /**
     * Reduces the unit's health by the specified amount. If the life drops
     * below 0, the unit is killed.
     * @param amount the amount to reduce the healthy by
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
     * @param ability the specified ability
     * @return whether or not the ability was used
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
     * @param other the unit to check allegiance to
     * @return the allegiance to the other unit
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

    /**
     * Sets the unit's profession to the specified profession. A unit's
     * profession provides a set of abilities and a set of attributes in which
     * they are proficient in and receive bonuses for.
     * @param profession the unit's profession
     */
    public void setProfession(Profession profession) {
        this.profession = profession;
    }
}

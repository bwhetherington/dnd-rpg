package com.bwh.game.unit;

import java.util.Map;

/**
 * @author Benjamin Hetherington
 * @since 11/9/2016
 */
public class Profession {
    private Map<Integer, Ability> abilities;
    private String name;
    private Map<Attribute, Integer> attributeBonuses;

    public Profession(String name, Map<Integer, Ability> abilities,
    		Map<Attribute, Integer> attributeBonuses) {
        this.name = name;
        this.abilities = abilities;
        this.attributeBonuses = attributeBonuses;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Ability> getAbilities() {
        return abilities;
    }

    public int getAttributeBonus(Attribute att) {
    	final Integer bonus = attributeBonuses.get(att);
    	return bonus == null ? 0 : bonus;
    }
}

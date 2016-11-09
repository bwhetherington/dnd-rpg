package com.bwh.game.unit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by bwh on 11/7/16.
 */
public class Profession {
    private Map<Integer, Ability> abilities;
    private String name;
    private Set<Attribute> bonusAttributes;

    public Profession(String name, Map<Integer, Ability> abilities, Set<Attribute> bonusAttributes) {
        this.name = name;
        this.abilities = abilities;
        this.bonusAttributes = bonusAttributes;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Ability> getAbilities() {
        return abilities;
    }

    public Set<Attribute> getBonusAttributes() {
        return bonusAttributes;
    }
}

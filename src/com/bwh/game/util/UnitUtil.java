package com.bwh.game.util;

import java.util.EnumMap;
import java.util.Map;

import com.bwh.game.unit.Attribute;
import com.bwh.game.unit.Unit;

/**
 * @author Benjamin Hetherington
 * @since 11/10/2016
 */
public final class UnitUtil {
	private UnitUtil() {}
	
    public static int generateBaseAttribute() {
        final int[] rolls = new int[4];
        for (int i = 0; i < rolls.length; i++) {
            rolls[i] = MathUtil.rollD6();
        }
        final int min = MathUtil.min(rolls);
        int sum = -min;
        for (int roll : rolls) {
            sum += roll;
        }
        return sum;
    }

    public static Map<Attribute, Integer> generateBaseAttributes() {
        final Map<Attribute, Integer> attributes = new EnumMap<>(Attribute.class);
        for (Attribute attribute : Attribute.values()) {
            attributes.put(attribute, generateBaseAttribute());
        }
        return attributes;
    }

    public static Map<Attribute, Integer> calculateModifiers(Map<Attribute, Integer> attributes) {
        final Map<Attribute, Integer> modifiers = new EnumMap<>(Attribute.class);
        for (Map.Entry<Attribute, Integer> pair : attributes.entrySet()) {
            modifiers.put(pair.getKey(), calculateModifier(pair.getValue()));
        }
        return modifiers;
    }

    public static int calculateModifier(int attribute) {
        return (attribute - 10) / 2;
    }

    public static int calculateProficiencyBonus(int level) {
        return level / 2 + 2;
    }
    
    public static int generateLifeStat(Unit unit) {
    	return 10 + unit.getAttributeModifier(Attribute.CONSTITUTION)
    	+ unit.getAttributeModifier(Attribute.STRENGTH);
    }
    
    public static int generateManaStat(Unit unit) {
    	return 10 + unit.getAttributeModifier(Attribute.INTELLIGENCE)
    	+ unit.getAttributeModifier(Attribute.WISDOM);
    }
    
    public static void generateUnitStats(Unit unit) {
    	// Life
    	final int life = generateLifeStat(unit);
    	unit.setLifeMax(life);
    	unit.setLife(life);
    	
    	// Mana
    	final int mana = generateManaStat(unit);
    	unit.setManaMax(mana);
    	unit.setMana(mana);
    	
    	// XP
    	final int xp = generateXPRequirement(unit);
    	unit.setXPMax(xp);
    	unit.setXP(0);
    }
    
    public static int generateXPRequirement(Unit unit) {
    	return generateXPRequirement(unit.getLevel());
    }
    
    /**
     * 1/4 * level^2 + 4 * level + 15
     * @param level
     * @return
     */
    public static int generateXPRequirement(int level) {
    	return 15 + 4 * level + level * level / 4;
    }
    
    public static void main(String[] args) {
    	for (int i = 0; i < 80; i++) {
    		System.out.printf("Level %d: %d%n", i, generateXPRequirement(i));
    	}
    }
}

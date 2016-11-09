package com.bwh.game.util;

import java.util.*;

import com.bwh.game.unit.Attribute;

/**
 * Created by bwh on 11/9/16.
 */
public class UnitUtil {

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

    private static <K, V> void printMap(Map<K, V> map) {
        List<String> pairs = new ArrayList<>(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            pairs.add(String.format("%s:%s", entry.getKey().toString(),
                    entry.getValue().toString()));
        }
        System.out.println(String.format("[%s]", String.join(", ", pairs)));
    }

    public static void main(String[] args) {
        final int[] sample = new int[1000000];
        for (int i = 0; i < sample.length; i++) {
            sample[i] = generateBaseAttribute();
        }
        MathUtil.analyze(sample);
    }

    public static int calculateModifier(int attribute) {
        return (attribute - 10) / 2;
    }

    public static int calculateProficiencyBonus(int level) {
        return level / 2 + 2;
    }
}

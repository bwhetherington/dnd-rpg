package com.bwh.game.unit;

import java.util.HashMap;
import java.util.Map;

import com.bwh.game.util.Pair;

/**
 * @author Benjamin Hetherington
 * @since 11/9/2016
 */
public enum Faction {
    GOOD,
    NEUTRAL,
    EVIL;

    static {
        GOOD.setAllegiances(new Pair<>(EVIL, Allegiance.ENEMY));
        EVIL.setAllegiances(new Pair<>(GOOD, Allegiance.ENEMY));
    }

    private Map<Faction, Allegiance> allegiances;

    Faction() {
        allegiances = new HashMap<>();
    }

    /**
     * @param pairs pairs of factions and their relative l
     */
    @SafeVarargs
	private final void setAllegiances(Pair<Faction, Allegiance>... pairs) {
        allegiances.clear();
        for (Pair<Faction, Allegiance> allegiance : pairs) {
            allegiances.put(allegiance.a, allegiance.b);
        }
    }

    /**
     * Returns the allegiance of this faction to another. If no allegiance has
     * been specified, an allegiance of neutral is assumed.
     * @param other The faction to compare to
     * @return The allegiance with respect to the other faction
     */
    public Allegiance allegianceTo(Faction other) {
        final Allegiance allegiance = allegiances.get(other);
        return allegiance == null ? Allegiance.NEUTRAL : allegiance;
    }
}

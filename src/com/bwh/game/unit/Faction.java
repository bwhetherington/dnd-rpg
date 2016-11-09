package com.bwh.game.unit;

import com.bwh.game.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bwh on 11/9/16.
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

    Faction(Pair<Faction, Allegiance>... pairs) {
        allegiances = new HashMap<>();
    }

    private void setAllegiances(Pair<Faction, Allegiance>... pairs) {
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

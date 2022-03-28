package com.mine.mine;

import java.util.HashSet;
import com.mine.mineral.Mineral;

public class MineralStorage {
    static HashSet<Mineral> minerals = new HashSet<>();

    public static HashSet<Mineral> getMinerals() {
        return minerals;
    }

    public static void addMineral(Mineral mineral) {
        minerals.add(mineral);
    }
}

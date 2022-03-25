package com.mine.mine;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

import com.mine.mineral.Mineral;
import com.mine.people.worker.CartMover;

public class Cart {
    private Queue<Mineral> minerals = new ArrayDeque<Mineral>();
    private static final int MAX_NUMBER_OF_MINERALS = 10;
    private boolean isAtMineralStorage;

    public Cart() {
        this.isAtMineralStorage = false;
    }

    public boolean isAtMineralStorage() {
        return isAtMineralStorage;
    }

    public boolean isFull() {
        return minerals.size() >= MAX_NUMBER_OF_MINERALS;
    }

    public void setAtMineralStorage(boolean atMineralStorage) {
        isAtMineralStorage = atMineralStorage;
    }

    public Queue<Mineral> getMinerals() {
        return minerals;
    }

    /**
     * Loads a mineral to the cart.
     * @param mineral mineral to be loaded
     * @return true if the mineral was added, false if the cart is full
     */
    public boolean loadCart(Mineral mineral) {
        if (!isFull()) {
            minerals.add(mineral);
            return true;
        }
        return false;
    }

    public void unloadCart() {
        minerals.forEach(mineral -> {
            MineralStorage.addMineral(mineral);
        });
        minerals.clear();
    }

}

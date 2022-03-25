package com.mine.people.worker;

import com.mine.mine.Mine;
import com.mine.mineral.*;

public class CartMover extends Worker {
    @Override
    public void work(Mine mine) {
        if (!mine.getCart().isAtMineralStorage() && mine.getCart().isFull()) {
            mine.getCart().setAtMineralStorage(true);
        } else if (mine.getCart().isAtMineralStorage()) {
            mine.getCart().setAtMineralStorage(false);
        }
    }
}

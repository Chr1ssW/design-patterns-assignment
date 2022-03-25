package com.mine.people.decorator;

import com.mine.mine.Mine;
import com.mine.mineral.Mineral;
import com.mine.people.worker.Worker;

public class LoadCart extends WorkTypeDecorator {
    Worker worker;

    public LoadCart(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void work(Mine mine) {
        Mineral nextMineral = mine.getUnloadedMinerals().peek();

        if (!mine.getCart().isAtMineralStorage()) {
            mine.getCart().loadCart(nextMineral);
            mine.getUnloadedMinerals().remove(nextMineral);
        }
    }
}

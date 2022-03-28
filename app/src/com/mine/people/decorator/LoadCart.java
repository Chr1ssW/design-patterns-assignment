package com.mine.people.decorator;

import com.mine.mine.Mine;
import com.mine.mineral.Mineral;
import com.mine.people.worker.Worker;

public class LoadCart extends WorkTypeDecorator {
    Worker worker;

    public LoadCart(Worker worker) {
        this.worker = worker;
    }

    public void work(Mine mine) {
        Mineral nextMineral = mine.getUnloadedMinerals().peek();

        if (!mine.getCart().isAtMineralStorage()) {

            if (!mine.getCart().isFull()) {
                mine.getCart().loadCart(nextMineral);
                mine.getUnloadedMinerals().remove(nextMineral);
            }
        }
    }

    @Override
    public String toString() {
        return "cart loader";
    }
}

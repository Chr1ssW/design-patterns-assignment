package com.mine.people.decorator;

import com.mine.mine.Mine;
import com.mine.mineral.Mineral;
import com.mine.people.worker.Worker;

public class LoadCart extends WorkTypeDecorator {

    public LoadCart(Worker worker) {
        super(worker);
    }

    public void work(Mine mine) {
        worker.work(mine);
        Mineral nextMineral = mine.getUnloadedMinerals().peek();

//        this.getState().executeState(this);
        worker.decreaseHungerMeter(10);
        worker.decreaseSanityMeter(20);
        worker.increaseTimesWorked();

        if (!mine.getCart().isAtMineralStorage()) {

            if (!mine.getCart().isFull()) {
                mine.getCart().loadCart(nextMineral);
                mine.getUnloadedMinerals().remove(nextMineral);
            }
        }
    }

    @Override
    public String toString() {
        return "Cart loader";
    }
}

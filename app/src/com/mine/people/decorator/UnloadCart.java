package com.mine.people.decorator;

import com.mine.mine.Mine;
import com.mine.mineral.Mineral;
import com.mine.people.worker.Worker;

public class UnloadCart extends WorkTypeDecorator{
    public UnloadCart(Worker worker) {
        super(worker);
    }

    @Override
    public void work(Mine mine) {
        worker.work(mine);
        if (mine.getCart().isAtMineralStorage()) {
            mine.getCart().unloadCart();
        }
    }

    @Override
    public String toString() {
        return "Cart unloader";
    }
}
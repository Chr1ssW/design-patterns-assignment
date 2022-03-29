package com.mine.people.worker;

import com.mine.mine.Mine;
import com.mine.mineral.*;

public class Miner extends Worker{

    public Miner() {}

    @Override
    public void work(Mine mine) {
        mine.mineMineral();
    }

    @Override
    public String toString() {
        return "miner";
    }
}

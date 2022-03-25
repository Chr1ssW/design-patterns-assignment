package com.mine.people.worker;

import com.mine.mine.Mine;
import com.mine.mineral.*;

public class Miner extends Worker{

    private Miner() {}

    @Override
    public void work(Mine mine) {
        mine.mineMineral();
    }
}

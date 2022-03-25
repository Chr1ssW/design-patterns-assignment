package com.mine.people.worker;

import com.mine.people.state.State;

public class Miner extends Worker{

    private Miner() {}

    @Override
    public void work(Mine mine) {
        mine.mineMineral();
    }
}

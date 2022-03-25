package com.mine.people.worker;

import com.mine.people.state.State;

public class Miner {
    private int timesWorked;
    private int hungerMeter;
    private int stressMeter;
    private State state;

    public Miner(int timesWorked, int hungerMeter, int stressMeter) {
        this.timesWorked = timesWorked;
        this.hungerMeter = hungerMeter;
        this.stressMeter = stressMeter;
    }

    public int getTimesWorked() {
        return timesWorked;
    }

    public void setTimesWorked(int timesWorked) {
        this.timesWorked = timesWorked;
    }
    public int getHungerMeter() {

        return hungerMeter;
    }

    public void setHungerMeter(int hungerMeter) {
        this.hungerMeter = hungerMeter;
    }

    public int getStressMeter() {
        return stressMeter;
    }

    public void setStressMeter(int stressMeter) {
        this.stressMeter = stressMeter;
    }

    public void doTask() {

    }

    public void update() {

    }
}

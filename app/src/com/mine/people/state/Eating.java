package com.mine.people.state;

import com.mine.people.worker.Worker;

public class Eating extends State{

    @Override
    public void nextState(Worker worker) {
        worker.setState(new Working());
    }

    @Override
    public void executeState(Worker worker) {
        worker.increaseHungerMeter(20);
        worker.increaseSanityMeter(10);
    }

    @Override
    public String toString() {
        return "Eating";
    }
}

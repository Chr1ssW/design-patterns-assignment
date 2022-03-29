package com.mine.people.decorator;

import com.mine.mine.Mine;
import com.mine.people.worker.Worker;

public abstract class WorkTypeDecorator extends Worker {
    protected Worker worker;

    public WorkTypeDecorator(Worker worker) {
        this.worker = worker;
    }
    public abstract void work(Mine mine);
}

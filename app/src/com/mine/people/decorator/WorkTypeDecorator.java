package com.mine.people.decorator;

import com.mine.mine.Mine;
import com.mine.people.worker.Worker;

public abstract class WorkTypeDecorator extends Worker {
    public abstract void work(Mine mine);
}

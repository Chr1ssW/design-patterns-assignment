package com.mine.mine;

import java.util.*;

import com.mine.people.Manager;
import com.mine.people.worker.Worker;
import com.mine.mineral.Mineral;

public abstract class Mine {
    private ArrayList<Worker> workers = new ArrayList<>();
    protected Queue<Mineral> minerals = new ArrayDeque<>();
    private Queue<Mineral> unloadedMinerals = new ArrayDeque<>();
    private Cart cart = new Cart();
    private int maxWorkers;

    public Mine(int maxWorkers) {
        Manager.GetManager().addMine(this);
        this.maxWorkers = maxWorkers;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public void addWorker(Worker worker) {
        if (this.workers.size() < maxWorkers) {
            this.workers.add(worker);
        }
    }

    public Queue<Mineral> getMinerals() {
        return minerals;
    }

    public void mineMineral() {
        Mineral nextMineral = getNextMineral();

        if (nextMineral != null) {
            this.minerals.remove(nextMineral);
            this.unloadedMinerals.add(nextMineral);
        }
    }

    private Mineral getNextMineral() {
        return this.minerals.peek();
    }

    public void addMineral(Mineral mineral) {
        this.minerals.add(mineral);
    }

    public Queue<Mineral> getUnloadedMinerals() {
        return unloadedMinerals;
    }

    public void addUnloadedMineral(Mineral unloadedMineral) {
        this.unloadedMinerals.add(unloadedMineral);
    }

    public Cart getCart() {
        return cart;
    }

    public void addCart(Cart cart) {
        this.cart = cart;
    }

    public int getMaxWorkers() {
        return maxWorkers;
    }

    public abstract Mineral GenerateMineral();

    public void removeOverWorkedWorkers() {
        Iterator workerIterator = workers.iterator();

        while (workerIterator.hasNext()) {
            Worker worker = (Worker) workerIterator.next();
            if (worker.isWorkerOverWorked()) {
                workerIterator.remove();
            }
        }
    }

    public void fireWorker(Worker worker) {
        if (workers.contains(worker)) {
            workers.remove(worker);
        }
    }
}

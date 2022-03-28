package com.mine.mine;

import java.util.*;

import com.mine.people.Manager;
import com.mine.people.worker.Worker;
import com.mine.mineral.Mineral;

public abstract class Mine {
    private HashSet<Worker> workers = new HashSet<>();
    private Queue<Mineral> minerals = new ArrayDeque<Mineral>();
    private Queue<Mineral> unloadedMinerals = new ArrayDeque<Mineral>();
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
        this.workers.add(worker);
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

}

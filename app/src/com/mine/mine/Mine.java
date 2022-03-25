package com.mine.mine;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import com.mine.mineral.*;
import com.mine.people.worker.Worker;

public abstract class Mine {
    private HashSet<Worker> workers = new HashSet<Worker>();
    private Queue<Mineral> minerals = new ArrayDeque<Mineral>();
    private HashSet<Mineral> unloadedMinerals = new HashSet<Mineral>();
    private HashSet<Mineral> loadedMinerals = new HashSet<Mineral>();
    private int maxWorkers;

    public Mine(int maxWorkers) {
        this.maxWorkers = maxWorkers;
    }

    public HashSet<Worker> getWorkers() {
        return workers;
    }

    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }

    public Queue<Mineral> getMinerals() {
        return minerals;
    }

    public void addMineral(Mineral mineral) {
        this.minerals.add(mineral);
    }

    public HashSet<Mineral> getUnloadedMinerals() {
        return unloadedMinerals;
    }

    public void addUnloadedMineral(Mineral unloadedMineral) {
        this.unloadedMinerals.add(unloadedMineral);
    }

    public HashSet<Mineral> getLoadedMinerals() {
        return loadedMinerals;
    }

    public void addLoadedMineral(Mineral loadedMineral) {
        this.loadedMinerals.add(loadedMineral);
    }

    public int getMaxWorkers() {
        return maxWorkers;
    }

    public abstract Mineral GenerateMineral();

}

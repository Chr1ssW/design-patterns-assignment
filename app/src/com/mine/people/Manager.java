package com.mine.people;

import com.mine.mine.Mine;
import com.mine.people.worker.Worker;

import java.util.HashSet;

public class Manager implements Subject{
    private HashSet<Observer> observers = new HashSet<Observer>();
    private HashSet<Mine> mines = new HashSet<Mine>();
    private static Manager managerSingleton;

    private Manager() {

    }

    public static Manager GetManager() {
        if (managerSingleton == null) {
            managerSingleton = new Manager();
        }

        return managerSingleton;
    }

    public HashSet<Mine> getMines() {
        return mines;
    }

    public void addMine(Mine mine) {
        this.mines.add(mine);
    }

    public void removeMine(Mine mine) {
        this.mines.remove(mine);
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer:
             observers) {
            observer.Update();
        }
    }

    public void motivateWorkers() {
        for (Mine mine : this.mines) {
            mine.removeOverWorkedWorkers();
            for (Worker worker : mine.getWorkers()) {
                worker.doTask();
                if (worker.getState() instanceof Working) {
                    worker.work(mine);
                }
            }
        }
    }
}

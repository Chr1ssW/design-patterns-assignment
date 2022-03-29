package com.mine;

import com.mine.mine.GemMine;
import com.mine.mine.Mine;
import com.mine.mine.MineralStorage;
import com.mine.mine.OreMine;
import com.mine.mineral.*;
import com.mine.people.Manager;
import com.mine.people.decorator.LoadCart;
import com.mine.people.decorator.UnloadCart;
import com.mine.people.worker.CartMover;
import com.mine.people.worker.Miner;
import com.mine.people.worker.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private ArrayList<Mine> mines;

    public App(ArrayList<Mine> mines) {
        this.mines = mines;
    }

    public void home() {
        System.out.println(
                """
                           Hello Mr. Manager. What would you like to do today?
                            1. Create a new mine.
                            2. Manage an existing mine.
                            3. Observe mineral storage.
                        """
        );

        try {
            String choice = reader.readLine();

            switch (choice) {
                case "1" -> createMines();
                case "2" -> manageMines();
                case "3" -> observeMineralStorage();
                default -> home();
            }
        } catch (IOException e) {
            home();
        }
    }

    public void observeMineralStorage()
    {
        System.out.println("Number of rubies: " + MineralStorage.getMinerals().stream().filter(mineral -> mineral instanceof RubyGem).count());
        System.out.println("Number of emeralds: " + MineralStorage.getMinerals().stream().filter(mineral -> mineral instanceof EmeraldGem).count());
        System.out.println("Number of gold: " + MineralStorage.getMinerals().stream().filter(mineral -> mineral instanceof GoldOre).count());
        System.out.println("Number of topaz: " + MineralStorage.getMinerals().stream().filter(mineral -> mineral instanceof TopasGem).count());
        System.out.println("Number of silver: " + MineralStorage.getMinerals().stream().filter(mineral -> mineral instanceof SilverOre).count());
        System.out.println("Number of iron: " + MineralStorage.getMinerals().stream().filter(mineral -> mineral instanceof IronOre).count());
        System.out.println("Total value: " + Math.round(MineralStorage.getMinerals().stream().mapToDouble(Mineral::getBatchPrice).sum()));
        System.out.println("Total weight: " + Math.round(MineralStorage.getMinerals().stream().mapToDouble(Mineral::getWeightInKg).sum()));
        System.out.println("Press any button to return to home.");

        try {
            reader.readLine();

            home();
        } catch (IOException e) {
            createMines();
        }
    }

    public void createMines() {
        System.out.println(
                """
                            What kind of mine would you like to create?
                            1. Gem Mine
                            2. OreMine
                            
                            Press `q` to cancel
                        """
        );

        try {
            String choice = reader.readLine();

            switch (choice) {
                case "1" -> createMine(new GemMine());
                case "2" -> createMine(new OreMine());
                case "q" -> home();
                default -> createMines();
            }
        } catch (IOException e) {
            createMines();
        }
    }

    public void createMine(Mine mine) {
        this.mines.add(mine);
        home();
    }

    public void manageMines() {
        if (mines.size() < 1)
        {
            home();
        }

        System.out.println("Which mine would you like to manage?");
        for (int i = 0; i < mines.size(); i++) {
            System.out.println((i + 1) + ". Mine number " + (i + 1));
        }

        try {
            int choice = Integer.parseInt(reader.readLine());

            manageMine(mines.get(choice - 1));
        } catch (Exception e) {
            manageMines();
        }
    }

    public void manageMine(Mine mine) throws Exception {
        if (!mines.contains(mine)) {
            throw new Exception("Mine doesn't exist");
        }

        System.out.println("Mine Status:");
        System.out.println("Number of workers: " + mine.getWorkers().size());
        System.out.println("Unloaded minerals: " + mine.getUnloadedMinerals().size());
        System.out.println("Minerals in cart: " + mine.getCart().getMinerals().size());
        System.out.println("Minerals in storage: " + MineralStorage.getMinerals().size());
        System.out.println("Is cart at mineral storage: " + mine.getCart().isAtMineralStorage());

        System.out.println(
                """
                        What action would you like to perform?
                        1. 'Hire' new workers
                        2. 'Motivate' workers
                        3. Move workers to next state
                        4. Manage specific worker
                            
                        Press `q` to cancel
                        """
        );

        try {
            String choice = reader.readLine();

            switch (choice) {
                case "1" -> purchaseWorker(mine);
                case "2" -> motivateWorkers(mine);
                case "3" -> moveShifts(mine);
                case "4" -> manageWorkers(mine);
                case "q" -> home();
                default -> manageMine(mine);
            }
        } catch (IOException e) {
            manageMine(mine);
        }

        manageMine(mine);
    }

    public void purchaseWorker(Mine mine) {

        System.out.println(
                """
                        Would you like to 'hire' a miner or a cart mover?
                        1. Miner
                        2. Cart Mover
                            
                        Press `q` to cancel
                        """
        );

        try {
            String choice = reader.readLine();

            switch (choice) {
                case "1" -> purchaseMiner(mine);
                case "2" -> purchaseCartMover(mine);
                case "q" -> home();
                default -> purchaseWorker(mine);
            }

            manageMine(mine);
        } catch (Exception e) {
            purchaseWorker(mine);
        }
    }

    public void purchaseMiner(Mine mine) {
        System.out.println("Miner successfully added");
        mine.addWorker(new Miner());
    }

    public void purchaseCartMover(Mine mine) {
        System.out.println("Cart Mover successfully added");
        mine.addWorker(new CartMover());
    }

    public void motivateWorkers(Mine mine) {
        Manager.GetManager().motivateWorkers();
        try {
            manageMine(mine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveShifts(Mine mine) {
        Manager.GetManager().notifyObservers();
        try {
            manageMine(mine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void manageWorkers(Mine mine) {
        if (mine.getWorkers().size() < 1 )
        {
            try {
                manageMine(mine);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Which worker you like to manage?");
        for (int i = 0; i < mine.getWorkers().size(); i++) {
            System.out.println((i + 1) + ". " + mine.getWorkers().get(i).toString() + " number " + (i + 1));
        }

        try {
            int choice = Integer.parseInt(reader.readLine());

            manageWorker(mine.getWorkers().get(choice - 1), mine);
        } catch (Exception e) {
            try {
                manageMine(mine);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void manageWorker(Worker worker, Mine mine) {
        System.out.println("Worker Status: " + worker.getState().toString());
        System.out.println("Worker type: " + worker.getClass());
        System.out.println("Worker Hunger: " + worker.getHungerMeter());
        System.out.println("Worker Sanity: " + worker.getSanityMeter());
        System.out.println("Worker Times Worked: " + worker.getTimesWorked());

        System.out.println(
                """
                        What action would you like to perform?
                        1. Add extra task
                        2. 'Fire' worker
                            
                        Press `q` to cancel
                        """
        );

        try {
            String choice = reader.readLine();

            switch (choice) {
                case "1" -> addWorkerTask(worker, mine);
                case "2" -> fireWorker(worker, mine);
                case "q" -> home();
                default -> manageWorker(worker, mine);
            }
        } catch (IOException e) {
            manageWorker(worker, mine);
        }
    }

    public void addWorkerTask(Worker worker, Mine mine) {
        // don't ask why we did this, and trust that it was necessary.
        final var worker1 = worker;
        mine.getWorkers().forEach(mineWorker -> {
            if (mineWorker.equals(worker1)) {
                mine.getWorkers().remove(mineWorker);

                if (mineWorker instanceof Miner || mineWorker instanceof LoadCart)
                {
                    mine.addWorker(new LoadCart(worker1));
                }
                else if (mineWorker instanceof CartMover)
                {
                    mine.addWorker(new UnloadCart(worker1));
                }
            }
        });
    }

    public void fireWorker(Worker worker, Mine mine) {
        mine.fireWorker(worker);
    }
}

package com.mine;

import com.mine.mine.GemMine;
import com.mine.mine.Mine;
import com.mine.mine.OreMine;

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
                            
                            Press `q` to cancel
                        """
        );

        try {
            String choice = reader.readLine();

            switch (choice) {
                case "1" -> createMines();
                case "2" -> manageMines();
                default -> home();
            }
        } catch (IOException e) {
            home();
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
        System.out.println("Which mine would you like to manage?");
    }

    public void manageMine() {

    }

    public void purchaseWorker() {

    }

    public void motivateWorker() {

    }

    public void moveShifts() {

    }

    public void manageWorker() {

    }

    public void addWorkerTask() {

    }

    public void removeWorkerTask() {

    }

    public void fireWorker() {

    }
}

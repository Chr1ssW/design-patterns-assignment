package com.mine.mineral;

import com.mine.utility.*;

public abstract class Mineral {
    protected double weightInKg;
    protected double purity;
    protected double pricePerKg;

    public double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(double weightInKg) {
        this.weightInKg = weightInKg;
    }

    public double getPurity() {
        return purity;
    }

    public void setPurity(double purity) {
        this.purity = purity;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public double getBatchPrice() {
        return pricePerKg * weightInKg * (purity/100);
    }

    public Mineral(double weightInKg, double purity, double price) {
        this.weightInKg = weightInKg;
        this.purity = purity;
        this.pricePerKg = price;
    }


}

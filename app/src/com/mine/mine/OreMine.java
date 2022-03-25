package com.mine.mine;

import com.mine.utility.Utilities;
import com.mine.mineral.GoldOre;
import com.mine.mineral.IronOre;
import com.mine.mineral.Mineral;
import com.mine.mineral.SilverOre;

public class OreMine extends Mine{
    private static final int MAX_WORKERS = 20;

    public OreMine() {
        super(MAX_WORKERS);
    }

    @Override
    public Mineral GenerateMineral() {
        int rand = (int) Utilities.GetRandomNumber(0, 5);
        double kg = Utilities.GetRandomNumber(0.1, 30);
        double purity = Utilities.GetRandomNumber(0.1, 100);

        return switch (rand) {
            case 0, 1, 2 -> new IronOre(kg, purity);
            case 3, 4 -> new SilverOre(kg, purity);
            case 5 -> new GoldOre(kg, purity);
            default -> throw new RuntimeException("This should never trigger but you better check out OreMine.java");
        };

    }


}

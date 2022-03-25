package com.mine.mine;

import com.mine.utility.Utilities;
import com.mine.mineral.Mineral;
import com.mine.mineral.EmeraldGem;
import com.mine.mineral.RubyGem;
import com.mine.mineral.TopasGem;

public class GemMine extends Mine{
    private static final int MAX_WORKERS = 15;

    public GemMine() {
        super(MAX_WORKERS);
    }

    @Override
    public Mineral GenerateMineral() {
        int rand = (int) Utilities.GetRandomNumber(0, 5);
        double kg = Utilities.GetRandomNumber(0.1, 5);
        double purity = Utilities.GetRandomNumber(0.1, 100);

        switch (rand) {
            case 0:
            case 1:
            case 2:
                return new RubyGem(kg, purity);
            case 3:
            case 4:
                return new TopasGem(kg, purity);
            case 5:
                return new EmeraldGem(kg, purity);
            default:
                throw new RuntimeException("This should never trigger but you better check out GemMine.java");
        }
    }
}

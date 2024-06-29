package fr.kiiow.mixapi.services.compute;

import fr.kiiow.mixapi.models.hench.Hench;

public class HenchDropRate {

    public static Double compute(Hench hench, Integer userLevel, Integer markRate, Integer serverRate) {
        if(markRate <= 0) markRate = 1;
        double baseRate = (hench.getDropRate() * serverRate * markRate);
        int levelDiff = userLevel - hench.getMinimumLevel();

        if(levelDiff >= 10 && levelDiff < 19) {
            baseRate = baseRate * 0.9;
        } else if (levelDiff >= 20 && levelDiff < 29) {
            baseRate = baseRate * 0.8;
        } else if (levelDiff >= 30 && levelDiff < 39) {
            baseRate = baseRate * 0.7;
        } else if (levelDiff >= 40 && levelDiff < 49) {
            baseRate = baseRate * 0.6;
        } else if (levelDiff > 50) {
            baseRate = baseRate * 0.5;
        }

        return Math.min((baseRate / 10000000) * 100, 100);
    }
}

package model;

import java.util.Random;

public class Dice {

    final Random random;
    final int limit;

    public Dice(final int limit) {
        this.limit = limit;
        random = new Random();
    }

    public int roll() {
        return random.nextInt(limit) + 1;
    }
}

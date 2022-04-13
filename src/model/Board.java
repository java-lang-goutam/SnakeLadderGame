package model;

import factory.CellFactory;

public class Board {

    final private int SIZE;
    public static final int UPPER_LIMIT = 1000;
    private Cell[] cells;

    public Board(final int size) {
        if (size > 0 && size <= UPPER_LIMIT) {
            this.SIZE = size + 1;
            cells = CellFactory.initializeCells(SIZE);
        }
        else throw new IllegalArgumentException("Invalid board size supplied !!");
    }
}

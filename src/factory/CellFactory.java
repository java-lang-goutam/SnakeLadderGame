package factory;

import model.Cell;

public class CellFactory {

    private static Cell[] cells;

    private CellFactory(){
        throw new IllegalArgumentException("Use initialize method !");
    }

    public static Cell[] initializeCells(final int size) {
        if (cells != null) return cells;
        cells = new Cell[size];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell(i);
        }
        return cells;
    }

    public static Cell getCell(final int position) {
        if (position < cells.length) {
            return cells[position];
        }
        return null;
    }
}

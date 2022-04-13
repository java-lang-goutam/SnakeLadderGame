package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cell {

    private final int value;
    private List<Pawn> pawns;

    public Cell(final int value) {
        if (value >= 0 && value <= Board.UPPER_LIMIT) {
            this.value = value;
            this.pawns = new ArrayList<>();
        } else {
            throw new IllegalArgumentException("Invalid cell value supplied !!");
        }

    }
    
    public int getValue() {
        return this.value;
    }

    public List<Pawn> getPawns() {
        return this.pawns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return value == cell.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}

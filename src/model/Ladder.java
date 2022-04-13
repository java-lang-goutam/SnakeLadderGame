package model;

import java.util.Objects;

public class Ladder implements Character {

    private final Cell from, to;

    public Ladder(final Cell from, final Cell to) {
        if (from == null || to == null ||  to.getValue() - from.getValue() <= 0 || from.getValue() < 0)
            throw new IllegalArgumentException("Invalid option supplied for ladder !!");
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean canProcess(final Pawn pawn) {
        if (pawn == null) return false;
        return this.from.equals(pawn.getPosition());
    }

    @Override
    public boolean process(final Pawn pawn) {
        if (canProcess(pawn)) {
            pawn.setPosition(to);
            System.out.println(pawn.getColor() + " CLIMBED LADDER, MOVED TO " + to.getValue());
            return true;
        }
        return false;
    }

    @Override
    public Cell getKey() {
        return from;
    }

    @Override
    public CharacterType getType() {
        return CharacterType.LADDER;
    }


    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        final Ladder snake = (Ladder) obj;
        return this.from == snake.from && this.to == snake.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}

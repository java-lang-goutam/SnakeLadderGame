package model;

import java.util.Objects;

public class Snake implements Character {

    private final Cell from, to;

    public Snake(final Cell from, final Cell to) {
        if (from == null || to == null || from.getValue() - to.getValue() <= 0 || to.getValue() < 0)
            throw new IllegalArgumentException("Invalid option supplied for snake !!");
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
            System.out.println(pawn.getColor() + " CUT BY SNAKE, MOVED TO " + to.getValue());
            pawn.setPosition(to);
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
        return CharacterType.SNAKE;
    }


    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        final Snake snake = (Snake) obj;
        return this.from == snake.from && this.to == snake.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}

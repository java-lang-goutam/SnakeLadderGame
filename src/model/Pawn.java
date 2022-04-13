package model;

import factory.CellFactory;

public class Pawn {

    private final Color color;
    private Cell position;
    private boolean isActive;

    public Pawn(final Color color, final Cell position) {
        if (color == null || position == null) {
            throw new IllegalArgumentException("Invalid color or position !!");
        }
        this.color = color;
        this.position = position;
        this.isActive = true;
    }

    public void move(int value) {
        position.getPawns().remove(this);
        this.position = CellFactory.getCell(this.position.getValue() + value);
        position.getPawns().add(this);
    }

    public Color getColor() {
        return this.color;
    }

    public Cell getPosition() {
        return this.position;
    }

    public void setPosition(final Cell position) {
        this.position = position;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void disable() {
        this.isActive = false;
    }
}

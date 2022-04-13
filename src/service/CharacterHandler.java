package service;

import model.Character;
import model.Pawn;

public abstract class CharacterHandler {

    protected CharacterHandler nextHandler;

    public void setNextHandler(final CharacterHandler handler) {
        this.nextHandler = handler;
    }

    public abstract void addCharacter(final Character character);
    public abstract void handle(Pawn pawn);
}

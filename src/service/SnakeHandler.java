package service;

import model.Cell;
import model.Character;
import model.CharacterType;
import model.Pawn;
import model.Snake;

import java.util.HashMap;
import java.util.Map;

public class SnakeHandler extends CharacterHandler {

    final Map<Cell, Snake> snakes;

    public SnakeHandler() {
        snakes = new HashMap<>();
    }

    @Override
    public void addCharacter(Character character) {
        if (character.getType() == CharacterType.SNAKE) {
            snakes.put(character.getKey(), (Snake) character);
        } else {
            if (nextHandler != null)
                nextHandler.addCharacter(character);
        }
    }

    @Override
    public void handle(final Pawn pawn) {
        if (snakes.containsKey(pawn.getPosition())) {
            final Snake snake = snakes.get(pawn.getPosition());
            snake.process(pawn);
        } else {
            if (nextHandler != null) nextHandler.handle(pawn);
        }
    }
}

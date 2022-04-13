package service;

import model.Cell;
import model.Character;
import model.CharacterType;
import model.Ladder;
import model.Pawn;

import java.util.HashMap;
import java.util.Map;

public class LadderHandler extends CharacterHandler {

    final Map<Cell, Ladder> ladders;

    public LadderHandler() {
        ladders = new HashMap<>();
    }

    @Override
    public void addCharacter(Character character) {
        if (character.getType() == CharacterType.LADDER) {
            ladders.put(character.getKey(), (Ladder) character);
        } else {
            if (nextHandler != null)
                nextHandler.addCharacter(character);
        }
    }

    @Override
    public void handle(final Pawn pawn) {
        if (ladders.containsKey(pawn.getPosition())) {
            final Ladder ladder = ladders.get(pawn.getPosition());
            ladder.process(pawn);
        } else {
            if (nextHandler != null)
                nextHandler.handle(pawn);
        }
    }
}

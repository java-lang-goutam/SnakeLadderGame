package model;

public interface Character {

    boolean canProcess(Pawn pawn);

    boolean process(Pawn pawn);

    Cell getKey();

    CharacterType getType();
}

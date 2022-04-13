import factory.CellFactory;
import model.Board;
import model.Color;
import model.Dice;
import model.Ladder;
import model.Pawn;
import model.Snake;
import service.CharacterHandler;
import service.LadderHandler;
import service.SnakeHandler;

import java.util.ArrayList;
import java.util.List;

public class Game {

    final public int BOARD_SIZE;
    final private List<Pawn> players;
    private int chance = 0;
    int activePlayers = 0;
    final Board board;
    final Dice dice;
    final CharacterHandler handler;

    public Game(final int boardSize, final int diceLimit) {
        BOARD_SIZE = boardSize;
        board = new Board(boardSize);
        dice = new Dice(diceLimit);
        players = new ArrayList<>();
        handler = new SnakeHandler();
        handler.setNextHandler(new LadderHandler());
    }

    public void addPlayer(final Color color) {

        if (this.players.size() == Color.values().length) {
            throw new UnsupportedOperationException("Max players added !");
        }

        final Pawn pawn = new Pawn(color, CellFactory.getCell(0));

        if (players.contains(pawn)) {
            System.out.println("Player already added !");
        } else {
            players.add(pawn);
            activePlayers++;
        }
    }

    public void addSnake(final int from, final int to) {
        handler.addCharacter(new Snake(CellFactory.getCell(from), CellFactory.getCell(to)));
    }

    public void addLadder(final int from, final int to) {
        handler.addCharacter(new Ladder(CellFactory.getCell(from), CellFactory.getCell(to)));
    }

    public void rollDice(final Pawn pawn) {

        if (pawn == null || !pawn.isActive()) return;

        final int value = dice.roll();
        System.out.printf("Rolling dice for %s, value : %d%n", pawn.getColor(), value);
        System.out.println(pawn.getColor() + " moved from " + pawn.getPosition().getValue() + " to " + (pawn.getPosition().getValue() + value));

        if (pawn.getPosition().getValue() + value > BOARD_SIZE) {
            pawn.disable();
            activePlayers--;
            System.out.println(pawn.getColor() + " Won, ELIMINATING ...");
        } else {
            pawn.move(value);
            handler.handle(pawn);
        }

        System.out.println();
    }

    public void play() {

        while (activePlayers > 1) {
            chance %= players.size();
            rollDice(players.get(chance++));
        }

        final Pawn loser = players.stream().filter(Pawn::isActive).findFirst().get();

        System.out.println("Game finished ..." + loser.getColor() + " lost.");
    }

    public static void main(String[] args) {
        int size = 1000;
        Game game = new Game(size, 12);
        game.addPlayer(Color.RED);
        game.addPlayer(Color.BLUE);
        game.addPlayer(Color.GREEN);
        game.addPlayer(Color.YELLOW);

        game.addLadder(10, 20);
        game.addLadder(20, 30);
        game.addLadder(40, 50);
        game.addLadder(60, 70);
        game.addLadder(80, 90);

        game.addSnake(95, 85);
        game.addSnake(75, 65);
        game.addSnake(55, 45);
        game.addSnake(35, 25);
        game.addSnake(15, 5);

        game.play();
    }
}

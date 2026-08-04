package org.example.Lesson15;

import java.util.ArrayList;
import java.util.List;

public class GameRental {

    List<BoardGame> boardGameList = new ArrayList<>();

    void addBoardGame(BoardGame game) {
        if (game == null) throw new IllegalArgumentException("Игра не может быть null");
        boolean isDuplicate = boardGameList.stream()
                .anyMatch(x -> x.getName().equalsIgnoreCase(game.getName()));
        if (isDuplicate) {
            throw new IllegalArgumentException("Игра с таким названием уже существует");
        }
        boardGameList.add(game);
    }

    BoardGame searchTheGame(String gameName) {
        return boardGameList.stream()
                .filter(game -> game.getName().equalsIgnoreCase(gameName))
                .findFirst()
                .orElse(null);
    }

    public boolean rentGame(String name, int customerAge) {
        BoardGame game = searchTheGame(name);
        if (game == null) {
            throw new IllegalArgumentException("Игры с названием '" + name + "' не существует в каталоге.");
        }
        if (!game.canBeRentedBy(customerAge)) {
            return false;
        }
        if (game.getIsGameRented()) {
            return false;
        }
        game.setGameRented(true);
        return true;
    }

    public boolean returnGame(String name) {
        BoardGame game = searchTheGame(name);
        if (game == null) {
            return false;
        }
        if (!game.getIsGameRented()) {
            return false;
        }
        game.setGameRented(false);
        return true;
    }

    int calculateCost(String name, int days) {
        BoardGame game = searchTheGame(name);
        if (game == null || days <= 0) {
            throw new IllegalArgumentException("Игры с названием '" + name + "' не существует в каталоге.");
        }

        return game.rentalCostForOneDay * days;
    }

    public void reset() {
        boardGameList.forEach(game -> game.setGameRented(false));
    }
}

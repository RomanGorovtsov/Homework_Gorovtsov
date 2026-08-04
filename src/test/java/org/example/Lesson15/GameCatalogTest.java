package org.example.Lesson15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameCatalogTest {

    private GameRental catalog;
    private BoardGame carcassonne;

    @BeforeEach
    void setUp() {
        catalog = new GameRental();
        carcassonne = new BoardGame("Каркассон", 8, 250);
        catalog.addBoardGame(carcassonne);
    }

    @Test
    @DisplayName("Успешный поиск игры по названию (без учета регистра)")
    void shouldFindGameByNameIgnoreCase() {
        BoardGame foundGame = catalog.searchTheGame("кАрКаСсОн");
        assertNotNull(foundGame);
        assertEquals("Каркассон", foundGame.getName());
    }

    @Test
    @DisplayName("Возврат null при поиске несуществующей игры")
    void shouldReturnNullWhenGameNotFound() {
        assertNull(catalog.searchTheGame("Мафия"));
    }

    @Test
    @DisplayName("Исключение при добавлении null или дубликата игры")
    void shouldThrowExceptionOnNullOrDuplicate() {
        assertThrows(IllegalArgumentException.class, () -> catalog.addBoardGame(null));

        // Создаем игру с таким же именем, но другими параметрами
        BoardGame duplicateGame = new BoardGame("КАРКАССОН", 12, 400);
        assertThrows(IllegalArgumentException.class, () -> catalog.addBoardGame(duplicateGame));
    }
}

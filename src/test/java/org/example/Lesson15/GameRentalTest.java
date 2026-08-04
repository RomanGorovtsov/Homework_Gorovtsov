package org.example.Lesson15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameRentalTest {

    private GameRental rentalService;

    @BeforeEach
    void setUp() {
        rentalService = new GameRental();
        rentalService.addBoardGame(new BoardGame("Монополия", 12, 300));
        rentalService.addBoardGame(new BoardGame("Доббль", 6, 150));
    }

    @ParameterizedTest
    @MethodSource("provideRentScenarios")
    @DisplayName("Проверка различных сценариев аренды игр")
    void shouldTestRentScenarios(String gameName, int age, boolean expectedResult) {
        assertEquals(expectedResult, rentalService.rentGame(gameName, age));
    }

    // Фабричный метод для MethodSource (должен быть static)
    private static Stream<Arguments> provideRentScenarios() {
        return Stream.of(
                Arguments.of("Монополия", 15, true),
                Arguments.of("Монополия", 10, false),
                Arguments.of("Доббль", 7, true)
        );
    }

    @Test
    @DisplayName("Исключение при аренде несуществующей игры")
    void shouldThrowExceptionWhenRentNonExistentGame() {
        assertThrows(IllegalArgumentException.class, () -> rentalService.rentGame("Несуществующая игра", 20));
    }

    @Test
    @DisplayName("Нельзя арендовать уже арендованную игру")
    void shouldNotRentAlreadyRentedGame() {
        assertTrue(rentalService.rentGame("Доббль", 10));
        assertFalse(rentalService.rentGame("Доббль", 20)); // Повторная аренда должна вернуть false
    }

    @Test
    @DisplayName("Успешный возврат арендованной игры")
    void shouldReturnRentedGame() {
        rentalService.rentGame("Монополия", 20);

        assertTrue(rentalService.returnGame("Монополия")); // Успешный возврат
        assertFalse(rentalService.returnGame("Монополия")); // Повторный возврат вернет false
        assertFalse(rentalService.returnGame("Несуществующая")); // Возврат несуществующей вернет false
    }

    @Test
    @DisplayName("Сброс состояния делает все игры снова доступными")
    void shouldResetAllGamesToAvailable() {
        rentalService.rentGame("Монополия", 20);
        rentalService.rentGame("Доббль", 20);

        rentalService.reset();

        assertTrue(rentalService.rentGame("Монополия", 20));
        assertTrue(rentalService.rentGame("Доббль", 20));
    }
}

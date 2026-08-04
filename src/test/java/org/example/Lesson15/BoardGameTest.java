package org.example.Lesson15;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BoardGameTest {

    @Test
    @DisplayName("Исключение при некорректных параметрах конструктора")
    void shouldThrowExceptionOnInvalidConstructorArguments() {
        assertThrows(IllegalArgumentException.class, () -> new BoardGame(null, 12, 500));
        assertThrows(IllegalArgumentException.class, () -> new BoardGame("", 12, 500));
        assertThrows(IllegalArgumentException.class, () -> new BoardGame("Шахматы", -1, 500));
        assertThrows(IllegalArgumentException.class, () -> new BoardGame("Шахматы", 12, 0));
    }

    @ParameterizedTest
    @CsvSource({
            "10, true",  // Возраст равен минимальному -> можно играть
            "15, true",  // Возраст больше минимального -> можно играть
            "5, false"   // Возраст меньше минимального -> нельзя играть
    })

    @DisplayName("Проверка возрастного ограничения игры (минимальный возраст: 10)")
    void shouldVerifyAgeRestrictions(int customerAge, boolean expectedResult) {
        BoardGame game = new BoardGame("Монополия", 10, 300);
        assertEquals(expectedResult, game.canBeRentedBy(customerAge));
    }
}

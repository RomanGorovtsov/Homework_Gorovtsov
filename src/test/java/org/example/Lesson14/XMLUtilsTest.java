package org.example.Lesson14;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class XMLUtilsTest {


    @Test
    void testForValidTag() {
        String input = "bentley";
        String expected = "<bentley></bentley>";

        String actual = XMLUtils.createEmptyElement(input);

        assertEquals(expected, actual, "Ошибка в формировании тега!");
    }

    @Test
    void testForInvalidTag() {
        String input = "";
        String expected = "<invalid/>";

        String actual = XMLUtils.createEmptyElement(input);

        assertEquals(expected, actual, "Ошибка в формировании тега!");
    }

    @Test
    void negativeTestForValidTag() {
        String input = "invalid";
        String expected = "<invalid/>";

        String actual = XMLUtils.createEmptyElement(input);

        assertNotEquals(expected, actual, "Ошибка в формировании тега!");
    }

}

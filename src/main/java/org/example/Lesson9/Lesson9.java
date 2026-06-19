package org.example.Lesson9;

import com.github.lalyos.jfiglet.FigletFont;
import net.datafaker.Faker;

import java.io.IOException;
import java.util.Random;

public class Lesson9 {

    private static final String[] SURNAMES = {"Ernst", "Dolce", "Smith", "Johnson", "Baker"};
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws IOException {
        // 1. Получаем первую случайную фамилию из собственного массива
        String part1 = getRandomSurname();

        // 2. Вторая часть — символ амперсанда
        String part2 = "&";

        // 3. Получаем вторую случайную фамилию с помощью Datafaker
        Faker faker = new Faker();
        String part3 = faker.name().lastName();

        // 4. Преобразуем каждую строку в ASCII
        String asciiPart1 = FigletFont.convertOneLine(part1);
        String asciiPart2 = FigletFont.convertOneLine(part2);
        String asciiPart3 = FigletFont.convertOneLine(part3);


        System.out.printf("%s%n%s%n%s%n",
                asciiPart1,
                asciiPart2,
                asciiPart3
        );

        System.out.printf("%s%n%s%n%s%n",
                faker.address().fullAddress(),
                faker.phoneNumber().phoneNumber(),
                faker.name().fullName()
        );
    }

    private static String getRandomSurname() {
        int randomIndex = RANDOM.nextInt(SURNAMES.length);
        return SURNAMES[randomIndex];
    }
}


package org.example.Lesson15;

import java.util.Objects;

public class BoardGame {

    String name;
    int minimalGamerAge;
    int rentalCostForOneDay;
    boolean isGameRented;

    public BoardGame(String name, int minimalGamerAge, int rentalCostForOneDay) {

        if (name == null) throw new IllegalArgumentException("Ошибка.Имя не может быть равным null");
        if (name.isEmpty()) throw new IllegalArgumentException("Ошибка.Название не может быть пустым");
        if (minimalGamerAge < 0) throw new IllegalArgumentException("Ошибка.Минимальный возраст меньше нуля");
        if (rentalCostForOneDay <= 0) throw new IllegalArgumentException("Ошибка.Стоимость аренды меньше или равна нулю");

        this.name = name;
        this.minimalGamerAge = minimalGamerAge;
        this.rentalCostForOneDay = rentalCostForOneDay;
    }

    public boolean canBeRentedBy(int age){
        return age >= minimalGamerAge;
    }

    public String getName() {
        return name;
    }

    public int getMinimalGamerAge() {
        return minimalGamerAge;
    }

    public int getRentalCostForOneDay() {
        return rentalCostForOneDay;
    }

    public boolean getIsGameRented() {
        return isGameRented;
    }

    public void setGameRented(boolean gameRented) {
        isGameRented = gameRented;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BoardGame boardGame = (BoardGame) o;
        return Objects.equals(name, boardGame.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "name='" + name + '\'' +
                ", minimalGamerAge=" + minimalGamerAge +
                ", rentalCostForOneDay=" + rentalCostForOneDay +
                ", isGameRented=" + isGameRented +
                '}';
    }
}

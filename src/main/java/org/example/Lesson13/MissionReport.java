package org.example.Lesson13;

import java.util.List;
import java.util.Objects;

public class MissionReport {
    private String missionName;
    private List<Alien> capturedAliens;
    private int squadSize;

    // Конструктор для инициализации полей
    public MissionReport(String missionName, List<Alien> capturedAliens, int squadSize) {
        this.missionName = missionName;
        this.capturedAliens = capturedAliens;
        this.squadSize = squadSize;
    }

    // Требование: Красивый и читаемый вывод отчета
    @Override
    public String toString() {
        return "Миссия: " + missionName + "\n" +
                "Поймано пришельцев: " + (capturedAliens != null ? capturedAliens.size() : 0) + "\n" +
                "Размер отряда: " + squadSize;
    }

    // Переопределение equals для корректного сравнения отчетов по содержимому
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MissionReport that = (MissionReport) o;
        return squadSize == that.squadSize &&
                Objects.equals(missionName, that.missionName) &&
                Objects.equals(capturedAliens, that.capturedAliens);
    }

    // Переопределение hashCode в паре с equals
    @Override
    public int hashCode() {
        return Objects.hash(missionName, capturedAliens, squadSize);
    }
}

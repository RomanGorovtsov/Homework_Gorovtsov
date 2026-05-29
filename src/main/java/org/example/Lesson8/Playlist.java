package org.example.Lesson8;

import java.util.ArrayList;

public class Playlist {

    //конструкторы
    public Playlist() {}

    public Playlist(String nameOfThePlaylist) {
        this.nameOfThePlaylist = nameOfThePlaylist;
    }


    //переменные
    private String nameOfThePlaylist;
    private final ArrayList<String> listOfSongs = new ArrayList<>();


    public void addSongToThePlaylist(String songName){
        listOfSongs.add(songName);
        System.out.printf("Добавлена песня: %s%n", songName);
    }

    public void deleteSongFromThePlaylist(int indexOfSongName){
        if (!isIndexValid(indexOfSongName)) return;
        String removedSong = listOfSongs.get(indexOfSongName);
        listOfSongs.remove(indexOfSongName);
        System.out.printf("Удалена песня: %s%n", removedSong);
    }

    public void updateSongInThePlaylist(int indexOfSongName, String songName){
        if (!isIndexValid(indexOfSongName)) return;
        String currentSongAtThisIndex = listOfSongs.get(indexOfSongName);
        listOfSongs.set(indexOfSongName, songName);
        System.out.printf("Обновлена песня: %s, вместо %s%n", songName, currentSongAtThisIndex);
    }

    public void getSongFromThePlaylist(int indexOfSongName){
        if (!isIndexValid(indexOfSongName)) return;
        System.out.printf("Получена песня: %s%n", listOfSongs.get(indexOfSongName));
    }

    //метод, который проверяет валидные значения вводимого индекса (не отрицательное число и не за границами листа)
    private boolean isIndexValid (int indexOfSongName) {
        if (indexOfSongName < 0 || indexOfSongName >= listOfSongs.size()) {
            System.out.println("Данный индекс выходит за рамки ArrayList");
            return false;
        }
        return true;
    }

    //переопределенный toString для красивого вывода
    @Override
    public String toString() {
        return "Playlist " +
                "'" + nameOfThePlaylist + "'"+
                ", содержит песни = " + listOfSongs;
    }
}

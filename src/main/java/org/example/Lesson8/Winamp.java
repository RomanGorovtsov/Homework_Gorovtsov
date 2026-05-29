package org.example.Lesson8;

public class Winamp {

    public static void main(String[] args) {
        Playlist playlist = new Playlist("The best songs");

        playlist.addSongToThePlaylist("Blinding Lights");
        playlist.addSongToThePlaylist("Shape of You");
        playlist.addSongToThePlaylist("Someone You Loved");
        playlist.addSongToThePlaylist("Sunflower");
        playlist.getSongFromThePlaylist(2);
        playlist.updateSongInThePlaylist(3, "Billie Jean");
        playlist.deleteSongFromThePlaylist(2);

        System.out.println(playlist);
    }
}

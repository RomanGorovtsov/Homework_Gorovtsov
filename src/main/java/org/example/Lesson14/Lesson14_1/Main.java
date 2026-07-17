package org.example.Lesson14.Lesson14_1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Интерстеллар", 8.7));
        movies.add(new Movie("Шрек", 8.1));
        movies.add(new Movie("Начало", 8.8));
        movies.add(new Movie("Веном", 6.6));

        for (Movie movie: movies){
            System.out.println(movie);
        }

        System.out.println(" ");
        movies.sort(new MovieRatingComparator());
        for (Movie movie: movies){
            System.out.println(movie);
        }
    }
}

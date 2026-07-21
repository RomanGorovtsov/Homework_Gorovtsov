package org.example.Lesson14.Lesson14_1;

import java.util.Comparator;

public class MovieRatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        return (o1.getMovieRating()).compareTo(o2.getMovieRating());
    }
}

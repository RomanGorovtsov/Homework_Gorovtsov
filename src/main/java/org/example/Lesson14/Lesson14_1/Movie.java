package org.example.Lesson14.Lesson14_1;

public class Movie {

    private String movieName;
    private Double movieRating;

    Movie(String movieName, Double movieRating){
        this.movieName = movieName;
        this.movieRating = movieRating;
    }

    public String getMovieName() {
        return movieName;
    }

    public Double getMovieRating() {
        return movieRating;
    }

    @Override
    public String toString() {
        return "MovieName = " + movieName + ", movieRating = " + movieRating;
    }
}

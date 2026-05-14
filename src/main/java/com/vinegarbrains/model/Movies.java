package com.vinegarbrains.model;

import java.time.LocalDate;

public class Movies {
    // Fields matching your MySQL table columns
    private int id;
    private String title;
    private String overview;
    private double rating;
    private String posterPath;
    private LocalDate releaseDate;

    // 1. Constructor: To create a Movie object when fetching from API or DB
    public Movies(int id, String title, String overview, double rating, String posterPath, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.rating = rating;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
    }

    // 2. Getters: Needed by JavaFX to display data in the UI
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getOverview() { return overview; }
    public double getRating() { return rating; }
    public String getPosterPath() { return posterPath; }
    public LocalDate getReleaseDate() { return releaseDate; }

    // 3. Setters: Useful if you need to update a specific field later
    public void setTitle(String title) { this.title = title; }
    public void setRating(double rating) { this.rating = rating; }

    // 4. toString method: Very helpful for debugging/printing to console
    @Override
    public String toString() {
        return String.format("Movie[ID=%d, Title='%s', Rating=%.1f]", id, title, rating);
    }
}
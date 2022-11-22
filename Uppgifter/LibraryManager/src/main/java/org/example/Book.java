package org.example;

import java.util.ArrayList;

public class Book {

    private String title;
    private String genre;
    private String authorName;
    private int publishYear;
    private ArrayList<Integer> score;
    private boolean isBorrowed;

    public Book(String title, String genre, String authorName, int publishYear, ArrayList<Integer> score) {
        this.title = title;
        this.genre = genre;
        this.authorName = authorName;
        this.publishYear = publishYear;
        this.score = score;
        isBorrowed = false;
    }

    public double getAverageScore(){
        int total = 0;
        for (Integer item: score) {
            total += item;
        }
        double result = total / score.size();
        System.out.println(result);
        return result;
    }
}

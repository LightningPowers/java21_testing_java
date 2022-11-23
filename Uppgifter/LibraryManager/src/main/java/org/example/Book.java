package org.example;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class Book {

    private final String title;
    private final String genre;
    private final String authorName;
    private final int publishYear;
    private final ArrayList<Integer> score;
    private final ArrayList<String> comments;
    private boolean isBorrowed;
    private int maxBorrowDays;

    public Book(String title, String genre, String authorName, int publishYear) {
        this.title = title;
        this.genre = genre;
        this.authorName = authorName;
        this.publishYear = publishYear;
        this.score = new ArrayList<>();
        this.comments = new ArrayList<>();
        isBorrowed = false;
        maxBorrowDays = 30;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public double getAverageScore(){
        int total = 0;
        for (Integer item: score) {
            total += item;
        }
        double result = (double) total / score.size();
        //System.out.println(result);

        //Formats result and sets decimal separator to '.'
        DecimalFormatSymbols decimalSymbols = DecimalFormatSymbols.getInstance();
        decimalSymbols.setDecimalSeparator('.');
        return Double.parseDouble(new DecimalFormat("0.0", decimalSymbols).format(result));
    }

    public void addScore(int scoreToAdd){
        if (scoreToAdd < 0){
            scoreToAdd = 0;
        } else if (scoreToAdd > 10) {
            scoreToAdd = 10;
        }
        score.add(scoreToAdd);
    }

    public String getComment(int index){
        return comments.get(index);
    }

    public ArrayList<String> getComments(){
        return comments;
    }

    public void addComment(String commentToAdd){
        comments.add(commentToAdd);
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public int getMaxBorrowDays() {
        return maxBorrowDays;
    }

    public void setMaxBorrowDays(int maxBorrowDays) {
        this.maxBorrowDays = maxBorrowDays;
    }
}
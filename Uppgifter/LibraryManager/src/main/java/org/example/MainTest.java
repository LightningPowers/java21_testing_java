package org.example;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    public void TestBookScoreList(){
        Book book = new Book("50 Shades of Gray", "Comedy", "Jane Austen", 1984);
        book.addScore(1);
        book.addScore(4);
        book.addScore(-22);
        System.out.println((book.getAverageScore()));
    }

    @Test
    public void TestComments(){
        Book book = new Book("Faster Than The Speed of Love", "Romance", "Brian Griffin", 2012);
        book.addComment("Terrible read, reading every single line was painful.");
        book.addComment("This book truly inspired me, now I will never become an author!");
        System.out.println(book.getComment(1));
    }

}
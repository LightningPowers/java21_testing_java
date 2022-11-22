package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class MainTest {

    @Test
    public void TestBookList(){
        ArrayList<Integer> tempScoreList = new ArrayList<>(Arrays.asList(1, 3, 5, 6, 7, 9, 10));
        Book book = new Book("50 Shades of Gray", "Comedy", "Jane Austen", 2012, tempScoreList);
        book.getAverageScore();
    }

}
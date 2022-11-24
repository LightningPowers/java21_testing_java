package org.example.services;

import org.example.Book;

import java.util.ArrayList;

public class BorrowService {

    private static final int borrowPrice = 100;

    //Calculate what it would cost to borrow a book
    public double calculateBorrowCost(ArrayList<Book> bookList, String bookTitle){
        double returnValue = 0.0;

        for(Book book: bookList){
            if(book.getTitle().equals(bookTitle)){
                returnValue = book.getMaxBorrowDays() * borrowPrice;
            }
        }
        return returnValue;
    }

    //Borrow a specified book from the library
    public boolean borrowBook(ArrayList<Book> bookList, String bookTitle){
        boolean returnValue = false;

        for(Book book: bookList){
            if(book.getTitle().equals(bookTitle) && !book.isBorrowed()){
                book.setBorrowed(true);
                returnValue = true;
            }
        }
        return returnValue;
    }

    //Return a borrowed book from the library
    public boolean returnBook(ArrayList<Book> bookList, String bookTitle){
        boolean returnValue = false;

        for(Book book: bookList){
            if(book.getTitle().equals(bookTitle) && !book.isBorrowed()){
                book.setBorrowed(false);
                returnValue = true;
            }
        }
        return returnValue;
    }

    //Add comment to book that is currently borrowed
    public boolean addComment(ArrayList<Book> bookList, String bookTitle, String comment){
        boolean returnValue = false;

        for(Book book: bookList){
            if(book.getTitle().equals(bookTitle) && book.isBorrowed()){
                book.addComment(comment);
                returnValue = true;
            }
        }
        return returnValue;
    }

    //Add score to book that is currently borrowed
    public boolean addScore(ArrayList<Book> bookList, String bookTitle, int score){
        boolean returnValue = false;

        for(Book book: bookList){
            if(book.getTitle().equals(bookTitle) && book.isBorrowed()){
                book.addScore(score);
                returnValue = true;
            }
        }
        return returnValue;
    }


}

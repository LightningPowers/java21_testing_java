package org.example.services;

import org.example.Book;

import java.util.ArrayList;

public class BorrowService {

    // Borrow a specified book from the library
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

}

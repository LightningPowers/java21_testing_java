package org.example.services;

import org.example.Book;

import java.util.ArrayList;

public class LibraryService {

    private BorrowService borrowService;
    private SearchService searchService;
    private ArrayList<Book> storedBooks;
    private static final int borrowPrice = 75;

    public LibraryService(BorrowService borrowService, SearchService searchService, ArrayList<Book> storedBooks) {
        this.borrowService = borrowService;
        this.searchService = searchService;
        this.storedBooks = storedBooks;
    }
}

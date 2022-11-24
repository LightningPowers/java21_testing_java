package org.example.services;

import org.example.Book;

import java.util.ArrayList;

public class LibraryService {

    private final BorrowService borrowService;
    private final SearchService searchService;

    //Stores books that are used for borrowing and searching
    private final ArrayList<Book> storedBooks;


    public LibraryService(BorrowService borrowService, SearchService searchService, ArrayList<Book> storedBooks) {
        this.borrowService = borrowService;
        this.searchService = searchService;
        this.storedBooks = storedBooks;
    }

    public ArrayList<Book> getBooks() {
        return storedBooks;
    }

    public BorrowService getBorrowService() {
        return borrowService;
    }

    public SearchService getSearchService() {
        return searchService;
    }
}

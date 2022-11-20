package org.example.services;

public class LibraryService {

    private BorrowService borrowService;
    private SearchService searchService;
    private static final int borrowPrice = 75;

    public LibraryService(BorrowService borrowService, SearchService searchService) {
        this.borrowService = borrowService;
        this.searchService = searchService;
    }
}

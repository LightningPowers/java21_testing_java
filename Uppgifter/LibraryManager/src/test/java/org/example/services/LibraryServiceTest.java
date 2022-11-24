package org.example.services;

import org.example.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LibraryServiceTest {

    @Mock
    private BorrowService mockBorrowService;

    @Mock
    private SearchService mockSearchService;

    @Mock
    private ArrayList<Book> mockBookList;

    @Mock
    private LibraryService library;


    //Testing BorrowService calculate cost method
    @Test
    public void testCalculateBorrowCost(){
        Book book1 = new Book("50 Shades of Gray", "Romance", "E.L. James", 2011);
        Book book2 = new Book("Faster Than The Speed of Love", "Romance", "Brian Griffin", 2012);
        Book book3 = new Book("The Hobbit", "Fantasy", "J.R.R. Tolkien", 1937);
        ArrayList<Book> bookList = new ArrayList<>(Arrays.asList(book1,book2,book3));
        when(library.getBooks()).thenReturn(bookList);

        BorrowService borrowService = new BorrowService();

        double expected = 3000;
        double actual = borrowService.calculateBorrowCost(library.getBooks(), "Faster Than The Speed of Love");

        assertEquals(expected,actual);
    }

    //Testing borrowing a book that is already borrowed
    @Test
    public void testForBorrowBorrowedBookException() throws Exception {
        Book book1 = new Book("50 Shades of Gray", "Romance", "E.L. James", 2011);
        Book book2 = new Book("Faster Than The Speed of Love", "Romance", "Brian Griffin", 2012);
        Book book3 = new Book("The Hobbit", "Fantasy", "J.R.R. Tolkien", 1937);
        ArrayList<Book> bookList = new ArrayList<>(Arrays.asList(book1,book2,book3));
        when(library.getBooks()).thenReturn(bookList);

        BorrowService borrowService = new BorrowService();
        borrowService.borrowBook(library.getBooks(),"The Hobbit");

        assertThrows(Exception.class, () -> borrowService.borrowBook(library.getBooks(), "The Hobbit"));
    }

}
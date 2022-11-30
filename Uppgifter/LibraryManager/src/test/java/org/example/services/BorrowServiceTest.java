package org.example.services;

import org.example.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BorrowServiceTest {

    @Spy
    private BorrowService spyBorrowService;

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

        double expected = 3000;
        double actual = spyBorrowService.calculateBorrowCost(library.getBooks(), "Faster Than The Speed of Love");

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

        spyBorrowService.borrowBook(library.getBooks(),"The Hobbit");

        assertThrows(Exception.class, () -> spyBorrowService.borrowBook(library.getBooks(), "The Hobbit"));
    }

    //Testing handling of duplicate comment entries
    @Test
    public void testAddingComments() throws Exception {
        Book book1 = new Book("50 Shades of Gray", "Romance", "E.L. James", 2011);
        Book book2 = new Book("Faster Than The Speed of Love", "Romance", "Brian Griffin", 2012);
        ArrayList<Book> bookList = new ArrayList<>(Arrays.asList(book1,book2));
        when(library.getBooks()).thenReturn(bookList);

        spyBorrowService.borrowBook(library.getBooks(), "50 Shades of Gray");
        spyBorrowService.addComment(library.getBooks(), "50 Shades of Gray", "Test");
        boolean actual = spyBorrowService.addComment(library.getBooks(), "50 Shades of Gray", "Test");
        boolean expected = true;

        assertTrue(actual);
    }

    //Testing adding score and seeing result
    @ParameterizedTest
    @ValueSource(ints = {1, 4, 5, 7, 9, 11, 17, -4})
    public void testAddingScore(int score) throws Exception {
        Book book1 = new Book("50 Shades of Gray", "Romance", "E.L. James", 2011);
        Book book2 = new Book("Faster Than The Speed of Love", "Romance", "Brian Griffin", 2012);
        ArrayList<Book> bookList = new ArrayList<>(Arrays.asList(book1,book2));
        when(library.getBooks()).thenReturn(bookList);

        spyBorrowService.borrowBook(library.getBooks(), "Faster Than The Speed of Love");
        boolean actual = spyBorrowService.addScore(library.getBooks(),"Faster Than The Speed of Love", score);
        boolean expected = true;

        assertEquals(expected, actual);
    }
}
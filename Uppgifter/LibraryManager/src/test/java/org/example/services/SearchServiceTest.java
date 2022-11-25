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
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SearchServiceTest {

    @Spy
    private SearchService spySearchService;

    @Mock
    private LibraryService library;

    //Search for a specific book
    @Test
    public void testSearchByTitle() throws Exception {
        Book book1 = new Book("50 Shades of Gray", "Romance", "E.L. James", 2011);
        Book book2 = new Book("Faster Than The Speed of Love", "Romance", "Brian Griffin", 2012);
        Book book3 = new Book("The Hobbit", "Fantasy", "J.R.R. Tolkien", 1937);
        ArrayList<Book> bookList = new ArrayList<>(Arrays.asList(book1,book2,book3));
        when(library.getBooks()).thenReturn(bookList);

        String expected = library.getBooks().get(1).getTitle();
        String actual = spySearchService.bookSearch(library.getBooks(), "Title" , "Faster Than The Speed of Love").get(0).getTitle();

        assertEquals(expected,actual);
    }

    //Search for genre, check for amount of returned books
    @Test
    public void testSearchByGenre() throws Exception {
        Book book1 = new Book("50 Shades of Gray", "Romance", "E.L. James", 2011);
        Book book2 = new Book("Faster Than The Speed of Love", "Romance", "Brian Griffin", 2012);
        Book book3 = new Book("The Hobbit", "Fantasy", "J.R.R. Tolkien", 1937);
        ArrayList<Book> bookList = new ArrayList<>(Arrays.asList(book1,book2,book3));
        when(library.getBooks()).thenReturn(bookList);

        int expected = library.getBooks().size();
        int actual = spySearchService.bookSearch(library.getBooks(), "Genre" , "Romance").size();
        System.out.println("Expected: " + expected + " Actual: " + actual);

        assertNotEquals(expected,actual);
    }

    //Search for author, check for amount of returned books
    @Test
    public void testSearchAuthor() throws Exception {
        Book book1 = new Book("50 Shades of Gray", "Romance", "E.L. James", 2011);
        Book book2 = new Book("Faster Than The Speed of Love", "Romance", "Brian Griffin", 2012);
        Book book3 = new Book("The Hobbit", "Fantasy", "J.R.R. Tolkien", 1937);
        ArrayList<Book> bookList = new ArrayList<>(Arrays.asList(book1,book2,book3));
        when(library.getBooks()).thenReturn(bookList);

        int expected = 2;
        int actual = spySearchService.bookSearch(library.getBooks(), "Genre" , "Romance").size();
        System.out.println("Expected: " + expected + " Actual: " + actual);

        assertEquals(expected,actual);
    }

    //Searching with invalid year formatting
    @Test
    public void testSearchYear(){
        Book book1 = new Book("50 Shades of Gray", "Romance", "E.L. James", 2011);
        Book book2 = new Book("Faster Than The Speed of Love", "Romance", "Brian Griffin", 2012);
        Book book3 = new Book("The Hobbit", "Fantasy", "J.R.R. Tolkien", 1937);
        ArrayList<Book> bookList = new ArrayList<>(Arrays.asList(book1,book2,book3));
        when(library.getBooks()).thenReturn(bookList);

        assertThrows(Exception.class, () -> spySearchService.bookSearch(library.getBooks(), "Year" ,"2012-May"));
    }

    //
    @ParameterizedTest
    @ValueSource(ints = {})
    public void testSearchScore(){

    }
}
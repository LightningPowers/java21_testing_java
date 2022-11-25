package org.example.services;

import org.example.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
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


}
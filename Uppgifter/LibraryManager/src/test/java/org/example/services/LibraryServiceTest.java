package org.example.services;

import org.example.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LibraryServiceTest {

    @Mock
    private BorrowService borrowService;

    @Mock
    private SearchService searchService;

    @Mock
    private ArrayList<Book> mockBookList;

    @InjectMocks
    private LibraryService library;


    @Test
    public void testCalculateBorrowCost(){
        Book book = new Book("Faster Than The Speed of Love", "Romance", "Brian Griffin", 2012);
        when(library.getBooks().get(0)).thenReturn(book);
        System.out.println(library.getBooks().get(0).getTitle());
        System.out.println(library.getBooks().get(0).getMaxBorrowDays());
        System.out.println(library.getBorrowService().calculateBorrowCost(library.getBooks(), "Faster Than The Speed of Love"));


        double expected = 3000;
        double actual = library.getBorrowService().calculateBorrowCost(library.getBooks(), "Faster Than The Speed of Love");

        assertEquals(expected,actual);
    }

}
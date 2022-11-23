import org.example.Book;
import org.example.services.BorrowService;
import org.example.services.LibraryService;
import org.example.services.SearchService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class MainTest {



    @Test
    public void TestBookScoreList(){
        Book book = new Book("50 Shades of Gray", "Comedy", "Jane Austen", 1984);
        book.addScore(1);
        book.addScore(4);
        book.addScore(-22);
        System.out.println((book.getAverageScore()));
    }

    @Test
    public void TestComments(){
        Book book = new Book("Faster Than The Speed of Love", "Romance", "Brian Griffin", 2012);
        book.addComment("Terrible read, reading every single line was painful.");
        book.addComment("This book truly inspired me, now I will never become an author!");
        System.out.println(book.getComment(1));
    }

    @Test
    public void TestLibraryBorrowService(){
        Book book1 = new Book("50 Shades of Gray", "Romance", "E.L. James", 2011);
        Book book2 = new Book("Faster Than The Speed of Love", "Romance", "Brian Griffin", 2012);
        Book book3 = new Book("The Hobbit", "Fantasy", "J.R.R. Tolkien", 1937);
        ArrayList<Book> bookList = new ArrayList<>(Arrays.asList(book1,book2,book3));
        BorrowService borrowService = new BorrowService();
        SearchService searchService = new SearchService();
        LibraryService library = new LibraryService(borrowService, searchService, bookList);

        System.out.println(library.getBorrowService().borrowBook(library.getBooks(),"The Hobbit"));
        System.out.println(library.getBorrowService().borrowBook(library.getBooks(),"The Hobbit"));
        System.out.println(library.getBorrowService().calculateBorrowCost(library.getBooks(), "The Hobbit"));
    }

    @Test
    public void TestLibrarySearchService() throws Exception {
        Book book1 = new Book("50 Shades of Gray", "Romance", "E.L. James", 2011);
        Book book2 = new Book("Faster Than The Speed of Love", "Romance", "Brian Griffin", 2012);
        Book book3 = new Book("The Hobbit", "Fantasy", "J.R.R. Tolkien", 1937);
        ArrayList<Book> bookList = new ArrayList<>(Arrays.asList(book1,book2,book3));
        BorrowService borrowService = new BorrowService();
        SearchService searchService = new SearchService();
        LibraryService library = new LibraryService(borrowService, searchService, bookList);

        ArrayList<Book> foundBooks = new ArrayList<>
                (library.getSearchService().bookSearch(library.getBooks(), "Year", "2011"));
        System.out.println(foundBooks.get(0).getTitle());
    }

}
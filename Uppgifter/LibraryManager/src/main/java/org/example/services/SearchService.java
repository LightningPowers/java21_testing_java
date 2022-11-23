package org.example.services;

import org.example.Book;

import java.util.ArrayList;

public class SearchService {

    public ArrayList<Book> bookSearch(ArrayList<Book> bookList, String searchMethod, String searchTerm) throws Exception {
        ArrayList<Book> foundBooks = new ArrayList<>();

        if(searchMethod.equals("Title")){
            foundBooks = searchByTitle(bookList, searchTerm);
        }
        else if(searchMethod.equals("Genre")){
            foundBooks = searchByGenre(bookList, searchTerm);
        }
        else if(searchMethod.equals("Author")){
            foundBooks = searchByAuthor(bookList, searchTerm);
        }
        else if(searchMethod.equals("Year")){
            foundBooks = searchByYear(bookList, Integer.parseInt(searchTerm));
        }
        else{
            throw new Exception("ERROR: Invalid search method!");
        }

        return foundBooks;
    }

    //Searches for books with the requested title
    private ArrayList<Book> searchByTitle(ArrayList<Book> bookList, String title){
        ArrayList<Book> foundBooks = new ArrayList<>();

        for(Book book: bookList){
            if(book.getTitle().equals(title)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    //Searches for books containing the requested genre
    private ArrayList<Book> searchByGenre(ArrayList<Book> bookList, String genre){
        ArrayList<Book> foundBooks = new ArrayList<>();

        for(Book book: bookList){
            if(book.getGenre().equals(genre)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    //Searches for books with the requested author
    private ArrayList<Book> searchByAuthor(ArrayList<Book> bookList, String authorName){
        ArrayList<Book> foundBooks = new ArrayList<>();

        for(Book book: bookList){
            if(book.getAuthorName().equals(authorName)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    //Searches for books from the requested release year
    private ArrayList<Book> searchByYear(ArrayList<Book> bookList, int year){
        ArrayList<Book> foundBooks = new ArrayList<>();

        for(Book book: bookList){
            if(book.getPublishYear() == year){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

}

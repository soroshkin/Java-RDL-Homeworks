package io.humb1t.library;

import java.util.HashSet;
import java.util.Set;

public class Library {
    private String name;
    private int numberOfBooksInLibrary;
    private boolean isOpened;
    private Set<Book> booksRoster;

    public Library() {
        throw new RuntimeException();
    }

    public Library(String name, int numberOfBooksInLibrary, boolean isOpened) {
        this.name = name;
        this.numberOfBooksInLibrary = numberOfBooksInLibrary;
        this.isOpened = isOpened;
        this.booksRoster = new HashSet<>();
        throw new RuntimeException();
    }

    public boolean addNewBook(Book book){
        return booksRoster.add(book);
    }
}

package io.humb1t.library;

import java.util.List;
import java.util.Objects;

public class Book {
    private String name;
    private List<Author> authors;

    public String getName() {
        return name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, List<Author> authors) {
        this.name = name;
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, authors);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authors=" + authors +
                '}';
    }
}

package com.www.springrest.repository;

import java.util.*;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.www.springrest.entity.Book;

@Repository
public class BookRepository {

  private static List<Book> books = new ArrayList<>(
      Arrays.asList(
          new Book(1L, "Book1", "author1", "decription1"),
          new Book(2L, "Book2", "author2", "decription2"),
          new Book(3L, "Book3", "author3", "decription3")));

  public Book save(Book book) {

    book.setId((long) (books.size() + 1));
    books.add(book);
    return book;
  }

  public Book findById(Long id) {

    for (Book book : books) {
      if (book.getId().equals(id)) {
        return book;
      }
    }
    return null;
  }

  public List<Book> findAll() {

    return books;
  }

  public Book update(Book book) {

    for (Book update : books) {
      if (update.getId().equals(book.getId())) {
        update.setTitle(book.getTitle());
        update.setAuthor(book.getAuthor());
        update.setDescription(book.getDescription());

        return update;
      }
    }
    return null;
  }

  public void deleteById(Long id) {

    for (Book book : books) {
      if (book.getId().equals(id)) {
        books.remove(book);
        break;
      }
    }
  }

  public List<Book> searchBooks(String searchTerm) {
    List<Book> searchedBooks = new ArrayList<Book>();
    for (Book b : books) {
      if (b.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
          b.getAuthor().toLowerCase().contains(searchTerm.toLowerCase()) ||
          b.getDescription().toLowerCase().contains(searchTerm.toLowerCase())) {
        searchedBooks.add(b);
      }
    }

    return searchedBooks;
  }
}

package com.www.springrest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.www.springrest.entity.Book;
import com.www.springrest.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Map;

@RestController
public class BookController {
  @Autowired

  BookRepository bookRepository;

  @GetMapping("/book")

  public List<Book> index() {

    return bookRepository.findAll();

  }

  @GetMapping("/book/{id}")

  public Book show(@PathVariable Long id) {

    return bookRepository.findById(id);

  }

  @PostMapping("/Books/search")

  public List<Book> search(@RequestBody Map<String, String> body) {

    String searchTerm = body.get("text");

    return bookRepository.searchBooks(searchTerm);

  }

  @PostMapping("/Books")

  public Book create(@RequestBody Book Book) {

    return bookRepository.save(Book);

  }

  @PutMapping("/Books/{id}")

  public Book update(@PathVariable Long id, @RequestBody Book Book) {

    // getting Book

    Book BookToUpdate = bookRepository.findById(id);

    BookToUpdate.setTitle(Book.getTitle());

    BookToUpdate.setAuthor(Book.getAuthor());

    BookToUpdate.setDescription(Book.getDescription());

    return bookRepository.save(BookToUpdate);

  }

  @DeleteMapping("Books/{id}")

  public boolean delete(@PathVariable Long id) {

    bookRepository.deleteById(id);

    return true;

  }
}

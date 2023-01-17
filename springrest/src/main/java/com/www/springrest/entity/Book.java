package com.www.springrest.entity;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String author;
  private String description;

  public Book() {
  }

  public Book(Long id, String title, String author, String description) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.description = description;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Book id(Long id) {
    setId(id);
    return this;
  }

  public Book title(String title) {
    setTitle(title);
    return this;
  }

  public Book author(String author) {
    setAuthor(author);
    return this;
  }

  public Book description(String description) {
    setDescription(description);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Book)) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author)
        && Objects.equals(description, book.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, author, description);
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", title='" + getTitle() + "'" +
        ", author='" + getAuthor() + "'" +
        ", description='" + getDescription() + "'" +
        "}";
  }
}

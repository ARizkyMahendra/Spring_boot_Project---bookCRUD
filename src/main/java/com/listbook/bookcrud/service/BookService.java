package com.listbook.bookcrud.service;

import com.listbook.bookcrud.dto.BookDTO;
import com.listbook.bookcrud.entity.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    List<Book> getBooks();

    Book getBook(Integer id);

    void updateBook(Integer id, Book book);

    void deleteBook(Integer id);

    void updateName(Integer id, BookDTO bookDTO);
}

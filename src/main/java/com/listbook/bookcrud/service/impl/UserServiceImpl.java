package com.listbook.bookcrud.service.impl;

import com.listbook.bookcrud.dto.BookDTO;
import com.listbook.bookcrud.entity.Book;
import com.listbook.bookcrud.repository.BookRepository;
import com.listbook.bookcrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    /**
     * add user
     */
    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    /**
     * get users as list
     */
    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    /**
     * get user by id
     */

    @Override
    public Book getBook(Integer id) {
        // check weather the Book is in database or not
        Book book = bookRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Book Id:" + id));

        return book;
    }

    /**
     * update user
     */

    @Override
    public void updateBook(Integer id, Book book) {
        // check weather the user is in database or not
        bookRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));

        book.setId(id);

        bookRepository.save(book);

    }

    @Override
    public void deleteBook(Integer id) {
        // check weather the user is in database or not
        Book book = bookRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid book Id:" + id));

        bookRepository.delete(book);
    }

    @Override
    public void updateName(Integer id, BookDTO bookDTO) {
        // check weather the user is in database or not
        Book book = bookRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid book Id:" + id));

        book.setBookName(bookDTO.getBookName());

        bookRepository.save(book);

    }
}

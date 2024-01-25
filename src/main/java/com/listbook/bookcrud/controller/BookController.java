package com.listbook.bookcrud.controller;

import com.listbook.bookcrud.dto.BookDTO;
import com.listbook.bookcrud.entity.Book;
import com.listbook.bookcrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * add user
     */

    @PostMapping("/add")
    public String addBook(@RequestBody Book book) {
        bookService.addBook(book);

        return "success add book";
    }

    /**
     * get users as list
     */

    @GetMapping
    public List<Book> getUsers() {
        return bookService.getBooks();
    }

    /**
     * get user by id
     */

    @GetMapping("/get")
    public Book getBook(@RequestParam Integer id) {
        return bookService.getBook(id);
    }

    /**
     * update user
     */

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable Integer id, @RequestBody Book book) {
        bookService.updateBook(id, book);

        return ResponseEntity.noContent().build();
    }

    /**
     * delete user
     */

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * update name
     */

    @PatchMapping("/update-name/{id}")
    public ResponseEntity<Void> updateName(@PathVariable Integer id, @RequestBody BookDTO bookDTO) {
        bookService.updateName(id, bookDTO);

        return ResponseEntity.noContent().build();
    }

}

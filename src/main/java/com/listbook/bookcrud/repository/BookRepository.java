package com.listbook.bookcrud.repository;

import com.listbook.bookcrud.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}

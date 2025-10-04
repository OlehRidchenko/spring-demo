package org.example.demospring.repository;

import java.util.List;
import java.util.Optional;
import org.example.demospring.model.Book;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();

    Optional<Book> getBookById(Long id);
}

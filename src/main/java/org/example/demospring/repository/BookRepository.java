package org.example.demospring.repository;

import org.example.demospring.model.Book;
import java.util.List;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}

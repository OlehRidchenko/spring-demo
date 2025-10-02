package org.example.demospring.repository;

import java.util.List;
import org.example.demospring.model.Book;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}

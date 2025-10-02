package org.example.demospring.service;

import java.util.List;
import org.example.demospring.model.Book;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}

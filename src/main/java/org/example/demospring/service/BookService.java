package org.example.demospring.service;

import org.example.demospring.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}

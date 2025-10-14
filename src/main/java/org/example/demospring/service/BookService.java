package org.example.demospring.service;

import java.util.List;
import org.example.demospring.dto.BookDto;
import org.example.demospring.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto book);

    List<BookDto> findAll();

    BookDto findById(Long id);

    BookDto updateBookById(Long id, CreateBookRequestDto changedBook);

    void deleteById(Long id);
}

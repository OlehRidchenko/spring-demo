package org.example.demospring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import org.example.demospring.dto.BookDto;
import org.example.demospring.dto.BookSearchParameters;
import org.example.demospring.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto book);

    Page<BookDto> findAll(Pageable pageable);

    BookDto findById(Long id);

    BookDto updateBookById(Long id, CreateBookRequestDto changedBook);

    void deleteById(Long id);

    List<BookDto> search(BookSearchParameters parameters);
}

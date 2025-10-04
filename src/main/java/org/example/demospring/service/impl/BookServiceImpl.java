package org.example.demospring.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.demospring.dto.BookDto;
import org.example.demospring.dto.CreateBookRequestDto;
import org.example.demospring.exception.EntityNotFoundException;
import org.example.demospring.mapper.BookMapper;
import org.example.demospring.model.Book;
import org.example.demospring.repository.BookRepository;
import org.example.demospring.service.BookService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toModel(requestDto);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) {
        return bookRepository.getBookById(id).stream()
                .map(bookMapper::toDto)
                .findAny()
                .orElseThrow(() -> new EntityNotFoundException("Can not find book with id: " + id));
    }
}

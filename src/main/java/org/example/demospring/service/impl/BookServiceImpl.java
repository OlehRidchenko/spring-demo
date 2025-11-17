package org.example.demospring.service.impl;

import org.springframework.data.domain.Pageable;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.demospring.dto.BookDto;
import org.example.demospring.dto.BookSearchParameters;
import org.example.demospring.dto.CreateBookRequestDto;
import org.example.demospring.exception.EntityNotFoundException;
import org.example.demospring.mapper.BookMapper;
import org.example.demospring.model.Book;
import org.example.demospring.repository.book.BookRepository;
import org.example.demospring.repository.book.BookSpecificationBuilder;
import org.example.demospring.service.BookService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookSpecificationBuilder bookSpecificationBuilder;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toModel(requestDto);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) {
        return bookRepository.findById(id).stream()
                .map(bookMapper::toDto)
                .findAny()
                .orElseThrow(() -> new EntityNotFoundException("Can not find book with id: " + id));
    }

    @Override
    public BookDto updateBookById(Long id, CreateBookRequestDto bookRequestDto) {
        Book existingBook = bookRepository.findById(id).stream()
                .findAny()
                .orElseThrow(
                        () -> new EntityNotFoundException("Book with id: " + id + " not exist"));
        bookMapper.updateBookFromDto(bookRequestDto, existingBook);
        bookRepository.save(existingBook);
        return bookMapper.toDto(existingBook);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDto> search(BookSearchParameters parameters) {
        var bookSpecification = bookSpecificationBuilder.build(parameters);
        return bookRepository.findAll(bookSpecification)
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }
}

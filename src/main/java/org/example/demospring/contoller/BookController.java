package org.example.demospring.contoller;

import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.demospring.dto.BookDto;
import org.example.demospring.dto.BookSearchParameters;
import org.example.demospring.dto.CreateBookRequestDto;
import org.example.demospring.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book store management", description = "Endpoints for all books")
@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController implements BookControllerApi{
    private final BookService bookService;

    @Override
    public Page<BookDto> findAll(Pageable pageable) {
        return bookService.findAll(pageable);
    }

    @Override
    public BookDto getBookById(Long id) {
        return bookService.findById(id);
    }

    @Override
    public BookDto createBook(CreateBookRequestDto requestDto) {
        return bookService.save(requestDto);
    }

    @Override
    public BookDto updateBookById(Long id, CreateBookRequestDto bookRequestDto) {
        return bookService.updateBookById(id, bookRequestDto);
    }

    @Override
    public void deleteById(Long id) {
        bookService.deleteById(id);
    }

    @Override
    public List<BookDto> searchBooks(BookSearchParameters searchParameters) {
        return bookService.search(searchParameters);
    }

}

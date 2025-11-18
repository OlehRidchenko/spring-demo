package org.example.demospring.contoller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.example.demospring.dto.BookDto;
import org.example.demospring.dto.BookSearchParameters;
import org.example.demospring.dto.CreateBookRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface BookControllerApi {
    @Operation(summary = "Get all books")
    @GetMapping
    Page<BookDto> findAll(Pageable pageable);

    @Operation(summary = "Get book with some id")
    @GetMapping("/{id}")
    BookDto getBookById(@PathVariable Long id);

    @Operation(summary = "Crate a new book")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    BookDto createBook(@Valid
                              @RequestBody CreateBookRequestDto requestDto);


    @Operation(summary = "Update existing book")
    @PutMapping("/{id}")
    BookDto updateBookById(@PathVariable Long id,
                                  @Valid
                                  @RequestBody CreateBookRequestDto bookRequestDto);

    @Operation(summary = "Remove existing book by some id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id);

    @Operation(summary = "Find book by some parameters")
    @GetMapping("/search")
    List<BookDto> searchBooks(BookSearchParameters searchParameters);
}

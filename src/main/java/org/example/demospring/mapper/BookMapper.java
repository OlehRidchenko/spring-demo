package org.example.demospring.mapper;

import org.example.demospring.config.MapperConfig;
import org.example.demospring.dto.book.BookDto;
import org.example.demospring.dto.book.CreateBookRequestDto;
import org.example.demospring.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto createBookRequestDto);

    void updateBookFromDto(CreateBookRequestDto changedBookDto, @MappingTarget Book book);
}

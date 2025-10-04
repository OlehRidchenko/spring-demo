package org.example.demospring.mapper;

import org.example.demospring.config.MapperConfig;
import org.example.demospring.dto.BookDto;
import org.example.demospring.dto.CreateBookRequestDto;
import org.example.demospring.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto createBookRequestDto);
}

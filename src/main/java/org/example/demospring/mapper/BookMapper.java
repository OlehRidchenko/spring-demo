package org.example.demospring.mapper;

import java.util.Set;
import java.util.stream.Collectors;
import org.example.demospring.config.MapperConfig;
import org.example.demospring.dto.book.BookDto;
import org.example.demospring.dto.book.BookDtoWithoutCategoryIds;
import org.example.demospring.dto.book.CreateBookRequestDto;
import org.example.demospring.model.Book;
import org.example.demospring.model.Category;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    @Mapping(target = "categories", ignore = true)
    @Mapping(target = "id", ignore = true)
    Book toModel(CreateBookRequestDto createBookRequestDto);

    @Mapping(target = "categories", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateBookFromDto(CreateBookRequestDto changedBookDto, @MappingTarget Book book);

    @AfterMapping
    default void setCategoryIds(@MappingTarget BookDto bookDto, Book book) {
        Set<Long> categories = book.getCategories().stream()
                .map(Category::getId)
                .collect(Collectors.toSet());

        bookDto.setCategoriesId(categories);
    }

    BookDtoWithoutCategoryIds toDtoWithoutCategories(Book book);
}

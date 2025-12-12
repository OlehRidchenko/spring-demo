package org.example.demospring.mapper;

import org.example.demospring.config.MapperConfig;
import org.example.demospring.dto.category.CategoryRequestDto;
import org.example.demospring.dto.category.CategoryResponseDto;
import org.example.demospring.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface CategoryMapper {
    CategoryResponseDto toDto(Category category);

    Category toModel(CategoryRequestDto categoryRequestDto);

    void toUpdatedModel(@MappingTarget Category category, CategoryRequestDto categoryRequestDto);
}

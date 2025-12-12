package org.example.demospring.service;

import org.example.demospring.dto.category.CategoryRequestDto;
import org.example.demospring.dto.category.CategoryResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<CategoryResponseDto> findAll(Pageable pageable);

    CategoryResponseDto getById(Long id);

    CategoryResponseDto save(CategoryRequestDto categoryResponseDto);

    CategoryResponseDto update(Long id, CategoryRequestDto categoryResponseDto);

    void deleteById(Long id);
}

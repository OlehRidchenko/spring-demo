package org.example.demospring.repository.book;

import lombok.RequiredArgsConstructor;
import org.example.demospring.dto.BookSearchParameters;
import org.example.demospring.model.Book;
import org.example.demospring.repository.SpecificationBuilder;
import org.example.demospring.repository.SpecificationProviderManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParameters bookSearchParameters) {
        Specification<Book> spec = null;

        if (bookSearchParameters.title() != null && !bookSearchParameters.title().isEmpty()) {
            spec = bookSpecificationProviderManager
                    .getSpecificationProvider("title")
                    .getSpecification(bookSearchParameters.title());
        }

        if (bookSearchParameters.author() != null && !bookSearchParameters.author().isEmpty()) {
            spec = bookSpecificationProviderManager
                    .getSpecificationProvider("author")
                    .getSpecification(bookSearchParameters.author());
        }

        if (bookSearchParameters.isbn() != null && !bookSearchParameters.isbn().isEmpty()) {
            spec = bookSpecificationProviderManager
                    .getSpecificationProvider("isbn")
                    .getSpecification(bookSearchParameters.isbn());
        }

        return spec;
    }

}

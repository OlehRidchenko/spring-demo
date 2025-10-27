package org.example.demospring.repository.book;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.demospring.model.Book;
import org.example.demospring.repository.SpecificationProvider;
import org.example.demospring.repository.SpecificationProviderManager;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationProviderManager implements SpecificationProviderManager<Book> {
    private final List<SpecificationProvider<Book>> bookSpecificationProvider;

    @Override
    public SpecificationProvider<Book> getSpecificationProvider(String key) {
        return bookSpecificationProvider.stream()
                .filter(b -> b.getKey().equals(key))
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException("Can not find correct specification provider for key: " + key));
    }
}

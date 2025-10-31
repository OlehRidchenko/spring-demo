package org.example.demospring.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateBookRequestDto {
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @NotBlank
    private String isbn;
    @DecimalMin("0.0")
    private BigDecimal price;
    @NotBlank
    private String description;
    @NotBlank
    private String coverImage;
}

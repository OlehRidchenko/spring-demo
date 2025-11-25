package org.example.demospring.validation;

import java.util.Objects;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
    private String firstField;
    private String secondField;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        this.firstField = constraintAnnotation.first();
        this.secondField = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Object sourceFieldValue = new BeanWrapperImpl(value).getPropertyValue(firstField);
        Object targetFieldValue = new BeanWrapperImpl(value).getPropertyValue(secondField);

        return Objects.equals(sourceFieldValue, targetFieldValue);
    }
}

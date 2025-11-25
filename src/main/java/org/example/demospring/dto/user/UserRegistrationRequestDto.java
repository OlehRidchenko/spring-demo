package org.example.demospring.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.demospring.validation.FieldMatch;

@Data
@FieldMatch(
        first = "password",
        second = "repeatPassword",
        message = "Passwords must match"
)
public class UserRegistrationRequestDto {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    @NotBlank
    @Size(min = 8, max = 20)
    private String repeatPassword;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
    private String shippingAddress;
}

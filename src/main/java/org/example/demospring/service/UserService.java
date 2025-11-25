package org.example.demospring.service;

import org.example.demospring.dto.user.UserRegistrationRequestDto;
import org.example.demospring.dto.user.UserResponseDto;
import org.example.demospring.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException;
}

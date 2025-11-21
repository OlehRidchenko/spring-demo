package org.example.demospring.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.demospring.dto.user.UserRegistrationRequestDto;
import org.example.demospring.dto.user.UserResponseDto;
import org.example.demospring.exception.RegistrationException;
import org.example.demospring.mapper.UserMapper;
import org.example.demospring.model.User;
import org.example.demospring.repository.UserRepository;
import org.example.demospring.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException {
        if (repository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException("Can not register user");
        }

        User user = mapper.toEntity(requestDto);

        repository.save(user);
        return mapper.toUserResponse(user);
    }
}

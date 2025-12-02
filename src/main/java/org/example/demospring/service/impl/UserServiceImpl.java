package org.example.demospring.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.demospring.dto.user.UserRegistrationRequestDto;
import org.example.demospring.dto.user.UserResponseDto;
import org.example.demospring.exception.RegistrationException;
import org.example.demospring.mapper.UserMapper;
import org.example.demospring.model.Role;
import org.example.demospring.model.User;
import org.example.demospring.repository.role.RoleRepository;
import org.example.demospring.repository.user.UserRepository;
import org.example.demospring.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final RoleRepository roleRepository;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException {
        if (repository.existsByEmail(requestDto.getEmail())) {
            throw new RegistrationException("Can not register user with email: " + requestDto.getEmail());
        }

        User user = mapper.toEntity(requestDto);
        Role role = roleRepository.findByName(Role.RoleName.USER);
        user.getRoles().add(role);
        repository.save(user);
        return mapper.toUserResponse(user);
    }
}

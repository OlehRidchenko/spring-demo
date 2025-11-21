package org.example.demospring.mapper;

import org.example.demospring.dto.user.UserRegistrationRequestDto;
import org.example.demospring.dto.user.UserResponseDto;
import org.example.demospring.model.User;
import org.mapstruct.Mapper;
import org.example.demospring.config.MapperConfig;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    User toEntity(UserRegistrationRequestDto dto);

    UserResponseDto toUserResponse (User user);
}

package vn.com.devmaster.services.service.mapper;

import org.springframework.stereotype.Component;
import vn.com.devmaster.services.domain.User;
import vn.com.devmaster.services.service.dto.UserDTO;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class UserMapper implements EntityMapper<UserDTO, User> {
    @Override
    public UserDTO toDto(User entity) {
        UserDTO dto = new UserDTO();
        dto.setFullName(entity.getFullName());
        dto.setAccount(entity.getAccount());
        dto.setEmail(entity.getEmail());
        dto.setRole(entity.getRole());
        return dto;
    }

    @Override
    public User toEntity(UserDTO dto) {
        User entity = new User();
        entity.setFullName(dto.getFullName());
        entity.setAccount(dto.getAccount());
        entity.setEmail(dto.getEmail());
        entity.setRole(dto.getRole());
        return entity;
    }

    @Override
    public Collection<UserDTO> toDto(Collection<User> entity) {
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public Collection<User> toEntity(Collection<UserDTO> dto) {
        return null;
    }
}

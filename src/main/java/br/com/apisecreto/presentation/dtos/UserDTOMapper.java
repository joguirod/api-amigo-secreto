package br.com.apisecreto.presentation.dtos;

import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.persistence.entities.UserEntity;
import br.com.apisecreto.presentation.dtos.request.UserRequestDTO;
import br.com.apisecreto.presentation.dtos.response.UserResponseDTO;

public class UserDTOMapper {
    public UserEntity toEntity(UserRequestDTO userRequestDTO) {
        return new UserEntity(userRequestDTO.name(), userRequestDTO.email(), userRequestDTO.password(), userRequestDTO.preferences());
    }

    public User toDomainEntity(UserRequestDTO userRequestDTO) {
        return new User(userRequestDTO.name(), userRequestDTO.email(), userRequestDTO.password(), userRequestDTO.preferences());
    }

    public UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(user.getName());
    }
}

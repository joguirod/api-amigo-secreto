package br.com.apisecreto.presentation.dtos.response;

import java.util.List;
import java.util.stream.Stream;

public record GroupResponseDTO(
        String name,
        List<UserResponseDTO> users
){
}

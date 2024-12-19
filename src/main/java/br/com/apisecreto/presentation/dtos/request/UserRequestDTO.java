package br.com.apisecreto.presentation.dtos.request;

public record UserRequestDTO(
        String name,
        String email,
        String password,
        String preferences
) {
}

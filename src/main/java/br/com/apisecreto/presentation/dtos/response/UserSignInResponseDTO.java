package br.com.apisecreto.presentation.dtos.response;

public record UserSignInResponseDTO(
        String name,
        String token
){
}

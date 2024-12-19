package br.com.apisecreto.presentation.dtos.request;

public record UserSignInRequestDTO(
        String email,
        String password
){
}

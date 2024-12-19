package br.com.apisecreto.presentation.dtos.request;

public record GroupRequestDTO(
        String name,
        String description,
        String secretPhrase
){
}

package br.com.apisecreto.presentation.dtos.request;

import java.util.UUID;

public record GroupMatchRequestDTO(
        UUID groupId,
        String secretPhrase
){
}

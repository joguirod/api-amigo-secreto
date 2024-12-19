package br.com.apisecreto.infrastructure;

import org.springframework.http.HttpStatus;

public class RestExceptionMessage {
    private HttpStatus status;
    private String message;

    public RestExceptionMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}

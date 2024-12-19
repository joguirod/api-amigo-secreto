package br.com.apisecreto.presentation.exceptions;

public class NotUniqueUserException extends HttpException {
    public NotUniqueUserException(String message, int statusCode) {
        super(message, statusCode);
    }
}

package br.com.apisecreto.presentation.exceptions;

public class UserNotFoundException extends HttpException{
    public UserNotFoundException(String message, int statusCode) {
        super(message, statusCode);
    }
}

package br.com.apisecreto.presentation.exceptions;

public class UserHaveNoGroupYetException extends HttpException {
    public UserHaveNoGroupYetException(String message, int statusCode) {
        super(message, statusCode);
    }
}

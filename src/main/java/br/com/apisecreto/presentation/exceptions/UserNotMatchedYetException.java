package br.com.apisecreto.presentation.exceptions;

public class UserNotMatchedYetException extends HttpException {
    public UserNotMatchedYetException(String message, int statusCode) {
        super(message, statusCode);
    }
}

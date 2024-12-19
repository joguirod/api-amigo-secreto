package br.com.apisecreto.presentation.exceptions;

public class GroupNotFoundException extends HttpException {
    public GroupNotFoundException(String message, int statusCode) {
        super(message, statusCode);
    }
}

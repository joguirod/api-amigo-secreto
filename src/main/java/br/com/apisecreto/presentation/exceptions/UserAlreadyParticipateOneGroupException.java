package br.com.apisecreto.presentation.exceptions;

public class UserAlreadyParticipateOneGroupException extends HttpException{
    public UserAlreadyParticipateOneGroupException(String message, int statusCode) {
        super(message, statusCode);
    }
}

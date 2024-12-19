package br.com.apisecreto.presentation.exceptions;

public class HttpException extends Exception {
    int statusCode;

    public HttpException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}

package br.com.apisecreto.infrastructure;

import br.com.apisecreto.presentation.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    private ResponseEntity<RestExceptionMessage> handleException(Exception exception) {
        RestExceptionMessage exceptionResponse = new RestExceptionMessage(HttpStatus.INTERNAL_SERVER_ERROR, "An internal server error occurred. Try again later.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }

    @ExceptionHandler(HttpException.class)
    private ResponseEntity<RestExceptionMessage> handleHttpException(HttpException exception) {
        RestExceptionMessage exceptionResponse = new RestExceptionMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(NotUniqueUserException.class)
    private ResponseEntity<RestExceptionMessage> handleNotUniqueUserException(NotUniqueUserException exception) {
        RestExceptionMessage exceptionResponse = new RestExceptionMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(GroupAlreadyMatchedParticipantsException.class)
    private ResponseEntity<RestExceptionMessage> groupAlreadyMatchedParticipantsException(GroupAlreadyMatchedParticipantsException exception) {
        RestExceptionMessage exceptionResponse = new RestExceptionMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(GroupNotFoundException.class)
    private ResponseEntity<RestExceptionMessage> groupNotFoundException(GroupNotFoundException exception) {
        RestExceptionMessage exceptionResponse = new RestExceptionMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(UserAlreadyParticipateOneGroupException.class)
    private ResponseEntity<RestExceptionMessage> userAlreadyParticipateOneGroupException(UserAlreadyParticipateOneGroupException exception) {
        RestExceptionMessage exceptionResponse = new RestExceptionMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
    @ExceptionHandler(UserHaveNoGroupYetException.class)
    private ResponseEntity<RestExceptionMessage> userHaveNoGroupYetException(UserHaveNoGroupYetException exception) {
        RestExceptionMessage exceptionResponse = new RestExceptionMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<RestExceptionMessage> userNotFoundException(UserNotFoundException exception) {
        RestExceptionMessage exceptionResponse = new RestExceptionMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(UserNotMatchedYetException.class)
    private ResponseEntity<RestExceptionMessage> userNotMatchedYetException(UserNotMatchedYetException exception) {
        RestExceptionMessage exceptionResponse = new RestExceptionMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
}

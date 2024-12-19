package br.com.apisecreto.presentation.exceptions;

public class GroupAlreadyMatchedParticipantsException extends HttpException {
    public GroupAlreadyMatchedParticipantsException(String message, int statusCode) {
        super(message, statusCode);
    }
}

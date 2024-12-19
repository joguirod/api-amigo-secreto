package br.com.apisecreto.domain.usecase.user;

import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.presentation.exceptions.UserHaveNoGroupYetException;
import br.com.apisecreto.presentation.exceptions.UserNotFoundException;
import br.com.apisecreto.presentation.exceptions.UserNotMatchedYetException;

public interface GetMatchedUserUseCase {
    User execute(String requesterEmail) throws UserNotFoundException, UserNotMatchedYetException, UserHaveNoGroupYetException;
}

package br.com.apisecreto.domain.usecase.user;

import br.com.apisecreto.domain.entities.User;

public interface UserSignInUseCase {
    String execute(String email, String password) throws Exception;
}

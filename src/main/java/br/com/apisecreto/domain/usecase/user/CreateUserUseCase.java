package br.com.apisecreto.domain.usecase.user;

import br.com.apisecreto.domain.entities.User;

public interface CreateUserUseCase {
    public User execute(User user) throws Exception;
}

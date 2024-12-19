package br.com.apisecreto.domain.usecase.user;

import br.com.apisecreto.domain.entities.User;

public interface CreateUserCreateUseCase {
    public void execute(User user) throws Exception;
}

package br.com.apisecreto.domain.usecase.user;

import br.com.apisecreto.domain.entities.User;

import java.util.List;

public interface GetAllUsersUseCase {
    public List<User> execute();
}

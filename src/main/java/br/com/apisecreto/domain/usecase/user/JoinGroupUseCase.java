package br.com.apisecreto.domain.usecase.user;

import br.com.apisecreto.domain.entities.Group;
import br.com.apisecreto.domain.entities.User;

public interface JoinGroupUseCase {
    public void execute(User user, Group group) throws Exception;
}

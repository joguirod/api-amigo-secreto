package br.com.apisecreto.domain.usecase.group;

import br.com.apisecreto.domain.entities.Group;

public interface CreateGroupUseCase {
    public void execute(Group group);
}

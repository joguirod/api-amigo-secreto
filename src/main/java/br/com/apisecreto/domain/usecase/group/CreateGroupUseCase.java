package br.com.apisecreto.domain.usecase.group;

import br.com.apisecreto.domain.entities.Group;

public interface CreateGroupUseCase {
    public Group execute(Group group);
}

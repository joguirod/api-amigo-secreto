package br.com.apisecreto.domain.usecase.group;

import br.com.apisecreto.domain.entities.Group;

public interface GroupParticipantMatchUseCase {
    public void execute(Group group);
}

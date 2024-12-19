package br.com.apisecreto.domain.usecase.group;

import br.com.apisecreto.domain.entities.Group;
import br.com.apisecreto.presentation.exceptions.GroupAlreadyMatchedParticipantsException;
import br.com.apisecreto.presentation.exceptions.GroupNotFoundException;

public interface GroupParticipantMatchUseCase {
    public Group execute(Group group) throws GroupNotFoundException, GroupAlreadyMatchedParticipantsException;
}

package br.com.apisecreto.application.usecase.group;

import br.com.apisecreto.domain.entities.Group;
import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.domain.usecase.group.GroupParticipantMatchUseCase;
import br.com.apisecreto.persistence.repositories.GroupRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupParticipantMatchUseCaseImpl implements GroupParticipantMatchUseCase {
    private final GroupRepository groupRepository;

    public GroupParticipantMatchUseCaseImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void execute(Group group) {

    }
}

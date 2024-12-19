package br.com.apisecreto.application.usecase.group;

import br.com.apisecreto.application.GroupMapper;
import br.com.apisecreto.domain.entities.Group;
import br.com.apisecreto.domain.usecase.group.CreateGroupUseCase;
import br.com.apisecreto.persistence.entities.GroupEntity;
import br.com.apisecreto.persistence.repositories.GroupRepository;

public class CreateGroupUseCaseImpl implements CreateGroupUseCase {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    public CreateGroupUseCaseImpl(GroupRepository groupRepository, GroupMapper groupMapper) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
    }

    @Override
    public Group execute(Group group) {
        GroupEntity groupEntity = groupMapper.toEntity(group);
        groupEntity = groupRepository.save(groupEntity);
        return groupMapper.toDomainEntity(groupEntity);
    }
}

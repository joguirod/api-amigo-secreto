package br.com.apisecreto.application.usecase.group;

import br.com.apisecreto.application.GroupMapper;
import br.com.apisecreto.domain.entities.Group;
import br.com.apisecreto.domain.usecase.group.GetAllGroupsUseCase;
import br.com.apisecreto.persistence.entities.GroupEntity;
import br.com.apisecreto.persistence.repositories.GroupRepository;

import java.util.List;

public class GetAllGroupsUseCaseImpl implements GetAllGroupsUseCase {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    public GetAllGroupsUseCaseImpl(GroupRepository groupRepository, GroupMapper groupMapper) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
    }

    @Override
    public List<Group> execute() {
        List<GroupEntity> groups = groupRepository.findAll();
        return groups.stream().map(groupMapper::toDomainEntity).toList();
    }
}

package br.com.apisecreto.application.usecase;

import br.com.apisecreto.domain.entities.Group;
import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.persistence.entities.GroupEntity;
import br.com.apisecreto.persistence.entities.UserEntity;

import java.util.List;

public class GroupMapper {
    private final UserMapper userMapper;

    public GroupMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public GroupEntity toEntity(Group group) {
        GroupEntity groupEntity = new GroupEntity(group.getName(), group.getDescription(), group.getSecretPhrase());

        List<UserEntity> usersEntity = group.getUsers().stream()
                .map(userMapper::toEntity)
                .toList();

        groupEntity.setParticipantUsers(usersEntity);

        return groupEntity;
    }

    public Group toDomainEntity(GroupEntity groupEntity) {
        Group group = new Group(groupEntity.getName(), groupEntity.getDescription(), groupEntity.getSecretPhrase());

        List<User> users = groupEntity.getParticipantUsers().stream()
                .map(userMapper::toDomainEntity)
                .toList();

        group.setUsers(users);

        return group;
    }
}

package br.com.apisecreto.application.usecase.group;

import br.com.apisecreto.application.GroupMapper;
import br.com.apisecreto.application.UserMapper;
import br.com.apisecreto.domain.entities.Group;
import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.domain.usecase.group.GroupParticipantMatchUseCase;
import br.com.apisecreto.persistence.entities.GroupEntity;
import br.com.apisecreto.persistence.entities.UserEntity;
import br.com.apisecreto.persistence.repositories.GroupRepository;
import br.com.apisecreto.persistence.repositories.UserRepository;
import br.com.apisecreto.presentation.exceptions.GroupAlreadyMatchedParticipantsException;
import br.com.apisecreto.presentation.exceptions.GroupNotFoundException;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GroupParticipantMatchUseCaseImpl implements GroupParticipantMatchUseCase {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final GroupMapper groupMapper;
    private final UserMapper userMapper;

    public GroupParticipantMatchUseCaseImpl(GroupRepository groupRepository, UserRepository userRepository, GroupMapper groupMapper, UserMapper userMapper) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.groupMapper = groupMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Group execute(Group group) throws GroupNotFoundException, GroupAlreadyMatchedParticipantsException {
        GroupEntity groupEntity = groupRepository.findByName(group.getName());
        if (groupEntity == null) {
            throw new GroupNotFoundException("Group informed not found.", 404);
        } else if (groupEntity.isAlreadyMatchedParticipants()) {
            throw new GroupAlreadyMatchedParticipantsException("The informed group already matched their users", 400);
        }

        List<User> users = group.getUsers();

        Collections.shuffle(users);
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            // se for o último usuário, ele presenteará o primeiro
            if (i == users.size() - 1) {
                user.setMatchedUser(users.get(0));
            } else {
                user.setMatchedUser(users.get(i + 1));
            }

            UserEntity userEntity = userMapper.toEntity(user);
            userRepository.save(userEntity);
        }

        groupEntity.setAlreadyMatchedParticipants(true);
        groupRepository.save(groupEntity);
        return groupMapper.toDomainEntity(groupEntity);
    }
}

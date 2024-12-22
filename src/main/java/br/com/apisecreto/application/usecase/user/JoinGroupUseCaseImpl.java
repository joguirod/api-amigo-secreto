package br.com.apisecreto.application.usecase.user;

import br.com.apisecreto.domain.entities.Group;
import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.domain.usecase.user.JoinGroupUseCase;
import br.com.apisecreto.persistence.entities.GroupEntity;
import br.com.apisecreto.persistence.entities.UserEntity;
import br.com.apisecreto.persistence.repositories.GroupRepository;
import br.com.apisecreto.persistence.repositories.UserRepository;
import br.com.apisecreto.presentation.exceptions.GroupNotFoundException;
import br.com.apisecreto.presentation.exceptions.UserAlreadyParticipateOneGroupException;
import br.com.apisecreto.presentation.exceptions.UserNotFoundException;

public class JoinGroupUseCaseImpl implements JoinGroupUseCase {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public JoinGroupUseCaseImpl(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void execute(User user, Group group) throws Exception {
        GroupEntity groupEntity = groupRepository.findByName(group.getName());
        if (groupEntity == null) {
            throw new GroupNotFoundException("Group with the given name not found", 404);
        }

        UserEntity userEntity = userRepository.findByEmail(user.getEmail());
        if (userEntity == null) {
            throw new UserNotFoundException("User with the given email not found", 404);
        } else if (userEntity.getGroupJoined() != null) {
            throw new UserAlreadyParticipateOneGroupException("User already participate one group", 400);
        }


        groupEntity.getParticipantUsers().add(userEntity);
        groupRepository.save(groupEntity);
    }
}

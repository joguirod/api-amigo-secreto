package br.com.apisecreto.application.usecase.user;

import br.com.apisecreto.application.UserMapper;
import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.domain.usecase.user.GetMatchedUserUseCase;
import br.com.apisecreto.persistence.entities.UserEntity;
import br.com.apisecreto.persistence.repositories.UserRepository;
import br.com.apisecreto.presentation.exceptions.UserHaveNoGroupYetException;
import br.com.apisecreto.presentation.exceptions.UserNotFoundException;
import br.com.apisecreto.presentation.exceptions.UserNotMatchedYetException;

public class GetMatchedUserUseCaseImpl implements GetMatchedUserUseCase {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public GetMatchedUserUseCaseImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User execute(String requesterEmail) throws UserNotFoundException, UserNotMatchedYetException, UserHaveNoGroupYetException {
        UserEntity userEntity = userRepository.findByEmail(requesterEmail);
        if (userEntity == null) {
            throw new UserNotFoundException("User informed not found", 404);
        }
        if (userEntity.getMatchedUser() == null) {
            throw new UserNotMatchedYetException("The user informed does not have a match yet", 400);
        }
        if (userEntity.getGroupJoined() == null) {
            throw new UserHaveNoGroupYetException("The user informed doest not have a group yet", 400);
        }

        return userMapper.toDomainEntity(userEntity.getMatchedUser());
    }
}

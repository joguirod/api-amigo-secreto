package br.com.apisecreto.application.usecase.user;

import br.com.apisecreto.application.UserMapper;
import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.domain.usecase.user.CreateUserUseCase;
import br.com.apisecreto.persistence.entities.UserEntity;
import br.com.apisecreto.persistence.repositories.UserRepository;
import br.com.apisecreto.presentation.exceptions.NotUniqueUserException;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public CreateUserUseCaseImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User execute(User user) throws NotUniqueUserException {
        UserEntity userEntity = userMapper.toEntity(user);

        if (userRepository.findByEmail(userEntity.getEmail())) {
            throw new NotUniqueUserException("A user with the given email already exists", 400);
        }

        userEntity = userRepository.save(userEntity);
        return userMapper.toDomainEntity(userEntity);
    }
}

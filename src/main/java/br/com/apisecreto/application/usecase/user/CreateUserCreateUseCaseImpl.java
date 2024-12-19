package br.com.apisecreto.application.usecase.user;

import br.com.apisecreto.application.usecase.UserMapper;
import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.domain.usecase.user.CreateUserCreateUseCase;
import br.com.apisecreto.persistence.entities.UserEntity;
import br.com.apisecreto.persistence.repositories.UserRepository;
import br.com.apisecreto.presentation.exceptions.NotUniqueUserException;

public class CreateUserCreateUseCaseImpl implements CreateUserCreateUseCase {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public CreateUserCreateUseCaseImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void execute(User user) throws NotUniqueUserException {
        UserEntity userEntity = userMapper.toEntity(user);

        if (userRepository.findByEmail(userEntity.getEmail())) {
            throw new NotUniqueUserException("A user with the given email already exists", 400);
        }


    }
}

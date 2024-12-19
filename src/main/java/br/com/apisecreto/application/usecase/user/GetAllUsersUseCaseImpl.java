package br.com.apisecreto.application.usecase.user;

import br.com.apisecreto.application.UserMapper;
import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.domain.usecase.user.GetAllUsersUseCase;
import br.com.apisecreto.persistence.entities.UserEntity;
import br.com.apisecreto.persistence.repositories.UserRepository;

import java.util.List;

public class GetAllUsersUseCaseImpl implements GetAllUsersUseCase {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public GetAllUsersUseCaseImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> execute() {
        List<UserEntity> usersEntities = userRepository.findAll();
        return usersEntities.stream()
                .map(userMapper::toDomainEntity)
                .toList();
    }
}

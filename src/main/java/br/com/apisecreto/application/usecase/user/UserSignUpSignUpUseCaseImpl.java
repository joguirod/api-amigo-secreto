package br.com.apisecreto.application.usecase.user;

import br.com.apisecreto.application.UserMapper;
import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.domain.usecase.user.UserSignUpUseCase;
import br.com.apisecreto.persistence.entities.UserEntity;
import br.com.apisecreto.persistence.repositories.UserRepository;
import br.com.apisecreto.presentation.exceptions.NotUniqueUserException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserSignUpSignUpUseCaseImpl implements UserSignUpUseCase {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserSignUpSignUpUseCaseImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User execute(User user) throws NotUniqueUserException {
        UserEntity userEntity = userMapper.toEntity(user);

        if (userRepository.findByEmail(userEntity.getEmail()) != null) {
            throw new NotUniqueUserException("A user with the given email already exists", 400);
        }

        // criptografa a senha recebida
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));

        userEntity = userRepository.save(userEntity);
        return userMapper.toDomainEntity(userEntity);
    }
}

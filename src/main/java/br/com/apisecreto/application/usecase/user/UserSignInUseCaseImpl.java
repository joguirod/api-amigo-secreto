package br.com.apisecreto.application.usecase.user;

import br.com.apisecreto.application.UserMapper;
import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.domain.usecase.user.UserSignInUseCase;
import br.com.apisecreto.infrastructure.security.AuthService;
import br.com.apisecreto.persistence.entities.UserEntity;
import br.com.apisecreto.persistence.repositories.UserRepository;
import br.com.apisecreto.presentation.exceptions.HttpException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.net.http.HttpTimeoutException;

public class UserSignInUseCaseImpl implements UserSignInUseCase {
    private final UserRepository userRepository;
    private final AuthService authService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserSignInUseCaseImpl(UserRepository userRepository, AuthService authService, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authService = authService;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String execute(String email, String password) throws HttpException, Exception {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) {
            throw new HttpException("Incorrect email and/or password", 400);
        }
        // compara o raw password com a senha encriptada
        if (!passwordEncoder.matches(password, userEntity.getPassword())) {
            throw new HttpException("Incorrect email and/or password", 400);
        }

        return authService.generateToken(userMapper.toDomainEntity(userEntity));
    }
}

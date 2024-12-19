package br.com.apisecreto.common.config;

import br.com.apisecreto.application.UserMapper;
import br.com.apisecreto.application.usecase.user.GetMatchedUserUseCaseImpl;
import br.com.apisecreto.application.usecase.user.UserSignInUseCaseImpl;
import br.com.apisecreto.application.usecase.user.UserSignUpSignUpUseCaseImpl;
import br.com.apisecreto.application.usecase.user.GetAllUsersUseCaseImpl;
import br.com.apisecreto.domain.usecase.user.GetMatchedUserUseCase;
import br.com.apisecreto.domain.usecase.user.UserSignInUseCase;
import br.com.apisecreto.domain.usecase.user.UserSignUpUseCase;
import br.com.apisecreto.domain.usecase.user.GetAllUsersUseCase;
import br.com.apisecreto.infrastructure.security.AuthService;
import br.com.apisecreto.persistence.repositories.UserRepository;
import br.com.apisecreto.presentation.dtos.UserDTOMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {
    @Bean
    UserDTOMapper userDTOMapper() {
        return new UserDTOMapper();
    }

    @Bean
    UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean
    UserSignUpUseCase userSignUpUseCase(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        return new UserSignUpSignUpUseCaseImpl(userRepository, userMapper, passwordEncoder);
    }

    @Bean
    UserSignInUseCase userSignInUseCase(UserRepository userRepository, AuthService authService, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        return new UserSignInUseCaseImpl(userRepository, authService, userMapper, passwordEncoder);
    }

    @Bean
    GetAllUsersUseCase getAllUsersUseCase(UserRepository userRepository, UserMapper userMapper) {
        return new GetAllUsersUseCaseImpl(userRepository, userMapper);
    }

    @Bean
    GetMatchedUserUseCase getMatchedUserUseCase(UserRepository userRepository, UserMapper userMapper) {
        return new GetMatchedUserUseCaseImpl(userRepository, userMapper);
    }
}

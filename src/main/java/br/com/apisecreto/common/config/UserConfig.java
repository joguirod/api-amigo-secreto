package br.com.apisecreto.common.config;

import br.com.apisecreto.application.UserMapper;
import br.com.apisecreto.application.usecase.user.CreateUserUseCaseImpl;
import br.com.apisecreto.application.usecase.user.GetAllUsersUseCaseImpl;
import br.com.apisecreto.domain.usecase.user.CreateUserUseCase;
import br.com.apisecreto.domain.usecase.user.GetAllUsersUseCase;
import br.com.apisecreto.persistence.repositories.UserRepository;
import br.com.apisecreto.presentation.dtos.UserDTOMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    CreateUserUseCase createUserUseCase(UserRepository userRepository, UserMapper userMapper) {
        return new CreateUserUseCaseImpl(userRepository, userMapper);
    }

    @Bean
    GetAllUsersUseCase getAllUsersUseCase(UserRepository userRepository, UserMapper userMapper) {
        return new GetAllUsersUseCaseImpl(userRepository, userMapper);
    }
}

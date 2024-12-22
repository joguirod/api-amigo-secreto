package br.com.apisecreto.presentation.controllers;


import br.com.apisecreto.application.UserMapper;
import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.domain.usecase.user.GetMatchedUserUseCase;
import br.com.apisecreto.domain.usecase.user.UserSignUpUseCase;
import br.com.apisecreto.domain.usecase.user.GetAllUsersUseCase;
import br.com.apisecreto.persistence.entities.UserEntity;
import br.com.apisecreto.persistence.repositories.UserRepository;
import br.com.apisecreto.presentation.dtos.UserDTOMapper;
import br.com.apisecreto.presentation.dtos.response.UserResponseDTO;
import br.com.apisecreto.presentation.exceptions.UserHaveNoGroupYetException;
import br.com.apisecreto.presentation.exceptions.UserNotFoundException;
import br.com.apisecreto.presentation.exceptions.UserNotMatchedYetException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserDTOMapper userDTOMapper;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final GetMatchedUserUseCase getMatchedUserUseCase;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserController(UserDTOMapper userDTOMapper, GetAllUsersUseCase getAllUsersUseCase, GetMatchedUserUseCase getMatchedUserUseCase, UserRepository userRepository, UserMapper userMapper) {
        this.userDTOMapper = userDTOMapper;
        this.getAllUsersUseCase = getAllUsersUseCase;
        this.getMatchedUserUseCase = getMatchedUserUseCase;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = getAllUsersUseCase.execute().stream()
                .map(userDTOMapper::toResponseDTO)
                .toList();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}/matched")
    public ResponseEntity<UserResponseDTO> getMatchedUser(@PathVariable Long userId) throws UserNotFoundException, UserNotMatchedYetException, UserHaveNoGroupYetException {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if (!userEntity.isPresent()) throw new UserNotFoundException("User with the given ID not found", 404);
        User user = getMatchedUserUseCase.execute(userEntity.get().getEmail());
        return new ResponseEntity<>(userDTOMapper.toResponseDTO(user), HttpStatus.OK);
    }
}

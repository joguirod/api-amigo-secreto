package br.com.apisecreto.presentation.controllers;


import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.domain.usecase.user.CreateUserUseCase;
import br.com.apisecreto.domain.usecase.user.GetAllUsersUseCase;
import br.com.apisecreto.presentation.dtos.UserDTOMapper;
import br.com.apisecreto.presentation.dtos.request.UserRequestDTO;
import br.com.apisecreto.presentation.dtos.response.UserResponseDTO;
import br.com.apisecreto.presentation.exceptions.NotUniqueUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserDTOMapper userDTOMapper;
    private final CreateUserUseCase createUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;

    public UserController(UserDTOMapper userDTOMapper, CreateUserUseCase createUserUseCase, GetAllUsersUseCase getAllUsersUseCase) {
        this.userDTOMapper = userDTOMapper;
        this.createUserUseCase = createUserUseCase;
        this.getAllUsersUseCase = getAllUsersUseCase;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = getAllUsersUseCase.execute().stream()
                .map(userDTOMapper::toResponseDTO)
                .toList();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) throws Exception {
        User user = userDTOMapper.toDomainEntity(userRequestDTO);
        user = createUserUseCase.execute(user);
        return new ResponseEntity<>(userDTOMapper.toResponseDTO(user), HttpStatus.CREATED);
    }
}

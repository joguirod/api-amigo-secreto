package br.com.apisecreto.presentation.controllers;

import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.domain.usecase.user.UserSignInUseCase;
import br.com.apisecreto.domain.usecase.user.UserSignUpUseCase;
import br.com.apisecreto.persistence.entities.UserEntity;
import br.com.apisecreto.persistence.repositories.UserRepository;
import br.com.apisecreto.presentation.dtos.UserDTOMapper;
import br.com.apisecreto.presentation.dtos.request.UserRequestDTO;
import br.com.apisecreto.presentation.dtos.request.UserSignInRequestDTO;
import br.com.apisecreto.presentation.dtos.response.UserResponseDTO;
import br.com.apisecreto.presentation.dtos.response.UserSignInResponseDTO;
import br.com.apisecreto.presentation.exceptions.HttpException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserSignInUseCase userSignInUseCase;
    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;
    private final UserSignUpUseCase userSignUpUseCase;

    public AuthController(UserSignInUseCase userSignInUseCase, UserRepository userRepository, UserDTOMapper userDTOMapper, UserSignUpUseCase userSignUpUseCase) {
        this.userSignInUseCase = userSignInUseCase;
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
        this.userSignUpUseCase = userSignUpUseCase;
    }

    @PostMapping("/user/signUp")
    public ResponseEntity<UserResponseDTO> signUp(@RequestBody UserRequestDTO userRequestDTO) throws Exception {
        User user = userDTOMapper.toDomainEntity(userRequestDTO);
        System.out.println("Usuário: " + user.getPassword());
        userSignUpUseCase.execute(user);
        UserResponseDTO userResponseDTO = userDTOMapper.toResponseDTO(user);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/user/signIn")
    public ResponseEntity<UserSignInResponseDTO> login(@RequestBody UserSignInRequestDTO userSignInRequestDTO) throws Exception, HttpException {
        System.out.println("Entrou no login");
        String token = userSignInUseCase.execute(userSignInRequestDTO.email(), userSignInRequestDTO.password());
        UserEntity userEntity = userRepository.findByEmail(userSignInRequestDTO.email());
        UserSignInResponseDTO userSignInResponseDTO = new UserSignInResponseDTO(userEntity.getName(), token);
        System.out.println("chegou no return");
        return new ResponseEntity<>(userSignInResponseDTO, HttpStatus.OK);
    }
}

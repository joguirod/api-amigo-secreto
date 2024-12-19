package br.com.apisecreto.presentation.controllers;

import br.com.apisecreto.application.GroupMapper;
import br.com.apisecreto.domain.entities.Group;
import br.com.apisecreto.domain.usecase.group.CreateGroupUseCase;
import br.com.apisecreto.domain.usecase.group.GetAllGroupsUseCase;
import br.com.apisecreto.domain.usecase.group.GroupParticipantMatchUseCase;
import br.com.apisecreto.persistence.entities.GroupEntity;
import br.com.apisecreto.persistence.repositories.GroupRepository;
import br.com.apisecreto.presentation.dtos.GroupDTOMapper;
import br.com.apisecreto.presentation.dtos.request.GroupMatchRequestDTO;
import br.com.apisecreto.presentation.dtos.request.GroupRequestDTO;
import br.com.apisecreto.presentation.dtos.response.GroupResponseDTO;
import br.com.apisecreto.presentation.exceptions.GroupAlreadyMatchedParticipantsException;
import br.com.apisecreto.presentation.exceptions.GroupNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupDTOMapper groupDTOMapper;
    private final CreateGroupUseCase createGroupUseCase;
    private final GetAllGroupsUseCase getAllGroupsUseCase;
    private final GroupParticipantMatchUseCase groupParticipantMatchUseCase;
    private final GroupMapper groupMapper;

    public GroupController(GroupDTOMapper groupDTOMapper, CreateGroupUseCase createGroupUseCase, GetAllGroupsUseCase getAllGroupsUseCase, GroupRepository groupRepository, GroupRepository groupRepository1, GroupParticipantMatchUseCase groupParticipantMatchUseCase, GroupMapper groupMapper) {
        this.groupDTOMapper = groupDTOMapper;
        this.createGroupUseCase = createGroupUseCase;
        this.getAllGroupsUseCase = getAllGroupsUseCase;
        this.groupParticipantMatchUseCase = groupParticipantMatchUseCase;
        this.groupMapper = groupMapper;
    }

    @GetMapping
    public ResponseEntity<List<GroupResponseDTO>> getAll() {
        List<Group> groups = getAllGroupsUseCase.execute();
        List<GroupResponseDTO> groupResponseDTOList = groups.stream().map(groupDTOMapper::toResponseDTO).toList();
        return new ResponseEntity<>(groupResponseDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GroupResponseDTO> createGroup(@RequestBody GroupRequestDTO groupRequestDTO) {
        Group group = groupDTOMapper.toDomainEntity(groupRequestDTO);
        group = createGroupUseCase.execute(group);
        return new ResponseEntity<>(groupDTOMapper.toResponseDTO(group), HttpStatus.CREATED);
    }

    @PostMapping("/match")
    public ResponseEntity<GroupResponseDTO> matchUsersPartipants(@RequestBody GroupMatchRequestDTO groupMatchRequestDTO) throws GroupNotFoundException, GroupAlreadyMatchedParticipantsException {
        GroupEntity groupEntity = groupDTOMapper.toEntity(groupMatchRequestDTO);
        if (groupEntity == null) throw new GroupNotFoundException("Group informed not found", 404);
        Group group = groupParticipantMatchUseCase.execute(groupMapper.toDomainEntity(groupEntity));
        return new ResponseEntity<>(groupDTOMapper.toResponseDTO(group), HttpStatus.OK);
    }
}

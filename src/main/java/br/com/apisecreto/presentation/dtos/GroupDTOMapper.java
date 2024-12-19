package br.com.apisecreto.presentation.dtos;

import br.com.apisecreto.domain.entities.Group;
import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.persistence.entities.GroupEntity;
import br.com.apisecreto.presentation.dtos.request.GroupMatchRequestDTO;
import br.com.apisecreto.presentation.dtos.request.GroupRequestDTO;
import br.com.apisecreto.presentation.dtos.response.GroupResponseDTO;

public class GroupDTOMapper {
    private final UserDTOMapper userDTOMapper;

    public GroupDTOMapper(UserDTOMapper userDTOMapper) {
        this.userDTOMapper = userDTOMapper;
    }

    public GroupEntity toEntity(GroupRequestDTO groupRequestDTO) {
        return new GroupEntity(groupRequestDTO.name(), groupRequestDTO.description(), groupRequestDTO.secretPhrase());
    }

    public GroupEntity toEntity(GroupMatchRequestDTO groupMatchRequestDTO) {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setGroupId(groupMatchRequestDTO.groupId());
        groupEntity.setSecretPhrase(groupMatchRequestDTO.secretPhrase());
        return groupEntity;
    }

    public Group toDomainEntity(GroupRequestDTO groupRequestDTO) {
        return new Group(groupRequestDTO.name(), groupRequestDTO.description(), groupRequestDTO.secretPhrase());
    }

    public GroupResponseDTO toResponseDTO(Group group) {
        return new GroupResponseDTO(group.getName(), group.getUsers().stream().map(user -> userDTOMapper.toResponseDTO(user)).toList());
    }
}

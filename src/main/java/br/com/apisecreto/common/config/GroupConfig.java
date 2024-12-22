package br.com.apisecreto.common.config;

import br.com.apisecreto.application.GroupMapper;
import br.com.apisecreto.application.UserMapper;
import br.com.apisecreto.application.usecase.group.CreateGroupUseCaseImpl;
import br.com.apisecreto.application.usecase.group.GetAllGroupsUseCaseImpl;
import br.com.apisecreto.application.usecase.group.GroupParticipantMatchUseCaseImpl;
import br.com.apisecreto.domain.usecase.group.CreateGroupUseCase;
import br.com.apisecreto.domain.usecase.group.GetAllGroupsUseCase;
import br.com.apisecreto.domain.usecase.group.GroupParticipantMatchUseCase;
import br.com.apisecreto.persistence.repositories.GroupRepository;
import br.com.apisecreto.persistence.repositories.UserRepository;
import br.com.apisecreto.presentation.dtos.GroupDTOMapper;
import br.com.apisecreto.presentation.dtos.UserDTOMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GroupConfig {
    @Bean
    public GroupMapper groupMapper(UserMapper userMapper) {
        return new GroupMapper(userMapper);
    }

    @Bean
    public GroupDTOMapper groupDTOMapper(UserDTOMapper userDTOMapper) {
        return new GroupDTOMapper(userDTOMapper);
    }

    @Bean
    CreateGroupUseCase createGroupUseCase(GroupRepository groupRepository, GroupMapper groupMapper) {
        return new CreateGroupUseCaseImpl( groupRepository, groupMapper);
    }

    @Bean
    GetAllGroupsUseCase getAllGroupsUseCase(GroupRepository groupRepository, GroupMapper groupMapper) {
        return new GetAllGroupsUseCaseImpl(groupRepository, groupMapper);
    }

    @Bean
    GroupParticipantMatchUseCase groupParticipantMatchUseCase(GroupRepository groupRepository, UserRepository userRepository, GroupMapper groupMapper, UserMapper userMapper) {
        return new GroupParticipantMatchUseCaseImpl(groupRepository, userRepository, groupMapper, userMapper);
    }
}

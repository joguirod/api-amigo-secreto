package br.com.apisecreto.common.config;

import br.com.apisecreto.application.GroupMapper;
import br.com.apisecreto.application.UserMapper;
import br.com.apisecreto.application.usecase.group.CreateGroupUseCaseImpl;
import br.com.apisecreto.domain.usecase.group.CreateGroupUseCase;
import br.com.apisecreto.persistence.repositories.GroupRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GroupConfig {
    @Bean
    public GroupMapper groupMapper(UserMapper userMapper) {
        return new GroupMapper(userMapper);
    }

    @Bean
    CreateGroupUseCase createGroupUseCase(GroupRepository groupRepository, GroupMapper groupMapper) {
        return new CreateGroupUseCaseImpl( groupRepository, groupMapper);
    }
}

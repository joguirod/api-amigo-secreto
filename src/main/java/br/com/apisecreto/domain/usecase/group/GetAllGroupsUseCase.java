package br.com.apisecreto.domain.usecase.group;

import br.com.apisecreto.domain.entities.Group;

import java.util.List;

public interface GetAllGroupsUseCase {
    List<Group> execute();
}

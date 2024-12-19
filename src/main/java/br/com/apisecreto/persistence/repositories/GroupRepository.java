package br.com.apisecreto.persistence.repositories;

import br.com.apisecreto.persistence.entities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<GroupEntity, UUID> {
    GroupEntity findByName(String name);
}

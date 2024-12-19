package br.com.apisecreto.persistence.repositories;

import br.com.apisecreto.persistence.entities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
}

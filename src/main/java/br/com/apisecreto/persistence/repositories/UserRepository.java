package br.com.apisecreto.persistence.repositories;

import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean findByEmail(String email);
}

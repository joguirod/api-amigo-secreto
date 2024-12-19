package br.com.apisecreto.persistence.repositories;

import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}

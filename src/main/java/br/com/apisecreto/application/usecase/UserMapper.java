package br.com.apisecreto.application.usecase;

import br.com.apisecreto.domain.entities.User;
import br.com.apisecreto.persistence.entities.UserEntity;

public class UserMapper {
    public UserEntity toEntity(User user) {
        return new UserEntity(user.getName(), user.getEmail(), user.getPassword(), user.getPreferences());
    }

    public User toDomainEntity(UserEntity userEntity) {
        return new User(userEntity.getName(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getPreferences());
    }
}

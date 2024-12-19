package br.com.apisecreto.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity(name = "userEntity")
@Table(name = "userEntity")
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String preferences;
    @OneToOne
    private UserEntity matchedUser;
    @ManyToOne
    private GroupEntity groupJoined;

    public UserEntity(String name, String email, String password, String preferences) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.preferences = preferences;
    }

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public UserEntity getMatchedUser() {
        return matchedUser;
    }

    public void setMatchedUser(UserEntity matchedUser) {
        this.matchedUser = matchedUser;
    }

    public GroupEntity getGroupJoined() {
        return groupJoined;
    }

    public void setGroupJoined(GroupEntity groupJoined) {
        this.groupJoined = groupJoined;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

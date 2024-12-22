package br.com.apisecreto.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name="groupEntity")
@Table(name="groupEntity")
@EqualsAndHashCode
@AllArgsConstructor
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID groupId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = true)
    private String description;
    @Column(nullable = false)
    private String secretPhrase;
    @Column(nullable = true)
    private boolean alreadyMatchedParticipants = false;
    // um grupo tem vários usuários, usuários podem participar de vários grupos
    @OneToMany
    private List<UserEntity> participantUsers;

    public GroupEntity() {
    }

    public GroupEntity(String name, String description, String secretPhrase) {
        this.name = name;
        this.description = description;
        this.secretPhrase = secretPhrase;
        this.participantUsers = new ArrayList<>();
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSecretPhrase() {
        return secretPhrase;
    }

    public void setSecretPhrase(String secretPhrase) {
        this.secretPhrase = secretPhrase;
    }

    public boolean isAlreadyMatchedParticipants() {
        return alreadyMatchedParticipants;
    }

    public void setAlreadyMatchedParticipants(boolean alreadyMatchedParticipants) {
        this.alreadyMatchedParticipants = alreadyMatchedParticipants;
    }

    public List<UserEntity> getParticipantUsers() {
        return participantUsers;
    }

    public void setParticipantUsers(List<UserEntity> participantUsers) {
        this.participantUsers = participantUsers;
    }
}




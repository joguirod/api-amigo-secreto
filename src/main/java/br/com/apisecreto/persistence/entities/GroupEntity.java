package br.com.apisecreto.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="group")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = true)
    private String description;
    @Column(nullable = false)
    private String secretPhrase;
    // um grupo tem vários usuários, usuários podem participar de vários grupos
    @OneToMany
    private List<UserEntity> participantUsers;

    public GroupEntity(String name, String description, String secretPhrase) {
        this.name = name;
        this.description = description;
        this.secretPhrase = secretPhrase;
    }
}




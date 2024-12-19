package br.com.apisecreto.domain.entities;

import java.util.List;

public class Group {
    private String name;
    private String description;
    private String secretPhrase;
    private List<User> users;

    public Group() {
    }

    public Group(String name, String description, String secretPhrase) {
        this.name = name;
        this.description = description;
        this.secretPhrase = secretPhrase;
    }

    public Group(String name, String description, String secretPhrase, List<User> users) {
        this.name = name;
        this.description = description;
        this.secretPhrase = secretPhrase;
        this.users = users;
    }

    public String getSecretPhrase() {
        return secretPhrase;
    }

    public void setSecretPhrase(String secretPhrase) {
        this.secretPhrase = secretPhrase;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

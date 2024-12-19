package br.com.apisecreto.domain.entities;

public class User {
    private String name;
    private String email;
    private String password;
    private String preferences;
    // para quem deverá ser dado o presente
    private User matchedUser;
    private Group groupJoined;

    public User() {
    }

    public User(String name, String email, String password, String preferences) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.preferences = preferences;
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

    public User getMatchedUser() {
        return matchedUser;
    }

    public void setMatchedUser(User matchedUser) {
        this.matchedUser = matchedUser;
    }

    public Group getGroupJoined() {
        return groupJoined;
    }

    public void setGroupJoined(Group groupJoined) {
        this.groupJoined = groupJoined;
    }
}

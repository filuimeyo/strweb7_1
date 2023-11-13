package by.iba.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String login;
    private String passw;

    public User(String login, String passw) {
        this.login = login;
        this.passw = passw;
    }
}

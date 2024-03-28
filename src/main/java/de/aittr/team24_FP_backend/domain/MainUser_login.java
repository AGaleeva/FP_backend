package de.aittr.team24_FP_backend.domain;

import de.aittr.team24_FP_backend.domain.interfaces.User_login;
import jakarta.persistence.*;
import lombok.Builder;


@Builder
@Entity
@Table(name = "user_login")
public class MainUser_login implements User_login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public MainUser_login() {
    }

    public MainUser_login(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User_login: id = %d, email = %s".formatted(id, email);
    }
}

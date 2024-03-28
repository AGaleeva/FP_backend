package de.aittr.team24_FP_backend.domain;

import de.aittr.team24_FP_backend.domain.interfaces.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class MainRole implements Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public MainRole() {
    }

    public MainRole(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
this.name = name;
    }

    public String toString() {
        return "Role: id = %d, name = %s".formatted(id, name);
    }
}

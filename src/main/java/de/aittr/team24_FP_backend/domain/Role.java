package de.aittr.team24_FP_backend.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role implements de.aittr.team24_FP_backend.domain.interfaces.Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "rolename")
    private String rolename;

    public Role() {
    }

    public Role(int id, String rolename) {
        this.id = id;
        this.rolename = rolename;
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
    public String getRolename() {
        return rolename;
    }

    @Override
    public void setRolename(String rolename) {
this.rolename = rolename;
    }
}

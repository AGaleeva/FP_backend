package de.aittr.team24_FP_backend.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cultural_life_info")
public class Cultural_life_info implements de.aittr.team24_FP_backend.domain.interfaces.Cultural_life_info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    public Cultural_life_info() {
    }

    public Cultural_life_info(int id, String title, String description, Date date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
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
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Cultural_life: id = %d, title = %s, description = %s, date = %s".formatted(id, title, description, date);
    }
}

package de.aittr.team24_FP_backend.domain;

import de.aittr.team24_FP_backend.domain.interfaces.General_news;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "general_news")
public class MainGeneral_news implements General_news {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;


    public MainGeneral_news() {
    }

    public MainGeneral_news(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
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
    public String toString() {
        return "News: id = %d, title = %s, description = %s".formatted(id, title, description);
    }
}

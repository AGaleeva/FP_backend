package de.aittr.team24_FP_backend.domain.oldFilesToDelete;

import de.aittr.team24_FP_backend.domain.interfaces.Cultural_life_info;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cultural_life_info")
public class MainCultural_life_info implements Cultural_life_info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;


    public MainCultural_life_info() {
    }

    public MainCultural_life_info(int id, String title, String description) {
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
        return "Cultural_life: id = %d, title = %s, description = %s".formatted(id, title, description);
    }
}

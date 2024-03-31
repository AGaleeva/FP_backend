package de.aittr.team24_FP_backend.domain.berlin;

import de.aittr.team24_FP_backend.domain.interfaces.Cultural_life_info;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "berlin_cultural_life_info")
public class BerlinCulturalLifeInfo implements Cultural_life_info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    public BerlinCulturalLifeInfo() {
    }

    public BerlinCulturalLifeInfo(int id, String title, String description) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BerlinCulturalLifeInfo that = (BerlinCulturalLifeInfo) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }

    @Override
    public String toString() {
        return "Berlin_cultural_life: id = %d, title = %s, description = %s".formatted(id, title, description);
    }
}

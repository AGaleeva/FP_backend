package de.aittr.team24_FP_backend.domain.munchen;

import de.aittr.team24_FP_backend.domain.interfaces.Restaurants_info;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "munchen_restaurants_info")
public class Munchen_restaurants_info implements Restaurants_info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    public Munchen_restaurants_info() {
    }

    public Munchen_restaurants_info(int id, String title, String description) {
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
        Munchen_restaurants_info that = (Munchen_restaurants_info) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }

    @Override
    public String toString() {
        return "Munchen_restaurants_info: id = %d, title = %s, description = %s".formatted(id, title, description);
    }
}


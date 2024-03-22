package de.aittr.team24_FP_backend.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User implements de.aittr.team24_FP_backend.domain.interfaces.User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "news")
    private Boolean news;

    @Column(name = "cultural_life")
    private Boolean cultural_life;

    @Column(name = "children")
    private Boolean children;

    @Column(name = "health")
    private Boolean health;

    @Column(name = "shop")
    private Boolean shop;

    @Column(name = "cafe")
    private Boolean cafe;

    @Column(name = "service")
    private Boolean service;


    public User() {
    }

    public User(int id, String email, String password, String firstName, String lastName
            , Date date_of_birth, Boolean news, Boolean cultural_life, Boolean children,
                Boolean health, Boolean shop, Boolean cafe, Boolean service) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date_of_birth = date_of_birth;
        this.news = news;
        this.cultural_life = cultural_life;
        this.children = children;
        this.health = health;
        this.shop = shop;
        this.cafe = cafe;
        this.service = service;
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
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Date getDate_of_birth() {
        return date_of_birth;
    }

    @Override
    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public boolean getNews() {
        return news;
    }

    @Override
    public void setNews(Boolean news) {
        this.news = news;
    }

    @Override
    public boolean getCultural_life() {
        return cultural_life;
    }

    @Override
    public void setCultural_life(Boolean cultural_life) {
        this.cultural_life = cultural_life;
    }

    @Override
    public boolean getChildren() {
        return children;
    }

    @Override
    public void setChildren(Boolean children) {
        this.children = children;
    }

    @Override
    public boolean getHealth() {
        return health;
    }

    @Override
    public void setHealth(Boolean health) {
        this.health = health;
    }

    @Override
    public boolean getShop() {
        return shop;
    }

    @Override
    public void setShop(Boolean shop) {
        this.shop = shop;
    }

    @Override
    public boolean getCafe() {
        return cafe;
    }

    @Override
    public void setCafe(Boolean cafe) {
        this.cafe = cafe;
    }

    @Override
    public boolean getService() {
        return service;
    }

    @Override
    public void setService(Boolean service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return ("User: id=%d, email=%s, password=%s, firstName=%s, lastName=%s, date_of_birth=%s,news=%b, cultural_life=%b" +
                ", children=%b, health=%b, shop=%b, cafe=%b, service=%b").formatted(id, email, password, firstName
                , lastName, date_of_birth, news, cultural_life, children, health, shop, cafe, service);
    }

}

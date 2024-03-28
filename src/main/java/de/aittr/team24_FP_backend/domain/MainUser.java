package de.aittr.team24_FP_backend.domain;

import de.aittr.team24_FP_backend.domain.interfaces.User;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.Date;


@Builder
@Entity
@Table(name = "user")
public class MainUser implements User {

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

    @Column(name = "general_news")
    private Boolean general_news;

    @Column(name = "cultural_life_info")
    private Boolean cultural_life_info;

    @Column(name = "children_info")
    private Boolean children_info;

    @Column(name = "health_info")
    private Boolean health_info;

    @Column(name = "shops_info")
    private Boolean shops_info;

    @Column(name = "restaurants_info")
    private Boolean restaurants_info;

    @Column(name = "services_info")
    private Boolean services_info;


    public MainUser() {
    }

    public MainUser(int id, String email, String password, String firstName, String lastName
            , Date date_of_birth, Boolean general_news, Boolean cultural_life_info, Boolean children_info,
                    Boolean health_info, Boolean shops_info, Boolean restaurants_info, Boolean services_info) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date_of_birth = date_of_birth;
        this.general_news = general_news;
        this.cultural_life_info = cultural_life_info;
        this.children_info = children_info;
        this.health_info = health_info;
        this.shops_info = shops_info;
        this.restaurants_info = restaurants_info;
        this.services_info = services_info;
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
    public boolean getGeneral_news() {
        return general_news;
    }

    @Override
    public void setGeneral_news(Boolean general_news) {
        this.general_news = general_news;
    }

    @Override
    public boolean getCultural_life_info() {
        return cultural_life_info;
    }

    @Override
    public void setCultural_life_info(Boolean cultural_life_info) {
        this.cultural_life_info = cultural_life_info;
    }

    @Override
    public boolean getChildren_info() {
        return children_info;
    }

    @Override
    public void setChildren_info(Boolean children_info) {
        this.children_info = children_info;
    }

    @Override
    public boolean getHealth_info() {
        return health_info;
    }

    @Override
    public void setHealth_info(Boolean health_info) {
        this.health_info = health_info;
    }

    @Override
    public boolean getShops_info() {
        return shops_info;
    }

    @Override
    public void setShops_info(Boolean shops_info) {
        this.shops_info = shops_info;
    }

    @Override
    public boolean getRestaurants_info() {
        return restaurants_info;
    }

    @Override
    public void setRestaurants_info(Boolean restaurants_info) {
        this.restaurants_info = restaurants_info;
    }

    @Override
    public boolean getServices_info() {
        return services_info;
    }

    @Override
    public void setServices_info(Boolean services_info) {
        this.services_info = services_info;
    }


    @Override
    public String toString() {
        return ("User: id=%d, email=%s, password=%s, firstName=%s, lastName=%s, date_of_birth=%s,news=%b, cultural_life=%b" +
                ", children=%b, health=%b, shop=%b, cafe=%b, service=%b").formatted(id, email, password, firstName
                , lastName, date_of_birth, general_news, cultural_life_info, children_info, health_info, shops_info
                , restaurants_info, services_info);
    }
}

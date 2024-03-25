package de.aittr.team24_FP_backend.domain.interfaces;

import java.util.Date;

public interface User {

    int getId();
    void setId(int id);

    String getEmail();
    void setEmail(String email);

    String getPassword();
    void setPassword(String password);

    String getFirstName();
    void setFirstName(String firstName);

    String getLastName();
    void setLastName(String lastName);

    Date getDate_of_birth();
    void setDate_of_birth(Date date_of_birth);

    boolean getGeneral_news();
    void setGeneral_news(Boolean general_news);

    boolean getCultural_life_info();
    void setCultural_life_info(Boolean cultural_life_info);

    boolean getChildren_info();
    void setChildren_info(Boolean children_info);

    boolean getHealth_info();
    void  setHealth_info(Boolean health_info);

    boolean getShops_info();
    void setShops_info(Boolean shops_info);

    boolean getRestaurants_info();
    void setRestaurants_info(Boolean restaurants_info);

    boolean getServices_info();
    void setServices_info(Boolean services_info);
}

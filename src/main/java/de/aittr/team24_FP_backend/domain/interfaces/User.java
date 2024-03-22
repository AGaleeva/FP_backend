package de.aittr.team24_FP_backend.domain.interfaces;

import java.util.Date;

public interface User {

    int getId();
    void setId(int id);

    String getFirstName();
    void setFirstName(String firstName);

    String getLastName();
    void setLastName(String lastName);

    String getEmail();
    void setEmail(String email);

    String getPassword();
    void setPassword(String password);

    Date getDate_of_birth();
    void setDate_of_birth(Date date_of_birth);

    boolean getNews();
    void setNews(Boolean news);

    boolean getCultural_life();
    void setCultural_life(Boolean cultural_life);

    boolean getChildren();
    void setChildren(Boolean children);

    boolean getHealth();
    void  setHealth(Boolean health);

    boolean getShop();
    void setShop(Boolean shop);

    boolean getCafe();
    void setCafe(Boolean cafe);

    boolean getService();
    void setService(Boolean service);
}

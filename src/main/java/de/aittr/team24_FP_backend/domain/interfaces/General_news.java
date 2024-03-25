package de.aittr.team24_FP_backend.domain.interfaces;

import java.util.Date;

public interface General_news {

    int getId();
    void setId(int id);

    String getTitle();
    void setTitle(String title);

    String getDescription();
    void setDescription(String description);

    Date getDate();
    void setDate(Date date);
}

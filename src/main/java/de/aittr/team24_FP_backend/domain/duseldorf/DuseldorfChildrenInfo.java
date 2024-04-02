package de.aittr.team24_FP_backend.domain.duseldorf;

import de.aittr.team24_FP_backend.domain.interfaces.Children_info;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "duseldorf_children_info")
public class DuseldorfChildrenInfo implements Children_info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "tel")
    private String tel;

    @Column(name = "link")
    private String link;

    @Column(name = "status")
    private Integer status;


    public DuseldorfChildrenInfo() {
    }

    public DuseldorfChildrenInfo(Integer id, String title, String description, String address, String tel, String link, Integer status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.address = address;
        this.tel = tel;
        this.link = link;
        this.status = status;
    }

    @Override
    public Integer getId() {
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
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getTel() {
        return tel;
    }

    @Override
    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String getLink() {
        return link;
    }

    @Override
    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public Integer getStatus() {
        return status;
    }

    @Override
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DuseldorfChildrenInfo that = (DuseldorfChildrenInfo) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(address, that.address) && Objects.equals(tel, that.tel) && Objects.equals(link, that.link) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, address, tel, link, status);
    }

    @Override
    public String toString() {
        return ("BerlinChildrenInfo: id = %d, title = %s, description = %s, address = %s," +
                "tel = %s, link = %s, status = %d").formatted(id, title, description, address, tel,
                link, status);
    }
}

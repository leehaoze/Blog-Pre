package edu.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "type", schema = "blog", catalog = "")
public class TypeEntity {
    private Integer id;
    private String name;
    private Integer num;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "num", nullable = false)
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeEntity that = (TypeEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(num, that.num);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, num);
    }
}

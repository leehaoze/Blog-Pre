package edu.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tag", schema = "blog", catalog = "")
public class TagEntity {
    private int id;
    private String name;
    private int num;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagEntity tagEntity = (TagEntity) o;
        return id == tagEntity.id &&
                num == tagEntity.num &&
                Objects.equals(name, tagEntity.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, num);
    }
}

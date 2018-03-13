package edu.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "site_conf", schema = "blog", catalog = "")
public class SiteConfEntity {
    private int id;
    private String indexPic;
    private String headPic;
    private String blogerName;
    private String quoto;
    private String nameFont;
    private String quotoFont;
    private String qq;
    private String wechat;
    private String github;
    private String email;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "index_pic", nullable = true, length = 255)
    public String getIndexPic() {
        return indexPic;
    }

    public void setIndexPic(String indexPic) {
        this.indexPic = indexPic;
    }

    @Basic
    @Column(name = "head_pic", nullable = true, length = 255)
    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    @Basic
    @Column(name = "bloger_name", nullable = true, length = 255)
    public String getBlogerName() {
        return blogerName;
    }

    public void setBlogerName(String blogerName) {
        this.blogerName = blogerName;
    }

    @Basic
    @Column(name = "quoto", nullable = true, length = 255)
    public String getQuoto() {
        return quoto;
    }

    public void setQuoto(String quoto) {
        this.quoto = quoto;
    }

    @Basic
    @Column(name = "name_font", nullable = true, length = 255)
    public String getNameFont() {
        return nameFont;
    }

    public void setNameFont(String nameFont) {
        this.nameFont = nameFont;
    }

    @Basic
    @Column(name = "quoto_font", nullable = true, length = 255)
    public String getQuotoFont() {
        return quotoFont;
    }

    public void setQuotoFont(String quotoFont) {
        this.quotoFont = quotoFont;
    }

    @Basic
    @Column(name = "qq", nullable = true, length = 255)
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "wechat", nullable = true, length = 255)
    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    @Basic
    @Column(name = "github", nullable = true, length = 255)
    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiteConfEntity that = (SiteConfEntity) o;
        return id == that.id &&
                Objects.equals(indexPic, that.indexPic) &&
                Objects.equals(headPic, that.headPic) &&
                Objects.equals(blogerName, that.blogerName) &&
                Objects.equals(quoto, that.quoto) &&
                Objects.equals(nameFont, that.nameFont) &&
                Objects.equals(quotoFont, that.quotoFont) &&
                Objects.equals(qq, that.qq) &&
                Objects.equals(wechat, that.wechat) &&
                Objects.equals(github, that.github) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, indexPic, headPic, blogerName, quoto, nameFont, quotoFont, qq, wechat, github, email);
    }
}

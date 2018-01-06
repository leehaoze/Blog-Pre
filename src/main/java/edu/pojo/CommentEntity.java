package edu.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "comment", schema = "blog", catalog = "")
public class CommentEntity {
    private Integer id;
    private Integer authorId;
    private Integer articleId;
    private String content;
    private Timestamp date;
    private Boolean see;
    private Integer towardId;
    private Integer agent;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "author_id", nullable = false)
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "article_id", nullable = false)
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "see", nullable = true)
    public Boolean getSee() {
        return see;
    }

    public void setSee(Boolean see) {
        this.see = see;
    }

    @Basic
    @Column(name = "toward_id", nullable = true)
    public Integer getTowardId() {
        return towardId;
    }

    public void setTowardId(Integer towardId) {
        this.towardId = towardId;
    }

    @Basic
    @Column(name = "agent", nullable = true)
    public Integer getAgent() {
        return agent;
    }

    public void setAgent(Integer agent) {
        this.agent = agent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentEntity that = (CommentEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(authorId, that.authorId) &&
                Objects.equals(articleId, that.articleId) &&
                Objects.equals(content, that.content) &&
                Objects.equals(date, that.date) &&
                Objects.equals(see, that.see) &&
                Objects.equals(towardId, that.towardId) &&
                Objects.equals(agent, that.agent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, authorId, articleId, content, date, see, towardId, agent);
    }
}

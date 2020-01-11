package com.kevin.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author kevin
 * @ClassName
 * @Date 2020/1/10
 */
//告诉jpa这是一个实体类
@Entity
@Table(name = "article")
public class Article {

    @Column(name = "aid")
    //标识此字段为主键
    @Id
    //标识主键的生成策略为自增长
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aid;
    @Column(name = "author")
    private String author;
    @Column(name = "createTime")
    private Date createTime;
    @Column(name = "title")
    private String title;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aid=" + aid +
                ", author='" + author + '\'' +
                ", createTime=" + createTime +
                ", title='" + title + '\'' +
                '}';
    }
}


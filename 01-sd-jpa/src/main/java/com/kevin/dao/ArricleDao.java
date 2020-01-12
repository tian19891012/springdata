package com.kevin.dao;

import com.kevin.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author kevin
 * @ClassName
 * @Date 2020/1/110:31
 * Article  实体类的类型
 * Integer  实体类的主键的类型
 */
public interface ArricleDao
        extends JpaRepository<Article,Integer>, JpaSpecificationExecutor<Article> {


    List<Article> findByTitle(String title);

    @Query("from Article a where a.title = ?1")
    List<Article> findByCondition(String title);

    @Query("from Article a where a.title = :title")
    List<Article> findByCondition1(@Param("title") String title);
}


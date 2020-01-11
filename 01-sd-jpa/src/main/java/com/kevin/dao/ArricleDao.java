package com.kevin.dao;

import com.kevin.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author kevin
 * @ClassName
 * @Date 2020/1/110:31
 * Article  实体类的类型
 * Integer  实体类的主键的类型
 */
public interface ArricleDao
        extends JpaRepository<Article,Integer>, JpaSpecificationExecutor<Article> {

}


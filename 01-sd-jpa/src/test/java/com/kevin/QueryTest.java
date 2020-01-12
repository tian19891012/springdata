package com.kevin;

import com.kevin.dao.ArricleDao;
import com.kevin.domain.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author kevin
 * @ClassName
 * @Date 2020/1/111:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-jpa.xml")
public class QueryTest {

    @Autowired
    private ArricleDao arricleDao;

    @Test
    public void testSave() {

        String title = "tian2";
        List<Article> articles = arricleDao.findByTitle(title);
        for (Article article : articles) {
            System.out.println(article);
        }

    }

    @Test
    public void test1() {

        String title = "tian2";
        List<Article> articles = arricleDao.findByCondition(title);
        for (Article article : articles) {
            System.out.println(article);
        }

    }

    @Test
    public void test2() {

        String title = "tian2";
        List<Article> articles = arricleDao.findByCondition1(title);
        for (Article article : articles) {
            System.out.println(article);
        }

    }


}


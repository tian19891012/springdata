package com.kevin;

import com.kevin.dao.ArricleDao;
import com.kevin.domain.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author kevin
 * @ClassName
 * @Date 2020/1/111:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-jpa.xml")
public class SpringDataTest {

    @Autowired
    private ArricleDao arricleDao;

    @Test
    public void testSave() {


        for (int i = 0; i < 100; i++) {

            Article article = new Article();
            article.setAuthor("kevin" + i);
            article.setCreateTime(new Date());
            article.setTitle("tian" + i);
            arricleDao.save(article);
        }


    }

    @Test
    public void testQueryById() {

        Optional<Article> article = arricleDao.findById(1);
        System.out.println(article.get());
    }

    @Test
    public void testQueryAll() {

        List<Article> articleList = arricleDao.findAll();
        System.out.println(articleList);
    }

    /**
     * SpringData jpa 的保存和修改都是save方法
     * 关键看实体传入的时候有没有主键
     * 如果没有主键就是保存方法
     * 如果有主键就是修改方法
     */
    @Test
    public void testUpdate() {
        Integer id = 2;
        Optional<Article> article = arricleDao.findById(id);

        article.get().setTitle("田文凯测试再更新的时候先查询");
        article.get().setAid(id);


        arricleDao.save(article.get());

    }
}


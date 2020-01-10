package org.kevin.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kevin.model.Article;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * @author kevin
 * @ClassName
 * @Date 2020/1/922:38
 */
public class JpaTest {

    String persistenceUnitName = "jpa01";
    EntityManagerFactory factory = null;
    EntityManager entityManager = null;
    EntityTransaction transaction = null;


    @Before
    public void setUp() throws Exception {
        //创建一个持久化管理工厂

        factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        //创建持久化管理器
        entityManager = factory.createEntityManager();
        //得到事务，开启
        transaction = entityManager.getTransaction();
        transaction.begin();
    }

    @After
    public void tearDown() throws Exception {
        //关闭资源
        if (entityManager != null) {
            entityManager.close();
        }

    }

    @Test
    public void testSave() {

        Article article = new Article();
        article.setAuthor("kevin");
        article.setCreateTime(new Date());
        article.setTitle("jpa测试");

        //操作
        entityManager.persist(article);
        //提交事务
        transaction.commit();

    }

    @Test
    public void testFind() {

        //操作
        Article article = entityManager.find(Article.class, 2);
        System.out.println(article);

        //提交事务
        transaction.commit();

    }

    @Test
    public void testUpdate() {

        //操作
        Article article = entityManager.find(Article.class, 2);
        article.setAuthor("田文凯");
        entityManager.merge(article);
        System.out.println(article);

        //提交事务
        transaction.commit();

    }

    @Test
    public void testDelete() {

        //操作
        Article article = entityManager.find(Article.class, 2);
        entityManager.remove(article);
        System.out.println(article);

        //提交事务
        transaction.commit();

    }
}


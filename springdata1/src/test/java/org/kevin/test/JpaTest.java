package org.kevin.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kevin.model.Article;
import org.kevin.model.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author kevin
 * @ClassName
 * @Date 2020/1/922:38
 */
public class JpaTest {

    String persistenceUnitName = "jpa01";
    EntityManagerFactory factory = null;
    //默认开启一级缓存
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

        //操作  JPA的修改操作，要求必须先查询，再修改
        Article article = entityManager.find(Article.class, 2);
        article.setAuthor("田文凯");
        entityManager.merge(article);
        System.out.println(article);

        //提交事务
        transaction.commit();

    }

    @Test
    public void testDelete() {

        //操作 JPA的删除操作，要求必须先查询，再修改
        Article article = entityManager.find(Article.class, 2);
        entityManager.remove(article);
        System.out.println(article);

        //提交事务
        transaction.commit();

    }

    @Test
    public void testList(){

        TypedQuery<User> query = entityManager.createQuery("select u FROM User u", User.class);
        List<User> userList = query.getResultList();
        System.out.println(userList);
    }

    @Test
    public void findUserById(){

        User user1 = entityManager.find(User.class, 1l);
        User user2 = entityManager.find(User.class, 1l);
        System.out.println(user1);
        System.out.println(user2);

    }

    @Test
    public void findUserById1(){

        User reference = entityManager.getReference(User.class, 1l);
        System.out.println(reference);

    }
}


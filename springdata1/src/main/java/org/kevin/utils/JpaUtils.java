package org.kevin.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author kevin
 * @ClassName
 * @Date 2020/1/1819:59
 */
public class JpaUtils {

    private static final String PERSISTENCEUNITNAME = "jpa01";
    EntityManagerFactory factory = null;
    public static EntityManager getEntityManager(){

        EntityManagerFactory fa = Persistence.createEntityManagerFactory(PERSISTENCEUNITNAME);
        EntityManager entityManager = fa.createEntityManager();
        return entityManager;

    }
}


package org.kevin.test;

import org.junit.Test;
import org.kevin.model.Department;
import org.kevin.model.Employee;
import org.kevin.utils.JpaUtils;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @ClassName
 * @Date 2020/1/922:38
 */
public class JpaTest {


    /**
     * 单向一对多测试
     */
    @Test
    public void testOne2ManySave() {
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        employee1.setName("kevin");
        employee2.setName("tian");

        Department department = new Department();

        department.setName("java开发");

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(employee1);
        employees.add(employee2);

        department.setEmployees(employees);

        EntityManager em = JpaUtils.getEntityManager();
        em.getTransaction().begin();

        em.persist(employee1);
        em.persist(employee2);
        em.persist(department);
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void testOne2ManyGet() {


    }
}


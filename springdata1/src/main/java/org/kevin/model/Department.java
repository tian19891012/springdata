package org.kevin.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @author kevin
 * @ClassName
 * @Date 2020/1/1819:06
 */
@Entity
@Getter
@Setter
@ToString
public class Department {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany
    private List<Employee> employees;
}


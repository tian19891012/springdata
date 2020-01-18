package org.kevin.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author kevin
 * @ClassName
 * @Date 2020/1/1819:06
 */

@Getter
@Setter
@ToString
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;


}


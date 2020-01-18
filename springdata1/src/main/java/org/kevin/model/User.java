package org.kevin.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @author kevin
 * @ClassName
 * @Date 2020/1/1621:13
 */
@Getter
@Setter
@ToString
@Entity
@Table
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;

    //对日期属性做映射
    @Temporal(TemporalType.DATE)
    private Date hiredate;

    private String sn;
}


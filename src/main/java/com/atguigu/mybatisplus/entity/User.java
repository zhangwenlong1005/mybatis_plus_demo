package com.atguigu.mybatisplus.entity;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * @author wenlong-Zhang
 * @create 2022-10-12 9:44
 */
@Data //lombok注解
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

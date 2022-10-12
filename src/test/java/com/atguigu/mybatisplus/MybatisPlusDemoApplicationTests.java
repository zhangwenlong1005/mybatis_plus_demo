package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.entity.User;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MybatisPlusDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public void testSelectList(){
//selectList()根据MP内置的条件构造器查询一个list集合，null表示没有条件，即查询所有
        userMapper.selectList(null).forEach(System.out::println);
    }
//    测试方法返回值都是void
    @Test
    public void testAdd(){
        User user = new User();
        user.setId(null);
        user.setAge(25);
        user.setName("小狐狸");
        user.setEmail("123456789@qq.com");
        int i = userMapper.insert(user);
        System.out.println(i);
    }
    @Test
    void selTest(){
        // Arrays.asList(1L, 2L, 3L);    构造一个集合
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        List<User> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);
//        System.out.println(users);
    }
    @Test
    void countTest(){
        long count = userService.count();
        System.out.println("总记录数:"+count);
    }



}

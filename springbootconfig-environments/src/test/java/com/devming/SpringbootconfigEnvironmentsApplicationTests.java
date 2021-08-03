package com.devming;

import com.devming.pojo.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootconfigEnvironmentsApplicationTests {

//    自动注入（装配）
    @Autowired
//    @Qualifier //实例化多个类时
    private Dog dog;
//    private Dog dog2;

    @Test
    void contextLoads() {
        System.out.println(dog);
    }

}

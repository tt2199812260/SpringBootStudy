package com.mingdev;

import com.mingdev.service.UserServicelmpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroSpringbootApplicationTests {
    @Autowired
    UserServicelmpl userServicelmpl;

    @Test
    void contextLoads() {
        System.out.println(userServicelmpl.queryUserByName("mingdev"));
    }

}

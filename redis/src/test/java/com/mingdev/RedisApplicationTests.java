package com.mingdev;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mingdev.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootTest
class RedisApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {

//        redisTemplate.   操作不同的数据类型
//         opsForCluster();
//         opsForGeo();
//         opsForHash();
//         opsForHyperLogLog();
//         opsForList();  操作list 类似List
//         opsForSet();
//         opsForStream();
//         opsForValue();  操作字符串 类似String
//         opsForZSet();

//        除了基本的操作，我们常用的方法都可以直接通过redisTemplate操作，比如事务，和基本的CRUD
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        connection.flushAll();

        redisTemplate.opsForValue().set("mykey","MingDev");
        System.out.println(redisTemplate.opsForValue().get("mykey"));


    }



    @Test
    void  test1() throws JsonProcessingException {
        //开发通常使用json来传递对象
        User user = new User("MingDev", 3);
        String jsonUser = new ObjectMapper().writeValueAsString(user);
//        redisTemplate.opsForValue().set("user",jsonUser);

        redisTemplate.opsForValue().set("user",user);  //pojo没有序列化会报错：org.springframework.data.redis.serializer.SerializationException: Cannot serialize;
        System.out.println(redisTemplate.opsForValue().get("user"));

    }

}

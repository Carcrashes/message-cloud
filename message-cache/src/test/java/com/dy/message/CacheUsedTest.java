package com.dy.message;


import com.msb.framework.redis.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CacheUsedTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisClient redisClient;

     @Test
    public void testCacheHash(){
         Map<String, Object> map=new HashMap<>();
         map.put("phone","17680154849");
         map.put("birthday", LocalDate.now());
         redisTemplate.opsForHash().putAll("test:hash:1",map);
     }

     @Test
     public void testCacheString(){
         redisClient.set("test:1","111111");
     }


}

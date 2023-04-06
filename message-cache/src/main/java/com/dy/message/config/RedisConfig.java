package com.dy.message.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@Configuration
public class RedisConfig {

    @Bean
    public <T> RedisTemplate<String,T> redisTemplate(RedisConnectionFactory connectionFactory,RedisSerializer<Object> redisSerializer){
        //1.构建redisTemplate对象
        RedisTemplate<String,T> redisTemplate=new RedisTemplate<>();

        //2.设置connectFactory
        redisTemplate.setConnectionFactory(connectionFactory);

        //3.设置key序列化方式
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());

        //4.设置value的序列化方式
        redisTemplate.setValueSerializer(redisSerializer);

        //5.保证生效
        redisTemplate.afterPropertiesSet();

        //6.返回
        return redisTemplate;
    }

    @Bean
    public RedisSerializer<Object> redisSerializer(){
        //1.构建jackson的objectMapper
        ObjectMapper objectMapper=new ObjectMapper();

        //2.设置JDK1.8的日期格式的支持
        DateTimeFormatter dateFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        SimpleModule simpleModule = new JavaTimeModule()
                .addDeserializer(LocalDate.class, new LocalDateDeserializer(dateFormatter))
                .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dateTimeFormatter))
                .addSerializer(LocalDate.class, new LocalDateSerializer(dateFormatter))
                .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter));
        objectMapper.registerModule(simpleModule);

        //构建jacksonJsonRedisSerializer
        Jackson2JsonRedisSerializer<Object> objectJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        objectJackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        return objectJackson2JsonRedisSerializer;

    }
}

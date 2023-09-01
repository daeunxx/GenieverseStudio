package com.studio.genieversestudio.src.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.embedded.RedisServer;

@Slf4j
@RequiredArgsConstructor
@Profile("local")
@Configuration
public class EmbeddedRedisConfig {

    private final RedisProperties redisProperties;

    private RedisServer redisServer;

    @PostConstruct
    public void startRedisServer(){
        redisServer = new RedisServer( redisProperties.getPort());
        redisServer.start();
    }

    @PreDestroy
    public void stopRedisServer(){
        if(redisServer != null){
            redisServer.stop();
        }
    }
}

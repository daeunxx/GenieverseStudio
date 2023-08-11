package com.studio.genieversestudio.src.controller;

import com.studio.genieversestudio.src.service.RedisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Set;

@RestController
public class RedisController {

    @Autowired
    RedisService redisService;

    @GetMapping(value = "/redis/test/setString")
    @ResponseBody
    public void setValue(String key, String value){
        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
        redisService.setValues(key, value);
    }

    @GetMapping(value = "/redis/test/getString")
    @ResponseBody
    public String getValue(String key){
        return redisService.getValues(key);
    }

    @GetMapping(value = "/redis/test/setSets")
    @ResponseBody
    public void setSets(String key, String... values){
        redisService.setSets(key, values);
    }

    @GetMapping(value = "/redis/test/getSets")
    @ResponseBody
    public Set getSets(String key){
        return redisService.getSets(key);
    }
}

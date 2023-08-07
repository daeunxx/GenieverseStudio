package com.studio.genieversestudio.src.controller;

import com.studio.genieversestudio.src.service.RedisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Set;

@Controller
public class RedisController {

    @Autowired
    RedisService redisService;

    @RequestMapping(value = "/redis/test/setString")
    @ResponseBody
    public void setValue(String key, String value){
        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
        redisService.setValues(key, value);
    }

    @RequestMapping(value = "/redis/test/getString")
    @ResponseBody
    public String getValue(String key){
        return redisService.getValues(key);
    }

    @RequestMapping(value = "/redis/test/setSets")
    @ResponseBody
    public void setSets(String key, String... values){
        redisService.setSets(key, values);
    }

    @RequestMapping(value = "/redis/test/getSets")
    @ResponseBody
    public Set getSets(String key){
        return redisService.getSets(key);
    }
}

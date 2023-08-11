package com.studio.genieversestudio.src.service;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import org.springframework.stereotype.Service;

@Service
public class GenieHomeService {

    public int checkFloorplan(StringBuilder builder){

        JSONObject jsonObject = new JSONObject(builder);

        return (int)jsonObject.get("result");
    }

    public int completeFloorplan(StringBuilder builder){

        JSONObject jsonObject = new JSONObject(builder);

        return (int)jsonObject.get("result");
    }
}

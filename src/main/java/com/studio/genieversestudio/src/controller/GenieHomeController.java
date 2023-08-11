package com.studio.genieversestudio.src.controller;

import com.studio.genieversestudio.src.service.GenieHomeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Tag(name="Genieverse Studio Genie Home", description = "Genieverse Studio Genie Home Creation based web")
@RestController
public class GenieHomeController {

    private final GenieHomeService genieHomeService;

    @Autowired
    public GenieHomeController(GenieHomeService genieHomeService){
        this.genieHomeService = genieHomeService;
    }

    @Operation(summary = "지니홈 도면 생성 요청", description = "지니홈 도면 생성 json data 전달(by-pass)")
    @PostMapping("/create-floorplan")
    public String createFloorplan(String jsonData){
        return jsonData;
    }

    @Operation(summary = "지니홈 도면 생성 완료 여부 확인", description = "사용자 ID와 도면 고유번호로 지니홈 도면 생성 완료 여부 확인(0 : 미완료, 1 : 완료, 2: 실패)")
    @GetMapping("/check-floorplan/{id}/{uuid}")
    public int checkFloorplan(@PathVariable("id") String id, @PathVariable("uuid") String uuid) throws IOException {

        String masterURL = "https://flooropt.prod.genieverse.co.kr/check-floorplan?"
                + "id=" + id
                + "&uuid=" + uuid;

        URL url = new URL(masterURL);

        HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");

        int responseCode = connection.getResponseCode();

        System.out.println(responseCode);
        System.out.println(connection.getResponseMessage());
        System.out.println(connection.getContent().toString());

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        StringBuilder builder = new StringBuilder();
        String line = "";
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }

        return genieHomeService.checkFloorplan(builder);
    }

    @Operation(summary = "지니홈 도면 생성 완료", description = "사용자 ID와 도면 고유번호로 지니홈 도면 생성 완료 확인(1 : 완료, 2: 실패)")
    @GetMapping("/complete-floorplan/{id}/{uuid}")
    public int completeFloorplan(@PathVariable("id") String id, @PathVariable("uuid") String uuid) throws IOException {

        String masterURL = "https://flooropt.prod.genieverse.co.kr/complete-floorplan?"
                + "id=" + id
                + "&uuid=" + uuid;

        URL url = new URL(masterURL);

        HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");

        int responseCode = connection.getResponseCode();

        System.out.println(responseCode);
        System.out.println(connection.getResponseMessage());
        System.out.println(connection.getContent().toString());

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        StringBuilder builder = new StringBuilder();
        String line = "";
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }

        return genieHomeService.completeFloorplan(builder);
    }

}

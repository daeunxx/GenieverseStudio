package com.studio.genieversestudio.src.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.time.LocalDateTime;

@Getter
@RedisHash(value = "resultHistory", timeToLive = 3600)
@AllArgsConstructor
@NoArgsConstructor
public class ResultHistory {

    @Id
    private String id;

    @Indexed
    private String ip;
    private String originText;
    private String transText;

    @Indexed
    private LocalDateTime createdDateTime;

    @Builder
    public ResultHistory(String ip, String originText, String transText, LocalDateTime createdDateTime){
        this.ip = ip;
        this.originText = originText;
        this.transText = transText;
        this.createdDateTime = createdDateTime;
    }
}

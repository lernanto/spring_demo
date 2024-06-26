package home.spring_demo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Agent")
public class Agent implements Serializable {
    @Id
    private String id;
    private double latitude;
    private double longitude;
}

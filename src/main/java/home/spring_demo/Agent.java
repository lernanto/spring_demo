package home.spring_demo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("agent")
public class Agent extends Location implements Serializable {
    @Id
    private String id;

    Agent(String id, double latitude, double longitude) {
        super(latitude, longitude);
        this.id = id;
    }
}

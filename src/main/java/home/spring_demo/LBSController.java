package home.spring_demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LbsController {

    @Autowired
    private AgentService agentService;

    @Autowired
    private SearchService searchService;

    @GetMapping("agent/{id}")
    public Location getLocation(@PathVariable String id) {
        return agentService.getAgent(id);
    }

    @PutMapping("agent/{id}")
    public void setLocation(@PathVariable String id, @RequestBody Location location) {
        agentService.setAgent(new Agent(id, location.getLatitude(), location.getLongitude()));
    }

    @PostMapping("agent/{id}")
    public Agent updateLocation(@PathVariable String id, @RequestBody Location location) {
        return agentService.updateAgent(id, location);
    }

    @GetMapping("search/{latitude}/{longitude}/{radius}")
    public List<Agent> searchAgents(@PathVariable double latitude, @PathVariable double longitude, @PathVariable double radius) {
        return searchService.searchAgents(new Location(latitude, longitude), radius);
    }
}

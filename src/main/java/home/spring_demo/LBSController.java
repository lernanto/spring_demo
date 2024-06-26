package home.spring_demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LBSController {

    @Autowired
    private LBSService service;

    @GetMapping("agent/{id}")
    public Location getLocation(@PathVariable String id) {
        Agent agent = service.getAgent(id);
        return new Location(agent.getLatitude(), agent.getLongitude());
    }

    @PutMapping("agent/{id}")
    public void setLocation(@PathVariable String id, @RequestBody Location location) {
        Agent agent = new Agent(id, location.getLatitude(), location.getLongitude());
        service.setAgent(agent);
    }

    @PostMapping("agent/{id}")
    public void updateLocation(@PathVariable String id, @RequestBody Location location) {

    }

    @GetMapping("search/{latitude}/{longitude}")
    public List<Agent> searchAgents(@PathVariable double latitude, @PathVariable double longitude) {
        List<Agent> agents = new ArrayList<Agent>();
        agents.add(new Agent());
        return agents;
    }
}

package home.spring_demo;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    public Agent getAgent(String id) {
        return agentRepository.findById(id).get();
    }

    public void setAgent(final Agent agent) {
        agentRepository.save(agent);
    }

    public Agent updateAgent(String id, final Location location) {
        Agent agent = null;
        try {
            agent = agentRepository.findById(id).get();
            agent.setLatitude((agent.getLatitude() + location.getLatitude()) / 2);
            agent.setLongitude((agent.getLongitude() + location.getLongitude()) / 2);
        } catch (NoSuchElementException e) {
            agent = new Agent(id, location.getLatitude(), location.getLongitude());
        }

        agentRepository.save(agent);
        return agent;
    }
}

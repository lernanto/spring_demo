package home.spring_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LBSService {

    @Autowired
    private AgentRepository agentRepository;

    public Agent getAgent(String id) {
        return agentRepository.findById(id).get();
    }

    public void setAgent(final Agent agent) {
        agentRepository.save(agent);
    }

    public Agent updateAgent(String id, final Location location) {
        Agent agent = agentRepository.findById(id).get();
        if (agent == null) {
            agent = new Agent(id, location.getLatitude(), location.getLongitude());
        } else {
            agent.setLatitude((agent.getLatitude() + location.getLatitude()) / 2);
            agent.setLongitude((agent.getLongitude() + location.getLongitude()) / 2);
        }

        agentRepository.save(agent);
        return agent;
    }
}

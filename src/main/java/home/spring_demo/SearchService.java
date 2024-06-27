package home.spring_demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Autowired
    private AgentRepository agentRepository;

    public List<Agent> searchAgents(final Location location, double radius) {
        List<Agent> agents = new ArrayList<>();

        for (Agent agent: agentRepository.findAll()) {
            if (location.distance(agent) < radius) {
                agents.add(agent);
            }
        }

        return agents;
    }
}

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
}

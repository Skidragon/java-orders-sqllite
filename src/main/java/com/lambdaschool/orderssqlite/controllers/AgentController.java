package com.lambdaschool.orderssqlite.controllers;

import com.lambdaschool.orderssqlite.models.Agent;
import com.lambdaschool.orderssqlite.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path={"/agents"}, produces= MediaType.APPLICATION_JSON_VALUE)
public class AgentController {

    @Autowired
    AgentRepository agentRepo;

    @GetMapping("")
    public List<Agent> allAgents() {
        return agentRepo.findAll();
    }

    @GetMapping("agentcode/{agentcode}")
    public Agent getAgentByCode(@PathVariable long agentcode) {
        return agentRepo.findAgentByCode(agentcode);
    }

    @PostMapping("")
    public Agent newAgent(@RequestBody Agent newAgent) throws URISyntaxException {
        return agentRepo.save(newAgent);
    }

    @PutMapping("agentcode/{agentcode}")
    public Agent updateAgent(@RequestBody Agent updatedAgent, @PathVariable long agentcode) throws URISyntaxException {
        Optional<Agent> foundCustomer = agentRepo.findById(agentcode);
        if(foundCustomer.isPresent()) {
            updatedAgent.setAgentcode(agentcode);
            agentRepo.save(updatedAgent);
            return updatedAgent;
        }
            return null;
    }
}

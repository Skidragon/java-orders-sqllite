package com.lambdaschool.orderssqlite.controllers;

import com.lambdaschool.orderssqlite.models.Agent;
import com.lambdaschool.orderssqlite.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

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
}

package com.lambdaschool.orderssqlite.controllers;

import com.lambdaschool.orderssqlite.models.Agent;
import com.lambdaschool.orderssqlite.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

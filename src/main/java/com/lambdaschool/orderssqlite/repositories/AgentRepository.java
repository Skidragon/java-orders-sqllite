package com.lambdaschool.orderssqlite.repositories;

import com.lambdaschool.orderssqlite.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AgentRepository extends JpaRepository<Agent, Long> {

    @Query(value="SELECT * FROM agents a WHERE a.agentcode = :agentcode", nativeQuery = true)
    Agent findAgentByCode(@Param("agentcode") long agentcode);
}

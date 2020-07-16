package com.ls.order.services;

import com.ls.order.models.Agent;
import com.ls.order.repos.AgentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//@Transactional
@Service(value = "agentServ")
public class AgentServImpli implements AgentServ {

    @Autowired
    private AgentRepo agentRepos;

    @Transactional
    @Override
    public Agent save(Agent agent) { return agentRepos.save(agent); }
}
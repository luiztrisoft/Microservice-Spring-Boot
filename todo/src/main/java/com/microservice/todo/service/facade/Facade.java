package com.microservice.todo.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Facade {

    @Autowired
    public ServiceFacade service;

    @Autowired
    public RepositoryFacade repository;
}

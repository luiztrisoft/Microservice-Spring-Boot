package com.microservice.todo.service.facade;

import com.microservice.todo.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFacade {

    @Autowired
    public TodoServiceImpl todoService;
}

package com.microservice.trisoft.service.facade;

import com.microservice.trisoft.service.EmailServiceImpl;
import com.microservice.trisoft.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFacade {

    @Autowired
    public EmailServiceImpl emailService;

    @Autowired
    public TodoServiceImpl todoService;
}

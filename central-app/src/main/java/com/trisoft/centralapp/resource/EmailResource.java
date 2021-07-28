package com.trisoft.centralapp.resource;

import com.trisoft.centralapp.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailResource {

    @Autowired
    private EmailServiceImpl service;

    @PostMapping("/single")
    public ResponseEntity saveEmail() throws Exception {
        return new ResponseEntity<>(service.saveEmail(), HttpStatus.OK);
    }

    @PostMapping("/list")
    public ResponseEntity saveEmails() throws Exception {
        return new ResponseEntity<>(service.saveEmails(), HttpStatus.OK);
    }

    @PostMapping("/empty")
    public void saveNothing() throws Exception {
        service.saveNothing();
    }
}

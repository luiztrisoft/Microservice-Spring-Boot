package com.microservice.trisoft.resource;

import com.microservice.trisoft.service.dto.EmailDto;
import com.microservice.trisoft.service.facade.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/email")
public class EmailResource {

    @Autowired
    private Facade facade;

    @GetMapping
    public ResponseEntity<String> getAllEmails() throws Exception{
        return ResponseEntity.ok(facade.service.emailService.getAllEmails());
    }

    @PostMapping
    public ResponseEntity<String>  sendEmail (@RequestBody @Valid EmailDto emailDto) throws Exception {
        return ResponseEntity.ok(facade.service.emailService.sendEmail(emailDto));
    }
}

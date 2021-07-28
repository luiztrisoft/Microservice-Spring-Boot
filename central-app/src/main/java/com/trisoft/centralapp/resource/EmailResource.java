package com.trisoft.centralapp.resource;

import com.trisoft.centralapp.dto.EmailDto;
import com.trisoft.centralapp.service.EmailServiceImpl;
import com.trisoft.centralapp.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/email")
public class EmailResource {

    @Autowired
    private RestUtil restUtil;

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

    @PostMapping
    public ResponseEntity<Void> criarEmail() throws Exception {
        EmailDto dto = new EmailDto();
        dto.setEndereco("luiz.trisoft@gmail.com");
        dto.setAssunto("Negociação de dívida");
        dto.setCorpo("Boa tarde!");
        dto.setUuid(UUID.randomUUID().toString());

        List<EmailDto> emails = new ArrayList<>();
        emails.add(dto);

        ResponseEntity<String> list = restUtil.post("http://localhost:9999/api/email/list", emails, null);
        ResponseEntity<String> single = restUtil.post("http://localhost:9999/api/email/single", dto, null);
        ResponseEntity<String> withoutBody = restUtil.post("http://localhost:9999/api/email/without-body", null, null);
        return null;
    }
}

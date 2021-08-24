package com.trisoft.centralapp.service;

import com.trisoft.centralapp.dto.EmailDto;
import com.trisoft.centralapp.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmailServiceImpl {

    @Value("${url.emailcloud}")
    private String emailCloudUrl;

    @Value("${url.email.service}")
    private String emailService;

    public String getAllEmails() throws Exception{
        ResponseEntity<String> result = restUtil.get(emailService.concat("/emails"), null, null);
        return result.getBody();
    }


    @Autowired
    private RestUtil restUtil;

    public String saveEmail() throws Exception {
        ResponseEntity<String> result = restUtil.post(emailCloudUrl.concat("/save-single"), getEmailDto(), null);
        return result.getBody();
    }

    public String saveEmails() throws Exception {
        List<EmailDto> emailList = new ArrayList<>();
        emailList.add(getEmailDto());
        emailList.add(getEmailDto("luiz.ricardo@groupsoftware.com.br"));
        emailList.add(getEmailDto("tiko_thepunisher@hotmail.com"));

        ResponseEntity<String> result = restUtil.post(emailCloudUrl.concat("/save-list"), emailList, null);
        return result.getBody();
    }

    public void saveNothing() throws Exception {
        ResponseEntity<String> withoutBody = restUtil.post(emailCloudUrl.concat("/without-body"), null, null);
    }

    private EmailDto getEmailDto(String email){
        EmailDto dto = getEmailMessage();
        dto.setEndereco(email);
        return dto;
    }

    private EmailDto getEmailDto(){
        EmailDto dto = getEmailMessage();
        dto.setEndereco("luiz.trisoft@gmail.com");
        return dto;
    }

    private EmailDto getEmailMessage(){
        EmailDto dto = new EmailDto();
        dto.setAssunto("Microservices");
        dto.setCorpo("Olá! Esta é uma mensagem do projeto de microserviços com Spring e Java");
        dto.setUuid(UUID.randomUUID().toString());
        return dto;
    }
}

package com.microservice.trisoft.service;

import com.microservice.trisoft.service.dto.EmailDto;
import com.microservice.trisoft.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

    @Value("${url.email.service}")
    private String emailMicroserviceUrl;

    @Autowired
    private RestUtil restUtil;

    public String getAllEmails() throws Exception{
        ResponseEntity<String> result = restUtil.get(emailMicroserviceUrl.concat("/emails"), null, null);
        return result.getBody();
    }

    public String sendEmail(EmailDto emailDto) throws Exception{
        //validação de dados
        ResponseEntity<String> result = restUtil.post(emailMicroserviceUrl.concat("/sending-email"), emailDto, null);
        return result.getBody();
    }
}

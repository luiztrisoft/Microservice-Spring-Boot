package com.trisoft.emailcloud.web.rest;

import com.trisoft.emailcloud.dto.EmailDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/email")
public class EmailResource {

    //@ApiOperation(value = "atualizarBoletos", notes = "Atualiza um ou mais boletos")
    @CrossOrigin
    @PostMapping("/list")
    public ResponseEntity<List<EmailDto>> criarEmails(@RequestBody List<EmailDto> dtos) throws Exception {
        List<EmailDto> result = dtos;
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/single")
    public ResponseEntity<EmailDto> criarEmail(@RequestBody EmailDto dto) throws Exception {
        EmailDto result = dto;
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/without-body")
    public ResponseEntity<List<EmailDto>> buscarEmail() throws Exception {
        List<EmailDto> result = new ArrayList<>();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

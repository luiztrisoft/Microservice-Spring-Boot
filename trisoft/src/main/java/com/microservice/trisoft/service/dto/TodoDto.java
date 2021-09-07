package com.microservice.trisoft.service.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class TodoDto {
    private Long id;
    private String uuid;
    @NotBlank
    private String titulo;
    @NotBlank
    private String texto;

    public TodoDto(){

    }

    public TodoDto(String uuid){
        this.uuid = uuid;
    }
}


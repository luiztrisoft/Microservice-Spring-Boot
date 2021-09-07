package com.microservice.todo.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TodoDto {
    private Long id;
    private String uuid;
    @NotBlank
    private String titulo;
    @NotBlank
    private String texto;
}

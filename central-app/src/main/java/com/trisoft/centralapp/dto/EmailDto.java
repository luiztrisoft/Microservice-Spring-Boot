package com.trisoft.centralapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDto {
    private String endereco;
    private String assunto;
    private String corpo;
}

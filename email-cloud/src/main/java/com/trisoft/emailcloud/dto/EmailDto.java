package com.trisoft.emailcloud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDto {
    private Long id;
    private String uuid;
    private String endereco;
    private String assunto;
    private String corpo;
}

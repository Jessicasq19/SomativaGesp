package com.senai.senai.models.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;
//herança
//extends faz a classe UpdatePartsDto ser FILHA da classe PartsDto
@Data
public class UpdatePartsDto extends PartsDto
        implements Serializable {

    private UUID id;
}

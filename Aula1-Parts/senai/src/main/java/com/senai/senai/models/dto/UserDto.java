package com.senai.senai.models.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserDto implements Serializable {
    private UUID id;
    private String name;
    private LocalDate birthday;
    private String cpf;
    private String phone;
    private LocalDateTime createdDate;
}

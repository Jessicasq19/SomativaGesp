package com.senai.users.users.models.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class UserDto implements Serializable {
    private String name;
    private LocalDate birthday;
    private String cpf;
    private String phone;
}

package com.senai.senai.models.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class UpdateRobotsDto extends RobotsDto
        implements Serializable {
    private UUID id;
}

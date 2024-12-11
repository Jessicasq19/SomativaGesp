package com.senai.senai.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senai.senai.models.Parts;
import com.senai.senai.models.Robots;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class RobotsDto implements Serializable {

    private UUID HANDLEBAR;
    private UUID base;
    private UUID REARWHEEL;
    private UUID WHEEL;
    private UUID ENGINE;
    private UUID userId;

    @JsonIgnore
    public Robots mapToRobot(){
        return Robots.builder()
                .HANDLEBAR(Parts.builder().id(this.HANDLEBAR).build())
                .REARWHEEL(Parts.builder().id(this.REARWHEEL).build())
                .WHEEL(Parts.builder().id(this.WHEEL).build())
                .ENGINE(Parts.builder().id(this.ENGINE).build())
                .userId(this.userId)
                .build();
    }
}

package com.senai.senai.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.senai.senai.models.Parts;
import com.senai.senai.utils.DataUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RobotsFullDto implements Serializable {

    private UUID id;
    private Parts HANDLEBAR;
    private Parts base;
    private Parts REARWHEEL;
    private Parts WHEEL;
    private Parts ENGINE;
    private UserDto user;
    private LocalDateTime createdDate;
    private BigDecimal totalCost;

}

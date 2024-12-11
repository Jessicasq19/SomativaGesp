package com.senai.senai.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.senai.senai.utils.DataUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Data
@Entity
@Table(name = "Robots")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Robots implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Parts HANDLEBAR;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Parts REARWHEEL;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Parts WHEEL;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Parts ENGINE;

    private UUID userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public BigDecimal getTotalCost(){

        return new BigDecimal(0)
                .add(DataUtils.nullSafe(ENGINE.getCost()))
                .add(DataUtils.nullSafe(HANDLEBAR.getCost()))
                .add(DataUtils.nullSafe(REARWHEEL.getCost()))
                .add(DataUtils.nullSafe(WHEEL.getCost()));
    }

}

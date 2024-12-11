package com.senai.senai.service;

import com.senai.senai.models.Motors;
import com.senai.senai.models.dto.RobotsFullDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface MotorsService {

    Page<Motors> getAllRobots(Pageable page, Specification<Motors> spec);

    List<Motors> saveRobots(List<Motors> robots);

    Motors updateRobot(Motors robot);

    void deleteRobot(UUID id);

    Page<RobotsFullDto> getFullRobots(Pageable page, Specification<Motors> spec);
}

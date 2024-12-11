package com.senai.senai.controller;

import com.senai.senai.models.Robots;
import com.senai.senai.models.dto.RobotsDto;
import com.senai.senai.models.dto.RobotsFullDto;
import com.senai.senai.models.dto.UpdateRobotsDto;
import com.senai.senai.service.RobotsService;
import com.senai.senai.specifications.RobotsSpecification;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/robots")
@CrossOrigin(origins = "*")
public class RobotsController {

    @Autowired
    RobotsService robotsService;

    @GetMapping
    public ResponseEntity<Page<Robots>> getAllRobots(
                                        Pageable pageable,
                                        RobotsSpecification.RobotsSpec spec ) {
        return ResponseEntity.ok(
                robotsService.getAllRobots(pageable,spec)
        );
    }

    @GetMapping("/full")
    public ResponseEntity<Page<RobotsFullDto>> getFullRobots(
                                        Pageable pageable,
                                        RobotsSpecification.RobotsSpec spec ) {
        return ResponseEntity.ok(
                robotsService.getFullRobots(pageable,spec)
        );
    }

    @PostMapping
    public ResponseEntity<List<Robots>> addNewRobot(@RequestBody @Valid List<RobotsDto> robots) {

        List<Robots> robotsList = robots.stream().map(RobotsDto::mapToRobot).toList();
        //List<Robots> robotsList = robots.stream().map(robotDto -> robotDto.mapToRobot()).toList();
        return ResponseEntity.status(HttpStatus.CREATED).body(
                robotsService.saveRobots(robotsList));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Robots> updateRobot(
            @PathVariable UUID id,
            @RequestBody @Valid UpdateRobotsDto robot) {

        Robots convertedRobot = robot.mapToRobot();
        convertedRobot.setId(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                robotsService.updateRobot(convertedRobot));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteRobot(@PathVariable UUID id) {
        robotsService.deleteRobot(id);
    }



}

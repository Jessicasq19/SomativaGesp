package com.senai.senai.service.impl;

import com.senai.senai.client.UserClient;
import com.senai.senai.client.UserService;
import com.senai.senai.models.Robots;
import com.senai.senai.models.dto.RobotsFullDto;
import com.senai.senai.models.dto.UserDto;
import com.senai.senai.repository.RobotsRepository;
import com.senai.senai.service.RobotsService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class RobotsServiceImpl implements RobotsService {

    @Autowired
    private RobotsRepository robotsRepository;

    @Autowired
    private UserService userService;

    @Override
    public Page<Robots> getAllRobots(Pageable page, Specification<Robots> spec) {
        return robotsRepository.findAll(spec,page);
    }

    @Override
    public Page<RobotsFullDto> getFullRobots(Pageable page, Specification<Robots> spec) {
        Page<Robots> robotsFound = getAllRobots(page, spec);
        List<RobotsFullDto> robotsDto = new ArrayList<>();
        List<UserDto> userDtos = userService.getUsersByIds(
                robotsFound.getContent().stream().map(Robots::getUserId).toList()
        );

        robotsFound.getContent().stream().forEach(robot->{
            var userFound = userDtos.stream().filter(u->u.getId().equals(robot.getUserId()))
                    .findFirst().orElse(null);

            robotsDto.add(
                    RobotsFullDto.builder()
                            .id(robot.getId())
                            .ENGINE(robot.getENGINE())
                            .HANDLEBAR(robot.getHANDLEBAR())
                            .REARWHEEL(robot.getREARWHEEL())
                            .WHEEL(robot.getWHEEL())
                            .user(userFound)
                            .build()
            );
        });

        return new PageImpl<>(robotsDto,
                              robotsFound.getPageable(),
                              robotsFound.getTotalElements());
    }

    @Override
    public List<Robots> saveRobots(List<Robots> robots) {
        List<UUID> robotIds = new ArrayList<>();
        robots.stream().forEach(robot -> {
            if( userService.checkIfUserExists(robot.getUserId()) ){
                robotIds.add(
                        robotsRepository.saveAndFlush(robot).getId()
                );
            }
            else{
                log.error("User with id: {} does not exist!",
                        robot.getUserId());
            }
        });
        return robotsRepository.findAllById(robotIds);
    }

    @Override
    public Robots updateRobot(Robots robot) {
        Optional<Robots> optionalRobot = robotsRepository.findById(robot.getId());

        if(optionalRobot.isPresent()) {
            BeanUtils.copyProperties(robot,optionalRobot.get(),
                    "createdDate");
            return robotsRepository.save(optionalRobot.get());
        }
        return null;
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void deleteRobot(UUID id) {
        Optional<Robots> optionalRobot = robotsRepository.findById(id);
        if(optionalRobot.isPresent()){
            robotsRepository.delete(optionalRobot.get());
        }
    }


}

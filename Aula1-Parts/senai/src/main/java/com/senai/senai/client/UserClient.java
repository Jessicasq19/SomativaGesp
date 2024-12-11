package com.senai.senai.client;

import com.senai.senai.models.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "user-client", url="${app.users-microservice.url}")
public interface UserClient {

    @GetMapping("/user/{userId}")
    UserDto getUserById(@PathVariable UUID userId);

    @GetMapping("/user-ids")
    List<UserDto> getUserByIds(@RequestParam List<UUID> userIds);

}

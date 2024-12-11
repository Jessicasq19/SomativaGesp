package com.senai.users.users.controller;

import com.senai.users.users.exceptions.UsersExeption;
import com.senai.users.users.models.User;
import com.senai.users.users.models.dto.UserDto;
import com.senai.users.users.service.UserService;
import com.senai.users.users.specification.UserSpecification;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<Page<User>> getAllUsers(
            Pageable pageable,
            UserSpecification.UserSpec spec ) {
        Page<User> users = userService.getAllUsers(pageable,spec);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserById(
            @PathVariable UUID userId) throws UsersExeption {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/user-ids")
    public ResponseEntity<List<User>> getUsersByIds(@RequestParam List<UUID> userIds) {
        List<User> users = userService.getUsersByIds(userIds);
        return ResponseEntity.ok(users);
    }

    @PostMapping("/user")
    public ResponseEntity<List<User>> addNewUsers(@RequestBody @Valid List<UserDto> users) {

        List<User> userList = users.stream().map(dto -> {
            User convertedUser = new User();
            BeanUtils.copyProperties(dto, convertedUser);
            return convertedUser;
        }).toList();


        return ResponseEntity.status(HttpStatus.CREATED).body(
                userService.saveUsers(userList));
    }



}

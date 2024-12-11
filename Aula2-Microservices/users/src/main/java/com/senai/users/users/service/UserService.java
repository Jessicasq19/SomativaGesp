package com.senai.users.users.service;

import com.senai.users.users.exceptions.UserNotFoundException;
import com.senai.users.users.exceptions.UsersExeption;
import com.senai.users.users.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface UserService {
    Page<User> getAllUsers(Pageable page, Specification<User> spec);

    List<User> saveUsers(List<User> users);

    User updateUser(User user);

    void deleteUser(UUID id);

    User getUserById(UUID userId) throws UsersExeption;

    List<User> getUsersByIds(List<UUID> userIds);
}

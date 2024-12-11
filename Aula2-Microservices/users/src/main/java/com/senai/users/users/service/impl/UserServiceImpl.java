package com.senai.users.users.service.impl;

import com.senai.users.users.exceptions.UserNotFoundException;
import com.senai.users.users.models.User;
import com.senai.users.users.repository.UserRepository;
import com.senai.users.users.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Page<User> getAllUsers(Pageable page, Specification<User> spec) {
        return userRepository.findAll(spec, page);
    }

    @Override
    public List<User> saveUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public User updateUser(User user) {

        Optional<User> optionalUser = userRepository.findById(user.getId());

        if(optionalUser.isPresent()) {
            BeanUtils.copyProperties(user,optionalUser.get(),
                    "createdDate");
            return userRepository.save(optionalUser.get());
        }
        return null;
    }

    @Override
    public void deleteUser(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
        }
    }

    @Override
    public User getUserById(UUID userId) throws UserNotFoundException {
        //var user --> ou use o var
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException());
        return user;
    }

    @Override
    public List<User> getUsersByIds(List<UUID> userIds) {
        return userRepository.findAllById(userIds);
    }
}

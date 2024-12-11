package com.senai.users.users.repository;

import com.senai.users.users.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository
        extends JpaRepository<User, UUID> {
    Page<User> findAll(Specification<User> spec, Pageable page);
}

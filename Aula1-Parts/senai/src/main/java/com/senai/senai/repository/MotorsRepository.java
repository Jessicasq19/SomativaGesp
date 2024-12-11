package com.senai.senai.repository;

import com.senai.senai.models.Motors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MotorsRepository extends JpaRepository<Motors, UUID>,
        JpaSpecificationExecutor<Motors> {

    Page<Motors> findAll(Specification<Motors> spec, Pageable pageable);
}



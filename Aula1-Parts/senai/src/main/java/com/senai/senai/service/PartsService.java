package com.senai.senai.service;

import com.senai.senai.models.Parts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface PartsService {

    Page<Parts> getAllParts(Pageable page, Specification<Parts> spec);

    List<Parts> saveParts(List<Parts> parts);

    Parts updatePart(Parts part);

    void deletePart(UUID id);
}

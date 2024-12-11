package com.senai.senai.service.impl;

import com.senai.senai.models.Parts;
import com.senai.senai.repository.PartsRepository;
import com.senai.senai.service.PartsService;
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
public class PartsServiceImpl implements PartsService {

    @Autowired
    private PartsRepository partsRepository;

    @Override
    public Page<Parts> getAllParts(Pageable page, Specification<Parts> spec) {
        return partsRepository.findAll(spec, page);
    }

    @Override
    public List<Parts> saveParts(List<Parts> parts) {
        return partsRepository.saveAll(parts);
    }

    @Override
    public Parts updatePart(Parts part) {
                                        //select *from parts where id = ???
        Optional<Parts> optionalPart = partsRepository.findById(part.getId());

        if(optionalPart.isPresent()) {
            BeanUtils.copyProperties(part,optionalPart.get(),
                    "createdDate");
            //update parts .... where id = ???
            return partsRepository.save(optionalPart.get());
        }
        return null;
    }

    @Override
    public void deletePart(UUID id) {
        Optional<Parts> optionalPart = partsRepository.findById(id);

        if(optionalPart.isPresent()) {
            partsRepository.delete(optionalPart.get());
        }
    }
}

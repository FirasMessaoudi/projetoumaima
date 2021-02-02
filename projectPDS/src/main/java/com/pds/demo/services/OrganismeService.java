package com.pds.demo.services;


import com.pds.demo.domains.Organisme;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrganismeService {
    Organisme save(Organisme organisme);
    List<Organisme> findAll();
    Optional<Organisme> findOne(Integer id);
    void delete(Integer id);
}

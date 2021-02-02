package com.pds.demo.services;

import com.pds.demo.domains.Jury;
import com.pds.demo.domains.Rapport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface JuryService {
    Jury save(Jury jury);
    List<Jury> findAll();
    Optional<Jury> findOne(Integer id);
    void delete(Integer id);
}

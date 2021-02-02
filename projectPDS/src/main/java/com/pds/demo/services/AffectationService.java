package com.pds.demo.services;


import com.pds.demo.domains.Affectation;
import com.pds.demo.domains.RapportJuryId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AffectationService {
    Affectation save(Affectation affectation);
    List<Affectation> findAll();
    Optional<Affectation> findOne(RapportJuryId id);
    void delete(RapportJuryId id);
}

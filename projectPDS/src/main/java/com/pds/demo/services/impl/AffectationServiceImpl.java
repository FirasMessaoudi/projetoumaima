package com.pds.demo.services.impl;


import com.pds.demo.domains.Affectation;
import com.pds.demo.domains.RapportJuryId;
import com.pds.demo.repository.AffectationRepository;
import com.pds.demo.services.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AffectationServiceImpl implements AffectationService {


    @Autowired
    private AffectationRepository affectationRepository;
    @Override
    public Affectation save(Affectation affectation) {
        return affectationRepository.save(affectation);
    }

    @Override
    public List<Affectation> findAll() {
        return affectationRepository.findAll();
    }

    @Override
    public Optional<Affectation> findOne(RapportJuryId id) {
         return Optional.of(affectationRepository.findById(id).get());
    }

    @Override
    public void delete(RapportJuryId id) {
        affectationRepository.deleteById(id);

    }
}

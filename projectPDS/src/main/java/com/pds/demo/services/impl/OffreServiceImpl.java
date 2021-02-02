package com.pds.demo.services.impl;


import com.pds.demo.domains.OffreStage;
import com.pds.demo.repository.OffreRepository;
import com.pds.demo.services.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OffreServiceImpl implements OffreService {


    @Autowired
    private OffreRepository offreRepository;

    @Override
    public OffreStage save(OffreStage offreStage) {
        return offreRepository.save(offreStage) ;
    }

    @Override
    public List<OffreStage> findAll() {
        return offreRepository.findAll();
    }

    @Override
    public Optional<OffreStage> findOne(Integer id) {
        return Optional.of(offreRepository.findById(id).get());
    }

    @Override
    public void delete(Integer id) {
        offreRepository.deleteById(id);

    }

    @Override
    public List<OffreStage> findByorganisme(Integer id) {

        return offreRepository.findAllByOrganismeId(id);
    }
}

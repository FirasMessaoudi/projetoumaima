package com.pds.demo.services.impl;


import com.pds.demo.domains.EtatRapport;
import com.pds.demo.repository.EtatRapportRepository;
import com.pds.demo.services.EtatRapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EtatRapportServiceImpl implements EtatRapportService {



    @Autowired
    private EtatRapportRepository etatRapportRepository;
    @Override
    public EtatRapport save(EtatRapport etatRapport) {
        return etatRapportRepository.save(etatRapport);
    }

    @Override
    public List<EtatRapport> findAll() {
        return etatRapportRepository.findAll();
    }

    @Override
    public Optional<EtatRapport> findOne(Integer id) {
        return Optional.of(etatRapportRepository.findById(id).get());
    }

    @Override
    public void delete(Integer id) {
        etatRapportRepository.deleteById(id);

    }
}

package com.pds.demo.services.impl;


import com.pds.demo.domains.Rapport;
import com.pds.demo.repository.RapportRepository;
import com.pds.demo.services.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RapportServiceImpl implements RapportService {



    @Autowired
    private RapportRepository rapportRepository;

    @Override
    public Rapport save(Rapport rapport) {
        return rapportRepository.save(rapport);
    }

    @Override
    public List<Rapport> findAll() {
        return rapportRepository.findAll();
    }

    @Override
    public Optional<Rapport> findOne(Integer id) {
        return Optional.of(rapportRepository.findById(id).get());
    }

    @Override
    public void delete(Integer id) {

        rapportRepository.deleteById(id);
    }
}

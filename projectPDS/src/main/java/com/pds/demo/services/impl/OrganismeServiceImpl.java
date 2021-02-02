package com.pds.demo.services.impl;


import com.pds.demo.domains.Organisme;
import com.pds.demo.repository.OrganismeRepository;
import com.pds.demo.services.OrganismeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrganismeServiceImpl implements OrganismeService {

    @Autowired
    private OrganismeRepository organismeRepository;

    @Override
    public Organisme save(Organisme organisme) {
        return organismeRepository.save(organisme);
    }

    @Override
    public List<Organisme> findAll() {
        return organismeRepository.findAll();
    }

    @Override
    public Optional<Organisme> findOne(Integer id) {
        return Optional.of(organismeRepository.findById(id).get());
    }

    @Override
    public void delete(Integer id) {
        organismeRepository.deleteById(id);

    }
}

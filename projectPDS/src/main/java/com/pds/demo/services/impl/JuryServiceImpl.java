package com.pds.demo.services.impl;


import com.pds.demo.domains.Jury;
import com.pds.demo.repository.JuryRepository;
import com.pds.demo.services.JuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JuryServiceImpl implements JuryService {

    @Autowired
    private JuryRepository juryRepository;


    @Override
    public Jury save(Jury jury) {
        return juryRepository.save(jury);
    }

    @Override
    public List<Jury> findAll() {
        return juryRepository.findAll();
    }

    @Override
    public Optional<Jury> findOne(Integer id) {
        return Optional.of(juryRepository.findById(id).get());
    }

    @Override
    public void delete(Integer id) {
        juryRepository.deleteById(id);

    }
}

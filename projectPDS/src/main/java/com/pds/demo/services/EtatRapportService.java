package com.pds.demo.services;


import com.pds.demo.domains.EtatRapport;
import com.pds.demo.domains.Jury;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EtatRapportService {
    EtatRapport save(EtatRapport etatRapport);
    List<EtatRapport> findAll();
    Optional<EtatRapport> findOne(Integer id);
    void delete(Integer id);
}

package com.pds.demo.services;


import com.pds.demo.domains.OffreStage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OffreService {
    OffreStage save(OffreStage offreStage);
    List<OffreStage> findAll();
    Optional<OffreStage> findOne(Integer id);
    void delete(Integer id);
    List<OffreStage> findByorganisme(Integer id);
}

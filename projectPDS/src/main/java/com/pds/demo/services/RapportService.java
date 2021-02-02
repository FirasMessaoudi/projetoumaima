package com.pds.demo.services;


import com.pds.demo.domains.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.pds.demo.domains.Rapport;
@Service
public interface RapportService {


    Rapport save(Rapport rapport);
    List<Rapport> findAll();
    Optional<Rapport> findOne(Integer id);
    void delete(Integer id);
}

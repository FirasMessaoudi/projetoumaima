package com.pds.demo.services;


import com.pds.demo.domains.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UtilisateurService {

    Utilisateur save(Utilisateur utilisateur);
    List<Utilisateur> findAll();
    Optional<Utilisateur> findOne(Integer id);
    void delete(Integer id);
}

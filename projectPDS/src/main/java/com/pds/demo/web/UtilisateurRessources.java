package com.pds.demo.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.pds.demo.services.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import com.pds.demo.domains.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UtilisateurRessources {


    private final Logger log = LoggerFactory.getLogger(UtilisateurRessources.class);

    private static final String ENTITY_NAME = "utilisateur";
    @Autowired
    private UtilisateurService utilisateurService;


    @PostMapping("/ajoutUser")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) throws URISyntaxException {
        log.debug("REST request to save Acquereur : {}", utilisateur);

        Utilisateur result = utilisateurService.save(utilisateur);
        return result;
    }
    @PutMapping("/updateUser")
    public Utilisateur updateUtilisateur( @RequestBody Utilisateur utilisateur) {
        Utilisateur result = utilisateurService.save(utilisateur);
     return result;
    }


    @GetMapping("/users")
    public List<Utilisateur> getAllUtilisateurs(Pageable pageable) {
        log.debug("REST request to get a page of utisateur");
        List<Utilisateur> utilisateurs=utilisateurService.findAll();

        return utilisateurs;
    }

    @GetMapping("/user/{id}")
    public Optional<Utilisateur> getUtilisateur(@PathVariable Integer id) {
        log.debug("REST request to get user : {}", id);
        Optional<Utilisateur> user = Optional.of(utilisateurService.findOne(id).get());
        return user;
    }


    @DeleteMapping("/utilisateur/{id}")
    public void deleteUtilisateur(@PathVariable Integer id) {

        try {
            utilisateurService.delete(id);


        } catch (Exception e) {
            System.out.println("erreur");
        }

    }


}

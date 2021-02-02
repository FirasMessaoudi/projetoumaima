package com.pds.demo.web;


import com.pds.demo.domains.Affectation;
import com.pds.demo.domains.RapportJuryId;
import com.pds.demo.services.AffectationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/Affectation")
public class AffectationRessources {

    private final Logger log = LoggerFactory.getLogger(AffectationRessources.class);

    private static final String ENTITY_NAME = "affectation";
    @Autowired
    private AffectationService affectationService;


    @PostMapping("/ajout")
    public Affectation createAffectation(@RequestBody Affectation affectation) throws URISyntaxException {
        log.debug("REST request to save Acquereur : {}", affectation);

        Affectation result = affectationService.save(affectation);
        return result;
    }
    @PutMapping("/update")
    public Affectation updateAffectation( @RequestBody Affectation affectation) {
        Affectation result = affectationService.save(affectation);
        return result;
    }


    @GetMapping("/getall")
    public List<Affectation> getAllAffectation(Pageable pageable) {
        log.debug("REST request to get a page of etat rapport");
        List<Affectation> listes=affectationService.findAll();

        return listes;
    }

    @GetMapping("/getOne/{id}")
    public Optional<Affectation> getAffectation(@PathVariable RapportJuryId id) {
        log.debug("REST request to get user : {}", id);
        Optional<Affectation> affectation = Optional.of(affectationService.findOne(id).get());
        return affectation;
    }


    @DeleteMapping("/delete/{id}")
    public void deleteAffectation(@PathVariable RapportJuryId id) {

        try {
            affectationService.delete(id);


        } catch (Exception e) {
            System.out.println("erreur");
        }

    }

























}

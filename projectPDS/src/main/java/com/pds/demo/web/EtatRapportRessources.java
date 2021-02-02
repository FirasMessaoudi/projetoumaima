package com.pds.demo.web;

import com.pds.demo.domains.EtatRapport;

import com.pds.demo.services.EtatRapportService;

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
@RequestMapping("/etatRapport")
public class EtatRapportRessources {

    private final Logger log = LoggerFactory.getLogger(EtatRapportRessources.class);

    private static final String ENTITY_NAME = "etatRapport";
    @Autowired
    private EtatRapportService etatRapportService;


    @PostMapping("/ajout")
    public EtatRapport createER(@RequestBody EtatRapport etatRapport) throws URISyntaxException {
        log.debug("REST request to save Acquereur : {}", etatRapport);

        EtatRapport result = etatRapportService.save(etatRapport);
        return result;
    }
    @PutMapping("/update")
    public EtatRapport updateER( @RequestBody EtatRapport etatRapport) {
        EtatRapport result = etatRapportService.save(etatRapport);
        return result;
    }


    @GetMapping("/getall")
    public List<EtatRapport> getAllER(Pageable pageable) {
        log.debug("REST request to get a page of etat rapport");
        List<EtatRapport> listes=etatRapportService.findAll();

        return listes;
    }

    @GetMapping("/getOne/{id}")
    public Optional<EtatRapport> getER(@PathVariable Integer id) {
        log.debug("REST request to get user : {}", id);
        Optional<EtatRapport> etatRapport = Optional.of(etatRapportService.findOne(id).get());
        return etatRapport;
    }


    @DeleteMapping("/delete/{id}")
    public void deleteER(@PathVariable Integer id) {

        try {
            etatRapportService.delete(id);


        } catch (Exception e) {
            System.out.println("erreur");
        }

    }

}

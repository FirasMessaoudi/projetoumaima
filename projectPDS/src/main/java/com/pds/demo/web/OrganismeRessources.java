package com.pds.demo.web;


import com.pds.demo.domains.OffreStage;
import com.pds.demo.domains.Organisme;

import com.pds.demo.services.OrganismeService;
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
@RequestMapping("/organisme")
public class OrganismeRessources {
    private final Logger log = LoggerFactory.getLogger(OrganismeRessources.class);

    private static final String ENTITY_NAME = "organisme";
    @Autowired
    private OrganismeService organismeService;


    @PostMapping("/ajout")
    public Organisme createOrganisme(@RequestBody Organisme organisme) throws URISyntaxException {
        log.debug("REST request to save organisme : {}", organisme);

        Organisme result = organismeService.save(organisme);
        return result;
    }

    @PutMapping("/update")
    public Organisme updateOrganisme(@RequestBody Organisme organisme) {
        Organisme result = organismeService.save(organisme);
        return result;
    }


    @GetMapping("/getall")
    public List<Organisme> getAllOrganisme(Pageable pageable) {
        log.debug("REST request to get a page of etat rapport");
        List<Organisme> listes = organismeService.findAll();

        return listes;
    }


    @DeleteMapping("/delete/{id}")
    public void deleteOrganisme(@PathVariable Integer id) {

        try {
            organismeService.delete(id);


        } catch (Exception e) {
            System.out.println("erreur");
        }

    }

    @GetMapping("/getOrganisme/{id}")
    public Optional<Organisme> getOrganisme(@PathVariable Integer id) {
        log.debug("REST request to get organisme : {}", id);
        Optional<Organisme> organisme = Optional.of(organismeService.findOne(id).get());
        return organisme;
    }
}

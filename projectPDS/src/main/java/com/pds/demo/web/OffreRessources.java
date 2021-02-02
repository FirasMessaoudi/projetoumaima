package com.pds.demo.web;


import com.pds.demo.domains.Jury;
import com.pds.demo.domains.OffreStage;
import com.pds.demo.services.JuryService;
import com.pds.demo.services.OffreService;
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
@RequestMapping("/offre")
public class OffreRessources {

    private final Logger log = LoggerFactory.getLogger(OffreRessources.class);

    private static final String ENTITY_NAME = "OffreStage";
    @Autowired
    private OffreService offreService;

    @PostMapping("/ajoutOffre")
    public OffreStage createOffre(@RequestBody OffreStage offreStage) throws URISyntaxException {
        log.debug("REST request to save Acquereur : {}", offreStage);

        OffreStage result = offreService.save(offreStage);
        return result;
    }
    @PutMapping("/updateOffre")
    public OffreStage updateOffre( @RequestBody OffreStage offreStage) {
        OffreStage result = offreService.save(offreStage);
        return result;
    }


    @GetMapping("/getOffre/{id}")
    public Optional<OffreStage> getOffreStage(@PathVariable Integer id) {
        log.debug("REST request to get user : {}", id);
        Optional<OffreStage> offre = Optional.of(offreService.findOne(id).get());
        return offre;
    }


    @DeleteMapping("/deleteOffre/{id}")
    public void deleteJury(@PathVariable Integer id) {

        try {
            offreService.delete(id);


        } catch (Exception e) {
            System.out.println("erreur");
        }

    }


    @GetMapping("/offreByorganisme/{idOrganisme}")
    public List<OffreStage> getAllOffreStagesSelonOrganisme(@PathVariable Integer idOrganisme) {
        log.debug("REST request to get a page of jury");
        List<OffreStage> Offres=offreService.findByorganisme(idOrganisme);

        return Offres;
    }
}

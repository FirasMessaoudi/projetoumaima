package com.pds.demo.web;


import com.pds.demo.domains.Jury;
import com.pds.demo.domains.Utilisateur;
import com.pds.demo.services.JuryService;
import com.pds.demo.services.UtilisateurService;
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
@RequestMapping("/jury")
public class JuryRessources {

    private final Logger log = LoggerFactory.getLogger(JuryRessources.class);

    private static final String ENTITY_NAME = "jury";
    @Autowired
    private JuryService juryService;


    @PostMapping("/ajoutJury")
    public Jury createJury(@RequestBody Jury jury) throws URISyntaxException {
        log.debug("REST request to save Acquereur : {}", jury);

        Jury result = juryService.save(jury);
        return result;
    }
    @PutMapping("/updateJury")
    public Jury updateJury( @RequestBody Jury jury) {
        Jury result = juryService.save(jury);
        return result;
    }


    @GetMapping("/jurys")
    public List<Jury> getAllJurys(Pageable pageable) {
        log.debug("REST request to get a page of jury");
        List<Jury> jurys=juryService.findAll();

        return jurys;
    }

    @GetMapping("/getJury/{id}")
    public Optional<Jury> getJury(@PathVariable Integer id) {
        log.debug("REST request to get user : {}", id);
        Optional<Jury> jury = Optional.of(juryService.findOne(id).get());
        return jury;
    }


    @DeleteMapping("/deleteJury/{id}")
    public void deleteJury(@PathVariable Integer id) {

        try {
            juryService.delete(id);


        } catch (Exception e) {
            System.out.println("erreur");
        }

    }

}

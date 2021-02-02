package com.pds.demo.web;
import com.pds.demo.services.RapportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import com.pds.demo.domains.Rapport;

@CrossOrigin("*")
@RestController
@RequestMapping("/rapport")
public class RapportRessources{

    private final Logger log = LoggerFactory.getLogger(RapportRessources.class);

    private static final String ENTITY_NAME = "rapport";
    @Autowired
    private RapportService rapportService;

    @PostMapping("/ajoutRapport")
    public Rapport createRapport(@RequestBody Rapport rapport) throws URISyntaxException {
        log.debug("REST request to save Acquereur : {}", rapport);

        Rapport result = rapportService.save(rapport);
        return result;
    }
    @PutMapping("/updateRapport")
    public Rapport updateRapport( @RequestBody Rapport rapport) {
        Rapport result = rapportService.save(rapport);
        return result;
    }


    @GetMapping("/rapports")
    public List<Rapport> getAllRapports(Pageable pageable) {
        log.debug("REST request to get a page of rapport");
        List<Rapport> rapports=rapportService.findAll();

        return rapports;
    }

    @GetMapping("/rapport/{id}")
    public Optional<Rapport> getRapport(@PathVariable Integer id) {
        log.debug("REST request to get rapport : {}", id);
        Optional<Rapport> rapport = Optional.of(rapportService.findOne(id).get());
        return rapport;
    }


    @DeleteMapping("/rapportdelete/{id}")
    public void deleteRapport(@PathVariable Integer id) {

        try {
            rapportService.delete(id);


        } catch (Exception e) {
            System.out.println("erreur");
        }

    }























}

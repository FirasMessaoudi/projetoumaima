package com.pds.demo.domains;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Affectation {
    @EmbeddedId
    private RapportJuryId rapportJurryId;
    private Date dateSoutenance;
    private String mention;
    private String note;
    @ManyToOne
    @MapsId("id")
    private Jury jury;
    @ManyToOne
    @MapsId("id")
    private Rapport rapport;





}

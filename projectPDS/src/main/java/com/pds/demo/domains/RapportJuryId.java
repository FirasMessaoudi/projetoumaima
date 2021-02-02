package com.pds.demo.domains;


import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;

@Embeddable
@Data
public class RapportJuryId implements Serializable {

    private Integer idRapport;
    private Integer idJury;
}

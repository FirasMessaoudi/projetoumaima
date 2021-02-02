package com.pds.demo.domains;


import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Data
@Entity
@Table(name = "Utilisateur")
public class Utilisateur {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String adresse;
    private String niveauEtude;
    private Role role;

    @ManyToMany
    private List<Rapport> rapports;







}

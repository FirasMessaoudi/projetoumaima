package com.pds.demo.domains;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    Administrateur, etudiant;

    public String getAuthority() {
        return name();
    }
}

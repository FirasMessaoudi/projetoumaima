package com.pds.demo.security.rest;


import com.pds.demo.domains.Role;
import com.pds.demo.domains.Utilisateur;
import com.pds.demo.repository.UtilisateurRepository;
import com.pds.demo.security.dto.JwtResponse;
import com.pds.demo.security.dto.UserForm;
import com.pds.demo.security.jwt.JwtTokenProvider;
import com.pds.demo.services.UtilisateurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import javax.transaction.RollbackException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;




@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class UserController {
    private static final String FILE_NAME = "/home/user/Documents/a.pdf";
    private final Logger log = LoggerFactory.getLogger(Utilisateur.class);
    private static final String ENTITY_NAME = "user";

    @Autowired
    private UtilisateurService userService;

    @Autowired
    private UtilisateurRepository userRepository;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody UserForm loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        Utilisateur user = userRepository.findByEmail(loginRequest.getEmail());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(loginRequest.getEmail(),  user.getRole());

        return ResponseEntity.ok(new JwtResponse(jwt));
    }


//	@PutMapping("/users")
//	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user) {
//
//		UserDTO result = userService.save(user);
//		return ResponseEntity.ok()
//				.headers(HeaderUtil.createEntityUpdateAlert("USER", user.getId().toString()))
//				.body(result);
//	}


    /**
     * POST  /users : Créer un nouveau user.
     *
     * @param user user à  créer
     * @return ResponseEntity avec status 201 (Created) et nouveau user dans le body, ou status 400 (Bad Request) si user posséde deja un ID
     * @throws URISyntaxException exception si URI est incorrecte
     */

    @PostMapping("/signup")
    public ResponseEntity<Utilisateur> signup(@RequestBody Utilisateur user) throws URISyntaxException {
        log.debug("REST request to save user : {}", user);
        user.setRole(Role.etudiant);
        Utilisateur result = userService.save(user);

        return ResponseEntity.ok(result);
    }

}

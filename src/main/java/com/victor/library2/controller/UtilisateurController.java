package com.victor.library2.controller;

import com.victor.library2.exception.ResourceNotFoundException;
import com.victor.library2.model.Livre;
import com.victor.library2.model.Utilisateur;
import com.victor.library2.service.LivreService;
import com.victor.library2.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/listUtilisateur")
    public List<Utilisateur> getAllUtilisateurs() {
        return this.utilisateurService.getAllUsers();
    }

    @GetMapping("/detailUtilisateur/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Utilisateur utilisateurId = utilisateurService.getUserById(id);
        if (utilisateurId == null){
            new ResourceNotFoundException("Utilisateur not found for this id :: " + utilisateurId);
        }
        return ResponseEntity.ok().body(utilisateurId);
    }

    @PostMapping("/addUtilisateur")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return this.utilisateurService.saveUser(utilisateur);
    }

    @PutMapping("/updateUtilisateur/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable(value = "id") Long utilisateurId,
                                                @RequestBody Utilisateur utilisateurDetails) throws ResourceNotFoundException {
        Utilisateur utilisateur = utilisateurService.getUserById(utilisateurId);
        if (utilisateurId == null){
            new ResourceNotFoundException("Employee not found for this id :: " + utilisateurId);
        }
        utilisateur.setId(utilisateurDetails.getId());
        utilisateur.setAge(utilisateurDetails.getAge());
        utilisateur.setPrenom(utilisateurDetails.getPrenom());
        utilisateur.setUsername(utilisateurDetails.getUsername());
        utilisateur.setMail(utilisateurDetails.getMail());
        final Utilisateur updatedUtilisateur = utilisateurService.saveUser(utilisateur);
        return ResponseEntity.ok(updatedUtilisateur);
    }

    @DeleteMapping("/deleteLivre/{id}")
    public Map<String, Boolean> deleteUtilisateur(@PathVariable(value = "id") Long utilisateurId)
            throws ResourceNotFoundException {
        Utilisateur utilisateur= utilisateurService.getUserById(utilisateurId);
        if (utilisateurId == null){
            new ResourceNotFoundException("Utilisateur not found for this id :: " + utilisateurId);
        }
        this.utilisateurService.deleteUserById(utilisateurId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
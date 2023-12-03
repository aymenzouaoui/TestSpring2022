package com.example.springrevision45.controller;


import com.example.springrevision45.entities.Bibliotheque;
import com.example.springrevision45.entities.Rayon;
import com.example.springrevision45.services.iBibliothequeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("bibliotheque")
@Tag(name = "BibliothequeManagement", description = "Endpoints for managing Bibliotheque")

public class BibliothequeController {

    private final iBibliothequeService bibliothequeService;

    @PostMapping("/ajouter")
    public ResponseEntity<Bibliotheque> ajouterBibliotheque(@RequestBody Bibliotheque bibliotheque) {
        Bibliotheque savedBibliotheque = bibliothequeService.ajouterBibliotheque(bibliotheque);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBibliotheque);
    }

    @PostMapping("/ajouterRayon/{idBibliotheque}")
    public ResponseEntity<Rayon> ajouterRayonEtAffecterABibliotheque(@RequestBody Rayon rayon, @PathVariable Long idBibliotheque) {
        Rayon savedRayon = bibliothequeService.ajouterRayonEtAffecterABibliotheque(rayon, idBibliotheque);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRayon);
    }

    // Ajoutez d'autres méthodes si nécessaire
}
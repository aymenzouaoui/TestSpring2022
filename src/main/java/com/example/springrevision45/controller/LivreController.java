package com.example.springrevision45.controller;

import com.example.springrevision45.entities.Livre;
import com.example.springrevision45.services.iLivreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/livre")
public class LivreController {

    private final iLivreService livreService;

    @PostMapping("/ajouter/{idRayon}")
    public ResponseEntity<Void> ajouterLivreEtAffecterARayon(@RequestBody Livre livre, @PathVariable Long idRayon) {
        livreService.ajouterLivreEtAffecterARayon(livre, idRayon);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/titres/{idBibliotheque}/{idRayon}")
    public ResponseEntity<List<String>> titreLivreParBibliothequeEtRayon(
            @PathVariable Long idBibliotheque,
            @PathVariable Long idRayon
    ) {
        List<String> titres = livreService.titreLivreParBibliothequeEtRayon(idBibliotheque, idRayon);
        return ResponseEntity.ok(titres);
    }

    // Ajoutez d'autres méthodes si nécessaire
}

package com.example.springrevision45.controller;

import com.example.springrevision45.entities.Personel;
import com.example.springrevision45.services.iPersonelService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("personnel")
@Tag(name = "personnelManagement", description = "Endpoints for managing personnel")

public class PersonelController {

    private final iPersonelService personelService;

    @PostMapping("/ajouter")
    public ResponseEntity<Personel> ajouterPersonnelEtAffecterARayon(@RequestBody Personel personnel, @RequestParam String codeRayon) {
        Personel savedPersonnel = personelService.ajouterPersonnelEtAffecterARayon(personnel, codeRayon);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPersonnel);
    }

    @DeleteMapping("/desaffecter/{idPersonnel}")
    public ResponseEntity<Void> desaffecterPersonnelDuRayon(@PathVariable Long idPersonnel) {
        personelService.desaffecterPersonnelDuRayon(idPersonnel);
        return ResponseEntity.noContent().build();
    }

    // Ajoutez d'autres méthodes si nécessaire
}

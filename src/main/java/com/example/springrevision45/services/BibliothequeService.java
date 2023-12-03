package com.example.springrevision45.services;

import com.example.springrevision45.entities.Bibliotheque;
import com.example.springrevision45.entities.Rayon;
import com.example.springrevision45.repositories.iBibliothequeRepositories;
import com.example.springrevision45.repositories.iRayonRepositories;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service





public class BibliothequeService implements iBibliothequeService {


 private final iBibliothequeRepositories bibliothequeRepositories;
private final iRayonRepositories rayonRepositories;

    @Override
    public Bibliotheque ajouterBibliotheque(Bibliotheque bibliotheque) {
        return bibliothequeRepositories.save(bibliotheque);
    }

    @Override
    public Rayon ajouterRayonEtAffecterABibliotheque(Rayon rayon, Long idBibliotheque) {
        // Fetch the Bibliotheque entity by its ID
        Bibliotheque bibliotheque = bibliothequeRepositories.findById(idBibliotheque)
                .orElseThrow(() -> new RuntimeException("Bibliotheque not found with ID: " + idBibliotheque));
        rayon.setBibliotheque(bibliotheque);
        Rayon savedRayon =rayonRepositories.save(rayon);
        // Add the Rayon to the Bibliotheque's list of rayons
        bibliotheque.getRayons().add(savedRayon);
        bibliothequeRepositories.save(bibliotheque);
        return savedRayon;
    }


}

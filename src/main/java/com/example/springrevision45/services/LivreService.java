package com.example.springrevision45.services;

import com.example.springrevision45.entities.Livre;
import com.example.springrevision45.entities.Rayon;
import com.example.springrevision45.repositories.iLivreRepositories;
import com.example.springrevision45.repositories.iRayonRepositories;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;


@Service


@RequiredArgsConstructor

public class LivreService implements iLivreService {
  private final iRayonRepositories rayonRepositories;
  private final iLivreRepositories livreRepositories;
    @Override
    public void ajouterLivreEtAffecterARayon(Livre livre, Long idRayon) {
        Rayon rayon =rayonRepositories.findById(idRayon).orElse(null);
                livre.setRayon(rayon);
                livreRepositories.save(livre);
                rayon.getLivers().add(livre);
                rayonRepositories.save(rayon);

    }

    @Override
    public List<String> titreLivreParBibliothequeEtRayon(Long idBibliotheque, Long idRayon) {
        return livreRepositories.findTitresByBibliothequeAndRayon(idBibliotheque, idRayon);

    }
}

package com.example.springrevision45.services;

import com.example.springrevision45.entities.Bibliotheque;
import com.example.springrevision45.entities.Rayon;

public interface iBibliothequeService {
    Bibliotheque ajouterBibliotheque(Bibliotheque bibliotheque);
    public Rayon ajouterRayonEtAffecterABibliotheque (Rayon rayon, Long idBibliotheque);

}

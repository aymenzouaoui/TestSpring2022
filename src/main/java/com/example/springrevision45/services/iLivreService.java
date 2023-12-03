package com.example.springrevision45.services;

import com.example.springrevision45.entities.Livre;

import java.util.List;

public interface iLivreService {
    void ajouterLivreEtAffecterARayon(Livre livre, Long idRayon);
    List<String> titreLivreParBibliothequeEtRayon(Long idBibliotheque, Long idRayon) ;

}

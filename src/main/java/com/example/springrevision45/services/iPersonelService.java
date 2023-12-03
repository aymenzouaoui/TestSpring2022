package com.example.springrevision45.services;

import com.example.springrevision45.entities.Personel;

public interface iPersonelService {
    Personel ajouterPersonnelEtAffecterARayon(Personel personnel, String codeRayon);
    void desaffecterPersonnelDuRayon(Long idPersonnel) ;
}

package com.example.springrevision45.services;

import com.example.springrevision45.entities.Personel;
import com.example.springrevision45.entities.Rayon;
import com.example.springrevision45.entities.TypePersonel;
import com.example.springrevision45.repositories.iPersonelRepositories;
import com.example.springrevision45.repositories.iRayonRepositories;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class PersonelService implements iPersonelService{

    private final iPersonelRepositories personelRepositories;
    private final iRayonRepositories rayonRepositories;
    @Override
    public Personel ajouterPersonnelEtAffecterARayon(Personel personnel, String codeRayon) {
        Rayon rayon =rayonRepositories.findByCodeRayon(codeRayon);
        personnel.setRayon(rayon);
        Personel savedPersonnel =  personelRepositories.save(personnel);
        rayonRepositories.save(rayon);
        return savedPersonnel;
    }

    @Override
    public void desaffecterPersonnelDuRayon(Long idPersonnel) {
       /* Personel p  =personelRepositories.findById(idPersonnel).orElse(null);
        p.setTypePersonel(null);
        personelRepositories.save(p);*/
// Retrieve the personnel by ID
        Optional<Personel> optionalPersonel = personelRepositories.findById(idPersonnel);
        if (optionalPersonel.isPresent()) {
            Personel personnel = optionalPersonel.get();

            // Retrieve the Rayon associated with the personnel
            Rayon rayon = personnel.getRayon();

            // Remove the personnel from the Rayon
            rayon.getPersonels().remove(personnel);

            // Save the updated Rayon
            rayonRepositories.save(rayon);
        } else {
            // Handle the case when personnel with the given ID is not found
            throw new IllegalArgumentException("Personnel not found with ID: " + idPersonnel);
        }


    }
}

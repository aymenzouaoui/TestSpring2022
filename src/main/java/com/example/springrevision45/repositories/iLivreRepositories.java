package com.example.springrevision45.repositories;

import com.example.springrevision45.entities.Livre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface iLivreRepositories extends CrudRepository<Livre,Long> {

    @Query("SELECT livre.titre FROM Livre livre " +
            "JOIN livre.rayon rayon " +
            "JOIN rayon.bibliotheque bibliotheque " +
            "WHERE bibliotheque.idBibliotheque = :idBibliotheque " +
            "AND rayon.idRayon = :idRayon")
    List<String> findTitresByBibliothequeAndRayon(
            @Param("idBibliotheque") Long idBibliotheque,
            @Param("idRayon") Long idRayon
    );
}

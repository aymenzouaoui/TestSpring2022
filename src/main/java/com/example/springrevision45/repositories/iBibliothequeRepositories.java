package com.example.springrevision45.repositories;

import com.example.springrevision45.entities.Bibliotheque;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iBibliothequeRepositories extends CrudRepository<Bibliotheque,Long> {
}

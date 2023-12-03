package com.example.springrevision45.repositories;

import com.example.springrevision45.entities.Rayon;
import org.springframework.data.repository.CrudRepository;

public interface iRayonRepositories extends CrudRepository<Rayon,Long> {
    Rayon findByCodeRayon(String codeRayon);
}

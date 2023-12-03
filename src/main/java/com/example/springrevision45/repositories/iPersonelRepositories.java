package com.example.springrevision45.repositories;

import com.example.springrevision45.entities.Personel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface iPersonelRepositories extends CrudRepository<Personel,Long> {
    Personel findByNom(String nom);

}

package com.example.springrevision45.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.AccessType;

import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Bibliotheque {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
long idBibliotheque;
    String nomBibliotheque;
    Date DateCreation;
@OneToMany(mappedBy = "bibliotheque")
    List<Rayon>rayons;


}

package com.example.springrevision45.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Personel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPersonel;
    String nom;
    String prenom;

    @Enumerated(EnumType.STRING)
    TypePersonel typePersonel;

    @ManyToOne
    @JoinColumn(name = "idRayon")  // This represents the foreign key column in the Personel table
    Rayon rayon;
}

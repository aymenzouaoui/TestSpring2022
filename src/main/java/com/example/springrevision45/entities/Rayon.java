package com.example.springrevision45.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rayon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idRayon;
    String codeRayon;
    String nomRayon;

    @OneToMany(mappedBy = "rayon")
    List<Personel> personels;

    @ManyToOne
    Bibliotheque bibliotheque;

    @OneToMany(mappedBy = "rayon")
    List<Livre>Livers;

}

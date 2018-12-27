package fr.formation.twitterxs.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 4)
    private String language;

    @Column(nullable = false, length = 2)
    private String country;
}

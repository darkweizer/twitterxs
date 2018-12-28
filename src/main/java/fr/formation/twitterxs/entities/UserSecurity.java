package fr.formation.twitterxs.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class UserSecurity {

    @Column(length = 50, nullable = false, unique = true, updatable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;
}

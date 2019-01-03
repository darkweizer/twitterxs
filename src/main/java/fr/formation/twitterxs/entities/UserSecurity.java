package fr.formation.twitterxs.entities;

import fr.formation.twitterxs.entities.User.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class UserSecurity {

    @Column(length = 50, nullable = false, unique = true, updatable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 13, nullable = false)
    private Role role = Role.getDefault();

    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    private boolean accountNonExpired = true;

    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    private boolean accountNonLocked = true;

    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    private boolean credentialsNonExpired = true;

    @Convert(converter = BooleanConverter.class)
    @Column(length = 1, nullable = false)
    private boolean enabled = true;
}

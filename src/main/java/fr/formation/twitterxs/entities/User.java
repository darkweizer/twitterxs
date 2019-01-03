package fr.formation.twitterxs.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) //for no mapping
    private Long id;

    @Column(nullable = false, length = 100)
    private String firstname;

    @Column(nullable = false, length = 100)
    private String lastname;

    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, updatable = false)
    private LocalDateTime subscriptionDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Region region;

    @Embedded
    private UserSecurity security;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Tweet> tweets;


    public enum Role{
        ROLE_USER("USER"),
        ROLE_ADMIN("ADMIN"),
        ROLE_ACTUATOR("ACTUATOR");

        private final String notPrefixed;

        Role(String notPrefixed) {
            this.notPrefixed = notPrefixed;
        }

        public static Role getDefault(){
            return ROLE_USER;
        }

        public boolean isUser() {
            return equals(ROLE_USER);
        }

        public boolean isAdmin() {
            return equals(ROLE_ADMIN);
        }

        public boolean isActuator() {
            return equals(ROLE_ACTUATOR);
        }
    }
}

package fr.formation.twitterxs.jparepository;

import fr.formation.twitterxs.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserJpaRepository extends JpaRepository<Users, Long> {

    public List<Users> findAllByFirstnameContains(String firstname);
}

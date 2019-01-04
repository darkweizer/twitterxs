package fr.formation.twitterxs.jparepository;

import fr.formation.twitterxs.dto.UserDto;
import fr.formation.twitterxs.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.List;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    @Query("select new fr.formation.twitterxs.dto.UserDto(u.id, u.firstname, u.lastname, r.country) from User u join u.region r where u.firstname like %:firstname%")
    List<UserDto> findAllDto(@Param("firstname") String firstname);

    Boolean existsByEmailIgnoreCase(String email);

    @Nullable // Indicates that return can be null
    User findBySecurityUsername(String username);

    boolean existsBySecurityUsernameIgnoreCase(String username);
}

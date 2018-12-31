package fr.formation.twitterxs.jparepository;

import fr.formation.twitterxs.entities.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetJpaRepository extends JpaRepository<Tweet, Long> {
}

package fr.formation.twitterxs.jparepository;

import fr.formation.twitterxs.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionJpaRepository extends JpaRepository<Region, Long> {
}

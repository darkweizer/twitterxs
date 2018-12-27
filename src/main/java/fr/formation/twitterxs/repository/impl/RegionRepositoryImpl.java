package fr.formation.twitterxs.repository.impl;

import fr.formation.twitterxs.entities.Region;
import fr.formation.twitterxs.repository.RegionRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class RegionRepositoryImpl implements RegionRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Long save(Region region) {
        em.persist(region);
        return region.getId();
    }
}

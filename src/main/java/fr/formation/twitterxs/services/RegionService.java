package fr.formation.twitterxs.services;

import fr.formation.twitterxs.entities.Region;

import java.util.List;

public interface RegionService {

    Long save(Region region);

    List<Region> allRegion();
}

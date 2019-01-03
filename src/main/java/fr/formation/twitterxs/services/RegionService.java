package fr.formation.twitterxs.services;

import fr.formation.twitterxs.dto.ValueLabelDto;
import fr.formation.twitterxs.entities.Region;

import java.util.List;

public interface RegionService {

    Long save(Region region);

    List<Region> allRegion();

    List<ValueLabelDto> listValueLabel();
}

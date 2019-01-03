package fr.formation.twitterxs.services.impl;

import fr.formation.twitterxs.dto.ValueLabelDto;
import fr.formation.twitterxs.entities.Region;
import fr.formation.twitterxs.jparepository.RegionJpaRepository;
import fr.formation.twitterxs.repository.RegionRepository;
import fr.formation.twitterxs.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionJpaRepository jpaRepo ;

    @Autowired
    private RegionRepository repo;

    protected RegionServiceImpl(RegionJpaRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    public Long save(Region region) {
        return repo.save(region);
    }

    @Override
    public List<Region> allRegion() {
        return jpaRepo.findAll();
    }

    @Override
    public List<ValueLabelDto> listValueLabel() {
        List<Region> res = jpaRepo.findAll();
        List<ValueLabelDto> result = new ArrayList<>();

        for(Region reg : res) {
            ValueLabelDto val = new ValueLabelDto();
            val.setLabel(reg.getCountry());
            val.setValue(reg.getId());
            result.add(val);
        }
        return result;

    }
}

package fr.formation.twitterxs.services.impl;

import fr.formation.twitterxs.dto.UserCreateDto;
import fr.formation.twitterxs.dto.UserDto;
import fr.formation.twitterxs.entities.Region;
import fr.formation.twitterxs.entities.User;
import fr.formation.twitterxs.jparepository.RegionJpaRepository;
import fr.formation.twitterxs.jparepository.UserJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements fr.formation.twitterxs.services.UserService {

    @Autowired
    private ModelMapper mapper;

    private final UserJpaRepository userJpa;
    private final RegionJpaRepository regionJpa;

    protected UserServiceImpl(UserJpaRepository userJpa, RegionJpaRepository regionJpa) {
        this.userJpa = userJpa;
        this.regionJpa = regionJpa;
    }

    @Override
    public List<UserDto> allUsersByLastname(String firstname) {
        return userJpa.findAllDto(firstname);
    }

    @Override
    public void create(UserCreateDto dto) {
        User user =  mapper.map(dto, User.class);
        Region region = regionJpa.getOne(dto.getRegionId());
        user.setRegion(region);
        user.setSubscriptionDate(LocalDateTime.now());

        userJpa.save(user);
    }

    @Override
    public void delete(Long id) {
        userJpa.deleteById(id);
    }

    @Override
    public boolean isEmailExist(String email) {
        return userJpa.existsByEmailIgnoreCase(email);
    }
}

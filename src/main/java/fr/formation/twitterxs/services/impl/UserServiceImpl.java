package fr.formation.twitterxs.services.impl;

import fr.formation.twitterxs.dto.UpdatePasswordDto;
import fr.formation.twitterxs.dto.UserCreateDto;
import fr.formation.twitterxs.dto.UserDto;
import fr.formation.twitterxs.entities.Region;
import fr.formation.twitterxs.entities.User;
import fr.formation.twitterxs.jparepository.RegionJpaRepository;
import fr.formation.twitterxs.jparepository.UserJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements fr.formation.twitterxs.services.UserService {

    @Autowired
    private ModelMapper mapper;

    private final PasswordEncoder encoder;

    private final UserJpaRepository userJpa;
    private final RegionJpaRepository regionJpa;

    protected UserServiceImpl(PasswordEncoder encoder, UserJpaRepository userJpa, RegionJpaRepository regionJpa) {
        this.encoder = encoder;
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

        String pwd = user.getSecurity().getPassword();
        String encoded = encoder.encode(pwd);
        user.getSecurity().setPassword(encoded);

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

    @Override
    public void changePassword(UpdatePasswordDto dto) {
        User user = userJpa.findBySecurityUsername(dto.getUsername());
        user.getSecurity().setPassword(encoder.encode(dto.getNewPassword()));
        userJpa.save(user);
    }

    @Override
    public boolean isUsernameExsit(String username) {
        return userJpa.existsBySecurityUsernameIgnoreCase(username);
    }

    @Override
    public boolean isUserPassword(String username, String password) {
        return encoder.matches(password, userJpa.findBySecurityUsername(username).getSecurity().getPassword());
    }
}

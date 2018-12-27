package fr.formation.twitterxs.services;

import fr.formation.twitterxs.dto.UserCreateDto;
import fr.formation.twitterxs.entities.Users;

import java.util.List;

public interface UserService {

    List<Users> allUsersByLastname(String firstname);

    void create(UserCreateDto dto);
}

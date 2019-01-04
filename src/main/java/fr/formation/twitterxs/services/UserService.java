package fr.formation.twitterxs.services;

import fr.formation.twitterxs.dto.ChangePasswordDto;
import fr.formation.twitterxs.dto.UserCreateDto;
import fr.formation.twitterxs.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> allUsersByLastname(String firstname);

    void create(UserCreateDto dto);

    void delete(Long id);

    boolean isEmailExist(String email);

    void changePassword(ChangePasswordDto dto);

    boolean isUsernameExsit(String value);

    boolean isUserPassword(String username, String password);
}

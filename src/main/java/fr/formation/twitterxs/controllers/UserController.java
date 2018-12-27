package fr.formation.twitterxs.controllers;

import fr.formation.twitterxs.dto.UserCreateDto;
import fr.formation.twitterxs.dto.UserDto;
import fr.formation.twitterxs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{firstname}")
    protected List<UserDto> allUsersByLastname(@PathVariable("firstname") String firstname){
        return userService.allUsersByLastname(firstname);
    }

    @PostMapping("/create")
    protected void create(@Valid @RequestBody UserCreateDto dto){
        userService.create(dto);
    }

    @DeleteMapping("/delete/{id}")
    protected void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }
}
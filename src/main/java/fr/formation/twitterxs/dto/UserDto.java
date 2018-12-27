package fr.formation.twitterxs.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String country;

    public UserDto() {
    }

    public UserDto(Long id, String firstname, String lastname, String country) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
    }
}

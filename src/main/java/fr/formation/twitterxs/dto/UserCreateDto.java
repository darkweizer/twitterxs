package fr.formation.twitterxs.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserCreateDto {

    private String firstname;
    private String lastname;
    private String email;
    private LocalDate birthDate;
    private Long regionId;
}

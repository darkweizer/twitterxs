package fr.formation.twitterxs.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserSecurityCreateDto {

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 50, message = "{E_MAX_LENGTH_EXCEEDED}")
    private String username;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 10, message = "{E_MAX_LENGTH_EXCEEDED}")
    @ToString.Exclude
    private String password;
}

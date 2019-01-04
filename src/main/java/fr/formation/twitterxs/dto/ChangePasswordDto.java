package fr.formation.twitterxs.dto;

import fr.formation.twitterxs.errors.IsUserPassword;
import fr.formation.twitterxs.errors.NotSamePassword;
import fr.formation.twitterxs.errors.UsernameExist;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@IsUserPassword
@NotSamePassword
public class ChangePasswordDto {

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 50, message = "{E_MAX_LENGTH_EXCEEDED}")
    @UsernameExist
    private String username;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 10, message = "{E_MAX_LENGTH_EXCEEDED}")
    @ToString.Exclude
    private String password;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 10, message = "{E_MAX_LENGTH_EXCEEDED}")
    @ToString.Exclude
    private String newPassword;
}

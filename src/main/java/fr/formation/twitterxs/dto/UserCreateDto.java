package fr.formation.twitterxs.dto;

import fr.formation.twitterxs.errors.Adult;
import fr.formation.twitterxs.errors.UniqueEmail;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class UserCreateDto {

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 100, message = "{E_MAX_LENGTH_EXCEEDED}")
    private String firstname;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 100, message = "{E_MAX_LENGTH_EXCEEDED}")
    private String lastname;

    @Email(message = "{E_EMAIL_MALFORMED}")
    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 255, message = "{E_MAX_LENGTH_EXCEEDED}")
    @UniqueEmail
    private String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Adult
    @NotNull(message = "{E_NOT_NULL}")
    private LocalDate birthDate;

    @NotNull(message = "{E_NOT_NULL}")
    private Long regionId;

    @Valid
    @NotNull(message = "{E_NOT_NULL}")
    private UserSecurityCreateDto security;
}

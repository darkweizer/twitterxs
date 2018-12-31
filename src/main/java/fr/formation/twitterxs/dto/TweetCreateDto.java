package fr.formation.twitterxs.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TweetCreateDto {

    @NotNull(message = "{E_NOT_NULL}")
    private Long authorId;

    @NotBlank(message = "{E_NOT_BLANK}")
    @Size(max = 280, message = "{E_MAX_LENGTH_EXCEEDED}")
    private String content;
}

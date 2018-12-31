package fr.formation.twitterxs.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TweetSearchDto {

    private String username;

    private int page;

    private int size;

    public TweetSearchDto() {
    }

    public TweetSearchDto(String username, int page, int size) {
        this.username = username;
        this.page = page;
        this.size = size;
    }
}

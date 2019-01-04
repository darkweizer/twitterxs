package fr.formation.twitterxs.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StatsDto {

    private Long nbUser;
    private Long nbTweet;

    public StatsDto() {
    }

    public StatsDto(Long nbUser, Long nbTweet) {
        this.nbUser = nbUser;
        this.nbTweet = nbTweet;
    }
}

package fr.formation.twitterxs.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class TweetDto {

    private Long tweetId;
    private LocalDateTime postDate;
    private String content;

    public TweetDto() {
    }

    public TweetDto(Long tweetId, LocalDateTime postDate, String content) {
        this.tweetId = tweetId;
        this.postDate = postDate;
        this.content = content;
    }
}

package fr.formation.twitterxs.services;

import fr.formation.twitterxs.dto.TweetCreateDto;

public interface TweetService {
    void create(TweetCreateDto tweetCreateDto);
}

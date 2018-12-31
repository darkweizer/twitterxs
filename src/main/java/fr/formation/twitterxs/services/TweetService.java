package fr.formation.twitterxs.services;

import fr.formation.twitterxs.dto.SearchResultDto;
import fr.formation.twitterxs.dto.TweetCreateDto;
import fr.formation.twitterxs.dto.TweetDto;
import fr.formation.twitterxs.dto.TweetSearchDto;

public interface TweetService {
    void create(TweetCreateDto tweetCreateDto);

    SearchResultDto<TweetDto> feed(TweetSearchDto dto);
}

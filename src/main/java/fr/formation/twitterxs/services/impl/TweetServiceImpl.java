package fr.formation.twitterxs.services.impl;

import fr.formation.twitterxs.dto.SearchResultDto;
import fr.formation.twitterxs.dto.TweetCreateDto;
import fr.formation.twitterxs.dto.TweetDto;
import fr.formation.twitterxs.dto.TweetSearchDto;
import fr.formation.twitterxs.entities.Tweet;
import fr.formation.twitterxs.entities.User;
import fr.formation.twitterxs.jparepository.TweetJpaRepository;
import fr.formation.twitterxs.jparepository.UserJpaRepository;
import fr.formation.twitterxs.services.TweetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TweetServiceImpl implements TweetService {

    @Autowired
    private ModelMapper mapper;

    private final UserJpaRepository userJpa;
    private final TweetJpaRepository tweetJpa;

    public TweetServiceImpl(UserJpaRepository userJpa, TweetJpaRepository tweetJpa) {
        this.userJpa = userJpa;
        this.tweetJpa = tweetJpa;
    }

    @Override
    public void create(TweetCreateDto tweetCreateDto) {
        Tweet tweet = mapper.map(tweetCreateDto, Tweet.class);
        User user = userJpa.getOne(tweetCreateDto.getAuthorId());
        LocalDateTime now = LocalDateTime.now();
        tweet.setAuthor(user);
        tweet.setPostDate(now);
        tweet.setEditDate(now);

        tweetJpa.save(tweet);
    }

    @Override
    public SearchResultDto<TweetDto> feed(TweetSearchDto dto) {
        Pageable pageable = PageRequest.of(dto.getPage(), dto.getSize());

        Page<TweetDto> page = tweetJpa.findByUsername(dto.getUsername(), pageable);
        return new SearchResultDto<>(page.getContent(), page.getTotalElements());
    }
}

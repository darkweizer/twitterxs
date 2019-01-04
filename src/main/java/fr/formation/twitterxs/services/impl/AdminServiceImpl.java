package fr.formation.twitterxs.services.impl;

import fr.formation.twitterxs.dto.StatsDto;
import fr.formation.twitterxs.jparepository.TweetJpaRepository;
import fr.formation.twitterxs.jparepository.UserJpaRepository;
import fr.formation.twitterxs.services.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private UserJpaRepository jpaUser;
    private TweetJpaRepository jpaTweet;

    public AdminServiceImpl(UserJpaRepository jpaUser, TweetJpaRepository jpaTweet) {
        this.jpaUser = jpaUser;
        this.jpaTweet = jpaTweet;
    }

    @Override
    public ResponseEntity<StatsDto> findStatsNbUsersAndNbTweets() {

        StatsDto statsDto = new StatsDto(jpaUser.count(), jpaTweet.count());
        ResponseEntity<StatsDto> stats = new ResponseEntity<StatsDto>(statsDto, HttpStatus.OK);

        return stats;
    }
}

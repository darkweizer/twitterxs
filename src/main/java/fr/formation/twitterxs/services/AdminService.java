package fr.formation.twitterxs.services;

import fr.formation.twitterxs.dto.StatsDto;
import org.springframework.http.ResponseEntity;

public interface AdminService {

    ResponseEntity<StatsDto> findStatsNbUsersAndNbTweets();
}

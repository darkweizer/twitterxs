package fr.formation.twitterxs.controllers;

import fr.formation.twitterxs.dto.TweetCreateDto;
import fr.formation.twitterxs.services.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetController extends BaseController {

    private TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping("/create")
    protected void create(@Valid @RequestBody TweetCreateDto tweetCreateDto){
        tweetService.create(tweetCreateDto);
    }
}

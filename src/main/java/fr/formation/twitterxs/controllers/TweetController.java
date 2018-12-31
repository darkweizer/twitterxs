package fr.formation.twitterxs.controllers;

import fr.formation.twitterxs.dto.SearchResultDto;
import fr.formation.twitterxs.dto.TweetCreateDto;
import fr.formation.twitterxs.dto.TweetDto;
import fr.formation.twitterxs.dto.TweetSearchDto;
import fr.formation.twitterxs.services.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/feed/{username}")
    protected SearchResultDto<TweetDto> searchResult(@PathVariable(value = "username", required = false) String username,
                                                     @RequestParam(name = "p", required = false) Integer p,
                                                     @RequestParam(name = "s", required = false) Integer s){
        int page = null == p ? 0 : Integer.max(0, p);
        int size = null == p ? 5 : Integer.max(1, s);
        TweetSearchDto dto = new TweetSearchDto(username, page, size);
        return tweetService.feed(dto);
    }
}

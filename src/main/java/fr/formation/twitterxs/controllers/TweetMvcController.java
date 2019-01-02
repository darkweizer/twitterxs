package fr.formation.twitterxs.controllers;

import fr.formation.twitterxs.dto.SearchResultDto;
import fr.formation.twitterxs.dto.TweetCreateDto;
import fr.formation.twitterxs.dto.TweetDto;
import fr.formation.twitterxs.dto.TweetSearchDto;
import fr.formation.twitterxs.services.TweetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/mvc/tweets")
public class TweetMvcController {

    private final TweetService service;

    protected TweetMvcController(TweetService service) {
        this.service = service;
    }

    @GetMapping("/feed/{username}")
    public String feed(@PathVariable("username") String username, Model model){
        TweetSearchDto dto = new TweetSearchDto(username, 0, 100);
        SearchResultDto<TweetDto> tweets = service.feed(dto);
        model.addAttribute("tweets", tweets);
        return "feed";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("tweet")TweetCreateDto tweet, Model model) {
        return "create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("tweet") TweetCreateDto tweet, BindingResult result, Model model){
        if(!result.hasErrors()){
            service.create(tweet);
            model.addAttribute("tweet", new TweetCreateDto()); // Reset Form
        }
        return "create";
     }
}

package fr.formation.twitterxs.controllers;

import fr.formation.twitterxs.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController // Spring context
@RequestMapping("test")
public class TestController {

//    @Autowired
    private TestService service;

    @Autowired
    public TestController(TestService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    protected String hello(){
        return "Hello Spring boot!";
    }

    @GetMapping("/weekdays")
    protected List<String> weekdays(){
        return Arrays.asList("Monday", "Tuesday", "Wednesday", "Thirsday", "Friday");
    }

    @GetMapping("/weekday/{day}")
    protected String weekday(@PathVariable("day") String day){
        String result = null;
        switch (day){
            case "mo":
                result = "Monday";
                break;
            case "tu":
                result = "Tuesday";
                break;
            default:
                result = "Friday";
                break;
        }
        return result;
    }

    @GetMapping("/weekday")
    protected String weekdayParam(@RequestParam("abbr") String abbr){
        return service.getWeekDay(abbr);
    }
}

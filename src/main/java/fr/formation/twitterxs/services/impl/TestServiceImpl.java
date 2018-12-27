package fr.formation.twitterxs.services.impl;

import fr.formation.twitterxs.services.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String getWeekDay(String day) {
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
}

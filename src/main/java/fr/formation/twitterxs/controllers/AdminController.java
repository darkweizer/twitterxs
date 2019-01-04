package fr.formation.twitterxs.controllers;

import fr.formation.twitterxs.dto.StatsDto;
import fr.formation.twitterxs.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController extends BaseController{

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/template/{className}")
    protected Object template(@PathVariable("className") String className)
            throws Exception {
        return Class.forName(className).newInstance();
    }

    @GetMapping("/stats")
    protected ResponseEntity<StatsDto> stats(){
        return adminService.findStatsNbUsersAndNbTweets();
    }

    /*@GetMapping("/stats/{username}")
    protected ResponseEntity<StatsDto> stats(@PathVariable("username") String username){
        ResponseEntity<StatsDto> stats = adminService.findStatsNbUsersAndNbTweets();

        return stats;
    }*/
}

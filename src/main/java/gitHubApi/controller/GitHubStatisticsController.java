package gitHubApi.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gitHubApi.service.UserService;

@RestController
@RequestMapping()
public class GitHubStatisticsController {

    private final UserService service;

    @Autowired
    public GitHubStatisticsController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/checkCurrentUser")
    public String response(@RequestParam String username) {
        return service.getCurrentUser(username);
    }
}

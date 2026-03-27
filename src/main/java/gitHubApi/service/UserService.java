package gitHubApi.service;

import gitHubApi.errorHandling.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gitHubApi.DTOs.ResponseDTO;
import gitHubApi.client.GitHubClient;

@Service
public class UserService {

    private final GitHubClient client;

    @Autowired
    public UserService(GitHubClient client) {
        this.client = client;
    }

    public String getCurrentUser(String username) {

        ResponseDTO response = client.getUser(username);
        if (response == null) {
            throw new UserNotFoundException("User %s not found".formatted(username));
        }
        return "Hello, %s! You have just accessed your gitHub profile. Happy coding. Your bio is: %s"
                .formatted(response.getName(), response.getBio());
    }
}

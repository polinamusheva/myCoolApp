package gitHubApi.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import gitHubApi.DTOs.ResponseDTO;

@Component
public class GitHubClient {

    private final RestClient restClient;

    private final String userPath = "/users/{user}";

    public GitHubClient(RestClient restClient) {
        this.restClient = restClient;
    }

    private final Logger log = LoggerFactory.getLogger(GitHubClient.class);

    public ResponseDTO getUser(String user) {
        String uri = userPath.replace("{user}", user);
        ResponseDTO currentUser = restClient.get()
                .uri(uri)
                .retrieve()
                .body(ResponseDTO.class);
        log.info("Successfully retrieved {} endpoint", userPath);
        return currentUser;
    }

}

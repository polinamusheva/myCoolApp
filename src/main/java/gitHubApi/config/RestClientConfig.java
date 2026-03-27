package gitHubApi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.List;

@Configuration
public class RestClientConfig {
    private final String BASE_URL = "https://api.github.com";
    private final String TOKEN = System.getenv("GITHUB_TOKEN");


    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl(BASE_URL)
                .defaultHeaders(headers -> {
                    headers.setBearerAuth(TOKEN);
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    headers.setAccept(List.of(MediaType.parseMediaType("application/vnd.github+json")));
                })
                .build();
    }
}

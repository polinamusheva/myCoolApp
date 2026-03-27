package gitHubApi;

import gitHubApi.DTOs.ResponseDTO;
import gitHubApi.client.GitHubClient;
import org.assertj.core.api.SoftAssertions;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Tag("integration")
class gitHubApplicationTests {

    private final GitHubClient gitHubClient;

    @Autowired
    public gitHubApplicationTests(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }


    @Test
    public void getUser() {
        String username = "polinamusheva";
        ResponseDTO response = gitHubClient.getUser(username);
        SoftAssertions softAssert = new SoftAssertions();

        softAssert.assertThat(response)
                .isNotNull();

        softAssert.assertThat(response.getLogin())
                .isEqualTo(username);

        softAssert.assertAll();
    }
}

package gitHubApi.service;

import gitHubApi.DTOs.ResponseDTO;
import gitHubApi.client.GitHubClient;
import gitHubApi.errorHandling.UserNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Tag("unit")
public class UserServiceTest {

    @Mock
    private GitHubClient mockedClient;

    @InjectMocks
    private UserService userService;

    @ParameterizedTest()
    @CsvSource({
            "Polina, QA Engineer",
            "John, Developer",
            "Katie, Just another freak coder"
    })
    public void shouldReturnFormattedMessage(String name, String bio) {
        //given
        String username = "polinamusheva";

        ResponseDTO mockedResponse = new ResponseDTO();
        mockedResponse.setName(name);
        mockedResponse.setBio(bio);

        //actual mocking magic
        when(mockedClient.getUser(username)).thenReturn(mockedResponse);

        String responseMessage = userService.getCurrentUser(username);
        String expectedMessage = "Hello, %s! You have just accessed your gitHub profile. Happy coding. Your bio is: %s".formatted(mockedResponse.getName(), mockedResponse.getBio());

        //then assert that the service logic is as expected
        Assertions.assertThat(expectedMessage).isEqualTo(responseMessage);

        //check that Mockito calls the mocked gitHubClient
        verify(mockedClient).getUser(username);
    }

    @Test
    public void shouldReturnUserNotFoundMessage() {
        //given
        String username = "null";

        ResponseDTO response = new ResponseDTO();

        //actual mocking magic
        when(mockedClient.getUser(username)).thenReturn(null);

        //then assert that the service logic is as expected
        assertThrows(UserNotFoundException.class,
                () -> userService.getCurrentUser(username));

        //check that Mockito calls the mocked gitHubClient
        verify(mockedClient).getUser(username);
    }
}

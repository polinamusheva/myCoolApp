package gitHubApi.UI;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;


    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @ParameterizedTest()
    @CsvSource({
            "polimusheva@gmail.com, polinamusheva20102016"
    })
    public void enterValidCreds (String username, String password){
        loginPage.open();
        loginPage.login(username, password);

        Assertions.assertThat(driver.getCurrentUrl()).contains("github");
        //Assertions.assertThat(page.title.equals("https://github.com/sessions/two-factor/webauthn"));

    }

    @AfterEach
    void closeBrowser() {
        driver.quit();
    }
}

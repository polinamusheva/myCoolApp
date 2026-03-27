package gitHubApi.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage extends BasePage {


    private final By usernameField = By.id("login_field");
    private final By passwordField = By.id("password");
    private final By signInButton = By.name("commit");
    private final By errorMessage = By.cssSelector(".flash-error");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private void enterUsername(String username) {
        super.waitForVisible(usernameField).sendKeys(username);
    }

    private void enterPassword(String password) {
        super.waitForVisible(passwordField).sendKeys(password);
    }

    private void pressSignInButton() {
        super.waitForClickable(signInButton).click();
    }

    public void open() {
        driver.get("https://github.com/login");
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        pressSignInButton();
    }
}

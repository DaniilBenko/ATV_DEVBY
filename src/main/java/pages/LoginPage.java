package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

public class LoginPage extends AbstractPage {
    @FindBy(id = "user_login")
    private WebElement loginField;

    @FindBy(id = "user_password")
    private WebElement passwordField;

    @FindBy(css = "#new_user > div:nth-child(2) > div.input.action > input")
    private WebElement commitButton;

    public LoginPage() throws MalformedURLException {
        super();
    }

    public void enterLogin(String login) {
        loginField.clear();
        loginField.sendKeys(login);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickCommit() {
        commitButton.click();
    }

    public void doLogin(String login, String password) {
        this.enterLogin(login);
        this.enterPassword(password);
        this.clickCommit();

    }
}

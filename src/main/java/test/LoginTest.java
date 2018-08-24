package test;

import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

@Listeners({TestListener.class})
public class LoginTest extends AbstractTest {
    private String loginFailedMessage = "Looks you are NOT logged in correctly!";

    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        init();
    }

    @Test(description = "Login to YouTube account")
    public void loginToDevBy() {
        menu.clickSignIn();
        loginpage.doLogin(Constants.Correct.LOGIN_CORRECT, Constants.Correct.PASSWORD_CORRECT);
        Assert.assertTrue(menu.isLoggedIn(), loginFailedMessage);

    }
}

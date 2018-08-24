package test;

import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

@Listeners({TestListener.class})
public class NavigationTest extends AbstractTest {
    private String loginFailedMessage = "Looks you are NOT logged in correctly!";
    private String companiesFailedMessage = "companies page is not opened";
    private String publicationsFailedMessage = "publications page is not opened";


    @BeforeClass
    public void beforeMethod() throws MalformedURLException {
        init();
    }

    @Test
    public void navigating() {
        driver.manage().window().maximize();
        menu.clickPublications();
        Assert.assertTrue(publications.isOpened(), publicationsFailedMessage);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        menu.clickCompanies();
        Assert.assertTrue(companies.isOpened(), companiesFailedMessage);

    }}
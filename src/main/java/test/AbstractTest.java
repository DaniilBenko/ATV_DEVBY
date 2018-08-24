package test;

import manager.DriverManager;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.net.MalformedURLException;

public abstract class AbstractTest {
    protected Companies companies;
    protected Menu menu;
    protected Publications publications;
    protected LoginPage loginpage;
    protected WebDriver driver;

    public void init() throws MalformedURLException {
        loginpage = new LoginPage();
        menu = new Menu();
        publications = new Publications();
        companies = new Companies();
        driver = DriverManager.getDriverManager().getDriver();
    }
}

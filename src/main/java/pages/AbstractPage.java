package pages;

import manager.DriverManager;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class AbstractPage {
    AbstractPage() throws MalformedURLException {
        PageFactory.initElements(DriverManager.getDriverManager().getDriver(), this);
    }

    String getTitle() throws MalformedURLException {
        return DriverManager.getDriverManager().getDriver().getTitle();
    }
}
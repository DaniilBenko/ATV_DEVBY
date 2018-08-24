package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

public class Publications extends AbstractPage{
    @FindBy (partialLinkText = "ЛЕНТА")
    private WebElement lenta;

    public Publications() throws MalformedURLException {
        super();
    }

    public boolean isOpened(){
        return (lenta.isDisplayed());
    }
}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

public class Companies extends AbstractPage{


    @FindBy(xpath = "//ul[contains(@class, 'sort-panel-company')]")
    private WebElement companyPanel;


    public Companies() throws MalformedURLException {
        super();
    }

    public boolean isOpened(){
        return companyPanel.isDisplayed();
    }
}

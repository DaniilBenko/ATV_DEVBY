package pages;

import manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;
import java.util.List;

public class Menu extends AbstractPage{
    @FindBy(className = "icon-button" )
    private WebElement signInButton;

    @FindBy(className = "user-info__photo" )
    private WebElement userInfoPhoto;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/header/div[1]/div[1]/nav/div[5]/a" )
    private WebElement companiesButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/header/div[1]/div[1]/nav/div[1]/a" )
    private WebElement publicationsButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/header/div[1]/div[2]/div[2]/div[1]/div/button" )
    private WebElement burgerButton;

    @FindBy(xpath = "//*[@id=\"popupContainer\"]/div[1]/div/button/svg" )
    private WebElement xButton;

    @FindAll(@FindBy(className = "header-nav__link"))
    private List<WebElement> menuButtons;

    public Menu() throws MalformedURLException {
        super();
    }

    public void clickSignIn(){
        signInButton.click();
    }

    public void clickBurger(){
        burgerButton.click();
    }

    public void clickCompanies(){
        companiesButton.click();
    }

    public void clickPublications(){
        publicationsButton.click();
    }

    public boolean isBurberPresent(){
        return burgerButton.isDisplayed();
    }

    public boolean isXPresent(){
        return xButton.isDisplayed();
    }

    public boolean isLoggedIn(){
        signInButton.click();
        return signInButton.isDisplayed();
    }

    public boolean isNotSelectedColorRightDesktop(int index) throws MalformedURLException {
        return getColorChangeDesktop(index).contains("34, 34, 34");
    }

    public String getColorChangeDesktop(int index) throws MalformedURLException {
        Actions actions = new Actions(DriverManager.getDriverManager().getDriver());
        actions.moveToElement(menuButtons.get(index)).build().perform();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String color = menuButtons.get(index).getCssValue("color");
        System.out.println("COLOR "+color);
        return color;
    }

    public boolean isNotSelectedColorRightMobile(int index){
        return menuButtons.get(index).getCssValue("color").contains("40, 60, 220");
    }

    public String getColorChangeMobile(int index) {
        return menuButtons.get(index).getCssValue("color");
    }

}

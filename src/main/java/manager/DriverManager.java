package manager;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static DriverManager driverManager;
    private WebDriver driver;


    private DriverManager() throws MalformedURLException {

        driver = DriverFactory.setupDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

    }

    public static DriverManager getDriverManager() throws MalformedURLException {
        if (driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    public WebDriver getDriver() {
        return driver;
    }

}


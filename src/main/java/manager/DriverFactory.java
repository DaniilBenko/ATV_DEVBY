package manager;

import constants.Browsers;
import constants.Platforms;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static final Logger logger = LogManager.getLogger(DriverFactory.class);

    public static WebDriver setupDriver() throws MalformedURLException {

        Platforms platforms = Platforms.valueOf(ProjectProperties.getProperties().getProperty("platform").toUpperCase());
        Browsers browsers = Browsers.valueOf(ProjectProperties.getProperties().getProperty("browser").toUpperCase());
        System.setProperty(browsers.getKey(), browsers.getPath());
        DesiredCapabilities capabilities = DesiredCapabilities.android();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Mi 5");
        capabilities.setCapability(MobileCapabilityType.VERSION, "8.0");
        URL url = new URL("http://localhost:4723/wd/hub");

        switch (platforms) {
            case DESKTOP:{
                switch (browsers) {
                    case CHROME: {
                        logger.log(Level.INFO, "Google Chrome webdriver set with thread name = " + Thread.currentThread().getName());
                        return new ChromeDriver();
                    }
                    case FIREFOX: {
                        logger.log(Level.INFO, "Google Chrome webdriver set with thread name = " + Thread.currentThread().getName());
                        return new FirefoxDriver();
                    }
                    default: {
                        throw new UnsupportedDriverException("Can not load driver '" + browsers + "'");
                    }
                }
            }
            case ANDROID:{
                logger.log(Level.INFO, "Android driver set with thread name = " + Thread.currentThread().getName());
                return new AndroidDriver(url, capabilities);
            }

            default: {
                throw new UnsupportedDriverException("Can not load driver for '" + platforms + "'");
            }
        }

    }

}

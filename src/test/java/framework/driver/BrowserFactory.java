package framework.driver;

import framework.properties.PropertiesFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    private static volatile BrowserFactory instance;
    private PropertiesFactory properties = new PropertiesFactory();
    WebDriver driver;
    protected Wait<WebDriver> wait;

    public static synchronized BrowserFactory getInstance() {
        if (instance == null) {
            instance = new BrowserFactory();
        }
        return instance;
    }

    public WebDriver setDriver(String driverName) {
        switch (driverName.toLowerCase()) {
            case "firefox":

                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(properties.getWaitTime(), TimeUnit.SECONDS);
                wait = new WebDriverWait(driver, properties.getWaitTime());
                break;

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(properties.getWaitTime(), TimeUnit.SECONDS);
                wait = new WebDriverWait(driver, properties.getWaitTime());
                break;

            default:
                System.out.println("Error: this type of browser is not exist. Check your configuration.");
        }
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Wait<WebDriver> getWait() {
        return wait;
    }
}
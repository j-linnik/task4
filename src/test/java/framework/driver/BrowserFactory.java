package framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {

    private static volatile BrowserFactory instance;
    WebDriver driver;
    private String downloadDirectory = "C:\\downloads\\";

    public static BrowserFactory getInstance() {
        if (instance == null) {
            synchronized (BrowserFactory.class) {
                if (instance == null) {
                    instance = new BrowserFactory();
                }
            }
        }
        return instance;
    }

    public WebDriver setDriver(String driverName) {
        driver = null;
        switch (driverName.toLowerCase()) {
            case "firefox":
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream");
                profile.setPreference("browser.download.folderList", 2);
                profile.setPreference("browser.download.dir", downloadDirectory);
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setProfile(profile);
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                driver = new FirefoxDriver(fOptions);
                break;

            case "chrome":
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> settings = new HashMap<>();
                settings.put("safebrowsing.enabled", "true");
                settings.put("download.default_directory" , downloadDirectory);
                options.setExperimentalOption("prefs", settings);
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                driver = new ChromeDriver(options);
                break;

            default:
                System.out.println("Error: this type of browser is not exist. Check your configuration.");
        }
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
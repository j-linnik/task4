package framework.base;

import framework.driver.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import framework.properties.PropertiesFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest{

    protected PropertiesFactory properties;
    protected WebDriver driver;

    protected Wait<WebDriver> wDWait;

    public BaseTest() {
        this.properties = new PropertiesFactory();
    }

    @BeforeTest
    public void setDriver() {
        this.driver = BrowserFactory.getInstance().setDriver(properties.getBrowserName());
        driver.manage().timeouts().implicitlyWait(properties.getWaitTime(), TimeUnit.SECONDS);
        wDWait = new WebDriverWait(driver, properties.getWaitTime());
        navigateToHomeUrl();
    }

    @AfterTest
    public void quitDriver(){
        driver.quit();
    }

    public void navigateToHomeUrl() {
        driver.navigate().to(properties.getMainPageUrl());
    }

}

package framework.base;

import framework.driver.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseElement extends BaseTest {

    protected WebElement element;
    protected WebDriver driver;
    protected Wait<WebDriver> wDWait;
    protected static Wait<WebDriver> fluentWait;

    {
        this.driver = BrowserFactory.getInstance().getDriver();
        wDWait = new WebDriverWait(driver, properties.getWaitTime());

        fluentWait = new FluentWait<WebDriver>(driver)
            .withTimeout(properties.getWaitTime(), SECONDS)
            .pollingEvery(properties.getPollingTime(), SECONDS)
            .ignoring(StaleElementReferenceException.class);
    }

    public BaseElement(String xpath) {
        try {
            element = driver.findElement(By.xpath(xpath));
        } catch (NullPointerException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public BaseElement (WebElement element) {
        this.element = element;
    }

    public boolean isDisplayed() {
        wDWait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public boolean isEnabled() {
        wDWait.until(ExpectedConditions.elementToBeClickable(element));
        return element.isEnabled();
    }

    public void click() {
        isEnabled();
        element.click();
    }

    public void clickAndWait() {
        click();
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        wDWait.until(pageLoadCondition);
    }

    public String getText() {
        if(element != null) {
            return element.getText();
        }
        return "No such element";
    }

    public WebElement getElement() {
        return element;
    }

    public void moveMouseToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}

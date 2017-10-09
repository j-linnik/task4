package framework.base.elements;

import framework.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ComboBox extends BaseElement {

    private Select select;
    private String optionsLocator = "%s/option";

    public ComboBox(String xpath) {
        super(xpath);
        select = new Select(driver.findElement(By.xpath(xpath)));
        optionsLocator = String.format(optionsLocator, xpath);
    }

    public void selectByValue(String value) {
        wDWait.until(ExpectedConditions.textToBe(By.xpath(optionsLocator), value));
        select.selectByValue(value);
    }

    public void selectByText(String text) {
        select.selectByVisibleText(text);
    }

    public String getSelectedText() {
        return select.getFirstSelectedOption().getText();
    }


    public String getRandomValue() {
        wDWait.until(ExpectedConditions.elementToBeClickable(this.getElement()));
        String randomText;
        int randomIndex = 0;
        List<WebElement> options = driver.findElements(By.xpath(optionsLocator));
        while(randomIndex < 1) {
            randomIndex = (int) (Math.random() * options.size());
        }
        randomText = options.get(randomIndex).getText();
        selectByText(randomText);
        return randomText;
    }

    public int getValuesAmount() {
        List<WebElement> values = driver.findElements(By.xpath(optionsLocator));
        return values.size();
    }
}

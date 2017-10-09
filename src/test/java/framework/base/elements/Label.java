package framework.base.elements;

import framework.base.BaseElement;
import framework.driver.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Label extends BaseElement {

    public Label(String xpath) {
        super(xpath);
    }

    public Label (WebElement element) {
        super(element);
    }

    public static Label getNewLabel (String xpath) {
        WebElement waitingElement = BrowserFactory.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        return new Label(waitingElement);
    }



}

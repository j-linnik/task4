package framework.base.elements;

import framework.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ComboBox extends BaseElement {

    private Select select;

    public ComboBox(String xpath) {
        super(xpath);
        select = new Select(driver.findElement(By.xpath(xpath)));
    }

    public void selectByValue(String value) {
        select.selectByValue(value);
    }
}

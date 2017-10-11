package base;

import base.elements.Label;
import driver.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class BaseForm extends BaseTest{

    protected WebDriver driver = BrowserFactory.getInstance().getDriver();

    public List<WebElement> confirmPageLoad(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    public List<Label> getElementsToLabelList(String xpath) {
        List<Label> labelList = new ArrayList<>();
        List<WebElement> tabElements = driver.findElements(By.xpath(xpath));
        for(int i = 0; i < tabElements.size(); i++){
            labelList.add(new Label(tabElements.get(i)));
        }
        return labelList;
    }

    public void goToUrl(String url) {
        driver.get(url);
    }
}

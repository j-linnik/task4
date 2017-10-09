package framework.base;

import framework.properties.PropertiesFactory;
import org.openqa.selenium.WebDriver;

public abstract class BaseEntity {

    protected static PropertiesFactory properties = new PropertiesFactory();
    protected WebDriver driver;

    public void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

}

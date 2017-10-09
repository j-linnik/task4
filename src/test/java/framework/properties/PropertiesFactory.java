package framework.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFactory {

    private Properties seleniumProperties;
    private String seleniumPropertiesPath = "src/test/resources/selenium.properties";

    public PropertiesFactory() {
        seleniumProperties = new Properties();
        try{
            seleniumProperties.load(new FileInputStream(seleniumPropertiesPath));
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public String getMainPageUrl() {
        return seleniumProperties.getProperty("website_url").toLowerCase();
    }

    public String getBrowserName() {
        return seleniumProperties.getProperty("browser_name").toLowerCase();
    }

    public long getWaitTime() {
        return Long.valueOf(seleniumProperties.getProperty("wait_time"));
    }
}

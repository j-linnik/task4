package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFactory {

    private Properties seleniumProperties;
    private String seleniunPropertiesPath = "src/resources/selenium.properties";

    private Properties languageProperties;
    private String languagePropertiesPath = "src/resources/localization/loc_%s.properties";

    public PropertiesFactory() {
        seleniumProperties = new Properties();
        try{
            seleniumProperties.load(new FileInputStream(seleniunPropertiesPath));
        } catch (IOException ex){
            ex.printStackTrace();
        }

        this.setLanguageProperties();
    }

    public String getMainPageUrl() {
        return seleniumProperties.getProperty("website_url").toLowerCase();
    }

    public String getTestLanguage() {
        return seleniumProperties.getProperty("set_language").toLowerCase();
    }

    public String getBrowserName() {
        return seleniumProperties.getProperty("browser_name").toLowerCase();
    }

    public long getWaitTime() {
        return Long.valueOf(seleniumProperties.getProperty("wait_time"));
    }

    public long getPollingTime() {
        return Long.valueOf(seleniumProperties.getProperty("polling_time"));
    }

    //texts for locators
    public String getLanguageText() {
        return languageProperties.getProperty("language");
    }

    public String getMenuGemesText() {
        return languageProperties.getProperty("menu_games");
    }

    public String getActionGamesText() {
        return languageProperties.getProperty("action_games");
    }

    public String getActionGamesSpecialsText() {
        return languageProperties.getProperty("action_games_specials");
    }

    private void setLanguageProperties() {
        languagePropertiesPath = String.format(languagePropertiesPath, getTestLanguage());
        try {
            languageProperties = new Properties();
            languageProperties.load(new FileInputStream(languagePropertiesPath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

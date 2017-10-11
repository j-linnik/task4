import base.elements.Button;
import base.elements.Label;
import elements.MenuElement;
import org.openqa.selenium.NoSuchElementException;
import base.BaseForm;

public class MainPage extends BaseForm {
    private String btnLanguageLocator = "//span[@id='language_pulldown']";
    private String lblLanguageItemsLocator = "//a[contains(text(),\"%s\")]";
    private Label pnlMenu = new Label("//div[@class=\"store_nav\"]");
    private MenuElement menu = new MenuElement (pnlMenu);

    public void checkLanguageSettings() {
        Button btnLanguage = new Button(btnLanguageLocator);
        try{
            Label lblLanguage = new Label(String.format(lblLanguageItemsLocator, properties.getLanguageText()));
            btnLanguage.click();
            lblLanguage.clickAndWait();
            System.out.println("Language was changed");
        } catch(NoSuchElementException ex) {
            System.out.println("Language was not changed");
        }
    }

    public void getMenu() {
        menu.navigate();
    }
}

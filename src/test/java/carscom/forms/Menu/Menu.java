package carscom.forms.Menu;

import framework.base.BaseForm;
import framework.base.elements.Label;

public class Menu extends BaseForm {

    private String lblMenuSectionLocator = "//a[@title='%s']";
    private String lblSubMenuLocator = "//a[contains(text(), \"Research Car Models\")]";

    public enum MenuSection {
        BYU("Buy"),
        SELL_AND_TRADE("Sell & Trade"),
        SERVICE_AND_REPAIR("Service & Repair"),
        VIDEOS_AND_REVIEWS("Videos & Review");

        private String name;

        MenuSection(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public enum SubMenu {

        RESEARCH_CAR_MODELS("Research Car Models");

        private String name;

        SubMenu(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public void getMenuSection(MenuSection menuSection, SubMenu subMenu) {
        Label lblMenuSection = new Label(String.format(lblMenuSectionLocator, menuSection.getName()));
        lblMenuSection.click();
        lblMenuSection.click();
        new Label(String.format(lblSubMenuLocator, subMenu.getName())).clickAndWait();

    }
}

package gamesite.forms.elements;

import framework.base.BaseForm;
import framework.base.elements.Label;

public class MenuElement extends BaseForm {
    private String lblMenuSection = "//span[@class=\"pulldown\"]//a[text()=\"%s\"]";
    private String lblSectionItem = "//a[@class='popup_menu_item'][contains(text(),\"%s\")]";

    public MenuElement(Label label) {
    }

    public void navigate() {
        Label lblGames = new Label(String.format(lblMenuSection, properties.getMenuGemesText()));
        lblGames.moveMouseToElement(lblGames.getElement());

        Label lblActions = new Label(String.format(lblSectionItem, properties.getActionGamesText()));
        lblActions.moveMouseToElement(lblActions.getElement());
        lblActions.clickAndWait();
    }
}
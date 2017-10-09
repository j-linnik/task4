package carscom.forms;

import framework.base.BaseForm;
import framework.base.elements.Label;

public class ResearchPage extends BaseForm{

    private Label lblCompareCars = new Label("//a[@data-link-name='compare-cars']");

    public void goToCompareCars() {
        lblCompareCars.click();
    }

}

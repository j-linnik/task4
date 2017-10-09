package carscom.forms;

import framework.base.BaseForm;
import framework.base.elements.Label;

public class CompareCarsWithOneCarInfoPage extends BaseForm{

    private Label lblAddCarToCompareList = new Label("//div[@id='icon-div']");

    public void clickAddCar() {
        lblAddCarToCompareList.click();
    }

}

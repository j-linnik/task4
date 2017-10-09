package carscom.forms;

import cucumber_pack.models.Car;
import framework.base.BaseForm;
import framework.base.elements.Button;
import framework.base.elements.ComboBox;

public class CompareSecondCarPage extends BaseForm{

    private ComboBox cmbMake = new ComboBox("//select[@id='make-dropdown']");
    private ComboBox cmbModel = new ComboBox("//select[@id='model-dropdown']");
    private ComboBox cmbYear = new ComboBox("//select[@id='year-dropdown']");
    private Button btnDone = new Button("//button[@class='modal-button']");

    public void insertDataForSecondCar(Car car) {
        cmbMake.selectByText(car.getMake());
        cmbModel.selectByText(car.getModel());
        cmbYear.selectByText(car.getYear());

        btnDone.click();
    }

}

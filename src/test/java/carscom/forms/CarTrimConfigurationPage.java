package carscom.forms;

import cucumber_pack.models.Car;
import framework.base.BaseForm;
import framework.base.elements.Label;

public class CarTrimConfigurationPage extends BaseForm{

    private Label lblEngine = new Label("//div[@class='cell cell-bg grow-2']");
    private Label lblTransmission = new Label("//div[@class='cell grow-2']");

    public String getEngine() {
        return lblEngine.getText();
    }

    public String getTransmission() {
        return lblTransmission.getText();
    }

    public Car setEngineAndTransmission(Car car) {
        car.setEngine(getEngine());
        car.setTransmission(getTransmission());
        return car;
    }
}

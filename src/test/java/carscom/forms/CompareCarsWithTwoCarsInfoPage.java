package carscom.forms;

import cucumber_pack.models.Car;
import framework.base.BaseForm;
import framework.base.elements.Label;
import org.testng.Assert;

public class CompareCarsWithTwoCarsInfoPage extends BaseForm {

    Label lblFirstCarEngine = new Label("//p[text()='Engine']/../following-sibling::div//span[@index='0']//p");
    Label lblSecondCarEngine = new Label("//p[text()='Engine']/../following-sibling::div//span[@index='1']//p");

    Label lblFirstCarTransmission = new Label("//p[text()='Transmission']/../following-sibling::div//span[@index='0']//p");
    Label getLblSecondCarTransmission = new Label("//p[text()='Transmission']/../following-sibling::div//span[@index='1']//p");


    public void compareCarsInfo(Car firstCar, Car secondCar) {
        Assert.assertEquals(lblFirstCarEngine.getText(), firstCar.getEngine() , "First car engine");
        Assert.assertEquals(lblFirstCarTransmission.getText(), firstCar.getTransmission() , "First car transmission");
        Assert.assertEquals(lblSecondCarEngine.getText(), secondCar.getEngine() , "Second car engine");
        Assert.assertEquals(getLblSecondCarTransmission.getText(), secondCar.getTransmission() , "Second car transmission");

    }
}

package carscom.forms;

import carscom.forms.Menu.Menu;
import cucumber_pack.models.Car;
import framework.base.BaseForm;
import framework.base.elements.Button;
import framework.base.elements.ComboBox;
import framework.base.elements.Label;

import static framework.base.elements.Label.getNewLabel;

public class HomePage extends BaseForm {
    private String lblSpecsAndReviewsLocator = ("//a[contains(text(), 'Read Specs & Reviews')]");
    private String cmbMakeLocator = "//option[text()='Select a Make']/..";
    private String cmbModelLocator = "//option[text()='Select a Model']/..";
    private String cmbYearLocator = "//option[text()='Select a Year']/..";
    private String btnSubmitLocator = "//div[@class='hsw-submit']";
    private Menu menu = new Menu();

    private String make;
    private String model;
    private String year;


    public void selectSpecsAndReviewsTab(){
        Label lblSpecsAndReviews = getNewLabel(lblSpecsAndReviewsLocator);
        lblSpecsAndReviews.click();
    }

    public void insertRandomValuesForCarSearch() {
        ComboBox cmbMake = getSlowLoadedComboBox(cmbMakeLocator);
        make = cmbMake.getRandomValue();

        ComboBox cmbModel = getSlowLoadedComboBox(cmbModelLocator);
        model = cmbModel.getRandomValue();

        ComboBox cmbYear = getSlowLoadedComboBox(cmbYearLocator);
        year = cmbYear.getRandomValue();

        Button btnSubmit = new Button(btnSubmitLocator);
        btnSubmit.submit();
    }

    public Car setCarModelConfiguration(Car car) {
        car.setMake(make);
        car.setModel(model);
        car.setYear(year);
        return car;
    }

    public ComboBox getSlowLoadedComboBox(String path) {
        ComboBox comboBox = new ComboBox(path);
        while(comboBox.getValuesAmount() <= 1) {
            comboBox = new ComboBox(cmbMakeLocator);
        }
        return comboBox;
    }

    public void navigateMenu(Menu.MenuSection menuSection, Menu.SubMenu subMenu) {
        menu.getMenuSection(menuSection, subMenu);
    }

}

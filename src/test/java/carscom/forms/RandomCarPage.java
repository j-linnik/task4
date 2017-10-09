package carscom.forms;

import cucumber_pack.models.Car;
import framework.base.BaseForm;
import framework.base.elements.Label;

public class RandomCarPage extends BaseForm {

    private String lblTrimComparisonLinkLocator = "//a[contains(text(), \"trim comparison\")]";
    private Label lblTrimComparisonLink;

    public RandomCarPage() {
        if(checkIsElementExist(lblTrimComparisonLinkLocator)) {
            System.out.println("Info: random car is OK");
            lblTrimComparisonLink = new Label(lblTrimComparisonLinkLocator);
            lblTrimComparisonLink.click();
        } else {
            System.out.println("Info: random car haven't Trim link, searching for another");
            HomePage homePage = new HomePage();
            homePage.goToUrl(properties.getMainPageUrl());
            homePage.selectSpecsAndReviewsTab();
            homePage.insertRandomValuesForCarSearch();
        }
    }

    public void checkTheCarNameMatching(Car car){

    }
}

package cucumber_pack.steps;

import carscom.forms.*;
import carscom.forms.Menu.Menu;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber_pack.models.Car;
import framework.base.BaseEntity;
import framework.driver.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class CarsComTestSteps extends BaseEntity {

    private WebDriver driver;
    private HomePage homePage;
    private Car carOne = new Car();
    private Car carTwo = new Car();

    @Before
    public void prepareSettings() {
        driver = BrowserFactory.getInstance().setDriver(properties.getBrowserName());
        homePage = new HomePage();
    }


    @When("^i navigate to main page 'cars-com'$")
    public void iNavigateToMainPageCarsCom() throws Throwable {
        homePage.goToUrl(properties.getMainPageUrl());
    }

    @Then("^i go to 'Read Specs & Reviews' tab$")
    public void iGoToTab() throws Throwable {
        homePage.selectSpecsAndReviewsTab();

    }

    @And("^i insert data to get random car and press 'search'$")
    public void iInsertDataForCarAndPress() throws Throwable {
        homePage.insertRandomValuesForCarSearch();
    }

    @And("^i record base configuration for first car$")
    public void iRecordBaseConfigurationForFirstCar() throws Throwable {
        carOne = homePage.setCarModelConfiguration(carOne);
    }

    @And("^i record base configuration for second car$")
    public void iRecordBaseConfigurationForSecondCar() throws Throwable {
        carTwo = homePage.setCarModelConfiguration(carTwo);
    }

    @Then("^i go to trim-section and press 'cars trim'$")
    public void iGoToAndPress() throws Throwable {
        RandomCarPage randomCarPage = new RandomCarPage();
    }

    @Then("^i record 'engine' and 'transmission' data of the first car$")
    public void iRecordAndDataOfFirstCar() throws Throwable {
        carOne = getCarTrimConfigPage().setEngineAndTransmission(carOne);
    }

    @Then("^i record 'engine' and 'transmission' data of the second car$")
    public void iRecordAndDataOfSecondCar() throws Throwable {
        carTwo = getCarTrimConfigPage().setEngineAndTransmission(carTwo);
    }

    @And("^i press 'buy' and 'Research New Car Models'$")
    public void iPressBuyAndResearchNewCarModels() throws Throwable {
        homePage.navigateMenu(Menu.MenuSection.BYU, Menu.SubMenu.RESEARCH_CAR_MODELS);
    }

    @And("^i press 'compare cars' button$")
    public void iPressButton() throws Throwable {
        ResearchPage rp = new ResearchPage();
        rp.goToCompareCars();
    }

    @Then("^i insert data of first car for comparing$")
    public void iInsertDataOfFirstCarForComparing() throws Throwable {
        CompareFirstCarPage compareFirstCarPage = new CompareFirstCarPage();
        compareFirstCarPage.insertDataForFirstCar(carOne);
    }

    @Then("^i press 'add one more comparing car' button$")
    public void iPressAddOneMoreComparingCarButton() throws Throwable {
        CompareCarsWithOneCarInfoPage firstCarPage = new CompareCarsWithOneCarInfoPage();
        firstCarPage.clickAddCar();
    }

    @And("^i insert data of second car for comparing$")
    public void iInsertDataOfSecondCarForComparing() throws Throwable {
        CompareSecondCarPage compareSecondCarPage = new CompareSecondCarPage();
        compareSecondCarPage.insertDataForSecondCar(carTwo);
        printCarsInfo();
    }

    @Then("^i check compare page for both cars$")
    public void iCheckComparePageForBothCars() throws Throwable {
        CompareCarsWithTwoCarsInfoPage compareBothCarsPage = new CompareCarsWithTwoCarsInfoPage();
        compareBothCarsPage.compareCarsInfo(carOne, carTwo);
    }

    @After
    public void tearDownTest() {
        driver.quit();
    }

    public CarTrimConfigurationPage getCarTrimConfigPage() {
        return new CarTrimConfigurationPage();
    }


    public void printCarsInfo() {
        System.out.println("|| Car ONE: "
                + carOne.getMake() + " ---- "
                + carOne.getModel() + " ---- "
                + carOne.getYear() + " ---- "
                + carOne.getEngine() + " ---- "
                + carOne.getTransmission() + " --||");

        System.out.println("|| Car TWO: "
                + carTwo.getMake() + " ---- "
                + carTwo.getModel() + " ---- "
                + carTwo.getYear() + " ---- "
                + carTwo.getEngine() + " ---- "
                + carTwo.getTransmission() + " --||");
    }
}

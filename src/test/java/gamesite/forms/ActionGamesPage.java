package gamesite.forms;

import framework.base.BaseForm;
import framework.base.elements.Label;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static framework.base.elements.Label.getNewLabel;

public class ActionGamesPage extends BaseForm {

    private Label lblDiscounts = new Label("//div[@id=\"tab_select_Discounts\"]");
    private String lblGamesListLocator = "//div[@id=\"tab_Discounts_content\"]//div[@class=\"discount_pct\"]";
    private String lblDiscountLocator = "(//div[@id=\"tab_Discounts_content\"]//div[@class=\"discount_pct\"])[%s]";
    private String lblPriceLocator = "//div[@class=\"tabarea\"]//div[contains(text(),\"%s\")]/following-sibling::div/div[@class=\"discount_final_price\"]";

    private String formAgeCheckPageLocator = "//form[@id=\"agecheck_form\"]";

    private List<Label> games = new ArrayList<>();

    private String discountAndPrice = "discount: %s, price: %s";
    private int discount;
    private int price;
    //pattern with numbers only
    private Pattern pattern = Pattern.compile("\\d+");

    public void getBiggestDiscountGame() {
        lblDiscounts.click();
        getGames();
        compareDiscounts();
        setDiscountAndPrice();
        Label lblPriceOfDiscountGame = getPriceElement();
        lblPriceOfDiscountGame.clickAndWait();
    }

    public void compareDiscounts() {

        int biggestDiscount = 0;
        for (int i = 1; i <= games.size(); i++) {
            String discountText = getNewLabel(String.format(lblDiscountLocator, i)).getText();
            Matcher matcher = pattern.matcher(discountText);
            if (matcher.find()) {
                int discountSize = Integer.valueOf(matcher.group());
                if (discountSize > biggestDiscount) {
                    biggestDiscount = discountSize;
                    discount = biggestDiscount;
                }
            }
            discount = biggestDiscount;
        }
    }

    public void setDiscountAndPrice() {
        Label lblPrice = getPriceElement();
        Matcher matcher = pattern.matcher(lblPrice.getText());
        if(matcher.find()) {
            price = Integer.valueOf(matcher.group());
        }
        discountAndPrice = String.format(discountAndPrice, discount, price);
        System.out.println(discountAndPrice + " in action games list");
    }

    public String getDiscountAndPrice() {
        return discountAndPrice;
    }

    public List<Label> getGames() {
        return games = getElementsToLabelList(lblGamesListLocator);
    }

    public Label getPriceElement() {
        return getNewLabel(String.format(lblPriceLocator, discount));
    }

    public boolean isReturnAgeCheckPage() {
        return confirmPageLoad(formAgeCheckPageLocator).size() > 0;
    }
}

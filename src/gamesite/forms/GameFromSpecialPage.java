import base.BaseForm;
import base.elements.Button;
import base.elements.Label;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameFromSpecialPage extends BaseForm{

    private String gameDiscountPriceF = "discount: %s, price: %s";

    private Label lblDiscount = new Label("//div[@class=\"discount_pct\"]");
    private Label lblPrice = new Label("//div[@class=\"discount_final_price\"]");
    private Button btnDownloadPage = new Button("//a[@class=\"header_installsteam_btn_content\"]");
    //pattern with numbers only
    private Pattern pattern = Pattern.compile("\\d+");

    public void checkGamePrice(String discountAndPrice) {
        String discount = getNumbersFromString(lblDiscount.getText());
        String price = getNumbersFromString(lblPrice.getText());
        String gameDiscountAndPrice = String.format(gameDiscountPriceF, discount, price);
        if(gameDiscountAndPrice.equals(discountAndPrice)) {
            System.out.println("Discount and price of the game is equals to requested.");
        } else {
            System.out.println("Discount and price of the game is NOT equals to requested.");
        }
        System.out.println(gameDiscountAndPrice + " IN Game Page");

        btnDownloadPage.click();
    }

    public String getNumbersFromString(String text){
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}

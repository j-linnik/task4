import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.BaseTest;

public class SteamTest extends BaseTest {

    @Test
    @Parameters("adult_age_year")
    public void test(String age) {
        MainPage mainPage = new MainPage();
        mainPage.checkLanguageSettings();
        mainPage.getMenu();

        ActionGamesPage actionGamesPage = new ActionGamesPage();
        actionGamesPage.getBiggestDiscountGame();

        if(actionGamesPage.isReturnAgeCheckPage()) {
            new AgeCheckPage(age);
        }

        GameFromSpecialPage gameFromSpecialPage = new GameFromSpecialPage();
        gameFromSpecialPage.checkGamePrice(actionGamesPage.getDiscountAndPrice());

//        DownloadPage downloadPage = new DownloadPage();
//        downloadPage.downloadFile();

//        AboutDownloadsPage adp = new AboutDownloadsPage();
//        adp.checkFileDownloadState();

    }
}

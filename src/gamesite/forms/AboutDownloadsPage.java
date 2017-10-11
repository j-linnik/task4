import base.BaseForm;
import base.elements.Label;

import java.io.File;

public class AboutDownloadsPage extends BaseForm{

    private String aboutDownloads = "about:downloads";
    private String lblFirefoxDownloadFileLocator = "//*[contains(@displayName,\"SteamSetup\")][@state=\"1\"]";
    private String filePath = "C:\\downloads\\SteamSetup.exe";
    private String browserType = properties.getBrowserName();

    public void checkFileDownloadState() {
        switch (browserType) {
            case "firefox" :
                checkDownloadsInFirefox();
                break;

            case "chrome" :
                checkDownloadsInChrome();
                break;
            default:
                break;

        }
    }

    public void checkDownloadsInFirefox() {
        goToUrl(aboutDownloads);
        Label e = new Label(lblFirefoxDownloadFileLocator);
        while (!e.getElement().getAttribute("state").equals("1")) {
            System.out.println("Downloading in progress...");
        }
        System.out.println("File have been downloaded");
        checkIfFileExist();
    }

    public void checkDownloadsInChrome() {

        //some sort of disaster

        System.out.println("File downloading checking in chrome is disabled!");

        //checkIfFileExist();
    }

    public void checkIfFileExist() {
        File steamSetup = new File(filePath);
        if(steamSetup.exists() && !steamSetup.isDirectory()) {
            System.out.println("You can find file here: " + filePath);
        }
    }
}

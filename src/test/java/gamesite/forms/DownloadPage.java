package gamesite.forms;

import framework.base.BaseForm;
import framework.base.elements.Button;

public class DownloadPage extends BaseForm{

    private Button btnDownload = new Button("//a[@id='about_install_steam_link']");

    public void downloadFile() {
        btnDownload.click();
    }
}

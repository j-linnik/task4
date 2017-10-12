package gamesite.forms;

import framework.base.BaseForm;
import framework.base.elements.Button;
import framework.base.elements.ComboBox;

public class AgeCheckPage extends BaseForm{

    private ComboBox cmbYear = new ComboBox("//select[@id='ageYear']");
    private Button btnSubmit = new Button("//form[@id='agecheck_form']//following-sibling::a");

    public AgeCheckPage(String age) {
            setYear(age);
    }

    private void setYear(String age) {
        cmbYear.selectByValue(age);
        btnSubmit.click();
    }
}

package UiWrappers.Portal.Recognisers;

import helpers.SeleniumHelper;
import org.openqa.selenium.By;

public class TechnicalErrorPage {
    private final SeleniumHelper mSeleniumHelper;

    public TechnicalErrorPage(SeleniumHelper pSeleniumHelper) {
        mSeleniumHelper = pSeleniumHelper;
    }

    public Boolean PassiveRecogniser() {
        return mSeleniumHelper.isElementVisible(By.xpath("//h1[text()='Technical Error']"));
    }
}

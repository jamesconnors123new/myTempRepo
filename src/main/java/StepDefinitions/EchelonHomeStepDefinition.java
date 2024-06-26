package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import activities.CommonControlDataDefns;
import helpers.CdlEchelonHelpers;
import helpers.SyncType;
import org.openqa.selenium.WebDriver;

import java.util.Map;




public class EchelonHomeStepDefinition extends CdlEchelonHelpers {
    private static WebDriver driver;

    public EchelonHomeStepDefinition(WebDriver driver, PageObjects.EchelonModel.Root echelonModelRoot) {
        super(driver, echelonModelRoot);
        this.driver = driver;
    }


    public void searchForClientPolicy(Map<String, String> searchCriteria) throws CustomE2eException {
        if(searchCriteria == null) {
            typeText(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().CLIENT_NUMBER(), "000", SyncType.PRESENT);
        } else if (isElementVisible(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().SEARCH_BUTTON())) {
            for (Map.Entry<String, String> entry : searchCriteria.entrySet()) {
                String key = entry.getKey();
                String value = String.valueOf(entry.getValue());
                switch (key) {
                    case CommonControlDataDefns.POLICY_NUMBER:
                        typeText(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().POLICY_NUMBER(), value, SyncType.PRESENT);
                        break;
                    case CommonControlDataDefns.FIRST_NAME:
                        typeText(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().FORENAME(), value, SyncType.PRESENT);
                        break;
                    case CommonControlDataDefns.LAST_NAME:
                        typeText(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().SURNAME(), value, SyncType.PRESENT);
                        break;
                    case CommonControlDataDefns.POST_CODE:
                        typeText(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().POSTCODE(), value, SyncType.PRESENT);
                        break;
                    case CommonControlDataDefns.CLIENT_NUMBER:
                        typeText(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().CLIENT_NUMBER(), value, SyncType.PRESENT);
                        break;
                    case CommonControlDataDefns.WEB_REF:
                        typeText(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().WEB_REFERENCE_NUMBER(), value,
                            SyncType.PRESENT);
                        break;
                    case CommonControlDataDefns.DATE_OF_BIRTH:
                        typeText(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().DATE_OF_BIRTH(), value, SyncType.PRESENT);
                        break;
                    case CommonControlDataDefns.EMAIL_ADDRESS:
                        typeText(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().EMAIL_ADDRESS(), value, SyncType.PRESENT);
                        break;
                    default:
                }
            }
        }
        clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().SEARCH_BUTTON(), SyncType.CLICKABLE);
        waitForPageLoad();
    }

    public void signOutEchelonApplication() throws CustomE2eException {
        waitForElement(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().ECHELON_LOGOUT_BUTTON(), SyncType.CLICKABLE);
        smartClickElement(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().ECHELON_LOGOUT_BUTTON(),
            this.pageObjectOfEchelon.getEchelonLoginLocatorModel().EMAIL_INPUT(), "Failed to click" +
            ".");
    }

}

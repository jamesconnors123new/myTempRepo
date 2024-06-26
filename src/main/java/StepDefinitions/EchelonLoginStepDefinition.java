package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import UiWrappers.I_ActionReturnT;
import activities.CommonControlDataDefns;
import helpers.CdlEchelonHelpers;
import helpers.SyncType;
import org.openqa.selenium.WebDriver;

import java.util.Map;



public class EchelonLoginStepDefinition extends CdlEchelonHelpers {

    public EchelonLoginStepDefinition(WebDriver driver, PageObjects.EchelonModel.Root echelonModelRoot) {
        super(driver, echelonModelRoot);
//        this.driver = driver;
    }


    public boolean loginToEchelon(Map<String, Object> credentials, String url,
                               I_ActionReturnT<Boolean> pRespondToAnomally, I_ActionReturnT<Boolean> pPrepareForRetry) throws CustomE2eException {


        String userName = (String) credentials.get(CommonControlDataDefns.EMAIL);
        String password = (String) credentials.get(CommonControlDataDefns.PASSWORD);

        int retryLoop = 5;
            typeText(this.pageObjectOfEchelon.getEchelonLoginLocatorModel().EMAIL_INPUT(),
                userName, SyncType.CLICKABLE, "Email entry failed");
            typeText(this.pageObjectOfEchelon.getEchelonLoginLocatorModel().PASSWORD_INPUT(),
                password, SyncType.CLICKABLE, "Password failed");
            waitForElement(this.pageObjectOfEchelon.getEchelonLoginLocatorModel().LOG_IN_BTN(),
                SyncType.CLICKABLE);
            clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonLoginLocatorModel().LOG_IN_BTN(),
                SyncType.CLICKABLE);
            //waitForSpinnerToDisappear(); NAH - DO NOT WAIT FOR TRANSITORY ITEMS, WAIT FOR WHAT WE NEED NEXT
        do {
            if (isElementVisible(this.pageObjectOfEchelon.getEchelonLoginLocatorModel().POLICY_NUMBER())) {
                break;
            } else if (isElementVisible(this.pageObjectOfEchelon.getEchelonLoginLocatorModel().UNSUCCESSFUL_LOGIN_INDICATOR())) {
                throw new CustomE2eException(getText(this.pageObjectOfEchelon.getEchelonLoginLocatorModel().UNSUCCESSFUL_LOGIN_INDICATOR()));
            } else {
                retryLoop--;
                if (retryLoop == 0) {
                    throw new CustomE2eException("Not successful login");
                }
            }
        } while (retryLoop > 0);
        return true;
    }

}



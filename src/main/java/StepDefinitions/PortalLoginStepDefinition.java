package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import Generic.customExceptions.OpImplMalfunction_MethodCalledWithInvalidParameters;
import UiWrappers.I_ActionReturnT;
import activities.CommonControlDataDefns;
import helpers.AgeasDigitalReactPortalHelpers;
import helpers.SyncType;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class PortalLoginStepDefinition extends AgeasDigitalReactPortalHelpers {

    public final String GENERAL_LOGIN_FAILURE = "loginPortal failed";
    public PortalLoginStepDefinition(WebDriver driver,
                                     PageObjects.PortalModel.Root pageObjectOfPortal) {
        super(driver, pageObjectOfPortal);
    }

    public boolean loginPortal2(Map<String, Object> credentials, String url, I_ActionReturnT<Boolean> pRespondToAnomally, I_ActionReturnT<Boolean> pPrepareForRetry) throws CustomE2eException {
        if(credentials==null||url==null||pPrepareForRetry==null) {
            throw new OpImplMalfunction_MethodCalledWithInvalidParameters("loginPortal2",credentials,url,pPrepareForRetry);
        }
        var userName = (String) credentials.getOrDefault(CommonControlDataDefns.EMAIL,null);
        var password = (String) credentials.getOrDefault(CommonControlDataDefns.PASSWORD,null);
        if(StringUtils.isBlank(userName)||StringUtils.isBlank(password)) {
            throw new OpImplMalfunction_MethodCalledWithInvalidParameters("loginPortal2 - credentials",userName,password);
        }
        int vRemainingAttempts = 5;
        do {
            typeText(this.pageObjectOfPortal.getPortalLoginLocatorModel().EMAIL_INPUT(), userName,
                SyncType.CLICKABLE,
                GENERAL_LOGIN_FAILURE);
            typeText(this.pageObjectOfPortal.getPortalLoginLocatorModel().PASSWORD_INPUT(),
                password, SyncType.CLICKABLE, GENERAL_LOGIN_FAILURE);
            waitForElement(this.pageObjectOfPortal.getPortalLoginLocatorModel().LOG_IN_BTN(),
                SyncType.CLICKABLE);
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalLoginLocatorModel().LOG_IN_BTN(),
                SyncType.CLICKABLE);
            int vInnerRetries = 10;
            do {
                waitForElement2(this.pageObjectOfPortal.getDashboardLocatorModel().WELCOME_BANNER(), SyncType.PRESENT, 2000L);
                if (isElementVisible(this.pageObjectOfPortal.getDashboardLocatorModel().WELCOME_BANNER())) {
                    return true;
                } else if (isElementVisible(this.pageObjectOfPortal.getPortalLoginLocatorModel().UNSUCCESSFUL_LOGIN_INDICATOR())) {
                    throw new CustomE2eException(getText(this.pageObjectOfPortal.getPortalLoginLocatorModel().UNSUCCESSFUL_LOGIN_INDICATOR()));
                } else {
                    if(!pRespondToAnomally.Action()) {
                        throw new CustomE2eException(GENERAL_LOGIN_FAILURE);
                    }
                }
            } while(--vInnerRetries >0);
            vRemainingAttempts--;
            if (vRemainingAttempts == 0) {
                throw new CustomE2eException(GENERAL_LOGIN_FAILURE);
            }
            if (!pPrepareForRetry.Action()) {
                throw new CustomE2eException(GENERAL_LOGIN_FAILURE + " Prepare for retry returned false");
            }
        } while (vRemainingAttempts > 0);
        return false;
    }
}

package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import PageObjects.EisModel.Root;
import UiWrappers.I_ActionReturnT;
import activities.CommonControlDataDefns;
import helpers.CdlEisHelpers;
import helpers.SyncType;
import org.openqa.selenium.WebDriver;

import java.util.Map;


public class EisLoginStepDefinition extends CdlEisHelpers {

  EisGeneralStepDefinitions eisGeneralStepDefinitions;

  public EisLoginStepDefinition(WebDriver pDriver, Root eisModelRoot) {
    super(pDriver, eisModelRoot);
    eisGeneralStepDefinitions = new EisGeneralStepDefinitions(pDriver, pageObjectOfEis);
  }


  public boolean loginToEis(Map<String, Object> credentials, String url,
                            I_ActionReturnT<Boolean> pRespondToAnomally,
                            I_ActionReturnT<Boolean> pPrepareForRetry) throws CustomE2eException {
    String userName = (String) credentials.get(CommonControlDataDefns.EMAIL);
    String password = (String) credentials.get(CommonControlDataDefns.PASSWORD);

    int retryLoop = 5;
    typeText(this.pageObjectOfEis.getEisLocatorModel().USER_ID(), userName, SyncType.CLICKABLE,
        "loginToEis failed");
    typeText(this.pageObjectOfEis.getEisLocatorModel().PASSWORD_INPUT(), password,
        SyncType.CLICKABLE, "loginToEis failed");
//    waitForElement2(this.pageObjectOfEis.getEisLocatorModel().LOG_IN_BTN(), SyncType.CLICKABLE,
//        eisGeneralStepDefinitions.waitDuration);

//    RetryOnClickInterceptedException(10,
//        () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisLocatorModel().LOG_IN_BTN(),
//            SyncType.CLICKABLE));
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisLocatorModel().LOG_IN_BTN(),
            SyncType.CLICKABLE);

//    waitForElement2(this.pageObjectOfEis.getEisLocatorModel().CUSTOMER_DETAILS(), SyncType.CLICKABLE,
//        eisGeneralStepDefinitions.waitDuration);
    do {
      if (isElementVisible(this.pageObjectOfEis.getEisLocatorModel().CUSTOMER_DETAILS())) {
        break;
      } else if (isElementVisible(this.pageObjectOfEis.getEisLocatorModel().UNSUCCESSFUL_LOGIN_INDICATOR())) {
        throw new CustomE2eException(getText(this.pageObjectOfEis.getEisLocatorModel().UNSUCCESSFUL_LOGIN_INDICATOR()));
      }
      else {
        retryLoop--;
        if (retryLoop == 0) {
          throw new CustomE2eException("Not successful login");
        }
      }
    } while (retryLoop > 0);
    return true;
  }

  public void signOutEisApplication() throws CustomE2eException {
    if (isElementVisible(this.pageObjectOfEis.getEisLocatorModel().EIS_PROFILE_BUTTON())) {
      scrollIntoView(this.pageObjectOfEis.getEisLocatorModel().EIS_PROFILE_BUTTON());
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisLocatorModel().EIS_PROFILE_BUTTON(),
          SyncType.CLICKABLE);
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisLocatorModel().EIS_LOGOUT_BUTTON(),
          SyncType.CLICKABLE);
    } else if (isElementVisible(this.pageObjectOfEis.getEisLocatorModel().LOGOUT_BUTTON())) {
      waitForElement2(this.pageObjectOfEis.getEisLocatorModel().LOGOUT_BUTTON(),
          SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisLocatorModel().LOGOUT_BUTTON(), SyncType.CLICKABLE);
      waitForElement2(this.pageObjectOfEis.getEisLocatorModel().LOGOUT_CONFIRMATION(),
          SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisLocatorModel().LOGOUT_CONFIRMATION(),
          SyncType.CLICKABLE);
      waitForElement2(this.pageObjectOfEis.getEisLocatorModel().LOG_IN_BTN(), SyncType.CLICKABLE,
          eisGeneralStepDefinitions.waitDuration);
    }
  }

  public boolean loginToEisCore(Map<String, Object> credentials) throws CustomE2eException {
    String userName = (String) credentials.get(CommonControlDataDefns.EIS_CORE_USERNAME);
    String password = (String) credentials.get(CommonControlDataDefns.EIS_CORE_PASSWORD);
    int retryLoop = 5;
    typeText(this.pageObjectOfEis.getEisLocatorModel().EIS_CORE_USERNAME(), userName,
        SyncType.CLICKABLE, "loginToEisCore " + "failed");
    typeText(this.pageObjectOfEis.getEisLocatorModel().EIS_CORE_PASSWORD(), password,
        SyncType.CLICKABLE, "loginToEisCore failed");
    waitForElement(this.pageObjectOfEis.getEisLocatorModel().EIS_CORE_LOGIN_BUTTON(),
        SyncType.CLICKABLE);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisLocatorModel().EIS_CORE_LOGIN_BUTTON(),
        SyncType.CLICKABLE);
    do {
      if (isElementVisible(this.pageObjectOfEis.getEisLocatorModel().EIS_CORE_CUSTOMER_DETAILS())) {
        break;
      } else if (isElementVisible(this.pageObjectOfEis.getEisLocatorModel().EIS_CORE_UNSUCCESSFUL_LOGIN_INDICATOR())) {
        throw new CustomE2eException(getText(this.pageObjectOfEis.getEisLocatorModel().EIS_CORE_UNSUCCESSFUL_LOGIN_INDICATOR()));
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



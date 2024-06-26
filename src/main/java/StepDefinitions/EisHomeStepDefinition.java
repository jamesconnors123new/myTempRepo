package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import activities.CommonControlDataDefns;
import helpers.CdlEisHelpers;
import helpers.SyncType;
import org.openqa.selenium.WebDriver;

import java.util.Map;


public class EisHomeStepDefinition extends CdlEisHelpers {
  EisGeneralStepDefinitions eisGeneralStepDefinitions;

  public EisHomeStepDefinition(WebDriver driver, PageObjects.EisModel.Root pageObjectOfEis) {
    super(driver, pageObjectOfEis);
    eisGeneralStepDefinitions = new EisGeneralStepDefinitions(driver, pageObjectOfEis);
  }


  public void clickOnAddNewCustomerButton() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisHomeLocatorModel().ADD_NEW_CLIENT(),
        SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    RetryOnClickInterceptedException(10,
        () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisHomeLocatorModel().ADD_NEW_CLIENT(),
            SyncType.CLICKABLE));
  }

  public void searchEisClient(Map<String, String> searchCriteria) throws CustomE2eException {
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisHomeLocatorModel().SEARCH_BUTTON(), SyncType.CLICKABLE);
    for (Map.Entry<String, String> entry : searchCriteria.entrySet()) {
      String key = entry.getKey();
      String value = String.valueOf(entry.getValue());
      switch (key) {
        case CommonControlDataDefns.POLICY_NUMBER:
          //DO NOT DELETE.- As of now this feature is not working in UI.
          // clickElement(this.pageObjectOfEis.getEisHomeLocatorModel().SWITCH_SEARCH_CRITERIA(),
          // SyncType.CLICKABLE);
          // clickElement(this.pageObjectOfEis.getEisHomeLocatorModel().SEARCH_BY_POLICIES(),
          // SyncType.CLICKABLE);
          break;
        default:
      }

      for (int attempt = 0; attempt <= 3; attempt++) {
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisHomeLocatorModel().SEARCH_FIELD(),
            SyncType.PRESENT);
        typeText(this.pageObjectOfEis.getEisHomeLocatorModel().SEARCH_FIELD(), value,
            SyncType.PRESENT);
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisHomeLocatorModel().SEARCH_FIELD(),
            SyncType.PRESENT);
        if (isElementVisible(this.pageObjectOfEis.getEisHomeLocatorModel().SUGGESTION_LIST())) {
          clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisHomeLocatorModel().SUGGESTION_LIST(),
              SyncType.CLICKABLE);
          break;
        } else if (isElementVisible(this.pageObjectOfEis.getEisHomeLocatorModel().VIEW_ALL_MATCHING())) {
          clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisHomeLocatorModel().VIEW_ALL_MATCHING(),
              SyncType.CLICKABLE);
        } else if (attempt == 3) {
          throw new CustomE2eException("Customer/Policy not found.");
        }
      }
      break;
    }
  }

  public void selectPolicyId(String policyId) throws CustomE2eException {
    waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisClientPortfolioLocatorModel().POLICY_ID(), policyId), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisClientPortfolioLocatorModel().POLICY_ID(), policyId), SyncType.CLICKABLE);
  }
}

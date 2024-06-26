package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import activities.CommonControlDataDefns;
import helpers.CdlEisHelpers;
import helpers.SyncType;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class EisClientPortfolioStepDefinition extends CdlEisHelpers {

  EisGeneralStepDefinitions eisGeneralStepDefinitions;
  public EisClientPortfolioStepDefinition(WebDriver pDriver, PageObjects.EisModel.Root pageObjectOfEis) {
    super(pDriver, pageObjectOfEis);
    eisGeneralStepDefinitions = new EisGeneralStepDefinitions(pDriver, pageObjectOfEis);
  }

  public void clickOnCreateQuoteButton() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisClientPortfolioLocatorModel().CREATE_QUOTE(),
        SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
   RetryOnStaleElementException(5,
       ()-> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisClientPortfolioLocatorModel().CREATE_QUOTE(),
        SyncType.CLICKABLE), "Click on create quote button.");
   refreshPage();
   waitForPageLoad();
  }

  public void loginQuotePortal(Map<String, Object> credentials) throws CustomE2eException {
    String userName = (String) credentials.get(CommonControlDataDefns.EMAIL);
    String password = (String) credentials.get(CommonControlDataDefns.PASSWORD);
    waitForPageLoad();
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().USER_NAME(),
        SyncType.VISIBLE, eisGeneralStepDefinitions.waitDuration);
    typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().USER_NAME(), userName,
        SyncType.VISIBLE);
    typeText( this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PASSWORD(), password, SyncType.VISIBLE);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SUBMIT_BUTTON(),
        SyncType.VISIBLE);
  }

}

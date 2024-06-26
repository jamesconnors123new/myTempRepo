package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import helpers.AgeasDigitalReactPortalHelpers;
import helpers.SyncType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class RetrieveQuotePortalUIStepDefinition extends AgeasDigitalReactPortalHelpers {

  QnBuyPortalQuotesCreationStepDefinition qnBuyPortalQuotesStepDefinition;
  PortalGeneralStepDefinitions portalGeneralStepDefinitions;

  public RetrieveQuotePortalUIStepDefinition(WebDriver driver,
                                             PageObjects.PortalModel.Root pageObjectOfPortal) {
    super(driver, pageObjectOfPortal);
    qnBuyPortalQuotesStepDefinition = new QnBuyPortalQuotesCreationStepDefinition(driver, pageObjectOfPortal);
    portalGeneralStepDefinitions = new PortalGeneralStepDefinitions(driver, pageObjectOfPortal);
  }

  public void retrieveHomeQuote(String DOB, String postcode, String quoteRef) throws CustomE2eException {
    var DateOfBirth = DOB.split("/");
    waitForPageLoad();
    waitForElement2(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().QUOTE_REFERENCE_INPUT(),
            SyncType.CLICKABLE, waitDuration);
    typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().QUOTE_REFERENCE_INPUT(), quoteRef, SyncType.CLICKABLE);
    typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().YOUR_POSTCODE_INPUT(), postcode, SyncType.CLICKABLE);
    typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().YOUR_DOB_DAY(), DateOfBirth[0], SyncType.CLICKABLE);
    typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().YOUR_DOB_MONTH(), DateOfBirth[1], SyncType.CLICKABLE);
    typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().YOUR_DOB_YEAR(), DateOfBirth[2], SyncType.CLICKABLE);
    clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().RETRIEVE_QUOTE_BTN(), SyncType.CLICKABLE);
  }

  public void verifyHomeQuoteRetrieved(String DOB, String postcode, String quoteRef) throws CustomE2eException {
    var DateOfBirth = DOB.split("/");
    waitForPageLoad();
    waitForElement2(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().QUOTE_REFERENCE_TEXT(), SyncType.VISIBLE, waitDuration);
    String quoteRefRetrieved = getText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().QUOTE_REFERENCE_TEXT());
    Assert.assertEquals(quoteRef, quoteRefRetrieved, "Quote Ref does not match");
    qnBuyPortalQuotesStepDefinition.navigateToPreviousPageOnQnB();
    String day = getAttribute(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().YOUR_DOB_DAY(), "value", "value not found");
    Assert.assertEquals(day, DateOfBirth[0], "DOB Day does not match");
    String month = getAttribute(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().YOUR_DOB_MONTH(), "value", "value not found");
    Assert.assertEquals(month, DateOfBirth[1], "DOB Month does not match");
    String year = getAttribute(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().YOUR_DOB_YEAR(), "value", "value not found");
    Assert.assertEquals(year, DateOfBirth[2], "DOB Year does not match");
    qnBuyPortalQuotesStepDefinition.navigateToPreviousPageOnQnB();
    String postcodeRetrieved = getText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PROPERTY_POSTCODE_EDIT()).trim();
    Assert.assertEquals(postcode, postcodeRetrieved, "Postcode does not match");
    portalGeneralStepDefinitions.continueButton();
    qnBuyPortalQuotesStepDefinition.agreedAndProceedToQuote();
    waitForPageLoad();
    waitForElement2(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().QUOTE_REFERENCE_TEXT(), SyncType.VISIBLE, waitDuration);
  }

  /*public void setEnhancePolicyCover() throws CustomE2eException {
    waitForPageLoad();
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().LEGAL_COST(), "N"), SyncType.CLICKABLE);
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOME_EMERGENCY(), "N"), SyncType.CLICKABLE);
    //clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().EXCESS_PROTECTION(), "N"), SyncType.CLICKABLE);
  }*/
}

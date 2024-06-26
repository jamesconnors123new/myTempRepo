package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import activities.PolicyCreationOnEchelonUI;
import helpers.CdlEchelonHelpers;
import helpers.CommonHelper;
import helpers.SelectOptions;
import helpers.SyncType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

public class EchelonPolicyCreationStepDefinition extends CdlEchelonHelpers {
  private final long waitDuration = 120000L;
  private final helpers.CommonHelper CommonHelper;

  public EchelonPolicyCreationStepDefinition(WebDriver driver,
                                             PageObjects.EchelonModel.Root echelonModelRoot) {
    super(driver, echelonModelRoot);
    this.CommonHelper = new CommonHelper(driver);
  }

  public void clickViewPolicyReferenceDetails(String quoteReference) throws CustomE2eException {
    var numberOfPages =
        getElementsMatchingToLocator(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().PAGE_INDEX());
    if (numberOfPages.size() > 0) {
      redirectToLastPage();
      for (var page : numberOfPages) {
        var recordFound = selectRecordOfQuotation(quoteReference);
        if (!recordFound) {
          clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().PREVIOUS_PAGE_POLICIES(), SyncType.CLICKABLE);
          waitForPageLoad();
        } else {
          break;
        }
      }
    } else {
      selectRecordOfQuotation(quoteReference);
    }
  }

  public Boolean selectRecordOfQuotation(String quoteReference) throws CustomE2eException {
    refreshPage();
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().POLICIES_TABLE(), SyncType.VISIBLE, waitDuration);
    List<WebElement> rows =
        getElementsMatchingToLocator(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().POLICIES_TABLE());
    for (int numberOfRows = rows.size(); numberOfRows >= 1; numberOfRows--) {
      int finalNumberOfRows = numberOfRows;
      waitForElement2(xpathBuilder(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().POLICY_QUOTE_REF(), String.valueOf(finalNumberOfRows)), SyncType.CLICKABLE, waitDuration);
      var actualQuoteRef = RetryOnException("GettingQuoteRef", CustomE2eException.class, 5, 300,
          () -> getText(xpathBuilder(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().POLICY_QUOTE_REF(), String.valueOf(finalNumberOfRows))));
      if (actualQuoteRef.equalsIgnoreCase(quoteReference)) {
        waitForElement2(xpathBuilder(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().VIEW_POLICY_DETAILS_BUTTON(), String.valueOf(numberOfRows)), SyncType.CLICKABLE, waitDuration);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().VIEW_POLICY_DETAILS_BUTTON(), String.valueOf(numberOfRows)), SyncType.CLICKABLE);
        waitForPageLoad();
        return true;
      }
    }
    return false;
  }

  public void redirectToLastPage() throws CustomE2eException {
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().LAST_PAGE_POLICIES(), SyncType.CLICKABLE);
    waitForPageLoad();
  }

  public void clickOnWrapup() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().POLICY_ACTIONS(), SyncType.VISIBLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().POLICY_ACTIONS(), SyncType.CLICKABLE);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().WRAP_UP_POLICY(), SyncType.CLICKABLE);
    if (isElementVisible(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BACK_DATED_POP_UP()) && getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BACK_DATED_POP_UP()).equalsIgnoreCase("Unable to Wrap Up")) {
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().ACCEPT_BACK_DATED_POP_UP(), SyncType.CLICKABLE);
      throw new CustomE2eException("This cover cannot be backdated. Please re-quote.");
    }
  }

  public void referralConfirmation() throws CustomE2eException {
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CONFIRMATION_RESOLVED(), SyncType.CLICKABLE);
  }

  public void navigateToNextPage() throws CustomE2eException {
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().NEXT_PAGE()
        , SyncType.CLICKABLE);
  }

  public void payByCard() throws CustomE2eException {

  }

  public boolean paymentProcess(String storeCardFlag) throws CustomE2eException {
    if (storeCardFlag.equalsIgnoreCase(PolicyCreationOnEchelonUI.NO_PAYMENT)) {
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CONTINUE_WRAPUP_BUTTON(), SyncType.CLICKABLE);
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().CONTINUE_WRAP_UP_WITHOUT_PAYMENT(), SyncType.CLICKABLE);
      RetryOnException("getCompleteWrapUpWithoutPayment", CustomE2eException.class, 500L, 10,
          () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().COMPLETE_WRAPUP_BUTTON(), SyncType.CLICKABLE));
//      return getPaymentStatus();
    } else  if (storeCardFlag.equalsIgnoreCase(PolicyCreationOnEchelonUI.STORED_CARD)) {
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().PAY_BY_CARD(), SyncType.CLICKABLE);
      if (!isElementVisible(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().SELECT_CREDIT_CARD())) {
        throw new CustomE2eException("Stored card not found.");
      } else {
        var expiryMonth =
            Integer.parseInt(getText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PREV_CARD_EXPIRY_DATE()).split("/")[0]);
        var expiryYear = Integer.parseInt(getText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PREV_CARD_EXPIRY_DATE()).split("/")[1]);

        //Year or if Year is same the it wil check for Month(OR condition) is smaller than
        // expected..
        if(expiryYear < Integer.parseInt(String.format("%ty", Year.now())) || expiryYear == Integer.parseInt(String.format("%ty", Year.now())) && expiryMonth< Integer.parseInt(String.format("%02d" , LocalDate.now().getMonth().getValue()))){
          throw new CustomE2eException("Stored card is expired.");
        }
      }
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().SELECT_CREDIT_CARD(), SyncType.CLICKABLE);
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().MANUAL_PAYMENT(), "Yes", SelectOptions.TEXT);
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PERMISSION_TO_STORED_CARD_DETAILS(), "Yes", SelectOptions.TEXT);
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().PAYMENT_NEXT_PAGE(), SyncType.CLICKABLE);
      waitForElement2(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PAYMENT_SUMMARY(), SyncType.CLICKABLE, waitDuration);
    } else if (storeCardFlag.equalsIgnoreCase(PolicyCreationOnEchelonUI.NEW_CARD)) {
      throw new CustomE2eException("This feature is not built yet");
    }
    documentCreationPage();
    var paymentSummary = getPaymentStatus();
    if (!paymentSummary) {
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CONTINUE_WRAPUP_BUTTON(), SyncType.CLICKABLE);
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().CONTINUE_WRAP_UP_WITHOUT_PAYMENT(), SyncType.CLICKABLE);
      RetryOnException("getCompleteWrapUpWithoutPayment", CustomE2eException.class, 500L, 10,
          () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().COMPLETE_WRAPUP_BUTTON(), SyncType.CLICKABLE));
      return false;
    } else {
      return true;
    }

  }

  private boolean getPaymentStatus() throws CustomE2eException {
    waitForPageLoad();
    waitForElement2(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PAYMENT_STATUS(), SyncType.VISIBLE, waitDuration);
    if (isElementVisible(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PAYMENT_STATUS())) {
      return true;
    } else if(isElementVisible(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PAYMENT_SUMMARY())) {
      var paymentSummary =
          getText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PAYMENT_SUMMARY());
      if (paymentSummary.contains("An error has occurred when processing this payment.")) {
        return false;
      } else {
        clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CONTINUE_WRAPUP_BUTTON(), SyncType.CLICKABLE);
        RetryOnException("getCompleteWrapUpWithoutPayment", CustomE2eException.class, 500L, 10,
            () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().COMPLETE_WRAPUP_BUTTON(), SyncType.CLICKABLE));
        documentCreationPage();
        return true;
      }
    }
      return false;
  }

  public void documentCreationPage() throws CustomE2eException {
    if (isElementVisible(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CORRESPONDENCE_TYPE())) {
      selectDropdown(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CORRESPONDENCE_TYPE(), "ADS7DCA [ADDACS 7DC No Balance (AGEAS)]", SelectOptions.TEXT);
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CREATE_DOCUMENT(), SyncType.CLICKABLE);
    }
  }


  public String getPolicyId() throws CustomE2eException {
    waitForPageLoad();
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().POLICY_ID(), SyncType.VISIBLE, waitDuration);
    return getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().POLICY_ID());
  }
}

package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import PageObjects.EisModel.Root;
import activities.PolicyCreationOnEis;
import helpers.CdlEisHelpers;
import helpers.CommonHelper;
import helpers.SelectOptions;
import helpers.SyncType;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class EisPolicyCreationStepDefinition extends CdlEisHelpers {

  EisGeneralStepDefinitions eisGeneralStepDefinitions;
  EisHomeQuoteCreationStepDefinition eisHomeQuoteCreationStepDefinition;

  public EisPolicyCreationStepDefinition(WebDriver pDriver, Root pageObjectOfEis) {
    super(pDriver, pageObjectOfEis);
    eisGeneralStepDefinitions = new EisGeneralStepDefinitions(pDriver, pageObjectOfEis);
    eisHomeQuoteCreationStepDefinition = new EisHomeQuoteCreationStepDefinition(pDriver, pageObjectOfEis);

  }

  public void purchaseQuote() throws CustomE2eException {
    waitForPageLoad();
//    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PURCHASE_POLICY(),
//        SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    if(!isElementVisible(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PURCHASE_POLICY())) {
      eisGeneralStepDefinitions.navigateToNextPage();
    }
    scrollIntoView(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PURCHASE_POLICY());
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PURCHASE_POLICY(),
        SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PURCHASE_POLICY(),
        SyncType.CLICKABLE);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CONFIRMATION_PURCHASE_POLICY(), SyncType.CLICKABLE);

    // James added 03/06/2024
    overrideAllIfErrorsFormDisplayed();
  }

  public void paymentProcess(String paymentMethod, Map<String, Object> paymentData) throws CustomE2eException {
    if (paymentMethod.equalsIgnoreCase(EisGeneralStepDefinitions.CREDIT_CARD)) {
      creditCardPayment();
    } else if (paymentMethod.equalsIgnoreCase(EisGeneralStepDefinitions.CHEQUE)) {
      chequePayment(paymentData);
    } else if (paymentMethod.equalsIgnoreCase(EisGeneralStepDefinitions.DIRECT_DEBIT)) {
      directDebit(paymentData);
    }
  }

  public String policyNumber() throws CustomE2eException {
    String policyNum =
        getText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().POLICY_NUMBER_VAR());
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().POLICY_NUMBER_VAR(),
        SyncType.CLICKABLE);
    return policyNum;
  }

  private void creditCardPayment() throws CustomE2eException {
    refreshPage();
    waitForPageLoad();
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CREDIT_CARD_AMOUNT(),
        SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    if (isElementVisible(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CREDIT_CARD_AMOUNT())) {
      //Existing saved card details
      scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().POLICY_AMOUNT_REQUIRED_FIELD());
      var amountToBePaid =
          getAttribute(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().POLICY_AMOUNT_REQUIRED_FIELD(), "value", "Policy payment amount not found.");
      var visaCardInputField =
          getAttribute(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CREDIT_CARD_AMOUNT(), "value", "Policy payment amount not found.");
      if (visaCardInputField.isEmpty()) {
        clearAmountField();
        RetryOnStaleElementException(3,
            () -> typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CREDIT_CARD_AMOUNT(), amountToBePaid, SyncType.CLICKABLE, true), "Amount to pay");
      }
    }

    // James - Added step to select 'Does this card belong to the policyholder?' answer
    if(isElementVisible(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_BELONGS_TO_POLICY_HOLDER(), CommonHelper.convertBooleanIntoString(true)))){
      clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_BELONGS_TO_POLICY_HOLDER(), CommonHelper.convertBooleanIntoString(true)), SyncType.CLICKABLE);
    }

    if(isElementVisible(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PERMISSION_TO_STORE_CARD(), CommonHelper.convertBooleanIntoString(true)))) {
      clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PERMISSION_TO_STORE_CARD(), CommonHelper.convertBooleanIntoString(true)), SyncType.CLICKABLE);
    }
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().FINISH_PAYMENT(),
        SyncType.CLICKABLE);
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CONFIRM_PAYMENT(),
        SyncType.CLICKABLE, PolicyCreationOnEis.waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CONFIRM_PAYMENT(),
        SyncType.CLICKABLE);


//    if(waitForElement2(this.pageObjectOfEis.getEisPaymentLocatorModel().CLOSE_WORLDPAY_POPUP(),
//            SyncType.CLICKABLE, PolicyCreationOnEis.waitDuration)) {
//      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisPaymentLocatorModel().CLOSE_WORLDPAY_POPUP(),
//              SyncType.CLICKABLE);
//    }
    if(isElementVisible(this.pageObjectOfEis.getEisPaymentLocatorModel().CLOSE_WORLDPAY_POPUP())) {
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisPaymentLocatorModel().CLOSE_WORLDPAY_POPUP(),
              SyncType.CLICKABLE);
    }
  }

//  public boolean addCreditCardDetails(Map<String, Object> paymentData) throws CustomE2eException {
//    if (!isElementVisible(this.pageObjectOfEis.getEisPaymentLocatorModel().CREDIT_CARD_PAYMENT_METHOD())) {
//      scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ADD_PAYMENT_METHOD());
//      if(isElementVisible(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_BELONGS_TO_POLICY_HOLDER(), CommonHelper.convertBooleanIntoString(true)))){
//        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_BELONGS_TO_POLICY_HOLDER(), CommonHelper.convertBooleanIntoString(true)), SyncType.CLICKABLE);
//        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PERMISSION_TO_STORE_CARD(), CommonHelper.convertBooleanIntoString(true)), SyncType.CLICKABLE);
//      }
//
//      //Add Payment Card
//      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ADD_PAYMENT_METHOD(),
//          SyncType.CLICKABLE); // Add Payment.
//      scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PAYMENT_METHOD());
//      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PAYMENT_METHOD(),
//          "Credit Card", SelectOptions.TEXT);
//      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_TYPE(),
//          paymentData.get("Type"), SelectOptions.TEXT);
//      typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_NUMBER(),
//          paymentData.get("CreditCardNumber"), SyncType.CLICKABLE);
//
//      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_EXPIRY_MONTH(),
//          StringUtils.stripStart(paymentData.get("ExpirationDate").toString().split("/")[0], "0")
//          , SelectOptions.TEXT);
//      typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_USER_NAME(),
//          paymentData.get("CardHolderName"), true, SyncType.CLICKABLE);
//      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_EXPIRY_YEAR(),
//          eisHomeQuoteCreationStepDefinition.getMatchingValueEndsWithFromDropDown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_EXPIRY_YEAR(), paymentData.get("ExpirationDate").toString().split("/")[1]), SelectOptions.TEXT);
//      scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ADD_UPDATE_CARD_DETAILS());
//      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ADD_UPDATE_CARD_DETAILS(), SyncType.CLICKABLE);
//      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BACK_BUTTON(),
//          SyncType.CLICKABLE);
//      return true;
//    } else {
//      return false;
//    }
//  }

  public boolean addCreditCardDetails(Map<String, Object> paymentData) throws CustomE2eException {
    if (!isElementVisible(this.pageObjectOfEis.getEisPaymentLocatorModel().CREDIT_CARD_PAYMENT_METHOD())) {
      scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ADD_PAYMENT_METHOD());
      if(isElementVisible(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_BELONGS_TO_POLICY_HOLDER(), CommonHelper.convertBooleanIntoString(true)))){
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_BELONGS_TO_POLICY_HOLDER(), CommonHelper.convertBooleanIntoString(true)), SyncType.CLICKABLE);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PERMISSION_TO_STORE_CARD(), CommonHelper.convertBooleanIntoString(true)), SyncType.CLICKABLE);
      }

      //Add Payment Card
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ADD_PAYMENT_METHOD(),
          SyncType.CLICKABLE); // Add Payment.
      int attempt =0;
      do {
        scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PAYMENT_METHOD());
        selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PAYMENT_METHOD(),
            "Credit Card", SelectOptions.TEXT);
        selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_TYPE(),
            paymentData.get("Type"), SelectOptions.TEXT);
        typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_NUMBER(),
            paymentData.get("CreditCardNumber"), SyncType.CLICKABLE);

        selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_EXPIRY_MONTH(),
            StringUtils.stripStart(paymentData.get("ExpirationDate").toString().split("/")[0], "0")
            , SelectOptions.TEXT);
        selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_EXPIRY_YEAR(),
            eisHomeQuoteCreationStepDefinition.getMatchingValueEndsWithFromDropDown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_EXPIRY_YEAR(), paymentData.get("ExpirationDate").toString().split("/")[1]), SelectOptions.TEXT);
        typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CARD_USER_NAME(),
            paymentData.get("CardHolderName"), SyncType.CLICKABLE, true);

        scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ADD_UPDATE_CARD_DETAILS());
        waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ADD_UPDATE_CARD_DETAILS(), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ADD_UPDATE_CARD_DETAILS(), SyncType.CLICKABLE);
        attempt++;
        if(attempt >5) {
          throw new CustomE2eException("Credit card not added successfully");
        }
      } while (!isElementVisible(this.pageObjectOfEis.getEisSharedLocatorModel().CREDIT_CARD_LINK()));
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BACK_BUTTON(),
          SyncType.CLICKABLE);
      return true;
    } else {
      return false;
    }
  }

  private void directDebit(Map<String, Object> paymentData) throws CustomE2eException {
    refreshPage();
    waitForPageLoad();
    selectDropdown(this.pageObjectOfEis.getEisPaymentLocatorModel().PAYMENT_PLAN_SELECTION(),
        eisHomeQuoteCreationStepDefinition.MONTHLY_DIRECT_DEBIT, SelectOptions.TEXT);
    waitForElement2(this.pageObjectOfEis.getEisPaymentLocatorModel().CCA_AGREEMENT(), SyncType.CLICKABLE, PolicyCreationOnEis.waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisPaymentLocatorModel().CCA_AGREEMENT(), SyncType.CLICKABLE);
    refreshPage();
    waitForPageLoad();
    waitForElement2(this.pageObjectOfEis.getEisPaymentLocatorModel().PREFERRED_PAYMENT_DATE(), SyncType.CLICKABLE, PolicyCreationOnEis.waitDuration);
    selectDropdown(this.pageObjectOfEis.getEisPaymentLocatorModel().PREFERRED_PAYMENT_DATE(),
        String.valueOf(paymentData.get(PolicyCreationOnEis.PREFERRED_PAYMENT_DATE)).trim(), SelectOptions.TEXT);
    waitForPageLoad();
//    scrollElementIntoCenterOfScreen(xpathBuilder(this.pageObjectOfEis.getEisPaymentLocatorModel().ACCOUNT_HOLDER(),
//        CommonHelper.convertBooleanIntoString(true)));

    clickElement(xpathBuilder(this.pageObjectOfEis.getEisPaymentLocatorModel().ACCOUNT_HOLDER(),
            CommonHelper.convertBooleanIntoString(true)), SyncType.CLICKABLE);

//    RetryOnStaleElementException(3,
//        () -> clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisPaymentLocatorModel().ACCOUNT_HOLDER(),
//        CommonHelper.convertBooleanIntoString(true)), SyncType.CLICKABLE), "Selecting Account " +
//            "holder");
    typeText(this.pageObjectOfEis.getEisPaymentLocatorModel().ACCOUNT_NUM(), paymentData.get(
        "AccountNumber"), SyncType.CLICKABLE);

    String value;
    do {
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisPaymentLocatorModel().BANK_SORT_CODE(),
          SyncType.CLICKABLE);
      waitForElement2(this.pageObjectOfEis.getEisPaymentLocatorModel().BANK_SORT_CODE(),
          SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
      typeTextWithoutClearField(this.pageObjectOfEis.getEisPaymentLocatorModel().BANK_SORT_CODE(), paymentData.get("SortCode"),
          true, SyncType.CLICKABLE, "Failed to enter sort code");
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisPaymentLocatorModel().ACCOUNT_NUM(),
          SyncType.CLICKABLE);
      waitForElement2(this.pageObjectOfEis.getEisPaymentLocatorModel().BANK_SORT_CODE(),
          SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
      value = getAttribute(this.pageObjectOfEis.getEisPaymentLocatorModel().BANK_SORT_CODE(),
          "value", "");

    } while (value.isEmpty());

    waitForElement2(this.pageObjectOfEis.getEisPaymentLocatorModel().ACCOUNT_HOLDER_NAME(),
        SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    RetryOnClickInterceptedException(3,
        () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisPaymentLocatorModel().ACCOUNT_HOLDER_NAME()
            , SyncType.CLICKABLE));
    typeText(this.pageObjectOfEis.getEisPaymentLocatorModel().ACCOUNT_HOLDER_NAME(),
        "Accountholder", SyncType.CLICKABLE);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisPaymentLocatorModel().ACCOUNT_NUM(),
        SyncType.CLICKABLE);
    waitForElement2(this.pageObjectOfEis.getEisPaymentLocatorModel().SIGNED_INSTRUCTION_RECEIVED(), SyncType.CLICKABLE, PolicyCreationOnEis.waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisPaymentLocatorModel().SIGNED_INSTRUCTION_RECEIVED(),
        SyncType.CLICKABLE);
    paymentAmountDetails(paymentData);
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().FINISH_PAYMENT(),
        SyncType.CLICKABLE, PolicyCreationOnEis.waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().FINISH_PAYMENT(),
        SyncType.CLICKABLE);
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CONFIRM_PAYMENT(),
        SyncType.CLICKABLE, PolicyCreationOnEis.waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CONFIRM_PAYMENT(),
        SyncType.CLICKABLE);
  }

  private void chequePayment(Map<String, Object> paymentData) throws CustomE2eException {
    paymentAmountDetails(paymentData);
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().FINISH_PAYMENT(),
        SyncType.CLICKABLE, PolicyCreationOnEis.waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().FINISH_PAYMENT(),
        SyncType.CLICKABLE);
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CONFIRM_PAYMENT(),
        SyncType.CLICKABLE, PolicyCreationOnEis.waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CONFIRM_PAYMENT(),
        SyncType.CLICKABLE);
  }

  private void paymentAmountDetails(Map<String, Object> paymentData) throws CustomE2eException {

    refreshPage();
    waitForPageLoad();

//    overrideErrorsIfErrorsFormDisplayed();


    //TODO: James taken out 15/05 as always fails
//    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CHEQUE_REFERENCE_NUM()
//        , SyncType.CLICKABLE, PolicyCreationOnEis.waitDuration);
    scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ADD_PAYMENT_METHOD());
//    scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().POLICY_AMOUNT_REQUIRED_FIELD());
//    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().POLICY_AMOUNT_REQUIRED_FIELD(),SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    var amountToBePaid =
        getAttribute(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().POLICY_AMOUNT_REQUIRED_FIELD(), "value", "Policy payment amount not found.");
    clearAmountField();
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CHEQUE_AMOUNT(), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CHEQUE_AMOUNT(), SyncType.CLICKABLE);
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CHEQUE_AMOUNT(), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CHEQUE_AMOUNT(),
        amountToBePaid, SyncType.CLICKABLE);
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CHEQUE_REFERENCE_NUM()
        , SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CHEQUE_REFERENCE_NUM(),
        SyncType.CLICKABLE);
    typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CHEQUE_REFERENCE_NUM(),
        paymentData.get(PolicyCreationOnEis.CHEQUE_NUMBER), SyncType.CLICKABLE);
  }

  private void overrideAllIfErrorsFormDisplayed() throws CustomE2eException {

    // By locator for Error page Title
    By errorTitleByLocator = By.xpath("//form[contains(@id, 'errorsForm')]//div[contains(text(), 'Error')]");
    // By locator for Errors select all checkbox
    By errorListSelectAllCheckboxByLocator = By.id("errorsForm:msgList:selectAllMessages");
    // By locator for Override button
    By overrideButtonByLocator = By.id("errorsForm:overrideRules");
    // By locator for error list first row Reason for overrride dropdown
    By errorFirstItemOverrideReasonDropdownByLocator = By.id("errorsForm:msgList:0:overrideReason");

    // Check if errors have been displayed
    if (isElementVisible(errorTitleByLocator)) {

      // Click select all checkbox
      clickElementAlt(errorListSelectAllCheckboxByLocator,
              SyncType.PRESENT, "Problem clicking error table select all checkbox");

      // TODO Switch to getElements and process them iteratively
      // Select Reason for override dropdown item 1
      selectDropdown(errorFirstItemOverrideReasonDropdownByLocator,
              "As per Guide", SelectOptions.TEXT);

      // Click Override button
      clickElementAlt(overrideButtonByLocator, SyncType.PRESENT, "Problem clicking Override button");

      // attempt purchase quote again
      purchaseQuote();

    }
  }

  private void clearAmountField() throws CustomE2eException {
//    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ALL_AMOUNT_COL(),
//        SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);

    var amountCol =
        getElementsMatchingToLocator(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ALL_AMOUNT_COL());
    int countOfElements = 1;
    for (var eachCol : amountCol) {
      waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().AMOUNT_COL(), String.valueOf(countOfElements)), SyncType.VISIBLE, eisGeneralStepDefinitions.waitDuration);
      int finalCountOfElements = countOfElements;
      var amountColLoc =
          RetryOnStaleElementException(5, () -> xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().AMOUNT_COL(),
              String.valueOf(finalCountOfElements)), "Waiting for Amount column");
      refreshPage();
      waitForPageLoad();
      var policyPayment = RetryOnStaleElementException(5, () -> getAttribute(amountColLoc, "value"
          , "Policy payment"), "getting policy payment");
      if (!policyPayment.isEmpty()) {
        waitForElement2(amountColLoc, SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
        var element = amountColLoc;
        RetryOnClickInterceptedException(10, () -> clickElementRetryX3onClickIntEx(element, SyncType.VISIBLE));
        clearText(amountColLoc);
        break;
      }
      countOfElements++;
    }
  }
}

package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import activities.CommonControlDataDefns;
import activities.PaymentOnPortal;
import activities.PolicyCreationOnQnBuyPortal;
import helpers.AgeasDigitalReactPortalHelpers;
import helpers.CommonHelper;
import helpers.SelectOptions;
import helpers.SyncType;
import org.openqa.selenium.WebDriver;


import java.time.Duration;
import java.util.Map;


public class PortalPaymentStepDefinition extends AgeasDigitalReactPortalHelpers {


    public PortalPaymentStepDefinition(WebDriver driver,
                                       PageObjects.PortalModel.Root pageObjectOfPortal) {
        super(driver, pageObjectOfPortal);
    }

    public void payNowButton(String quoteReference) throws CustomE2eException {
        try {
            boolean policyFound = false;
            waitForPageLoad();
            var payNowCount =
                    getElementsMatchingToLocator(this.pageObjectOfPortal.getPaymentLocatorModel().PAY_NOW_BUTTON());
            for (int payNowCounter = 1; payNowCounter <= payNowCount.size(); payNowCounter++) {
                clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPaymentLocatorModel().PAY_NOW(),
                        String.valueOf(payNowCounter)), SyncType.CLICKABLE);
                var quoteRef = getText(this.pageObjectOfPortal.getPaymentLocatorModel().QUOTE_REF());
                if (quoteReference.equalsIgnoreCase(quoteRef)) {
                    policyFound = true;
                    break;
                } else {
                    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPaymentLocatorModel().PAYMENT_BACK_BUTTON(),
                            SyncType.CLICKABLE);
                }
            }
            if (!policyFound) {
                throw new CustomE2eException("Policy not found to pay. Please check with quote reference.");
            }
//      if(isElementVisible(this.pageObjectOfPortal.getPaymentLocatorModel().COMPLETE_PAYMENT())) {
//        waitForElement(this.pageObjectOfPortal.getPaymentLocatorModel().COMPLETE_PAYMENT(),
//        SyncType.CLICKABLE);
//        clickElement(this.pageObjectOfPortal.getPaymentLocatorModel().COMPLETE_PAYMENT(),
//        SyncType.CLICKABLE);
//      }
        } catch (Exception e) {
            throw new CustomE2eException(e.getMessage());
        }
    }

    public void completePolicyChangeButton() throws CustomE2eException {
        try {
            waitForPageLoad();
            if(isElementVisible(this.pageObjectOfPortal.getPaymentLocatorModel().COMPLETE_PAYMENT())) {
                waitForElement(this.pageObjectOfPortal.getPaymentLocatorModel().COMPLETE_PAYMENT(), SyncType.CLICKABLE);
                clickElement(this.pageObjectOfPortal.getPaymentLocatorModel().COMPLETE_PAYMENT(), SyncType.CLICKABLE);
            }
        } catch (Exception e) {
            throw new CustomE2eException("Payment option is not available");
        }
    }
    public boolean navigateAndGetDescFromSummaryPage() throws CustomE2eException {
        boolean paymentNeed;
        paymentNeed = paymentCheck();
        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_SUMMARY_CHANGE_BUTTON(), SyncType.CLICKABLE);
        return paymentNeed;
    }

//  public void enterCardDetails(Map<String, Object> cardDetails, boolean paymentNeeded) throws
//  CustomE2eException {
//    if (paymentNeeded) {
//      String cardNumber = String.valueOf(cardDetails.get(PaymentOnPortal.CARD_NUMBER));
//      String cardHolderName = (String) cardDetails.get(PaymentOnPortal.CARD_HOLDER_NAME);
//      String cvvNumber = String.valueOf(cardDetails.get(PaymentOnPortal.CVV_NUMBER));
//      selectWhereCardBelongsToPolicyHolder();
//      enterCardNumber(cardNumber);
//      enterCardHolderName(cardHolderName);
//      selectExpiryDate();
//      enterCvvDetails(cvvNumber);
//      clickNextButton();
//      waitForPaymentProcessToComplete();
//    }
//    waitForPageLoad();
//  }

    public void enterCardDetails(Map<String, Object> cardDetails) throws CustomE2eException {
        String cardNumber = String.valueOf(cardDetails.get(PaymentOnPortal.CARD_NUMBER));
        String cardHolderName = (String) cardDetails.get(PaymentOnPortal.CARD_HOLDER_NAME);
        String cvvNumber = String.valueOf(cardDetails.get(PaymentOnPortal.CVV_NUMBER));
        selectWhereCardBelongsToPolicyHolder();
        //enterCardNumber(cardNumber);
        enterCardNumber("4444333322221111");
        enterCardHolderName(cardHolderName);
        selectExpiryDate();
        enterCvvDetails ("555");
        //enterCvvDetails(cvvNumber);

        //Temp work around


        clickNextButton();
    }

  /*public void confirmCardUsage(Boolean proposalIsCardHolder) throws CustomE2eException {
    if(proposalIsCardHolder) {
      clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPaymentLocatorModel().PROPOSER_IS_CARD_HOLDER(), "Y"),
              SyncType.VISIBLE);
    }else {
      clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPaymentLocatorModel().PROPOSER_IS_CARD_HOLDER(), "N"),
              SyncType.VISIBLE);
      clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPaymentLocatorModel().CARD_PERMISSION(), "Y"),
              SyncType.VISIBLE);
    }
  }*/

    public boolean waitForPaymentProcessToComplete() {
        if (getCurrentUrl().endsWith("PolicyDetails")) {
            return true;
        } else {
            return false;
        }
    }

//  Do not Delete - 06/02/2024
//  public void waitForPaymentSpinnerToDisappear() {
//    if (isElementVisible(SharedLocatorLibrary.PAYMENT_SPINNER)) {
//      waitForElementToInvisible(SharedLocatorLibrary.PAYMENT_SPINNER);
//    }
//  }

    public void paymentSuccessful() throws CustomE2eException {
        waitForPageLoad();
        //waitForElement2(this.pageObjectOfPortal.getPaymentLocatorModel().CLOSE_PAYMENT_POP_UP(), SyncType.VISIBLE, waitDuration);

        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300), () -> waitForElement2(this.pageObjectOfPortal.getPaymentLocatorModel().CLOSE_PAYMENT_POP_UP(), SyncType.VISIBLE, waitDuration));

        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300), () -> clickElement(this.pageObjectOfPortal.getPaymentLocatorModel().CLOSE_PAYMENT_POP_UP(),
                SyncType.CLICKABLE));

        //if(isElementVisible(this.pageObjectOfPortal.getPaymentLocatorModel().COMPLETE_PAYMENT())){
        //PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(30), () -> waitForElement2(this.pageObjectOfPortal.getPaymentLocatorModel().CLOSE_PAYMENT_POP_UP(), SyncType.VISIBLE, waitDuration));
        //waitForElement2(this.pageObjectOfPortal.getPaymentLocatorModel().CLOSE_PAYMENT_POP_UP(),
        //SyncType.CLICKABLE, waitDuration);
        //PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(30), () -> clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPaymentLocatorModel().CLOSE_PAYMENT_POP_UP(),
        //SyncType.CLICKABLE));



    };

    public void paymentSuccessfulA() throws CustomE2eException {
        waitForPageLoad();

        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(600),
                () -> waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().SIGN_OUT_BUTTON(), SyncType.CLICKABLE, waitDuration));

        //if(isElementVisible(this.pageObjectOfPortal.getPaymentLocatorModel().COMPLETE_PAYMENT())){
        //PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(30), () -> waitForElement2(this.pageObjectOfPortal.getPaymentLocatorModel().CLOSE_PAYMENT_POP_UP(), SyncType.VISIBLE, waitDuration));
        //waitForElement2(this.pageObjectOfPortal.getPaymentLocatorModel().CLOSE_PAYMENT_POP_UP(),
        //SyncType.CLICKABLE, waitDuration);
        //PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300), () -> clickElement(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_HOME_TAB(),
        //SyncType.CLICKABLE));


    };



    public Map<?,?> paymentSuccessfulQnBuy(Map<String, Object>dataResult) throws CustomE2eException {
        var policyNo = "";
        waitForPageLoad();
        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(30), () -> waitForElement2(this.pageObjectOfPortal.getPaymentLocatorModel().PAYMENT_SUCCESSFUL_TEXT(), SyncType.VISIBLE, waitDuration));
        Boolean paymentIsSuccessful = waitForElement2(this.pageObjectOfPortal.getPaymentLocatorModel().PAYMENT_SUCCESSFUL_TEXT(), SyncType.VISIBLE, waitDuration);
        policyNo = getText(this.pageObjectOfPortal.getPaymentLocatorModel().POLICY_NUMB()).split("\n")[1];
        dataResult.put(CommonControlDataDefns.IS_PAYMENT_SUCCESSFUL, paymentIsSuccessful);
        dataResult.put(CommonControlDataDefns.POLICY_NUMBER, policyNo);
        return dataResult;
    }

    private void clickNextButton() throws CustomE2eException {
        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPaymentLocatorModel().NEXT_BUTTON(),
                SyncType.CLICKABLE);
    }

    private void enterCvvDetails(String cvvNumber) throws CustomE2eException {
        typeText(this.pageObjectOfPortal.getPaymentLocatorModel().CARD_CVV(), cvvNumber,
                SyncType.CLICKABLE);
    }

    private void selectExpiryDate() throws CustomE2eException {
        selectDropdown(this.pageObjectOfPortal.getPaymentLocatorModel().CARD_HOLDER_MONTH(), 2,
                SelectOptions.INDEX);
        selectDropdown(this.pageObjectOfPortal.getPaymentLocatorModel().CARD_HOLDER_YEAR(), 4,
                SelectOptions.INDEX);
    }

    private void enterCardHolderName(String cardHolderName) throws CustomE2eException {
        typeText(this.pageObjectOfPortal.getPaymentLocatorModel().CARD_HOLDER_NAME(), cardHolderName,
                SyncType.CLICKABLE);
    }

    private void enterCardNumber(String cardNumber) throws CustomE2eException {
        waitForElement2(this.pageObjectOfPortal.getPaymentLocatorModel().CARD_NUMBER(),
                SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfPortal.getPaymentLocatorModel().CARD_NUMBER(), cardNumber,
                SyncType.CLICKABLE);
    }


    private void selectWhereCardBelongsToPolicyHolder() throws CustomE2eException {


        //waitForElement2(this.pageObjectOfPortal.getPaymentLocatorModel().CARD_BELONG_TO_POLICY_HOLDER(), SyncType.CLICKABLE, waitDuration);
        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300), () -> clickElement(this.pageObjectOfPortal.getPaymentLocatorModel().CARD_BELONG_TO_POLICY_HOLDER(),
                SyncType.CLICKABLE));
        //clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPaymentLocatorModel().CARD_BELONG_TO_POLICY_HOLDER(),
        //SyncType.CLICKABLE);
    }

    public boolean paymentCheck() {
        boolean paymentReq = false;
        if (isElementVisible(this.pageObjectOfPortal.getPaymentLocatorModel().PREMIUM_VALUE())) {
            paymentReq = true;
        } else if (isElementVisible(this.pageObjectOfPortal.getPaymentLocatorModel().REFUND_VALUE())) {
            paymentReq = false;
        }
        return paymentReq;
    }

}

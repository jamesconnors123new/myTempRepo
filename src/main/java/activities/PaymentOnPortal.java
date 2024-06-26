package activities;

import Generic.customExceptions.CustomE2eException;
import StepDefinitions.PortalGeneralStepDefinitions;
import StepDefinitions.PortalPaymentStepDefinition;
import UiWrappers.Browser;
import UiWrappers.Portal.Site.PortalVer001;
import activities.bases.AgeasPortalLoggedInBase;
import org.openqa.selenium.WebDriver;
import sqc.bstof.skeleton.ActivityEndpoint;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static helpers.SeleniumHelper.openBrowser;

/**
 * This operation is used to complete the payment on portal.
 */
public class PaymentOnPortal extends AgeasPortalLoggedInBase<PortalVer001> implements ActivityEndpoint {

  public static final String CARD_DETAILS = "CardDetails";
  public static final String QUOTE_REFERENCE = "QuoteReference";
  public static final String CARD_NUMBER = "CreditCardNumber";
  public static final String CARD_HOLDER_NAME = "CardHolderName";
  public static final String CVV_NUMBER = "CVV";
  public static final String PAYMENT_SUCCESSFUL = "PaymentSuccessful";

  public static final String TRANS_TYPE = "TransType";

  //LocalActionRecordingServices actionRecordingService = null;
  ActivityExecPeriodReturn executionResult;


  @Override
  protected WebDriver ProvideWebDriver() throws CustomE2eException {
    return openBrowser();

  }

  @Override
  protected boolean requiresLogin() {
    return true;
  }

  @Override
  public ActivityExecPeriodReturn performActionLoggedIntoPortal(PageObjects.PortalModel.Root pageObjectOfPortal, Browser<PageObjects.PortalModel.Root, PortalGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) {
    Map<String, Object> resultsData = new HashMap<>();
    Map<String, Object> returnYaml = new HashMap<>();


    try {
      var paymentPage = new PortalPaymentStepDefinition(pBrowser.Wd(), pageObjectOfPortal);
      var portalGeneralStepDefinitions = new PortalGeneralStepDefinitions(pBrowser.Wd(),
          pageObjectOfPortal);
      String transactionType = (String)controlData.get(TRANS_TYPE);
      if (transactionType.equalsIgnoreCase("New") ){
        paymentPage.redirectToHomePageTab();
        paymentPage.payNowButton(String.valueOf(controlData.get(QUOTE_REFERENCE)));
        paymentPage.enterCardDetails((Map<String, Object>) controlData.get(CARD_DETAILS));
        paymentPage.paymentSuccessful();
        portalGeneralStepDefinitions.signOutApplication();
      } else if (transactionType.equalsIgnoreCase("Mta") ){
        pBrowser.Cs().switchToInsuranceTab((String) controlData.get(PortalGeneralStepDefinitions.INSURANCE_TYPE));
        paymentPage.completePolicyChangeButton();
        //boolean paymentNeeded = paymentPage.navigateAndGetDescFromSummaryPage();
        paymentPage.enterCardDetails((Map<String, Object>) controlData.get(CARD_DETAILS));
        paymentPage.paymentSuccessfulA();
        portalGeneralStepDefinitions.signOutApplication();
        //pBrowser.Cs().switchToInsuranceTab((String) controlData.get(PortalGeneralStepDefinitions.INSURANCE_TYPE));
      }
      return ActivityExecPeriodReturnImpl.completed(uuid, resultsData);
    } catch (CustomE2eException customE2eException) {
      useActionRecordingService().writeToTestCaseInstanceRecord(getClass().getSimpleName() +
          "Activity" + " failed; \n\n" + customE2eException);
      executionResult = ActivityExecPeriodReturnImpl.faulted(uuid);
    } catch (Exception e) {
      useActionRecordingService().writeToTestCaseInstanceRecord(getClass().getSimpleName() +
          "Activity" + " failed; \n\n" + e);
      executionResult = ActivityExecPeriodReturnImpl.faulted(uuid);
    } finally {
      useActionRecordingService().recordEndOfAnActivityInCaseInstRecord();
    }
    return executionResult;
  }
}


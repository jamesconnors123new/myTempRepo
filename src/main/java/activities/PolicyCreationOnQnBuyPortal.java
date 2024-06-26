package activities;

import Generic.customExceptions.CustomE2eException;
import StepDefinitions.EnhanceCoverQnBPortalUIStepDefinition;
import StepDefinitions.PortalGeneralStepDefinitions;
import StepDefinitions.PortalPaymentStepDefinition;
import StepDefinitions.RetrieveQuotePortalUIStepDefinition;
import UiWrappers.Browser;
import UiWrappers.Portal.Site.PortalVer001;
import activities.bases.AgeasPortalLoggedInBase;
import helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import sqc.bstof.skeleton.ActivityEndpoint;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;
import sqc.bstof.skeletonhelp.StandardReportingPatterns;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * This operation is used to complete the payment on portal.
 */
public class PolicyCreationOnQnBuyPortal extends AgeasPortalLoggedInBase<PortalVer001> implements ActivityEndpoint {

  public static final String CARD_DETAILS = "CardDetails";
  public static final String PAYMENT_DATA = "PaymentData";
  //public static final String CARD_PERMISSION = "CardPermission";
  //public static final String PROPOSER_IS_CARD_HOLDER = "ProposerIsCardHolder";
  public static final String QUOTE_REFERENCE = "QuoteReference";
  public static final String CARD_NUMBER = "CreditCardNumber";
  public static final String CARD_HOLDER_NAME = "CardHolderName";
  public static final String CVV_NUMBER = "CVV";
  public static final String PAYMENT_SUCCESSFUL = "PaymentSuccessful";


  StandardReportingPatterns actionRecordingService = null;
  ActivityExecPeriodReturn executionResult;


  @Override
  protected WebDriver ProvideWebDriver() throws CustomE2eException {
    return SeleniumHelper.openBrowser();
  }

  @Override
  protected boolean requiresLogin() {
    return false;
  }

  @Override
  public ActivityExecPeriodReturn performActionLoggedIntoPortal(
      PageObjects.PortalModel.Root pageObjectOfPortal,
      Browser<PageObjects.PortalModel.Root, PortalGeneralStepDefinitions> pBrowser,
      SequencerFaceToActivity sequencerFaceToActivity,
      UUID uuid,
      Map<String, Object> controlData,
      ActivityInterimState activityInterimState,
      PrintStream printStream) {
    actionRecordingService = new StandardReportingPatterns(sequencerFaceToActivity);
    String strLogLine = getClass().getSimpleName() + " Activity.execute";
    actionRecordingService.recordStartOfAnActivityInCaseInstRecord(strLogLine);

    Map<String, Object> resultsData = new HashMap<>();
    Map<String, Object> returnYaml = new HashMap<>();


    try {
      var paymentPage = new PortalPaymentStepDefinition(pBrowser.Wd(), pageObjectOfPortal);
      var portalGeneralStepDefinitions = new PortalGeneralStepDefinitions(pBrowser.Wd(),
              pageObjectOfPortal);
      var retrieveQuotePage = new RetrieveQuotePortalUIStepDefinition(pBrowser.Wd(), pageObjectOfPortal);
      var enhanceCover = new EnhanceCoverQnBPortalUIStepDefinition(pBrowser.Wd(),pageObjectOfPortal);
      var quoteDetails = (Map<String, String>) controlData.get(CommonControlDataDefns.QUOTE_DET);

      paymentPage.redirectToRetrieveQuotePage();
      retrieveQuotePage.retrieveHomeQuote(quoteDetails.get(CommonControlDataDefns.DATE_OF_BIRTH),
              quoteDetails.get(CommonControlDataDefns.POST_CODE_VAR),
              String.valueOf(quoteDetails.get(CommonControlDataDefns.QUOTE_REF)));
      retrieveQuotePage.verifyHomeQuoteRetrieved(quoteDetails.get(CommonControlDataDefns.DATE_OF_BIRTH),
              quoteDetails.get(CommonControlDataDefns.POST_CODE_VAR),
              String.valueOf(quoteDetails.get(CommonControlDataDefns.QUOTE_REF)));
      enhanceCover.setEnhancePolicyCoverToNo();
      portalGeneralStepDefinitions.continueButton();
      portalGeneralStepDefinitions.payButton();
      portalGeneralStepDefinitions.waitForPageLoad();
      paymentPage.enterCardDetails((Map<String, Object>) controlData.get(PolicyCreationOnQnBuyPortal.PAYMENT_DATA));
      Map<?, ?> paymentSuccessfulData = paymentPage.paymentSuccessfulQnBuy(resultsData);
      returnYaml.put(CommonControlDataDefns.POLICY_NUMBER, paymentSuccessfulData.get(CommonControlDataDefns.POLICY_NUMBER));
      returnYaml.put(CommonControlDataDefns.IS_PAYMENT_SUCCESSFUL, paymentSuccessfulData.get(CommonControlDataDefns.IS_PAYMENT_SUCCESSFUL));
      resultsData.put(CommonControlDataDefns.QUOTE_DET, returnYaml);
      return ActivityExecPeriodReturnImpl.completed(uuid, resultsData);
    } catch (Exception customE2eException) {
      useActionRecordingService().reportRuntimeFaultIssue(customE2eException);
      return ActivityExecPeriodReturnImpl.faulted(uuid);
    }
  }
}


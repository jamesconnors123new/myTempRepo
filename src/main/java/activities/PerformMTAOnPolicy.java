package activities;

import Generic.customExceptions.CustomE2eException;
import StepDefinitions.PerformMTAStepDefinition;
import StepDefinitions.PortalGeneralStepDefinitions;
import StepDefinitions.PortalPaymentStepDefinition;
import UiWrappers.Browser;
import UiWrappers.Portal.Site.PortalVer001;
import activities.bases.AgeasPortalLoggedInBase;
import helpers.ControlDataHelpers;
import helpers.SeleniumHelper;
import lombok.Getter;
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

import static activities.CommonControlDataDefns.POLICY_NUMBER;
import static activities.CommonControlDataDefns.SEARCH_CRITERIA;

public class PerformMTAOnPolicy extends AgeasPortalLoggedInBase<PortalVer001> implements ActivityEndpoint {

  @Getter
  private static final String MTA_SPEC = "MTASpec";

  @Override
  protected WebDriver ProvideWebDriver() throws CustomE2eException {
    return SeleniumHelper.openBrowser();
  }

  @Override
  protected boolean requiresLogin() {
    return true;
  }

  @Override
  public ActivityExecPeriodReturn performActionLoggedIntoPortal(PageObjects.PortalModel.Root pageObjectOfPortal, Browser<PageObjects.PortalModel.Root, PortalGeneralStepDefinitions> pBroswer, SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) {
    var returnYaml = new HashMap<String, Object>();

    try {

      if (!ControlDataHelpers.ValidateMapContainsNonEmptyStringValueAtPath(controlData,
          SEARCH_CRITERIA, POLICY_NUMBER)) {
        useActionRecordingService().reportControlDataIssue("Policy number specification missing");
        return ActivityExecPeriodReturnImpl.faulted(uuid);
      }
      var vPolicyNumber =
          (String) ((Map<String, Object>) controlData.get(SEARCH_CRITERIA)).get(CommonControlDataDefns.POLICY_NUMBER);
      var performMTAOnPortal = new PerformMTAStepDefinition(pBroswer, pageObjectOfPortal);

      Map<String, Object> returnData = performMTAOnPortal.performMTA(vPolicyNumber, (Map<String,
          Object>) controlData.get(MTA_SPEC),
          (String) controlData.get(CommonControlDataDefns.MTAEFFECTIVEDATE));  //Fetching

      // expect to be on Confirm your changes page
      returnYaml.put(CommonControlDataDefns.PREMIUM_AFTER_PREMIUM_AFFECTING_OPERATION, returnData);



      var Charge = ((Map<String, Object>) returnData.get("FinancialImpact")).get("Charge");
      var Refund = ((Map<String, Object>) returnData.get("FinancialImpact")).get("Refund");

      if (!( Charge.equals("0")) && (!(Boolean) Refund)) {
        //Temp workaround to complete
        var paymentPage = new PortalPaymentStepDefinition(pBroswer.Wd(), pageObjectOfPortal);
        paymentPage.enterCardDetails((Map<String, Object>) controlData.get(PaymentOnPortal.CARD_DETAILS));
        paymentPage.paymentSuccessfulA();

      }

      var portalGeneralStepDefinitions = new PortalGeneralStepDefinitions(pBroswer.Wd(),
              pageObjectOfPortal);
      portalGeneralStepDefinitions.signOutApplication();


      return ActivityExecPeriodReturnImpl.completed(uuid, returnYaml);
    } catch (Exception customE2eException) {
      useActionRecordingService().reportRuntimeFaultIssue(customE2eException);
      return ActivityExecPeriodReturnImpl.faulted(uuid);

    }
  }


}

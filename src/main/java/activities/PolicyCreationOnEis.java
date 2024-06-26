package activities;

import Generic.customExceptions.CustomE2eException;
import StepDefinitions.*;
import UiWrappers.Browser;
import UiWrappers.Eis.Site.EisVer001;
import activities.bases.EisLoggedInBase;
import helpers.SeleniumHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import sqc.bstof.skeleton.ActivityEndpoint;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;
import sqc.bstof.skeletonhelp.StandardReportingPatterns;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;


public class PolicyCreationOnEis extends EisLoggedInBase<EisVer001> implements ActivityEndpoint {
  StandardReportingPatterns actionRecordingService = null;
  ActivityExecPeriodReturn executionResult;
  public static final long waitDuration = 60000L;

  public static final String POLICY_STATUS = "PolicyStatus";
  public static final String POLICY_NUMBER = "PolicyNumber";
  public static final String EIS_CLIENT_NUMBER = "ClientNumber";
  public static final String PAYMENT_METHOD = "PaymentMethod";
  public static final String PAYMENT_DATA = "PaymentData";
  public static final String CHEQUE_NUMBER = "ChequeNumber";
  public static final String PREFERRED_PAYMENT_DATE = "PreferredPaymentDate";


  @Override
  protected WebDriver ProvideWebDriver() throws CustomE2eException {
    return SeleniumHelper.openBrowser();
  }

  @Override
  public ActivityExecPeriodReturn performActionLoggedIntoEis(PageObjects.EisModel.Root pageObjectOfEis, Browser<PageObjects.EisModel.Root, EisGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) {

    LinkedHashMap<String, Object> resultsData = new LinkedHashMap<>();
    LinkedHashMap<String, Object> returnYaml = new LinkedHashMap<>();

    actionRecordingService = new StandardReportingPatterns(sequencerFaceToActivity);
    String strLogLine = getClass().getSimpleName() + " Activity.execute";
    actionRecordingService.recordStartOfAnActivityInCaseInstRecord(strLogLine);

    try {
      var eisGeneralStepDefinitions = new EisGeneralStepDefinitions(pBrowser.Wd(), pageObjectOfEis);
      var eisLoginSteDef = new EisLoginStepDefinition(pBrowser.Wd(), pageObjectOfEis);
      var commonControlDataDef = new CommonControlDataDefns();
      var eisHomePage = new EisHomeStepDefinition(pBrowser.Wd(), pageObjectOfEis);
      var eisPolicyCreationStepDef = new EisPolicyCreationStepDefinition(pBrowser.Wd(),
          pageObjectOfEis);
      var eisClientPortfolioPage = new EisClientPortfolioStepDefinition(pBrowser.Wd(),
          pageObjectOfEis);
      var eisQuoteCreationStepDef = new EisHomeQuoteCreationStepDefinition(pBrowser.Wd(),
          pageObjectOfEis);
      var declines =  controlData.get(commonControlDataDef.DECLINES);
      var referrals = controlData.get(commonControlDataDef.REFERRALS);
      if (!(Boolean.parseBoolean((String) declines)) ) {

        eisHomePage.searchEisClient((LinkedHashMap<String, String>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA));
        eisHomePage.selectPolicyId((String) (controlData.get(CommonControlDataDefns.QUOTE_REFERENCE)));
        eisClientPortfolioPage.loginQuotePortal((LinkedHashMap<String, Object>) controlData.get(CORE_USER_CREDENTIALS));

        eisQuoteCreationStepDef.openQuote((String) (controlData.get(CommonControlDataDefns.QUOTE_REFERENCE)));
        eisQuoteCreationStepDef.redirectToCoverageAndPremium();
        eisPolicyCreationStepDef.purchaseQuote();
        eisPolicyCreationStepDef.paymentProcess((String) controlData.get(PAYMENT_METHOD),
                (LinkedHashMap<String, Object>) controlData.get(PAYMENT_DATA));
        var customerNumber = eisQuoteCreationStepDef.getCustomerNumber();
        var policyId = eisQuoteCreationStepDef.getPolicyNumber();
        var policyStatus = eisQuoteCreationStepDef.getPolicyStatus();

        returnYaml.put(POLICY_STATUS, policyStatus);
        returnYaml.put(POLICY_NUMBER, policyId);
        returnYaml.put(EIS_CLIENT_NUMBER, customerNumber);
        returnYaml.put(commonControlDataDef.DECLINES, declines);
        returnYaml.put(commonControlDataDef.REFERRALS, referrals);
        returnYaml.put(PAYMENT_METHOD, controlData.get(PAYMENT_METHOD));
        returnYaml.put(PAYMENT_DATA, controlData.get(PAYMENT_DATA));


        resultsData.put(CommonControlDataDefns.POLICY_DETAILS, returnYaml);
      } else{
        throw new CustomE2eException("Policy has been declined");
      }

      this.useActionRecordingService()
              .storeDataInTestCaseInstanceRecord(
                      "EisPolicyData_PolicyActive",
                      "png",
                      ((TakesScreenshot) pBrowser.Wd()).getScreenshotAs(OutputType.BYTES)
              );

      eisLoginSteDef.signOutEisApplication();
      actionRecordingService.writeToTestCaseInstanceRecord(getClass().getSimpleName() + " " +
          "Activity completed");
      return ActivityExecPeriodReturnImpl.completed(uuid, resultsData);
    } catch (Exception customE2eException) {
      useActionRecordingService().reportRuntimeFaultIssue(customE2eException);
      return ActivityExecPeriodReturnImpl.faulted(uuid);
    }
  }
}

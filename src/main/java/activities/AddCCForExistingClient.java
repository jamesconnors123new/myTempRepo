package activities;


import Generic.customExceptions.CustomE2eException;
import StepDefinitions.*;
import UiWrappers.Browser;
import UiWrappers.Eis.Site.EisVer001;
import activities.bases.EisLoggedInBase;
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


public class AddCCForExistingClient extends EisLoggedInBase<EisVer001> implements ActivityEndpoint {
  public static final String CLIENT_NUMBER = "ClientNumber";
  public static final String EIS_CLIENT_DETAILS = "EisClientDetails";
  public static final String PAYMENT_DATA = "PaymentData";

  StandardReportingPatterns actionRecordingService = null;
  ActivityExecPeriodReturn executionResult;
  public static final long waitDuration = 60000L;
  @Override
  protected WebDriver ProvideWebDriver() throws CustomE2eException {
    return SeleniumHelper.openBrowser();
  }

  @Override
  public ActivityExecPeriodReturn performActionLoggedIntoEis(PageObjects.EisModel.Root pageObjectOfEis,
                                                             Browser<PageObjects.EisModel.Root,
                                                                 EisGeneralStepDefinitions> pBrowser,
                                                             SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) {

    Map<String, Object> resultsData = new HashMap<>();
    Map<String, Object> returnYaml = new HashMap<>();

    actionRecordingService =  new StandardReportingPatterns(sequencerFaceToActivity);
    String strLogLine = getClass().getSimpleName() + " Activity.execute";
    actionRecordingService.recordStartOfAnActivityInCaseInstRecord(strLogLine);

    try {
      var eisGeneralStepDefinitions = new EisGeneralStepDefinitions(pBrowser.Wd(),
              pageObjectOfEis);
      var commonControlDataDef = new CommonControlDataDefns();
      var eisLoginPage = new EisLoginStepDefinition(pBrowser.Wd(), pageObjectOfEis);
      var eisHomePage = new EisHomeStepDefinition(pBrowser.Wd(), pageObjectOfEis);
      var eisClientPortfolioPage = new EisClientPortfolioStepDefinition(pBrowser.Wd(),
          pageObjectOfEis);
      var eisQuoteCreationStepDef = new EisHomeQuoteCreationStepDefinition(pBrowser.Wd(),
          pageObjectOfEis);
      var eisPolicyCreationStepDef = new EisPolicyCreationStepDefinition(pBrowser.Wd(),
          pageObjectOfEis);
      var declines =  controlData.get(commonControlDataDef.DECLINES);
      var referrals = controlData.get(commonControlDataDef.REFERRALS);
      if(!(Boolean.parseBoolean((String) declines)) ) {

        eisHomePage.searchEisClient((Map<String, String>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA));
        eisHomePage.selectPolicyId((String) ((Map<String, Object>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA)).get("QuoteReference"));
        eisClientPortfolioPage.loginQuotePortal((Map<String, Object>) controlData.get(CORE_USER_CREDENTIALS));
        eisQuoteCreationStepDef.openQuote((String) ((Map<String, Object>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA)).get("QuoteReference"));
        eisQuoteCreationStepDef.redirectToCoverageAndPremium();

        eisPolicyCreationStepDef.purchaseQuote();
        eisPolicyCreationStepDef.addCreditCardDetails((Map<String, Object>) controlData.get(PAYMENT_DATA));
      }else{
        throw new CustomE2eException("Policy has been declined");
      }
      eisLoginPage.signOutEisApplication();

      actionRecordingService.writeToTestCaseInstanceRecord(getClass().getSimpleName() + " " +
          "Activity completed");
      resultsData.put(EIS_CLIENT_DETAILS, returnYaml);
      executionResult = ActivityExecPeriodReturnImpl.completed(uuid, resultsData);
    } catch (Exception customE2eException) {
      actionRecordingService.reportRuntimeFaultIssue(customE2eException);
      executionResult = ActivityExecPeriodReturnImpl.faulted(uuid);
    } finally {
      actionRecordingService.recordEndOfAnActivityInCaseInstRecord();
    }
    return executionResult;
  }
}

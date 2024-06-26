package activities;

import Generic.customExceptions.CustomE2eException;
import PageObjects.EchelonModel.Root;
import StepDefinitions.EchelonGeneralStepDefinitions;
import StepDefinitions.EchelonHomeStepDefinition;
import StepDefinitions.EchelonLoginStepDefinition;
import StepDefinitions.EchelonPolicyCreationStepDefinition;
import UiWrappers.Browser;
import UiWrappers.Echelon.Site.EchelonVer001;
import activities.bases.EchelonLoggedInBase;
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
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PolicyCreationOnEchelonUI extends EchelonLoggedInBase<EchelonVer001> implements ActivityEndpoint {

  public static final String POLICY_NUMBER = "PolicyNumber";
  public static final String PAYMENTS_STATUS = "PaymentStatus";
  public static final String HOUSE_HOLD = "Household";
  public static final String PRIVATE_CAR = "Private Car";
  public static final String PAYMENT_DETAILS = "PaymentDetails";
  public static final String PAYMENT_METHOD = "PaymentMethod";
  public static final String NO_PAYMENT = "NoPayment";
  public static final String STORED_CARD = "StoredCard";
  public static final String NEW_CARD = "NewCard";

  StandardReportingPatterns actionRecordingService = null;
  ActivityExecPeriodReturn executionResult;


  @Override
  protected WebDriver ProvideWebDriver() throws CustomE2eException {
    return SeleniumHelper.openBrowser();
  }


  @Override
  protected ActivityExecPeriodReturn performActionLoggedIntoEchelon(Root pageObjectOfEchelon, Browser<Root, EchelonGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) throws CustomE2eException {

    Map<String, Object> resultsData = new HashMap<>();
    Map<String, Object> returnYaml = new HashMap<>();

    actionRecordingService = new StandardReportingPatterns(sequencerFaceToActivity);
    String strLogLine = getClass().getSimpleName() + " Activity.execute";
    actionRecordingService.recordStartOfAnActivityInCaseInstRecord(strLogLine);
    //Initialise Page Objects
    EchelonGeneralStepDefinitions echelonGeneralStepDefinitions = null;
    try {

      echelonGeneralStepDefinitions = new EchelonGeneralStepDefinitions(pBrowser.Wd(),
          pageObjectOfEchelon);
      var echelonLoginPage = new EchelonLoginStepDefinition(pBrowser.Wd(), pageObjectOfEchelon);
      var echelonHomePage = new EchelonHomeStepDefinition(pBrowser.Wd(), pageObjectOfEchelon);

      var echelonPolicyCreationPage = new EchelonPolicyCreationStepDefinition(pBrowser.Wd(),pageObjectOfEchelon);
      var quoteDetails = ((Map<String, Object>) controlData.get(CommonControlDataDefns.QUOTE_DET));
      echelonHomePage.searchForClientPolicy((Map<String, String>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA));
      echelonGeneralStepDefinitions.selectClient();
      echelonPolicyCreationPage.clickViewPolicyReferenceDetails((String) quoteDetails.get(
          CommonControlDataDefns.QUOTE_REF));
      echelonPolicyCreationPage.clickOnWrapup();
//      echelonPolicyCreationPage.referralConfirmation(); Do not delete
      echelonPolicyCreationPage.navigateToNextPage();
      var paymentStatus =
          echelonPolicyCreationPage.paymentProcess(((Map<String, String>) controlData.get(
              PAYMENT_DETAILS)).get(PAYMENT_METHOD));

      var policyNumber= echelonPolicyCreationPage.getPolicyId();
      returnYaml.put(POLICY_NUMBER, policyNumber);
      returnYaml.put(PAYMENTS_STATUS, paymentStatus);
      resultsData.put(CommonControlDataDefns.POLICY_DETAILS,returnYaml);

      var vScreenShot = ((TakesScreenshot) pBrowser.Wd()).getScreenshotAs(OutputType.BYTES);
      this.useActionRecordingService().storeDataInTestCaseInstanceRecord("CustomerDetailsSummary"
          , "png", vScreenShot);
      echelonHomePage.signOutEchelonApplication();
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

package activities;

import Generic.customExceptions.CustomE2eException;
import PageObjects.EchelonModel.Root;
import StepDefinitions.*;
import UiWrappers.Browser;
import UiWrappers.Echelon.Site.EchelonVer001;
import activities.bases.EchelonLoggedInBase;
import helpers.DataNormalisationHelper;
import helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import sqc.bstof.skeleton.ActivityEndpoint;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;
import sqc.bstof.skeletonhelp.LocalSettingsAndVariableAccessService;
import sqc.bstof.skeletonhelp.StandardReportingPatterns;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//public class GetCarPolicyDetailsEchelonUI implements ActivityEndpoint {
public class GetCarPolicyDetailsEchelonUI extends EchelonLoggedInBase<EchelonVer001> implements ActivityEndpoint {
  private static final String WEBSITE_ROOT = "EchelonLoginURL";

  public static final String USER_CREDENTIALS = "UserCredentials";
  public static final String CUSTOMER_DETAILS_ECHELON = "CustomerPolicyDetailOnEchelon";
  public static final String POLICY_NUMBER = "PolicyNumber";
  public static final String RAW_DATA = "RawData";
  public static final String NORMALIZED_DATA = "NormalizedData";

  public static final String CAR_POLICY_DETAILS_ECHELON = "CarPolicyDetailsEchelon";

  StandardReportingPatterns actionRecordingService = null;
  ActivityExecPeriodReturn executionResult;


  //    @Override
//    public ActivityExecPeriodReturn execute(
//            SequencerFaceToActivity sequencerFaceToActivity,
//            UUID uuid,
//            Map<String, Object> controlData,
//            ActivityInterimState activityInterimState,
//            PrintStream printStream) {
  @Override
  protected WebDriver ProvideWebDriver() throws CustomE2eException {
    return SeleniumHelper.openBrowser();
  }


  @Override
  protected ActivityExecPeriodReturn performActionLoggedIntoEchelon(Root pageObjectOfEchelon, Browser<Root, EchelonGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) throws CustomE2eException {

    WebDriver driver;
    Map<String, Object> resultsData = new HashMap<>();
    Map<String, Object> returnYaml = new HashMap<>();

    var dataAccess = new LocalSettingsAndVariableAccessService(sequencerFaceToActivity);
    var rootUrl = (String) dataAccess.getGlobalSetting(WEBSITE_ROOT);

    actionRecordingService = new StandardReportingPatterns(sequencerFaceToActivity);
    String strLogLine = getClass().getSimpleName() + " Activity.execute";
    actionRecordingService.recordStartOfAnActivityInCaseInstRecord(strLogLine);

    //Initialise Page Objects
    CommonStepDefinitions commonStepDef = null;
    try {
      driver = SeleniumHelper.openBrowser(rootUrl);
      commonStepDef = new CommonStepDefinitions(driver);
      var echelonLoginPage = new EchelonLoginStepDefinition(driver, pageObjectOfEchelon);
      var echelonHomePage = new EchelonHomeStepDefinition(driver, pageObjectOfEchelon);
      var echelonClientDetailsPage = new EchelonClientDetailsStepDefinition(driver, pageObjectOfEchelon);
      var dataNormalisationHelper = new DataNormalisationHelper();
      HashMap<String, Object> carPolicyDetails = new HashMap<>();

      //Login into Echelon
//      echelonLoginPage.loginToEchelon((Map<String, Object>) controlData.get(USER_CREDENTIALS));

      ///Search for client using policy number
      echelonHomePage.searchForClientPolicy((Map<String, String>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA));

      //Get car policy details from Echelon
      var listOfData = echelonClientDetailsPage.getCarPolicyDetailsInPortalFormat((Map<String,
          String>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA));

      carPolicyDetails.put(CommonStepDefinitions.MOTOR_INSURANCE_INFORMATION, listOfData);
      returnYaml.put(RAW_DATA, carPolicyDetails);
      var normalizedData = dataNormalisationHelper.dataNormalisation(carPolicyDetails);
      returnYaml.put(NORMALIZED_DATA, normalizedData);
      resultsData.put(CAR_POLICY_DETAILS_ECHELON, returnYaml);
      echelonHomePage.signOutEchelonApplication();
      SeleniumHelper.returnWebDriverToBase(driver);
      executionResult = ActivityExecPeriodReturnImpl.completed(uuid, resultsData);
    } catch (Exception customE2eException) {
      actionRecordingService.reportRuntimeFaultIssue(customE2eException);
      executionResult = ActivityExecPeriodReturnImpl.faulted(uuid);
    } finally {
      commonStepDef.quitBrowser();
      actionRecordingService.recordEndOfAnActivityInCaseInstRecord();
    }
    return executionResult;
  }


}

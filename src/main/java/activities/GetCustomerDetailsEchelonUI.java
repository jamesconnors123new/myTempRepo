package activities;

import Generic.customExceptions.CustomE2eException;
import StepDefinitions.EchelonClientDetailsStepDefinition;
import StepDefinitions.EchelonGeneralStepDefinitions;
import StepDefinitions.EchelonHomeStepDefinition;
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
import java.util.*;

/**
 * Pre-requisite steps:
 * 1. Login to Echelon
 * 2. Search for a client using Policy Number
 * 3. Select customer policy from search results
 * 4. Client Summary Page is displayed
 * <p>
 * Customer details returned:
 * - Name
 * - Salutation
 * - Main Address
 * - Gender
 * - Date Of Birth
 * - Age
 * - Mobile Telephone Number
 * - Email Address
 * - Category
 */
public class GetCustomerDetailsEchelonUI extends EchelonLoggedInBase<EchelonVer001> implements ActivityEndpoint {

  public static final String CUSTOMER_DETAILS_ECHELON = "CustomerDetailsOnEchelon";
  public static final String POLICY_NUMBER = "PolicyNumber";
  public static final String RAW_DATA = "RawData";
  public static final String NORMALIZED_DATA = "NormalizedData";

  StandardReportingPatterns actionRecordingService = null;
  ActivityExecPeriodReturn executionResult;

  @Override
  protected WebDriver ProvideWebDriver() throws CustomE2eException {
    return SeleniumHelper.openBrowser();
  }


  @Override
  protected ActivityExecPeriodReturn performActionLoggedIntoEchelon(PageObjects.EchelonModel.Root pageObjectOfEchelon, Browser<PageObjects.EchelonModel.Root, EchelonGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) throws CustomE2eException {

    Map<String, Object> resultsData = new HashMap<>();
    Map<String, Object> returnYaml = new HashMap<>();

    actionRecordingService = new StandardReportingPatterns(sequencerFaceToActivity);
    String strLogLine = getClass().getSimpleName() + " Activity.execute";
    actionRecordingService.recordStartOfAnActivityInCaseInstRecord(strLogLine);

    EchelonGeneralStepDefinitions echelonGeneralStepDefinitions = null;
    try {
      echelonGeneralStepDefinitions = new EchelonGeneralStepDefinitions(pBrowser.Wd(),
          pageObjectOfEchelon);
      var echelonHomePage = new EchelonHomeStepDefinition(pBrowser.Wd(), pageObjectOfEchelon);
      var echelonClientDetailsPage = new EchelonClientDetailsStepDefinition(pBrowser.Wd(),
          pageObjectOfEchelon);

      //Search for client using policy number
      echelonHomePage.searchForClientPolicy((Map<String, String>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA));
      echelonGeneralStepDefinitions.selectClient();
      echelonClientDetailsPage.redirectToPolicyDetails((Map<String, String>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA));
      String policyId = echelonClientDetailsPage.getHomePolicyNumber();
      Map<String, Object> customerDetails = echelonClientDetailsPage.getCustomerDetails();

      Map<String, Object> normalizedCustData = new HashMap<>();
      normalizedCustData.put(CommonControlDataDefns.CUSTOMER_PERSONAL_DET, customerDetails);

      ArrayList<TreeMap<String, Object>> homeInsurancePolicy = new ArrayList<>();
      var homeInsurance = new TreeMap<String, Object>();

      homeInsurance.put(policyId, customerDetails);
      homeInsurancePolicy.add(homeInsurance);
      var insuranceDet = new TreeMap<String, Object>();
      insuranceDet.put(EchelonGeneralStepDefinitions.HOME_INSURANCE_VAR, homeInsurancePolicy);
      returnYaml.put(NORMALIZED_DATA, insuranceDet);
      //Return my customer details in map to execution yaml file
      //returnYaml.put(CUSTOMER_DETAILS, myDetails);
      resultsData.put(CUSTOMER_DETAILS_ECHELON, returnYaml);
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

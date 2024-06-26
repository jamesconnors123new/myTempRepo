package activities;

import Generic.customExceptions.CustomE2eException;
import PageObjects.EchelonModel.Root;
import StepDefinitions.EchelonClientDetailsStepDefinition;
import StepDefinitions.EchelonGeneralStepDefinitions;
import StepDefinitions.EchelonHomeStepDefinition;
import StepDefinitions.EchelonLoginStepDefinition;
import UiWrappers.Browser;
import UiWrappers.Echelon.Site.EchelonVer001;
import activities.bases.EchelonLoggedInBase;
import helpers.ControlDataHelpers;
import helpers.DataNormalisationHelper;
import helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import sqc.bstof.skeleton.ActivityEndpoint;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;
import sqc.bstof.skeletonhelp.StandardReportingPatterns;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GetPolicyDetailsEchelonUI extends EchelonLoggedInBase<EchelonVer001> implements ActivityEndpoint {

  public static final String CUSTOMER_DETAILS_ECHELON = "CustomerPolicyDetailOnEchelon";

  public static final String POLICY_NUMBER = "PolicyNumber";
  public static final String RAW_DATA = "RawData";
  public static final String NORMALIZED_DATA = "NormalizedData";
  public static final String CUSTOMER_POLICY_DETAILS = "CustomerPolicyDetailOnEchelon";
  public static final String POLICY_STATUS_DATE = "AsOfDate";

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
    var dataNorm = new DataNormalisationHelper();

    try {
      echelonGeneralStepDefinitions = new EchelonGeneralStepDefinitions(pBrowser.Wd(),
          pageObjectOfEchelon);
      var echelonLoginPage = new EchelonLoginStepDefinition(pBrowser.Wd(), pageObjectOfEchelon);
      var echelonHomePage = new EchelonHomeStepDefinition(pBrowser.Wd(), pageObjectOfEchelon);

      var echelonClientDetailsPage = new EchelonClientDetailsStepDefinition(pBrowser.Wd(),
          pageObjectOfEchelon);

      //Search for client using policy number
      echelonHomePage.searchForClientPolicy((Map<String, String>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA));
      echelonGeneralStepDefinitions.selectClient();
      // Determine the date that will be used as the policy status date
      var vPolicyStatusDate = (LocalDate) null;
      if (ControlDataHelpers.ValidateMapContainsNonEmptyStringValueAtPath(controlData,
          POLICY_STATUS_DATE)) {
        try {
          vPolicyStatusDate = LocalDate.parse((String) controlData.get(POLICY_STATUS_DATE),
              DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException pDtpe) {
          throw new CustomE2eException("Invalid data specified as " + POLICY_STATUS_DATE + " for "
              + this.getClass().getName() + "should be dd/MM/yyyy but got: " + controlData.get(POLICY_STATUS_DATE));
        }
      } else {
        vPolicyStatusDate = LocalDate.now();
      }

      //Get customer details from Echelon Client Details page in converted Portal format
      var listOfData = echelonClientDetailsPage.getEchelonPolicyData(vPolicyStatusDate,
          (Map<String, String>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA));
      returnYaml.put(CommonControlDataDefns.RAW_DATA, listOfData);
      var normalizedEchelonData = dataNorm.dataNormalisation(listOfData);
      returnYaml.put(NORMALIZED_DATA, normalizedEchelonData);
      resultsData.put(CUSTOMER_POLICY_DETAILS, returnYaml);
      useActionRecordingService().writeToTestCaseInstanceRecord(getClass().getSimpleName() + " " + "Activity completed");
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


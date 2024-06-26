package activities;


import Generic.customExceptions.CustomE2eException;
import StepDefinitions.PortalGeneralStepDefinitions;
import UiWrappers.Browser;
import UiWrappers.Portal.Site.PortalVer001;
import activities.bases.AgeasPortalLoggedInBase;
import helpers.DataNormalisationHelper;
import helpers.SeleniumHelper;
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

/**
 * Fetching the policy details from portal.
 */
public class GetCarPolicyDetailsPortal extends AgeasPortalLoggedInBase<PortalVer001> implements ActivityEndpoint {
  public static final String MARITAL_STATUS = "MaritalStatus";
  public static final String DATE_OF_BIRTH = "DateOfBirth";
  public static final String EMPLOYMENT_STATUS = "EmploymentStatus";
  public static final String OCCUPATION = "Occupation";
  public static final String SECOND_JOB_OCCUPATION = "SecondJobOccupation";
  public static final String RELATIONSHIP_STATUS = "RelationshipStatus";
  public static final String CUSTOMER_POLICY_DETAILS = "CustomerPolicyDetailOnPortal";
  public static final String RAW_DATA = "RawData";
  public static final String NORMALIZED_DATA = "NormalizedData";

  @Override
  protected WebDriver ProvideWebDriver() throws CustomE2eException {
    return SeleniumHelper.openBrowser();
  }

  @Override
  protected boolean requiresLogin() {
    return true;
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
    Map<String, Object> resultsData = new HashMap<>();
    Map<String, Object> returnYaml = new HashMap<>();

    var dataNorm = new DataNormalisationHelper();
    try {
      var customerDetails = pBrowser.Cs().getFilterBasedData(
          null, (Map<String, Object>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA));
      returnYaml.put(RAW_DATA, customerDetails);
      var vUniversalViewOfHomePolicy = dataNorm.dataNormalisation(customerDetails);
      returnYaml.put(NORMALIZED_DATA,vUniversalViewOfHomePolicy);
      resultsData.put(CUSTOMER_POLICY_DETAILS, returnYaml);
      return ActivityExecPeriodReturnImpl.completed(uuid, resultsData);
    } catch (Exception customE2eException) {
      useActionRecordingService().writeToTestCaseInstanceRecord(getClass().getSimpleName()
          + "Activity failed; \n\n" + customE2eException);
      return ActivityExecPeriodReturnImpl.faulted(uuid);
    }
  }
}


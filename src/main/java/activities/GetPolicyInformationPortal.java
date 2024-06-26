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
public class GetPolicyInformationPortal extends AgeasPortalLoggedInBase<PortalVer001> implements ActivityEndpoint {
  public static final String MARITAL_STATUS = "MaritalStatus";
  public static final String DATE_OF_BIRTH = "DateOfBirth";
  public static final String EMPLOYMENT_DETAILS = "EmploymentDetails";
  public static final String SECOND_JOB_STATUS = "SecondJobStatus";
  public static final String SECOND_JOB_DETAILS = "SecondJobDetails";
  public static final String EMPLOYMENT_STATUS = "EmploymentStatus";
  public static final String OCCUPATION = "Occupation";
  public static final String INDUSTRY_TYPE = "IndustryType";
  public static final String SECOND_JOB_OCCUPATION = "SecondJobOccupation";
  public static final String SECOND_JOB_INDUSTRY_TYPE = "SecondJobIndustry";
  public static final String RELATIONSHIP_STATUS = "RelationshipStatus";

  public static final String MY_COVER = "MyCover";
  public static final String MY_EXCESSES = "Excesses";
  public static final String ENHANCE_COVER = "EnhanceMyCover";
  public static final String CUSTOMER_POLICY_DETAILS = "CustomerPolicyDetailOnPortal";
  public static final String RAW_DATA = "RawData";
  public static final String NORMALIZED_DATA = "NormalizedData";
  // ------------- Car Policy Details ----------------------------//
  public static final String CAR_POLICY_NUMBER = "CarPolicyNumber";
  public static final String NAME = "Name";
  //public static final String MARITAL_STATUS = "MaritalStatus";
  public static final String EMAIL_ADDRESS = "EmailAddress";
  public static final String MOBILE_TELEPHONE_NUMBER = "MobileTelephoneNumber";
  public static final String ADDRESS = "Address";

  public static final String DRIVING_LICENSE_TYPE = "DrivingLicenseType";
  public static final String YEARS_NO_CLAIMS_DISCOUNT = "YearsNoClaimsDiscount";
  public static final String JOINT_POLICY_HOLDER_NAME = "JointPolicyHolderName";

  public static final String CAR_MAKE = "CarMake";
  public static final String CAR_MODEL = "CarModel";
  public static final String YEAR_OF_MAKE = "YearOfMake";
  public static final String TRANSMISSION = "Transmission";
  public static final String FUEL_TYPE = "FuelType";
  public static final String CURRENT_MARKET_VALUE = "CurrentMarketValue";
  public static final String CAR_OWNER = "CarOwner";
  public static final String REGISTERED_KEEPER = "RegisteredKeeper";
  public static final String CAR_LOCATION_OVERNIGHT = "CarLocationOvernight";
  public static final String CLASS_OF_USE = "ClassOfUse";
  public static final String CHANGES_EFFECTIVE_DATE = "ChangesEffectiveDate";
  public static final String ANNUAL_MILEAGE = "AnnualMileage";

  public static final String LEVEL_OF_VOLUNTARY_EXCESS = "LevelOfVoluntaryExcess";
  public static final String COMPULSORY = "Compulsory";

  //-------------- Additional Driver --------------------

  public static final String AD_NAME = "AdditionalDriverName";
  public static final String AD_GENDER = "AdditionalDriverGender";
  public static final String AD_DATE_OF_BIRTH = "AdditionalDriverDateOfBirth";
  public static final String AD_AGE = "AdditionalDriverAge";
  public static final String AD_FULL_TIME_OCCUPATION = "AdditionalDriverFullTimeOccupation";
  public static final String AD_PART_TIME_OCCUPATION = "AdditionalDriverPartTimeOccupation";
  public static final String AD_LICENSE_TYPE = "AdditionalDriverLicenseType";
  public static final String AD_LICENSE_DATE = "AdditionalDriverLicenseDate";
  public static final String AD_ACCESS_TO_VEHICLES = "AdditionalDriverAccessToVehicles";
  public static final String AD_RELATIONSHIP_TO_PROPOSER = "AdditionalDriverRelationshipToProposer";
  public static final String AD_MARITAL_STATUS = "AdditionalDriverMaritalStatus";
  public static final String AD_DATE_OF_RESIDENCY = "AdditionalDriverDateOfResidency";
  public static final String AD_VEHICLE_USE = "AdditionalDriverVehicleUse";
  public static final String AD_INSURANCE_PREVIOUSLY_REFUSED =
      "AdditionalDriverInsurancePreviouslyRefused";

  // ----------------------------------------------------

  @Override
  protected WebDriver ProvideWebDriver() throws CustomE2eException {
    return SeleniumHelper.openBrowser();
  }

  @Override
  protected boolean requiresLogin() {
    return true;
  }

  @Override
  public ActivityExecPeriodReturn performActionLoggedIntoPortal(PageObjects.PortalModel.Root pageObjectOfPortal, Browser<PageObjects.PortalModel.Root, PortalGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) {
    Map<String, Object> resultsData = new HashMap<>();
    Map<String, Object> returnYaml = new HashMap<>();

    var dataNorm = new DataNormalisationHelper();
    try {
      var customerDetails = pBrowser.Cs().getFilterBasedData(null,
          (Map<String, Object>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA));
      returnYaml.put(RAW_DATA, customerDetails);
      var vUniversalViewOfHomePolicy = dataNorm.dataNormalisation(customerDetails);
      returnYaml.put(NORMALIZED_DATA, vUniversalViewOfHomePolicy);
      resultsData.put(CUSTOMER_POLICY_DETAILS, returnYaml);
      return ActivityExecPeriodReturnImpl.completed(uuid, resultsData);
    } catch (Exception customE2eException) {
      useActionRecordingService().writeToTestCaseInstanceRecord(getClass().getSimpleName() +
          "Activity failed; \n\n" + customE2eException);
      //CommonHelper.saveScreenshot("/"+Utils);
      return ActivityExecPeriodReturnImpl.faulted(uuid);
    }
  }
}


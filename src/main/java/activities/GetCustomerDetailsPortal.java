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


public class GetCustomerDetailsPortal extends AgeasPortalLoggedInBase<PortalVer001> implements ActivityEndpoint {

  public static final String COVER_DETAILS = "MyCover";
  public static final String EXCESS_DETAILS = "Excesses";

  public static final String RAW_DATA = "RawData";
  public static final String NORMALIZED_DATA = "NormalizedData";
  public static final String CUSTOMER_DETAILS_PORTAL = "CustomerDetailsOnPortal";
  public static final String TITLE = "Title";
  public static final String NAME = "Name";
  public static final String LAST_NAME = "LastName";
  public static final String EMAIL_ADDRESS = "Email address";
  public static final String PHONE_NUMBER = "Phone number";
  public static final String DATE_OF_BIRTH = "Date of birth";
  public static final String EMPLOYMENT_STATUS = "Employment Status";
  public static final String RELATIONSHIP_STATUS = "Relationship status";
  public static final String DRIVING_LICENSE_TYPE = "Driving license type";
  public static final String YEAR_NCD = "Years no claims discount";
  public static final String INSURED_ADD = "Insured address";
  public static final String CORRESPONDENCE_ADD = "Correspondence address";
  public static final String MY_DETAILS = "MyDetails";

  public static final String OWNERSHIP = "Ownership";
  public static final String MAIN_ADDRESS = "Address";
  public static final String PROPERTY_TYPE = "PropertyType";
  public static final String CORRESPONDENCE_ADDRESS = "CorrespondenceAddress";
  public static final String OCCUPATION = "Occupation";
  public static final String INSURED_ADDRESS = "InsuredAddress";
  public static final String BEDROOMS = "Bedrooms";
  public static final String BATHROOMS= "Bathrooms";
  //public static final String JOINT_POLICY_HOLDER = "JointPolicyHolder";

  public static final String BUILDINGS = "Buildings";
  public static final String TYPE = "Type";
  public static final String REBUILD_COST = "BuildingRebuildCost";
  public static final String FLOOD = "Flood";
  public static final String LEVEL_OF_VOLUNTARY_EXCESS = "LevelOfVoluntaryExcess";
  public static final String ESCAPE_OF_WATER_EXCESS = "LeakingFreezing";
  public static final String SUBSIDENCE_COMPULSORY_EXCESS = "SubsidenceGroundHeaveLandslip";

  public static final String ADDITIONAL_COVER_DETAILS = "AdditionalCoverDetails";
  public static final String HOME_EXTENSION_DETAILS = "ExtensionDetails";
  public static final String HOME_LISTING_DETAILS = "ListingDetails";
  public static final String HOME_OCCUPIED_DETAILS = "OccupiedDetails";
  public static final String HOME_LOCKING_DETAILS = "LockingDetails";
  public static final String HOME_OWN_RENT_DETAILS = "OwnRentDetails";
  public static final String HOME_BUILT_DETAILS = "BuiltDetails";
  public static final String HOME_ROOF_DETAILS = "RoofDetails";
  public static final String HOME_USE_DETAILS = "UseDetails";
  public static final String HOME_BEST_DESCRIBE = "BestDescribe";
  public static final String HOME_INTRUDER_ALARM_DETAILS = "IntruderAlarmDetails";
  public static final String HOME_WALL_OF_DETAILS = "WallMadeOfDetails";
  public static final String HOME_ROOF_MADE_OF_DETAILS = "RoofMadeOfDetails";
  public static final String HOME_NUMBER_OF_ADULT_DETAILS = "NumberOfAdultDetails";
  public static final String HOME_NUMBER_OF_CHILD_DETAILS = "NumberOfChildDetails";
  public static final String HOME_PAYING_GUEST_DETAILS = "PayingGuestDetails";
  public static final String HOME_PET_DETAILS = "PetDetails";
  public static final String HOME_CLERICAL_USE_DETAILS = "ClericalUseDetails";

  @Override
  protected WebDriver ProvideWebDriver() throws CustomE2eException {
    return SeleniumHelper.openBrowser();
  }


  @Override
  protected boolean requiresLogin() {
    return true;
  }

  @Override
  public ActivityExecPeriodReturn performActionLoggedIntoPortal(PageObjects.PortalModel.Root pageObjectOfPortal, Browser<PageObjects.PortalModel.Root, PortalGeneralStepDefinitions> pBrowser,
                                                                SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) {

    Map<String, Object> resultsData = new HashMap<>();
    Map<String, Object> returnYaml = new HashMap<>();
    try {
      var dataNormalisationHelper = new DataNormalisationHelper();
      Map<String, Object> myDetails = pBrowser.Cs().getFilterBasedData(MY_DETAILS, (Map<String,
          Object>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA));  //Fetching customer
      returnYaml.put(RAW_DATA, myDetails); // details from portal
      var normalizedData = dataNormalisationHelper.dataNormalisation(myDetails);

      returnYaml.put(NORMALIZED_DATA, normalizedData);
      resultsData.put(CUSTOMER_DETAILS_PORTAL, returnYaml);
      return ActivityExecPeriodReturnImpl.completed(uuid, resultsData);
    } catch (Exception customE2eException) {
      useActionRecordingService().reportRuntimeFaultIssue(customE2eException);
      return ActivityExecPeriodReturnImpl.faulted(uuid);
    }
  }
}

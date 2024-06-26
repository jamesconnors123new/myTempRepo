package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import UiWrappers.Browser;
import activities.CommonControlDataDefns;
import activities.GetCustomerDetailsPortal;
import activities.GetPolicyInformationPortal;
import helpers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

//import static activities.CommonControlDataDefns.*;

public class PortalGeneralStepDefinitions extends AgeasDigitalReactPortalHelpers {


  public static final String REQUIRED_BUILDING_ACCIDENTAL_DAMAGE_COVER =
      "DoYouRequireBuildingsAccidentalDamageCover?";
  public static final String BUILDING_EXCESS_VAR =
      "WhatLevelOfBuildingsVoluntaryExcessDoYouRequire?";
  public static final String CONTENT_EXCESS_VAR = "WhatLevelOfContentsVoluntaryExcessDoYouRequire?";
  public static final String HELD_CONTENT_INSURANCE_VAR =
      "HaveYouHeldContentsInsuranceWithinTheLast2Years?";
  public static final String INSURE_HOUSEHOLD_CONTENT_VAR =
      "HowMuchWouldYouLikeToInsureYourHouseholdContentsFor?";
  public static final String CONTENT_ACCIDENTAL_DAMAGE_COVER_VAR =
      "DoYouRequireContentsAccidentalDamageCover?";
  public static final String VALUABLE_IN_HOME_VAR = "DoYouHaveAnyValuablesOver£2," +
      "000ThatYouDon'tTakeOutsideOfTheHome?";
  public static final String POLICY_BALANCE = "PolicyBalance";

  public static final String JPH_PRESENT_FLAG = "JointPolicyHolderFlag";
  public static final String JPH_DETAILS = "JointPolicyHolderDetails";
  public static final String ADDITIONAL_COVER_DETAILS = "AdditionalCoverDetails";
  public static final String INSURED_HOUSE_HOLD_CONTENT_DETAILS = "InsuredHouseHoldContentDetails";
  public static final String ADDITIONAL_DRIVER_DETAILS = "AdditionalDriverDetails";
  public static final String SEARCH_BY_POLICY_NUMBER = "PolicyNumber";
  public static final String POLICY_START_DATE = "PolicyStartDate";
  public static final String POLICY_END_DATE = "PolicyEndDate";
  public static final String POLICY_EXPIRES_IN = "PolicyExpiresIn";
  public static final String EARLIEST_ALLOWED_MTA_DATE = "EarliestAllowedMtaDate";

  public static final String INSURANCE_TYPE = "InsuranceType";

  public static final String OCCUPATION = "Occupation";
  //  public static final String JPH = "Joint policy holder";
  public static final String PROPERTY_TYPE = "Property type";
  public static final String BEDROOMS = "Bedrooms";
  public static final String BATHROOMS = "Bathrooms";
  public static final String YEAR_BUILT = "Year built";
  public static final String OWNERSHIP = "Ownership";


  //HOME COVER
  public static final String COVER_TYPE = "CoverType";
  public static final String TYPE = "Type";

  public static final String BUILDINGS_COVER_AMOUNT = "Buildings (including accidental damage)";
  public static final String CONTENTS_COVER_AMOUNT = "Contents (including accidental damage)";
  public static final String BUILDINGS_MY_COVER = "Buildings";
  public static final String CONTENTS_MY_COVER = "Contents";
  //EXCESS
  public static final String COMPULSORY_EXCESS_BUILDINGS = "Buildings";
  public static final String COMPULSORY_EXCESS_BUILDINGS_VAR = "BuildingsCompulsoryExcess";
  public static final String COMPULSORY_EXCESS_CONTENT = "Contents";
  public static final String COMPULSORY_EXCESS_CONTENT_VAR = "ContentsCompulsoryExcess";
  public static final String SUBSIDENCE_GROUND_LANDSLIP = "Subsidence, Ground Heave and Landslip";
  public static final String SUBSIDENCE_GROUND_LANDSLIP_VAR = "SubsidenceGroundHeaveLandslip";
  public static final String LEAKING_FREEZING = "Leaking or freezing of water or Leaking oil";
  public static final String MOD_LEAKING_FREEZING = "LeakingFreezing";
  public static final String FLOOD = "Flood";
  //ENHANCE_COVER
  public static final String EXCESS_PROTECTION = "Excess Protection";
  public static final String LEGAL_EXP = "Legal Expenses";
  public static final String EXTRA_HOME_EMERGENCY = "Ageas Extra Home Emergency";
  public static final String HOME_EMERGENCY = "Home Emergency";
  public static final String EXCESS_PROTECTION_SUBSIDENCE = "Home Excess Protection Subsidence";
  public static final String EXCESS_PROTECT_SUBSIDENCE = "Excess Protect with subsidence";


  public static final String KEY_PROTECTION = "Key Protection";
  public static final String BREAKDOWN_COVER = "Breakdown Cover";
  public static final String REPLACEMENT_VEHICLE = "Replacement Vehicle";


  //Van MY COVER
  public static final String VEHICLE_TYPE = "VehicleType";
  public static final String CAR_MAKE = "Car Make";
  public static final String CAR_MODEL = "Car Model";
  public static final String YEAR_REG = "Year Registered";
  public static final String YEAR_MANUFACTURE = "YearManufacture";
  public static final String REGISTRATION_NUMBER = "RegistrationNumber";
  public static final String TRANSMISSION = "Transmission";
  public static final String CAR_ALARM_TYPE = "CarAlarmType";
  public static final String LEFT_HAND_DRIVER = "LeftHandDrive";
  public static final String FUEL_TYPE = "Fuel Type";
  public static final String EST_VALUE = "Estimated Value";
  public static final String CAR_OWNER = "Car Owner";
  public static final String REG_KEEPER = "Registered Keeper";
  public static final String ANNUAL_MILEAGE = "Annual Mileage";
  public static final String CAR_LOC_OVERNIGHT = "Car Location Overnight";
  public static final String CLASS_USE = "Class of Use";
  public static final String EFFECTIVE_DATE = "Changes effective date";

  //EXCESS
  public static final String VOLUNTARY = "Voluntary";
  public static final String COMPULSORY = "Compulsory";


  public static final String ENHANCE_COVER_DET = "EnhanceCoverDetails";

  public static final String PAGE_HEADING = "PageHeading";
  public static final String CURRENT_URL = "CurrentUrl";
  public static final String FAILED_MESSAGE = "Failed to execute %s. User is not on expected page";


  public static final String BUILDING_VOLUNTARY_EXCESS = "BuildingVoluntaryExcess";
  public static final String CONTENT_VOLUNTARY_EXCESS = "ContentVoluntaryExcess";
  public static final String CONTENT_INSURANCE_HELD = "ContentInsuranceHeld";
  public static final String BUILDING_INSURANCE_HELD = "BuildingInsuranceHeld";

  public static final String VALUABLE_OVER_2000£ = "ValuableOver2000£";
  public static final String VALUABLE_ITEMS = "ValuableItems";

  public static final String PERSONAL_BELONGING_AWAY_FROM_HOME = "PersonalBelongingAwayFromHome";
  public static final String PERSONAL_BELONGING_AWAY_FROM_HOME_VAR =
      "WouldYouLikeExtraCoverForPersonalBelongingsAwayFromTheHome?";
  public static final String PERSONAL_BELONGING_AWAY_FROM_HOME_COST_VAR =
      "HowMuchCoverWouldYouLikeForPersonalBelongingsAwayFromTheHome?";
  public static final String PERSONAL_BELONGING_AWAY_FROM_HOME_COST =
      "PersonalBelongingAwayFromHomeCost";

  public static final String INDIVIDUAL_ITEM_COVER = "IndividualItemCover";
  public static final String INDIVIDUAL_ITEM = "IndividualItem";

  public static final String NUMBER_OF_CHILDREN = "NumberOfChildren";

  public static final String PET_DETAILS = "PetDetails";


  public static final String YES = "Yes";
  public static final String NO = "No";


  private final WebDriver driver;
  private final SeleniumHelper SeleniumHelper;
  private final long waitDuration = 60000L;

  private final JointPolicyHolderStepDefinition JointPolicyHolderPage;
  private final CommonControlDataDefns commonControlDataDefns;


  public PortalGeneralStepDefinitions(WebDriver driver,
                                      PageObjects.PortalModel.Root pageObjectOfPortal) {
    super(driver, pageObjectOfPortal);
    this.driver = driver;
    this.SeleniumHelper = new SeleniumHelper(this.driver);
    this.JointPolicyHolderPage = new JointPolicyHolderStepDefinition(this.driver,
        pageObjectOfPortal);
    this.commonControlDataDefns = new CommonControlDataDefns();
  }


  public String getSystemDataOrTime(String dateTimePattern) {
    LocalDateTime currentTime = LocalDateTime.now();
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(dateTimePattern);
    return timeFormatter.format(currentTime);
  }

  public void switchToInsuranceTab(String insuranceType) throws CustomE2eException {
    switch (insuranceType) {
      case CommonControlDataDefns.HOME_INSURANCE_INFORMATION:
      case EisGeneralStepDefinitions.PROD_TYPE_HOME_VAR:
        redirectToHomeTab();
        break;
      case CommonControlDataDefns.MOTOR_INSURANCE_INFORMATION:
      case EisGeneralStepDefinitions.PROD_TYPE_MOTOR_VAR:
        redirectToCarTab();
        break;
      case CommonControlDataDefns.VAN_INSURANCE_INFORMATION:
      case EisGeneralStepDefinitions.PROD_TYPE_VAN_VAR:
        redirectToVanTab();
        break;
      default:
    }
  }

  public void acceptCookieBtn() throws CustomE2eException {
    waitForPageLoad();
    if (waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().ACCEPT_COOKIE_BTN()
        , SyncType.CLICKABLE, 20L)) {
      clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalSharedLocatorModel().ACCEPT_COOKIE_BTN(), SyncType.CLICKABLE);
    }
  }


//  public void signOutApplication() throws CustomE2eException {
//    try {
//      //waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().SIGN_OUT_BUTTON(), SyncType.CLICKABLE, waitDuration);
//      //if (isElementVisible(this.pageObjectOfPortal.getPortalSharedLocatorModel().SIGN_OUT_BUTTON())) {
//        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(120), () -> clickElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().SIGN_OUT_BUTTON(),
//                SyncType.CLICKABLE));
//
//        //waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().ACCEPT_SIGNOUT(), SyncType.CLICKABLE, waitDuration);
//        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(120), () -> clickElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().ACCEPT_SIGNOUT(),
//        SyncType.CLICKABLE));
//        //clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalSharedLocatorModel().ACCEPT_SIGNOUT(),SyncType.CLICKABLE);
//      //}
//         PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(120), () -> waitForElement2(this.pageObjectOfPortal.getPortalLoginLocatorModel().LOG_IN_BTN(), SyncType.CLICKABLE, waitDuration));
//
//  } catch (Exception e) {
//    throw new CustomE2eException(e.getMessage());
//
//  }
//
//  }
//



  public void continueButton() throws CustomE2eException {
    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CONTINUE_BUTTON(), SyncType.CLICKABLE);
  }

  public void payButton() throws CustomE2eException {
    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PAY_BUTTON(), SyncType.CLICKABLE);
  }

  public SortedMap<String, Object> getDetails(By myDetailsFieldNameAndValue) throws CustomE2eException {
    var MyDetails = new TreeMap<String, Object>();
    try {
      waitForElement2(myDetailsFieldNameAndValue, SyncType.VISIBLE, waitDuration);
      var listOfValues = getTextAllWebElementMatchingLocator(myDetailsFieldNameAndValue);
      for (int valueCounter = 0; valueCounter < listOfValues.size(); ) {
        String key =
            Formatting.capitalizeAllFirstCapitalizeRemoveSpace(listOfValues.get(valueCounter++));
        var value = listOfValues.get(valueCounter++);
        MyDetails.put(key, value);
      }
    } catch (CustomE2eException ex) {
      throw new CustomE2eException(ex.getMessage());
    }
    return MyDetails;
  }


  public Map<String, Object> getFilterBasedData(String sectionDetails,
                                                Map<String, Object> searchCriteria) throws CustomE2eException, ParseException {
    String filterValue = null;
    String filterCriteria = null;
    Map<String, Object> data = new HashMap<>();
    List<String> normalizeFilterValue;
    switch (searchCriteria.entrySet().stream().findFirst().get().getKey()) {
      case SEARCH_BY_POLICY_NUMBER:
        filterValue = (String) searchCriteria.get(SEARCH_BY_POLICY_NUMBER);
        filterCriteria = SEARCH_BY_POLICY_NUMBER;
        normalizeFilterValue = Formatting.getValuesInList(filterValue, ",");
        List<String> policyNumTrimmed =
            normalizeFilterValue.stream().map(String::trim).collect(Collectors.toList());
        data = getDataBasedOnPolicyNumber(sectionDetails, (ArrayList<String>) policyNumTrimmed,
            filterCriteria);
        break;
      case POLICY_START_DATE:
        filterValue = (String) searchCriteria.get(POLICY_START_DATE);
        filterCriteria = POLICY_START_DATE;
        normalizeFilterValue = new ArrayList<>();
        normalizeFilterValue = Formatting.getValuesInList(filterValue, ",");
        List<String> policyStartDateTrimmed =
            normalizeFilterValue.stream().map(String::trim).collect(Collectors.toList());
        data = getDataBasedOnPolicyDate(sectionDetails,
            (ArrayList<String>) policyStartDateTrimmed, filterCriteria);
        break;
      case POLICY_END_DATE:
        filterValue = (String) searchCriteria.get(POLICY_END_DATE);
        filterCriteria = POLICY_END_DATE;
        normalizeFilterValue = new ArrayList<>();
        normalizeFilterValue = Formatting.getValuesInList(filterValue, ",");
        List<String> policyEndDateTrimmed =
            normalizeFilterValue.stream().map(String::trim).collect(Collectors.toList());
        data = getDataBasedOnPolicyDate(sectionDetails, (ArrayList<String>) policyEndDateTrimmed,
            filterCriteria);
        break;
      case INSURANCE_TYPE:
        filterValue = (String) searchCriteria.get(INSURANCE_TYPE);
        filterCriteria = INSURANCE_TYPE;
//        normalizeFilterValue = new ArrayList<>();
        normalizeFilterValue = Formatting.getValuesInList(filterValue, ",");
        List<String> insuranceTypeTrimmed =
            normalizeFilterValue.stream().map(String::trim).collect(Collectors.toList());
        data = getDataBasedOnInsuranceType(sectionDetails,
            (ArrayList<String>) insuranceTypeTrimmed, filterCriteria);
        //var details = jointPolicyHolder.getJointPolicyHolderInformationFromUi();
        break;
      default:
    }
    return data;
  }

  private Map<String, Object> getDataBasedOnPolicyDate(String section,
                                                       ArrayList<String> filterValue,
                                                       String filterCriteria) {
    Map<String, Object> data = new HashMap<>();
    // In complete
    return data;
  }

  public void checkForPageUsingBy(String expectedHeading, String expectedUrl, By headingLocator) throws CustomE2eException {
    var callerMethod = Thread.currentThread().getStackTrace()[2].getMethodName();
    var details = getTitleAndUrl(headingLocator);
    String pageHeading = (String) details.get(PAGE_HEADING);
    String currentUrl = (String) details.get(CURRENT_URL);
    String urlErrorMessage = String.format(FAILED_MESSAGE + "\n Expected url :%s, \n Current " +
        "url:" + " %s", callerMethod, expectedUrl, currentUrl);
    String headingErrorMessage = String.format(FAILED_MESSAGE + "\n Expected url :%s, \n Current "
        + "url: %s", callerMethod, expectedHeading, pageHeading);

    if (!pageHeading.toLowerCase().contains(expectedHeading.toLowerCase()) || !currentUrl.contains(expectedUrl)) {
      String errorMessage = String.format("User is not on expected page. %s and %s",
          urlErrorMessage, headingErrorMessage);
      throw new CustomE2eException(errorMessage);
    }
    String successMessage = String.format("%s executed sucessfully.", callerMethod);
  }

  private Map<String, Object> getTitleAndUrl(By headingLocator) throws CustomE2eException {
    HashMap<String, Object> details = new HashMap<>();
    String actualHeading;
    String actualUrl;
    actualHeading = getText(headingLocator);
    actualUrl = getCurrentUrl();
    details.put(PAGE_HEADING, actualHeading);
    details.put(CURRENT_URL, actualUrl);
    return details;
  }

  private Map<String, Object> getDataBasedOnPolicyNumber(String section,
                                                         ArrayList<String> filterValue,
                                                         String filterCriteria) throws CustomE2eException, ParseException {
    var vSourceViewOfHomePolicy = new TreeMap<String, Object>();
    var motorDetails = new TreeMap<String, Object>();
    var vanDetails = new TreeMap<String, Object>();
    boolean policyFound = false;
    var detail = new TreeMap<String, Object>();
    ArrayList<String> listOfPolicies;
    ArrayList<String> insuranceTabSearch = new ArrayList<>();

    if (!filterValue.isEmpty()) {
      Collections.sort(filterValue);
      for (var policyNum : filterValue) {
        if (policyNum.startsWith("GD")) {
          insuranceTabSearch.add(commonControlDataDefns.MOTOR_INSURANCE_INFORMATION);
        } else if (policyNum.startsWith("HE")||policyNum.startsWith("HH")) {
          insuranceTabSearch.add(commonControlDataDefns.HOME_INSURANCE_INFORMATION);
        } else if (policyNum.startsWith("MM")) {
          insuranceTabSearch.add(commonControlDataDefns.VAN_INSURANCE_INFORMATION);
        }
      }
    } else {
      filterValue.add("ALL");
      insuranceTabSearch.add(commonControlDataDefns.MOTOR_INSURANCE_INFORMATION);
      insuranceTabSearch.add(commonControlDataDefns.HOME_INSURANCE_INFORMATION);
      insuranceTabSearch.add(commonControlDataDefns.VAN_INSURANCE_INFORMATION);
    }

    for (var insuranceTab : insuranceTabSearch) {
      if (insuranceTab.contains(commonControlDataDefns.HOME_INSURANCE_INFORMATION) && isElementVisible(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_HOME_TAB())) {
        var homeDetails = new TreeMap<String, Object>();
        switchToInsuranceTab(commonControlDataDefns.HOME_INSURANCE_INFORMATION);
        listOfPolicies = (ArrayList<String>) getListOfPolicies(filterValue);
        try {
          for (var policyNum : listOfPolicies) {
            try {
              PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(40),
                  () -> switchToPolicy(policyNum, filterCriteria,
                      commonControlDataDefns.HOME_INSURANCE_INFORMATION));
              homeDetails = (TreeMap<String, Object>) fetchDetailsFromUiPolicyDetails(section);
              vSourceViewOfHomePolicy.put(CommonControlDataDefns.TYPE_VAR,
                  ((Map) homeDetails.get(GetPolicyInformationPortal.MY_COVER)).get(CommonControlDataDefns.TYPE_VAR));
              vSourceViewOfHomePolicy.put(CommonControlDataDefns.POLICY_ID, policyNum);
              //vSourceViewOfHomePolicy.put(CUSTOMER_DETAILS, homeDetails);
//              filterValue.remove(String.valueOf(policyNum));
            } catch (Exception e) {
              throw new CustomE2eException(e.getCause().toString());
            }
          }
        } catch (ConcurrentModificationException ex) {

        }
        try{
        var excesses = new TreeMap<String, Object>();

        excesses.putAll((Map<String, Object>) homeDetails.get(CommonControlDataDefns.EXCESSES));
        excesses.putAll((Map<String, Object>) homeDetails.get(CommonControlDataDefns.ENHANCE_EXCESS_DETAILS));

        var normExcess = normalizeExcess(excesses);
        vSourceViewOfHomePolicy.put(CommonControlDataDefns.EXCESS_VAR, normExcess);

        vSourceViewOfHomePolicy.put(POLICY_START_DATE, RetryOnException("Text of " +
            "POLICY_START_DATE", CustomE2eException.class, 500L, 10,
            () -> getText(this.pageObjectOfPortal.getDashboardLocatorModel().HOME_POLICY_START_DATE())));
        vSourceViewOfHomePolicy.put(POLICY_END_DATE, RetryOnException("Text of POLICY_END_DATE",
            CustomE2eException.class, 500L, 10,
            () -> getText(this.pageObjectOfPortal.getDashboardLocatorModel().HOME_POLICY_END_DATE())));
        vSourceViewOfHomePolicy.put(CommonControlDataDefns.POLICY_PERIOD, getPolicyExpiresInDays());
        var effectiveDate =
            getEffectiveDate(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CHANGE_TEXT());
        CommonHelper.extractDateFromString(LocalDate.now(), effectiveDate);
        Double premiumAmount = getPremiumAmount();
        vSourceViewOfHomePolicy.put(CommonControlDataDefns.ADDITIONAL_PREMIUM, premiumAmount);
        vSourceViewOfHomePolicy.put(JPH_DETAILS,
            Optional.ofNullable(JointPolicyHolderPage.getJointPolicyHolderInformationFromUi()).orElse(null));
        vSourceViewOfHomePolicy.put(CommonControlDataDefns.JOINT_POLICY_HOLDER_FLAG,
            (vSourceViewOfHomePolicy.get(JPH_DETAILS) != null) ? true : false);


        var employmentDet = getEmploymentDetails();
        var insuredAddress = getInsureHouseDetails(); //Needs Improvements

        var homeDetailsCustomerDet =
            (Map<String, Object>) homeDetails.get(CommonControlDataDefns.CUSTOMER_DETAILS);

        insuredAddress.put(CommonControlDataDefns.NUM_OF_BEDROOM,
            Integer.parseInt(String.valueOf(homeDetailsCustomerDet.get(CommonControlDataDefns.NUM_OF_BEDROOM_VAR))));
        (homeDetailsCustomerDet).remove(CommonControlDataDefns.NUM_OF_BEDROOM_VAR);

        insuredAddress.put(CommonControlDataDefns.NUM_OF_BATHROOM,
            Integer.parseInt(String.valueOf(homeDetailsCustomerDet.get(CommonControlDataDefns.NUM_OF_BATHROOMS_VAR))));
        (homeDetailsCustomerDet).remove(CommonControlDataDefns.NUM_OF_BATHROOMS_VAR);

        insuredAddress.put(CommonControlDataDefns.OWNERSHIP_TYPE,
            homeDetailsCustomerDet.get(CommonControlDataDefns.OWNERSHIP_VAR));
        (homeDetailsCustomerDet).remove(CommonControlDataDefns.OWNERSHIP_VAR);

        insuredAddress.put(CommonControlDataDefns.BUILDING_TYPE,
            homeDetailsCustomerDet.get(CommonControlDataDefns.PROPERTY_TYPE));
        (homeDetailsCustomerDet).remove(CommonControlDataDefns.PROPERTY_TYPE);

        insuredAddress.put(CommonControlDataDefns.YEAR_BUILT_VAR,
            homeDetailsCustomerDet.get(CommonControlDataDefns.YEAR_BUILT_VAR));
        (homeDetailsCustomerDet).remove(CommonControlDataDefns.YEAR_BUILT_VAR);
        insuredAddress.put(CommonControlDataDefns.RISK_ADDRESS,
            homeDetailsCustomerDet.get(CommonControlDataDefns.INSURED_ADDRESS));
        homeDetailsCustomerDet.remove(CommonControlDataDefns.INSURED_ADDRESS);

        vSourceViewOfHomePolicy.put(CommonControlDataDefns.INSURED_HOME_SPECIFIC_DETAILS,
            insuredAddress);

        var customerPersonalDetails = new TreeMap<String, Object>();
        customerPersonalDetails.put(CommonControlDataDefns.EMPLOYMENT_DET, employmentDet);
        homeDetailsCustomerDet.remove(CommonControlDataDefns.OCCUPATION);
        homeDetailsCustomerDet.remove(CommonControlDataDefns.EMPLOYMENT_STATUS);

        customerPersonalDetails.put(CommonControlDataDefns.TITLE,
            homeDetailsCustomerDet.get(CommonControlDataDefns.NAME).toString().split(" ")[0]);

        customerPersonalDetails.put(CommonControlDataDefns.FIRST_NAME,
            homeDetailsCustomerDet.get(CommonControlDataDefns.NAME).toString().split(" ")[1]);

        customerPersonalDetails.put(CommonControlDataDefns.LAST_NAME,
            homeDetailsCustomerDet.get(CommonControlDataDefns.NAME).toString().split(" ")[2]);
        homeDetailsCustomerDet.remove(CommonControlDataDefns.NAME);
        customerPersonalDetails.put(CommonControlDataDefns.DATE_OF_BIRTH,
            Formatting.changeDateFormatIntoExpected((String) homeDetailsCustomerDet.get(CommonControlDataDefns.DATE_OF_BIRTH), "dd MMM yyyy", "dd/MM/yyyy"));
        homeDetailsCustomerDet.remove(CommonControlDataDefns.DATE_OF_BIRTH);
        customerPersonalDetails.put(CommonControlDataDefns.PHONE_NUMBER,
            (homeDetailsCustomerDet.get(CommonControlDataDefns.PHONE_NUMBER)).toString().isEmpty() ? "NoValue" : homeDetailsCustomerDet.get(CommonControlDataDefns.PHONE_NUMBER).toString().replace(" ", ""));
        homeDetailsCustomerDet.remove(CommonControlDataDefns.PHONE_NUMBER);

        customerPersonalDetails.put(CommonControlDataDefns.CORRESPONDENCE_ADDRESS,
            homeDetailsCustomerDet.get(CommonControlDataDefns.CORRESPONDENCE_ADDRESS));
        homeDetailsCustomerDet.remove(CommonControlDataDefns.CORRESPONDENCE_ADDRESS);
        customerPersonalDetails.putAll(homeDetailsCustomerDet);

        vSourceViewOfHomePolicy.put(CommonControlDataDefns.CUSTOMER_DETAILS,
            customerPersonalDetails);
        var additionalCoverDetails = getAdditionalCoverDetails();
        additionalCoverDetails.put(CommonControlDataDefns.REBUILDING_COST,
            Optional.ofNullable((String) ((Map) homeDetails.get(GetPolicyInformationPortal.MY_COVER)).get(CommonControlDataDefns.BUILDING_VAR)).orElse((String) ((Map) homeDetails.get(GetPolicyInformationPortal.MY_COVER)).get(CommonControlDataDefns.BUILDING_INCLUDING_ACCIDENTAL_DAMAGE)));
        additionalCoverDetails.put(CommonControlDataDefns.INSURED_HOUSE_HOLD_CONENT_LIMIT,
            Optional.ofNullable(((String) ((Map) homeDetails.get(GetPolicyInformationPortal.MY_COVER))
                .get(CommonControlDataDefns.INSURED_HOUSE_HOLD_CONTENT_LIMIT_VAR)).replaceAll(
                    "[£,]", "")).orElse(
                    "NoValue"));
        vSourceViewOfHomePolicy.put(CommonControlDataDefns.COVER_DET, additionalCoverDetails);
        detail.put(commonControlDataDefns.HOME_INSURANCE_INFORMATION, vSourceViewOfHomePolicy);
        }catch (Exception e ) {
          throw new CustomE2eException(e.getMessage().toString());
        }
      } else if (insuranceTab.contains(commonControlDataDefns.MOTOR_INSURANCE_INFORMATION) && isElementVisible(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_MOTOR_TAB())) {
        switchToInsuranceTab(commonControlDataDefns.MOTOR_INSURANCE_INFORMATION);
        ArrayList<Object> policyNumber = new ArrayList<>();
        listOfPolicies = (ArrayList<String>) getListOfPolicies(filterValue);
        try {
          for (var policyNum : listOfPolicies) { //Loop inside InsuranceType
            try {
              if (listOfPolicies.size() > 1) {
                switchToPolicy(policyNum, filterCriteria,
                    commonControlDataDefns.MOTOR_INSURANCE_INFORMATION);
              }
              Map<String, Object> motor = fetchDetailsFromUiPolicyDetails(section);
              policyNumber.add(motor);
              motorDetails.put(policyNum, policyNumber);
//              policyFound = true;
              filterValue.remove(String.valueOf(policyNum));
            } catch (CustomE2eException e) {
            }
          }
        } catch (ConcurrentModificationException ex) {

        }
        motorDetails.put(POLICY_START_DATE,
            getText(this.pageObjectOfPortal.getDashboardLocatorModel().POLICY_START_DATE()));
        motorDetails.put(POLICY_END_DATE,
            getText(this.pageObjectOfPortal.getDashboardLocatorModel().POLICY_END_DATE()));
        motorDetails.put(POLICY_EXPIRES_IN,
            getText(this.pageObjectOfPortal.getDashboardLocatorModel().POLICY_EXPIRES_IN()));

        var additionalDriverDetails = new TreeMap<String, Object>();
        motorDetails.put(ADDITIONAL_DRIVER_DETAILS, additionalDriverDetails);

        Double premiumAmount = getPremiumAmount();
        motorDetails.put(CommonControlDataDefns.ADDITIONAL_PREMIUM, premiumAmount);
        String effectiveDate =
            getText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().EFFECTIVE_DATE());
        motorDetails.put(CommonControlDataDefns.MTAEFFECTIVEDATE,
            Formatting.changeDateFormatIntoExpected(effectiveDate, "dd MMM yyyy", "dd/MM/yyyy"));
        detail.put(commonControlDataDefns.MOTOR_INSURANCE_INFORMATION, motorDetails);
      }

    }
    if (detail == null || vSourceViewOfHomePolicy == null) {
      throw new CustomE2eException("Policy not found.");
    }
    return detail;
  }

  private SortedMap<String, Object> normalizeExcess(TreeMap<String, Object> excesses) {
    var normExcess = new TreeMap<String, Object>();
    for (var excessKey : excesses.keySet()) {
      switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(excessKey)) {
        case CommonControlDataDefns.EXTRA_HOME_EMERGENCY ->
            normExcess.put(CommonControlDataDefns.EXTRA_HOME_EMERGENCY, excesses.get(excessKey));
        case CommonControlDataDefns.BREAKDOWN_COVER ->
            normExcess.put(CommonControlDataDefns.BREAKDOWN_COVER, excesses.get(excessKey));
        case CommonControlDataDefns.CONTENTS_VAR ->
            normExcess.put(CommonControlDataDefns.CONTENTS_VAR,
                Integer.parseInt(excesses.get(excessKey).toString().replaceAll("[£,]", "")));
        case CommonControlDataDefns.EXCESS_PROTECTION ->
            normExcess.put(CommonControlDataDefns.EXCESS_PROTECTION, excesses.get(excessKey));
        case CommonControlDataDefns.FLOOD ->
            normExcess.put(CommonControlDataDefns.FLOOD,
                Integer.parseInt(excesses.get(excessKey).toString().replaceAll("[£,]", "")));
        case CommonControlDataDefns.EXCESS_PROTECTION_SUBSIDENCE ->
            normExcess.put(CommonControlDataDefns.EXCESS_PROTECTION_SUBSIDENCE_VAR,
                excesses.get(excessKey));
        case CommonControlDataDefns.KEY_PROTECTION ->
            normExcess.put(CommonControlDataDefns.KEY_PROTECTION, excesses.get(excessKey));
        case CommonControlDataDefns.LEAKING_FREEZING_VAR ->
            normExcess.put(CommonControlDataDefns.LEAKING_FREEZING,
                excesses.get(excessKey));
        case CommonControlDataDefns.LEGAL_EXPENSES ->
            normExcess.put(CommonControlDataDefns.LEGAL_EXPENSES, excesses.get(excessKey));
        case CommonControlDataDefns.REPLACEMEMT_VEHICLE ->
            normExcess.put(CommonControlDataDefns.REPLACEMEMT_VEHICLE, excesses.get(excessKey));
        case CommonControlDataDefns.SUBSIDENCE_GROUND_HEAVE_LAND_SLIP_VAR ->
            normExcess.put(CommonControlDataDefns.SUBSIDENCE_GROUND_HEAVE_LAND_SLIP,
                excesses.get(excessKey).toString().replaceAll("[£,]", ""));
      }
    }
    return normExcess;
  }

//  private static TreeMap<String, Object> getAddressNormalize(String address) {
//    var postCode = Formatting.getTextFromRegex(address, CommonControlDataDefns.POST_CODE_REGEX);
//    var houseIdentifier = address.replace(postCode, "").trim();
//    var addres = new TreeMap<String, Object>();
//    addres.put(CommonControlDataDefns.HOUSE_IDENTIFIER, houseIdentifier);
//    addres.put(CommonControlDataDefns.POSTCODE, postCode);
//    return addres;
//  }

  private SortedMap<String, Object> getEmploymentDetails() throws CustomE2eException {
    var empDet = new TreeMap<String, Object>();
    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalSharedLocatorModel().EDIT_MAIN_POLICY_HOLDER(), SyncType.CLICKABLE);

    //Sarah added as there is a spinnter after clicking edit
    PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(30),
            () -> waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().PRIMARY_EMP_STATUS(), SyncType.VISIBLE, waitDuration));
    waitForPageLoad();

    var primaryEmpDet = new TreeMap<String, Object>();

    //Sarah added waitforelements as intermittently blank
    waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().PRIMARY_EMP_STATUS(),SyncType.VISIBLE,waitDuration);
    primaryEmpDet.put(CommonControlDataDefns.EMPLOYMENT_STATUS,
        getSelectedValueFromDropDown(this.pageObjectOfPortal.getPortalSharedLocatorModel().PRIMARY_EMP_STATUS(), "Failed to fetch primary employment status"));



    waitForPageLoad();
    waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().PRIMARY_EMP_INDUSTRY(),SyncType.VISIBLE,waitDuration);
    primaryEmpDet.put(CommonControlDataDefns.INDUSTRY,
            getAttributeNotEmpty(this.pageObjectOfPortal.getPortalSharedLocatorModel().PRIMARY_EMP_INDUSTRY(), "value", "Failed to fetch industry"));



    waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().PRIMARY_EMP_OCCUPATION(),SyncType.VISIBLE,waitDuration);

    waitForPageLoad();
    primaryEmpDet.put(CommonControlDataDefns.OCCUPATION,
            getAttributeNotEmpty(this.pageObjectOfPortal.getPortalSharedLocatorModel().PRIMARY_EMP_OCCUPATION(), "value", "Failed to fetch occupation"));

//    primaryEmpDet.put(CommonControlDataDefns.OCCUPATION,
//            getText(this.pageObjectOfPortal.getPortalSharedLocatorModel().PRIMARY_EMP_OCCUPATION(), "failed to fetch the value of voluntary excess"));



    empDet.put(CommonControlDataDefns.PRIMARY_EMPLOYMENT, primaryEmpDet);
    var secondaryEmpDet = new TreeMap<String, Object>();
    if (getSecondJobStatus(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED_INSURED_ADDRESS(), "Do you have a second job?"))) {
      secondaryEmpDet.put(CommonControlDataDefns.SECOND_EMP_FLAG, true);
      secondaryEmpDet.put(CommonControlDataDefns.EMPLOYMENT_STATUS,
          getSelectedValueFromDropDown(this.pageObjectOfPortal.getPortalSharedLocatorModel().SECONDARY_EMP_STATUS(), "Failed to fetch secondary employment status"));
      secondaryEmpDet.put(CommonControlDataDefns.OCCUPATION,
          getAttribute(this.pageObjectOfPortal.getPortalSharedLocatorModel().SECONDARY_EMP_OCCUPATION(), "value", "Failed to fetch secondary occupation"));
      secondaryEmpDet.put(CommonControlDataDefns.INDUSTRY,
          getAttribute(this.pageObjectOfPortal.getPortalSharedLocatorModel().SECONDARY_EMP_INDUSTRY(), "value", "Failed to fetch secondary industry"));
    } else {
      secondaryEmpDet.put(CommonControlDataDefns.SECOND_EMP_FLAG, false);
    }
    empDet.put(CommonControlDataDefns.SECONDARY_EMPLOYMENT, secondaryEmpDet);
    waitForElement2(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().CANCEL_BUTTON(),
        SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().CANCEL_BUTTON(), SyncType.CLICKABLE);
    return empDet;
  }


  public void selectPolicyFromDropDown(String policyNumber) throws CustomE2eException {
    var listOfPolicies = new ArrayList<String>();
    var insuranceTabSearch = new ArrayList<String>();
    var policyFound = false;
    if (policyNumber.startsWith("GD")) {
      insuranceTabSearch.add(commonControlDataDefns.MOTOR_INSURANCE_INFORMATION);
    } else if (policyNumber.startsWith("HE")) {
      insuranceTabSearch.add(commonControlDataDefns.HOME_INSURANCE_INFORMATION);
    } else if (policyNumber.startsWith("MM")) {
      insuranceTabSearch.add(commonControlDataDefns.VAN_INSURANCE_INFORMATION);
    }
    listOfPolicies = (ArrayList<String>) getAllPolicyNumber();
    //  var policyCount =0;
    try {
      //  do{
      try {
        if (insuranceTabSearch.contains(commonControlDataDefns.MOTOR_INSURANCE_INFORMATION)) {
          policyFound = switchToPolicy(policyNumber, CommonControlDataDefns.POLICY_NUMBER,
              commonControlDataDefns.MOTOR_INSURANCE_INFORMATION);
        } else if (insuranceTabSearch.contains(commonControlDataDefns.HOME_INSURANCE_INFORMATION)) {
          policyFound = switchToPolicy(policyNumber, CommonControlDataDefns.POLICY_NUMBER,
              commonControlDataDefns.HOME_INSURANCE_INFORMATION);
        } else if (insuranceTabSearch.contains(commonControlDataDefns.VAN_INSURANCE_INFORMATION)) {
          policyFound = switchToPolicy(policyNumber, CommonControlDataDefns.POLICY_NUMBER,
              commonControlDataDefns.VAN_INSURANCE_INFORMATION);
        }
        //      policyCount++;
      } catch (CustomE2eException e) {

      }
      //    }while(!policyFound && policyCount<listOfPolicies.size() );
    } catch (ConcurrentModificationException ex) {

    }
    if (!policyFound) {
      throw new CustomE2eException("Policy not found.");
    }
  }

  public SortedMap<String, Object> getInsureHouseDetails() throws CustomE2eException {
    SortedMap<String, Object> insuredAddressDetails = new TreeMap<>();
    editInsuredAddress();

    PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(120),
        () -> waitForElement2(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().QUESTION_LIST(), SyncType.CLICKABLE, waitDuration));
    ArrayList<String> listOfQuestions = new ArrayList<>();
    listOfQuestions =
        getTextAllWebElementMatchingLocator(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().QUESTION_LIST());

    for (int listOfQuestionVar = 0; listOfQuestionVar < listOfQuestions.size(); listOfQuestionVar++) {
      var que = listOfQuestions.get(listOfQuestionVar);
      que = que.contains("\n") ? que.split("\n")[0] : que;

      switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(que)) {
        case CommonControlDataDefns.HOME_EXTENSION_DETAILS_VAR: //"Has your home been extended?":
          var extensionVal =
              getHouseExtDetail(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED_INSURED_ADDRESS(), "Has your home been extended?"));
          insuredAddressDetails.put(CommonControlDataDefns.EXTENSION_DETAILS, extensionVal);
          break;
        case CommonControlDataDefns.LISTED_BUILDING_VAR: //"Is your home a listed building?"
          insuredAddressDetails.put(CommonControlDataDefns.LISTED_BUILDING_FLAG,
              getHouseListingDetail(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED_INSURED_ADDRESS(), "Is your home a listed building?")));
          break;
        case CommonControlDataDefns.PROPERTY_LEFT_OCCUPIED_VAR: //"When is your home normally
          // occupied?":
          insuredAddressDetails.put(CommonControlDataDefns.OCCUPANCY_VAR,
              getHouseOccupiedDetail(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED_INSURED_ADDRESS(), "When is your home normally occupied?")));
          break;
        case CommonControlDataDefns.LOCKING_DETAILS_VAR:
          insuredAddressDetails.put(CommonControlDataDefns.LOCKING_DETAILS,
              getHouseFittingDetail(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED_INSURED_ADDRESS(), "Is your home fitted with five-lever mortice deadlocks or a multi-point locking system on all external doors, and key-operated window locks on all ground-level windows and accessible upper floor windows?")));
          break;
        case CommonControlDataDefns.INTRUDER_ALARM_VAR: //"Is an intruder alarm installed?":
          var intruderAlarm =
              getSelectedValueFromDropDown(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().DROP_DOWN_VALUE_ANWER(), "Is an intruder alarm installed?"), "Value is not available");
          insuredAddressDetails.put(CommonControlDataDefns.INTRUDER_ALARM, intruderAlarm);
          break;
//        case "Do you own or rent your home?": //DoYouOwnOrRentYourHome?
//          insuredAddressDetails.put(GetCustomerDetailsPortal.HOME_OWN_RENT_DETAILS,
//              Formatting.capitalizeFirstCharacter(getHouseOwnOrRentDetail(xpathBuilder(this
//              .pageObjectOfPortal.getPortalSharedLocatorModel()
//              .CHOICE_ANSWER_SELECTED_INSURED_ADDRESS, "Do you own or rent your home?"))));
//          break; //Information is available on Echelon but not matching. DO NOT DELETE DO NOT
//          DELETE
        case CommonControlDataDefns.CONST_STANDARD_VAR: //"Is your home built of standard " +
          //  "construction?":
          insuredAddressDetails.put(GetCustomerDetailsPortal.HOME_BUILT_DETAILS,
              getHouseConstructionDetail(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED_INSURED_ADDRESS(), "Is your home built of standard construction?")));
          break;
        case CommonControlDataDefns.EXTERNAL_WALL_MADE_FROM: //"What are the external walls made
          // from?":
          var externalWallsMadeFrom =
              getSelectedValueFromDropDown(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().DROP_DOWN_VALUE_ANWER(), "What are the external walls made from?"), "Value is not available");
          insuredAddressDetails.put(GetCustomerDetailsPortal.HOME_WALL_OF_DETAILS,
              externalWallsMadeFrom);
          break;
        case CommonControlDataDefns.EXTERNAL_ROOF_MADE_FROM: //"What’s the roof made of?":
          var roofMadeFrom =
              getSelectedValueFromDropDown(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().DROP_DOWN_VALUE_ANWER(), "What’s the roof made of?"), "Value is not available");
          insuredAddressDetails.put(GetCustomerDetailsPortal.HOME_ROOF_MADE_OF_DETAILS,
              roofMadeFrom);
          break;
        case CommonControlDataDefns.PERCENT_FLAT_ROOF_VAR: //"Approximately what
          // percentage of the roof is flat?":
          insuredAddressDetails.put(GetCustomerDetailsPortal.HOME_ROOF_DETAILS,
              Formatting.capitalizeFirstCharacter(getHouseRoofingDetail(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED_INSURED_ADDRESS(), "Approximately what percentage of the roof is flat?"))));
          break;
        case CommonControlDataDefns.NUM_ADULTS_LIVE_HOME_VAR: //"How many adults live at your
          // home?":
          insuredAddressDetails.put(CommonControlDataDefns.NUM_ADULTS,
              getNumberOfAdult(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().DROP_DOWN_VALUE_ANWER(), "How " + "many adults live at your home?")));
          break;
        case CommonControlDataDefns.NUM_CHILD_LIVE_HOME_VAR: //"How many children live at your
          // home?": //
          insuredAddressDetails.put(CommonControlDataDefns.NUM_CHILD,
              getNumberOfChildren(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().DROP_DOWN_VALUE_ANWER(), "How many children live at your home?")));
          break;
        case CommonControlDataDefns.PET_LIVING_IN_HOME_VAR: //"Do you have any pets living at
          // your home?": //
          insuredAddressDetails.put(CommonControlDataDefns.PET_DET,
              getPetDetails(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().DROP_DOWN_VALUE_ANWER(), "Do you have any pets living at your home?")));
          break;
        case CommonControlDataDefns.PAYING_GUEST_DET_VAR: //"Do you have any paying guests living
          // at your home?":
          insuredAddressDetails.put(CommonControlDataDefns.NON_FAMILY_LODGER,
              getPayingGuestDetails(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().DROP_DOWN_VALUE_ANWER(), "Do you have any paying guests living at your home?")));
          break;
        case CommonControlDataDefns.HOME_BUSINESS_PURPOSE_FLAG_VAR: //"Is any part of your home
          // used for " +
//            "business purposes?":
          insuredAddressDetails.put(GetCustomerDetailsPortal.HOME_USE_DETAILS,
              getHouseUseDetail(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED_INSURED_ADDRESS(), "Is any part of your home used for business purposes?")));
          break;
        case "Is this clerical business use only (no employees or visitors)?":
          insuredAddressDetails.put(GetCustomerDetailsPortal.HOME_CLERICAL_USE_DETAILS,
              getHouseUseDetail(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED_INSURED_ADDRESS(), "Is this clerical business use only (no employees or visitors)?")));
        case CommonControlDataDefns.PROPERTY_TYPE: //"Property Type":
//          insuredAddressDetails.put(CommonControlDataDefns.PROPERTY_TYPE, );
          break;
        case CommonControlDataDefns.BEST_DESCRIBE_YOUR_HOME:
          break;
        default:
      }
    }
    waitForElement2(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().CANCEL_BUTTON(),
        SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().CANCEL_BUTTON(), SyncType.CLICKABLE);

    //Sarah addedd PerformSpinner OP..... the cancel can triggere spinner
    waitForElement2(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().BACK_BUTTON(),
        SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().BACK_BUTTON(), SyncType.CLICKABLE);


    //Sarah addedd PerformSpinner OP..... the back can triggere spinner
    waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().YES_DIALOG_BOX(),
        SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalSharedLocatorModel().YES_DIALOG_BOX(), SyncType.CLICKABLE);
    return insuredAddressDetails;
  }

  private String getHouseOccupiedDetail(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    return getHouseOccupiedStatusFromValueAtt((String) getAnswerSelected(getChildNodes));
  }


  private String getHouseRoofingDetail(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    return getRoofingDetails((String) getAnswerSelected(getChildNodes));
  }

  public String getRoofingDetails(String node) {
    String det = null;
    switch (node) {
      case "A":
        det = "0% to 33%";
      case "B":
        det = "34% to 50%";
      case "C":
        det = "50%+";
      default:
        det = "NoValueSelected";

    }
    return det;
  }

  private Boolean getHouseUseDetail(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    return Boolean.parseBoolean((String) getAnswerSelected(getChildNodes));
  }

  private Boolean getHouseConstructionDetail(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    var constDetails = getAnswerSelected(getChildNodes);
    if ((String.valueOf(constDetails).equalsIgnoreCase("Standard"))) {
      return true;
    } else {
      return false;
    }
  }


  public Boolean getHouseListingDetail(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    return Boolean.parseBoolean((String) getAnswerSelected(getChildNodes));
  }

  private boolean getSecondJobStatus(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    return Boolean.parseBoolean((String) getAnswerSelected(getChildNodes));
  }

  public Boolean getHouseFittingDetail(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    return Boolean.parseBoolean((String) getAnswerSelected(getChildNodes));
  }

  private String getHouseOccupiedStatusFromValueAtt(String value) {
    String status = null;
    switch (value) {
      case "Occupied":
        status = "Day and Night";
        break;
      case "NightlyUn":
        status = "During the day";
        break;
      case "DailyUnoc":
        status = "During the night";
        break;
      case "LengthyUn":
        status = "Unoccupied";
        break;
      default:
        status = "NoValueSelected";
    }
    return status;
  }


  public Object getHouseExtDetail(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    var answer = (String) getAnswerSelected(getChildNodes);
    if (answer.equalsIgnoreCase("N")) {
      return false;
    } else if (answer.equalsIgnoreCase("Y")) {
      return true;
    } else {
      return "NoValueSelected";
    }
  }

  private void editInsuredAddress() throws CustomE2eException {
    waitForElement2(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().INSURED_ADDRESS_EDIT_LINK(), SyncType.CLICKABLE
        , waitDuration);
    //Sarah Need this here bedause of the get operation on polidy, cancels and goes back to the page casuing a spinner
    PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(120), () -> clickElement(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().INSURED_ADDRESS_EDIT_LINK(), SyncType.CLICKABLE));

    //RetryOnClickInterceptedException(10,
       //() ->  clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().INSURED_ADDRESS_EDIT_LINK(), SyncType.CLICKABLE));
  }

  public SortedMap<String, Object> getAdditionalCoverDetails() throws CustomE2eException {
    SortedMap<String, Object> additionalCoverDetail = new TreeMap<>();
    //waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().EDIT_COVER(),
        //SyncType.CLICKABLE, waitDuration);

    PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(120), () -> clickElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().EDIT_COVER(),
            SyncType.CLICKABLE));
    waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().ADD_MORE_CHANGES(),
        SyncType.CLICKABLE, waitDuration);
    var listOfQuestion =
        getTextAllWebElementMatchingLocator(this.pageObjectOfPortal.getPortalSharedLocatorModel().GET_COVER_QUESTIONS());
    int countOfListOfQue = listOfQuestion.size() - 1;
    var valuable = new TreeMap<String, Object>();
    var awayFromHome = new TreeMap<String, Object>();
    var inHome = new TreeMap<String, Object>();
    for (int listOfQuestionVar = 0; listOfQuestionVar <= countOfListOfQue; listOfQuestionVar++) {
      var que = listOfQuestion.get(listOfQuestionVar);
      int positionOfElement = listOfQuestionVar + 1;
      que = que.contains("\n") ? que.split("\n")[0] : que;

      switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(que)) {
//        case "What date would you like the change to start?":
//          var coverDate = getCoverStartDate(xpathBuilder(this.pageObjectOfPortal
//          .getPortalSharedLocatorModel().ANSWER_DROP_DOWN(),
//              String.valueOf(positionOfElement)));
//          var year = Year.now().getValue();
//          var formattedDate = Formatting.changeDateFormatIntoExpected(coverDate, "EEEE, dd MMM",
//              "dd/MM/" +year);
//          additionalCoverDetail.put(Formatting.capitalizeAllFirstCapitalize
//          (COVER_CHANGE_START_DATE), formattedDate);
//          break; Not on Echelon and not relevant while for get details
        case REQUIRED_BUILDING_ACCIDENTAL_DAMAGE_COVER:
          var accidentalDamageCover =
              getAccidentalDamageCover(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED(), String.valueOf(positionOfElement)));
          additionalCoverDetail.put(CommonControlDataDefns.BUILDING_ACCIDENTAL_DAMAGE_COVER,
              accidentalDamageCover);
          break;
        case BUILDING_EXCESS_VAR:
          additionalCoverDetail.put(CommonControlDataDefns.BUILDING_COMPULSORY_EXCESS,
              getTextNotPresetBecomesEmpty(this.pageObjectOfPortal.getPortalSharedLocatorModel().BUILDING_COMPULSORY_EXCESS(), "failed to fetch the value of voluntary excess").replaceAll("[£,]", ""));

          additionalCoverDetail.put(CommonControlDataDefns.BUILDING_VOLUNTARY_EXCESS,
              getTextNotPresetBecomesEmpty(this.pageObjectOfPortal.getPortalSharedLocatorModel().BUILDING_VOLUNTARY_EXCESS(), "failed to fetch the value of voluntary excess").replaceAll("[£,]", ""));
          break;
        case CONTENT_EXCESS_VAR:
          additionalCoverDetail.put(CommonControlDataDefns.CONTENT_COMPULSORY_EXCESS,
              getTextNotPresetBecomesEmpty(this.pageObjectOfPortal.getPortalSharedLocatorModel().CONTENT_COMPULSORY_EXCESS(), "failed to fetch the value of voluntary excess").replaceAll("[£,]", ""));
          additionalCoverDetail.put(CommonControlDataDefns.CONTENT_VOLUNTARY_EXCESS,
              getTextNotPresetBecomesEmpty(this.pageObjectOfPortal.getPortalSharedLocatorModel().CONTENT_VOLUNTARY_EXCESS(), "failed to fetch the value of voluntary excess").replaceAll("[£,]", ""));
          break;
        case HELD_CONTENT_INSURANCE_VAR:
          additionalCoverDetail.put(CommonControlDataDefns.PREVIOUS_INSURANCE,
              getContentInsuranceHeld(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED(), String.valueOf(positionOfElement))));
          break;
        case INSURE_HOUSEHOLD_CONTENT_VAR:
          additionalCoverDetail.put(CommonControlDataDefns.ACCIDENTAL_DAMAGE_COVER,
              getInsureHouserholdContent(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().ANSWER_DROP_DOWN(), String.valueOf(positionOfElement))));
          break;
        case CONTENT_ACCIDENTAL_DAMAGE_COVER_VAR:
          additionalCoverDetail.put(CommonControlDataDefns.CONTENT_ACCIDENTAL_DAMAGE_VAR,
              getContentAccidentalDamageCover(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED(), String.valueOf(positionOfElement))));
          break;
        case VALUABLE_IN_HOME_VAR:
          var specified = new TreeMap<String, Object>();
          var itemsInHomeChoice =
              itemsInHomeFlag(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED(), String.valueOf(positionOfElement)));
//          inHome.put(CommonControlDataDefns.VALUABLE_IN_HOME_FLAG,
//              itemsInHomeChoice);
          if ((Boolean) itemsInHomeChoice) {
            var items =
                getListOfItems(this.pageObjectOfPortal.getPortalSharedLocatorModel().SECTION_OF_VALUABLE_ITEMS());
            inHome.put(CommonControlDataDefns.ITEMS_IN_HOME, items);
            inHome.put(CommonControlDataDefns.IN_HOME_COUNT, items.size());
          } else {
            inHome.put(CommonControlDataDefns.ITEMS_IN_HOME, null);
            inHome.put(CommonControlDataDefns.IN_HOME_COUNT, 0);
          }
          specified.putAll(inHome);

          var itemsAwayFromHomeChoice =
              awayFromHomeFlag(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED(), String.valueOf(positionOfElement)));
//          awayFromHome.put(CommonControlDataDefns.VALUABLE_AWAY_FROM_HOME_FLAG,
//              itemsAwayFromHomeChoice);

          if ((Boolean) itemsAwayFromHomeChoice) {
            var items =
                getListOfItems(this.pageObjectOfPortal.getPortalSharedLocatorModel().SECTION_OF_SPECIFIED_ITEMS());
            awayFromHome.put(CommonControlDataDefns.ITEMS_AWAY_FROM_HOME, items);
            awayFromHome.put(CommonControlDataDefns.AWAY_FROM_HOME_COUNT, items.size());
          } else {
            awayFromHome.put(CommonControlDataDefns.ITEMS_AWAY_FROM_HOME, null);
            awayFromHome.put(CommonControlDataDefns.AWAY_FROM_HOME_COUNT, 0);
          }
          specified.putAll(awayFromHome);
          additionalCoverDetail.put(CommonControlDataDefns.SPECIFIED_ITEM, specified);
          break;

        case CommonControlDataDefns.PERSONAL_BELONGING_AWAY_FROM_HOME_VAR:
          var extraCoverPersonalBelongingsAway =
              getExtraCoverPersonalBelongingsAway(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED(), String.valueOf(positionOfElement)));
          additionalCoverDetail.put(CommonControlDataDefns.PERSONAL_BELONGING_AWAY_FROM_HOME,
              extraCoverPersonalBelongingsAway); //get List of Items to store
          break;
        case CommonControlDataDefns.PERSONAL_BELONGING_AWAY_FROM_HOME_COST_VAR:
          var personalBelongingAwayFromHome =
              getPersonalBelonging(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().ANSWER_DROP_DOWN(), String.valueOf(positionOfElement)));
          additionalCoverDetail.put(CommonControlDataDefns.PERSONAL_BELONGING_AWAY_FROM_HOME_COST,
              personalBelongingAwayFromHome.replaceAll("[£,]", ""));
          break;

        default:
      }
    }
    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalSharedLocatorModel().COVER_BACK_BUTTON(), SyncType.CLICKABLE);
    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalSharedLocatorModel().YES_DIALOG_BOX(), SyncType.CLICKABLE);
    return additionalCoverDetail;
  }


  private ArrayList<TreeMap<String, Object>> getListOfItems(By component) {
    ArrayList<TreeMap<String, Object>> returnItems = new ArrayList<>();
    var listOfItems = getElementsMatchingToLocator(component);
    for (var item : listOfItems) {
      TreeMap<String, Object> list = new TreeMap<>();
      var itemName = item.getText().split("\n")[0].replace(":", "").trim();
      var itemCost = Double.parseDouble(item.getText().replaceAll("[£,]", "").split("\n")[1]);
      list.put(CommonControlDataDefns.ITEM, itemName);
      list.put(CommonControlDataDefns.VALUE, itemCost);
      //list.put(itemName, itemCost);
      returnItems.add(list);
    }
    return returnItems;
  }

  public String getDetailsOfHomeFloodedInLast25Years(String selectedAnswer) {
    if (Boolean.parseBoolean(selectedAnswer)) {
      return "No";
    } else {
      return "Yes";
    }
  }


  private Object getNumberOfAdult(By component) throws CustomE2eException {
    var numberOfAdult = getSelectedValueFromDropDown(component, "Value is not available");
    if (numberOfAdult.equalsIgnoreCase("Please select...")) {
      return "NoValueSelected";
    }
    return Integer.parseInt(numberOfAdult);
  }

  private Object getPayingGuestDetails(By component) throws CustomE2eException {
    var payingGuest = getSelectedValueFromDropDown(component, "Value is not available");
    if (payingGuest.equalsIgnoreCase("Please select...")) {
      payingGuest = "NoValueSelected";
    }
    if (payingGuest.equalsIgnoreCase("No")) {
      return false;
    }
    return payingGuest;
  }

  private Object getPetDetails(By component) throws CustomE2eException {
    var petDetails = getSelectedValueFromDropDown(component, "Value is not available");
    if (petDetails.equalsIgnoreCase("Please select...")) {
      petDetails = "NoValueSelected";
    }
    if (petDetails.equalsIgnoreCase("No")) {
      return false;
    }
    return petDetails;
  }

  private Object getNumberOfChildren(By component) throws CustomE2eException {
    var numberOfChildren = getSelectedValueFromDropDown(component, "Value is not available");
    if (numberOfChildren.equalsIgnoreCase("Please yesselect...")) {
      return "NoValueSelected";
    }
    return Integer.parseInt(numberOfChildren);
  }


  private String getHomeDesc(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }

  private String getExchangeDate(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }


  private Object getAccidentalDamageCover(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    return getAnswerSelected(getChildNodes);
  }

  public Object awayFromHomeFlag(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    return getAnswerSelected(getChildNodes);
    //getSpecified Items if answer is yes
  }

  public String getPersonalBelonging(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }


  public Object getExtraCoverPersonalBelongingsAway(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    return getAnswerSelected(getChildNodes);
  }

  public Object itemsInHomeFlag(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    return getAnswerSelected(getChildNodes);
  }

  public Object getContentAccidentalDamageCover(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    return getAnswerSelected(getChildNodes);
  }

  public String getInsureHouserholdContent(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available").replaceAll("[£,]", "");
  }

  public Object getContentInsuranceHeld(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    return getAnswerSelected(getChildNodes);
  }

  public String getVoluntaryExcess(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }


  long getPolicyExpiresInDays() throws CustomE2eException {
    var vUiText =
        this.getText(this.pageObjectOfPortal.getDashboardLocatorModel().POLICY_EXPIRES_IN());
    var vNumericText = vUiText.substring(0, vUiText.indexOf(' '));
    var vValue = Long.parseLong(vNumericText);
    return vValue;
  }

  private double getPremiumAmount() throws CustomE2eException {
    double premiumAmount = 0.0;
    if (isElementVisible(this.pageObjectOfPortal.getDashboardLocatorModel().COMPLETE_PAYMENT())) {
      clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getDashboardLocatorModel().COMPLETE_PAYMENT(), SyncType.CLICKABLE);
      waitForElement2(this.pageObjectOfPortal.getDashboardLocatorModel().PREMIUM_PAYMENT(),
          SyncType.VISIBLE, waitDuration);
      if (isElementVisible(this.pageObjectOfPortal.getDashboardLocatorModel().PREMIUM_PAYMENT())) {
        premiumAmount =
            Double.parseDouble(Formatting.getTextFromRegex(tryGetText(this.pageObjectOfPortal.getDashboardLocatorModel().PREMIUM_PAYMENT()), "\\d{1,4}.\\d{1,2}"));
      }
      RetryOnClickInterceptedException(10,
          () -> clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalSharedLocatorModel().SAVE_BUTTON(), SyncType.CLICKABLE));
    }
    return premiumAmount;
  }


  private String getEffectiveDate(By byLocator) throws CustomE2eException, ParseException {
    LocalDate effectiveDate = LocalDate.now();
    if (isElementVisible(byLocator)) {
      var changeTextOnPortal = getText(byLocator);
      effectiveDate = CommonHelper.extractDateFromString(LocalDate.now(), changeTextOnPortal);
    }
    return Formatting.changeDateFormatIntoExpected(effectiveDate.toString(), "yyyy-MM-dd", "dd/MM"
        + "/yyyy");
  }

  private Map<String, Object> getDataBasedOnInsuranceType(String section,
                                                          ArrayList<String> filterValue,
                                                          String filterCriteria) {
    Map<String, Object> data = new HashMap<>();

    return data;
  }


  private Map<String, Object> getDetailsOfPolicy(Map<String, Object> policyDetails) {
    Map<String, Object> returnFormat = new HashMap<>();
    //count policies
    return returnFormat;
  }

  private List<String> getListOfPolicies(List<String> listOfPolicies) throws CustomE2eException {
    if (listOfPolicies.contains(String.valueOf("ALL"))) {
      listOfPolicies = getAllPolicyNumber();
    }
    return listOfPolicies;
  }


  private SortedMap<String, Object> fetchDetailsFromUiPolicyDetails(String section) throws CustomE2eException {
    SortedMap<String, Object> details = new TreeMap<>();
    SortedMap<String, Object> myDetails;
    SortedMap<String, Object> coverDetails;
    SortedMap<String, Object> excessDetails;
    SortedMap<String, Object> enhanceCoverDetails;
    try {
      if (section == null) {
        section = "All";
      }
      switch (section) {
        case GetCustomerDetailsPortal.MY_DETAILS:
          waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().MY_DETAILS_SECTION(), SyncType.VISIBLE, waitDuration);
          PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300), () -> clickElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().MY_DETAILS_SECTION(),
                  SyncType.CLICKABLE));
          //clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalSharedLocatorModel().MY_DETAILS_SECTION(),
          //SyncType.CLICKABLE);



          myDetails =
                  getDetails(this.pageObjectOfPortal.getPortalSharedLocatorModel().MY_DETAILS_FIELD_NAME_AND_VALUE());
          details.put(CommonControlDataDefns.CUSTOMER_DETAILS, myDetails);

          break;

        default:
          waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().MY_DETAILS_SECTION(), SyncType.VISIBLE, waitDuration);
          PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300), () -> clickElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().MY_DETAILS_SECTION(),
                  SyncType.CLICKABLE));
          //waitForElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().MY_DET_SEC_INFO(), SyncType.VISIBLE);
          myDetails =
              getDetails(this.pageObjectOfPortal.getPortalSharedLocatorModel().MY_DETAILS_FIELD_NAME_AND_VALUE());
          details.put(CommonControlDataDefns.CUSTOMER_DETAILS, myDetails);

          PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(120), () -> clickElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().MY_COVER_SECTION(),
                  SyncType.CLICKABLE));
//        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalSharedLocatorModel().MY_COVER_SECTION(),
//            SyncType.CLICKABLE);
          waitForElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().MY_COVER_SEC_INFO(), SyncType.VISIBLE);
          coverDetails =
              getDetails(this.pageObjectOfPortal.getPortalSharedLocatorModel().MY_COVER_FIELD_NAME_AND_VALUE());
          details.put(GetPolicyInformationPortal.MY_COVER, coverDetails);

          PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(120), () -> clickElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().EXCESSES_SECTION(),
                  SyncType.CLICKABLE));

//        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalSharedLocatorModel().EXCESSES_SECTION(),
//            SyncType.CLICKABLE);
          waitForElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().EXCESSES_SEC_INFO(), SyncType.VISIBLE);
          excessDetails =
              getDetails(this.pageObjectOfPortal.getPortalSharedLocatorModel().EXCESS_FIELD_NAME_AND_VALUE());
          details.put(GetPolicyInformationPortal.MY_EXCESSES, excessDetails);

          PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(120), () -> clickElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().ENHANCE_MY_COVER_SECTION(),
                  SyncType.CLICKABLE));

          //clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalSharedLocatorModel().ENHANCE_MY_COVER_SECTION(), SyncType.CLICKABLE);
          waitForElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().ENHANCE_MY_COVER_SEC_INFO(), SyncType.VISIBLE);
          enhanceCoverDetails = getEnhancedCover();
          details.put(GetPolicyInformationPortal.ENHANCE_COVER, enhanceCoverDetails);
          break;
      }
      return details;
    }catch (Exception e ) {
      throw new CustomE2eException(e.getMessage().toString());
    }
  }

  //Need to update Logic- Variables are with Spaces
  public SortedMap<String, Object> getEnhancedCover() throws CustomE2eException {
    var enhanceCover = new TreeMap<String, Object>();
    var notAddedCover = new ArrayList<String>();
    var addedCovers =
        getTextAllWebElementMatchingLocator(this.pageObjectOfPortal.getPortalSharedLocatorModel().ENHANCE_COVER_ADDED());
    var enhanceCoverNotAdded =
        getTextAllWebElementMatchingLocator(this.pageObjectOfPortal.getPortalSharedLocatorModel().ENHANCE_COVER_NOT_ADDED());
    for (var notAdded : enhanceCoverNotAdded) {
      notAddedCover.add(Formatting.capitalizeAllFirstCapitalizeRemoveSpace(notAdded));
    }
    enhanceCover.put(PortalGeneralStepDefinitions.EXCESS_PROTECTION, false);
    enhanceCover.put(PortalGeneralStepDefinitions.LEGAL_EXP, false);
    enhanceCover.put(PortalGeneralStepDefinitions.EXTRA_HOME_EMERGENCY, false);
    enhanceCover.put(PortalGeneralStepDefinitions.EXCESS_PROTECTION_SUBSIDENCE, false);
    enhanceCover.put(PortalGeneralStepDefinitions.KEY_PROTECTION, false);
    enhanceCover.put(PortalGeneralStepDefinitions.BREAKDOWN_COVER, false);
    enhanceCover.put(PortalGeneralStepDefinitions.EXCESS_PROTECTION, false);
    enhanceCover.put(PortalGeneralStepDefinitions.REPLACEMENT_VEHICLE, false);

    if (addedCovers.toString().contains(PortalGeneralStepDefinitions.EXCESS_PROTECTION)) {
      enhanceCover.put(PortalGeneralStepDefinitions.EXCESS_PROTECTION, true);
    }
    if (addedCovers.toString().contains(LEGAL_EXP)) {
      enhanceCover.put(LEGAL_EXP, true);
    }
    if (addedCovers.toString().contains(EXTRA_HOME_EMERGENCY)) {
      enhanceCover.put(EXTRA_HOME_EMERGENCY, true);
    }
    if (addedCovers.toString().contains(KEY_PROTECTION)) {
      enhanceCover.put(KEY_PROTECTION, true);
    }
    if (addedCovers.toString().contains(BREAKDOWN_COVER)) {
      enhanceCover.put(BREAKDOWN_COVER, true);
    }

    if (addedCovers.toString().contains(EXCESS_PROTECTION)) {
      enhanceCover.put(EXCESS_PROTECTION, true);
    }

    if (addedCovers.toString().contains(REPLACEMENT_VEHICLE)) {
      enhanceCover.put(REPLACEMENT_VEHICLE, true);
    }

    return enhanceCover;
  }


  public List<String> getAllPolicyNumber() throws CustomE2eException {
    List<String> listPolicyNumber = new ArrayList<>();
    int index = 0;
    Select selectOption =
        new Select(SeleniumHelper.findElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_DROP_DOWN(), SyncType.VISIBLE, "Failed to fetch policy numbers"));
    var allOptions = selectOption.getOptions();
    for (var option : allOptions) {
      SeleniumHelper.selectDropdown(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_DROP_DOWN(), index, SelectOptions.INDEX);
      waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_NUMBER(),
          SyncType.CLICKABLE, waitDuration);
      listPolicyNumber.add(getText(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_NUMBER()));
      index++;
    }
    return listPolicyNumber;
  }

  public void switchToPolicyBasedOnIndex(String expectedValue, String filterCriteria,
                                         String insuranceType) throws CustomE2eException {
    boolean policyFound = false;
    String actualValue = null;

    if (filterCriteria.equalsIgnoreCase(POLICY_START_DATE) || filterCriteria.equalsIgnoreCase(POLICY_END_DATE)) {
      if (insuranceType.equalsIgnoreCase(commonControlDataDefns.HOME_INSURANCE_INFORMATION)) {
        actualValue =
            getTextNotPresetBecomesEmpty(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_START_DATE_HOME(), "");
      } else if (insuranceType.equalsIgnoreCase(commonControlDataDefns.MOTOR_INSURANCE_INFORMATION)) {
        actualValue =
            getTextNotPresetBecomesEmpty(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_START_DATE_MOTOR(), "");
      }
    } else if (filterCriteria.equalsIgnoreCase(SEARCH_BY_POLICY_NUMBER)) {
      actualValue =
          getTextNotPresetBecomesEmpty(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_NUMBER(), "");
    }

    if (expectedValue.equalsIgnoreCase(actualValue)) {
      policyFound = true;
    } else if (!(expectedValue.equalsIgnoreCase(actualValue))) {
      if (filterCriteria.equalsIgnoreCase(SEARCH_BY_POLICY_NUMBER)) {
        Select selectOption =
            new Select(SeleniumHelper.findElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_DROP_DOWN(), SyncType.VISIBLE, "Selecting address from dropdown failed."));
        var allOptions = selectOption.getOptions();
        for (var policyCount = 0; policyCount < allOptions.size(); policyCount++) {
          selectDropdown(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_DROP_DOWN()
              , policyCount, SelectOptions.INDEX);
          try {
            waitForPageLoad();
            actualValue =
                getText(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_NUMBER());
          } catch (Exception e) {
            NoThrowSleep(Duration.ofMillis(600L));
            actualValue =
                getText(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_NUMBER());
          }
          NoThrowSleep(Duration.ofMillis(600L));

          if (expectedValue.equalsIgnoreCase(actualValue)) {
            policyFound = true;
            break;
          }
        }
      } else if (filterCriteria.equalsIgnoreCase(POLICY_START_DATE)) {
        Select selectOption =
            new Select(SeleniumHelper.findElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_DROP_DOWN(), SyncType.VISIBLE, "Selecting address from dropdown failed."));
        var allOptions = selectOption.getOptions();
        for (var option : allOptions) {
          selectDropdown(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_DROP_DOWN()
              , option.getText(), SelectOptions.TEXT);
          if (insuranceType.equalsIgnoreCase(commonControlDataDefns.HOME_INSURANCE_INFORMATION)) {
            actualValue =
                getText(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_START_DATE_HOME());
          } else if (insuranceType.equalsIgnoreCase(commonControlDataDefns.MOTOR_INSURANCE_INFORMATION)) {
            actualValue =
                getText(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_START_DATE_MOTOR());
          }
          if (expectedValue.equalsIgnoreCase(actualValue)) {
            policyFound = true;
            break;
          }
        }
      }
      if (!policyFound) {
        throw new CustomE2eException(expectedValue + " policy not found.");
      }
    }
  }

  public boolean switchToPolicy(String expectedValue, String filterCriteria,
                                String insuranceType) throws CustomE2eException {
    boolean policyFound = false;
    String actualValue = null;
    try {
      if (filterCriteria.equalsIgnoreCase(POLICY_START_DATE) || filterCriteria.equalsIgnoreCase(POLICY_END_DATE)) {
        if (insuranceType.equalsIgnoreCase(commonControlDataDefns.HOME_INSURANCE_INFORMATION)) {
          actualValue =
              tryGetText(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_START_DATE_HOME());
        } else if (insuranceType.equalsIgnoreCase(commonControlDataDefns.MOTOR_INSURANCE_INFORMATION)) {
          actualValue =
              getText(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_START_DATE_MOTOR());
        }
      } else if (filterCriteria.equalsIgnoreCase(SEARCH_BY_POLICY_NUMBER)) {
        actualValue =
            getText(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_NUMBER());
      }

      if (expectedValue.equalsIgnoreCase(actualValue)) {
        policyFound = true;
      } else if (!(expectedValue.equalsIgnoreCase(actualValue))) {
        if (filterCriteria.equalsIgnoreCase(SEARCH_BY_POLICY_NUMBER)) {
          int dropDownIndexes = 0;
          NoThrowSleep(Duration.ofSeconds(20));
          Select selectOption =
              new Select(SeleniumHelper.findElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_DROP_DOWN(), SyncType.VISIBLE, "Selecting address from dropdown failed."));
          var allOptions = selectOption.getOptions();
          var optionCount = 0;
          do {
            waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_DROP_DOWN(), SyncType.VISIBLE, waitDuration);
            selectDropdown(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_DROP_DOWN(), dropDownIndexes, SelectOptions.INDEX);
            PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(60),
                () -> waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_NUMBER(), SyncType.CLICKABLE, waitDuration));
            actualValue =
                tryGetText(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_NUMBER());
            dropDownIndexes++;
            if (expectedValue.equalsIgnoreCase(actualValue)) {
              policyFound = true;
              break;
            }
            optionCount++;
          } while (!expectedValue.equalsIgnoreCase(actualValue) && optionCount < allOptions.size());
        } else if (filterCriteria.equalsIgnoreCase(POLICY_START_DATE)) {
          Select selectOption =
              new Select(SeleniumHelper.findElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_DROP_DOWN(), SyncType.VISIBLE, "Selecting address from dropdown failed."));
          var allOptions = selectOption.getOptions();
          for (var option : allOptions) {
            PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(30),
                () -> selectDropdown(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_DROP_DOWN(), option.getText(), SelectOptions.TEXT));
            if (insuranceType.equalsIgnoreCase(commonControlDataDefns.HOME_INSURANCE_INFORMATION)) {
              actualValue =
                  getText(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_START_DATE_HOME());
            } else if (insuranceType.equalsIgnoreCase(commonControlDataDefns.MOTOR_INSURANCE_INFORMATION)) {
              actualValue =
                  getText(this.pageObjectOfPortal.getPortalSharedLocatorModel().POLICY_START_DATE_MOTOR());
            }
            if (expectedValue.equalsIgnoreCase(actualValue)) {
              policyFound = true;
              break;
            }
          }
        }
        if (!policyFound) {
          throw new CustomE2eException(expectedValue + " policy not found.");
        }
      }
    } catch (Exception e) {
      throw new CustomE2eException(e.getMessage());
    }
    return policyFound;
  }


  public void redirectToPaymentTab() throws CustomE2eException {
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getDashboardLocatorModel().TAB_REDIRECT(), "Payments"),
        SyncType.CLICKABLE);
  }

  // Update drop down where amount is in comma delimited currency format as in £0, £100, £500,
  // £1,000, £5,000, £10,000 and so on
  DropDownNumericListUpdater.ChangeDetails ChangeCurrencyAmountForm01DropDownSelector(By pControlLocator, Browser pBrowser, Object pChangeSpecification) throws CustomE2eException {
    return DropDownNumericListUpdater.ChangeNumericDropDownSelector(
        // Tailoring parameter
        pControlLocator, (Browser pBrowserInner, By pLocator) -> {
          var currentValueStr = pBrowserInner.Sh().getSelectedValueFromDropDown(pLocator, "Unable"
              + " to read the value for Currency");
          var currentValue = Integer.parseInt(currentValueStr.replace("£", "").replaceAll(",", ""));
          return currentValue;
        }, (int pValue) -> {
          DecimalFormat formatter = new DecimalFormat("#,###");
          return String.format("£%s", formatter.format(pValue));
        }, (String pUiValue) -> {
          return Integer.parseInt(pUiValue.replace("£", "").replaceAll(",", ""));
        }, (int pProposedValue) -> true, DropDownNumericListUpdater.ListOperatingMode.ValueIsMax,
        true,
        // Use parameters
        pBrowser, pChangeSpecification);
  }

  DropDownNumericListUpdater.ChangeDetails ChangeCoverAmountForm01DropDownSelector(By pControlLocator, Browser pBrowser, Object pChangeSpecification) throws CustomE2eException {
    return DropDownNumericListUpdater.ChangeNumericDropDownSelector(
        // Tailoring parameter
        pControlLocator, (Browser pBrowserInner, By pLocator) -> {
          var currentValueStr = pBrowserInner.Sh().getSelectedValueFromDropDown(pLocator, "Unable"
              + " to read the value for Cover Amount");
          if (currentValueStr.equalsIgnoreCase("Please select...")) {
            return 0;
          }
          var currentValue = Integer.parseInt(currentValueStr.replace("£", "").replaceAll(",", ""));
          return currentValue;
        }, (int pValue) -> {
          if (pValue == 0) {
            return "Please select...";
          } else {
            DecimalFormat formatter = new DecimalFormat("#,###");
            return String.format("£%s", formatter.format(pValue));
          }
        }, (String pUiValue) -> {
          if (pUiValue.equalsIgnoreCase("Please select...")) {
            return 0;
          }
          return Integer.parseInt(pUiValue.replace("£", "").replaceAll(",", ""));
        }, (int pProposedValue) -> true, DropDownNumericListUpdater.ListOperatingMode.ValueIsMax,
        true,
        // Use parameters
        pBrowser, pChangeSpecification);
  }

}

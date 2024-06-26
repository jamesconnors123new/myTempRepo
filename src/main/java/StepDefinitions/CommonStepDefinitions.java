package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import PageObjects.PortalModel.Root;
import helpers.SeleniumHelper;
import helpers.SyncType;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CommonStepDefinitions extends SeleniumHelper {


  public static final String POLICY_BALANCE = "PolicyBalance";

  public static final String HOME_INSURANCE_INFORMATION = "HomeInsurance";
  public static final String MOTOR_INSURANCE_INFORMATION = "MotorInsurance";
  public static final String VAN_INSURANCE_INFORMATION = "VanInsurance";

  public static final String JPH_PRESENT_FLAG = "JointPolicyHolderActive";
  public static final String JPH_DETAILS = "JointPolicyHolderDetails";
  public static final String ADDITIONAL_COVER_DETAILS = "AdditionalCoverDetails";
  public static final String ADDITIONAL_ADDRESS_DETAILS = "AdditionalAddressDetails";
  public static final String ADDITIONAL_DRIVER_DETAILS = "AdditionalDriverDetails";
  public static final String SEARCH_BY_POLICY_NUMBER = "PolicyNumber";
  public static final String POLICY_START_DATE = "PolicyStartDate";
  public static final String POLICY_END_DATE = "PolicyEndDate";
  public static final String POLICY_EXPIRES_IN = "PolicyExpiresIn";
  //public static final String MTA_EFFECTIVE_DATE = "MTAEffectiveDate";
  public static final String EARLIEST_ALLOWED_MTA_DATE = "EarliestAllowedMtaDate";

  public static final String MTA_ADDITIONAL_PREMIUM_AMOUNT = "AdditionalPremium";
  public static final String SEARCH_BY_FIRST_NAME = "Firstname";
  public static final String SEARCH_BY_LAST_NAME = "Lastname";
  public static final String SEARCH_BY_POSTCODE = "Postcode";
  public static final String SEARCH_BY_CLIENT_NUM = "ClientNumber";
  public static final String SEARCH_BY_WEB_REF = "WebReference";
  public static final String SEARCH_BY_DOB = "DateOfBirth";
  public static final String SEARCH_BY_EMAIL_ADD = "EmailAddress";
  public static final String INSURANCE_TYPE = "InsuranceType";
  //public static final String SEARCH_CRITERIA = "SearchCriteria";
  public static final String MOD_YEAR_NCD = "NCDYears";
  public static final String OCCUPATION = "Occupation";
  public static final String JPH = "Joint policy holder";
  public static final String PROPERTY_TYPE = "Property type";
  public static final String BEDROOMS = "Bedrooms";
  public static final String BATHROOMS = "Bathrooms";
  public static final String YEAR_BUILT = "Year built";
  public static final String OWNERSHIP = "Ownership";
  public static final String ADDRESS = "Address";

  //HOME COVER
  public static final String TYPE = "Type";
  public static final String COVER_CHANGE_START_DATE = "CoverChangeStartDate";
  public static final String MY_COVER_BUILDINGS = "Buildings";
  //EXCESS
  public static final String EXCESS_BUILDINGS = "Buildings";
  public static final String SUBSIDENCE_GROUND_LANDSLIP = "Subsidence, Ground Heave and Landslip";
  public static final String MOD_SUBSIDENCE_GROUND_LANDSLIP = "SubsidenceGroundHeaveLandslip";
  public static final String LEAKING_FREEZING = "Leaking or freezing of water or Leaking oil";
  public static final String MOD_LEAKING_FREEZING = "LeakingFreezing";
  public static final String FLOOD = "Flood";
  //ENHANCE_COVER
  public static final String EXCESS_PROTECTION = "Excess Protection";
  public static final String LEGAL_EXP = "Legal Expenses";
  public static final String EXTRA_HOME_EMERGENCY = "Ageas Extra Home Emergency";
  public static final String EXCESS_PROTECTION_SUBSIDENCE = "Home Excess Protection Subsidence";
  public static final String MOD_EXTRA_HOME_EMERGENCY = "ExtraHomeEmergency";

  //Van MY COVER
  @Getter
  public static final String CAR_MAKE = "Car Make";
  public static final String CAR_MODEL = "Car Model";
  public static final String YEAR_REG = "Year Registered";
  public static final String TRANSMISSION = "Transmission";
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
  public static final String CUSTOMER_PERSONAL_DET = "CustomerPersonalDetails";
  public static final String COVER_DET = "CoverDetails";
  public static final String EXCESS_DET = "ExcessDetails";
  public static final String ENHANCE_COVER_DET = "EnhanceCoverDetails";
  public static final String POLICY_ID = "PolicyId";
  public static final String PAGE_HEADING = "PageHeading";
  public static final String CURRENT_URL = "CurrentUrl";
  public static final String FAILED_MESSAGE = "Failed to execute %s. User is not on expected page";

  public static final String BUILDING_ACCIDENTAL_DAMAGE_COVER = "BuildingAccidentalDamageCover";
  public static final String CONTENT_ACCIDENTAL_DAMAGE_COVER = "ContentAccidentalDamageCover";
  public static final String BUILDING_VOLUNTARY_EXCESS = "BuildingVoluntaryExcess";
  public static final String CONTENT_VOLUNTARY_EXCESS = "ContentVoluntaryExcess";
  public static final String CONTENT_INSURANCE_HELD = "ContentInsuranceHeld";
  public static final String BUILDING_INSURANCE_HELD = "BuildingInsuranceHeld";

  public static final String VALUABLE_OVER_2000£ = "ValuableOver2000£";
  public static final String PERSONAL_BELONGING_AWAY_FROM_HOME = "PersonalBelongingAwayFromHome";
  public static final String INDIVIDUAL_ITEM_COVER = "IndividualItemCover";
  public static final String EXCHANGE_DATE = "ExchangeDate";
  public static final String HOME_DESCRIPTION ="HomeDescription";

  public static final String NUMBER_OF_BEDROOM ="NumberOfBedroom";
  public static final String NUMBER_OF_BATHROOM ="NumberOfBathroom";
  public static final String INTRUDER_ALARM ="IntruderAlarm";
  public static final String NUMBER_OF_ADULT ="NumberOfAdult";
  public static final String NUMBER_OF_CHILDREN ="NumberOfChildren";

  public static final String PET_DETAILS ="PetDetails";
  public static final String PAYING_GUEST ="PayingGuest";
  public static final String POST_CODE = "Postcode";
  public static final String DURATION_TO_MOVE ="DurationToMove";
  public static final String HOUSE_IDENTIFIER = "HouseIdentifier";


  public static final String SUMMARY_DETAILS = "SummaryDetails";
  public static final String PROPOSER_DETAILS = "ProposerDetails";
  public static final String VEHICLE_DETAILS = "VehicleDetails";
  public static final String EXCESS_DETAILS = "ExcessDetails";
  public static final String ADDITIONAL_DRIVER = "AdditionalDriver";

  public static final String MY_DETAILS = "MyDetails";
  public static final String MY_COVER = "MyCover";
  public static final String EXCESSES = "Excesses";
  public static final String ENHANCE_MY_COVER = "EnhanceMyCover";

  public static final String LEGAL_EXPENSES = "MotorLegalExpenses";
  public static final String KEY_PROTECTION = "MotorKeyProtection";
  public static final String BREAKDOWN_COVER = "MotorRoadsidePlus";




  private final WebDriver driver;
  private final SeleniumHelper SeleniumHelper;
  private final long waitDuration = 60000L;

  private final PortalLoginStepDefinition portalLoginPage;
  private final JointPolicyHolderStepDefinition JointPolicyHolderPage;


  public CommonStepDefinitions(WebDriver driver) {
    super(driver);
    this.driver = driver;
    this.SeleniumHelper = new SeleniumHelper(this.driver);
    Root pageObjectOfPortal = null;
    this.portalLoginPage = new PortalLoginStepDefinition(this.driver, pageObjectOfPortal);
    this.JointPolicyHolderPage = new JointPolicyHolderStepDefinition(this.driver, pageObjectOfPortal);
  }


  public String getSystemDataOrTime(String dateTimePattern) {
    LocalDateTime currentTime = LocalDateTime.now();
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(dateTimePattern);
    return timeFormatter.format(currentTime);
  }

  //public void quitBrowser() {
//    SeleniumHelper.getCurrentWebDriverInstance().quit();
//  }

//  public void acceptCookieBtn() throws CustomE2eException {
//    waitForPageLoad();
//    waitForElement(SharedLocatorLibrary.ACCEPT_COOKIE_BTN, SyncType.CLICKABLE);
//    clickElement(SharedLocatorLibrary.ACCEPT_COOKIE_BTN, SyncType.CLICKABLE);
//  }


//  public void signOutApplication() throws CustomE2eException {
//    if (isElementVisible(SharedLocatorLibrary.SIGN_OUT_BUTTON)) {
//      clickElement(SharedLocatorLibrary.SIGN_OUT_BUTTON, SyncType.CLICKABLE);
//      clickElement(SharedLocatorLibrary.ACCEPT_SIGNOUT, SyncType.CLICKABLE);
//    }
//    waitForElement(PortalLoginLocatorLibrary.LOG_IN_BTN, SyncType.VISIBLE);
//  }

//  public void continueButton() throws CustomE2eException {
//    clickElement(SharedLocatorLibrary.CONTINUE_BUTTON, SyncType.CLICKABLE);
//  }

  public SortedMap<String, Object> getDetails(By myDetailsFieldNameAndValue) throws CustomE2eException {
    waitForElement2(myDetailsFieldNameAndValue, SyncType.VISIBLE, waitDuration);
    var listOfValues = getTextAllWebElementMatchingLocator(myDetailsFieldNameAndValue);
    var MyDetails = new TreeMap<String, Object>();
    for (int valueCounter = 0; valueCounter < listOfValues.size(); ) {
      String key = listOfValues.get(valueCounter++);
      String value = listOfValues.get(valueCounter++);
      MyDetails.put(key, value);
    }
    return MyDetails;
  }


//  public Map<String, Object> getFilterBasedData(String sectionDetails,
//                                                Map<String, Object> searchCriteria) throws CustomE2eException, ParseException {
//    String filterValue = null;
//    String filterCriteria = null;
//    Map<String, Object> data = new HashMap<>();
//    List<String> normalizeFilterValue;
//    switch (searchCriteria.entrySet().stream().findFirst().get().getKey()) {
//      case SEARCH_BY_POLICY_NUMBER:
//        filterValue = (String) searchCriteria.get(SEARCH_BY_POLICY_NUMBER);
//        filterCriteria = SEARCH_BY_POLICY_NUMBER;
//        normalizeFilterValue = Formatting.getValuesInList(filterValue, ",");
//        List<String> policyNumTrimmed =
//            normalizeFilterValue.stream().map(String::trim).collect(Collectors.toList());
//        data = getDataBasedOnPolicyNumber(sectionDetails, (ArrayList<String>) policyNumTrimmed,
//            filterCriteria);
//        break;
//      case POLICY_START_DATE:
//        filterValue = (String) searchCriteria.get(POLICY_START_DATE);
//        filterCriteria = POLICY_START_DATE;
//        normalizeFilterValue = new ArrayList<>();
//        normalizeFilterValue = Formatting.getValuesInList(filterValue, ",");
//        List<String> policyStartDateTrimmed =
//            normalizeFilterValue.stream().map(String::trim).collect(Collectors.toList());
//        data = getDataBasedOnPolicyDate(sectionDetails,
//            (ArrayList<String>) policyStartDateTrimmed, filterCriteria);
//        break;
//      case POLICY_END_DATE:
//        filterValue = (String) searchCriteria.get(POLICY_END_DATE);
//        filterCriteria = POLICY_END_DATE;
//        normalizeFilterValue = new ArrayList<>();
//        normalizeFilterValue = Formatting.getValuesInList(filterValue, ",");
//        List<String> policyEndDateTrimmed =
//            normalizeFilterValue.stream().map(String::trim).collect(Collectors.toList());
//        data = getDataBasedOnPolicyDate(sectionDetails, (ArrayList<String>) policyEndDateTrimmed,
//            filterCriteria);
//        break;
//      case INSURANCE_TYPE:
//        filterValue = (String) searchCriteria.get(INSURANCE_TYPE);
//        filterCriteria = INSURANCE_TYPE;
//        normalizeFilterValue = new ArrayList<>();
//        normalizeFilterValue = Formatting.getValuesInList(filterValue, ",");
//        List<String> insuranceTypeTrimmed =
//            normalizeFilterValue.stream().map(String::trim).collect(Collectors.toList());
//        data = getDataBasedOnInsuranceType(sectionDetails,
//            (ArrayList<String>) insuranceTypeTrimmed, filterCriteria);
//        //var details = jointPolicyHolder.getJointPolicyHolderInformationFromUi();
//        break;
//      default:
//    }
//    return data;
//  }

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

//  private Map<String, Object> getDataBasedOnPolicyNumber(String section,
//                                                         ArrayList<String> filterValue,
//                                                         String filterCriteria) throws CustomE2eException, ParseException {
//    var vSourceViewOfHomePolicy = new TreeMap<String, Object>();
//    var motorDetails = new TreeMap<String, Object>();
//    var vanDetails = new TreeMap<String, Object>();
//    boolean policyFound = false;
//    var detail = new TreeMap<String, Object>();
//
//
//    ArrayList<String> listOfPolicies;
//    ArrayList<String> insuranceTabSearch = new ArrayList<>();
//
//    if (!filterValue.isEmpty()) {
//      Collections.sort(filterValue);
//      for (var policyNum : filterValue) {
//        if (policyNum.startsWith("GD")) {
//          insuranceTabSearch.add(MOTOR_INSURANCE_INFORMATION);
//        } else if (policyNum.startsWith("HE")) {
//          insuranceTabSearch.add(HOME_INSURANCE_INFORMATION);
//        } else if (policyNum.startsWith("MM")) {
//          insuranceTabSearch.add(VAN_INSURANCE_INFORMATION);
//        }
//      }
//    } else {
//      filterValue.add("ALL");
//      insuranceTabSearch.add(MOTOR_INSURANCE_INFORMATION);
//      insuranceTabSearch.add(HOME_INSURANCE_INFORMATION);
//      insuranceTabSearch.add(VAN_INSURANCE_INFORMATION);
//    }
//
//    for (var insuranceTab : insuranceTabSearch) {
//      if (insuranceTab.contains(MOTOR_INSURANCE_INFORMATION) && isElementVisible(PortalLoginLocatorLibrary.MY_MOTOR_TAB)) {
//        switchToInsuranceTab(CommonStepDefinitions.MOTOR_INSURANCE_INFORMATION);
//        ArrayList<Object> policyNumber = new ArrayList<>();
//        listOfPolicies = (ArrayList<String>) getListOfPolicies(filterValue);
//        try {
//          for (var policyNum : listOfPolicies) { //Loop inside InsuranceType
//            try {
//              switchToPolicy(policyNum, filterCriteria, MOTOR_INSURANCE_INFORMATION);
//              Map<String, Object> motor = fetchDetailsFromUiPolicyDetails(section);
//              policyNumber.add(motor);
//              motorDetails.put(policyNum, policyNumber);
//              policyFound = true;
//              filterValue.remove(String.valueOf(policyNum));
//            } catch (CustomE2eException e) {
//            }
//          }
//        } catch (ConcurrentModificationException ex) {
//
//        }
//        motorDetails.put(POLICY_START_DATE, getText(this.pageObjectOfPortal.getDashboardLocatorModel().POLICY_START_DATE));
//        motorDetails.put(POLICY_END_DATE, getText(this.pageObjectOfPortal.getDashboardLocatorModel().POLICY_END_DATE));
//        motorDetails.put(POLICY_EXPIRES_IN, getText(this.pageObjectOfPortal.getDashboardLocatorModel().POLICY_EXPIRES_IN));
//
//        var additionalDriverDetails = new TreeMap<String, Object>();
//        motorDetails.put(ADDITIONAL_DRIVER_DETAILS, additionalDriverDetails);
//
//        Double premiumAmount = getPremiumAmount();
//        motorDetails.put(MTA_ADDITIONAL_PREMIUM_AMOUNT, premiumAmount);
//        String effectiveDate = getText(QuoteCreationLocatorLibrary.getEFFECTIVE_DATE());
//        motorDetails.put(MTAEFFECTIVEDATE, Formatting.changeDateFormatIntoExpected(effectiveDate,
//            "dd MMM yyyy", "dd/MM/yyyy"));
//        detail.put(MOTOR_INSURANCE_INFORMATION, motorDetails);
//      }
//      if (insuranceTab.contains(HOME_INSURANCE_INFORMATION) && isElementVisible(PortalLoginLocatorLibrary.MY_HOME_TAB)) {
//        switchToInsuranceTab(CommonStepDefinitions.HOME_INSURANCE_INFORMATION);
//        ArrayList<Object> policyNumber = new ArrayList<>();
//        listOfPolicies = (ArrayList<String>) getListOfPolicies(filterValue);
//        try {
//          for (var policyNum : listOfPolicies) {
//            try {
//              switchToPolicy(policyNum, filterCriteria, HOME_INSURANCE_INFORMATION);
//              Map<String, Object> home = fetchDetailsFromUiPolicyDetails(section);
//              policyNumber.add(home);
//              vSourceViewOfHomePolicy.put(policyNum, policyNumber);
//              policyFound = true;
//              filterValue.remove(String.valueOf(policyNum));
//            } catch (CustomE2eException e) {
//
//            }
//          }
//        } catch (ConcurrentModificationException ex) {
//
//        }
//
//        vSourceViewOfHomePolicy.put(POLICY_START_DATE,
//            getText(DashboardLocatorLibrary.HOME_POLICY_START_DATE));
//        vSourceViewOfHomePolicy.put(POLICY_END_DATE,
//            getText(DashboardLocatorLibrary.HOME_POLICY_END_DATE));
//
//        vSourceViewOfHomePolicy.put(POLICY_EXPIRES_IN, getPolicyExpiresInDays());
//        var effectiveDate = getEffectiveDate(QuoteCreationLocatorLibrary.getCHANGE_TEXT());
//        CommonHelper.extractDateFromString(LocalDate.now(), effectiveDate);
//        //vSourceViewOfHomePolicy.put(MTAEFFECTIVEDATE, effectiveDate); NH 8/9/23 - Concept not
//        // sound
//
//        //Premium Amount
//        Double premiumAmount = getPremiumAmount();
//        vSourceViewOfHomePolicy.put(MTA_ADDITIONAL_PREMIUM_AMOUNT, premiumAmount);
//        var jointPolicyHolderDetails =
//            JointPolicyHolderPage.getJointPolicyHolderInformationFromUi();
//        vSourceViewOfHomePolicy.put(JPH_DETAILS, jointPolicyHolderDetails);
//        var additionalCoverDetails = getAdditionalCoverDetails();
//        vSourceViewOfHomePolicy.put(ADDITIONAL_COVER_DETAILS, additionalCoverDetails);
//        var addressDetails = getAddressDetails();
//        vSourceViewOfHomePolicy.put(ADDITIONAL_ADDRESS_DETAILS, addressDetails);
//        detail.put(HOME_INSURANCE_INFORMATION, vSourceViewOfHomePolicy);
//      }
//    }
//
//    if (!policyFound) {
//      throw new CustomE2eException("Policy not found.");
//    }
//    return detail;
//  }

//  public SortedMap<String, Object> getAddressDetails() throws CustomE2eException, ParseException {
//    SortedMap<String, Object> additionalAddressDetail = new TreeMap<>();
//    waitForElement2(SharedLocatorLibrary.EDIT_ADDRESS, SyncType.CLICKABLE, waitDuration);
//    RetryOnClickInterceptedException(10, () -> clickElement(SharedLocatorLibrary.EDIT_ADDRESS,
//        SyncType.CLICKABLE));
//    waitForPageLoad();
//    var listOfQuestion =
//        getTextAllWebElementMatchingLocator(SharedLocatorLibrary.GET_COVER_QUESTIONS);
//    int countOfListOfQue = listOfQuestion.size() - 1;
//    for (int listOfQuestionVar = 0; listOfQuestionVar <= countOfListOfQue; listOfQuestionVar++) {
//      var que = listOfQuestion.get(listOfQuestionVar);
//      if (que.contains("\n")) {
//        que = que.split("\n")[0];
//      }
//      int positionOfElement = listOfQuestionVar + 1;
//      switch (que) {
//        case "When is your exchange date?":
//          var exchangeDate = getExchangeDate(xpathBuilder(SharedLocatorLibrary.ANSWER_DROP_DOWN,
//              String.valueOf(positionOfElement)));
//          var year = Year.now().getValue();
//          var formattedDate = Formatting.changeDateFormatIntoExpected(exchangeDate, "EEEE, dd MMM",
//              "dd/MM/" + year);
//          additionalAddressDetail.put(EXCHANGE_DATE, formattedDate);
//          break;
//        case "House name or number":
//          //Text
//          var houseIdentifier = getAttribute(SharedLocatorLibrary.HOUSE_IDENTIFIER, "value",
//              "Element not found");
//          additionalAddressDetail.put(HOUSE_IDENTIFIER, houseIdentifier);
//          break;
//        case "Postcode":
//          var postcode = getAttribute(SharedLocatorLibrary.POST_CODE, "value",
//              "Element not found");
//          additionalAddressDetail.put(POST_CODE, postcode);
//          break;
//        case "How long after the exchange date will you be moving into your new home?":
//          //Choice Question
//          var durationToMove =
//              Formatting.capitalizeFirstCharacter(getDurationToMove(xpathBuilder(SharedLocatorLibrary.CHOICE_ANSWER_SELECTED, String.valueOf(positionOfElement))));
//          additionalAddressDetail.put(DURATION_TO_MOVE, durationToMove);
//          break;
//        case "Property Type":
//          var propertyType =
//              Formatting.capitalizeFirstCharacter(getPropertyType(xpathBuilder(SharedLocatorLibrary.CHOICE_ANSWER_SELECTED, String.valueOf(positionOfElement))));
//          additionalAddressDetail.put(Formatting.capitalizeAllFirstCapitalizeRemoveSpace(CommonStepDefinitions.PROPERTY_TYPE), propertyType);
//          break;
//        case "What best describes your home?":
//          var homeDesc = getHomeDesc(xpathBuilder(SharedLocatorLibrary.ANSWER_DROP_DOWN,
//              String.valueOf(positionOfElement)));
//          additionalAddressDetail.put(HOME_DESCRIPTION, homeDesc);
//          break;
//        case "Is your home built of standard construction?":
//          //Choice Question
//          break;
//        case "How many bedrooms and bathrooms does your home have?":
//          var numberOfBedroom =
//              getNumberOfBedroom(xpathBuilder(SharedLocatorLibrary.ANSWER_DROP_DOWN,
//                  String.valueOf(positionOfElement)));
//          additionalAddressDetail.put(NUMBER_OF_BEDROOM, numberOfBedroom);
//          var numberOfBathroom =
//              getNumberOfBathroom(xpathBuilder(SharedLocatorLibrary.ANSWER_DROP_DOWN,
//                  String.valueOf(++positionOfElement)));
//          additionalAddressDetail.put(NUMBER_OF_BATHROOM, numberOfBathroom);
//          break;
//        case "When was your home built?":
//          var homeBuiltYear = getHomeBuiltYear(xpathBuilder(SharedLocatorLibrary.ANSWER_DROP_DOWN,
//              String.valueOf(++positionOfElement)));
//          break;
//        case "Has your home been extended?":
//          //Choice Question
//          break;
//        case "Is your home a listed building?":
//          //Choice Question
//          break;
//        case "Has your home flooded at any time in the last 25 years?":
//          //Choice Question
//          break;
//        case "Is your home fitted with five-lever mortice deadlocks or a multi-point locking " +
//            "system on all external doors, and key-operated window locks on all ground-level " +
//            "windows and accessible upper floor windows?":
//          //Choice Question
//          break;
//        case "Is an intruder alarm installed?":
//          var intruderAlarm =
//              getIntruderAlarmDetails(xpathBuilder(SharedLocatorLibrary.ANSWER_DROP_DOWN,
//              String.valueOf(++positionOfElement)));
//          additionalAddressDetail.put(INTRUDER_ALARM, intruderAlarm);
//          break;
//        case "Do you own or rent your home?":
//          //Choice Question
//          break;
//        case "Is your correspondence address the same as the property you are insuring?":
//          //Choice Question
//          break;
//        case "How many adults live at your home?":
//          var numberOfAdult =
//              getNumberOfAdult(xpathBuilder(SharedLocatorLibrary.ANSWER_DROP_DOWN,
//                  String.valueOf(positionOfElement)));
//          additionalAddressDetail.put(NUMBER_OF_ADULT, numberOfAdult);
//          break;
//        case "How many children live at your home?":
//          var numberOfChildren =
//              getNumberOfChildren(xpathBuilder(SharedLocatorLibrary.ANSWER_DROP_DOWN,
//                  String.valueOf(positionOfElement)));
//          additionalAddressDetail.put(NUMBER_OF_CHILDREN, numberOfChildren);
//
//          break;
//        case "Do you have any pets living at your home?":
//          var petDetails =
//              getPetDetails(xpathBuilder(SharedLocatorLibrary.ANSWER_DROP_DOWN,
//                  String.valueOf(positionOfElement)));
//          additionalAddressDetail.put(PET_DETAILS, petDetails);
//          break;
//        case "Do you have any paying guests living at your home?":
//          var payingGuestDetails =
//              getPayingGuestDetails(xpathBuilder(SharedLocatorLibrary.ANSWER_DROP_DOWN,
//                  String.valueOf(positionOfElement)));
//          additionalAddressDetail.put(PAYING_GUEST, payingGuestDetails);
//          break;
//        case "Is any part of your home used for business purposes?":
//          //Choice Question
//          break;
//        default:
//      }
//    }
//
//    return additionalAddressDetail;
//  }
//
//  private String getDurationToMove(By component) throws CustomE2eException {
//    String duration;
//      var getDurationToMove = getElementsMatchingToLocator(component);
//       duration = getAnswerSelected(getDurationToMove);
//      return duration;
//  }


//  public SortedMap<String, Object> getAdditionalCoverDetails() throws CustomE2eException,
//      ParseException {
//    SortedMap<String, Object> additionalCoverDetail = new TreeMap<>();
//    waitForElement2(SharedLocatorLibrary.EDIT_COVER, SyncType.CLICKABLE, waitDuration);
//    RetryOnClickInterceptedException(10, () -> clickElement(SharedLocatorLibrary.EDIT_COVER,
//        SyncType.CLICKABLE));
//    waitForPageLoad();
//    int voluntaryDropDown = 1;
//    var listOfQuestion =
//        getTextAllWebElementMatchingLocator(SharedLocatorLibrary.GET_COVER_QUESTIONS);
//    int countOfListOfQue = listOfQuestion.size() - 1;
//    for (int listOfQuestionVar = 0; listOfQuestionVar <= countOfListOfQue; listOfQuestionVar++) {
//      var que = listOfQuestion.get(listOfQuestionVar);
//      int positionOfElement = listOfQuestionVar + 1;
//      if (que.contains("\n")) {
//        que = que.split("\n")[0];
//      }
//      switch (que) {
//        case "What date would you like the change to start?":
//          var coverDate = getCoverStartDate(xpathBuilder(SharedLocatorLibrary.ANSWER_DROP_DOWN,
//              String.valueOf(positionOfElement)));
//          var year = Year.now().getValue();
//          var formattedDate = Formatting.changeDateFormatIntoExpected(coverDate, "EEEE, dd MMM",
//              "dd/MM/" + year);
//          additionalCoverDetail.put(Formatting.capitalizeAllFirstCapitalizeRemoveSpace(CommonStepDefinitions.COVER_CHANGE_START_DATE), formattedDate);
//          break;
//        case "Do you require buildings accidental damage cover?":
//          var accidentalDamageCover =
//              Formatting.capitalizeFirstCharacter(getAccidentalDamageCover(xpathBuilder(SharedLocatorLibrary.CHOICE_ANSWER_SELECTED, String.valueOf(positionOfElement))));
//          additionalCoverDetail.put(BUILDING_ACCIDENTAL_DAMAGE_COVER, accidentalDamageCover);
//          break;
//        case "What level of voluntary excess do you require?":
//          var voluntaryExcess =
//              getVoluntaryExcess(xpathBuilder(SharedLocatorLibrary.VOLUNTARY_DROP_DOWN,
//                  String.valueOf(voluntaryDropDown)));
//          if (voluntaryDropDown == 1) {
//            additionalCoverDetail.put(BUILDING_VOLUNTARY_EXCESS, voluntaryExcess);
//          } else {
//            additionalCoverDetail.put(CONTENT_VOLUNTARY_EXCESS, voluntaryExcess);
//          }
//          voluntaryDropDown++;
//          break;
//        case "Have you held contents insurance within the last 2 years?":
//          var contentInsuranceHeld =
//              Formatting.capitalizeFirstCharacter(getContentInsuranceHeld(xpathBuilder(SharedLocatorLibrary.CHOICE_ANSWER_SELECTED, String.valueOf(positionOfElement))));
//          additionalCoverDetail.put(CONTENT_INSURANCE_HELD, contentInsuranceHeld);
//          break;
//        case "How much would you like to insure your household contents for?":
//          var insureHouseholdContent =
//              getInsureHouserholdContent(xpathBuilder(SharedLocatorLibrary.ANSWER_DROP_DOWN,
//                  String.valueOf(positionOfElement)));
//          additionalCoverDetail.put(BUILDING_INSURANCE_HELD, insureHouseholdContent);
//          break;
//        case "Do you require contents accidental damage cover?":
//          var contentAccidentalDamageCover =
//              Formatting.capitalizeFirstCharacter(getContentAccidentalDamageCover(xpathBuilder(SharedLocatorLibrary.CHOICE_ANSWER_SELECTED, String.valueOf(positionOfElement))));
//          additionalCoverDetail.put(CONTENT_ACCIDENTAL_DAMAGE_COVER, contentAccidentalDamageCover);
//          break;
//        case "Do you have any valuables over £2,000 that you don't take outside of the home?":
//          var valuableOver2000 =
//              Formatting.capitalizeFirstCharacter(getOver2000Valuable(xpathBuilder(SharedLocatorLibrary.CHOICE_ANSWER_SELECTED, String.valueOf(positionOfElement))));
//          additionalCoverDetail.put(VALUABLE_OVER_2000£, valuableOver2000);
//          //get List of Items to store
//          break;
//        case "Would you like extra cover for personal belongings away from the home?":
//          var extraCoverPersonalBelongingsAway =
//              Formatting.capitalizeFirstCharacter(getExtraCoverPersonalBelongingsAway(xpathBuilder(SharedLocatorLibrary.CHOICE_ANSWER_SELECTED, String.valueOf(positionOfElement))));
//          additionalCoverDetail.put(VALUABLE_OVER_2000£, extraCoverPersonalBelongingsAway);
//          //get List of Items to store
//          break;
//        case "How much cover would you like for personal belongings away from the home?":
//          var personalBelongingAwayFromHome =
//              getPersonalBelonging(xpathBuilder(SharedLocatorLibrary.ANSWER_DROP_DOWN,
//                  String.valueOf(positionOfElement)));
//          additionalCoverDetail.put(PERSONAL_BELONGING_AWAY_FROM_HOME,
//              personalBelongingAwayFromHome);
//          break;
//        case "Would you like cover for any individual items away from the home?":
//          var coverIndividualItems =
//              Formatting.capitalizeFirstCharacter(getCoverIndividualItems(xpathBuilder(SharedLocatorLibrary.CHOICE_ANSWER_SELECTED, String.valueOf(positionOfElement))));
//
//          additionalCoverDetail.put(INDIVIDUAL_ITEM_COVER, coverIndividualItems);
//          break;
//        default:
//      }
//    }
//    clickElement(SharedLocatorLibrary.COVER_BACK_BUTTON, SyncType.CLICKABLE);
//    clickElement(SharedLocatorLibrary.YES_DIALOG_BOX, SyncType.CLICKABLE);
//    return additionalCoverDetail;
//  }

  public String getPropertyType(By component) throws CustomE2eException {
    var getPropetyType = getElementsMatchingToLocator(component);
    return getAnswerSelected(getPropetyType);
  }

  private String getNumberOfAdult(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }

  private String getPayingGuestDetails(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }

  private String getPetDetails(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }

  private String getNumberOfChildren(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }

  private String getIntruderAlarmDetails(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }

  private String getNumberOfBedroom(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }

  private String getHomeBuiltYear(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }

  private String getNumberOfBathroom(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }

  private String getHomeDesc(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }

  private String getExchangeDate(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }

  private String getCoverStartDate(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }

  private String getAccidentalDamageCover(By component) throws CustomE2eException {
    var getChildNodes = getElementsMatchingToLocator(component);
    return getAnswerSelected(getChildNodes);
  }

  public String getCoverIndividualItems(By component) throws CustomE2eException {
    var getChildNodes = getElementsMatchingToLocator(component);
    return getAnswerSelected(getChildNodes);
    //getSpecified Items if answer is yes
  }

  public String getPersonalBelonging(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }


  public String getExtraCoverPersonalBelongingsAway(By component) throws CustomE2eException {
    var getChildNodes = getElementsMatchingToLocator(component);
    return getAnswerSelected(getChildNodes);
  }

  public String getOver2000Valuable(By component) throws CustomE2eException {
    var getChildNodes = getElementsMatchingToLocator(component);
    return getAnswerSelected(getChildNodes);
  }

  public String getContentAccidentalDamageCover(By component) throws CustomE2eException {
    var getChildNodes = getElementsMatchingToLocator(component);
    return getAnswerSelected(getChildNodes);
  }

  public String getInsureHouserholdContent(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }

  public String getContentInsuranceHeld(By component) throws CustomE2eException {
    var getChildNodes = getElementsMatchingToLocator(component);
    return getAnswerSelected(getChildNodes);
  }

  public String getVoluntaryExcess(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }

  public String getAnswerSelected(List<WebElement> getChildNodes) throws CustomE2eException {
    String selectedChoice = "";
    for (var element : getChildNodes) {
      if (element.isSelected()) {
        selectedChoice = element.getAttribute("value");
        break;
      }
    }
    return selectedChoice;
  }


//  long getPolicyExpiresInDays() throws CustomE2eException {
//    var vUiText = this.getText(DashboardLocatorLibrary.POLICY_EXPIRES_IN);
//    var vNumericText = vUiText.substring(0, vUiText.indexOf(' '));
//    var vValue = Long.parseLong(vNumericText);
//    return vValue;
//  }
//
//  private double getPremiumAmount() throws CustomE2eException {
//    double premiumAmount = 0.0;
//    if (isElementVisible(DashboardLocatorLibrary.getCOMPLETE_PAYMENT())) {
//      clickElement(DashboardLocatorLibrary.getCOMPLETE_PAYMENT(), SyncType.CLICKABLE);
//      if (isElementVisible(DashboardLocatorLibrary.PREMIUM_PAYMENT)) {
//        premiumAmount =
//            Double.parseDouble(Formatting.getTextFromRegex(tryGetText(DashboardLocatorLibrary.PREMIUM_PAYMENT), "\\d{1,4}.\\d{1,2}"));
//      }
//    }
//    return premiumAmount;
//  }

//  public void selectClient() throws CustomE2eException {
//    clickElement(EchelonHomeLocatorLibrary.CLIENT_SELECT_BTN, SyncType.CLICKABLE);
//  }
//
//  private String getEffectiveDate(By byLocator) throws CustomE2eException, ParseException {
//    LocalDate effectiveDate = LocalDate.now();
//    if (isElementVisible(byLocator)) {
//      var changeTextOnPortal = getText(byLocator);
//      effectiveDate = CommonHelper.extractDateFromString(LocalDate.now(), changeTextOnPortal);
//    }
//    return Formatting.changeDateFormatIntoExpected(effectiveDate.toString(), "yyyy-MM-dd", "dd/MM"
//        + "/yyyy");
//  }

//  private Map<String, Object> getDataBasedOnInsuranceType(String section,
//                                                          ArrayList<String> filterValue,
//                                                          String filterCriteria) {
//    Map<String, Object> data = new HashMap<>();
//
//    return data;
//  }
//
//
//  private Map<String, Object> getDetailsOfPolicy(Map<String, Object> policyDetails) {
//
//    Map<String, Object> returnFormat = new HashMap<>();
//
//    //count policies
//
//    return returnFormat;
//
//  }

//  private List<String> getListOfPolicies(List<String> listOfPolicies) throws CustomE2eException {
//    if (listOfPolicies.contains(String.valueOf("ALL"))) {
//      listOfPolicies = getAllPolicyNumber();
//    }
//    return listOfPolicies;
//  }
//
//  public void switchToInsuranceTab(String insuranceType) throws CustomE2eException {
//    switch (insuranceType) {
//      case CommonStepDefinitions.HOME_INSURANCE_INFORMATION:
//      case "Home":
//        portalLoginPage.redirectToHomeTab();
//        break;
//      case CommonStepDefinitions.MOTOR_INSURANCE_INFORMATION:
//      case "Motor":
//        portalLoginPage.redirectToCarTab();
//        break;
//      case CommonStepDefinitions.VAN_INSURANCE_INFORMATION:
//      case "Van":
//        portalLoginPage.redirectToVanTab();
//        break;
//      default:
//    }
//  }

//  private SortedMap<String, Object> fetchDetailsFromUiPolicyDetails(String section) throws CustomE2eException {
//    SortedMap<String, Object> details = new TreeMap<>();
//    SortedMap<String, Object> myDetails;
//    SortedMap<String, Object> coverDetails;
//    SortedMap<String, Object> excessDetails;
//    SortedMap<String, Object> enhanceCoverDetails;
//
//    if (section == null) {
//      section = "All";
//    }
//    switch (section) {
//      case GetCustomerDetailsPortal.MY_DETAILS:
//        clickElement(SharedLocatorLibrary.MY_DETAILS_SECTION, SyncType.CLICKABLE);
//        myDetails = getDetails(SharedLocatorLibrary.MY_DETAILS_FIELD_NAME_AND_VALUE);
//        details.put(GetCustomerDetailsPortal.CUSTOMER_DETAILS, myDetails);
//        break;
//      default:
//        clickElement(SharedLocatorLibrary.MY_DETAILS_SECTION, SyncType.CLICKABLE);
//        waitForElement(SharedLocatorLibrary.getMY_DET_SEC_INFO(), SyncType.VISIBLE);
//        myDetails = getDetails(SharedLocatorLibrary.MY_DETAILS_FIELD_NAME_AND_VALUE);
//        details.put(GetCustomerDetailsPortal.CUSTOMER_DETAILS, myDetails);
//
//        clickElement(SharedLocatorLibrary.MY_COVER_SECTION, SyncType.CLICKABLE);
//        waitForElement(SharedLocatorLibrary.getMY_COVER_SEC_INFO(), SyncType.VISIBLE);
//        coverDetails = getDetails(SharedLocatorLibrary.MY_COVER_FIELD_NAME_AND_VALUE);
//        details.put(GetPolicyInformationPortal.MY_COVER, coverDetails);
//
//        clickElement(SharedLocatorLibrary.EXCESSES_SECTION, SyncType.CLICKABLE);
//        waitForElement(SharedLocatorLibrary.getEXCESSES_SEC_INFO(), SyncType.VISIBLE);
//        excessDetails = getDetails(SharedLocatorLibrary.EXCESS_FIELD_NAME_AND_VALUE);
//        details.put(GetPolicyInformationPortal.MY_EXCESSES, excessDetails);
//
//        clickElement(SharedLocatorLibrary.ENHANCE_MY_COVER_SECTION, SyncType.CLICKABLE);
//        waitForElement(SharedLocatorLibrary.getENHANCE_MY_COVER_SEC_INFO(), SyncType.VISIBLE);
//        enhanceCoverDetails = getEnhancedCover();
//        details.put(GetPolicyInformationPortal.ENHANCE_COVER, enhanceCoverDetails);
//        break;
//    }
//    return details;
//  }

//  public SortedMap<String, Object> getEnhancedCover() {
//    var enhanceCover = new TreeMap<String, Object>();
//    var addedCovers = getTextAllWebElementMatchingLocator(SharedLocatorLibrary.ENHANCE_COVER_ADDED);
//    var notAddedCovers =
//        getTextAllWebElementMatchingLocator(SharedLocatorLibrary.ENHANCE_COVER_NOT_ADDED);
//
//    enhanceCover.put(EXCESS_PROTECTION_SUBSIDENCE, false);
//
//    if (addedCovers.toString().contains(EXCESS_PROTECTION)) {
//      enhanceCover.put(EXCESS_PROTECTION, true);
//    }
//    if (addedCovers.toString().contains(LEGAL_EXP)) {
//      enhanceCover.put(LEGAL_EXP, true);
//    }
//    if (addedCovers.toString().contains(EXTRA_HOME_EMERGENCY)) {
//      enhanceCover.put(EXTRA_HOME_EMERGENCY, true);
//    }
//    if (notAddedCovers.toString().contains(EXCESS_PROTECTION)) {
//      enhanceCover.put(EXCESS_PROTECTION, false);
//    }
//    if (notAddedCovers.toString().contains(LEGAL_EXP)) {
//      enhanceCover.put(LEGAL_EXP, false);
//    }
//    if (notAddedCovers.toString().contains(EXTRA_HOME_EMERGENCY)) {
//      enhanceCover.put(EXTRA_HOME_EMERGENCY, false);
//    }
//    return enhanceCover;
//  }
//
//
//  public List<String> getAllPolicyNumber() throws CustomE2eException {
//    List<String> listPolicyNumber = new ArrayList<>();
//    Select selectOption =
//        new Select(SeleniumHelper.findElement(SharedLocatorLibrary.POLICY_DROP_DOWN,
//            SyncType.VISIBLE, "Failed to fetch policy numbers"));
//    var allOptions = selectOption.getOptions();
//    for (var option : allOptions) {
//      SeleniumHelper.selectDropdown(SharedLocatorLibrary.POLICY_DROP_DOWN, option.getText(),
//          SelectOptions.TEXT);
//      listPolicyNumber.add(getText(SharedLocatorLibrary.POLICY_NUMBER));
//    }
//    return listPolicyNumber;
//  }

//  public boolean switchToPolicy(String expectedValue, String filterCriteria,
//                                String insuranceType) throws CustomE2eException {
//    boolean policyFound = false;
//    String actualValue = null;
//
//    if (filterCriteria.equalsIgnoreCase(POLICY_START_DATE) || filterCriteria.equalsIgnoreCase(POLICY_END_DATE)) {
//      if (insuranceType.equalsIgnoreCase(HOME_INSURANCE_INFORMATION)) {
//        actualValue = getText(SharedLocatorLibrary.POLICY_START_DATE_HOME);
//      } else if (insuranceType.equalsIgnoreCase(MOTOR_INSURANCE_INFORMATION)) {
//        actualValue = getText(SharedLocatorLibrary.POLICY_START_DATE_MOTOR);
//      }
//    } else if (filterCriteria.equalsIgnoreCase(SEARCH_BY_POLICY_NUMBER)) {
//      actualValue = getText(SharedLocatorLibrary.POLICY_NUMBER);
//    }
//
//    if (expectedValue.equalsIgnoreCase(actualValue)) {
//      policyFound = true;
//    } else if (!(expectedValue.equalsIgnoreCase(actualValue))) {
//      if (filterCriteria.equalsIgnoreCase(SEARCH_BY_POLICY_NUMBER)) {
//        Select selectOption =
//            new Select(SeleniumHelper.findElement(SharedLocatorLibrary.POLICY_DROP_DOWN,
//                SyncType.VISIBLE, "Selecting address from dropdown failed."));
//        var allOptions = selectOption.getOptions();
//        for (var option : allOptions) {
//          selectDropdown(SharedLocatorLibrary.POLICY_DROP_DOWN, option.getText(),
//              SelectOptions.TEXT);
//          actualValue = getText(SharedLocatorLibrary.POLICY_NUMBER);
//          if (expectedValue.equalsIgnoreCase(actualValue)) {
//            policyFound = true;
//            break;
//          }
//        }
//      } else if (filterCriteria.equalsIgnoreCase(POLICY_START_DATE)) {
//        Select selectOption =
//            new Select(SeleniumHelper.findElement(SharedLocatorLibrary.POLICY_DROP_DOWN,
//                SyncType.VISIBLE, "Selecting address from dropdown failed."));
//        var allOptions = selectOption.getOptions();
//        for (var option : allOptions) {
//          selectDropdown(SharedLocatorLibrary.POLICY_DROP_DOWN, option.getText(),
//              SelectOptions.TEXT);
//          if (insuranceType.equalsIgnoreCase(HOME_INSURANCE_INFORMATION)) {
//            actualValue = getText(SharedLocatorLibrary.POLICY_START_DATE_HOME);
//          } else if (insuranceType.equalsIgnoreCase(MOTOR_INSURANCE_INFORMATION)) {
//            actualValue = getText(SharedLocatorLibrary.POLICY_START_DATE_MOTOR);
//          }
//          if (expectedValue.equalsIgnoreCase(actualValue)) {
//            policyFound = true;
//            break;
//          }
//        }
//      }
//      if (!policyFound) {
//        throw new CustomE2eException(expectedValue + " policy not found.");
//      }
//    }
//    return policyFound;
//  }

//    public void waitForSpinnerToDisappear() {
//        try {
//            if (isElementVisible(SharedLocatorLibrary.SPINNER)) {
//                waitForElementToInvisible(SharedLocatorLibrary.SPINNER);
//            }
//        } catch(Throwable pThrown) {
//            throw pThrown;
//        }
//    }


//  public void redirectToPaymentTab() throws CustomE2eException {
//    clickElement(xpathBuilder(DashboardLocatorLibrary.getTAB_REDIRECT(), "Payments"),
//        SyncType.CLICKABLE);
//  }
}

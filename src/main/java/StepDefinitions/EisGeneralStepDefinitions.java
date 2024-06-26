package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import activities.CommonControlDataDefns;
import activities.GetPolicyDetailsEis;
import helpers.*;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;
import java.util.function.Predicate;

public class EisGeneralStepDefinitions extends CdlEisHelpers {

  public static final String TITLE = "Title";
  public static final String NAME = "Name";
  public static final String LAST_NAME = "LastName";
  public static final String EMAIL_ADDRESS = "Email address";
  public static final String PHONE_NUMBER = "Phone number";
  public static final String DATE_OF_BIRTH = "Date of birth";
  public static final String EMPLOYMENT_STATUS = "Employment Status";
  public static final String RELATIONSHIP_STATUS = "Relationship status";

  public static final String AGEAS_BRAND_DIRECT_VAR = "Ageas Direct";
  public static final String DIRECT_DEBIT = "DirectDebit";
  public static final String OWNERSHIP = "Ownership";
  public static final String PROPERTY_TYPE = "Property type";
  public static final String OCCUPATION = "Occupation";
  public static final String BEDROOMS = "Bedrooms";
  public static final String BATHROOMS = "Bathrooms";
  public static final String YEAR_BUILT = "Year built";
  public static final String TYPE = "Type";
  public static final String HOME_EXTENSION_DETAILS = "InsuredHomeExtensionDetails";
  public static final String HOME_LISTING_DETAILS = "InsuredHomeListingDetails";
  public static final String HOME_OCCUPIED_DETAILS = "InsuredHomeOccupiedDetails";
  public static final String HOME_LOCKING_DETAILS = "InsuredHomeLockingDetails";
  public static final String HOME_BUILT_DETAILS = "InsuredHomeBuiltDetails";
  public static final String HOME_USE_DETAILS = "InsuredHomeUseDetails";
  public static final String HOME_INTRUDER_ALARM_DETAILS = "InsuredHomeIntruderAlarmDetails";
  public static final String HOME_NUMBER_OF_ADULT_DETAILS = "InsuredHomeNumberOfAdultDetails";
  public static final String HOME_NUMBER_OF_CHILD_DETAILS = "InsuredHomeNumberOfChildDetails";
  public static final String HOME_PAYING_GUEST_DETAILS = "InsuredHomePayingGuestDetails";
  public static final String HOME_PET_DETAILS = "InsuredHomePetDetails";
  public static final String HOME_CLERICAL_USE_DETAILS = "InsuredHomeClericalUseDetails";


  public static final String JPH_NAME = "Joint Policy holder";
  public static final String INSURED_ADDRESS = "Insured address";
  public static final String INSURED_ADDRESS_DETAILS = "InsuredAddressDetails";
  public static final String SEARCH_BY_POLICY_NUMBER = "PolicyNumber";
  public static final String POLICY_START_DATE = "PolicyStartDate";
  public static final String POLICY_END_DATE = "PolicyEndDate";
  public static final String POLICY_EXPIRES_IN = "PolicyExpiresIn";

  public static final String BUILDINGS_COVER_AMOUNT = "Buildings (including accidental damage)";
  public static final String CONTENTS_COVER_AMOUNT = "Contents (including accidental damage)";

  public static final String CONTENTS_MY_COVER = "Contents";
  public static final String COMPULSORY_EXCESS_BUILDINGS_VAR = "Buildings";
  public static final String COMPULSORY_EXCESS_CONTENT_VAR = "Contents";
  public static final String SUBSIDENCE_GROUND_LANDSLIP = "Subsidence, Ground Heave and Landslip";
  public static final String LEAKING_FREEZING = "Leaking or freezing of water or Leaking oil";
  public static final String FLOOD = "Flood";

  public static final String CUSTOMER_PERSONAL_DET = "CustomerDetails";
  public static final String COVER_DET = "MyCover";
  public static final String EXCESS_DET = "Excesses";
  public static final String ENHANCE_COVER_DET = "EnhanceMyCover";
  public static final String POLICY_ID = "PolicyId";
  public static final String ADDITIONAL_COVER_DETAILS = "AdditionalCoverDetails";
  public static final String BUILDING_ACCIDENTAL_DAMAGE_COVER = "BuildingAccidentalDamageCover";
  public static final String CONTENT_ACCIDENTAL_DAMAGE_COVER = "ContentAccidentalDamageCover";

  public static final String CONTENT_INSURANCE_HELD = "ContentInsuranceHeld";

  public static final String VALUABLE_OVER_2000£ = "ValuableOver2000£";
  public static final String PERSONAL_BELONGING_AWAY_FROM_HOME = "PersonalBelongingAwayFromHome";
  public static final String PERSONAL_BELONGING_AWAY_FROM_HOME_COST =
      "PersonalBelongingAwayFromHomeCost";
  public static final String INDIVIDUAL_ITEM_COVER = "IndividualItemCover";
  public static final String NUMBER_OF_CHILDREN = "NumberOfChildren";
  public static final String POST_CODE = "Postcode";
  //Joint Policyholder
  public static final String JPH_DATE_OF_BIRTH = "DateOfBirth";
  public static final String JPH_EMPLOYMENT_DETAILS = "EmploymentDetails";
  public static final String JPH_INDUSTRY_TYPE = "IndustryType";
  public static final String JPH_LAST_NAME = "LastName";
  public static final String JPH_MARITAL_STATUS = "MaritalStatus";
  public static final String JPH_OCCUPATION = "Occupation";
  public static final String JPH_RELATIONSHIP_STATUS = "RelationshipStatus";
  public static final String JPH_SECOND_JOB = "SecondJobStatus";
  public static final String JPH_TITLE = "Title";

  public static final String SALES_DETAILS_VAR = "SalesDetails";
  public static final String MARKETING_CHOICE_VAR = "MarketingChoice";
  public static final String MARKETING_CHOICE_SMS_VAR = "SMS";
  public static final String MARKETING_CHOICE_EMAIL_VAR = "Email";
  public static final String MARKETING_CHOICE_POSTAL_VAR = "Postal";
  public static final String MARKETING_CHOICE_TELEPHONE_VAR = "Telephone";
  public static final String POST_CODE_VAR = "Postcode";
  //    public static final String ADDRESS_SELECTOR_VAR = "AddressSelector";
  public static final String CORRESPONDENCE_ADDRESS = "CorrespondenceAddress";
  public static final String HOUSE_IDENTIFIER_VAR = "HouseIdentifier";
  public static final String EMAIL_ADDRESS_VAR = "EmailAddress";

  public static final String TITLE_VAR = "Title";
  public static final String FIRST_NAME_VAR = "FirstName";
  public static final String LAST_NAME_VAR = "LastName";
  public static final String DATE_OF_BIRTH_VAR = "DateOfBirth";
  public static final String GENDER_VAR = "Gender";
  public static final String MARITAL_STATUS_VAR = "MaritalStatus";
  public static final String PROD_TYPE_HOME_VAR = "Home";
  public static final String PROD_TYPE_MOTOR_VAR = "Motor";
  public static final String PROD_TYPE_PRIVATE_CAR = "Private car";
  public static final String PROD_TYPE_VAN_VAR = "Van";
  public static final String COVER_START_DATE = "Cover Start Date";
  public static final String PERSONAL_BELONGINGS = "Everyday personal belongings";
  public static final String MAX_CLAIM_LIMIT = "Max. Claim Limit for Valuables in the home";
  public static final String CREDIT_CARD = "CreditCard";
  public static final String CHEQUE = "Cheque";
  public static final String DEFAULT_DATE_FORMAT = "dd/mm/yyyy";

  public static final String YES = "Yes";
  public static final String No = "No";


  public static final long waitDuration = 60000L;
  public static final long elementWaitDuration = 10000L;
  public final CommonHelper commonHelper;
  EisHelpers eisHelpers;

  public EisGeneralStepDefinitions(WebDriver pDriver, PageObjects.EisModel.Root pageObjectOfEis) {
    super(pDriver, pageObjectOfEis);
    eisHelpers = new EisHelpers(pDriver, pageObjectOfEis);
    commonHelper = new CommonHelper(pDriver);

  }

  //Needs Improvements for Logic - 18/01
  public void selectEisPolicy(Map<String, Object> searchCriteria) throws CustomE2eException {
    //  var policyCount = driver.findElements(this.pageObjectOfEis
    //  .getEisPolicyDashboardLocatorModel().POLICY_NUMBER_SELECT()).size();
    for (Map.Entry<String, Object> entry : searchCriteria.entrySet()) {
      String key = entry.getKey();
      String value = String.valueOf(entry.getValue());
      switch (key) {
        case CommonControlDataDefns.POLICY_NUMBER:
          if (isElementVisible(this.pageObjectOfEis.getEisPolicyDashboardLocatorModel().VIEW_ALL_POLICY())) {
            clickElement(this.pageObjectOfEis.getEisPolicyDashboardLocatorModel().VIEW_ALL_POLICY(), SyncType.CLICKABLE);
          }
          var policyList =
           getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisPolicyDashboardLocatorModel().SELECT_POLICY_NUMBER_LIST());
          if (!policyList.contains(value)) {
            throw new CustomE2eException("Policy not found");
          } else {
            scrollElementIntoCenterOfScreen(xpathBuilder(this.pageObjectOfEis.getEisPolicyDashboardLocatorModel().SELECT_POLICY_NUMBER(), String.valueOf(value)));
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisPolicyDashboardLocatorModel().SELECT_POLICY_NUMBER(), String.valueOf(value)), SyncType.CLICKABLE);
          }
          break;

        default:
      }
    }
  }

  public void selectClient() throws CustomE2eException {
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisHomeLocatorModel().SELECT_CLIENT()
        , SyncType.CLICKABLE);

  }

  public SortedMap<String, Object> getEisPolicyData(String sectionDetails,
   Map<String, Object> searchCriteria) throws CustomE2eException {
    var vSourceViewOfPolicy = new TreeMap<String, Object>();
    var enhanceCover = new TreeMap<String, Object>();
    var insuredDetails = new TreeMap<String, Object>();
    var coverDetails = new TreeMap<String, Object>();
    var excessDetails = new TreeMap<String, Object>();
    var myCover = new TreeMap<String, Object>();
    var data = new TreeMap<String, Object>();

    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().POLICY_NUMBER(), SyncType.CLICKABLE);

    try {
      if (((String) searchCriteria.get(SEARCH_BY_POLICY_NUMBER)).startsWith("H")) {
//      if (((String) searchCriteria.get(SEARCH_BY_POLICY_NUMBER)).startsWith("HH")) {
        // Policy Tab
        var policyDet = getHomePolicyBasicInformation();
        vSourceViewOfPolicy.put(CommonControlDataDefns.POLICY_INFORMATION, policyDet);
        vSourceViewOfPolicy.put(POLICY_END_DATE,
         Optional.ofNullable(policyDet.get(CommonControlDataDefns.POLICY_END_DATE).toString()).filter(Predicate.not(String::isEmpty)).orElse("NoValue"));
        vSourceViewOfPolicy.put(POLICY_START_DATE,
         Optional.ofNullable(policyDet.get(CommonControlDataDefns.POLICY_START_DATE).toString()).filter(Predicate.not(String::isEmpty)).orElse("NoValue"));
        // Insured Tab
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().INSURED_TAB(), SyncType.CLICKABLE);
        vSourceViewOfPolicy.put(CommonControlDataDefns.CUSTOMER_DETAILS, getInsuredDetails());

        var jphDet = getJointPolicyDetails();
        var jphFlag = false;
        if (!jphDet.contains(CommonControlDataDefns.NO_VALUE)) {
          vSourceViewOfPolicy.put(CommonControlDataDefns.JPH_DETAILS, getJPHDetails());
          jphFlag = true;
        }
        vSourceViewOfPolicy.put(CommonControlDataDefns.JOINT_POLICY_HOLDER_FLAG, jphFlag);
        // Risk Address
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().RISK_ADDRESS_TAB(), SyncType.CLICKABLE);
        vSourceViewOfPolicy.put(CommonControlDataDefns.INSURED_HOME_SPECIFIC_DETAILS,
         getRiskAddressDetails());

        // Claim - Do not Delete
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().CLAIMS_TAB(), SyncType.CLICKABLE);
        vSourceViewOfPolicy.put(CommonControlDataDefns.CLAIM_HISTORY,
         Optional.ofNullable(getClaimDetails()).orElse(null));

        // Interested Parties - Do not Delete
//        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel()
//        .INTERESTED_PARTIES_TAB(), SyncType.CLICKABLE);
//        vSourceViewOfPolicy.put(CommonControlDataDefns.INTERESTED_PARTIES,
//         Optional.ofNullable(getInterestedPartiesDetails()).orElse(null)); // Need to build it

        // Cover Options
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().COVER_OPTIONS_TAB(), SyncType.CLICKABLE);
        vSourceViewOfPolicy.put(CommonControlDataDefns.COVER_DET, getCoverDetails());

        excessDetails.put(CommonControlDataDefns.EXCESS_VAR,
         vSourceViewOfPolicy.get(CommonControlDataDefns.EXCESS_VAR));

        myCover.put(CommonControlDataDefns.MY_COVER_VAR,
         vSourceViewOfPolicy.get(CommonControlDataDefns.MY_COVER_VAR));


        //Coverrage and Premium - Do not delete
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().COVERAGE_AND_PREMIUM_TAB(), SyncType.CLICKABLE);
        vSourceViewOfPolicy.put(CommonControlDataDefns.ADDITIONAL_PREMIUM, getHomePremiumDetails());

//         Endorsement  - Do not Delete
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().ENDORSEMENTS_TAB(), SyncType.CLICKABLE);
        vSourceViewOfPolicy.put(CommonControlDataDefns.ENDORSEMENT, getEndorsementDetails());
        vSourceViewOfPolicy.put(CommonControlDataDefns.ENHANCE_EXCESS_DETAILS,
         getOptionalExtrasAdded());

//        Do not delete End date is not showing in EIS - VD
//        vSourceViewOfPolicy.put(POLICY_EXPIRES_IN, this.commonHelper.getPolicyExpiresInDays
//        (policyDet.get(CommonControlDataDefns.POLICY_END_DATE)));

        vSourceViewOfPolicy.put(POLICY_EXPIRES_IN,
         policyDet.get(CommonControlDataDefns.POLICY_PERIOD));
        // Need to implement months into days logis
//        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel()
//            .ENDORSEMENTS_TAB(), SyncType.CLICKABLE);
        
        navigateToNextPage();
        vSourceViewOfPolicy.put(CommonControlDataDefns.POLICY_ID, getPolicyId());

        data.put(CommonControlDataDefns.HOME_INSURANCE_INFORMATION, vSourceViewOfPolicy);
      } else if (((String) searchCriteria.get(SEARCH_BY_POLICY_NUMBER)).startsWith("CV")) {
        var policyBasicInfo = getPolicyBasicInformation();
        vSourceViewOfPolicy.put(CommonControlDataDefns.POLICY_INFORMATION, policyBasicInfo);
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().INSURED_TAB(), SyncType.CLICKABLE);
        vSourceViewOfPolicy.put(CommonControlDataDefns.CUSTOMER_PERSONAL_DET, getPersonalDetails());

        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().DRIVER_TAB(), SyncType.CLICKABLE);
        vSourceViewOfPolicy.put(CommonControlDataDefns.DRIVER_DETAILS, getDriverDetails());

        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().CLAIMS_CONVICTION_SUMMARY_TAB(), SyncType.CLICKABLE);
        vSourceViewOfPolicy.put(CommonControlDataDefns.VEHICLE_CLAIMS_CONVICTION_SUMMARY,
         getVehicleClaims());

        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().VEHICLE_TAB(), SyncType.CLICKABLE);
        vSourceViewOfPolicy.put(CommonControlDataDefns.VEHICLE_DETAILS, getVehicleDetails());

        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().PREMIUM_COVERAGES_TAB(), SyncType.CLICKABLE);
        vSourceViewOfPolicy.put(CommonControlDataDefns.EXCESS_DET, getVehicleExcessDetails());
        vSourceViewOfPolicy.put(CommonControlDataDefns.PREMIUM_DETAILS, getPremiumDetails());
        vSourceViewOfPolicy.put(CommonControlDataDefns.COVERAGE_CODE, getCoverageCode());
        //vSourceViewOfPolicy.put(CommonControlDataDefns.OPTIONAL_EXTRAS, getOptionalExtras());

        if (((String) policyBasicInfo.get(CommonControlDataDefns.PROD_TYPE)).equalsIgnoreCase(CommonControlDataDefns.VAN_QUOTE)) {
          data.put(CommonControlDataDefns.VAN_INSURANCE_INFORMATION, vSourceViewOfPolicy);
        } else if (((String) policyBasicInfo.get(CommonControlDataDefns.PROD_TYPE)).equalsIgnoreCase(CommonControlDataDefns.PRIVATE_CAR)) {
          data.put(CommonControlDataDefns.MOTOR_INSURANCE_INFORMATION, vSourceViewOfPolicy);
        }
      }
    } catch (ConcurrentModificationException ex) {

    }

    if (data == null || vSourceViewOfPolicy == null) {
      throw new CustomE2eException("Policy not found.");
    }
    return data;
  }

  private SortedMap<String, Object> getClaimDetails() throws CustomE2eException {
    var claimDetails = new TreeMap<String, Object>();

    var claimCount =
     getElementsMatchingToLocator(this.pageObjectOfEis.getEisSharedLocatorModel().CLAIMS_LIST()).size();
    int changeClaimLink = 1;
    for (int claims = 0; claims < claimCount; claims++) {
      var claim = new ArrayList<SortedMap<String, Object>>();
      var addressDet =
       getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().GET_POLICY_INFORMATION_LABEL());
      var claimValue = new TreeMap<String, Object>();
      try {
        for (var fieldName : addressDet) {
          switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(fieldName)) {
            case CommonControlDataDefns.INCIDENT_SOURCE ->
                claimValue.put(CommonControlDataDefns.INCIDENT_SOURCE,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().CLAIM_INCIDENT_SOURCE(), "Failed to retrieve incident source flag."));
            case CommonControlDataDefns.INCIDENT_DATE ->
                claimValue.put(CommonControlDataDefns.INCIDENT_DATE,
                 getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().CLAIM_INCIDENT_DATE(), "value", "Failed to retrieve incident source flag."));
            case CommonControlDataDefns.CLAIM_STATUS ->
                claimValue.put(CommonControlDataDefns.CLAIM_STATUS,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().CLAIM_CLAIM_STATUS(), "Failed to retrieve incident source flag."));
            case CommonControlDataDefns.CLAIM_TYPE ->
                claimValue.put(CommonControlDataDefns.CLAIM_TYPE,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().CLAIM_TYPE(), "Failed to retrieve incident source flag."));
            case CommonControlDataDefns.CLAIM_CAUSE ->
                claimValue.put(CommonControlDataDefns.CLAIM_CAUSE,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().CLAIM_CAUSE(), "Failed to retrieve incident source flag."));
            case CommonControlDataDefns.CLAIM_COST_VAR ->
                claimValue.put(CommonControlDataDefns.CLAIM_COST_VAR,
                 Double.parseDouble(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().CLAIM_COST(), "Failed to retrieve incident source flag.").replace("£", "")));
            case CommonControlDataDefns.CLAIM_NUM ->
                claimValue.put(CommonControlDataDefns.CLAIM_NUM,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().CLAIM_NUM(), "Failed to retrieve incident source flag."));
            case CommonControlDataDefns.SUFFERED_LOSS_NOT_RESULTED_CLAIM_VAR ->
                claimValue.put(CommonControlDataDefns.SUFFERED_LOSS_NOT_RESULTED_CLAIM,
                 CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().SUFFERED_LOSS_NOT_RESULTED_CLAIM(), "Failed to retrieve incident source flag.")));
          }
        }
        if (isElementVisible(xpathBuilder(this.pageObjectOfEis.getEisSharedLocatorModel().ITEM_CHANGE_LINK(), String.valueOf(changeClaimLink + 1)))) {
          scrollIntoView(xpathBuilder(this.pageObjectOfEis.getEisSharedLocatorModel().ITEM_CHANGE_LINK(), String.valueOf(changeClaimLink + 1)));
          clickElement(xpathBuilder(this.pageObjectOfEis.getEisSharedLocatorModel().ITEM_CHANGE_LINK(), String.valueOf(changeClaimLink + 1)), SyncType.CLICKABLE);
          changeClaimLink++;
        }
        claim.add(claimValue);
      } catch (Exception exception) {
        throw new CustomE2eException(exception.getMessage());
      }
      claimDetails.put(CommonControlDataDefns.CLAIMS, claim);
    }
    return claimDetails;
  }

  private String getJointPolicyDetails() throws CustomE2eException {
    //JointPolicyHolder
    String jphName;
    if (getElementsMatchingToLocator(this.pageObjectOfEis.getEisSharedLocatorModel().LIST_OF_INSURED_HOLDERS()).size() > 1) {
      selectNameInsuredDropdown();
      selectJointPolicyholder();
      jphName = getJPHTitle() + " " + getJPHFirstname() + " " + getJPHLastname();
    } else {
      jphName = "NoValue";
    }
    return jphName;
  }

  private SortedMap<String, Object> getEndorsementDetails() throws CustomE2eException {
    var endorsementList = new TreeMap<String, Object>();
    var endorsementAddedAutomatically =
     getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().ENDORSEMENT_LIST());

    endorsementList.put(CommonControlDataDefns.DEFAULT_ADDED_ENDORSEMENT,
     endorsementAddedAutomatically);
    return endorsementList;
  }

  private TreeMap<String, Object> getPremiumDetails() throws CustomE2eException {
    var premiumDetails = new TreeMap<String, Object>();
    premiumDetails.put(CommonControlDataDefns.NET_PREMIUM,
     Double.parseDouble(getText(this.pageObjectOfEis.getEisMotorPremiumAndCoveragesLocatorModel().NET_PREMIUM()).replace("£", "")));
    premiumDetails.put(CommonControlDataDefns.GROSS_PREMIUM,
     Double.parseDouble(getText(this.pageObjectOfEis.getEisMotorPremiumAndCoveragesLocatorModel().GROSS_PREMIUM()).replace("£", "")));
    premiumDetails.put(CommonControlDataDefns.SELLING_PRICE,
     Double.parseDouble(getText(this.pageObjectOfEis.getEisMotorPremiumAndCoveragesLocatorModel().SELLING_PRICE()).replace("£", "")));
    return premiumDetails;
  }

  private TreeMap<String, Object> getHomePremiumDetails() throws CustomE2eException {
    var premiumDetails = new TreeMap<String, Object>();
    premiumDetails.put(CommonControlDataDefns.NET_PREMIUM,
     Double.parseDouble(getText(this.pageObjectOfEis.getEisHomePolicyDetailsLocatorModel().NET_PREMIUM()).replaceAll("[£,]", "")));
    premiumDetails.put(CommonControlDataDefns.GROSS_PREMIUM,
     Double.parseDouble(getText(this.pageObjectOfEis.getEisHomePolicyDetailsLocatorModel().GROSS_PREMIUM()).replaceAll("[£,]", "")));
    premiumDetails.put(CommonControlDataDefns.SELLING_PRICE,
     Double.parseDouble(getText(this.pageObjectOfEis.getEisHomePolicyDetailsLocatorModel().SELLING_PRICE()).replaceAll("[£,]", "")));
    return premiumDetails;
  }

  private ArrayList<String> getCoverageCode() throws CustomE2eException {
    // var excessDetails = new TreeMap<String, Object>();

    //Motor Policy Creation is showing only option as of now. 22/01
    var coverageCodes =
     getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisMotorPremiumAndCoveragesLocatorModel().COVERAGE_CODE());

//    excessDetails.put(MOTOR_COVERAGE_CODES, coverageCodes);
    return coverageCodes;
  }

  private TreeMap<String, Object> getVehicleExcessDetails() throws CustomE2eException {
    var excessDetails = new TreeMap<String, Object>();

    //Motor Policy Creation is showing only option as of now. 22/01
    var voluntaryExcess =
     Integer.parseInt(getText(this.pageObjectOfEis.getEisMotorPremiumAndCoveragesLocatorModel().VOLUNTARY_EXCESS()));

    excessDetails.put(CommonControlDataDefns.VEHICLE_VOLUNTARY_EXCESS, voluntaryExcess);
    return excessDetails;
  }

  private TreeMap<String, Object> getVehicleClaims() throws CustomE2eException {

    var claimAndConviction = new TreeMap<String, Object>();

    var claim = new ArrayList<>();
    var conviction = new ArrayList<>();
    try {
      var countOfClaim =
       getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisMotorClaimLocatorModel().LIST_OF_CLAIMS());
      var claimDetails = new TreeMap<String, Object>();
      var individualClaimLabels =
       getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisMotorClaimLocatorModel().CLAIMS_LABELS_LIST());

      for (int claims = 1; claims <= countOfClaim.size(); claims++) {//Claim based loop
        var individualClaimValue =
         getTextAllWebElementMatchingLocator(xpathBuilder(this.pageObjectOfEis.getEisMotorClaimLocatorModel().CLAIMS_DETAILS_VALUE(), String.valueOf(claims)));
        for (var label : individualClaimLabels) {
          switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(label)) {
            case CommonControlDataDefns.DRIVER:
              claimDetails.put(CommonControlDataDefns.FULL_NAME, individualClaimValue.get(0));
              break;
            case CommonControlDataDefns.INCIDENT_DATE:
              claimDetails.put(CommonControlDataDefns.INCIDENT_DATE,
               Formatting.changeDateFormatIntoExpected(individualClaimValue.get(1),
                       DEFAULT_DATE_FORMAT, "mm/dd//yyyy"));
              break;
            case CommonControlDataDefns.CLAIM_STATUS:
              claimDetails.put(CommonControlDataDefns.CLAIM_STATUS, individualClaimValue.get(2));
              break;
            case CommonControlDataDefns.CLAIM_TYPE:
              claimDetails.put(CommonControlDataDefns.CLAIM_TYPE, individualClaimValue.get(3));
              break;
            case CommonControlDataDefns.CLAIM_CAUSE:
              claimDetails.put(CommonControlDataDefns.CLAIM_CAUSE, individualClaimValue.get(4));
              break;
            case CommonControlDataDefns.OWN_DAMAGE_COST:
              claimDetails.put(CommonControlDataDefns.OWN_DAMAGE_COST,
               Integer.parseInt(individualClaimValue.get(5).replace("£", "")));
              break;
            case CommonControlDataDefns.THIRD_PARTY_DAMAGE_COST:
              claimDetails.put(CommonControlDataDefns.THIRD_PARTY_DAMAGE_COST,
               Integer.parseInt(individualClaimValue.get(6).replace("£", "")));
              break;
            case CommonControlDataDefns.NCD_AFFECTED:
              claimDetails.put(CommonControlDataDefns.NCD_AFFECTED,
               CommonHelper.convertStringIntoBoolean(individualClaimValue.get(7)));
              break;
            case CommonControlDataDefns.PERSONAL_INJURY:
              claimDetails.put(CommonControlDataDefns.PERSONAL_INJURY,
               CommonHelper.convertStringIntoBoolean(individualClaimValue.get(8)));
              break;
            default:
          }
        }
        claim.add(claimDetails);
      }
      claimAndConviction.put(CommonControlDataDefns.CLAIMS, claim);

      var countOfConviction =
       getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisMotorClaimLocatorModel().LIST_OF_CONVICTIONS());
      var convictionDetails = new TreeMap<String, Object>();
      var individualConvictionLabels =
       getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisMotorClaimLocatorModel().CONVICTION_LABELS_LIST());
      for (int convictions = 1; convictions <= countOfConviction.size(); convictions++) {
        var individualConvictionValue =
            getTextAllWebElementMatchingLocator(xpathBuilder(this.pageObjectOfEis.getEisMotorClaimLocatorModel().CONVICTION_DETAILS_VALUE(), String.valueOf(convictions)));
        for (var convictionLabel : individualConvictionLabels) {
          switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(convictionLabel)) {
            case CommonControlDataDefns.DRIVER:
              convictionDetails.put(CommonControlDataDefns.FULL_NAME,
               individualConvictionValue.get(0));
              break;
            case CommonControlDataDefns.TYPE:
              convictionDetails.put(CommonControlDataDefns.TYPE, individualConvictionValue.get(1));
              break;
            case CommonControlDataDefns.OFFENCE_DATE:
              convictionDetails.put(CommonControlDataDefns.OFFENCE_DATE,
                  individualConvictionValue.get(2));
              break;
            case CommonControlDataDefns.CONVICTION_DATE:
              convictionDetails.put(CommonControlDataDefns.CONVICTION_DATE,
               Formatting.changeDateFormatIntoExpected(individualConvictionValue.get(3),
                       DEFAULT_DATE_FORMAT, "mm" + "/dd//yyyy"));
              break;
            case CommonControlDataDefns.POINTS:
              convictionDetails.put(CommonControlDataDefns.POINTS,
               Integer.parseInt(individualConvictionValue.get(4)));
              break;
            case GetPolicyDetailsEis.CONVICTION_MONTHS_SUSPENDED:
              convictionDetails.put(CommonControlDataDefns.MONTHS_SUSPENDED,
               Integer.parseInt(individualConvictionValue.get(5)));
              break;
            case CommonControlDataDefns.FINE:
              convictionDetails.put(CommonControlDataDefns.FINE,
               Double.parseDouble(individualConvictionValue.get(6).replace("£", "")));
              break;
            case CommonControlDataDefns.DISQUALIFIED:
              convictionDetails.put(CommonControlDataDefns.DISQUALIFIED,
                  CommonHelper.convertStringIntoBoolean(individualConvictionValue.get(7)));
              break;
            default:
          }
        }
        conviction.add(convictionDetails);
      }
    } catch (ParseException exception) {
      throw new CustomE2eException(exception.getMessage());
    }
    claimAndConviction.put(CommonControlDataDefns.CONVICTIONS, conviction);
    return claimAndConviction;
  }

  //
  private TreeMap<String, Object> getVehicleDetails() throws CustomE2eException {
    var vehicleDetails = new TreeMap<String, Object>();
    var driverTabLabels =
     getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().GET_POLICY_INFORMATION_LABEL());
    try {
      for (var fieldName : driverTabLabels) {
        switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(fieldName)) {
          case CommonControlDataDefns.TEMP_VEHICLE:
////    TemporaryVehicle
            vehicleDetails.put(CommonControlDataDefns.TEMP_VEHICLE,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().TEMP_VEHICLE(), "Failed to retrieve temporary vehicle"));
            break;
//    VehicleRegistrationNumber
          case CommonControlDataDefns.VEHICLE_REG_NUMBER_VAR:
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_REG_NUMBER,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_REG_NUMBER(), "Failed to retrieve vehicle registration number"));
            break;
          case CommonControlDataDefns.VEHICLE_TYPE:
//    VehicleType
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_TYPE,
                getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_TYPE(), "Failed to retrieve vehicle type"));
            break;
          case CommonControlDataDefns.VEHICLE_MAKE_VAR:
//    Make
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_MAKE,
                getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_MAKE(), "Failed to retrieve vehicle make"));
            break;
          case CommonControlDataDefns.VEHICLE_MODEL_VAR:
//    Model
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_MODEL,
                getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_MODEL(), "Failed to retrieve vehicle model"));
            break;
          case CommonControlDataDefns.VEHICLE_YEAR_OF_MANUFACTURE_VAR:
          case CommonControlDataDefns.YEAR_OF_MANUFACTURE_VAR:
//    YearOfManufacture
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_YEAR_OF_MANUFACTURE,
                Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_YEAR_OF_MANUFACTURE(), "Failed to retrieve vehicle manufacture")));
            break;
          //Is the vehicle imported?
          case CommonControlDataDefns.VEHICLE_IMPORTED_VAR:
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_IMPORTED,
             CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_IMPORTED(), "Failed to retrieve vehicle imported status")));

          case CommonControlDataDefns.VEHICLE_FULE_TYPE:
//    FuelType
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_FULE_TYPE,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_FULE_TYPE(), "Failed to retrieve vehicle fuel type"));
            break;
          case CommonControlDataDefns.VEHICLE_TRANSMISSION:
//    Transmission
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_TRANSMISSION,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_TRANSMISSION(), "Failed to retrieve vehicle transmission"));
            break;
          case CommonControlDataDefns.VEHICLE_BODY_STYLE:
//    BodyStyle
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_BODY_STYLE,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_BODY_STYLE(), "Failed to retrieve vehicle body style"));
            break;
          case CommonControlDataDefns.VEHICLE_NUM_DOORS:
//    NumberOfDoors
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_NUM_DOORS,
                Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_NUM_DOORS(), "Failed to retrieve vehicle door number")));
            break;
          case CommonControlDataDefns.VEHICLE_NUM_SEAT:
//    NumberOfSeats
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_NUM_SEAT,
                Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_NUM_SEAT(), "Failed to retrieve vehicle seats")));
            break;
          case CommonControlDataDefns.VEHICLE_ENGINE_CC_VAR:
//    EngineCC
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_ENGINE_CC,
             Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_ENGINE_CC(), "Failed to retrieve vehicle engine cc")));
            break;

          case CommonControlDataDefns.VEHICLE_ABI_CODE_VAR:
//    ABICode
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_ABI_CODE,
             Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_ABI_CODE(), "Failed to retrieve vehicle ABI Code")));
            break;
          case CommonControlDataDefns.VEHICLE_MARKET_VALUE:
//    Marketvalue
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_MARKET_VALUE,
             Double.parseDouble(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_MARKET_VALUE(), "Failed to retrieve vehicle market value").replaceAll("[£,]", "")));
            break;
          case CommonControlDataDefns.VEHICLE_ALARM:
//    Alarm
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_ALARM,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_ALARM(), "Failed to retrieve vehicle alarm"));
            break;
          case CommonControlDataDefns.VEHICLE_IMMOBILISER_VAR:
//    Immobiliser - VAN
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_IMMOBILISER_FLAG,
                CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_IMMOBILISER_FLAG(), "Failed to retrieve vehicle immobiliser flag")));
            break;
          case CommonControlDataDefns.VEHICLE_TRACKER_VAR:
//    Tracker
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_TRACKER_FLAG,
                CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_TRACKER_FLAG(), "Failed to retrieve vehicle tracker flag")));
            break;
          case CommonControlDataDefns.VEHICLE_IMMOBILISER:
//    Immobiliser - Car
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_IMMOBILISER,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_IMMOBILISER(), "Failed to retrieve vehicle immobiliser"));
            break;
          case CommonControlDataDefns.VEHICLE_TRACKER:
//    Tracker
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_TRACKER,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_TRACKER(), "Failed to retrieve vehicle tracker"));
            break;
          case CommonControlDataDefns.VEHICLE_DASH_CAM_FITTED_VAR:
//    Do you have a dashcam fitted to your vehicle?
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_DASH_CAM_FITTED,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_DASHCAM_FITTED(), "Failed to retrieve vehicle dash cam fitted"));
            break;

          case CommonControlDataDefns.VEHICLE_LEFT_HAND_DRIVE:
//    Left Hand Drive
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_LEFT_HAND_DRIVE,
             CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_LEFT_HAND_DRIVE(), "Failed to retrieve vehicle left hand drive")));
            break;
          case CommonControlDataDefns.VEHICLE_RACKING_VAR:
//Is the vehicle fitted with racking?
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_RACKING,
                getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_RACKING_FLAG(), "Failed to retrieve vehicle racking flag"));
            break;
          case CommonControlDataDefns.VEHICLE_SIGNAGE_VAR:
//Does the vehicle carry any signage?
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_SIGNAGE,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_SIGNAGE_FLAG(), "Failed to retrieve vehicle signage flag"));
            break;
//    Has the car been modified from the manufacturer's standard specification?
          case CommonControlDataDefns.VEHICLE_MODIFIED_VAR:
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_MODIFIED,
             CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_MODIFIED(), "Failed to retrieve vehicle modified")));
            break;
//    What do you use your car for?
          case CommonControlDataDefns.VEHICLE_USE_FOR_VAR:
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_USE_FOR,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_USE_FOR(), "Failed to retrieve vehicle use for"));
            break;
//  Is this purely for social domestic and pleasure use ?
          case CommonControlDataDefns.VEHICLE_USE_TYPE_FOR_VAR:
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_USE_FOR,
             CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_USE_FOR_TYPE(), "Failed to retrieve vehicle use for type")));
            break;
//    Annual Mileage
          case CommonControlDataDefns.VEHICLE_ANNUAL_MILEAGE:
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_ANNUAL_MILEAGE,
             Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_ANNUAL_MILEAGE(), "Failed to retrieve vehicle annual mileage")));
            break;
//Business Mileage
          case CommonControlDataDefns.VEHICLE_BUSINESS_MILEAGE:
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_BUSINESS_MILEAGE,
             Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_BUSINESS_MILEAGE(), "Failed to retrieve vehicle business mileage")));
            break;
// When did you buy your car?
          case CommonControlDataDefns.VEHICLE_PURCHASE_DATE_VAR:
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_PURCHASE_DATE,
             Optional.ofNullable(Formatting.changeDateFormatIntoExpected(getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_BUY_DATE(), "value", "Failed retrieve buy date"), "mm/dd/yyyy", "dd/mm/yyyy")).orElse(""));
            break;
          //P.S Different from:-> Where is the vehicle kept during the night?
          case CommonControlDataDefns.VEHICLE_OVER_NIGHT_LOC_VAR:
            //Overnight Location
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_OVER_NIGHT_LOC_VAR,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_OVERNIGHT_LOC(), "Failed retrieve overnight location."));
//Do you have Public Liability in force?
          case CommonControlDataDefns.VEHICLE_PUBLIC_LIABILITY_IN_FORCE_VAR: // When did you buy
            vehicleDetails.put(CommonControlDataDefns.PUBLIC_LIABILITY_IN_FORCE,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_PUBLIC_LIABILITY_IN_FORCE(), "Failed retrieve public liability in force"));
            break;
//Will the vehicle carry any hazardous goods?
          case CommonControlDataDefns.VEHICLE_HAZARDOUSE_GOOD_VAR: // When did you buy your car?
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_HAZARDOUSE_GOOD,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_HAZARDOUSE_GOOD(), "value"));
            break;
// Where is the vehicle kept during the day?
          case CommonControlDataDefns.VEHICLE_KEPT_DURING_DAY_LOC_VAR: //Where is the vehicle kept
            // during the day?
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_KEPT_DURING_DAY_LOC,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_KEPT_DURING_DAY_LOC(), "Failed to retrieve vehicle kept during day"));
            break;
//Where is the vehicle kept during the night?
          case CommonControlDataDefns.VEHICLE_KEPT_DURING_NIGHT_LOC_VAR:
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_KEPT_DURING_NIGHT_LOC,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_KEPT_DURING_NIGHT_LOC(), "Failed to retrieve vehicle kept during night"));
            break;
//    Where Kept Postcode
          case CommonControlDataDefns.VEHICLE_KEPT_DURING_NIGHT_POSTCODE:
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_KEPT_DURING_NIGHT_POSTCODE,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_KEPT_DURING_NIGHT_POSTCODE(), "Failed to retrieve vehicle kept postcode"));
            break;
//    Vehicle owner
          case CommonControlDataDefns.VEHICLE_OWNER:
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_OWNER,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_OWNER(), "Failed to retrieve vehicle owner"));
            break;
// ProposerRegisteredKeeper
          case CommonControlDataDefns.VEHICLE_PROPOSER_REGISTER_KEEPER:
            vehicleDetails.put(CommonControlDataDefns.VEHICLE_PROPOSER_REGISTER_KEEPER,
             CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_PROPOSER_REGISTER_KEEPER(), "Failed to retrieve vehicle proposer registere keeper")));
            break;
          default:

        }
      }
    } catch (ParseException exception) {
      throw new CustomE2eException(exception.getMessage());
    }
    return vehicleDetails;

  }



  private TreeMap<String, Object> getDriverDetails() throws CustomE2eException {
    var driver = new TreeMap<String, Object>();
    var mainDriver = new TreeMap<String, Object>();

    if (isElementVisible(xpathBuilder(this.pageObjectOfEis.getEisSharedLocatorModel().DRIVER_CHANGE_LINK_DRIVER(), String.valueOf(1)))) {
      clickElement(xpathBuilder(this.pageObjectOfEis.getEisSharedLocatorModel().DRIVER_CHANGE_LINK_DRIVER(), String.valueOf(1)), SyncType.CLICKABLE);
    }
    waitForPageLoad();
    var driverTabLabels =
     getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().GET_POLICY_INFORMATION_LABEL());


    try {
      for (var fieldName : driverTabLabels) {
        switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(fieldName)) {
          case CommonControlDataDefns.TEMP_DRIVER:
            mainDriver.put(CommonControlDataDefns.TEMP_DRIVER,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().TEMP_DRIVER(), "Failed to retrieve temp driver status"));
            break;
          case CommonControlDataDefns.DRIVER_PARTY_SELECTION:
            //Driver name -> Driver Party Selection ->
            mainDriver.put(CommonControlDataDefns.DRIVER_NAME,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().DRIVER_NAME(), "Failed to retrieve driver name"));
            break;
          case CommonControlDataDefns.DRIVER_TYPE:
            //DriverType -> Driver Type
            mainDriver.put(CommonControlDataDefns.DRIVER_TYPE,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().DRIVER_TYPE(), "Failed to retrieve driver type"));
            break;
          case CommonControlDataDefns.RESIDENCE_IN_UK_SINCE:
            //Residence in UK since
            var residenceInUk =
             getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().RESIDENCE_IN_UK_SINCE(), "value", "Failed retrieve Residence in Uk since");
            mainDriver.put(CommonControlDataDefns.RESIDENCE_IN_UK_SINCE,
             Optional.ofNullable(Formatting.changeDateFormatIntoExpected(residenceInUk,
              DEFAULT_DATE_FORMAT, "mm" + "/dd" + "/yyyy")).orElse(""));
            break;
          case CommonControlDataDefns.PREFERRED_DELIVERY:
            // Preferred delivery
            mainDriver.put(CommonControlDataDefns.PREFERRED_DELIVERY,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().PREFERRED_DELIVERY(), "Failed to retrieve preferred delivery"));
            break;
          case CommonControlDataDefns.LICENCE_TYPE:
            //Licence Type
            mainDriver.put(CommonControlDataDefns.LICENCE_TYPE,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().LICENCE_TYPE(), "Failed to retrieve license type"));
            break;
          case CommonControlDataDefns.LICENCE_OBTAIN_VAR:
            //On what date did you get your Licence?
            var licenceObtain =
             getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().LICENCE_OBTAIN_DATE(), "value", "Failed retrieve License obtain date");
            mainDriver.put(CommonControlDataDefns.LICENCE_OBTAIN,
             Optional.ofNullable(Formatting.changeDateFormatIntoExpected(licenceObtain,
              DEFAULT_DATE_FORMAT, "mm/dd" + "/yyyy")).orElse(""));

            break;
          case CommonControlDataDefns.HELD_DRIVING_LICENCE_VAR:
            //How long have you held your driving Licence?
            mainDriver.put(CommonControlDataDefns.HELD_DRIVING_LICENCE,
             Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().HELD_DRIVING_LICENCE(), "Failed to retrieve held driving license")));
            break;
          case CommonControlDataDefns.DRIVING_LICENCE_NUMBER:
            mainDriver.put(CommonControlDataDefns.DRIVING_LICENCE_NUMBER,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().LICENCE_NUMBER(), "Failed to retrieve license number"));
            break;
          case CommonControlDataDefns.ACCESS_TO_OTHER_VEHICLE:
            //Access to other vehicles
            mainDriver.put(CommonControlDataDefns.ACCESS_TO_OTHER_VEHICLE,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().ACCESS_TO_OTHER_DRIVER(), "Failed to retrieve access to other driver"));
            break;
          default:
        }
      }
    } catch (ParseException exception) {
      throw new CustomE2eException(exception.getMessage());
    }

    driver.put(CommonControlDataDefns.MAIN_DRIVER, mainDriver);
    driver.put(CommonControlDataDefns.ADDITIONAL_DRIVER, getAdditionalDriverDetails());

//    var treeMap = new TreeMap<String, Object>();
//    var tabLabelsArrayList =
//            getTextAllWebElementMatchingLocator(
//                    By.xpath("//tr[not(contains(@style, 'display: none'))  and not(contains(@class, 'hidden'))]/td[contains(@class, 'pfFormLabel')]//label[string-length(text()) > 0]"));
//
//    var tabValuesArrayList =
//            getTextAllWebElementMatchingLocator(
//                    By.xpath("//tr[./td[contains(@class, 'pfFormLabel')]/label[string-length(text()) > 0]]/td[contains(@class, 'pfFormControl')]//span[contains(@id, 'policyDataGatherForm:sedit') and not(contains(@style, 'display: none')) and not(contains(@class, 'hidden'))]"));
//
//    IntStream
//            .range(0, tabLabelsArrayList.size())
//            .forEach(index ->
//                    System.out.println(String.format("%s: %s", tabLabelsArrayList.get(index), tabValuesArrayList.get(index)))
//            );
//
//    IntStream
//            .range(0, tabLabelsArrayList.size())
//            .forEach(index ->
//                    treeMap.put(tabLabelsArrayList.get(index), tabValuesArrayList.get(index))
//            );
//
//
//    driver.put(CommonControlDataDefns.MAIN_DRIVER, treeMap);
//    driver.put(CommonControlDataDefns.ADDITIONAL_DRIVER, getAdditionalDriverDetails());


    return driver;
  }


  private ArrayList<Object> getAdditionalDriverDetails() throws CustomE2eException {
    var driver = new ArrayList<>();
    var additionalDriver = new TreeMap<String, Object>();

    var countOfDrivers =
     getElementsMatchingToLocator(this.pageObjectOfEis.getEisSharedLocatorModel().LIST_OF_DRIVERS());

    if (countOfDrivers.size() > 1) {
      for (int addDrivercounter = 2; addDrivercounter <= countOfDrivers.size(); addDrivercounter++) {
        clickElement(xpathBuilder(this.pageObjectOfEis.getEisSharedLocatorModel().DRIVER_CHANGE_LINK_DRIVER(), String.valueOf(addDrivercounter)), SyncType.CLICKABLE);
        waitForPageLoad();

        var addDriverTabLabels =
         getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().GET_POLICY_INFORMATION_LABEL());
        try {
          for (var fieldName : addDriverTabLabels) {
            switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(fieldName)) {
              case CommonControlDataDefns.TEMP_DRIVER:
                additionalDriver.put(CommonControlDataDefns.TEMP_DRIVER,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().TEMP_DRIVER(), "Failed to retrieve temporary driver status"));
                break;
              case CommonControlDataDefns.DRIVER_PARTY_SELECTION:
                //Driver name -> Driver Party Selection ->
                additionalDriver.put(CommonControlDataDefns.DRIVER_NAME,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().DRIVER_NAME(), "Failed to retrieve driver name"));
                break;
              case CommonControlDataDefns.DRIVER_TYPE:
                //DriverType -> Driver Type
                additionalDriver.put(CommonControlDataDefns.DRIVER_TYPE,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().DRIVER_TYPE(), "Failed to retrieve driver type"));
                break;
              case CommonControlDataDefns.RELATIONSHIP_TO_PROPOSER:
                additionalDriver.put(CommonControlDataDefns.RELATIONSHIP_TO_PROPOSER,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().ADD_DRIVER_RELATIONSHIP_TO_PROPOSER(), "Failed to retrieve relationship proposer"));
                break;
              case CommonControlDataDefns.DATE_OF_BIRTH:
                var dateOfBirth =
                 getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().ADD_DRIVER_DATE_OF_BIRTH(), "value", "Failed retrieve date of birth");
                additionalDriver.put(CommonControlDataDefns.DATE_OF_BIRTH,
                 Optional.ofNullable(Formatting.changeDateFormatIntoExpected(dateOfBirth,
                  DEFAULT_DATE_FORMAT, "mm/dd" + "/yyyy")).orElse(""));

                break;
              case CommonControlDataDefns.GENDER:
                additionalDriver.put(CommonControlDataDefns.GENDER,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().ADD_DRIVER_GENDER(), "Failed to retrieve additional driver gender"));
                break;
              case CommonControlDataDefns.MARITAL_STATUS:
                additionalDriver.put(CommonControlDataDefns.MARITAL_STATUS,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().ADD_DRIVER_MARITAL_STATUS(), "Failed to retrieve additional driver marital status"));
                break;
              case CommonControlDataDefns.EMPLOYMENT_STATUS:
                var employment = new TreeMap<String, Object>();
                var primaryEmployment = new TreeMap<String, Object>();
                var secondaryEmployment = new TreeMap<String, Object>();

                primaryEmployment.put(CommonControlDataDefns.EMPLOYMENT_STATUS,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().ADD_DRIVER_PRIMARY_EMPLOYMENT_STATUS(), "Failed to retrieve additional driver employment staus"));
                primaryEmployment.put(CommonControlDataDefns.OCCUPATION,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().ADD_DRIVER_PRIMARY_OCCUPATION(), "Failed to retrieve additional driver primary occupation"));
                primaryEmployment.put(CommonControlDataDefns.INDUSTRY,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().ADD_DRIVER_PRIMARY_INDUSTRY(), "Failed to retrieve additional driver primary industry"));
                employment.put(CommonControlDataDefns.PRIMARY_EMPLOYMENT_DET, primaryEmployment);

                secondaryEmployment.put(CommonControlDataDefns.SECOND_EMPLOYMENT_STATUS,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().ADD_DRIVER_SECONDARY_EMPLOYMENT_STATUS(), "Failed to retrieve additional driver second job status"));
                secondaryEmployment.put(CommonControlDataDefns.SECOND_EMP_FLAG,
                 CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().SECONDARY_EMPLOYMENT_STATUS_FLAG(), "Failed to retrieve additional driver second job flag")));
                secondaryEmployment.put(CommonControlDataDefns.OCCUPATION,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().ADD_DRIVER_SECONDARY_EMPLOYER_OCCUPATION(), "Failed to retrieve additional driver employment occupation"));
                secondaryEmployment.put(CommonControlDataDefns.INDUSTRY,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().ADD_DRIVER_SECONDARY_EMPLOYMENT_INDUSTRY(), "Failed to retrieve additional driver second employment industry"));
                employment.put(CommonControlDataDefns.SECOND_EMPLOYMENT_DET, secondaryEmployment);
                additionalDriver.put(CommonControlDataDefns.EMPLOYMENT_DET, employment);
                break;
              case CommonControlDataDefns.RESIDENCE_IN_UK_SINCE:
                var residenceInUk =
                 getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().ADD_DRIVER_RESIDENCE_IN_UK_SINCE(), "value", "Failed retrieve residence in uk since");
                Optional.ofNullable(additionalDriver.put(CommonControlDataDefns.RESIDENCE_IN_UK_SINCE, Formatting.changeDateFormatIntoExpected(residenceInUk, DEFAULT_DATE_FORMAT, "mm" + "/dd/yyyy"))).orElse("");
                break;
              case CommonControlDataDefns.LICENCE_OBTAIN_VAR:
                //On what date did you get your Licence?
                var licenceObtain =
                 getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().LICENCE_OBTAIN_DATE(), "value", "Failed retrieve license obtain");
                Optional.ofNullable(additionalDriver.put(CommonControlDataDefns.LICENCE_OBTAIN,
                 Formatting.changeDateFormatIntoExpected(licenceObtain, DEFAULT_DATE_FORMAT,
                  "mm" + "/dd" + "/yyyy"))).orElse("");
                break;
              case CommonControlDataDefns.HELD_DRIVING_LICENCE_VAR:
                //How long have you held your driving Licence?
                additionalDriver.put(CommonControlDataDefns.HELD_DRIVING_LICENCE,
                    getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().HELD_DRIVING_LICENCE(), "Failed to retrieve held driving license"));
                break;
              case CommonControlDataDefns.PREFERRED_DELIVERY:
                // Preferred delivery
                additionalDriver.put(CommonControlDataDefns.PREFERRED_DELIVERY,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().PREFERRED_DELIVERY(), "Failed to retrieve preferred delivery"));
                break;
              case CommonControlDataDefns.LICENCE_ACQUIRED:
                var licenseAcquired =
                 getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().ADD_DRIVER_LICENCE_OBTAIN_DATE(), "value", "Failed retrieve license acquired");
                additionalDriver.put(CommonControlDataDefns.LICENCE_ACQUIRED,
                 Optional.ofNullable(Formatting.changeDateFormatIntoExpected(licenseAcquired,
                  DEFAULT_DATE_FORMAT, "mm/dd/yyyy")).orElse(""));
                break;
              case CommonControlDataDefns.HELD_DRIVING_LICENCE:
                additionalDriver.put(CommonControlDataDefns.HELD_DRIVING_LICENCE,
                 Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().HELD_DRIVING_LICENCE(), "Failed to retrieve held driving license")));
                break;
              case CommonControlDataDefns.ACCESS_TO_OTHER_VEHICLE:
                additionalDriver.put(CommonControlDataDefns.ACCESS_TO_OTHER_VEHICLE,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().ACCESS_TO_OTHER_DRIVER(), "Failed to retrieve access to other driver"));
                break;
              case CommonControlDataDefns.LICENCE_TYPE:
                //      Licence Type
                additionalDriver.put(CommonControlDataDefns.LICENCE_TYPE,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().LICENCE_TYPE(), "Failed to retrieve license type"));
                break;
              case CommonControlDataDefns.DRIVING_LICENCE_NUMBER:
                additionalDriver.put(CommonControlDataDefns.DRIVING_LICENCE_NUMBER,
                 getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().LICENCE_NUMBER(), "Failed to retrieve license number"));
                break;
              default:
            }
          }
        } catch (ParseException exception) {
          throw new CustomE2eException(exception.getMessage());
        }

//        var treeMap = new TreeMap<String, Object>();
//        var tabLabelsArrayList =
//                getTextAllWebElementMatchingLocator(
//                        By.xpath("//tr[not(contains(@style, 'display: none'))  and not(contains(@class, 'hidden'))]/td[contains(@class, 'pfFormLabel')]//label[string-length(text()) > 0]"));
//
//        var tabValuesArrayList =
//                getTextAllWebElementMatchingLocator(
//                        By.xpath("//tr[./td[contains(@class, 'pfFormLabel')]/label[string-length(text()) > 0]]/td[contains(@class, 'pfFormControl')]//span[contains(@id, 'policyDataGatherForm:sedit') and not(contains(@style, 'display: none')) and not(contains(@class, 'hidden'))]"));
//
//        IntStream
//                .range(0, tabLabelsArrayList.size())
//                .forEach(index ->
//                        System.out.println(String.format("%s: %s", tabLabelsArrayList.get(index), tabValuesArrayList.get(index)))
//                );
//
//        IntStream
//                .range(0, tabLabelsArrayList.size())
//                .forEach(index ->
//                        treeMap.put(tabLabelsArrayList.get(index), tabValuesArrayList.get(index))
//                );
//



        driver.add(additionalDriver);
      }
//      driver.add(additionalDriver);
    }
    return driver;
  }

  //
  private TreeMap<String, Object> getPolicyBasicInformation() throws CustomE2eException {
    var basicPolicyInfo = new TreeMap<String, Object>();
    var policyTabLabel =
     getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().GET_POLICY_INFORMATION_LABEL());
    try {
      for (var fieldName : policyTabLabel) {
        switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(fieldName)) {
          case CommonControlDataDefns.ENQUIRY:
            basicPolicyInfo.put(CommonControlDataDefns.ENQUIRY,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().ENQUIRY(), "Failed to retrieve enquiry"));
            break;
          case CommonControlDataDefns.SALES_CHANNEL:
            basicPolicyInfo.put(CommonControlDataDefns.SALES_CHANNEL,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().SALES_CHANNEL(), "Failed to retrieve sales channel"));
            break;
          case CommonControlDataDefns.BRAND:
            basicPolicyInfo.put(CommonControlDataDefns.BRAND,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().BRAND(), "Failed to retrieve brand"));
            break;
          case CommonControlDataDefns.PROD_TYPE:
            basicPolicyInfo.put(CommonControlDataDefns.PROD_TYPE,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().PROD_TYPE(), "Failed to retrieve product type"));
            break;
          case CommonControlDataDefns.SCHEME:
            basicPolicyInfo.put(CommonControlDataDefns.SCHEME,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().SCHEME(), "Failed to retrieve scheme"));
            break;
          case CommonControlDataDefns.AFFINITY_CODE:
            basicPolicyInfo.put(CommonControlDataDefns.AFFINITY,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().AFFINITY_CODE(), "Failed to retrieve affinity code"));
            break;
          case CommonControlDataDefns.COVER_TYPE:
            basicPolicyInfo.put(CommonControlDataDefns.COVER_TYPE,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().COVER_TYPE(), "Failed to retrieve cover type"));
            break;
          case CommonControlDataDefns.COVER_SECTIONS:
            basicPolicyInfo.put(CommonControlDataDefns.COVER_SECTIONS,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().COVER_SECTIONS(), "Failed to retrieve cover sections"));
            break;
          case CommonControlDataDefns.ORIGINAL_QUOTE_DATE:
            basicPolicyInfo.put(CommonControlDataDefns.ORIGINAL_QUOTE_DATE,
             Formatting.changeDateFormatIntoExpected(getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().ORIGINAL_QUOTE_DATE(), "value", "Failed retrieve original quote date"), DEFAULT_DATE_FORMAT, "mm/dd/yyyy"));
            break;
          case CommonControlDataDefns.POLICY_PERIOD:
            basicPolicyInfo.put(CommonControlDataDefns.POLICY_PERIOD,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().POLICY_PERIOD(), "Failed to retrieve policy period"));
            break;
          case CommonControlDataDefns.INCEPTION_DATE_VAR:
            basicPolicyInfo.put(CommonControlDataDefns.INCEPTION_DATE,
             Formatting.changeDateFormatIntoExpected(this.commonHelper.getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().INCEPTION_DATE(), "value", "Failed retrieve inception date"), DEFAULT_DATE_FORMAT, "mm/dd/yyyy"));
            break;
          case CommonControlDataDefns.DRIVING_RESTRICTION:
            basicPolicyInfo.put(CommonControlDataDefns.DRIVING_RESTRICTION,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().DRIVING_RESTRICTION(), "Failed to retrieve driving restrictions"));
            break;
          case CommonControlDataDefns.RENEWAL_COUNT:
            basicPolicyInfo.put(CommonControlDataDefns.RENEWAL_COUNT,
                Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().RENEWAL_COUNT(), "Failed to retrieve renewal count")));
            break;
          case CommonControlDataDefns.NCD_FLAG_VAR:
            basicPolicyInfo.put(CommonControlDataDefns.NCD_FLAG,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().NCD_FLAG(), "Failed to retrieve ncd flag"));
            break;
          case CommonControlDataDefns.CONCERN_FLAG:
            basicPolicyInfo.put(CommonControlDataDefns.CONCERN_FLAG,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().CONCERN_FLAG(), "Failed to retrieve concern flag"));
            break;
          case CommonControlDataDefns.POLICY_START_DATE:
            basicPolicyInfo.put(CommonControlDataDefns.POLICY_START_DATE,
             getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().POLICY_START_DATE(), "value", "Failed retrieve policy start date"));
            break;
          case CommonControlDataDefns.POLICY_END_DATE:
            basicPolicyInfo.put(CommonControlDataDefns.POLICY_END_DATE,
             getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().POLICY_END_DATE(), "value", "Failed retrieve policy end date"));
            break;
          case CommonControlDataDefns.NUM_OF_DAYS_IN_A_TERM_VAR:
            basicPolicyInfo.put(CommonControlDataDefns.NUM_OF_DAYS_IN_A_TERM,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().NUM_OF_DAYS_IN_A_TERM(), "Failed to retrieve number day in a term"));
            break;
          case CommonControlDataDefns.AGENCY_NUMBER:
            basicPolicyInfo.put(CommonControlDataDefns.AGENCY_NUMBER,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().AGENCY_NUMBER(), "Failed to retrieve agency number"));
            break;
          default:
        }
      }
    } catch (ParseException exception) {
      throw new CustomE2eException(exception.getMessage());
    }
    return basicPolicyInfo;
  }

  private TreeMap<String, Object> getPersonalDetails() throws CustomE2eException {
    var custDetails = new TreeMap<String, Object>();
    waitForPageLoad();
    var insuredTabLabels =
     getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().GET_POLICY_INFORMATION_LABEL());

//    var treeMap = new TreeMap<String, Object>();
//    var tabLabelsArrayList =
//    getTextAllWebElementMatchingLocator(
//            By.xpath("//tr[not(contains(@style, 'display: none'))  and not(contains(@class, 'hidden'))]/td[contains(@class, 'pfFormLabel')]//label[string-length(text()) > 0]"));
//
//    var tabValuesArrayList =
//    getTextAllWebElementMatchingLocator(
//            By.xpath("//tr[./td[contains(@class, 'pfFormLabel')]/label[string-length(text()) > 0]]/td[contains(@class, 'pfFormControl')]//span[contains(@id, 'policyDataGatherForm:sedit') and not(contains(@style, 'display: none')) and not(contains(@class, 'hidden'))]"));
//
//    IntStream
//            .range(0, tabLabelsArrayList.size())
//            .forEach(index ->
//                    treeMap.put(tabLabelsArrayList.get(index), tabValuesArrayList.get(index))
//            );
//
//    return treeMap;

    try {
      for (var fieldName : insuredTabLabels) {
        switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(fieldName.trim())) {
          case CommonControlDataDefns.TITLE:
            custDetails.put(CommonControlDataDefns.TITLE,
             Optional.ofNullable(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().TITLE(), "Failed to retrieve first name")).orElse("NoValue"));
            break;
          case CommonControlDataDefns.FIRST_NAME_VAR:
            custDetails.put(CommonControlDataDefns.FULL_NAME,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().FIRST_NAME(), "Failed to retrieve first name").concat(" ").concat(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().SURNAME(), "Failed to retrieve surname")));
            break;
          case CommonControlDataDefns.DATE_OF_BIRTH:
            custDetails.put(CommonControlDataDefns.DATE_OF_BIRTH,
             Formatting.changeDateFormatIntoExpected(getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().DATE_OF_BIRTH(), "value", "Failed retrieve date of birth"), DEFAULT_DATE_FORMAT, "mm/dd/yyyy"));
            break;
          case CommonControlDataDefns.GENDER:
            custDetails.put(CommonControlDataDefns.GENDER,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().GENDER(), "Failed to retrieve gender"));
            break;
          case CommonControlDataDefns.MARITAL_STATUS:
            custDetails.put(CommonControlDataDefns.MARITAL_STATUS,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().MARITAL_STATUS(), "Failed to retrieve marital status"));
            break;
          case CommonControlDataDefns.RESIDENCE_IN_UK_SINCE:
            custDetails.put(CommonControlDataDefns.RESIDENCE_IN_UK_SINCE,
             Formatting.changeDateFormatIntoExpected(getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().RESIDENCE_IN_UK_SINCE(), "value", "Failed retrieve residence in uk since"), DEFAULT_DATE_FORMAT, "mm/dd/yyyy"));
            break;
          case CommonControlDataDefns.EMPLOYMENT_STATUS:
            var employmentDetails = new TreeMap<String, Object>();
            employmentDetails.put(CommonControlDataDefns.PRIMARY_EMPLOYMENT_DET,
                    getPrimaryEmploymentDetails());
            employmentDetails.put(CommonControlDataDefns.SECOND_EMPLOYMENT_DET,
             getSecondJobEmploymentStatus());
            custDetails.put(CommonControlDataDefns.EMPLOYMENT_DET, employmentDetails);
            break;
          case CommonControlDataDefns.PREFERRED_DELIVERY:
            custDetails.put(CommonControlDataDefns.PREFERRED_DELIVERY,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().PREFERRED_DELIVERY(), "Failed to retrieve preferred delivery"));
            break;
          case CommonControlDataDefns.FCA_CLASS:
            custDetails.put(CommonControlDataDefns.FCA_CLASS,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().FCA_CLASS(), "Failed to retrieve fca class"));
          case CommonControlDataDefns.ADDRESS:
            custDetails.put(CommonControlDataDefns.ADDRESS, getAddressDetails());
            break;
          case CommonControlDataDefns.EMAIL_ADDRESS_VAR, CommonControlDataDefns.EMAIL_ADDRESS:
            custDetails.put(CommonControlDataDefns.EMAIL_ADDRESS,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().EMAIL_ADDRESS(), "Failed to retrieve email address"));
            break;
          case CommonControlDataDefns.PHONE_NUMBER:
            custDetails.put(CommonControlDataDefns.PHONE_NUMBER,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().INSURED_PHONE_NO(), "Failed to retrieve phone number"));
            break;
          //           Is proposer member of IAM or other organisation
          case CommonControlDataDefns.PROPOSER_IAM_OTHER_ORGANISATION_VAR:
            custDetails.put(CommonControlDataDefns.PROPOSER_IAM_OTHER_ORGANISATION,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().IAM_PROPOSER(), "Failed to retrieve IAM proposer"));
            break;
          //           How many children or dependents under the age of 16?
          case CommonControlDataDefns.NUM_CHILD_UNDER_16_VAR:
            custDetails.put(CommonControlDataDefns.NUM_CHILD_UNDER_16,
                getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().DEPENDENTS_CHILD_UNDER_16(), "Failed to retrieve dependent child"));
            break;
          //VAN Only
//      How many cars are there in your household, excluding this one?
          case CommonControlDataDefns.NUMBER_OF_CARS_EXCLUDING_CURRENT_VAR:
            custDetails.put(CommonControlDataDefns.NUMBER_OF_CARS_EXCLUDING_CURRENT,
             Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().NUM_CARS_EXCLUDING_CURRENT(), "Failed to retrieve number of cars excluding")));
            break;
//      Use of vehicle by proposer
          case CommonControlDataDefns.VEHICLE_USE_FOR_VAR:
            custDetails.put(CommonControlDataDefns.VEHICLE_USE_FOR,
                    CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorVehicleLocatorModel().VEHICLE_USE_FOR(), "Failed to retrieve vehicle proposer")));
            break;
          //            //Insurance previously refused ?
          case CommonControlDataDefns.PREV_INSURANCE_REFUSED_VAR:
            custDetails.put(CommonControlDataDefns.PREV_INSURANCE_REFUSED,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().PREV_INSURANCE_REFUSED(), "Failed to retrieve previous insurance refused"));
            break;

          //Preferred Payment Method
          case CommonControlDataDefns.PREFERRED_PAYMENT_METHOD:
            custDetails.put(CommonControlDataDefns.PREFERRED_PAYMENT_METHOD,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().PREFERRED_PAYMENT_METHOD(), "Failed to retrieve preferred payment method"));
            break;

          //Are You A Home Owner?
          case CommonControlDataDefns.HOME_OWNER_VAR:
            custDetails.put(CommonControlDataDefns.HOME_OWNER,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().ARE_YOU_HOME_OWNER(), "Failed to retrieve home owner value"));
            break;

          ////Has affordability threshold been reached ?
          case CommonControlDataDefns.AFFORDABILITY_THRESHOLD_VAR:
            custDetails.put(CommonControlDataDefns.AFFORDABILITY_THRESHOLD,
             CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().AFFORDABILITY_THRESHOLD(), "Failed to retrieve affordability threshold")));
            break;
//U/w only premium finance rekey ?
          case CommonControlDataDefns.PREMIUM_FINANCE_REKEY_VAR:
            custDetails.put(CommonControlDataDefns.PREMIUM_FINANCE_REKEY,
                CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().U_W_PREMIUM_FINANCE_REKEY(), "Failed to retrieve finance rekey")));
            break;
//Previous Insurance
          case CommonControlDataDefns.PREV_INSURANCE:
            custDetails.put(CommonControlDataDefns.PREVIOUS_INSURANCE_AVAILABLE,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().PREVIOUS_INSURANCE(), "Failed to retrieve previous insurance"));
            break;

//Previous Policy Expiry Date
          case CommonControlDataDefns.PREVIOUS_POLICY_EXPIRY_DATE:
            custDetails.put(CommonControlDataDefns.PREVIOUS_POLICY_EXPIRY_DATE,
             Formatting.changeDateFormatIntoExpected(getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().PREV_POLICY_EXPIRY_DATE(), "value", "Failed to retrieve previous policy expiry date"), DEFAULT_DATE_FORMAT, "mm/dd/yyyy"));
            break;
//Type of Insurance
          case CommonControlDataDefns.TYPE_OF_INSURANCE_VAR:
            custDetails.put(CommonControlDataDefns.TYPE_OF_INSURANCE,
                getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().INSURANCE_TYPE(), "Failed to retrieve insurance type"));
            break;
//NCD claimed Year
          case CommonControlDataDefns.NCD_CLAIM_YEAR:
            custDetails.put(CommonControlDataDefns.NCD_CLAIM_YEARS,
             Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().NCD_CLAIM_FREE_YEARS(), "Failed to retrieve insurance type")));
            break;
//Would you like to protect your No Claims Discount?
          case CommonControlDataDefns.PROTECT_NCD_VAR:
          case CommonControlDataDefns.PROTECT_NCD:
            custDetails.put(CommonControlDataDefns.PROTECT_NCD,
             CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().PROTECT_NCD_CLAIMS_DISCOUNT(), "Failed to retrieve protect ncd claim discount")));
            break;
//Do you have access to any other vehicles?
          case CommonControlDataDefns.ACCESS_TO_OTHER_VEHICLE_FLAG_VAR:
            custDetails.put(CommonControlDataDefns.ACCESS_TO_OTHER_VEHICLE,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().ACCESS_TO_ANY_OTHER_VEHICLE(), "Failed to retrieve access to any other driver"));
            break;
          //How many?
          case CommonControlDataDefns.ACCESS_TO_OTHER_VEHICLE:
            custDetails.put(CommonControlDataDefns.ACCESS_TO_OTHER_VEHICLE,
             Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().ACCESS_TO_ANY_OTHER_VEHICLE(), "Failed to retrieve access to any other driver")));
            break;

          case CommonControlDataDefns.YEAR_NCD:
            custDetails.put(CommonControlDataDefns.YEAR_NCD,
             Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().NCD_CLAIM_FREE_YEARS(), "Failed to retrieve NCDYears")));
            break;

          //Use of vehicle by proposer
          case CommonControlDataDefns.VEHICLE_USE_FOR_BY_PROPOSER_VAR:
            custDetails.put(CommonControlDataDefns.VEHICLE_USE_BY_PROPOSER,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().USE_VEHICLE_BY_PROPOSER(), ""));
            break;
//How many years' NCD do you have on your other vehicle
          //NCD Applied to Any Other Vehicle
          case CommonControlDataDefns.NCD_APPLIED_TO_ANOTHER_VEHICLE_VAR,
           CommonControlDataDefns.NCD_APPLIED_TO_ANY_OTHER_VEHICLE:
          case CommonControlDataDefns.NCD_YEAR_APPLIED_TO_ANY_OTHER_VEHICLE_VAR:
            custDetails.put(CommonControlDataDefns.NCD_APPLIED_TO_ANOTHER_VEHICLE,
             CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().NCD_APPLIED_OTHER_VEHICLE(), "Failed to retrieve Ncd applied to other vehicle")));
            break;
//What type of policy is the NCD being mirrored from?
          case CommonControlDataDefns.NCD_BEING_MIRRORED_FROM_VAR:
            custDetails.put(CommonControlDataDefns.NCD_BEING_MIRRORED_FROM,
                getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().NCD_MIRRORED_FROM(), "Failed to retrieve Ncd mirrored from"));
            break;

          default:
        }
      }
    } catch (ParseException exception) {
      throw new CustomE2eException(exception.getMessage());
    }
    return custDetails;
  }

//  private String getFullNameMotor() throws CustomE2eException {
//    return getText(this.pageObjectOfEis.getEisMotorPolicyDetailsLocatorModel().FIRST_NAME())
//    .concat(" ").concat(getText(this.pageObjectOfEis.getEisMotorPolicyDetailsLocatorModel()
//    .SURNAME()));
//  }

//  private String getEmailAddressMotor() throws CustomE2eException {
//    return getText(this.pageObjectOfEis.getEisMotorPolicyDetailsLocatorModel().EMAIL_ADDRESS());
//  }
//
//  private String getPhoneNumberMotor() throws CustomE2eException {
//    return getText(this.pageObjectOfEis.getEisMotorPolicyDetailsLocatorModel().PHONE_NUMBER());
//  }
//
//  private TreeMap<String, Object> getAddressDetailsMotor() throws CustomE2eException {
//    var houseAddressDetails = new TreeMap<String, Object>();
//    houseAddressDetails.put(CommonControlDataDefns.HOUSE_IDENTIFIER,
//        getText(this.pageObjectOfEis.getEisMotorPolicyDetailsLocatorModel().ADDRESS_POSTCODE()));
//    houseAddressDetails.put(CommonControlDataDefns.POST_CODE,
//        getText(this.pageObjectOfEis.getEisMotorPolicyDetailsLocatorModel().ADDRESS_POSTCODE()));
//    return houseAddressDetails;
//  }
//
//  private Integer getNcdYearMotor() throws CustomE2eException {
//    return Integer.parseInt(getText(this.pageObjectOfEis.getEisMotorPolicyDetailsLocatorModel()
//    .NCD_CLAIM_FREE_YEARS()));
//  }

  private TreeMap<String, Object> getAddressDetails() throws CustomE2eException {
    var houseAddressDetails = new TreeMap<String, Object>();
    houseAddressDetails.put(CommonControlDataDefns.HOUSE_IDENTIFIER,
     getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().ADDRESS_HOUSE_IDENTIFIER(), "Failed to retrieve house identifier"));
    houseAddressDetails.put(CommonControlDataDefns.POST_CODE,
     getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().ADDRESS_POSTCODE(), "Failed to retrieve postcode"));
    return houseAddressDetails;
  }

  private SortedMap<String, Object> getPrimaryEmploymentDetails() throws CustomE2eException {
    TreeMap<String, Object> employmentStatus = new TreeMap<>();
    employmentStatus.put(CommonControlDataDefns.EMPLOYMENT_STATUS,
     Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().PRIMARY_EMPLOYMENT_STATUS(), "Failed to retrieve employment status")));

    employmentStatus.put(CommonControlDataDefns.OCCUPATION,
     Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().PRIMARY_OCCUPATION(), "Failed to retrieve employment occupation")));

    employmentStatus.put(CommonControlDataDefns.INDUSTRY,
     Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().PRIMARY_JOB_INDUSTRY(), "Failed to retrieve employment industry")));
    return employmentStatus;
  }

  public SortedMap<String, Object> getSecondJobEmploymentStatus() throws CustomE2eException {
    TreeMap<String, Object> secondEmploymentStatus = new TreeMap<>();
    secondEmploymentStatus.put(CommonControlDataDefns.SECOND_EMP_FLAG,
     CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().SECOND_JOB_EMPLOYMENT_FLAG(), "Failed to retrieve second job employment status")));
    if (secondEmploymentStatus.get(CommonControlDataDefns.SECOND_EMP_FLAG).equals(true)) {
      secondEmploymentStatus.put(CommonControlDataDefns.EMPLOYMENT_STATUS,
       Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().SECOND_EMPLOYMENT_STATUS(), "Failed to retrieve second job employment status")));
      secondEmploymentStatus.put(CommonControlDataDefns.OCCUPATION,
       Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().SECOND_EMPLOYMENT_OCCUPATION(), "Failed to retrieve second job employment status")));
      secondEmploymentStatus.put(CommonControlDataDefns.INDUSTRY,
       Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().SECOND_EMPLOYMENT_INDUSTRY(), "Failed to retrieve second job employment status")));
    }
    return secondEmploymentStatus;
  }


  public SortedMap<String, Object> getOptionalExtrasAdded() throws CustomE2eException {
    var optionalExtraDetails = new TreeMap<String, Object>();
//    clickElement(this.pageObjectOfEis.getEisSharedLocatorModel().CANCEL_BUTTON(),
//SyncType.CLICKABLE);
    optionalExtraDetails.put(CommonControlDataDefns.EXCESS_PROTECTION, false);
    optionalExtraDetails.put(CommonControlDataDefns.LEGAL_EXPENSES, false);
    optionalExtraDetails.put(CommonControlDataDefns.HOME_EMERGENCY, false);
    optionalExtraDetails.put(CommonControlDataDefns.EXCESS_PROTECTION_SUBSIDENCE_VAR, false);
    if (isElementVisible(this.pageObjectOfEis.getEisSharedLocatorModel().LIST_OPTIONAL_EXTRAS())) {
      List<WebElement> rows =
getElementsMatchingToLocator(this.pageObjectOfEis.getEisSharedLocatorModel().LIST_OPTIONAL_EXTRAS());
      for (int enhanceCoverRows = 1; enhanceCoverRows <= rows.size(); enhanceCoverRows++) {
        String description =
        getText(xpathBuilder(this.pageObjectOfEis.getEisSharedLocatorModel().LIST_OPTIONAL_EXTRAS_TABLE_COLUMN(), String.valueOf(enhanceCoverRows))).trim();
        optionalExtraDetails.put(getKeyValue(description), true);
      }
    }
    return optionalExtraDetails;
  }
//
//  private String getDateOfBirth() throws CustomE2eException, ParseException {
//    return Formatting.changeDateFormatIntoExpected(getAttribute(this.pageObjectOfEis
//    .getEisMotorPolicyDetailsLocatorModel().DATE_OF_BIRTH(), "value"), "dd/mm/yyyy",
//    "mm/dd/yyyy");
//  }
//
//  private String getRelationshipStatus() throws CustomE2eException {
//    return getText(this.pageObjectOfEis.getEisMotorPolicyDetailsLocatorModel().MARITAL_STATUS());
//  }
//
//  private String getPreviousPolicyExpiryDate() throws CustomE2eException, ParseException {
//    return Formatting.changeDateFormatIntoExpected(getAttribute(this.pageObjectOfEis
//    .getEisMotorPolicyDetailsLocatorModel().PREV_POLICY_EXPIRY_DATE(), "value"), "dd/mm/yyyy",
//    "mm/dd/yyyy");
//  }


//  private void restructureInformation(TreeMap<String, Object> policyTabDetails, TreeMap<String,
//      Object> insuredTabDetails, TreeMap<String, Object> driverTabDetails, TreeMap<String,
//      Object> claimAndConvictionTabDetails, TreeMap<String, Object> vehicleTabDetails) {
//    var individualPolicy = new TreeMap<String, Object>();
//    var custDetails = new TreeMap<String, Object>();
//    var coverDetails = new TreeMap<String, Object>();
//    var excessDetails = new TreeMap<String, Object>();
//    coverDetails.put(PortalGeneralStepDefinitions.REGISTRATION_NUMBER, vehicleTabDetails.get(
//        "Vehicle Registration Number"));
//    coverDetails.put(PortalGeneralStepDefinitions.VEHICLE_TYPE,
//        vehicleTabDetails.get("Vehicle " + "Type"));
//    coverDetails.put(PortalGeneralStepDefinitions.CAR_MAKE, vehicleTabDetails.get("Make"));
//    coverDetails.put(PortalGeneralStepDefinitions.CAR_MODEL, vehicleTabDetails.get("Model"));
//    coverDetails.put(PortalGeneralStepDefinitions.YEAR_MANUFACTURE,
//        vehicleTabDetails.get("Year " + "of Manufacture"));
//    coverDetails.put(PortalGeneralStepDefinitions.FUEL_TYPE, vehicleTabDetails.get("Fuel " +
//        "Type"));
//    coverDetails.put(PortalGeneralStepDefinitions.ABI_CODE, vehicleTabDetails.get("ABI Code"));
//    coverDetails.put(PortalGeneralStepDefinitions.CAR_MARKET_VALUE, vehicleTabDetails.get("Market"
//        + " value"));
//    coverDetails.put(PortalGeneralStepDefinitions.TRANSMISSION, vehicleTabDetails.get(
//        "Transmission"));
//    coverDetails.put(PortalGeneralStepDefinitions.CAR_ALARM_TYPE, vehicleTabDetails.get("Alarm"));
//    coverDetails.put(PortalGeneralStepDefinitions.LEFT_HAND_DRIVER,
//        vehicleTabDetails.get("Left " + "Hand Drive"));
//    coverDetails.put(PortalGeneralStepDefinitions.CLASS_USE,
//        vehicleTabDetails.get("What do you " + "use your car for?"));
//    coverDetails.put(PortalGeneralStepDefinitions.ANNUAL_MILEAGE,
//        vehicleTabDetails.get("Annual " + "Mileage"));
//    coverDetails.put(PortalGeneralStepDefinitions.CAR_BUYING_DATE,
//        vehicleTabDetails.get("When " + "did you buy your car?"));
//    coverDetails.put(PortalGeneralStepDefinitions.CAR_LOC_OVERNIGHT, vehicleTabDetails.get("Where"
//        + " Kept Postcode"));
//    coverDetails.put(PortalGeneralStepDefinitions.CAR_OWNER, vehicleTabDetails.get("Vehicle " +
//        "owner"));
//    coverDetails.put(PortalGeneralStepDefinitions.REG_KEEPER, vehicleTabDetails.get("Proposer" +
//        " registered keeper"));
//
//
//    individualPolicy.put(CommonControlDataDefns.COVER_DET, coverDetails);
//  }


  private String getKeyValue(String text) {
    String enhanceKey = null;
    switch (text) {
      case "Excess Protect":
        enhanceKey =
        Formatting.capitalizeAllFirstCapitalizeRemoveSpace(PortalGeneralStepDefinitions.EXCESS_PROTECTION);
        break;
      case "Legal Expenses":
        enhanceKey =
        Formatting.capitalizeAllFirstCapitalizeRemoveSpace(PortalGeneralStepDefinitions.LEGAL_EXP);
        break;
      case "Home Emergency":
        enhanceKey =
         Formatting.capitalizeAllFirstCapitalizeRemoveSpace(PortalGeneralStepDefinitions.EXTRA_HOME_EMERGENCY);
        break;
      case "Excess Protect with subsidence":
        enhanceKey =
        Formatting.capitalizeAllFirstCapitalizeRemoveSpace(PortalGeneralStepDefinitions.EXCESS_PROTECT_SUBSIDENCE);
        break;
      default:
    }
    return enhanceKey;
  }

  public SortedMap<String, Object> getHomePolicyBasicInformation() throws CustomE2eException {
    var basicPolicyInfo = new TreeMap<String, Object>();
    var policyTabLabel =
     getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().GET_POLICY_INFORMATION_LABEL());
    try {
      for (var fieldName : policyTabLabel) {
        switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(fieldName)) {
          case CommonControlDataDefns.ENQUIRY:
            basicPolicyInfo.put(CommonControlDataDefns.ENQUIRY,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().ENQUIRY(), "Failed to retrieve enquiry"));
            break;
          case CommonControlDataDefns.SALES_CHANNEL:
            basicPolicyInfo.put(CommonControlDataDefns.SALES_CHANNEL,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().SALES_CHANNEL(), "Failed to retrieve sales channel"));
            break;
          case CommonControlDataDefns.BRAND:
            basicPolicyInfo.put(CommonControlDataDefns.BRAND,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().BRAND(), "Failed to retrieve brand"));
            break;
          case CommonControlDataDefns.PROD_TYPE:
            basicPolicyInfo.put(CommonControlDataDefns.PROD_TYPE,
                getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().PROD_TYPE(), "Failed to retrieve product type"));
            break;
          case CommonControlDataDefns.SCHEME:
            basicPolicyInfo.put(CommonControlDataDefns.SCHEME,
                    getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().SCHEME(), "Failed to retrieve scheme"));
            break;
          case CommonControlDataDefns.AFFINITY_CODE:
            basicPolicyInfo.put(CommonControlDataDefns.AFFINITY,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().AFFINITY_CODE(), "Failed to retrieve affinity code"));
            break;
          case CommonControlDataDefns.TYPE_OF_HOUSEHOLD_COVER_VAR:
            basicPolicyInfo.put(CommonControlDataDefns.TYPE_OF_HOUSEHOLD_COVER,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().HOUSEHOLD_COVER(), "Failed to retrieve cover type"));
            break;
          case CommonControlDataDefns.POLICY_PERIOD:
            basicPolicyInfo.put(CommonControlDataDefns.POLICY_PERIOD,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().POLICY_PERIOD(), "Failed to retrieve policy period"));
            break;
          case CommonControlDataDefns.ORIGINAL_QUOTE_DATE:
            basicPolicyInfo.put(CommonControlDataDefns.ORIGINAL_QUOTE_DATE,
             Formatting.changeDateFormatIntoExpected(getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().ORIGINAL_QUOTE_DATE(), "value", "Failed retrieve original quote date"), DEFAULT_DATE_FORMAT, "mm/dd/yyyy"));
            break;
          case CommonControlDataDefns.INCEPTION_DATE_VAR:
            basicPolicyInfo.put(CommonControlDataDefns.INCEPTION_DATE,
             Formatting.changeDateFormatIntoExpected(this.commonHelper.getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().INCEPTION_DATE(), "value", "Failed retrieve inception date"), DEFAULT_DATE_FORMAT, "mm/dd/yyyy"));
            break;

          case CommonControlDataDefns.RENEWAL_COUNT:
            basicPolicyInfo.put(CommonControlDataDefns.RENEWAL_COUNT,
             Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().RENEWAL_COUNT(), "Failed to retrieve renewal count")));
            break;
          case CommonControlDataDefns.POLICY_START_DATE:
            basicPolicyInfo.put(CommonControlDataDefns.POLICY_START_DATE,
             getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().POLICY_START_DATE(), "value", "Failed retrieve policy start date"));
            break;
          case CommonControlDataDefns.POLICY_END_DATE:
            basicPolicyInfo.put(CommonControlDataDefns.POLICY_END_DATE,
             Optional.ofNullable(getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().POLICY_END_DATE(), "value", "Failed retrieve policy end date")).orElse("NoValue"));
            break;
          case CommonControlDataDefns.UNSATISFIED_COUNTY_JUDGEMENTS_VAR:
            basicPolicyInfo.put(CommonControlDataDefns.UNSATISFIED_COUNTY_JUDGEMENTS,
                    CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisHomePolicyDetailsLocatorModel().UNSATISFIED_COUNTY_COURT_JUDGEMENTS(), "Failed retrieve policy end date")));
            break;
          case CommonControlDataDefns.DECLARED_BANKRUPT_VAR:
            basicPolicyInfo.put(CommonControlDataDefns.DECLARED_BANKRUPT,
             CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisHomePolicyDetailsLocatorModel().DELCARED_BANKRUPT(), "Failed to retrieve number day in a term")));
            break;
          case CommonControlDataDefns.AGENCY_NUMBER:
            basicPolicyInfo.put(CommonControlDataDefns.AGENCY_NUMBER,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyBasicInfoLocatorModel().AGENCY_NUMBER(), "Failed to retrieve agency number"));
            break;
          default:
        }
      }
    } catch (ParseException exception) {
      throw new CustomE2eException(exception.getMessage());
    }
    return basicPolicyInfo;
  }

//  public SortedMap<String, Object> getInterestedPartiesDetails() throws CustomE2eException {
//    return null;
//  }
//
//  public SortedMap<String, Object> getClaimDetails() throws CustomE2eException {
//
//    return null;
//  }

  public SortedMap<String, Object> getRiskAddressDetails() throws CustomE2eException {
    var riskAddressDetails = new TreeMap<String, Object>();
    var addressDet =
     getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().GET_POLICY_INFORMATION_LABEL());
    try {
      for (var fieldName : addressDet) {
        switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(fieldName)) {

          case CommonControlDataDefns.EXTENSION_DETAILS_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.EXTENSION_DETAILS,
               CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().INSURED_ADDRESS_EXTENSION(), "Failed to retrieve risk address flag.")));
          case CommonControlDataDefns.PET_LIVING_IN_PROPERTY_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.PET_DET,
               getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().PET_DETAILS(), "Failed to retrieve risk address flag."));
          case CommonControlDataDefns.NUM_CHILD_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.NUM_CHILD,
               Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().NUMBER_OF_CHILDREN(), "Failed to retrieve number of children")));
          case CommonControlDataDefns.NUM_ADULTS_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.NUM_ADULTS,
               Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().NUMBER_OF_ADULTS(), "Failed to retrieve number of adult.")));
          case CommonControlDataDefns.RISK_ADD_SAME_AS_CORRESPONDENCE_ADDRESS ->
              riskAddressDetails.put(CommonControlDataDefns.RISK_ADD_SAME_AS_CORRESPONDENCE_ADDRESS_FLAG, CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().RISK_ADDRESS_SAME_AS_CORRESPONDENCE_FLAG(), "Failed to retrieve risk address flag.")));
          case CommonControlDataDefns.BUILDING_NAME_NUMBER_VAR, CommonControlDataDefns.POST_CODE ->
              riskAddressDetails.put(CommonControlDataDefns.RISK_ADDRESS, getAddressDetails());
          case CommonControlDataDefns.PRIMARY_RESIDENCE_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.PRIMARY_RESIDENCE,
               CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().PRIMARY_RESIDENCE(), "Failed to retrieve primary residence flag.")));
          case CommonControlDataDefns.NUM_OF_BEDROOM ->
              riskAddressDetails.put(CommonControlDataDefns.NUM_OF_BEDROOM,
               Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().NUMBER_OF_BEDROOMS(), "Failed to retrieve number of bedrooms.")));
          case CommonControlDataDefns.NUM_OF_BATHROOM_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.NUM_OF_BATHROOM,
               Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().NUMBER_OF_BEDROOMS(), "Failed to retrieve number of bathrooms.")));
          case CommonControlDataDefns.YEAR_BUILT_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.YEAR_BUILT_VAR,
                  getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().CONSTRUCTION_YEAR(), "Failed to retrieve year built."));
          case CommonControlDataDefns.OWNERSHIP_TYPE ->
              riskAddressDetails.put(CommonControlDataDefns.OWNERSHIP_TYPE,
                  Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().OWNERSHIP_TYPE(), "Failed to retrieve ownership type")));
          case CommonControlDataDefns.PROPERTY_LET_SUBLET_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.PROPERTY_LET_SUBLET_FLAG,
               CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().PROPERTY_LET_SUBLET_STATUS(), "Failed to retrieve property let status")));
          case CommonControlDataDefns.BUILDING_WORK_FLAG_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.BUILDING_WORK_FLAG,
               CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().BUILDING_WORK(), "")));
          case CommonControlDataDefns.GOOD_REPAIR_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.GOOD_REPAIR_FLAG,
               CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().GOOD_REPAIR(), "")));
          case CommonControlDataDefns.CONSTRUCTION_TYPE ->
              riskAddressDetails.put(CommonControlDataDefns.CONSTRUCTION_TYPE,
               Optional.ofNullable(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().CONSTRUCTION_TYPE(), "")).filter(Predicate.not(String::isEmpty)).orElse("NoValue"));
          case CommonControlDataDefns.OCCUPANCY_TYPE ->
              riskAddressDetails.put(CommonControlDataDefns.OCCUPANCY_VAR,
               getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().OCCUPANCY_TYPE(), ""));
          case CommonControlDataDefns.PROPERTY_LEFT_UNOCCUPIED_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.PROPERTY_LEFT_UNOCCUPIED,
               getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().PROPERTY_LEFT_UNOCCUPIED(), ""));
          case CommonControlDataDefns.BUSINESS_USE ->
              riskAddressDetails.put(CommonControlDataDefns.BUSINESS_USE,
               CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().BUSINESS_USE(), "")));
          case CommonControlDataDefns.DOOR_LOCKS_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.LOCKING_DETAILS,
                  CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().DOOR_LOCK_DETAILS(), "")));
          case CommonControlDataDefns.INTRUDER_ALARM_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.INTRUDER_ALARM,
               getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().INTRUDER_ALARM_DETAILS(), ""));
          case CommonControlDataDefns.NEIGHBOURHOOD_WATCH ->
              riskAddressDetails.put(CommonControlDataDefns.NEIGHBOURHOOD_WATCH,
               CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().NEIGHBOURHOOD_WATCH(), "")));
          case CommonControlDataDefns.NON_FAMILY_LODGER_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.NON_FAMILY_LODGER,
               CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().NON_FAMILY_LODGER(), "")));
          case CommonControlDataDefns.BRUSH_FIRE_SURCHARGE_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.BRUSH_FIRE_SURCHARGE,
               CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().BRUSH_FIRE_SURCHARGE(), "")));
          case CommonControlDataDefns.BUILDING_TYPE ->
              riskAddressDetails.put(CommonControlDataDefns.BUILDING_TYPE,
               Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().BUILDING_TYPE(), "")));
          case CommonControlDataDefns.BUILDING_TYPE_BUNGLOW_TYPE_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.BUNGLOW_TYPE_VAR,
               Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().BUNGLOW_TYPE(), "")));
          case CommonControlDataDefns.HOUSE_TYPE_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.HOUSE_TYPE,
               Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().HOUSE_TYPE(), "")));
          case CommonControlDataDefns.FREE_SUBSIDENCE_LANDSLIP_FLAG_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.SUBSIDENCE_GROUND_HEAVE_LAND_SLIP,
                  CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().FREE_SUBSIDENCE_LANDSLIP(), "")));
          case CommonControlDataDefns.FREE_FLOODING_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.FREE_FLOODING_THREAT_VAR,
               CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().FREE_FROM_FLOODING(), "")));
          case CommonControlDataDefns.LISTED_BUILDING_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.LISTED_BUILDING_FLAG,
               CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().BUILDING_LISTED_DETAILS(), "")));
          case CommonControlDataDefns.WALL_CONSTRUCTION ->
              riskAddressDetails.put(CommonControlDataDefns.WALL_CONSTRUCTION,
               Optional.ofNullable(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().WALL_CONSTRUCTION(), "failed to retrieve wall construction value")).filter(Predicate.not(String::isEmpty)).orElse("NoValue"));
          case CommonControlDataDefns.ROOF_CONSTRUCTION ->
              riskAddressDetails.put(CommonControlDataDefns.ROOF_CONSTRUCTION,
               Optional.ofNullable(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().ROOF_CONSTRUCTION(), "failed to retrieve roof construction value")).filter(Predicate.not(String::isEmpty)).orElse("NoValue"));
          case CommonControlDataDefns.PERCENTAGE_FLAT_ROOF_VAR ->
              riskAddressDetails.put(CommonControlDataDefns.PERCENTAGE_FLAT_ROOF,
               getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().FLAT_ROOF_PERCENTAGE(), ""));
        }
      }
    } catch (Exception exception) {
      throw new CustomE2eException(exception.getMessage());
    }
    return riskAddressDetails;
  }

  public SortedMap<String, Object> getInsuredDetails() throws CustomE2eException {
    var insuredDetails = new TreeMap<String, Object>();
    waitForPageLoad();
    var insuredTabLabels =
     getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().GET_POLICY_INFORMATION_LABEL());
    var custDetails = new TreeMap<String, Object>();

    try {
      for (var fieldName : insuredTabLabels) {
        switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(fieldName.trim())) {
          case CommonControlDataDefns.TITLE:
            custDetails.put(CommonControlDataDefns.TITLE,
                    Optional.ofNullable(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().TITLE(), "Failed to retrieve first name")).orElse("NoValue"));
            break;
          case CommonControlDataDefns.FIRST_NAME_VAR:
            custDetails.put(CommonControlDataDefns.FIRST_NAME,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().FIRST_NAME(), "Failed to retrieve first name"));
            break;
          case CommonControlDataDefns.SURNAME:
            custDetails.put(CommonControlDataDefns.LAST_NAME,
                getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().SURNAME(), "Failed to retrieve surname"));
            break;
          case CommonControlDataDefns.DATE_OF_BIRTH:
            custDetails.put(CommonControlDataDefns.DATE_OF_BIRTH,
             getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().DATE_OF_BIRTH(), "value", "Failed retrieve date of birth"));
            break;
          case CommonControlDataDefns.GENDER:
            custDetails.put(CommonControlDataDefns.GENDER,
                    getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().GENDER(), "Failed to retrieve gender"));
            break;
          case CommonControlDataDefns.MARITAL_STATUS:
            custDetails.put(CommonControlDataDefns.MARITAL_STATUS,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().MARITAL_STATUS(), "Failed to retrieve marital status"));
            break;
          case CommonControlDataDefns.RESIDENCE_IN_UK_SINCE:
            custDetails.put(CommonControlDataDefns.RESIDENCE_IN_UK_SINCE,
             Formatting.changeDateFormatIntoExpected(getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().RESIDENCE_IN_UK_SINCE(), "value", "Failed retrieve residence in uk since"), DEFAULT_DATE_FORMAT, "mm/dd/yyyy"));
            break;
          case CommonControlDataDefns.AGE:
            custDetails.put(CommonControlDataDefns.AGE,
             Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().AGE(), "Failed to retrieve marital status")));
            break;
          case CommonControlDataDefns.EMPLOYMENT_STATUS:
            var employmentDetails = new TreeMap<String, Object>();
            employmentDetails.put(CommonControlDataDefns.PRIMARY_EMPLOYMENT,
             getPrimaryEmploymentDetails());
            employmentDetails.put(CommonControlDataDefns.SECONDARY_EMPLOYMENT,
             getSecondJobEmploymentStatus());
            custDetails.put(CommonControlDataDefns.EMPLOYMENT_DET, employmentDetails);
            break;
          case CommonControlDataDefns.PREFERRED_DELIVERY:
            custDetails.put(CommonControlDataDefns.PREFERRED_DELIVERY,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().PREFERRED_DELIVERY(), "Failed to retrieve preferred delivery"));
            break;
          case CommonControlDataDefns.UNSPENT_CRIMINAL_CONVICTION_VAR:
            custDetails.put(CommonControlDataDefns.UNSPENT_CRIMINAL_CONVICTION,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().UNSPENT_CRIMINAL_CONVICTION(), "Failed to retrieve fca class"));
          case CommonControlDataDefns.ADDRESS:
            custDetails.put(CommonControlDataDefns.CORRESPONDENCE_ADDRESS, getAddressDetails());
            break;
          case CommonControlDataDefns.EMAIL, CommonControlDataDefns.EMAIL_ADDRESS:
            custDetails.put(CommonControlDataDefns.EMAIL_ADDRESS,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().EMAIL_ADDRESS(), "Failed to retrieve email address"));
            break;
          case CommonControlDataDefns.PHONE_NUMBER_VAR:
            custDetails.put(CommonControlDataDefns.PHONE_NUMBER,
             StringUtils.deleteWhitespace(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().PHONE_NUMBER(), "Failed to retrieve phone number")));
            break;
          case CommonControlDataDefns.INSURANCE_REFUSED_VAR:
            custDetails.put(CommonControlDataDefns.PREV_INSURANCE_REFUSED,
                    CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().INSURANCE_REFUSED(), "Failed to retrieve previous insurance refused")));
            break;
          //Preferred Payment Method
          case CommonControlDataDefns.PREFERRED_PAYMENT_METHOD:
            custDetails.put(CommonControlDataDefns.PREFERRED_PAYMENT_METHOD,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().PREFERRED_PAYMENT_METHOD(), "Failed to retrieve preferred payment method"));
            break;
          case CommonControlDataDefns.PREVIOUS_INSURANCE_VAR:
            custDetails.put(CommonControlDataDefns.PREVIOUS_INSURANCE,
             CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().PREV_INSURANCE(), "Failed to retrieve preferred payment method")));
            break;
          case CommonControlDataDefns.PREVIOUS_POLICY_EXPIRY_DATE_VAR:
            custDetails.put(CommonControlDataDefns.PREVIOUS_POLICY_EXPIRY_DATE,
             Optional.ofNullable(Formatting.changeDateFormatIntoExpected(getAttributeNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().PREV_POLICY_EXPIRATION_DATE(), "value", "Failed to retrieve previous policy expiry date"), DEFAULT_DATE_FORMAT, "mm/dd/yyyy")).orElse("NoValue"));
            break;
          case CommonControlDataDefns.PREVIOUS_COVER_TYPE:
            custDetails.put(CommonControlDataDefns.PREVIOUS_COVER_TYPE,
             getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().PREVIOUS_COVER_TYPE(), "Failed to retrieve preferred payment method"));
            break;
          case CommonControlDataDefns.NCD_BUILDING_VAR:
            custDetails.put(CommonControlDataDefns.NCD_BUILDING,
             Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().NCD_BUILDING(), "Failed to retrieve preferred payment method")));
            break;
          default:

        }
      }
    } catch (ParseException exception) {
      throw new CustomE2eException(exception.getMessage());
    }
    return custDetails;
  }

  public SortedMap<String, Object> getJPHDetails() throws CustomE2eException {
    var jphDetails = new TreeMap<String, Object>();
//    selectNameInsuredDropdown();
//    selectJointPolicyholder();

    waitForPageLoad();
    var insuredTabLabels =
     getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().GET_POLICY_INFORMATION_LABEL());
    try {
      for (var fieldName : insuredTabLabels) {
        switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(fieldName.trim())) {
          case CommonControlDataDefns.TITLE:
            jphDetails.put(JPH_TITLE, getJPHTitle());
            break;
          case CommonControlDataDefns.DATE_OF_BIRTH:
            jphDetails.put(JPH_DATE_OF_BIRTH, getJPHDateOfBirth());
            break;
          case CommonControlDataDefns.FIRST_NAME_VAR:
            jphDetails.put(CommonControlDataDefns.FIRST_NAME, getJPHFirstname());
            jphDetails.put(CommonControlDataDefns.LAST_NAME_VAR, getJPHLastname());
            break;
          case CommonControlDataDefns.EMPLOYMENT_STATUS:
            jphDetails.put(CommonControlDataDefns.EMPLOYMENT_DET, getJphEmploymentDet());
            break;
          case CommonControlDataDefns.MARITAL_STATUS:
            jphDetails.put(JPH_MARITAL_STATUS, getJPHMaritalStatus());
            break;
          case CommonControlDataDefns.RELATIONSHIP_TO_PROPOSER:
            jphDetails.put(CommonControlDataDefns.RELATIONSHIP_TO_PROPOSER,
             getJPHRelationshipToProposer());
            break;
          case CommonControlDataDefns.GENDER:
            jphDetails.put(CommonControlDataDefns.GENDER,
                    getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().GENDER(), "Failed to retrieve marital status"));
            break;
          case CommonControlDataDefns.AGE:
            jphDetails.put(CommonControlDataDefns.AGE,
             Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().AGE(), "Failed to retrieve marital status")));
            break;
          case CommonControlDataDefns.RESIDENCE_IN_UK_SINCE:
            var residenceInUk = getAttributeNotPresetBecomesEmpty(
                    this.pageObjectOfEis.getEisSharedLocatorModel().ADD_DRIVER_RESIDENCE_IN_UK_SINCE(),
                    "value",
                    "Failed retrieve residence in uk since"
            );

            Optional.ofNullable(
                    jphDetails.put(
                            CommonControlDataDefns.RESIDENCE_IN_UK_SINCE,
                            Formatting.changeDateFormatIntoExpected(residenceInUk, DEFAULT_DATE_FORMAT, "mm/dd/yyyy")
                    )
            ).orElse("");

            break;
          case CommonControlDataDefns.UNSPENT_CRIMINAL_CONVICTIONS:
            jphDetails.put(CommonControlDataDefns.UNSPENT_CRIMINAL_CONVICTION,
             CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().UNSPENT_CRIMINAL_CONVICTION(), "Failed to retrieve fca class")));
            break;
          case CommonControlDataDefns.INSURANCE_REFUSED_VAR:
            jphDetails.put(CommonControlDataDefns.PREV_INSURANCE_REFUSED,
             CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisMotorPolicyPersonalDetailsLocatorModel().INSURANCE_REFUSED(), "Failed to retrieve previous insurance refused")));
            break;
          default:
        }
      }
    } catch (ParseException exception) {
      throw new CustomE2eException(exception.getMessage());
    }
    return jphDetails;
  }

  private SortedMap<String, Object> getJphEmploymentDet() throws CustomE2eException {
    var jphDetails = new TreeMap<String, Object>();
    var employmentDet = new TreeMap<String, Object>();
    employmentDet.put(CommonControlDataDefns.EMPLOYMENT_STATUS, getJPHEmploymentStatus());
    employmentDet.put(CommonControlDataDefns.INDUSTRY, getJPHEmploymentIndustry());
    employmentDet.put(CommonControlDataDefns.OCCUPATION, getJPHOccupation());
    jphDetails.put(CommonControlDataDefns.PRIMARY_EMPLOYMENT, employmentDet);
    var secondEmpStatus = CommonHelper.convertStringIntoBoolean(getJphSecondEmploymentFlag());
    var secondEmployDet = new TreeMap<String, Object>();
    secondEmployDet.put(CommonControlDataDefns.SECOND_EMP_FLAG, secondEmpStatus);
    if (secondEmpStatus.equals(true)) {
      secondEmployDet.put(CommonControlDataDefns.EMPLOYMENT_STATUS, getJphSecondEmploymentStatus());
      secondEmployDet.put(CommonControlDataDefns.INDUSTRY, getJphSecondEmploymentIndustry());
      secondEmployDet.put(CommonControlDataDefns.OCCUPATION, getJphSecondEmploymentOccupation());
      jphDetails.put(CommonControlDataDefns.SECONDARY_EMPLOYMENT, secondEmployDet);
    }
    return jphDetails;
  }

  public SortedMap<String, Object> getExcessDetails() throws CustomE2eException {
    var excessDetails = new TreeMap<String, Object>();
    excessDetails.put(COMPULSORY_EXCESS_BUILDINGS_VAR, "0");
    excessDetails.put(COMPULSORY_EXCESS_CONTENT_VAR, "0");
    excessDetails.put(LEAKING_FREEZING, "0");
    excessDetails.put(SUBSIDENCE_GROUND_LANDSLIP, "0");
    excessDetails.put(FLOOD, "0");
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().POLICY_NUMBER(), SyncType.CLICKABLE);
    return excessDetails;
  }


  public SortedMap<String, Object> getInsuredAddressDetails() throws CustomE2eException {
    var insuredAddress = new TreeMap<String, Object>();
    clickRiskAddressTab();
    insuredAddress.put(HOME_BUILT_DETAILS,
     CommonHelper.convertStringIntoBoolean(getBuildingConstruction()));
    var insuredHomeExtensionDetails = isPropertyExtended();
    insuredAddress.put(HOME_EXTENSION_DETAILS,
     CommonHelper.convertStringIntoBoolean(insuredHomeExtensionDetails));
    var intruderAlarmDetails = getAlarmDetails();
    insuredAddress.put(HOME_INTRUDER_ALARM_DETAILS, intruderAlarmDetails);
    var homeListingDetails = getListedBuildingDetails();
    insuredAddress.put(HOME_LISTING_DETAILS,
     CommonHelper.convertStringIntoBoolean(homeListingDetails));
    var homeLockingDetails = getDoorLockDetails();
    insuredAddress.put(HOME_LOCKING_DETAILS,
     CommonHelper.convertStringIntoBoolean(homeLockingDetails));
    var numberOfAdults = getNumberOfAdults();
    insuredAddress.put(HOME_NUMBER_OF_ADULT_DETAILS, numberOfAdults);
    var numberOfChildren = getNumberOfChildren();
    insuredAddress.put(HOME_NUMBER_OF_CHILD_DETAILS, numberOfChildren);
    var homeOccupiedStatus = getHouseOccupancy();
    insuredAddress.put(HOME_OCCUPIED_DETAILS, homeOccupiedStatus);
    var payingGuestDetails = getPayingGuestDetails();
    insuredAddress.put(HOME_PAYING_GUEST_DETAILS,
     CommonHelper.convertStringIntoBoolean(payingGuestDetails));
    var petDetails = getPetDetails();
    insuredAddress.put(HOME_PET_DETAILS, CommonHelper.convertStringIntoBoolean(petDetails));
    var homeUseDetails = getBusinessUseDetails();
    insuredAddress.put(HOME_USE_DETAILS, CommonHelper.convertStringIntoBoolean(homeUseDetails));
    return insuredAddress;
  }

  public SortedMap<String, Object> additionalCoverDetails() throws CustomE2eException {
    var additionalCover = new TreeMap<String, Object>();
    clickPolicyNumber();
    clickInsuredTab();
    additionalCover.put(CONTENT_INSURANCE_HELD, getContentInsuranceHeld());
    clickCoverOptionsTab();
    var buildingAccidentalCover = getBuildingAccidentalDamageCover();

    additionalCover.put(BUILDING_ACCIDENTAL_DAMAGE_COVER,
     CommonHelper.convertStringIntoBoolean(buildingAccidentalCover));
    var contentAccidentalCover = getContentAccidentalDamageCover();
    additionalCover.put(CONTENT_ACCIDENTAL_DAMAGE_COVER,
     CommonHelper.convertStringIntoBoolean(contentAccidentalCover));

//
//        var contentAmount = getContentSumInsured();
//        additionalCover.put(CONTENTS_MY_COVER, contentAmount);

    var contentVoluntaryExcess = getContentVoluntaryExcess();
    additionalCover.put(CommonControlDataDefns.CONTENT_VOLUNTARY_EXCESS, contentVoluntaryExcess);
    var buildingVoluntaryExcess = getBuildingVoluntaryExcess();
    additionalCover.put(CommonControlDataDefns.BUILDING_VOLUNTARY_EXCESS, buildingVoluntaryExcess);
    var personalBelongingAwayFromHome = getPersonalisedItemAwayFromHome();
    additionalCover.put(PERSONAL_BELONGING_AWAY_FROM_HOME,
     CommonHelper.convertStringIntoBoolean(personalBelongingAwayFromHome));
    if (CommonHelper.convertStringIntoBoolean(getPersonalisedItemAwayFromHome())) {
      var personalBelongingAwayFromHomeCost = getPersonalisedItemsAwayFromHomeCost();
      additionalCover.put(PERSONAL_BELONGING_AWAY_FROM_HOME_COST,
       personalBelongingAwayFromHomeCost);
    } else {
      additionalCover.put(PERSONAL_BELONGING_AWAY_FROM_HOME_COST, "0");
    }
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().SPECIFIED_ITEMS_TAB(), SyncType.CLICKABLE);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().SPECIFIED_ITEMS_AT_HOME_TAB(), SyncType.CLICKABLE);
    var individualItemCover = getIndividualItemCover();
    additionalCover.put(INDIVIDUAL_ITEM_COVER,
     CommonHelper.convertStringIntoBoolean(individualItemCover));
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().SPECIFIED_ITEMS_AWAY_FROM_HOME_TAB(), SyncType.CLICKABLE);

    additionalCover.put(VALUABLE_OVER_2000£, false);
    return additionalCover;
  }

  public SortedMap<String, Object> getCoverDetails() throws CustomE2eException {
    var excessDetails = new TreeMap<String, Object>();
    var myCoverDetails = new TreeMap<String, Object>();

    var coverDetails = new TreeMap<String, Object>();
    var coverType = new TreeMap<String, Object>();

    var buildingCoverType = new TreeMap<String, Object>();
    var contentCoverType = new TreeMap<String, Object>();

    var coverTabLabel =
     getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().GET_POLICY_INFORMATION_LABEL());
    try {
      for (var fieldName : coverTabLabel) {
        switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(fieldName)) {
          case CommonControlDataDefns.FULL_ACCIDENTAL_COVER_ON_BUILDING_VAR ->
              myCoverDetails.put(CommonControlDataDefns.BUILDING_ACCIDENTAL_DAMAGE_COVER,
               CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().FULL_ACCIDENTAL_COVER_BUILDING(), "")));
          case CommonControlDataDefns.BUILDING_VOLUNTARY_EXCESS_VAR ->
              excessDetails.put(CommonControlDataDefns.BUILDING_VOLUNTARY_EXCESS,
                      Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().BUILDING_VOLUNTARY_EXCESS(), "")));
          case CommonControlDataDefns.REBUILDING_COST ->
              excessDetails.put(CommonControlDataDefns.BUILDING_COMPULSORY_EXCESS,
               Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().REBUILDING_COST(), "")));
          case CommonControlDataDefns.BUILDING_CLAIM_FREE_YEAR_VAR ->
              buildingCoverType.put(CommonControlDataDefns.BUILDING_CLAIM_FREE_YEAR,
               Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().BUILDING_NCD(), "")));
          //Content
          case CommonControlDataDefns.FULL_ACCIDENTAL_COVER_ON_CONTENT_VAR ->
              myCoverDetails.put(CommonControlDataDefns.CONTENT_ACCIDENTAL_DAMAGE_VAR,
               CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().FULL_ACCIDENTAL_COVER_ON_CONTENT_VAR(), "")));
          case CommonControlDataDefns.CONTENT_SUM_INSURED_VAR ->
              excessDetails.put(CommonControlDataDefns.CONTENT_COMPULSORY_EXCESS,
               Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().CONTENT_SUM_INSURED(), "")));
          case CommonControlDataDefns.CONTENT_VOLUNTARY_EXCESS_VAR ->
              excessDetails.put(CommonControlDataDefns.CONTENT_VOLUNTARY_EXCESS,
               Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().CONTENT_VOLUNTARY_EXCESS(), "")));
          case CommonControlDataDefns.CONTENTS_CLAIM_FREE_YEAR_VAR ->
              contentCoverType.put(CommonControlDataDefns.CONTENT_CLAIM_FREE_YEAR,
               Integer.parseInt(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().CONTENT_NCD(), "")));
          case CommonControlDataDefns.SAFE_INSTALLED ->
              contentCoverType.put(CommonControlDataDefns.SAFE_INSTALLED,
               CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().SAFE_INSTALLED(), "")));
          case CommonControlDataDefns.UNSPECIFIED_ITEM_TAKE_OUTSIDE_HOME_VAR ->
              contentCoverType.put(CommonControlDataDefns.INDIVIDUAL_ITEM_COVER,
               CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().UNSPECIFIED_TEMS_AWAY_FROM_HOME(), "")));
        }
      }
    } catch (Exception exception) {
      throw new CustomE2eException(exception.getMessage());
    }
    //These Fields are not available in EIS. Needs investigation
    //    excessDetails.put(LEAKING_FREEZING, 0);
    //    excessDetails.put(SUBSIDENCE_GROUND_LANDSLIP, 0);
    //    excessDetails.put(FLOOD, 0);

    myCoverDetails.put(CommonControlDataDefns.TYPE_VAR, getInsuranceType());
    coverType.put(CommonControlDataDefns.BUILDING_VAR, buildingCoverType);
    coverType.put(CommonControlDataDefns.CONTENTS_VAR, contentCoverType);

    coverDetails.put(CommonControlDataDefns.EXCESS_VAR, excessDetails);
    coverDetails.put(CommonControlDataDefns.MY_COVER_VAR, myCoverDetails);
    coverDetails.put(CommonControlDataDefns.OTHER_COVER_DET, coverType);
    coverDetails.put(CommonControlDataDefns.SPECIFIED_ITEM, getSpecifiedItemsHome());
    return coverDetails;
  }

  public SortedMap<String, Object> getSpecifiedItemsHome() throws CustomE2eException {

    var specifiedItemsDetails = new TreeMap<String, Object>();
    // With Bicycle
    int changeItemLink = 1;
    var inHomeItems = new ArrayList<SortedMap<String, Object>>();
    if (isElementVisible(this.pageObjectOfEis.getEisSharedLocatorModel().SPECIFIED_ITEMS_TAB())) {
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().SPECIFIED_ITEMS_TAB(), SyncType.CLICKABLE);
      var specifiedItemsInHome =
       getElementsMatchingToLocator(this.pageObjectOfEis.getEisSharedLocatorModel().ITEMS_IN_HOME_LIST()).size();
      for (int items = 0; items < specifiedItemsInHome; items++) {
        var inHome = new TreeMap<String, Object>();
        var itemsInHome =
         getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().GET_POLICY_INFORMATION_LABEL());
        try {
          for (var fieldName : itemsInHome) {
            switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(fieldName)) {
              case CommonControlDataDefns.VALUABLE_IN_HOME_FLAG_VAR ->
                  inHome.put(CommonControlDataDefns.VALUABLE_IN_HOME_FLAG,
                   CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().VALUABLE_IN_HOME_FLAG(), "")));
              case CommonControlDataDefns.SPECIFIED_ITEM ->
                  inHome.put(CommonControlDataDefns.SPECIFIED_ITEM,
                   Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().SPECIFIED_ITEMS_IN_HOME(), "")));
              case CommonControlDataDefns.ITEM_DESCRIPTION ->
                  inHome.put(CommonControlDataDefns.DESCRIPTION,
                   Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().SPECIFIED_ITEMS_IN_HOME_DESCRIPTION(), "")));
              case CommonControlDataDefns.VALUE_OF_SPECIFIED_ITEM ->
                  inHome.put(CommonControlDataDefns.VALUE,
                   Double.parseDouble(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().VALUABLE_IN_HOME(), "").replaceAll("[£,]", "")));
            }
          }
        } catch (Exception exception) {
          throw new CustomE2eException(exception.getMessage());
        }
        if (isElementVisible(xpathBuilder(this.pageObjectOfEis.getEisSharedLocatorModel().ITEM_CHANGE_LINK(), String.valueOf(changeItemLink + 1)))) {
          clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisSharedLocatorModel().ITEM_CHANGE_LINK(), String.valueOf(changeItemLink + 1)), SyncType.CLICKABLE);
          changeItemLink++;
        }
        inHomeItems.add(inHome);
      }
      specifiedItemsDetails.put(CommonControlDataDefns.ITEMS_IN_HOME, inHomeItems);
      specifiedItemsDetails.put(CommonControlDataDefns.IN_HOME_COUNT, inHomeItems.size());

    // Away from home items
    navigateToNextPage();
    changeItemLink = 1;
    var awayHomeItems = new ArrayList<SortedMap<String, Object>>();
      var specifiedItemsAwayHome =
       getElementsMatchingToLocator(this.pageObjectOfEis.getEisSharedLocatorModel().ITEMS_AWAY_FROM_HOME_LIST()).size();
      for (int items = 0; items < specifiedItemsAwayHome; items++) {
        var awayFromHome = new TreeMap<String, Object>();
        var itemsAwayFromHome =
            getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().GET_POLICY_INFORMATION_LABEL());
        //Logic
        try {
          for (var fieldName : itemsAwayFromHome) {
            switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(fieldName)) {
              case CommonControlDataDefns.VALUABLE_AWAY_FROM_HOME_FLAG_VAR ->
                  awayFromHome.put(CommonControlDataDefns.VALUABLE_AWAY_FROM_HOME_FLAG,
                   CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().VALUABLE_AWAY_HOME_FLAG(), "")));
              case CommonControlDataDefns.ITEM_VALUE_VAR ->
                  awayFromHome.put(CommonControlDataDefns.VALUE,
                   Double.parseDouble(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().SPECIFIED_ITEM_VALUE_AWAY_FROM_HOME(), "").replaceAll("[£,]", "")));
              case CommonControlDataDefns.SPECIFIED_ITEM ->
                  awayFromHome.put(CommonControlDataDefns.ITEM,
                   Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().SPECIFIED_ITEMS_AWAY_FROM_HOME(), "")));
              case CommonControlDataDefns.ITEM_DESCRIPTION ->
                  awayFromHome.put(CommonControlDataDefns.DESCRIPTION,
                   Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().SPECIFIED_ITEMS_AWAY_FROM_HOME_DESCRIPTION(), "")));
              case CommonControlDataDefns.LIMIT_AMOUNT ->
                  awayFromHome.put(CommonControlDataDefns.SPECIFIED_ITEMS_SUM_INSURED,
                   Double.parseDouble(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().SPECIFIED_ITEMS_SUM_INSURED(), "").replaceAll("[£,]", "")));
            }
          }
        } catch (Exception exception) {
          throw new CustomE2eException(exception.getMessage());
        }

        if (isElementVisible(xpathBuilder(this.pageObjectOfEis.getEisSharedLocatorModel().ITEM_CHANGE_LINK(), String.valueOf(changeItemLink + 1)))) {
          scrollIntoView(xpathBuilder(this.pageObjectOfEis.getEisSharedLocatorModel().ITEM_CHANGE_LINK(), String.valueOf(changeItemLink + 1)));
          clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisSharedLocatorModel().ITEM_CHANGE_LINK(), String.valueOf(changeItemLink + 1)), SyncType.CLICKABLE);
          changeItemLink++;
        }
      }

      navigateToNextPage();
      changeItemLink = 1;
      var bicyclesCount =
       getElementsMatchingToLocator(this.pageObjectOfEis.getEisSharedLocatorModel().BICYCLE_AWAY_FROM_HOME_LIST()).size();
      for (int items = 0; items < bicyclesCount; items++) {
        var awayFromHome = new TreeMap<String, Object>();
        var itemsAwayFromHomeBicycles =
                getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().GET_POLICY_INFORMATION_LABEL());
        //Logic
        try {
          for (var fieldName : itemsAwayFromHomeBicycles) {
            switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(fieldName)) {
              case CommonControlDataDefns.BICYCLES_FLAG_VAR ->
                  awayFromHome.put(CommonControlDataDefns.BICYCLES_FLAG,
                      CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().BICYCLE_FLAG(), "")));
              case CommonControlDataDefns.BICYLCE_TYPE_VAR ->
                  awayFromHome.put(CommonControlDataDefns.BICYLCE_TYPE,
                   Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().BICYLCLE_TYPE(), "")));
              case CommonControlDataDefns.BICYCLE_DESCRIPTION ->
                  awayFromHome.put(CommonControlDataDefns.DESCRIPTION,
                   Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().BICYLCLE_DESCRIPTION(), "")));
              case CommonControlDataDefns.VALUE_OF_SPECIFIED_ITEM ->
                  awayFromHome.put(CommonControlDataDefns.VALUE,
                   Double.parseDouble(getTextNotPresetBecomesEmpty(this.pageObjectOfEis.getEisSharedLocatorModel().BICYLCLE_VALUE(), "").replaceAll("[£,]", "")));
            }
          }
        } catch (Exception exception) {
          throw new CustomE2eException(exception.getMessage());
        }
        if (isElementVisible(xpathBuilder(this.pageObjectOfEis.getEisSharedLocatorModel().ITEM_CHANGE_LINK(), String.valueOf(changeItemLink + 1)))) {
          scrollIntoView(xpathBuilder(this.pageObjectOfEis.getEisSharedLocatorModel().ITEM_CHANGE_LINK(), String.valueOf(changeItemLink + 1)));
          clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisSharedLocatorModel().ITEM_CHANGE_LINK(), String.valueOf(changeItemLink + 1)), SyncType.CLICKABLE);
          changeItemLink++;
        }
        awayHomeItems.add(awayFromHome);
      }
      specifiedItemsDetails.put(CommonControlDataDefns.ITEMS_AWAY_FROM_HOME, awayHomeItems);
      specifiedItemsDetails.put(CommonControlDataDefns.AWAY_FROM_HOME_COUNT, awayHomeItems.size());
    }
    return specifiedItemsDetails;
  }

  private String getInsuranceType() throws CustomE2eException {
    var getInsuranceType =
     getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().INSURANCE_TYPES());
    if (getInsuranceType.contains(CommonControlDataDefns.BUILDING_COVER_OPTIONS) && getInsuranceType.contains(CommonControlDataDefns.CONTENT_COVER_OPTIONS)) {
      return CommonControlDataDefns.BUILDING_CONTENT_INSURANCE_TYPE;
    } else if (getInsuranceType.contains(CommonControlDataDefns.BUILDING_COVER_OPTIONS)) {
      return CommonControlDataDefns.BUILDING_VAR;
    } else if (getInsuranceType.contains(CommonControlDataDefns.CONTENT_COVER_OPTIONS)) {
      return CommonControlDataDefns.CONTENTS_VAR;
    }
    return null;
  }

//  public boolean getPersonalValuablesAwayFromHome() throws CustomE2eException {
//    return CommonHelper.convertStringIntoBoolean(getText(this.pageObjectOfEis.getEisSharedLocatorModel().SPECIFY_ITEMS_AWAY_FROM_HOME()));
//  }
//
//  public String getCoverType() throws CustomE2eException {
//    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().GET_COVER_TYPE(), "Cover type "
//        + "not available");
//  }
//
//  public String getCoverStartDate() throws CustomE2eException {
//    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().COVER_START_DATE(),
//"Cover " + "start date not available");
//  }

  public void clickPolicyNumber() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisSharedLocatorModel().POLICY_NUMBER(),
     SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().POLICY_NUMBER(), SyncType.CLICKABLE);
  }

//  public void clickPolicyTab() throws CustomE2eException {
//    waitForElement2(this.pageObjectOfEis.getEisSharedLocatorModel().POLICY_TAB(),
//     SyncType.CLICKABLE, waitDuration);
//    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().POLICY_TAB(),
//     SyncType.CLICKABLE);
//  }

  public void clickInsuredTab() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisSharedLocatorModel().INSURED_TAB(),
        SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().INSURED_TAB()
    , SyncType.CLICKABLE);
  }

  public void clickRiskAddressTab() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisSharedLocatorModel().RISK_ADDRESS_TAB(),
     SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().RISK_ADDRESS_TAB(), SyncType.CLICKABLE);
  }

//  public void clickClaimsTab() throws CustomE2eException {
//    waitForElement2(this.pageObjectOfEis.getEisSharedLocatorModel().CLAIMS_TAB(),
//    SyncType.CLICKABLE, waitDuration);
//    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().CLAIMS_TAB(),
//     SyncType.CLICKABLE);
//  }
//
//  public void clickInterestedPartiesTab() throws CustomE2eException {
//    waitForElement2(this.pageObjectOfEis.getEisSharedLocatorModel().INTERESTED_PARTIES_TAB(),
//     SyncType.CLICKABLE, waitDuration);
//    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().INTERESTED_PARTIES_TAB(), SyncType.CLICKABLE);
//  }

  public void clickCoverOptionsTab() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisSharedLocatorModel().COVER_OPTIONS_TAB(),
     SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().COVER_OPTIONS_TAB(), SyncType.CLICKABLE);
  }

  public void clickCoverTypesTab() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisSharedLocatorModel().COVER_TYPES_TAB(),
SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().COVER_TYPES_TAB(), SyncType.CLICKABLE);
  }

  public void clickSpecifiedItemsAtHomeTab() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisSharedLocatorModel().SPECIFIED_ITEMS_AT_HOME_TAB()
    , SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().SPECIFIED_ITEMS_AT_HOME_TAB(), SyncType.CLICKABLE);
  }

  public void clickSpecifiedItemsAwayFromHomeTab() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisSharedLocatorModel().SPECIFIED_ITEMS_AWAY_FROM_HOME_TAB(), SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().SPECIFIED_ITEMS_AWAY_FROM_HOME_TAB(), SyncType.CLICKABLE);
  }

  public void clickCoverageAndPremiumTab() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisSharedLocatorModel().PREMIUM_COVERAGES_TAB(),
     SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().PREMIUM_COVERAGES_TAB(), SyncType.CLICKABLE);
  }

  public void clickEndorsementsTab() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisSharedLocatorModel().ENDORSEMENTS_TAB(),
SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().ENDORSEMENTS_TAB(), SyncType.CLICKABLE);
  }

  public String getPolicyStartDate() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().POLICY_START_DATE(),
     "Policy " + "Start Date not available");
  }

  public String getPolicyEndDate() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().POLICY_END_DATE(),
 "Policy " + "End" + " Date not available");
  }

  public String getInsuredTitle() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().INSURED_TITLE(), "Insured " +
        "Salutation not available");
  }

  public String getInsuredFirstName() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().INSURED_FIRSTNAME(), "Insured "
 + "Firstname not available");
  }

  public String getInsuredLastName() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().INSURED_LASTNAME(),
     "Insured " + "surname not available");
  }

  public String getInsuredDOB() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().INSURED_DATE_OF_BIRTH(),
    "Insured date of birth not available");
    // return Formatting.changeDateFormatIntoExpected(dob,  DEFAULT_DATE_FORMAT,"dd MMM yyyy");
  }

  public String getInsuredCorrespondenceAddress() throws CustomE2eException {
       /* String correspondenceAddress;
        var insuredHouseNo = getText(this.pageObjectOfEis.getEisSharedLocatorModel()
        .INSURED_CORRESPONDENCE_ADDRESS_HOUSE_NO(),"Insured correspondence house number not
        available");
        var insuredAddressLine1 = getText(this.pageObjectOfEis.getEisSharedLocatorModel()
        .INSURED_CORRESPONDENCE_ADDRESS_LINE1(),"Insured first line of correspondence address not
         available");
        var insuredAddressLine2 = getText(this.pageObjectOfEis.getEisSharedLocatorModel()
        .INSURED_CORRESPONDENCE_ADDRESS_LINE2(),"Insured second line of correspondence address
        not available");
        var insuredAddressCity = getText(this.pageObjectOfEis.getEisSharedLocatorModel()
        .INSURED_CORRESPONDENCE_ADDRESS_CITY(),"Insured correspondence address city not available");
        var insuredAddressCounty = getText(this.pageObjectOfEis.getEisSharedLocatorModel()
        .INSURED_CORRESPONDENCE_ADDRESS_COUNTY(),"Insured Correspondence address county not
        available");
        var insuredAddressPostcode = getText(this.pageObjectOfEis.getEisSharedLocatorModel()
        .INSURED_CORRESPONDENCE_ADDRESS_POSTCODE(),"Insured correspondence address postcode not
        available");
        correspondenceAddress = insuredHouseNo + ", " + insuredAddressLine1 + ", " +
        insuredAddressLine2 + ", " + insuredAddressCity + ", " + insuredAddressCounty + ", " +
        insuredAddressPostcode;
        return correspondenceAddress;*/
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().CORRESPONDENCE_FULL_ADDRESS(),
     "Insured correspondence address not available");
  }

  public String getInsuredEmail() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().INSURED_EMAIL(), "Insured " +
    "email address not available");
  }

  public String getInsuredEmploymentStatus() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().INSURED_EMPLOYMENT_STATUS(),
    "Insured employment status not available");
  }

  public String getInsuredEmploymentOccupation() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().INSURED_EMPLOYMENT_OCCUPATION(), "Insured employment occupation not available");
  }

  public String getPolicyId() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().POLICY_NUMBER(), "Policy " +
    "number not available");
  }

  public String getInsuredRiskAddress() throws CustomE2eException {
        /*String riskAddress;
        var insuredHouseNo = getText(this.pageObjectOfEis.getEisSharedLocatorModel()
        .INSURED_RISK_ADDRESS_HOUSE_NO(),"Insured risk address house number not available");
        var insuredAddressLine1 = getText(this.pageObjectOfEis.getEisSharedLocatorModel()
        .INSURED_RISK_ADDRESS_LINE1(),"Insured first line of risk address not available");
        var insuredAddressLine2 = getText(this.pageObjectOfEis.getEisSharedLocatorModel()
        .INSURED_RISK_ADDRESS_LINE2(),"Insured second line of risk address not available");
        var insuredAddressCity = getText(this.pageObjectOfEis.getEisSharedLocatorModel()
        .INSURED_ADDRESS_CITY(),"Insured risk address city not available");
        var insuredAddressCounty = getText(this.pageObjectOfEis.getEisSharedLocatorModel()
        .INSURED_ADDRESS_COUNTY(),"Insured risk address county not available");
        var insuredAddressPostcode = getText(this.pageObjectOfEis.getEisSharedLocatorModel()
        .INSURED_ADDRESS_POSTCODE(),"Insured risk address postcode not available");
        riskAddress = insuredHouseNo + ", " + insuredAddressLine1 + ", " + insuredAddressLine2 +
        ", " + insuredAddressCity + ", " + insuredAddressCounty + ", " + insuredAddressPostcode;
        return riskAddress;*/
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().RISK_FULL_ADDRESS(), "Insured "
     + "risk address not available");
  }

  public String getOwnershipStatus() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().OWNERSHIP_TYPE(), "Risk " +
    "address ownership status not available");
  }

  public String getTelephoneNumber() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().INSURED_PHONE_NO(),
 "Insured " + "telephone number not available");
  }

  public String isPropertyExtended() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().INSURED_ADDRESS_EXTENSION(),
 "Property extension status not available");
  }

  public String getAlarmDetails() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().INTRUDER_ALARM_DETAILS(),
 "Intruder alarm details are not available");
  }

  public String getDoorLockDetails() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().DOOR_LOCK_DETAILS(),
"Door " + "lock details are not available");
  }

  public String getNumberOfAdults() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().NUMBER_OF_ADULTS(),
     "Number " + "of" + " adults are not available");
  }

  public String getNumberOfChildren() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().NUMBER_OF_CHILDREN(), "Number "
     + "of children are not available");
  }

  public String getHouseOccupancy() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().HOUSE_OCCUPANCY(), "House " +
    "occupancy not available");
  }

  public String getPayingGuestDetails() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().PAYING_GUEST_DETAILS(),
"Paying guests details not available");
  }

  public String getPetDetails() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().PET_DETAILS(),
     "Pet details " + "are not available");
  }

  public String getBusinessUseDetails() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().BUSINESS_USE(), "Business Use "
     + "are not available");
  }

//  public String getNumberOfBedrooms() throws CustomE2eException {
//    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().NUMBER_OF_BEDROOMS(), "Number "
//+ "of Bedrooms not available");
//  }
//
//  public String getNumberOfBathrooms() throws CustomE2eException {
//    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().NUMBER_OF_BATHROOMS(), "Number"
//     + " of bathrooms not available");
//  }

  public String getBuildingConstruction() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().BUILDING_CONSTRUCTION(),
        "Building construction not available");
  }

  public String getPropertyType() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().PROPERTY_TYPE(),
        "Property " + "type not available");
  }

  public String getConstructionYear() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().CONSTRUCTION_YEAR(),
 "Construction year not available");
  }

  public String getListedBuildingDetails() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().BUILDING_LISTED_DETAILS(),
        "Building listed details not available");
  }

  public String getBuildingAccidentalDamageCover() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().BUILDING_ACCIDENTAL_DAMAGE_COVER(), "Building accidental damage cover not available");
  }

  public String getBuildingCost() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().BUILDING_COST(),
        "Building " + "cost not available");
    //  return getCurrencyValue(cost);
  }

  public String getContentAccidentalDamageCover() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().CONTENT_ACCIDENTAL_DAMAGE_COVER(), "Content Accidental damage cover not available");
  }

  public String getContentInsuranceHeld() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().PREVIOUS_INSURANCE_HELD(),
    "Content Insurance held not available");
  }

  public String getContentSumInsured() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().CONTENT_SUM_INSURED(),
    "Content Sum Insured not available");
    //  return getCurrencyValue(sumInsured);
  }

  public String getMaxLimitAmount() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().MAX_LIMIT_AMOUNT(),
"Limit " + "amount not available");
    //  return getCurrencyValue(sumInsured);
  }

  public String getCurrencyValue(String amount) {
    DecimalFormat formatter = new DecimalFormat("#,###");
    return String.format("£%s", formatter.format(amount));
  }

  public String getIndividualItemCover() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().INDIVIDUAL_ITEM_COVER(),
    "Individual item cover not available");
  }

  public String getPersonalisedItemAwayFromHome() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().PERSONALISED_ITEMS_AWAY_FROM_HOME(), "Personalised item away from home not available");
  }

  public String getPersonalisedItemsAwayFromHomeCost() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().PERSONALISED_ITEMS_AWAY_FROM_HOME_COST(), "Personalised item away from home cost not available");
    // return getCurrencyValue(cost);
  }

  public String getHouseholdCover() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().HOUSEHOLD_COVER(), "Household "
        + "cover not available");
  }

  public String getBuildingVoluntaryExcess() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().BUILDING_VOLUNTARY_EXCESS(),
        "Building voluntary excess not available");
  }

  public String getContentVoluntaryExcess() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().CONTENT_VOLUNTARY_EXCESS(),
    "Content voluntary excess not available");
  }

  public String getJPHDateOfBirth() throws CustomE2eException {
    return getAttribute(this.pageObjectOfEis.getEisSharedLocatorModel().JPH_DATE_OF_BIRTH(),
    "value", "Date of Birth not found");
  }

  public void selectNameInsuredDropdown() throws CustomE2eException {
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().NAME_INSURED_DROPDOWN_SELECTOR(), SyncType.CLICKABLE);
  }

  public void selectJointPolicyholder() throws CustomE2eException {
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().SELECT_JOINT_POLICYHOLDER(), SyncType.CLICKABLE);
  }

  public void selectNameInsured() throws CustomE2eException {
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisSharedLocatorModel().SELECT_NAMED_INSURED(), SyncType.CLICKABLE);
  }

//  public int getListOfNamedInsured() {
//    return driver.findElements().size();
//  }

  public int getListOfPolicies() {
    return driver.findElements(this.pageObjectOfEis.getEisSharedLocatorModel().LIST_POLICY_IN_TABLE()).size();
  }

  public String getJPHEmploymentStatus() throws CustomE2eException {
    return Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getText(this.pageObjectOfEis.getEisSharedLocatorModel().JPH_EMPLOYMENT_STATUS(), "JPH " + "Employment status not available"));
  }


  public String getJPHEmploymentIndustry() throws CustomE2eException {
    return Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getText(this.pageObjectOfEis.getEisSharedLocatorModel().JPH_EMPLOYMENT_INDUSTRY(), "JPH Employment industry not available"));
  }


  public void navigateToNextPageAlt() throws CustomE2eException {

    clickElement(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().NEXT_PAGE(),
            SyncType.CLICKABLE);

  }

  public void navigateToNextPage() throws CustomE2eException {

    if (Boolean.valueOf(Utils.getProperty("SKIP_DEEP_SYNC_MEASURES", "false"))) {
      navigateToNextPageAlt();
    } else {

      waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().NEXT_PAGE(),
              SyncType.CLICKABLE, waitDuration);

      waitForElement(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().NEXT_PAGE(),
              SyncType.CLICKABLE);


      clickElement(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().NEXT_PAGE(),
              SyncType.CLICKABLE);


      RetryOnStaleElementException(15,
              () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().NEXT_PAGE(), SyncType.CLICKABLE), "");


      if (isElementVisible(this.pageObjectOfEis.getEisSharedLocatorModel().MISSING_FIELD_INFO_ERROR_MESSAGE())) {
        var getErrorMessages =
                getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().MISSING_FIELD_INFO_ERROR_MESSAGE());
        var countOfErrorMessage = getErrorMessages.size();
        if (countOfErrorMessage == 1) {
          throw new CustomE2eException(getErrorMessages.get(0));
        } else {
          throw new CustomE2eException("Multiple fields information are missing.");
        }

      }

    }

  }

  public void saveQuote() throws CustomE2eException {

    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SAVE_QUOTE(),
     SyncType.CLICKABLE, waitDuration);

    RetryOnStaleElementException(15,
            () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SAVE_QUOTE(), SyncType.CLICKABLE), ""
    );

    if (isElementVisible(this.pageObjectOfEis.getEisSharedLocatorModel().MISSING_FIELD_INFO_ERROR_MESSAGE())) {
      var getErrorMessages =
              getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisSharedLocatorModel().MISSING_FIELD_INFO_ERROR_MESSAGE());
      var countOfErrorMessage = getErrorMessages.size();
      if (countOfErrorMessage == 1) {
        throw new CustomE2eException(getErrorMessages.get(0));
      } else {
        throw new CustomE2eException("Multiple fields information are missing.");
      }
    }
  }

  public String getJPHFirstname() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().JPH_FIRSTNAME(), "JPH " +
    "firstname not available");
  }


  public String getJPHLastname() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().JPH_LASTNAME(),
     "JPH surname " + "not available");
  }

  public String getJPHMaritalStatus() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().JPH_MARITAL_STATUS(),
     "JPH " + "marital status not available");
  }

  public String getJPHOccupation() throws CustomE2eException {
    return Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getText(this.pageObjectOfEis.getEisSharedLocatorModel().JPH_OCCUPATION(), "JPH " + "occupation not available"));
  }

  public String getJPHRelationshipToProposer() throws CustomE2eException {
    return Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getText(this.pageObjectOfEis.getEisSharedLocatorModel().JPH_RELATIONSHIP_TO_PROPOSER(), "JPH relationship to proposer not available"));
  }

  public String getJphSecondEmploymentFlag() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().SECOND_EMPLOYMENT_FLAG(), "JPH"
    + " " + "secondary job not available");
  }

  public String getJphSecondEmploymentOccupation() throws CustomE2eException {
    return Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getText(this.pageObjectOfEis.getEisSharedLocatorModel().SECOND_EMPLOYMENT_OCCUPATION(), "JPH " + "secondary job not available"));
  }

  public String getJphSecondEmploymentIndustry() throws CustomE2eException {
    return Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getText(this.pageObjectOfEis.getEisSharedLocatorModel().SECOND_EMPLOYMENT_INDUSTRY(), "JPH " + "secondary job not available"));
  }

  public String getJphSecondEmploymentStatus() throws CustomE2eException {
    return Formatting.capitalizeAllFirstCapitalizeRemoveSpace(getText(this.pageObjectOfEis.getEisSharedLocatorModel().SECOND_EMPLOYMENT_STATUS(), "JPH " + "secondary job not available"));
  }

  public String getJPHTitle() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisSharedLocatorModel().JPH_TITLE(),
     "JPH title not " + "available");
  }

}

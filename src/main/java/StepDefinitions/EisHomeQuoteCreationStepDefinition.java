package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import PageObjects.EisModel.Root;
import activities.CommonControlDataDefns;
import helpers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class EisHomeQuoteCreationStepDefinition extends CdlEisHelpers {

  EisGeneralStepDefinitions eisGeneralStepDefinitions;
  private final helpers.CommonHelper CommonHelper;

  //public static final String PROPOSER_PERSONAL_DETAILS = "ProposerPersonalDetails";
  //public static final String PROPOSER_CONTACT_DETAILS = "ProposerContactDetails";
  public static final String PREF_DELIVERY_METHOD = "PreferredDeliveryMethod";
  //public static final String JOINT_POLICY_HOLDER_STATUS = "JointPolicyHolderStatus";
//  public static final String JOINT_POLICY_HOLDER_DET = "JointPolicyHolderDetails";
  public static final String PROPERTY_LEFT_UNOCCUPIED = "NumberOfDaysPropertyLeftUnoccupied";
  public static final String SECURITY = "Security";
  //public static final String USAGE = "Usage";
  /*public static final String OTHER_DETAILS = "OtherDetails";
  public static final String SUFFERED_LOSS_NOT_RESULTED_CLAIM = "SufferedLossNotResultedInClaim";*/
  public static final String PERCENTAGE_FLAT_ROOF = "PercentageOfFlatRoof";
  public static final String WALL_CONSTRUCTION ="WallConstructionType";
  public static final String ROOF_CONSTRUCTION ="RoofConstructionType";

  //public static final String DYNAMIC_UNDERWRITER_QUESTIONS = "DynamicUnderwriterQuestions";
  /*public static final String INSURANCE_DETAILS = "InsuranceDetails";
  public static final String TYPE_OF_HOUSE_HOLDE_COVER = "TypeOfHouseHoldCover";*/

  //public static final String BUILDING_DETAILS = "BuildingDetails";

  public static final String PRODUCT_TYPE_VAR = "ProductType";
  public static final String AFFINITY_VAR = "Affinity";
  public static final String UNSATISFIED_COUNTRY_COURT_JUDGEMENTS_VAR =
      "UnsatisfiedCountyCourtJudgements";

  public static final String RESID_DECLARED_BANKRUPT_VAR = "ResidentDeclaredBankrupt";
  /*public static final String BUILDING_VAR = "Buildings";
  public static final String CONTENTS_VAR = "Contents";*/
  public static final String PROD_TYPE_HOME_DD_VAL_VAR = "Home (Preconfigured)";
  /*public static final String PRIMARY_EMPLOYMENT_STATUS_VAR = "PrimaryEmploymentStatus";
  public static final String PRIMARY_EMPLOYMENT_TYPE_VAR = "Type";*/
  public static final String BRAND_VAR = "Brand";
  public static final String PRIMARY_JOB_OCCUPATION_VAR = "SecondaryJobOccupation";
  public static final String PRIMARY_JOB_INDUSTRY_VAR = "Industry";
  //public static final String SECOND_EMPLOYMENT_STATUS_VAR = "SecondaryEmploymentStatus";
  public static final String SECOND_JOB_OCCUPATION_VAR = "SecondaryJobOccupation";
  public static final String SECOND_JOB_INDUSTRY_VAR = "SecondaryJobIndustry";
  //public static final String PAYMENT_STATUS_VAR = "PaymentType";
  //public static final String PREV_INSURANCE_VAR = "PreviousInsurance";
  public static final String UNSPENT_CRIMINAL_CONV_VAR = "UnspentCriminalConviction";
  public static final String INSURANCE_PREV_REFUSED_VAR = "InsurancePreviouslyRefused";
  //public static final String INSURANCE_HISTORY_VAR = "InsuranceHistory";
  //public static final String CATEGORY_VAR = "Category";
  //public static final String PRIM_JOB_CATEGORY_EMPLOYEE_VAR = "Employee";
  //public static final String JOB_CATEGORY_EMPLOYED_VAR = "Employed";
  public static final String PRIM_JOB_CATEGORY_EDUCATION_VAR = "Education";
  public static final String PRIM_JOB_CATEGORY_FULL_PART_TIME_EDUCATION_VAR =
      "In Full Or Part Time Education";


  public static final String BUILDING_DET_VAR = "BuildingDetails";
  public static final String ADDITIONAL_INFORMATION_VAR = "AdditionalInformation";
  public static final String ADDRESS_VAR = "Address";
  /*public static final String BATHROOM_NUM_VAR = "NumberOfBathroom";
  public static final String BEDROOM_NUM_VAR = "NumberOfBedrooms";
  public static final String YEAR_BUILT_VAR = "YearBuilt";*/
  public static final String GOOD_REPAIR_STATUS_VAR = "GoodRepairStatus";
  public static final String USAGE_VAR = "Usage";
  public static final String EXTENDED_HOUSE_VAR = "ExtendedHouse";
  public static final String BUILDING_WORK_STATUS_VAR = "BuildingWorkStatus";
  public static final String LET_SUBLET_VAR = "LetWithSublet";
  //public static final String PROPERTY_OWNED_VAR = "PropertyOwned";
  public static final String OWNED_DD_VAL_VAR = "Owned";
  public static final String PROPERTY_OWNED_OUTRIGHT_VAR = "Owned Outright";
  public static final String PROPERTY_TYPE_COUNCIL_VAR = "Council";
  //public static final String OCCUPANCY_VAR = "Occupancy";
  public static final String LODGER_TYPE = "LodgersType";
  public static final String BUSINESS_USAGE_VAR="BusinessUsage";
  public static final String BUSINESS_USE_VAR = "BusinessUse";
  public static final String CLERICAL_USE_VAR ="ClericalUse";
  public static final String PROPERTY_USE_VAR = "PropertyUse";
  public static final String HOLIDAY_HOME_STATUS = "HolidayHomeStatus";
  public static final String NEIGHBOUR_HOOD_WATCH_VAR = "NeighbourhoodWatch";
  public static final String ALARMS_VAR = "Alarms";
  //public static final String BASIC_ALARMS_VAR = "Basic DIY Alarm";
  public static final String NSI_NACOSS_SSAIB_ALARMS_VAR = "NSI NACOSS/SSAIB";
  public static final String NO_ALARMS_VAR = "No Alarm";
  public static final String OTHER_ALARMS_VAR = "Other";
  public static final String LOCKS_VAR = "Locks";
  //public static final String NUM_PEOPLE_LIVE = "NumberOfPeopleLive";
  /*public static final String NON_FAMILY_LODGER_VAR = "NonFamilyLodger";
  public static final String ADULT_VAR = "Adult";
  public static final String CHILDREN_VAR = "Children";
  public static final String PET_VAR = "Pet";
  public static final String CAT_VAR = "Cat";
  public static final String DOG_VAR = "Dog";*/
  //public static final String OTHER_VAR = "Other";
//  public static final String BUILDING_TYPE_VAR = "BuildingType";
  public static final String STRUCTURE_TYPE_VAR = "StructureType";
  //public static final String FREE_FLOODING_THREAT_VAR = "FreeFromFloodingThreats";
  public static final String CONSTRUCTION_TYPE_VAR = "ConstructionType";
  public static final String GEOLOGICAL_THREAT_VAR = "GeologicalThreats";
  //public static final String LISTING_STATUS_VAR = "ListingStatus";
  //public static final String CONST_TYPE_STANDARD_VAR = "Standard";
  /*public static final String CONST_TYPE_DETACHED_VAR = "Detached";
  public static final String CONST_TYPE_DETACHED_HOUSE_VAR = "Detached House";
  public static final String BUILDING_TYPE_HOUSE_VAR = "House";
  public static final String CONST_TYPE_TERRACED_VAR = "Terraced";
  public static final String BUILDING_SUB_TYPE_END_TERRACED_HOUSE_VAR = "End Terraced House";
  public static final String CONST_TYPE_SEMI_DETACHED_VAR = "Semi-Detached";
  public static final String BUILDING_SUB_TYPE_SEMI_DETACHED_HOUSE_VAR = "Semi-Detached House";
  public static final String CONST_TYPE_DETACHED_BUNGALOW_VAR = "Detached Bungalow";
  public static final String BUILDING_TYPE_BUNGLOW_VAR = "Bungalow";
  public static final String BUILDING_SUB_TYPE_SEMI_DETACHED_BUNGLOW_VAR = "Semi Detached Bungalow";
  public static final String BUILDING_SUB_TYPE_SEMI_DETACHED_BUNGLOW_DD_VAL_VAR = "Semi-Detached "
      + "Bungalow";*/
  public static final String CONST_TYPE_BASEMENT_FLAT_VAR = "Basement Flat";
  public static final String BUILDING_TYPE_SELF_CONTAINED_FLAT_VAR = "Self-contained Flat";
  public static final String TYPE_OF_HOUSEHOLD_COVER_VAR = "TypeOfHouseHoldCover";
  public static final String RISK_ADDRESS_VAR = "RiskAddress";
  public static final String BUILDING_ADDRESS_VAR = "BuildingAddress";

  public static final String REBUILDING_COST_VAR = "RebuildingCost";
  public static final String BUILDING_VOL_EXCESS_VAR = "BuildingVoluntaryExcess";
  public static final String BUILDING_CLAIM_FREE_YEAR_VAR = "BuildingClaimFreeYears";
  /*public static final String CONTENT_ACCIDENTAL_DAMAGE_VAR = "ContentAccidentalDamage";
  public static final String CONTENT_SUM_VAR = "ContentSum";
  public static final String CONTENT_CLAIM_FREE_YEARS_VAR = "ContentClaimFreeYears";*/
  public static final String CONTENT_VOL_EXCESS_VAR = "ContentVoluntaryExcess";
  //public static final String CONTENT_DETAILS_VAR = "ContentDetails";
  public static final String SPECIFIED_ITEMS = "SpecifiedItems";
  public static final String SAFE_VAR = "Safe";
  public static final String UNSPECIFIED_ITEMS_VAR = "UnspecifiedItems";
  public static final String COVER_STATUS_VAR = "CoverStatus";
  public static final String ITEM_AMOUNT = "ItemAmount";
  public static final String SPECIFIED_ITEM = "Item";
  public static final String SPECIFIED_DESC = "Description";
  public static final String SPECIFIED_VALUE = "Value";
  public static final String BICYCLE = "Bicycle";


  public static final String AWAY_HOME = "AwayHome";
  public static final String IN_HOME = "InHome";
  //public static final String SPECIFIED_ITEM_FLAG = "SpecifiedItemsAvailable";
  public static final String MONTHLY_DIRECT_DEBIT = "Monthly (Direct Debit)";
  CommonControlDataDefns commonControlDataDef = new CommonControlDataDefns();

  public EisHomeQuoteCreationStepDefinition(WebDriver pDriver, Root pageObjectOfEis) {
    super(pDriver, pageObjectOfEis);
    eisGeneralStepDefinitions = new EisGeneralStepDefinitions(pDriver, pageObjectOfEis);
    this.CommonHelper = new CommonHelper(pDriver);
  }



  public void homeQuoteCreation(Map<String, Object> salesDetails) throws CustomE2eException {
    var quotesDetails =
        (Map<String, Object>) salesDetails.get(commonControlDataDef.QUOTE_DETAILS);
    var insuranceDetails =
        (Map<String, Object>) salesDetails.get(commonControlDataDef.INSURANCE_DETAILS);
    var dynamicUnderwriterQuestions =
        (Map<String, Object>) salesDetails.get(commonControlDataDef.DYNAMIC_UNDERWRITER_QUESTIONS);

    var buildingDetails =
        (Map<String, Object>) insuranceDetails.get(commonControlDataDef.BUILDING_DETAILS);

    enterPolicyBasicInformation((Map<String, Object>) insuranceDetails.get(commonControlDataDef.TYPE_OF_HOUSEHOLD_COVER), quotesDetails, dynamicUnderwriterQuestions);
    eisGeneralStepDefinitions.navigateToNextPage();
    enterInsuredDetails(dynamicUnderwriterQuestions,
        (Map<String, Object>) salesDetails.get(commonControlDataDef.PROPOSER_PERSONAL_DETAILS), insuranceDetails,
        (String) salesDetails.get(PREF_DELIVERY_METHOD));
    var jointPolicyholderDet =
        CommonHelper.convertStringIntoBoolean(salesDetails.get(commonControlDataDef.JOINT_POLICY_HOLDER_STATUS));
    if (jointPolicyholderDet) {
      enterJointPolicyDetails((Map<String, Object>) salesDetails.get(commonControlDataDef.JOINT_POLICY_HOLDER_DET));
    }
    eisGeneralStepDefinitions.navigateToNextPage();

    enterRiskAddressDetails(insuranceDetails, dynamicUnderwriterQuestions
        , (Map<String, Object>) salesDetails.get(commonControlDataDef.PROPOSER_CONTACT_DETAILS));


    locationUse((Integer) dynamicUnderwriterQuestions.get(PROPERTY_LEFT_UNOCCUPIED), (Map<String, Object>) insuranceDetails.get(commonControlDataDef.USAGE));
    homeSecurity((Map<String, Object>) insuranceDetails.get(SECURITY));
    occupants((Map<String, Object>) insuranceDetails.get(commonControlDataDef.USAGE),
        dynamicUnderwriterQuestions);
    buildingInformation(buildingDetails,dynamicUnderwriterQuestions);

    eisGeneralStepDefinitions.navigateToNextPage();
    sufferedLossNotResultedInClaim((Boolean) ((Map<String, Object>) salesDetails.get(commonControlDataDef.OTHER_DETAILS)).get(commonControlDataDef.SUFFERED_LOSS_NOT_RESULTED_CLAIM));
    if (Boolean.parseBoolean(String.valueOf(salesDetails.get(commonControlDataDef.CLAIM_HIST_FLAG)))) {
      enterClaimDetails(salesDetails);
    }
    eisGeneralStepDefinitions.navigateToNextPage();
    interestedParties();
    eisGeneralStepDefinitions.navigateToNextPage();
    coverDetails(insuranceDetails);
    calculatePremium();
    if (((Map<String, Object>) insuranceDetails.get(commonControlDataDef.TYPE_OF_HOUSEHOLD_COVER)).get(commonControlDataDef.OPTIONAL_EXTRAS) != null) {
      addOptionalExtras((String) ((Map<String, Object>) insuranceDetails.get(commonControlDataDef.TYPE_OF_HOUSEHOLD_COVER)).get(commonControlDataDef.OPTIONAL_EXTRAS));
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().OPEX_OK_BUTTON(),
          SyncType.CLICKABLE);
    }
    consentToRenew(CommonHelper.convertStringIntoBoolean(salesDetails.get(commonControlDataDef.CONSENT_TO_RENEW)));
    waitForPageLoad();
    eisGeneralStepDefinitions.navigateToNextPage();

    //Home endorsement
    if (salesDetails.get(commonControlDataDef.ENDORSEMENT) != null) {
      addEndorsement((String) salesDetails.get(CommonControlDataDefns.ENDORSEMENT));
    }
  }


  public void clickOnAddNewQuote() throws CustomE2eException {
    refreshPage();
    waitForPageLoad();
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ADD_NEW_QUOTE(),
        SyncType.VISIBLE, eisGeneralStepDefinitions.waitDuration);
    RetryOnStaleElementException(5,
        () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ADD_NEW_QUOTE()
            , SyncType.VISIBLE), "Add new quote.");
  }


  public void enterPolicyBasicInformation(Map<String, Object> typeOfHouseHoldeCover, Map<String,
      Object> quoteDet, Map<String, Object> dynamicUnderwriterQuestions) throws CustomE2eException {

    selectProduct(quoteDet.get(PRODUCT_TYPE_VAR));
    //Disabled this field after release 17. Delete this line of code after confirmation with team
//    if (isElementEnabled(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BRAND_PAGE())) {
//      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BRAND_PAGE(),
//          quoteDet.get(BRAND_VAR), SelectOptions.TEXT);
//    }
    //Product Type - Home
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().INSURANCE_TYPE(),
        quoteDet.get(PRODUCT_TYPE_VAR), SelectOptions.TEXT);
    //Type of Household Cover Required - Building and Cover
    selectTypeOfHouseholdCover(typeOfHouseHoldeCover);
    //Affinity Code - AHCC
    selectAffinity((String) quoteDet.get(AFFINITY_VAR));
    //Has any resident had any unsatisfied County Court Judgements?
//    scrollElementIntoCenterOfScreen(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().UNSATISFIED_COUNTY_COURT_JUDGEMENTS(), this.CommonHelper.convertBooleanIntoString((Boolean) dynamicUnderwriterQuestions.get(UNSATISFIED_COUNTRY_COURT_JUDGEMENTS_VAR))));
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().UNSATISFIED_COUNTY_COURT_JUDGEMENTS(), this.CommonHelper.convertBooleanIntoString((Boolean) dynamicUnderwriterQuestions.get(UNSATISFIED_COUNTRY_COURT_JUDGEMENTS_VAR))), SyncType.CLICKABLE);
//    scrollElementIntoCenterOfScreen(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().DECLARED_BANKRUPT_YES_NO(), this.CommonHelper.convertBooleanIntoString((Boolean) dynamicUnderwriterQuestions.get(RESID_DECLARED_BANKRUPT_VAR))));
    //Has any resident been declared bankrupt?
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().DECLARED_BANKRUPT_YES_NO(), this.CommonHelper.convertBooleanIntoString((Boolean) dynamicUnderwriterQuestions.get(RESID_DECLARED_BANKRUPT_VAR))), SyncType.CLICKABLE);
  }

  //Common between Echelon and EIS
  private void selectAffinity(String affinity) throws CustomE2eException {
    var value =
        getMatchingValueStartWithFromDropDown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().AFFINITY_CODE(), affinity);
//    RetryOnException("Select affinity", CustomE2eException.class, 500L, 50,
//        () -> selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().AFFINITY_CODE(), value, SelectOptions.TEXT));
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().AFFINITY_CODE(), value, SelectOptions.TEXT);
  }

  //Common between Echelon and EIS
  public void selectTypeOfHouseholdCover(Map<String, Object> typeOfHouseHoldCover) throws CustomE2eException {
    scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().TYPE_HOUSEHOLD_INSURANCE());

    Boolean buildingCover =
        CommonHelper.convertStringIntoBoolean(typeOfHouseHoldCover.get(commonControlDataDef.BUILDING_VAR));
    Boolean contentCover =
        CommonHelper.convertStringIntoBoolean(typeOfHouseHoldCover.get(commonControlDataDef.CONTENTS_VAR));

//    if (buidlingCoverObj instanceof String) {
//      buildingCover = Boolean.parseBoolean((String) buidlingCoverObj);
//    } else {
//      buildingCover = (Boolean) buidlingCoverObj;
//    }

//    if (contentCoverObj instanceof String) {
//      contentCover = Boolean.parseBoolean((String) contentCoverObj);
//    } else {
//      contentCover = (Boolean) contentCoverObj;
//    }

    if (buildingCover.equals(true) && contentCover.equals(true)) {
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().TYPE_HOUSEHOLD_INSURANCE(), 3, SelectOptions.INDEX);
    } else if (buildingCover.equals(true)) {
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().TYPE_HOUSEHOLD_INSURANCE(), 1, SelectOptions.INDEX);
    } else if (contentCover.equals(true)) {
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().TYPE_HOUSEHOLD_INSURANCE(), 2, SelectOptions.INDEX);
    }
  }

  //Common between Echelon and EIS
  public String getMatchingValueStartWithFromDropDown(By byLocator, String value) throws CustomE2eException {
    String matchingVal = null;
    var options = getAllValuesFromDropDown(byLocator, "selectDropdown failed");
    for (var currVal : options) {
      if (currVal.getText().toLowerCase().startsWith(value.toLowerCase())) {
        matchingVal = currVal.getText();
        break;
      }
    }
    return matchingVal;
  }

  public String getMatchingValueEndsWithFromDropDown(By byLocator, String value) throws CustomE2eException {
    String matchingVal = null;
    var options = getAllValuesFromDropDown(byLocator, "selectDropdown failed");
    for (var currVal : options) {
      if (currVal.getText().toLowerCase().endsWith(value.toLowerCase())) {
        matchingVal = currVal.getText();
        break;
      }
    }
    return matchingVal;
  }

  public void selectProduct(Object productType) throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PRODUCT_TYPE(),
        SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    String prodType;
    if (((String) productType).equalsIgnoreCase(commonControlDataDef.PROD_TYPE_HOME_VAR)) {
      prodType = PROD_TYPE_HOME_DD_VAL_VAR;
    } else {
      prodType = commonControlDataDef.PROD_TYPE_MOTOR_VAR;
    }
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PRODUCT_TYPE(),
        prodType, SelectOptions.TEXT);
    RetryOnStaleElementException(5,
        () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().NEXT_BUTTON(),
            SyncType.CLICKABLE), "Navigate to next page.");
  }


  public void enterJointPolicyDetails(Map<String, Object> jointPolicyDet) throws CustomE2eException {
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_ADD_JOINT_POLICY_HOLDER_BUTTON(), SyncType.CLICKABLE);
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_RELATIIONSHIP_TO_PROPOSER(), Formatting.addSpacesAfterCapital((String) jointPolicyDet.get("RelationshipWithPolicyholder")), SelectOptions.TEXT);
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_TITLE(),
        jointPolicyDet.get("Title"), SelectOptions.TEXT);
    typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_FIRST_NAME(),
        jointPolicyDet.get("FirstName"), SyncType.CLICKABLE);
//    scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_LAST_NAME());
//    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_LAST_NAME(),
//        SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_LAST_NAME(),
        SyncType.CLICKABLE);
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_LAST_NAME(),
        SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_LAST_NAME(),
        jointPolicyDet.get("LastName"), SyncType.CLICKABLE);
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_DATE_OF_BIRTH(),
        SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_DATE_OF_BIRTH(),
        SyncType.CLICKABLE);
    scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_DATE_OF_BIRTH());
    typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_DATE_OF_BIRTH(),
        jointPolicyDet.get("DateOfBirth"), SyncType.CLICKABLE);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_RESIDENCE_IN_UK(),
        SyncType.CLICKABLE);
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_RESIDENCE_IN_UK(),
        SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_RESIDENCE_IN_UK(),
        jointPolicyDet.get("UkResidentSince"), SyncType.CLICKABLE);
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_GENDER(),
        Formatting.addSpacesAfterCapital((String) jointPolicyDet.get("Gender")),
        SelectOptions.TEXT);
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_MARITAL_STATUS(),
        SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_MARITAL_STATUS(),
        Formatting.addSpacesAfterCapital((String) jointPolicyDet.get("MaritalStatus")),
        SelectOptions.TEXT);
    scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().FULLTIME_OCCUPATION());
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().FULLTIME_OCCUPATION(),
        (String) ((Map<String, Object>) jointPolicyDet.get("PrimaryEmploymentStatus")).get("Type"), SelectOptions.TEXT);
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().EMPLOYMENT_STATUS(),
        (String) ((Map<String, Object>) jointPolicyDet.get("PrimaryEmploymentStatus")).get(
            "Category"), SelectOptions.TEXT);
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_EMPLOYER_BUSINESS()
        , (String) ((Map<String, Object>) jointPolicyDet.get("PrimaryEmploymentStatus")).get(
            "Industry"), SelectOptions.TEXT);
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_SECONDARY_JOB(), this.CommonHelper.convertBooleanIntoString((Boolean) ((Map<String, Object>) jointPolicyDet.get("SecondaryEmploymentStatus")).get("Employed"))), SyncType.CLICKABLE);
    waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_UNSPENT_CRIMINAL_CONVITIONS(), this.CommonHelper.convertBooleanIntoString((Boolean) (jointPolicyDet.get("NonRtaConvictions")))), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_UNSPENT_CRIMINAL_CONVITIONS(), this.CommonHelper.convertBooleanIntoString((Boolean) (jointPolicyDet.get("NonRtaConvictions")))), SyncType.CLICKABLE);
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().JPH_INSURANCE_REFUSED(), this.CommonHelper.convertBooleanIntoString((Boolean) (((Map<String, Object>) jointPolicyDet.get("InsuranceHistory")).get("InsurancePreviouslyRefused")))), SyncType.CLICKABLE);
  }


  public void enterInsuredDetails(Map<String, Object> dynamicsQuestion,
                                  Map<String, Object> proposerPersonalDetails, Map<String,
      Object> insuranceDetails, String preferredDeliveryMethod) throws CustomE2eException {

    enterPrimaryJobDetails(((Map<String, Object>) (proposerPersonalDetails).get(commonControlDataDef.PRIMARY_EMPLOYMENT_STATUS_VAR)));
    //Secondary job?
    enterSecondaryJobDetails(((Map<String, Object>) (proposerPersonalDetails).get(commonControlDataDef.SECOND_EMPLOYMENT_STATUS_VAR)));
    //Preferred Delivery
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PREFERRED_DELIVERY(),
        preferredDeliveryMethod, SelectOptions.TEXT);
    //Preferred Payment Method
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PREFERRED_PAYMENT_METHOD(), getMatchingValueStartWithFromDropDown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PREFERRED_PAYMENT_METHOD(), (String) dynamicsQuestion.get(commonControlDataDef.PAYMENT_STATUS_VAR)), SelectOptions.TEXT);
//    scrollElementIntoCenterOfScreen(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().UNSPENT_CRIMINAL_CONVICTIONS_YES_NO(), this.CommonHelper.convertBooleanIntoString((Boolean) dynamicsQuestion.get(UNSPENT_CRIMINAL_CONV_VAR))));
    //Unspent Criminal Convictions
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().UNSPENT_CRIMINAL_CONVICTIONS_YES_NO(), this.CommonHelper.convertBooleanIntoString((Boolean) dynamicsQuestion.get(UNSPENT_CRIMINAL_CONV_VAR))), SyncType.CLICKABLE);
    //Insurance refused?
    var insuranceRefusedVar =
        ((Map<String, Object>) insuranceDetails.get(commonControlDataDef.INSURANCE_HISTORY_VAR)).get(INSURANCE_PREV_REFUSED_VAR);
    var insuranceRefused = CommonHelper.convertStringIntoBoolean(insuranceRefusedVar);
//    if (insuranceRefusedVar instanceof String) {
//      insuranceRefused = Boolean.parseBoolean((String) insuranceRefusedVar);
//    } else {
//      insuranceRefused = (Boolean) insuranceRefusedVar;
//    }
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().INSURANCE_REFUSED(), this.CommonHelper.convertBooleanIntoString(insuranceRefused)), SyncType.CLICKABLE);
    //Previous Insurance?
    selectPreviousInsuranceDetails((Boolean) ((Map<String, Object>) insuranceDetails.get(commonControlDataDef.INSURANCE_HISTORY_VAR)).get(commonControlDataDef.PREV_INSURANCE_VAR));
  }

  public void selectPreviousInsuranceDetails(Boolean previousInsurance) throws CustomE2eException {
    scrollElementIntoCenterOfScreen(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PREVIOUS_INSURANCE(), this.CommonHelper.convertBooleanIntoString(previousInsurance)));
    RetryOnClickInterceptedException(10,
        () -> clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PREVIOUS_INSURANCE(), this.CommonHelper.convertBooleanIntoString(previousInsurance)), SyncType.CLICKABLE));
  }


  public void enterPrimaryJobDetails(Map<String, Object> primaryEmploymentStatus) throws CustomE2eException {
    scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().FULLTIME_OCCUPATION());
    String category = (String) primaryEmploymentStatus.get(commonControlDataDef.CATEGORY_VAR);

    var primaryEmploymentType =
        (String) primaryEmploymentStatus.get(commonControlDataDef.PRIMARY_EMPLOYMENT_TYPE_VAR);
    primaryEmploymentType = Formatting.addSpacesAfterCapital(primaryEmploymentType);

    var jobIndustry =
        (String) primaryEmploymentStatus.get(PRIMARY_JOB_INDUSTRY_VAR);
    jobIndustry = Formatting.addSpacesAfterCapital(jobIndustry);

    switch (category) {
      case CommonControlDataDefns.PRIM_JOB_CATEGORY_EMPLOYEE_VAR:
        category = commonControlDataDef.JOB_CATEGORY_EMPLOYED_VAR;
        break;
      case PRIM_JOB_CATEGORY_EDUCATION_VAR:
        category = PRIM_JOB_CATEGORY_FULL_PART_TIME_EDUCATION_VAR;
        break;
      case CommonControlDataDefns.PRIM_JOB_CATEGORY_SELF_EMPLOYEE_VAR:
        category = CommonControlDataDefns.PRIM_JOB_CATEGORY_SELF_EMPLOYED_VAR;
        break;
      default:
        category = CommonControlDataDefns.PRIM_JOB_CATEGORY_UNEMPLOYED_VAR;
    }
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().FULLTIME_OCCUPATION(),
        primaryEmploymentType, SelectOptions.TEXT);
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().EMPLOYMENT_STATUS(),
        category, SelectOptions.TEXT);
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().EMPLOYMENT_INDUSTRY(),
        jobIndustry, SelectOptions.TEXT);
  }

  public void enterSecondaryJobDetails(Map<String, Object> secondaryJobDetails) throws CustomE2eException {
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SECOND_EMPLOYMENT_YES_NO(), this.CommonHelper.convertBooleanIntoString((Boolean) secondaryJobDetails.get(commonControlDataDef.JOB_CATEGORY_EMPLOYED_VAR))), SyncType.CLICKABLE);
    if ((Boolean) secondaryJobDetails.get(commonControlDataDef.JOB_CATEGORY_EMPLOYED_VAR)) {
      //      this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SECOND_EMPLOYMENT_STATUS();
      //      this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SECOND_JOB_OCCUPATION();
      //      this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SECOND_JOB_INDUSTRY();
    }
  }

  public void enterRiskAddressDetails(Map<String, Object> insuranceDetails,
                                      Map<String, Object> dynamicQuestion,
                                      Map<String, Object> proposerContactDetails) throws CustomE2eException {

    var buildingDetails = (Map<String, Object>) insuranceDetails.get(BUILDING_DET_VAR);

    var additionalInformation =
            (Map<String, Object>) buildingDetails.get(ADDITIONAL_INFORMATION_VAR);
    //Risk Location Information
    selectRiskAddress((Map<String, Object>) buildingDetails.get(RISK_ADDRESS_VAR), proposerContactDetails);

    //Residency type
    String residencyTypeTargetText = "PH";
    if((Boolean) ((Map<String, Object>) insuranceDetails.get(USAGE_VAR)).get(HOLIDAY_HOME_STATUS)) {
      residencyTypeTargetText = "HH";
    }
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RESIDENCY_TYPE(),
            residencyTypeTargetText, SelectOptions.VALUE);

    //Number of Bathrooms
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().NUM_BATHROOM(),
        String.valueOf(dynamicQuestion.get(commonControlDataDef.BATHROOM_NUM_VAR)),
        SelectOptions.TEXT);

    //Year Built
    typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().YEAR_BUILT(), ((Map<String,
        Object>) insuranceDetails.get(BUILDING_DET_VAR)).get(commonControlDataDef.YEAR_BUILT_VAR), SyncType.CLICKABLE);

    //Number of bedroom
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().NUM_BEDROOM(),
        String.valueOf(((Map<String, Object>) insuranceDetails.get(BUILDING_DET_VAR)).get(commonControlDataDef.NUM_OF_BEDROOM)), SelectOptions.TEXT);
//    scrollElementIntoCenterOfScreen(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().GOOD_REPAIR(), this.CommonHelper.convertBooleanIntoString((Boolean) additionalInformation.get(GOOD_REPAIR_STATUS_VAR))));

    //In good repair?
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().GOOD_REPAIR(), this.CommonHelper.convertBooleanIntoString((Boolean) additionalInformation.get(GOOD_REPAIR_STATUS_VAR))), SyncType.CLICKABLE);
//    scrollElementIntoCenterOfScreen(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().LET_SUBLET(), this.CommonHelper.convertBooleanIntoString(((Map<String, Object>) insuranceDetails.get(USAGE_VAR)).get(LET_SUBLET_VAR))));

    ///Is the property let/sublet?
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().LET_SUBLET()
        ,
        this.CommonHelper.convertBooleanIntoString((Boolean) ((Map<String, Object>) insuranceDetails.get(USAGE_VAR)).get(LET_SUBLET_VAR))), SyncType.CLICKABLE);

    //Has the property been extended? -
    if (isElementVisible(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().EXTENDED_HOME())) {
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().EXTENDED_HOME(),
          this.CommonHelper.convertBooleanIntoString((Boolean) dynamicQuestion.get(EXTENDED_HOUSE_VAR)), SelectOptions.TEXT);
    }
    selectOwnership((String) dynamicQuestion.get(commonControlDataDef.PROPERTY_OWNED_VAR));

    // Is the property furnished?
//    waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PROPERTY_FURNISHED(), String.valueOf(2)), SyncType.CLICKABLE, eisGeneralStepDefinitions.elementWaitDuration);
    if (isElementVisible(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PROPERTY_FURNISHED(), String.valueOf(2)))) {
      clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PROPERTY_FURNISHED(), String.valueOf(2)), SyncType.CLICKABLE);
    }

    //Any building work?
//    waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BUILDING_WORK(), this.CommonHelper.convertBooleanIntoString((Boolean) additionalInformation.get(BUILDING_WORK_STATUS_VAR))), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BUILDING_WORK(), this.CommonHelper.convertBooleanIntoString((Boolean) additionalInformation.get(BUILDING_WORK_STATUS_VAR))), SyncType.CLICKABLE);
  }

  private void selectOwnership(String ownership) throws CustomE2eException {
    // OwnershipType
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().OWNERSHIP_TYPE(),
        Formatting.addSpacesAfterCapital(ownership), SelectOptions.TEXT);
  }

  public void locationUse(int numberOfDaysPropertyLeftUnoccupied, Map<String, Object> usage) throws CustomE2eException {
    var BusinessUsage = (Map<String, Object>) usage.get(BUSINESS_USAGE_VAR);
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().OCCUPANCY_TYPE(),
        usage.get(commonControlDataDef.OCCUPANCY_VAR), SelectOptions.TEXT);//Occupancy Type -
    // Occupied
    selectDaysOfLeftOccupied(numberOfDaysPropertyLeftUnoccupied);
    var businessUse = String.valueOf(this.CommonHelper.convertBooleanIntoInteger((Boolean) BusinessUsage.get(BUSINESS_USE_VAR)));
    waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BUSINESS_USE(), businessUse), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
//    scrollElementIntoCenterOfScreen(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BUSINESS_USE(), businessUse));
    //Business Use
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BUSINESS_USE(), businessUse), SyncType.CLICKABLE);
    if((Boolean) BusinessUsage.get(BUSINESS_USE_VAR)){
      var clericalUse = String.valueOf(this.CommonHelper.convertBooleanIntoInteger((Boolean) BusinessUsage.get(CLERICAL_USE_VAR)));
        waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CLERICAL_USE(),clericalUse ), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
//        scrollElementIntoCenterOfScreen(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CLERICAL_USE(), clericalUse));
        //Is business use solely clerical with no employees or visitors?
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CLERICAL_USE(), clericalUse), SyncType.CLICKABLE);
        if(!((Boolean) BusinessUsage.get(CLERICAL_USE_VAR))){
          waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PROPERTY_USE(), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
          scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PROPERTY_USE());
          typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PROPERTY_USE(), BusinessUsage.get(PROPERTY_USE_VAR), SyncType.CLICKABLE, true);
        }
    }
  }

  //Common between EIS -Echelon
  private void selectDaysOfLeftOccupied(int numberOfDaysPropertyLeftUnoccupied) throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PROPERTY_LEFT_OCCUPIED(), SyncType.VISIBLE, eisGeneralStepDefinitions.waitDuration);
    if (numberOfDaysPropertyLeftUnoccupied <= 60) {
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PROPERTY_LEFT_OCCUPIED(), 1, SelectOptions.INDEX);
    } else {
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PROPERTY_LEFT_OCCUPIED(), 2, SelectOptions.INDEX);
    }
  }

  public void homeSecurity(Map<String, Object> security) throws CustomE2eException {
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().DOOR_WINDOW_LOCKS(), this.CommonHelper.convertBooleanIntoString((Boolean) security.get(LOCKS_VAR))), SyncType.CLICKABLE);
    //Is an intruder alarm installed?
    selectAlarmDetail((String) security.get(ALARMS_VAR));
    //Neighbourhood Watch
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().NEIGHBOURHOOD_WATCH(), this.CommonHelper.convertBooleanIntoString((Boolean) security.get(NEIGHBOUR_HOOD_WATCH_VAR))), SyncType.CLICKABLE);
  }

  private void selectAlarmDetail(Object alarms) throws CustomE2eException {
    Object alarmType = alarms;
    if (String.valueOf(alarms).equalsIgnoreCase(commonControlDataDef.BASIC_ALARMS_VAR)) {
      alarmType = NSI_NACOSS_SSAIB_ALARMS_VAR;
    } else if (!((Boolean) alarms)) {
      alarmType = NO_ALARMS_VAR;
    } else {
      alarmType = OTHER_ALARMS_VAR;
    }
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ALARM(),
        String.valueOf(alarmType), SelectOptions.TEXT);
  }

  public void occupants(Map<String, Object> usage,
                        Map<String, Object> dynamicUnderwriterQuestions) throws CustomE2eException {

    var numberOfPeopleLives =
        (Map<String, Object>) dynamicUnderwriterQuestions.get(commonControlDataDef.NUM_PEOPLE_LIVE);
    //Non Family Lodgers
    var nonFamilyLodgerValue =
        xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().NON_FAMILY_LODGER(),
            this.CommonHelper.convertBooleanIntoString(usage.get(commonControlDataDef.NON_FAMILY_LODGER)));
    waitForElement2(nonFamilyLodgerValue, SyncType.CLICKABLE,
        eisGeneralStepDefinitions.waitDuration);
//    scrollElementIntoCenterOfScreen(nonFamilyLodgerValue);
    clickElementRetryX3onClickIntEx(nonFamilyLodgerValue, SyncType.CLICKABLE);
//    Type of Occupancy- Lodgers
    if ((Boolean) usage.get(commonControlDataDef.NON_FAMILY_LODGER)) {
      waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().LODGER_OCCUPANCY_TYPE(), SyncType.VISIBLE, eisGeneralStepDefinitions.waitDuration);
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().LODGER_OCCUPANCY_TYPE(), dynamicUnderwriterQuestions.get(LODGER_TYPE), SelectOptions.TEXT);
    }
    //How many adults live in the property?
    if (isElementVisible(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().NUM_ADULTS())) {
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().NUM_ADULTS(),
          String.valueOf(numberOfPeopleLives.get(commonControlDataDef.ADULT_VAR)),
          SelectOptions.TEXT);
    }
    //How many children live in the property?
    if (isElementVisible(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().NUM_CHILD())) {
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().NUM_CHILD(),
          String.valueOf(numberOfPeopleLives.get(commonControlDataDef.CHILDREN_VAR)),
          SelectOptions.TEXT);
    }
    //Do you have a pet living at the property?
    if (isElementVisible(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PET_DETAILS())) {
      petSelection((Map<String, Object>) ((Map<String, Object>) dynamicUnderwriterQuestions.get(commonControlDataDef.NUM_PEOPLE_LIVE)).get(commonControlDataDef.PET_VAR));
    }

  }

  private void petSelection(Map<String, Object> petDetails) throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PET_DETAILS(),
        SyncType.VISIBLE, eisGeneralStepDefinitions.waitDuration);
    boolean cat = (boolean) petDetails.get(commonControlDataDef.CAT_VAR);
    boolean dog = (boolean) petDetails.get(commonControlDataDef.DOG_VAR);
    boolean otherAnimal = (boolean) petDetails.get(commonControlDataDef.OTHER_VAR);
    if (cat && dog) {
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PET_DETAILS(), 3,
          SelectOptions.INDEX);
    } else if (cat) {
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PET_DETAILS(), 2,
          SelectOptions.INDEX);
    } else if (dog) {
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PET_DETAILS(), 4,
          SelectOptions.INDEX);
    } else if (otherAnimal) {
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PET_DETAILS(), 5,
          SelectOptions.INDEX);
    } else {
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PET_DETAILS(), 6,
          SelectOptions.INDEX);
    }
  }

  public void buildingInformation(Map<String, Object> buildingDetails,
                                  Map<String, Object> dynamicUnderwriterQuestions) throws CustomE2eException {
    var percentageOfFlatRoof =
        Integer.parseInt(String.valueOf(dynamicUnderwriterQuestions.get(PERCENTAGE_FLAT_ROOF)));
        var wallConst = (String) dynamicUnderwriterQuestions.get(WALL_CONSTRUCTION);
    var roofConst = (String) dynamicUnderwriterQuestions.get(ROOF_CONSTRUCTION);
    selectBuildingType(buildingDetails); //
    // Need to improve ###
    //Free from flooding?
    waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().FREE_FROM_FLOODING(), this.CommonHelper.convertBooleanIntoString((Boolean) ((Map<String, Object>) buildingDetails.get(ADDITIONAL_INFORMATION_VAR)).get(commonControlDataDef.FREE_FLOODING_THREAT_VAR))), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    RetryOnStaleElementException(5,
        () -> clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().FREE_FROM_FLOODING(), this.CommonHelper.convertBooleanIntoString((Boolean) ((Map<String, Object>) buildingDetails.get(ADDITIONAL_INFORMATION_VAR)).get(commonControlDataDef.FREE_FLOODING_THREAT_VAR))), SyncType.CLICKABLE), "Select free flooding threat.");
    //Is your home built of standard construction?
    selectWallAndRoofType(roofConst, wallConst);

    //Free from subsidence..
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().GEOLOGICAL_STATUS(), this.CommonHelper.convertBooleanIntoString(!(Boolean) ((Map<String, Object>) buildingDetails.get(ADDITIONAL_INFORMATION_VAR)).get(GEOLOGICAL_THREAT_VAR))), SyncType.CLICKABLE);
    //Is your home a listed building?
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().HOME_LISTED(), this.CommonHelper.convertBooleanIntoString((Boolean) ((Map<String, Object>) buildingDetails.get(ADDITIONAL_INFORMATION_VAR)).get(commonControlDataDef.LISTING_STATUS))), SyncType.CLICKABLE);
    selectionOfRoofPercentage(percentageOfFlatRoof);
  }

  private void selectionOfRoofPercentage(int percentageOfFlatRoof) throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PERCENTAGE_FLAT_ROOF()
        , SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    if (percentageOfFlatRoof < 33) {
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PERCENTAGE_FLAT_ROOF(), 1, SelectOptions.INDEX);
    } else if (percentageOfFlatRoof <= 50) {
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PERCENTAGE_FLAT_ROOF(), 2, SelectOptions.INDEX);
    } else {
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PERCENTAGE_FLAT_ROOF(), 3, SelectOptions.INDEX);
    }
  }

  public void InterestedParties() throws CustomE2eException {
  }

  private void selectWallAndRoofType(String roofConst, String wallConst) throws CustomE2eException {
    selectWallDetail(wallConst);
    selectRoofDetail(roofConst);
  }

  private void selectRoofDetail(String roofDetails) throws CustomE2eException {
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ROOF_CONSTRUCTION(),
        roofDetails, SelectOptions.TEXT);
  }

  private void selectWallDetail(String wallDetails) throws CustomE2eException {
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().WALL_CONSTRUCTION(),
        wallDetails, SelectOptions.TEXT);
  }

  private void selectBuildingType(Map<String, Object> buildingDetails) throws CustomE2eException {
    var buildingType = (String) buildingDetails.get(commonControlDataDef.BUILDING_TYPE_VAR);
    scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BUILDING_TYPE());
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BUILDING_TYPE(),
        buildingType, SelectOptions.TEXT);
    if (isElementVisible(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().STRUCTURE_TYPE())) { // condition for Maisonette Building type
      var structureType = (String) buildingDetails.get(STRUCTURE_TYPE_VAR);
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().STRUCTURE_TYPE(),
          structureType, SelectOptions.TEXT);
    }
  }

  public void sufferedLossNotResultedInClaim(Boolean sufferedLossNotResultedInClaim) throws CustomE2eException {
    waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SUFFERED_LOSS_NOT_RESULTED_IN_CLAIM(), this.CommonHelper.convertBooleanIntoString(sufferedLossNotResultedInClaim)), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SUFFERED_LOSS_NOT_RESULTED_IN_CLAIM(), this.CommonHelper.convertBooleanIntoString(sufferedLossNotResultedInClaim)), SyncType.CLICKABLE);
  }

  public void interestedParties() throws CustomE2eException {
  }

  public void calculatePremium() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CALCULATE_PREMIUM(),
        SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    RetryOnClickInterceptedException(10,
        () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CALCULATE_PREMIUM(), SyncType.CLICKABLE));
    waitForPageLoad();
  }

  public void coverDetails(Map<String, Object> insuranceDetails) throws CustomE2eException {
    //Building cover options
    var contentDetails =
        ((Map<String, Object>) (insuranceDetails.get(commonControlDataDef.CONTENT_DETAILS_VAR)));
    var typeOfHouseholdCover =
        ((Map<String, Object>) (insuranceDetails.get(commonControlDataDef.TYPE_OF_HOUSEHOLD_COVER)));
    coverTypes(insuranceDetails);
    eisGeneralStepDefinitions.navigateToNextPage();
//    Boolean buildingCover;
//    Boolean contentCover;
    var buildingCover =
        CommonHelper.convertStringIntoBoolean(typeOfHouseholdCover.get(commonControlDataDef.BUILDING_VAR));
    var contentCover =
        CommonHelper.convertStringIntoBoolean(typeOfHouseholdCover.get(commonControlDataDef.CONTENTS_VAR));

    if (contentCover.equals(true) || buildingCover.equals(true) && contentCover.equals(true)) {
      if (!Boolean.parseBoolean(String.valueOf(contentDetails.get(commonControlDataDef.SPECIFIED_ITEM_FLAG)))) {
//        RetryOnException("valuable Items", CustomE2eException.class, 500L, 10,
//            () -> clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().VALUABLES_IN_HOME(), this.CommonHelper.convertBooleanIntoString(false)), SyncType.CLICKABLE));
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().VALUABLES_IN_HOME(), this.CommonHelper.convertBooleanIntoString(false)), SyncType.CLICKABLE);
        eisGeneralStepDefinitions.navigateToNextPage();
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().VALUABLES_AWAY_HOME(), this.CommonHelper.convertBooleanIntoString(false)), SyncType.CLICKABLE);
        eisGeneralStepDefinitions.navigateToNextPage();
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BICYCLE_AWAY_HOME(), this.CommonHelper.convertBooleanIntoString(false)), SyncType.CLICKABLE);
        //eisGeneralStepDefinitions.navigateToNextPage();
//        try {
//          Thread.sleep(5000);
//        } catch (InterruptedException e) {
//          throw new RuntimeException(e);
//        }
      } else {
        specifiedValuableItemsInHome((Map<String, Object>) contentDetails.get(SPECIFIED_ITEMS));
        eisGeneralStepDefinitions.navigateToNextPage();
        specifiedValuableItemsAwayHome((Map<String, Object>) contentDetails.get(SPECIFIED_ITEMS));
        //eisGeneralStepDefinitions.navigateToNextPage();
      }
      eisGeneralStepDefinitions.navigateToNextPage();

    }
  }

  private void specifiedValuableItemsInHome(Map<String, Object> specifiedContent) throws CustomE2eException {
    if (specifiedContent.containsKey(IN_HOME)) {
      ArrayList<Map<String, Object>> itemsInHome =
          (ArrayList<Map<String, Object>>) specifiedContent.get(IN_HOME);
      clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().VALUABLES_IN_HOME(), this.CommonHelper.convertBooleanIntoString(true)), SyncType.CLICKABLE);
//      RetryOnException("valuable Items", CustomE2eException.class, 500L, 10,
//          () -> clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().VALUABLES_IN_HOME(), this.CommonHelper.convertBooleanIntoString(true)), SyncType.CLICKABLE));
      int itemCount = itemsInHome.size();
      for (var individualItems : itemsInHome) {
        selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().VALUABLE_ITEMS(),
            individualItems.get(SPECIFIED_ITEM).toString(),
            SelectOptions.TEXT);
        typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().VALUABLE_ITEMS_DESCRIPTION(), individualItems.get(SPECIFIED_DESC), SyncType.CLICKABLE);
        typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().VALUABLE_ITEMS_VALUE(),
            individualItems.get(SPECIFIED_VALUE), SyncType.CLICKABLE);
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().OK_BUTTON_VALUABLE_SECTION(), SyncType.CLICKABLE);
        if (itemCount > 1) {
          clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ADD_ITEMS(),
              SyncType.CLICKABLE);
          itemCount--;
        }
      }
    } else {
//      RetryOnException("valuable Items", CustomE2eException.class, 500L, 10,
//          () -> clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().VALUABLES_IN_HOME(), this.CommonHelper.convertBooleanIntoString(false)), SyncType.CLICKABLE));
      clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().VALUABLES_IN_HOME(), this.CommonHelper.convertBooleanIntoString(false)), SyncType.CLICKABLE);
    }
  }

  private void specifiedValuableItemsAwayHome(Map<String, Object> specifiedContent) throws CustomE2eException {
    if (specifiedContent.containsKey(AWAY_HOME)) {
      ArrayList<Map<String, Object>> itemsAwayFromHome =
          (ArrayList<Map<String, Object>>) specifiedContent.get(AWAY_HOME);
      ArrayList<Map<String, Object>> exceptBike = new ArrayList<>();
      ArrayList<Map<String, Object>> onlyBike = new ArrayList<>();

      boolean answerToQuestion = false;
      for (var individualItems : itemsAwayFromHome) {
        if (!individualItems.get(SPECIFIED_ITEM).toString().equalsIgnoreCase(BICYCLE)) {
          answerToQuestion = true;
          exceptBike.add(individualItems);
        } else if (individualItems.get(SPECIFIED_ITEM).toString().equalsIgnoreCase(BICYCLE)) {
          onlyBike.add(individualItems);
        }
      }
      int itemExceptBikeCount = exceptBike.size();
      clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().VALUABLES_AWAY_HOME(), this.CommonHelper.convertBooleanIntoString(answerToQuestion)), SyncType.CLICKABLE);
      if (answerToQuestion == true) {
        for (var individualItems : exceptBike) {
          selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().VALUABLE_ITEMS(),
              individualItems.get(SPECIFIED_ITEM).toString(),
              SelectOptions.TEXT);
          typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().VALUABLE_ITEMS_DESCRIPTION(), individualItems.get(SPECIFIED_DESC), SyncType.CLICKABLE);
          typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().VALUABLE_ITEMS_VALUE(),
              individualItems.get(SPECIFIED_VALUE), SyncType.CLICKABLE);
          clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().OK_BUTTON_VALUABLE_SECTION(), SyncType.CLICKABLE);
          if (itemExceptBikeCount > 1) {
            clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ADD_ITEMS(),
                SyncType.CLICKABLE);
            itemExceptBikeCount--;
          }
        }
      }
      eisGeneralStepDefinitions.navigateToNextPage();
      if (!onlyBike.isEmpty()) {
        specifiedBicycleItemsAwayHome(onlyBike);
      } else {
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BICYCLE_AWAY_HOME(), this.CommonHelper.convertBooleanIntoString(false)), SyncType.CLICKABLE);
      }
    } else {
      clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().VALUABLES_AWAY_HOME(), this.CommonHelper.convertBooleanIntoString(false)), SyncType.CLICKABLE);
      eisGeneralStepDefinitions.navigateToNextPage();
      clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BICYCLE_AWAY_HOME(), this.CommonHelper.convertBooleanIntoString(false)), SyncType.CLICKABLE);
    }
  }

  private void specifiedBicycleItemsAwayHome(ArrayList<Map<String, Object>> bicycle) throws CustomE2eException {
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BICYCLE_AWAY_HOME(), this.CommonHelper.convertBooleanIntoString(true)), SyncType.CLICKABLE);
    int itemCount = bicycle.size();
    for (var individualItems : bicycle) {
      typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BICYCLE_DESCRIPTION(),
          individualItems.get(SPECIFIED_DESC), SyncType.CLICKABLE);
      typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().VALUE_OF_BICYCLE(),
          individualItems.get(SPECIFIED_VALUE), SyncType.CLICKABLE);
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().OK_BUTTON_VALUABLE_SECTION(), SyncType.CLICKABLE);
      if (itemCount > 1) {
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ADD_ITEMS(),
            SyncType.CLICKABLE);
        itemCount--;
      }
    }
  }


  private void coverTypes(Map<String, Object> insuranceDetails) throws CustomE2eException {
    var typeOfHouseholdCover =
        ((Map<String, Object>) (insuranceDetails.get(commonControlDataDef.TYPE_OF_HOUSEHOLD_COVER)));
    Boolean buildingCover =
        CommonHelper.convertStringIntoBoolean(typeOfHouseholdCover.get(commonControlDataDef.BUILDING_VAR));
    Boolean contentCover =
        CommonHelper.convertStringIntoBoolean(typeOfHouseholdCover.get(commonControlDataDef.CONTENTS_VAR));
//    var buidlingCoverObj = ;
//    var contentCoverObj =
//
//    if (buidlingCoverObj instanceof String) {
//      buildingCover = Boolean.parseBoolean((String) buidlingCoverObj);
//    } else {
//      buildingCover = (Boolean) buidlingCoverObj;
//    }
//    if (contentCoverObj instanceof String) {
//      contentCover = Boolean.parseBoolean((String) contentCoverObj);
//    } else {
//      contentCover = (Boolean) contentCoverObj;
//    }
    if (buildingCover.equals(true)) {
      enterBuildingCoverTypesDetails(insuranceDetails,
              (Map<String, Object>) insuranceDetails.get(TYPE_OF_HOUSEHOLD_COVER_VAR));
    }
    if (contentCover.equals(true)) {
      //Content cover options
      enterContentCoverTypeDetails(insuranceDetails,
          (Map<String, Object>) insuranceDetails.get(TYPE_OF_HOUSEHOLD_COVER_VAR));
    }
  }


  public void selectRiskAddress(Map<String, Object> riskAddress,
                                Map<String, Object> proposerContactDetails) throws CustomE2eException {
    var addressSelectorHouseIdentifier = String.valueOf(((Map<String, Object>) proposerContactDetails.get(commonControlDataDef.CORRESPONDENCE_ADDRESS)).get(commonControlDataDef.HOUSE_IDENTIFIER));
    var riskAddressHouseIdentifier = String.valueOf(riskAddress.get(commonControlDataDef.HOUSE_IDENTIFIER));

    var addressSelectorPostCode =
        String.valueOf(((Map<String, Object>) proposerContactDetails.get(commonControlDataDef.CORRESPONDENCE_ADDRESS)).get(commonControlDataDef.POST_CODE));
    var riskAddressPostCode =   String.valueOf(riskAddress.get(commonControlDataDef.POST_CODE));

    if (addressSelectorHouseIdentifier.equalsIgnoreCase(riskAddressHouseIdentifier) && addressSelectorPostCode.equalsIgnoreCase(riskAddressPostCode)) {
//      scrollElementIntoCenterOfScreen(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS(), String.valueOf("1")));
//      waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS(), String.valueOf("1")), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
      clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS(), String.valueOf("1")), SyncType.CLICKABLE);
    } else {
//      scrollElementIntoCenterOfScreen(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS(), String.valueOf("2")));
//      waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS(), String.valueOf("2")), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
      clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS(), String.valueOf("2")), SyncType.CLICKABLE);
      enterRiskDetails(riskAddressHouseIdentifier, riskAddressPostCode);
    }
  }

  public void enterRiskDetails(String houseIdentifier, String postCode) throws CustomE2eException {
//    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS_POST_CODE(), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
//    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS_POST_CODE(),
//        SyncType.CLICKABLE);
    typeText(
            this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS_POST_CODE(),
            postCode,
            SyncType.CLICKABLE,
            false,
            true,
            ""
    );




//    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS_HOUSE_IDENTIFIER(), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
//    scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS_HOUSE_IDENTIFIER());
//    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS_HOUSE_IDENTIFIER(), SyncType.CLICKABLE);
//    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS_FIND_POSTCODE(), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
//    smartClickElement(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS_FIND_POSTCODE(), xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().DEFAULT_RISK_HOME_ADDRESS(), houseIdentifier), "Find correspondence post code");
//    int retryCount = 2;
//    for (int count = 0; count < retryCount; count++) {
//      waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().DEFAULT_RISK_HOME_ADDRESS(), houseIdentifier), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
//      if (!isElementVisible(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().DEFAULT_RISK_HOME_ADDRESS(), houseIdentifier))) {
//        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS_FIND_POSTCODE(), SyncType.CLICKABLE);
//      }
//    }


    clickElement(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS_FIND_POSTCODE(), SyncType.CLICKABLE);
//    clickElement(By.xpath( "//td[starts-with(text(), '" + houseIdentifier + " ')]"), SyncType.CLICKABLE);
    clickElement(By.xpath( "//tr[.//td[starts-with(text(), '" + houseIdentifier + " ')]]"), SyncType.CLICKABLE);
    clickElement(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS_SELECTION_OK(), SyncType.CLICKABLE);


//    RetryOnStaleElementException(3,
//        () -> clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().DEFAULT_RISK_HOME_ADDRESS(), houseIdentifier), SyncType.CLICKABLE), "Selecting default address");
//    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS_SELECTION_OK(), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
//    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS_SELECTION_OK(), SyncType.CLICKABLE);
//    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS_HOUSE_IDENTIFIER(), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
//    typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS_HOUSE_IDENTIFIER(), houseIdentifier, SyncType.CLICKABLE);
//    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().RISK_ADDRESS_ADDRESS_LINE1(), SyncType.CLICKABLE);
  }

  public void enterClaimDetails(Map<String, Object> salesDetails) throws CustomE2eException {
    ArrayList<Map<String, Object>> claimHoistory =
        (ArrayList<Map<String, Object>>) salesDetails.get(CommonControlDataDefns.CLAIM_HISTORY);
    for (var claim : claimHoistory) {
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ADD_CLAIM(),
          SyncType.CLICKABLE);
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().INCIDENT_SOURCE(),
          claim.get(CommonControlDataDefns.INCIDENT_SOURCE), SelectOptions.TEXT);
      typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().INCIDENT_DATE(),
          claim.get(CommonControlDataDefns.INCIDENT_DATE), SyncType.CLICKABLE);
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CLAIM_STATUS(), 1,
          SelectOptions.INDEX); //Temp Arrangements
      waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CLAIM_STATUS(),
          SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CLAIM_STATUS(),
          claim.get(CommonControlDataDefns.CLAIM_STATUS), SelectOptions.TEXT);
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CLAIM_TYPE(),
          claim.get(CommonControlDataDefns.CLAIM_TYPE), SelectOptions.TEXT);
      selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CLAIM_CAUSE(),
          claim.get(CommonControlDataDefns.CLAIM_CAUSE), SelectOptions.TEXT);
      typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CLAIM_COST(),
          claim.get(CommonControlDataDefns.COST), SyncType.CLICKABLE);
      waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CLAIM_NUMBER(),
          SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CLAIM_NUMBER(),
          SyncType.CLICKABLE);
      typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CLAIM_NUMBER(),
          claim.get(CommonControlDataDefns.CLAIM_NUM), SyncType.CLICKABLE);
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CLAIM_OK_BUTTON(),
          SyncType.CLICKABLE);
    }
  }

  public void enterInterestedPartiesDetails() {
    //TBD
  }

  public void enterBuildingCoverTypesDetails(Map<String, Object> insuranceDet,
                                             Map<String, Object> typeOfHouseHoldCover) throws CustomE2eException {
    var insuredAmount = insuranceDet.get(CommonControlDataDefns.INSURED_AMOUNT);
//    waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BUILDING_ACCIDENTAL_DAMAGE_COVER(), this.CommonHelper.convertBooleanIntoString(typeOfHouseHoldCover.get(commonControlDataDef.BUILDING_ACCIDENTAL_DAMAGE_COVER))), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BUILDING_ACCIDENTAL_DAMAGE_COVER(), this.CommonHelper.convertBooleanIntoString(typeOfHouseHoldCover.get(commonControlDataDef.BUILDING_ACCIDENTAL_DAMAGE_VAR))), SyncType.CLICKABLE);

    typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().REBUILDING_COST(),
        ((Map<String, Object>) insuredAmount).get(REBUILDING_COST_VAR),
        SyncType.CLICKABLE);
    //ByDefault set to 0 as per Echelon
//    scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BUILDING_CLAIM_FREE_YEARS());
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BUILDING_CLAIM_FREE_YEARS(), SyncType.CLICKABLE);
    typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BUILDING_CLAIM_FREE_YEARS(),
        ((Map<String, Object>) insuranceDet.get(commonControlDataDef.INSURANCE_HISTORY_VAR)).get(BUILDING_CLAIM_FREE_YEAR_VAR), SyncType.VISIBLE);
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BUILDING_VOLUNTARY_EXCESS(), String.valueOf(((Map<String, Object>) insuredAmount).get(BUILDING_VOL_EXCESS_VAR)), SelectOptions.TEXT);
  }

  public void enterContentCoverTypeDetails(Map<String, Object> insuranceDet,
                                           Map<String, Object> typeOfHouseHoldCover) throws CustomE2eException {
    var unspecifiedItemCover=(Map<String, Object>)((Map<String, Object>) insuranceDet.get(commonControlDataDef.CONTENT_DETAILS_VAR)).get(UNSPECIFIED_ITEMS_VAR);
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CONTENT_ACCIDENTAL_DAMAGE_COVER(), this.CommonHelper.convertBooleanIntoString(typeOfHouseHoldCover.get(commonControlDataDef.CONTENT_ACCIDENTAL_DAMAGE_VAR))), SyncType.CLICKABLE);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CONTENTS_SUM_INSURED(),
        SyncType.CLICKABLE);
    typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CONTENTS_SUM_INSURED(),
        ((Map<String, Object>) insuranceDet.get(commonControlDataDef.INSURED_AMOUNT_VAR)).get(commonControlDataDef.CONTENT_SUM_VAR), SyncType.CLICKABLE, true, false, "Enter contents sum failed");
    //ByDefault set to 0 as per Echelon
//    scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CONTENT_CLAIM_FREE_YEARS());
//    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CONTENT_CLAIM_FREE_YEARS(), SyncType.CLICKABLE);
    typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CONTENT_CLAIM_FREE_YEARS(),
        ((Map<String, Object>) insuranceDet.get(commonControlDataDef.INSURANCE_HISTORY_VAR)).get(commonControlDataDef.CONTENT_CLAIM_FREE_YEARS_VAR), SyncType.VISIBLE, true, false, "Enter contents years claim free failed");
    selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CONTENT_VOLUNTARY_EXCESS(), String.valueOf(((Map<String, Object>) insuranceDet.get(commonControlDataDef.INSURED_AMOUNT_VAR)).get(CONTENT_VOL_EXCESS_VAR)), SelectOptions.TEXT);
    //safe installed - Default set to true
//    scrollElementIntoCenterOfScreen(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SAFE_INSTALLED(), this.CommonHelper.convertBooleanIntoString((Boolean) ((Map<String, Object>) insuranceDet.get(commonControlDataDef.CONTENT_DETAILS_VAR)).get(SAFE_VAR))));
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SAFE_INSTALLED(), this.CommonHelper.convertBooleanIntoString((Boolean) ((Map<String, Object>) insuranceDet.get(commonControlDataDef.CONTENT_DETAILS_VAR)).get(SAFE_VAR))), SyncType.CLICKABLE);

    //Would you like cover for other unspecified items you take outside the home?
    waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().COVER_FOR_OTHER_UNSPECIFIED_ITEMS(), String.valueOf(this.CommonHelper.convertBooleanIntoInteger((Boolean) unspecifiedItemCover.get(COVER_STATUS_VAR)))), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().COVER_FOR_OTHER_UNSPECIFIED_ITEMS(), String.valueOf(this.CommonHelper.convertBooleanIntoInteger((Boolean) unspecifiedItemCover.get(COVER_STATUS_VAR)))), SyncType.CLICKABLE);

    if((Boolean) unspecifiedItemCover.get(COVER_STATUS_VAR)){
      waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().UNSPECIFIED_ITEMS_AMOUNT(), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
      typeText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().UNSPECIFIED_ITEMS_AMOUNT(),unspecifiedItemCover.get(ITEM_AMOUNT), SyncType.CLICKABLE, true);
    }
  }

  public void CoveragesAndPremiumDetails() {

  }


  public void consentToRenew(Boolean consentToRenew) throws CustomE2eException {
//    scrollElementIntoCenterOfScreen(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CONSENT_TO_RENEW(), this.CommonHelper.convertBooleanIntoString(consentToRenew)));
//    waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CONSENT_TO_RENEW(), this.CommonHelper.convertBooleanIntoString(consentToRenew)), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CONSENT_TO_RENEW(), this.CommonHelper.convertBooleanIntoString(consentToRenew)), SyncType.CLICKABLE);
    waitForPageLoad();
  }

  public String getQuoteReference() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().QUOTE_REF_NUMBER());
  }


  public String getEffectiveDate() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().POLICY_EFFECTIVE_DATE());
  }

  public Double getQuoteValue() throws CustomE2eException {
    return Double.parseDouble(getText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().QUOTE_REF_VALUE()).replaceAll("[£,]", ""));
  }

  public void saveAndExitButton() throws CustomE2eException {
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SAVE_AND_EXIT(),
        SyncType.CLICKABLE);
  }

  public boolean declinesApplied(){
    var declines = false;
    if(isElementVisible(this.pageObjectOfEis.getEisPolicyDashboardLocatorModel().SELECT_DECLINES_APPLIED())){
      declines=true;
    }
    return declines;
  }
  public boolean referralsApplied(){
    var referrals = false;
    if(isElementVisible(this.pageObjectOfEis.getEisPolicyDashboardLocatorModel().SELECT_REFERRALS_APPLIED())){
      referrals = true;
    }
    return referrals;
  }


  public void openQuote(String quoteReference) throws CustomE2eException {
    waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().POLICY_NUMBER(), quoteReference), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().POLICY_NUMBER(), quoteReference), SyncType.CLICKABLE);
  }

  public void redirectToCoverageAndPremium() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().COVERAGE_AND_PREMIUM_TAB(), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().COVERAGE_AND_PREMIUM_TAB(), SyncType.CLICKABLE);
  }

  public String getCustomerNumber() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CUSTOMER_NUMBER(),
        SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    return getText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CUSTOMER_NUMBER());
  }

  public String getPolicyNumber() throws CustomE2eException {
    return getText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().POLICY_ID());
  }

  public String getPolicyStatus() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().POLICY_STATUS(),
        SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    return getText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().POLICY_STATUS());
  }

  public String policyNumber() throws CustomE2eException {
    String policyNum =
        getText(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().POLICY_NUMBER());
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().POLICY_NUMBER(),
        SyncType.CLICKABLE);
    return policyNum;
  }

  public void addOptionalExtras(String optionalExtrasStr) throws CustomE2eException {
    int optExtraCounter = 0;
    ArrayList<String> listOptionalExtras =
        new ArrayList<>(Arrays.asList(optionalExtrasStr.replace(", ", ",").split(",")));
    var listOfCode =
        getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ALL_OPTIONAL_EXTRAS_CODE());
    if(listOfCode.size()>1) {
      for (var optExtra : listOptionalExtras) {
        if (listOfCode.contains(optExtra)) {
//          scrollElementIntoCenterOfScreen(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().OPTIONAL_EXTRAS_CODE_YES_ANSWER(), optExtra));
//          browserScrollToElementUpOrDown(, false);
          clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().OPTIONAL_EXTRAS_CODE_YES_ANSWER(), optExtra), SyncType.CLICKABLE);
          optExtraCounter++;
        }
      }
      if (optExtraCounter != listOptionalExtras.size()) {
        scrollIntoView(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ALL_OPTIONAL_EXTRAS_CODE());
        throw new CustomE2eException("Some optional extras is not added/found.");
      }
    }
  }

  public void addEndorsement(String endorsement) throws CustomE2eException {
    int endorsementCounter = 0;
    ArrayList<String> endorsementList = new ArrayList<>(Arrays.asList(endorsement.replace(", ",
        ",").split(",")));
    var listOfEndorsements =
        getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ENDORSEMENT_LIST());
    for (var endorse : listOfEndorsements) {
      if (endorsementList.contains(endorse)) {
        var indexOfEndorse = endorsementList.indexOf(endorse.trim());
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ADD_ENDORSEMENT(), String.valueOf(indexOfEndorse + 1)), SyncType.VISIBLE);
//        scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ENDORSEMENT_CLOSE());
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().ENDORSEMENT_CLOSE(),
            SyncType.VISIBLE);
        endorsementCounter++;
      }
    }
    if (endorsementCounter != endorsementList.size()) {
      throw new CustomE2eException("Some endorsement is not added/found.");
    }
  }

}

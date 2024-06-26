package PageObjects.EisVersion.V01;

import PageObjects.EisModel.EisSharedLocatorModel;
import org.openqa.selenium.By;

public class EisSharedLocatorLib implements EisSharedLocatorModel {
  @Override
  public By POLICY_LIST() {
    return By.xpath("//tbody[@class=\"ant-table-tbody\"]/tr");
  }

  @Override
  public By POLICY_NUMBER() {
    return By.cssSelector("#productConsolidatedViewForm\\:scolumn_Policy\\:0\\:policyNumber");
  }

  @Override
  public By POLICY_TAB() {
    return By.cssSelector("#policyDataGatherForm\\:tabListList_1\\:0\\:link");
  }

  @Override
  public By INSURED_TAB() {
    return By.cssSelector("#policyDataGatherForm\\:tabListList_1\\:1\\:link");
  }

  @Override
  public By RISK_ADDRESS_TAB() {
    return By.cssSelector("#policyDataGatherForm\\:tabListList_1\\:2\\:link");
  }

  @Override
  public By CLAIMS_TAB() {
    return By.cssSelector("#policyDataGatherForm\\:tabListList_1\\:3\\:link");
  }

  @Override
  public By INTERESTED_PARTIES_TAB() {
    return By.cssSelector("#policyDataGatherForm\\:tabListList_1\\:4\\:link");
  }

  @Override
  public By COVER_OPTIONS_TAB() {
    return By.cssSelector("#policyDataGatherForm\\:tabListList_1\\:5\\:link");
  }

  @Override
  public By COVER_TYPES_TAB() {
    return By.cssSelector("#policyDataGatherForm\\:tabListList_2\\:0\\:linkLabel");
  }

  @Override
  public By SPECIFIED_ITEMS_TAB() {
    return By.cssSelector("#policyDataGatherForm\\:tabListList_2\\:1\\:linkLabel");
  }

  @Override
  public By SPECIFIED_ITEMS_AT_HOME_TAB() {
    return By.cssSelector("#policyDataGatherForm\\:tabListList_3\\:0\\:linkLabel");
  }

  @Override
  public By SPECIFIED_ITEMS_AWAY_FROM_HOME_TAB() {
    return By.cssSelector("#policyDataGatherForm\\:tabListList_3\\:1\\:linkLabel");
  }

    @Override
    public By COVERAGE_AND_PREMIUM_TAB() {
        return By.cssSelector("[id=\"policyDataGatherForm:tabListList_1:6:linkLabel\"]");
    }

  @Override
  public By ENDORSEMENTS_TAB() {
    return By.cssSelector("#policyDataGatherForm\\:tabListList_1\\:7\\:link");
  }

  @Override
  public By POLICY_START_DATE() {
    return By.cssSelector("#productConsolidatedViewForm\\:scolumn_Policy\\:0" +
        "\\:contractTerm_effective");
  }

  @Override
  public By POLICY_END_DATE() {
    return By.cssSelector("#productConsolidatedViewForm\\:scolumn_Policy\\:0" +
        "\\:contractTerm_expiration");
  }

  @Override
  public By INSURED_TITLE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonInfoProxy_person_nameInfo_salutation");
  }

  @Override
  public By INSURED_FIRSTNAME() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonInfoProxy_person_nameInfo_firstName");
  }

  @Override
  public By INSURED_LASTNAME() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonInfoProxy_person_nameInfo_lastName");
  }

  @Override
  public By INSURED_DATE_OF_BIRTH() {
    return By.xpath("//*[@id=\"productConsolidatedViewForm:ageaInsuredHomeTable_data\"]/tr[1]/td" + "[3]");
  }

  @Override
  public By INSURED_CORRESPONDENCE_ADDRESS_HOUSE_NO() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonAddressContactProxy_addressEntity_address_addressLine1");
  }

  @Override
  public By INSURED_CORRESPONDENCE_ADDRESS_LINE1() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonAddressContactProxy_addressEntity_address_addressLine2");
  }

  @Override
  public By INSURED_CORRESPONDENCE_ADDRESS_LINE2() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonAddressContactProxy_addressEntity_address_addressLine3");
  }

  @Override
  public By INSURED_CORRESPONDENCE_ADDRESS_CITY() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonAddressContactProxy_addressEntity_address_city");
  }

  @Override
  public By INSURED_CORRESPONDENCE_ADDRESS_COUNTY() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonAddressContactProxy_addressEntity_address_county");
  }

  @Override
  public By INSURED_CORRESPONDENCE_ADDRESS_POSTCODE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonAddressContactProxy_addressEntity_address_postalCode");
  }

  @Override
  public By INSURED_EMAIL() {
    return By.cssSelector("#productConsolidatedViewForm\\:scolumn_PreconfigInsured\\:0" +
        "\\:emailsAsStringCons");
  }

  @Override
  public By INSURED_EMPLOYMENT_STATUS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonInfoProxy_person_occupationOptionsCd");
  }

  @Override
  public By INSURED_EMPLOYMENT_OCCUPATION() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonInfoProxy_person_occupationCd");
  }

  @Override
  public By INSURED_RISK_ADDRESS_HOUSE_NO() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigHomeRiskItemAddressContact_address_addressLine1");
  }

  @Override
  public By INSURED_RISK_ADDRESS_LINE1() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigHomeRiskItemAddressContact_address_addressLine2");
  }

  @Override
  public By LIST_OPTIONAL_EXTRAS() {
    return By.xpath("//*[@id=\"productConsolidatedViewForm:j_id_25_73_o_2:j_id_25_73_o_3\"]/table"
        + "[2]/tbody/tr/td/table/tbody/tr");
  }

  @Override
  public By LIST_OPTIONAL_EXTRAS_TABLE_COLUMN() {
    return By.xpath("//*[@id=\"productConsolidatedViewForm:j_id_25_73_o_2:j_id_25_73_o_3\"]/table"
        + "[2]/tbody/tr/td/table/tbody/tr[<variable>]/td[2]");
  }

  @Override
  public By CANCEL_BUTTON() {
    return By.cssSelector("#topCancelLink");
  }

  @Override
  public By LIST_POLICY_IN_TABLE() {
    return By.xpath("//*[@id=\"f06e1d2c-6297-4366-b861-e71b6cb8e19f\"]/div/div/form/div/div/div[2"
        + "]/div/div/div/div/div/div/table/tbody/tr");
  }

  @Override
  public By SELECT_POLICY_FROM_TABLE() {
    return By.xpath("//*[@id=\"f06e1d2c-6297-4366-b861-e71b6cb8e19f\"]/div/div/form/div/div/div[2"
        + "]/div/div/div/div/div/div/table/tbody/tr/td[2]/div/a/span");
  }

  @Override
  public By INSURED_RISK_ADDRESS_LINE2() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigHomeRiskItemAddressContact_address_addressLine3");
  }

  @Override
  public By INSURED_ADDRESS_CITY() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigHomeRiskItemAddressContact_address_city");
  }

  @Override
  public By INSURED_ADDRESS_COUNTY() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigHomeRiskItemAddressContact_address_county");
  }

  @Override
  public By INSURED_ADDRESS_POSTCODE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigHomeRiskItemAddressContact_address_postalCode");
  }

  @Override
  public By OWNERSHIP_TYPE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_PreconfigConstructionInfo_owned");
  }

  @Override
  public By PROPERTY_LET_SUBLET_STATUS() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_PreconfigConstructionInfo_propertyLetInd\"]");
  }

  @Override
  public By BUILDING_WORK() {
    return By.xpath("//span[@id=\"policyDataGatherForm:sedit_PreconfigConstructionInfo_cocInd\"]");
  }

  @Override
  public By GOOD_REPAIR() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_PreconfigConstructionInfo_goodRepairInd\"]");
  }

  @Override
  public By CONSTRUCTION_TYPE() {
    return By.xpath("//label[text()=\"Construction Type\"]/following::span[1]"); // Value not available
  }

  @Override
  public By INSURED_PHONE_NO() {
//    return By.cssSelector("#productConsolidatedViewForm\\:scolumn_PreconfigInsured\\:0" +
//        "\\:phonesAsStringCons");
    return By.cssSelector("#policyDataGatherForm\\:sedit_PreconfigInsuredPersonPhoneContactProxy_phoneEntity_phoneNumber");
  }

  @Override
  public By INSURED_ADDRESS_EXTENSION() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigConstructionInfo_propertyExtendedInd");
  }

  //label[contains(text(), "extended")]/following::span[1]
  @Override
  public By INTRUDER_ALARM_DETAILS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigBurglarAlarmTypeQuestionAnswer_otherAnswer");
  }

  @Override
  public By DOOR_LOCK_DETAILS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigDeadBoltQuestionAnswer_yesNoAnswer");
  }

  @Override
  public By NUMBER_OF_ADULTS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaNumberOfAdultsQuestionAnswer_otherAnswer");
  }

  @Override
  public By NUMBER_OF_CHILDREN() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaChildInPropertyQuestionAnswer_otherAnswer");
  }

  @Override
  public By HOUSE_OCCUPANCY() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigOccupancyTypeQuestionAnswer_otherAnswer");
  }

  @Override
  public By PAYING_GUEST_DETAILS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaNonFamilyLodgersQuestionAnswer_yesNoAnswer");
  }

  @Override
  public By PET_DETAILS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaPetsInPropertyQuestionAnswer_otherAnswer");
  }

  @Override
  public By BUSINESS_USE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigBusinessConductedQuestionAnswer_yesNoAnswer");
  }

  @Override
  public By NUMBER_OF_BEDROOMS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigConstructionInfo_bedroomsNumberCd");
  }

  @Override
  public By NUMBER_OF_BATHROOMS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigConstructionInfo_bathroomsNumberCd");
  }

  @Override
  public By PROPERTY_TYPE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_AgeaBuildingInfo_buildingTypeCd");
  }

  @Override
  public By CONSTRUCTION_YEAR() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_PreconfigConstructionInfo_yearBuilt");
  }

  @Override
  public By BUILDING_CONSTRUCTION() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaBuildingInfo_homeBuiltOfStandardConstructionInd");
  }

  @Override
  public By BUILDING_LISTED_DETAILS() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_AgeaBuildingInfo_homeListedBuildingInd");
  }

  @Override
  public By BUILDING_ACCIDENTAL_DAMAGE_COVER() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaHomeBuildingCoverOptions_accidentalDamageCoverOnYourBuildingsInd");
  }

  @Override
  public By BUILDING_COST() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_AgeaHomeBuildingCoverOptions_rebuildCost");
  }

  @Override
  public By PREVIOUS_INSURANCE_HELD() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigPolicyPriorCarrier_previousInsuranceInd");
  }

  @Override
  public By MAX_LIMIT_AMOUNT() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_AgeaHomeSISIAFHCoverage_radarLimitStr");
  }

  @Override
  public By CONTENT_ACCIDENTAL_DAMAGE_COVER() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaHomeContentCoverOptions_accidentalDamageCoverOnYourContentsInd");
  }

  @Override
  public By CONTENT_SUM_INSURED() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaHomeContentCoverOptions_contentsSumInsured");
  }

  @Override
  public By INDIVIDUAL_ITEM_COVER() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaHomeCoverSpecifiedItemsInTheHomeQuestionAnswer_yesNoAnswer");
  }

  @Override
  public By PERSONALISED_ITEMS_AWAY_FROM_HOME() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaHomeContentCoverOptions_coverForOtherUnspecifiedItemsInd");
  }

  @Override
  public By SPECIFY_ITEMS_AWAY_FROM_HOME() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaHomeSpecifiedItemsAwayFromHomeQuestionAnswer_yesNoAnswer");
  }

  @Override
  public By PERSONALISED_ITEMS_AWAY_FROM_HOME_COST() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaHomeContentCoverOptions_unspecifiedItemsAmount");
  }

  @Override
  public By VIEW_ALL_POLICIES() {
    return By.xpath("//button[@class=\"ant-btn ui-components__button ant-btn-link\"]");
  }

  @Override
  public By GET_COVER_TYPE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_Policy_coverageTypeCd");
  }

  @Override
  public By COVER_START_DATE() {
    return By.cssSelector("#productContextInfoForm" +
        "\\:policyDetail_policyStatusCdText_txEffectiveDate");
  }

  @Override
  public By HOUSEHOLD_COVER() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_Policy_coverageTypeCd");
  }

  @Override
  public By BUILDING_VOLUNTARY_EXCESS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaHomeBuildingCoverOptions_buildingVolXsCd");
  }

  @Override
  public By CONTENT_VOLUNTARY_EXCESS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaHomeContentCoverOptions_contentsVolXS");
  }

  @Override
  public By SELECT_NAMED_INSURED() {
    return By.cssSelector("#policyDataGatherForm\\:pathContextElement_PreconfigInsured0");
  }

  @Override
  public By LIST_NAME_INSURED() {
    return By.cssSelector("#policyDataGatherForm\\:dataGatherView_ListPreconfigInsured_data");
  }

  @Override
  public By NAME_INSURED_DROPDOWN_SELECTOR() {
    return By.cssSelector("#policyDataGatherForm\\:pathContextElement_PreconfigInsured0_label");
  }

  @Override
  public By SELECT_JOINT_POLICYHOLDER() {
    return By.xpath("//*[@id=\"policyDataGatherForm:items0_1\"]/span[2]");
  }

  @Override
  public By SELECT_MAIN_POLICYHOLDER() {
    return By.xpath("//*[@id=\"policyDataGatherForm:items0_0\"]/span[2]");
  }

  @Override
  public By JPH_DATE_OF_BIRTH() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonInfoProxy_person_dateOfBirthInputDate");
  }

  @Override
  public By JPH_EMPLOYMENT_STATUS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonInfoProxy_person_occupationOptionsCd");
  }

  @Override
  public By JPH_EMPLOYMENT_INDUSTRY() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonInfoProxy_person_businessTypeCd");
  }

  @Override
  public By JPH_FIRSTNAME() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonInfoProxy_person_nameInfo_firstName");
  }

  @Override
  public By JPH_LASTNAME() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonInfoProxy_person_nameInfo_lastName");
  }

  @Override
  public By JPH_MARITAL_STATUS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonInfoProxy_person_maritalStatusCode");
  }

  @Override
  public By JPH_OCCUPATION() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonInfoProxy_person_occupationCd");
  }

  @Override
  public By JPH_RELATIONSHIP_TO_PROPOSER() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsured_relationshipToPrimaryInsured");
  }

  @Override
  public By SECOND_EMPLOYMENT_STATUS() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_PreconfigInsuredPersonInfoProxy_person_secondJobOptionCd\"]");
  }

  @Override
  public By SECOND_EMPLOYMENT_OCCUPATION() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_PreconfigInsuredPersonInfoProxy_person_secondJobDescriptionCd\"]");
  }

  @Override
  public By SECOND_EMPLOYMENT_INDUSTRY() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_PreconfigInsuredPersonInfoProxy_person_secondJobBusinessTypeCd\"]");
  }

  @Override
  public By ITEMS_IN_HOME_LIST() {
    return By.xpath("//tbody[@id=\"policyDataGatherForm" +
        ":dataGatherView_ListAgeaSpecifiedItemsInTheHome_data\"]/tr");
  }

  @Override
  public By ITEMS_AWAY_FROM_HOME_LIST() {
    return By.xpath("//tbody[@id=\"policyDataGatherForm" +
        ":dataGatherView_ListAgeaSpecifiedItemsAwayFromHome_data\"]/tr");
  }

  @Override
  public By BICYCLE_AWAY_FROM_HOME_LIST() {
    return By.xpath("//tbody[@id=\"policyDataGatherForm" +
        ":dataGatherView_ListAgeaHomeBicycleItem_data\"]/tr");
  }

  @Override
  public By SPECIFIED_ITEMS_AWAY_FROM_HOME_DESCRIPTION() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_AgeaSpecifiedItemsAwayFromHome_description\"]");
  }

  @Override
  public By SPECIFIED_ITEMS_AWAY_FROM_HOME() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_AgeaSpecifiedItemsAwayFromHome_specifiedItemName\"]");
  }

  @Override
  public By SPECIFIED_ITEM_VALUE_AWAY_FROM_HOME() {
    return By.cssSelector("[id=\"policyDataGatherForm:sedit_AgeaSpecifiedItemsAwayFromHome_amount\"]");
  }

  @Override
  public By SPECIFIED_ITEM_VALUE_IN_HOME() {
    return By.cssSelector("[id=\"policyDataGatherForm:sedit_AgeaSpecifiedItemsInTheHome_amount\"]");
  }

  @Override
  public By SPECIFIED_ITEMS_SUM_INSURED() {
    return By.cssSelector("[id=\"policyDataGatherForm:sedit_AgeaHomeSISIAFHCoverage_radarLimitStr\"]");
  }

  @Override
  public By ITEM_CHANGE_LINK() {
    return By.xpath("(//a[text()=\"Change\"])[<variable>]");
  }

  @Override
  public By CLAIMS_LIST() {
    return By.xpath("//tbody[@id=\"policyDataGatherForm:dataGatherView_ListPreconfigLossInfo_data" +
        "\"]/tr");
  }

  @Override
  public By CLAIM_INCIDENT_SOURCE() {
    return By.cssSelector("[id=\"policyDataGatherForm:sedit_PreconfigLossInfo_incidentSource\"]");
  }

  @Override
  public By CLAIM_INCIDENT_DATE() {
    return By.cssSelector("[id=\"policyDataGatherForm:sedit_PreconfigLossInfo_lossDateInputDate\"]");
  }

  @Override
  public By CLAIM_CLAIM_STATUS() {
    return By.cssSelector("[id=\"policyDataGatherForm:sedit_PreconfigLossInfo_statusOfClaim\"]");
  }

  @Override
  public By CLAIM_TYPE() {
    return By.cssSelector("[id=\"policyDataGatherForm:sedit_PreconfigLossInfo_lossTypeCd\"]");
  }

  @Override
  public By CLAIM_CAUSE() {
    return By.cssSelector("[id=\"policyDataGatherForm:sedit_PreconfigLossInfo_reason\"]");
  }

  @Override
  public By CLAIM_COST() {
    return By.cssSelector("[id=\"policyDataGatherForm:sedit_PreconfigLossInfo_lossAmount\"]");
  }

  @Override
  public By CLAIM_NUM() {
    return By.cssSelector("[id=\"policyDataGatherForm:sedit_PreconfigLossInfo_claim\"]");
  }

  @Override
  public By SUFFERED_LOSS_NOT_RESULTED_CLAIM() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_AgeaHomeClaimNonRtaConvictionsQuestionAnswer_yesNoAnswer\"]");
  }

  @Override
  public By BICYLCLE_TYPE() {
    return By.cssSelector("[id=\"policyDataGatherForm:sedit_AgeaHomeBicycleItem_specifiedItemName\"]");
  }

  @Override
  public By BICYLCLE_DESCRIPTION() {
    return By.cssSelector("[id=\"policyDataGatherForm:sedit_AgeaHomeBicycleItem_description\"]");
  }

  @Override
  public By BICYLCLE_VALUE() {
    return By.cssSelector("[id=\"policyDataGatherForm:sedit_AgeaHomeBicycleItem_amount\"]");
  }

  @Override
  public By SPECIFIED_ITEMS_IN_HOME_DESCRIPTION() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_AgeaSpecifiedItemsInTheHome_description\"]");
  }

  @Override
  public By JPH_TITLE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonInfoProxy_person_nameInfo_salutation");
  }

  @Override
  public By CORRESPONDENCE_FULL_ADDRESS() {
    return By.cssSelector("#productConsolidatedViewForm\\:scolumn_PreconfigInsured\\:0" +
        "\\:addressesAsStringCons");
  }

  @Override
  public By RISK_FULL_ADDRESS() {
    return By.cssSelector("#productConsolidatedViewForm\\:scolumn_PreconfigDwell\\:0" +
        "\\:addressLineCons");
  }

  @Override
  public By MISSING_FIELD_INFO_ERROR_MESSAGE() {
    return By.xpath("//div[@class=\"error-container\"]/following::span[contains(@id, " +
        "\"_error\") and @style=\"display: block;\"]");
  }

  @Override
  public By GET_POLICY_INFORMATION_LABEL() {
    return By.xpath("//tr[contains(@class,\"evenRow asterisk-aware-row\") or contains(@class," +
        "\"oddRow asterisk-aware-row\")]/td[1]/label");
  }

  @Override
  public By GET_MOTOR_POLICY_INFORMATION_VALUE() {
    return By.xpath("//tr[contains(@class,\"evenRow asterisk-aware-row\") or contains(@class," +
        "\"oddRow asterisk-aware-row\")]/td[2]");
  }

  @Override
  public By DRIVER_TAB() {
    return By.xpath("(//li[contains(@id,\"policyDataGatherForm:tabListList_\")" + "]//span" +
        "[normalize-space(text())=\"Driver\"])");
  }

  @Override
  public By CLAIMS_CONVICTION_SUMMARY_TAB() {
    return By.xpath("//li[contains(@id,\"policyDataGatherForm:tabListList_\")" + "]//span" +
        "[normalize-space(text())=\"Claims/Convictions Summary\"]");
  }

  @Override
  public By UNSPENT_CRIMINAL_CONVICTION() {
    return By.xpath("//label[text()=\"Unspent Criminal Convictions\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_TAB() {
    return By.xpath("//li[contains(@id,\"policyDataGatherForm:tabListList_\")" + "]//span" +
        "[normalize-space(text())=\"Vehicle\"]");
  }

  @Override
  public By PREMIUM_COVERAGES_TAB() {
    return By.xpath("//li[contains(@id,\"policyDataGatherForm:tabListList_\")" + "]//span" +
        "[normalize-space(text())=\"Premium & Coverages\"]");
  }

  @Override
  public By LIST_OF_DRIVERS() {
    return By.xpath("(//label[contains(text(),\"List of Drivers\")]/following::table/tbody)[1]/tr");
  }

  @Override
  public By DRIVER_CHANGE_LINK_DRIVER() {
    return By.xpath("((//label[contains(text(),\"List of Drivers\")]/following::table/tbody)" +
        "[1]/tr//a)[<variable>]");
  }

//  @Override
//  public By ADD_DRIVER_CHANGE_LINK_DRIVER(){
//    return By.xpath("//span[@title=\"Frequent\"]/following::a[1]");
//  }

  @Override
  public By TEMP_DRIVER() {
    return By.xpath("//label[text()=\"Temporary Driver\"]/following::span[1]");
  }

  @Override
  public By DRIVER_NAME() {
    return By.xpath("//label[text()=\"Driver Party Selection\"]/following::span[1]");
  }

  @Override
  public By DRIVER_TYPE() {
    return By.xpath("//label[text()=\"Driver Type\"]/following::span[1]");
  }

  @Override
  public By RESIDENCE_IN_UK_SINCE() {
    return By.xpath("//label[text()=\"Residence in UK since\"]/following::span[1]/input[1]");
  }

  @Override
  public By PREFERRED_DELIVERY() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_PreconfigInsuredPersonInfoProxy_person_preferredDeliveryCd\"]");
  }

  @Override
  public By FCA_CLASS() {
    return By.xpath("//label[text()=\"FCAClass\"]/following::span[1]");
  }

  @Override
  public By LICENCE_TYPE() {
    return By.xpath("//label[text()=\"Licence Type\"]/following::span[1]");
  }

  @Override
  public By LICENCE_OBTAIN_DATE() {
    return By.xpath("//label[contains(text(),\"get your Licence?\")]/following::span[1]/input[1]");
  }

  @Override
  public By HELD_DRIVING_LICENCE() {
    return By.xpath("//label[contains(text(),\"held your driving Licence?\")]/following::span[1]");
  }

  @Override
  public By ACCESS_TO_OTHER_DRIVER() {
    return By.xpath("//label[text()=\"Access to other vehicles\"]/following::span[1]");
  }

  //Cannot club with one above Locators are different -VD
  @Override
  public By ACCESS_TO_ANY_OTHER_VEHICLE() {
    return By.xpath("//label[contains(text(),\"access to any other vehicles?\")" + "]/following" + "::span[1]");
  }

  @Override
  public By ADD_DRIVER_RELATIONSHIP_TO_PROPOSER() {
    return By.xpath("//label[text()=\"Relationship to Proposer\"]/following::span[1]");
  }

  @Override
  public By ADD_DRIVER_DATE_OF_BIRTH() {
    return By.xpath("//label[text()=\"Date of Birth\"]/following::span[1]/input[1]");
  }

  @Override
  public By ADD_DRIVER_GENDER() {
    return By.xpath("//label[text()=\"Gender\"]/following::span[1]");
  }

  @Override
  public By ADD_DRIVER_MARITAL_STATUS() {
    return By.xpath("//label[text()=\"Marital Status\"]/following::span[1]");
  }

  @Override
  public By ADD_DRIVER_PRIMARY_EMPLOYMENT_STATUS() {
    return By.xpath("//label[text()=\"Employment Status\"]/following::span[1]");
  }

  @Override
  public By ADD_DRIVER_PRIMARY_OCCUPATION() {
    return By.xpath("//label[text()=\"Full Time Occupation\"]/following::span[1]");
  }

  @Override
  public By ADD_DRIVER_PRIMARY_INDUSTRY() {
    return By.xpath("//label[text()=\"Employer's business\"]/following::span[1]");
  }

  @Override
  public By ADD_DRIVER_SECONDARY_EMPLOYMENT_STATUS() {
    return By.xpath("//label[text()=\"Secondary Employment Status\"]/following::span[1]");
  }

  @Override
  public By SECONDARY_EMPLOYMENT_STATUS_FLAG() {
    return By.xpath("//label[text()=\"Secondary job?\"]/following::span[1]");
  }

  @Override
  public By SECOND_EMPLOYMENT_FLAG() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_PreconfigInsuredPersonInfoProxy_person_secondJobInd\"]");
  }

  @Override
  public By ADD_DRIVER_SECONDARY_EMPLOYER_OCCUPATION() {
    return By.xpath("//label[text()=\"Secondary Occupation Description\"]/following::span[1]");
  }

  @Override
  public By ADD_DRIVER_SECONDARY_EMPLOYMENT_INDUSTRY() {
    return By.xpath("//label[text()=\"Secondary Employer's Business\"]/following::span[1]");
  }

  @Override
  public By ADD_DRIVER_RESIDENCE_IN_UK_SINCE() {
    return By.xpath("//label[text()=\"Residence in UK since\"]/following::span[1]/input[1]");
  }

  @Override
  public By ADD_DRIVER_LICENSE_TYPE() {
    return By.xpath("//label[text()=\"Licence Type\"]/following::span[1]");
  }

  @Override
  public By ADD_DRIVER_LICENCE_OBTAIN_DATE() {
    return By.xpath("//label[contains(text(),\"get your Licence?\")]/following::span[1]/input[1]");
  }

  @Override
  public By ADD_DRIVER_HELD_DRIVING_LICENCE() {
    return By.xpath("//label[contains(text(),\"held your driving Licence?\")]/following::span[1]");
  }

  @Override
  public By LICENCE_NUMBER() {
    return By.xpath("//label[text()=\"Driver Licence Number\"]/following::span[1]");
  }

  @Override
  public By ADD_DRIVER_ACCESS_TO_OTHER_DRIVER() {
    return By.xpath("//label[text()=\"Access to other vehicles\"]/following::span[1]");
  }

  @Override
  public By RISK_ADDRESS_SAME_AS_CORRESPONDENCE_FLAG() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_PreconfigHomeRiskItemAddressContact_sameInsuredAddressInd\"]");
  }

  @Override
  public By PRIMARY_RESIDENCE() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_PreconfigPrimaryResidenceQuestionAnswer_yesNoAnswer\"]");
  }

  @Override
  public By OCCUPANCY_TYPE() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_PreconfigOccupancyTypeQuestionAnswer_otherAnswer\"]");
  }

  @Override
  public By PROPERTY_LEFT_UNOCCUPIED() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_AgeaPropertyUnoccupiedQuestionAnswer_otherAnswer\"]");
  }

  @Override
  public By NEIGHBOURHOOD_WATCH() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_PreconfigGuardedGatedCommunityQuestionAnswer_yesNoAnswer\"]");
  }

  @Override
  public By NON_FAMILY_LODGER() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_AgeaNonFamilyLodgersQuestionAnswer_yesNoAnswer\"]");
  }

  @Override
  public By BRUSH_FIRE_SURCHARGE() {
    return By.xpath("//span[@id=\"policyDataGatherForm:sedit_PreconfigBrush_brushFireSurchargeInd\"]");
  }

  @Override
  public By FREE_SUBSIDENCE_LANDSLIP() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_AgeaBuildingInfo_freeFromSubsidenceHeaveLandslipInd\"]");
  }

  @Override
  public By BUILDING_TYPE() {
    return By.xpath("//span[@id=\"policyDataGatherForm:sedit_AgeaBuildingInfo_buildingTypeCd\"]");
  }

  @Override
  public By HOUSE_TYPE() {
    return By.cssSelector("[id=\"policyDataGatherForm:sedit_AgeaBuildingInfo_houseTypeCd\"]");
  }

  @Override
  public By FREE_FROM_FLOODING() {
    return By.xpath("//span[@id=\"policyDataGatherForm:sedit_AgeaBuildingInfo_freeFromFloodingInd\"]");
  }

  @Override
  public By WALL_CONSTRUCTION() {
    return By.xpath("//label[text()=\"Type of Wall Construction\"]/following::span[1]"); // Value is not available
  }

  @Override
  public By ROOF_CONSTRUCTION() {
    return By.xpath("//label[text()=\"Type of Roof Construction\"]/following::span[1]"); // Value is not available
  }

  @Override
  public By FLAT_ROOF_PERCENTAGE() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_AgeaBuildingInfo_percentageOfFlatRoofCd\"]");
  }

  @Override
  public By FULL_ACCIDENTAL_COVER_BUILDING() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_AgeaHomeBuildingCoverOptions_accidentalDamageCoverOnYourBuildingsInd\"]");
  }

  @Override
  public By BUILDING_NCD() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_AgeaHomeBuildingCoverOptions_numberOfBuildingClaimFreeYearsHaveYouHad\"]");
  }

  @Override
  public By CONTENT_NCD() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_AgeaHomeContentCoverOptions_contentsClaimFreeYearsCount\"]");
  }
  @Override
  public By REBUILDING_COST() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_AgeaHomeBuildingCoverOptions_rebuildCost\"]");
  }

  @Override
  public By FULL_ACCIDENTAL_COVER_ON_CONTENT_VAR() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_AgeaHomeContentCoverOptions_accidentalDamageCoverOnYourContentsInd\"]");
  }

  @Override
  public By SAFE_INSTALLED() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_AgeaHomeContentCoverOptions_safeInstalledInd\"]");
  }

  @Override
  public By UNSPECIFIED_TEMS_AWAY_FROM_HOME() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_AgeaHomeContentCoverOptions_coverForOtherUnspecifiedItemsInd\"]");
  }

  @Override
  public By VALUABLE_IN_HOME_FLAG() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_AgeaHomeCoverSpecifiedItemsInTheHomeQuestionAnswer_yesNoAnswer\"]");
  }

  @Override
  public By VALUABLE_IN_HOME() {
    return By.cssSelector("[id=\"policyDataGatherForm:sedit_AgeaSpecifiedItemsInTheHome_amount\"]");
  }

  @Override
  public By VALUABLE_AWAY_HOME_FLAG() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_AgeaHomeSpecifiedItemsAwayFromHomeQuestionAnswer_yesNoAnswer\"]");
  }

  @Override
  public By BICYCLE_FLAG() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_AgeaHomeCoverBicycleItemAwayFromHomeQuestionAnswer_yesNoAnswer\"]");
  }
  @Override
  public By ENDORSEMENT_LIST() {
    return By.xpath("//div[@id=\"policyDataGatherForm" +
        ":selectedObjects_AgeaHomeAutomaticEndorsementsFormManager:content\"]//td[@class" +
        "=\"dataCell nameCell \"]");
  }

  @Override
  public By INSURANCE_TYPES() {
    return By.xpath("//span[@class=\"componentViewPanelHeader\"]");
  }

  @Override
  public By LIST_OF_INSURED_HOLDERS(){
    return By.xpath("//*[@id=\"policyDataGatherForm:dataGatherView_ListPreconfigInsured\"]/div[1" +
        "]/table/tbody/tr");
  }

  @Override
  public By CREDIT_CARD_LINK() {
    return By.xpath("//span[contains(normalize-space(text()) ,\"Credit Card Visa\")]");
  }

  @Override
  public By SPECIFIED_ITEMS_IN_HOME() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_AgeaSpecifiedItemsInTheHome_specifiedItemName\"]");
  }

  @Override
  public By BUNGLOW_TYPE() {
    return By.cssSelector("[id=\"policyDataGatherForm:sedit_AgeaBuildingInfo_bungalowTypeCd\"]");
  }


}

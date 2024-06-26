package PageObjects.EisVersion.V01;

import PageObjects.EisModel.EisMotorQuoteCreationLocatorModel;
import org.openqa.selenium.By;

public class EisMotorQuoteCreationLocatorLib implements EisMotorQuoteCreationLocatorModel {
  @Override
  public By VEHICLE_TAB() {
    return By.xpath("//span[contains(text(),\"Vehicle\")]/parent::a");
  }
  @Override
  public By SELECT_ENQUIRY() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_Policy_enquiry");
  }

  @Override
  public By SALES_CHANNEL() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_Policy_channelCd");
  }

  @Override
  public By MOTOR_PRODUCT_TYPE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_Policy_typeOfPolicyCd");
  }

  @Override
  public By MOTOR_SCHEME() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_Policy_schemeCd");
  }

  @Override
  public By AFFINITY_CODE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_Policy_affinityCd");
  }

  @Override
  public By COVER_TYPE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_Policy_coverageTypeCd");
  }

  @Override
  public By POLICY_START_DATE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_Policy_effectiveTimestampInputDate");
  }

  @Override
  public By DRIVING_RESTRICTIONS() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_Policy_drivingRestrictionsCd");
  }

  @Override
  public By NCD_FLAG() {
    return By.xpath("//*[@id=\"policyDataGatherForm:sedit_Policy_ncdChaseFlagInd:<variable>\"]");
  }

  @Override
  public By CONCERN_FLAG() {
    return By.xpath("//*[@id=\"policyDataGatherForm:sedit_Policy_concernFlagInd:<variable>\"]");
  }

  @Override
  public By RESIDENCY_SINCE_DATE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonInfoProxy_person_residenceUKSinceInputDate");
  }

  @Override
  public By EXTRA_CARS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaAdditionalInsuredInformation_numberOfExtraCars");
  }

  @Override
  public By VEHICLE_USAGE_BY_PROPOSER() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaAdditionalInsuredInformation_useOfVehicle");
  }

  @Override
  public By PREFERRED_PAYMENT_METHOD() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaAdditionalInsuredInformation_howToPayInsurance");
  }

  @Override
  public By HOME_OWNER() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaAdditionalInsuredInformation_homeOwner");
  }

  @Override
  public By AFFORDABILITY_THRESHOLD() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_AgeaAdditionalInsuredFinanceInformation_insuranceAffordabilityThresholdBreachedInd:<variable>\"]");
  }

  @Override
  public By PREMIUM_FINANCE_REKEY() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_AgeaAdditionalInsuredFinanceInformation_onlyPremiumFinanceRekeyInd:<variable>\"]");
  }

  @Override
  public By IAM_ORGANISATION() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_AgeaAdditionalInsuredInformation_iamMemberInd:<variable>\"]");
  }

  @Override
  public By PARTY_SEARCH_POPUP() {
    return By.cssSelector("#partySearchForm\\:partySearchPopup_container");
  }

  @Override
  public By PARTY_SEARCH_CANCEL() {
    return By.cssSelector("#partySearchForm\\:cancelBtn");
  }

  @Override
  public By VEHICLE_MARKET_VALUE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_PreconfigVehicle_ratingInfo_marketValue");
  }

  @Override
  public By MANUAL_SEARCH() {
    return By.cssSelector("#policyDataGatherForm\\:showVehicleManualSearchPopup");
  }

  @Override
  public By VEHICLE_MANUAL_SEARCH_POPUP() {
    return By.cssSelector("#policyDataGatherForm\\:vehicleManualSearchPopup");
  }

  @Override
  public By SELECT_VEHICLE_MAKE() {
    return By.cssSelector("#policyDataGatherForm\\:make");
  }

  @Override
  public By SELECT_VEHICLE_MODEL() {
    return By.cssSelector("#policyDataGatherForm\\:modelId");
  }

  @Override
  public By SELECT_FUEL_TYPE() {
    return By.cssSelector("#policyDataGatherForm\\:fuelType");
  }

  @Override
  public By ENTER_YEAR_OF_MANUFACTURE() {
    return By.cssSelector("#policyDataGatherForm\\:yearOfManufacture");
  }

  @Override
  public By VEHICLE_SEARCH_POPUP() {
    return By.cssSelector("#policyDataGatherForm\\:searchButton");
  }

  @Override
  public By NAVIGATE_VEHICLE_LIST() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":manualVehicleSearchResultTable_paginator_bottom\"]/span[4]");
  }

  @Override
  public By VEHICLE_MAKE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_PreconfigVehicle_baseInfo_manufacturer");
  }

  @Override
  public By NUMBER_OF_SEATS() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_PreconfigVehicle_numberOfSeats");
  }

  @Override
  public By VEHICLE_LIST() {
    return By.xpath("//*[@id=\"policyDataGatherForm:manualVehicleSearchResultTable_data\"]/tr");
  }

  @Override
  public By ABI_CODE_LIST() {
    return By.xpath("//*[@id=\"policyDataGatherForm:manualVehicleSearchResultTable_data\"]/tr" +
        "[<variable>]/td[1]");
  }

  @Override
  public By SELECT_VEHICLE_FROM_LIST() {
    return By.xpath("//*[@id=\"policyDataGatherForm:manualVehicleSearchResultTable_data\"]/tr" +
        "[<variable>]/td[13]");
  }

  @Override
  public By VEHICLE_MODEL() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_PreconfigVehicle_baseInfo_model");
  }

  @Override
  public By YEAR_OF_MANUFACTURE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_PreconfigVehicle_baseInfo_modelYear");
  }

  @Override
  public By FUEL_TYPE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_PreconfigVehicle_baseInfo_fuelTypeCd");
  }

  @Override
  public By ABI_CODE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_PreconfigVehicle_baseInfo_abiCd");
  }

  @Override
  public By SECONDARY_JOB() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_PreconfigInsuredPersonInfoProxy_person_secondJobInd:<variable>\"]");
  }

  @Override
  public By PREVIOUS_MOTOR_INSURANCE() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_PreconfigPolicyPriorCarrier_hasPriorCarrier:<variable>\"]");
  }
  @Override
  public By DRIVING_EXPERIENCE_NOT_IN_PROPOSER_NAME() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_PreconfigPolicyPriorCarrier_extDrivingExperience:<variable>\"]");
  }

  @Override
  public By CLAIM_FREE_YEARS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigPolicyPriorCarrier_yearsOfClaimsFree");
  }
  @Override
  public By TYPE_OF_EXPERIENCE() {
    return By.cssSelector("select#policyDataGatherForm" +
        "\\:sedit_PreconfigPolicyPriorCarrier_typeofExperienceCd");
  }
  @Override
  public By NCD_APPLIED_TO_OTHER_VEHICLES() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_PreconfigPolicyPriorCarrier_ncdNotUsedOnAnotherVehicle:<variable>\"]");
  }

  @Override
  public By PREVIOUS_POLICY_END_DATE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigPolicyPriorCarrier_carrierPolicyExpirationDateInputDate");
  }

  @Override
  public By TYPE_OF_INSURANCE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigPolicyPriorCarrier_typeOfInsuranceCd");
  }

  @Override
  public By NCD_DISCOUNT_YEARS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigPolicyPriorCarrier_yearsNoClaimsDiscount");
  }

  @Override
  public By PROTECT_NCD_CLAIM() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_PreconfigPolicyPriorCarrier_protectNoClaimsDiscount:<variable>\"]");
  }

  @Override
  public By ACCESS_TO_OTHER_VEHICLES() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigPolicyPriorCarrier_accessToOtherVehicles");
  }

  @Override
  public By LICENCE_TYPE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverLicense_license_licenceTypeCd");
  }

  @Override
  public By LICENCE_ISSUE_DATE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverLicense_license_licensedDtInputDate");
  }

  @Override
  public By LICENCE_NUMBER() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverLicense_license_licensePermitNumber");
  }

  @Override
  public By ADD_CLAIM() {
    return By.cssSelector("#policyDataGatherForm\\:addAgeaAutoDrivingRecordClaims");
  }

  @Override
  public By CLAIM_INCIDENT_DATE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaAutoDrivingRecordClaims_claimDtInputDate");
  }

  @Override
  public By CLAIM_STATUS() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_AgeaAutoDrivingRecordClaims_claimStatus");
  }

  @Override
  public By CLAIM_TYPE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_AgeaAutoDrivingRecordClaims_claimType");
  }

  @Override
  public By CLAIM_CAUSE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_AgeaAutoDrivingRecordClaims_claimCause");
  }

  @Override
  public By OWN_DAMAGE_COST() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaAutoDrivingRecordClaims_ownDamageCosts");
  }

  @Override
  public By THIRD_PARTY_DAMAGE_COST() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaAutoDrivingRecordClaims_thirdPartyDamageCosts");
  }

  @Override
  public By NCD_AFFECTED() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_AgeaAutoDrivingRecordClaims_ncdAffectedInd:<variable>\"]");
  }

  @Override
  public By UNDER_POLICYHOLDERS_COVER() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_AgeaAutoDrivingRecordClaims_underThisPolicyHoldersCoverInd:<variable>\"]");
  }

  @Override
  public By PERSONAL_INJURY() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_AgeaAutoDrivingRecordClaims_personalInjuryInd:<variable>\"]");
  }

  @Override
  public By ADD_CONVICTIONS() {
    return By.cssSelector("#policyDataGatherForm\\:addAgeaAutoDriverConvictions");
  }

  @Override
  public By CONVICTION_TYPE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_AgeaAutoDriverConvictions_convictionType");
  }

  @Override
  public By OFFENCE_DATE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaAutoDriverConvictions_offenceDateInputDate");
  }

  @Override
  public By CONVICTION_DATE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaAutoDriverConvictions_convictionDateInputDate");
  }

  @Override
  public By MOTORING_POINTS() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_AgeaAutoDriverConvictions_points");
  }

  @Override
  public By DISQUALIFIED() {
    return By.xpath("//*[@id=\"policyDataGatherForm:sedit_AgeaAutoDriverConvictions_disqualified" +
        ":<variable>\"]");
  }

  @Override
  public By MOTORING_FINE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_AgeaAutoDriverConvictions_fine");
  }

  @Override
  public By SUSPENSION_MONTH() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_AgeaAutoDriverConvictions_mouthSuspended");
  }

  @Override
  public By OFFENCE_DATE_DISPLAY() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaAutoDriverConvictions_offenceDateDisplay");
  }

  @Override
  public By CONVICTION_DATE_DISPLAY() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaAutoDriverConvictions_convictionDateDisplay");
  }

  @Override
  public By ADD_NEW_DRIVER() {
    return By.xpath("//input[@value=\"Add New Driver\"]");
  }

  @Override
  public By DRIVER_PARTY_SELECTION() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_PreconfigAutoDriver_partySelection");
  }

  @Override
  public By DRIVER_TYPE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_PreconfigAutoDriver_driverTypeCd");
  }

  @Override
  public By DRIVER_RELATIONSHIP_TO_PROPOSER() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriver_driverRelToApplicantCd");
  }

  @Override
  public By ADDITIONAL_DRIVER_TITLE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverPersonInfoProxy_person_nameInfo_salutation");
  }

  @Override
  public By ADDITIONAL_DRIVER_FIRSTNAME() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverPersonInfoProxy_person_nameInfo_firstName");
  }

  @Override
  public By ADDITIONAL_DRIVER_LASTNAME() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverPersonInfoProxy_person_nameInfo_lastName");
  }

  @Override
  public By ADDITIONAL_DRIVER_DOB() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverPersonInfoProxy_person_dateOfBirthInputDate");
  }

  @Override
  public By ADDITIONAL_DRIVER_GENDER() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverPersonInfoProxy_person_genderCd");
  }

  @Override
  public By ADDITIONAL_DRIVER_MARITAL_STATUS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverPersonInfoProxy_person_maritalStatusCode");
  }

  @Override
  public By ADDITIONAL_DRIVER_EMP_STATUS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverPersonInfoProxy_person_employmentStatusCd");
  }

  @Override
  public By ADDITIONAL_DRIVER_OCCUPATION() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverPersonInfoProxy_person_occupationCd");
  }

  @Override
  public By ADDITIONAL_DRIVER_EMP_BUSINESS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverPersonInfoProxy_person_businessTypeCd");
  }

  @Override
  public By ADDITIONAL_DRIVER_SECOND_JOB() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_PreconfigAutoDriverPersonInfoProxy_person_secondJobInd:<variable>\"]");
  }

  @Override
  public By AD_SECOND_JOB_BUSINESS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverPersonInfoProxy_person_secondJobBusinessTypeCd");
  }

  @Override
  public By AD_SECOND_JOB_STATUS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverPersonInfoProxy_person_secondJobOptionCd");
  }

  @Override
  public By AD_SECOND_JOB_DESCRIPTION() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverPersonInfoProxy_person_secondJobDescriptionCd");
  }

  @Override
  public By AD_RESIDENCE_IN_UK() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverPersonInfoProxy_person_residenceUKSinceInputDate");
  }

  @Override
  public By AD_PREFERRED_DELIVERY() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverPersonInfoProxy_person_preferredDeliveryCd");
  }


  @Override
  public By ADDITIONAL_DRIVER_ACCESS_TO_OTHER_VEHICLES() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoDriverLicense_accessToOtherVehicles");
  }

  @Override
  public By ADD_NEW_VEHICLE() {
    return By.cssSelector("#policyDataGatherForm\\:addPreconfigVehicle");
  }

  @Override
  public By ADD_VEHICLE_REG_NUMBER() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_PreconfigVehicle_baseInfo_registrationNo");
  }

  @Override
  public By SEARCH_VEHICLE() {
    return By.cssSelector("#policyDataGatherForm\\:searchRegistrationNo");
  }

  @Override
  public By MANUAL_SEARCH_VEHICLE() {
    return By.cssSelector("#policyDataGatherForm\\:showVehicleManualSearchPopup");
  }

  @Override
  public By VEHICLE_ALARM() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_VehicleFeatureComponent_baseInfo_alarm");
  }

  @Override
  public By IMMOBILISER() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_VehicleFeatureComponent_baseInfo_immobiliser");
  }

  @Override
  public By IMMOBILISER_YES_NO() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_VehicleFeatureComponent_baseInfo_immobiliserFittedInd:<variable>\"]");
  }

  @Override
  public By TRACKER() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_VehicleFeatureComponent_baseInfo_tracker");
  }

  @Override
  public By DASHCAM() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_VehicleFeatureComponent_baseInfo_dashCamFitted");
  }

  @Override
  public By LEFT_HAND_DRIVE() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_VehicleFeatureComponent_baseInfo_leftHandDriveInd:<variable>\"]");
  }

  @Override
  public By IS_VEHICLE_IMPORTED() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_VehicleFeatureComponent_baseInfo_importedVehicleInd");
  }

  @Override
  public By IS_VEHICLE_MODIFIED() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_VehicleFeatureComponent_baseInfo_carModifiedFromManufacturersStandardInd" +
        ":<variable>\"]");
  }

  @Override
  public By ADD_MODIFICATION() {
    return By.cssSelector("#policyDataGatherForm\\:addAgeaAutoVehicleModifications");
  }

  @Override
  public By VEHICLE_MODIFICATION() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaAutoVehicleModifications_accessoryType");
  }

  @Override
  public By VEHICLE_USAGE() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_VehicleUseDetailComponent_usage");
  }

  @Override
  public By ANNUAL_MILEAGE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_VehicleUseDetailComponent_ratingInfo_annualMiles");
  }

  @Override
  public By BUSINESS_MILEAGE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_VehicleUseDetailComponent_businessMileage");
  }

  @Override
  public By VEHICLE_PURCHASE_DATE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_VehicleAdditionalInformationComponent_ratingInfo_purchaseDateInputDate");
  }

  @Override
  public By DAY_PARKING() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaAutoVehicleKeptDuringDayQuestionAnswer_otherAnswer");
  }

  @Override
  public By NIGHT_PARKING() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaAutoVehicleKeptDuringNightQuestionAnswer_otherAnswer");
  }

  @Override
  public By CLAIM_ERROR_POPUP() {
    return By.cssSelector("#errorsForm\\:back");
  }

  @Override
  public By OVERNIGHT_PARKING() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaAutoVehicleOvernightLocationQuestionAnswer_otherAnswer");
  }

  @Override
  public By PARKING_POSTCODE() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_AgeaAutoVehicleKeptPostcodeQuestionAnswer_otherAnswer");
  }

  @Override
  public By VEHICLE_OWNER() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoRegisteredOwner_typeOfVehicleOwnerCd");
  }

  @Override
  public By PROPOSER_REGISTERED_KEEPER() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_PreconfigAutoRegisteredOwner_proposerRegisteredKeeperInd:<variable>\"]");
  }

  @Override
  public By TYPE_REGISTERED_KEEPER() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigAutoRegisteredOwner_typeOfRegisteredKeeperCd");
  }

  @Override
  public By PROPOSER_EMP_STATUS() {
    return By.cssSelector("#policyDataGatherForm" +
        "\\:sedit_PreconfigInsuredPersonInfoProxy_person_employmentStatusCd");
  }

  @Override
  public By VOLUNTARY_EXCESS() {
    return By.cssSelector("#policyDataGatherForm\\:sedit_AgeaAutoCoverageExcess_voluntaryExcess");
  }

  @Override
  public By PACKAGE_CHANGE() {
    return By.cssSelector("#policyDataGatherForm\\:refreshPackageInd_AgeaOpenLAutoCoverageManager");
  }

  @Override
  public By PACKAGE_CONFIRM() {
    return By.cssSelector("#policyDataGatherForm\\:j_id_1_25_47_2_1f_2_d_6_1_1_d");
  }

  @Override
  public By ACCIDENTAL_DAMAGE() {
    return By.cssSelector("#policyDataGatherForm\\:accordionPanel_AgeaMotorVEADCoverage" +
        "\\:sedit_AgeaMotorVEADCoverage_inner_deductibleAmount");
  }

  @Override
  public By CONSENT_TO_RENEW() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_AgeaAutoConsentToRenewComponent_consentToRenewInd:<variable>\"]");
  }

  @Override
  public By QUOTE_REF_NUMBER() {
    return By.xpath("//span[contains(text(), \"Quote # :\")]");
  }


  @Override
  public By NCD_HOME_MANY_YEARS_ON_OTHER_VEHICLE() {
    return By.xpath("//label[normalize-space(text())='How many years'' NCD do you have on your " +
        "other vehicle']/following::input[1]");
  }


  public By NCD_MANY_YEARS_ON_OTHER_VEHICLE() {
    return By.xpath("//label[contains(text(),\"NCD do you have on your other vehicle\")" +
        "]/following::input[1]");
  }


  @Override
  public By NUMBER_OF_DOORS() {
    return By.xpath("//label[normalize-space(text())='Number of Doors']/following::input[1]");
  }

  @Override
  public By VEHICLE_FITTED_WITH_RACKING_YES() {
    return By.xpath("//input[@id='policyDataGatherForm" +
        ":sedit_VehicleFeatureComponent_baseInfo_rackingFittedInd:0' and  @value='true']");
  }

  @Override
  public By VEHICLE_FITTED_WITH_RACKING_NO() {
    return By.xpath("//input[@id='policyDataGatherForm" +
        ":sedit_VehicleFeatureComponent_baseInfo_rackingFittedInd:1' and  @value='false']");
  }

  @Override
  public By DOES_VEHICLE_CARRY_SIGNAGE_YES() {
    return By.xpath("//input[@id='policyDataGatherForm" +
        ":sedit_VehicleFeatureComponent_baseInfo_carryAnySignageInd:0' and @type='radio' and " +
        "@value='true']");
  }

  @Override
  public By DOES_VEHICLE_CARRY_SIGNAGE_NO() {
    return By.xpath("//input[@id='policyDataGatherForm" +
        ":sedit_VehicleFeatureComponent_baseInfo_carryAnySignageInd:1' and @type='radio' and " +
        "@value='false']");
  }

  @Override
  public By FOR_SOCIAL_AND_PLEASURE_YES() {
    return By.xpath("//input[@id='policyDataGatherForm" +
        ":sedit_VehicleUseDetailComponent_purelyForDomesticAndPleasureInd:0' and @type='radio' " +
        "and @value='true']");
  }

  @Override
  public By FOR_SOCIAL_AND_PLEASURE_NO() {
    return By.xpath("//input[@id='policyDataGatherForm" +
        ":sedit_VehicleUseDetailComponent_purelyForDomesticAndPleasureInd:1' and @type='radio' " +
        "and @value='false']");
  }

  @Override
  public By PUBLIC_LIABILITY_IN_FORCE_YES() {
    return By.xpath("//input[@id='policyDataGatherForm" +
        ":sedit_AgeaAutoPublicLiabilityInForceQuestionAnswer_yesNoAnswer:0' and @type='radio' and" +
        " @value='true']");
  }

  @Override
  public By PUBLIC_LIABILITY_IN_FORCE_NO() {
    return By.xpath("//input[@id='policyDataGatherForm" +
        ":sedit_AgeaAutoPublicLiabilityInForceQuestionAnswer_yesNoAnswer:1' and @type='radio' and" +
        " @value='false']");
  }

  @Override
  public By WILL_VEHICLE_CARRY_HAZARDOUS_GOODS_YES() {
    return By.xpath("//input[@id='policyDataGatherForm" +
        ":sedit_AgeaAutoVehicleCarryHazardousGoodsQuestionAnswer_yesNoAnswer:0' and @type='radio'" +
        " and @value='true']");
  }

  @Override
  public By WILL_VEHICLE_CARRY_HAZARDOUS_GOODS_NO() {
    return By.xpath("//input[@id='policyDataGatherForm" +
        ":sedit_AgeaAutoVehicleCarryHazardousGoodsQuestionAnswer_yesNoAnswer:1' and @type='radio'" +
        " and @value='false']");
  }

  @Override
  public By WHAT_TYPE_OF_POLICY_NCD_MIRRORED_FROM() {
    return By.xpath("//label[text()='What type of policy is the NCD being mirrored " +
        "from?']/following::select[1]");
  }

  //    @Override
//    public By NUMBER_OF_SEATS(){
//        return By.xpath("//label[normalize-space(text())='Number of Seats']/following::input[1]");
//    }
  @Override
  public By VEHICLE_FITTED_WITH_RACKING() {
    return By.xpath("//input[@id='policyDataGatherForm" +
        ":sedit_VehicleFeatureComponent_baseInfo_rackingFittedInd:<variable>']");
  }

  @Override
  public By DOES_VEHICLE_CARRY_SIGNAGE() {
    return By.xpath("//input[@id='policyDataGatherForm" +
        ":sedit_VehicleFeatureComponent_baseInfo_carryAnySignageInd:<variable>']");
  }

  @Override
  public By FOR_SOCIAL_AND_PLEASURE() {
    return By.xpath("//input[@id='policyDataGatherForm" +
        ":sedit_VehicleUseDetailComponent_purelyForDomesticAndPleasureInd:<variable>']");
  }

  @Override
  public By WHEN_DID_YOU_BUY_YOUR_CAR() {
    return By.xpath("//label[normalize-space(text())='When did you buy your " +
        "car?']/following::input[1]");
  }

  @Override
  public By PUBLIC_LIABILITY_IN_FORCE() {
    return By.xpath("//input[@id='policyDataGatherForm" +
        ":sedit_AgeaAutoPublicLiabilityInForceQuestionAnswer_yesNoAnswer:<variable>']");
  }

  @Override
  public By WILL_VEHICLE_CARRY_HAZARDOUS_GOODS() {
    return By.xpath("//input[@id='policyDataGatherForm" +
        ":sedit_AgeaAutoVehicleCarryHazardousGoodsQuestionAnswer_yesNoAnswer:<variable>']");
  }


  @Override
  public By ENTER_YEAR_OF_MANUFACTURE_VAN() {
    return By.xpath("(//label[contains(text(),\"Year of Manufacture\")]/following::input[1])[2]");
  }

  @Override
  public By OPEX_EXTRAS_OK() {
    return By.cssSelector("#policyDataGatherForm\\:AgeaAutoOpenLAncillariesView_okBtn");
  }

  @Override
  public By PREVIOUS_INSURANCE_REFUSED() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_AgeaAdditionalInsuredInformation_insurancePreviouslyRefusedInd:<variable>\"]");
  }

  @Override
  public By NON_RTA_CONVICTIONS() {
    return By.xpath("//*[@id=\"policyDataGatherForm" +
        ":sedit_AgeaAutoDriverNonRTAConvictionsViewOnly_nonRTAConvictions:<variable>\"]");
  }
}

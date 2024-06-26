package activities;

public class CommonControlDataDefns {

  public static final String JPH_DATE_OF_BIRTH = "What'sTheirDateOfBirth?";
  public static final String JPH_EMPLOYMENT_STATUS = "What'sTheirEmploymentStatus?";
  public static final String JPH_SECOND_JOB = "DoTheyHaveASecondJob?";
  public static final String JPH_RELATIONSHIP_TO_YOU = "What'sTheirRelationshipToYou?";
  public static final String INSURED_HOUSE_HOLD_CONTENT_LIMIT_VAR = "Max.ClaimLimitForValuablesInTheHome";
  public static final String EARLIEST_ALLOWED_MTA_DATE = "EarliestAllowedMtaDate";

  public enum E_ControlDataSource {
    ControlData, TestInstanceDataStore
  }

  public static final String KEY_PROTECTION = "KeyProtection";
  public static final String REPLACEMEMT_VEHICLE = "ReplacementVehicle" ;
  public static final String BREAKDOWN_COVER = "BreakdownCover";


  public static final String RAW_DATA = "RawData";
  public static final String NORMALIZED_DATA = "NormalizedData";
  public static final String CUSTOMER_POLICY_DETAILS = "CustomerPolicyDetailOnEis";
  public static final String NO_VALUE = "NoValue";
  public static final String UNIVERSAL_VIEW = "UniversalView";
  public static final String POLICY_ADMIN_SYS_VIEW = "PolAdminSysView";
  public static final String ADDITIONAL_INFO = "AdditionalInfo";

  public static final String WEBSITE_ROOT = "PortalLoginURL";
  public static final String PORTAL_URL_AGEAS = "PortalLoginURL_Ageas";
  public static final String PORTAL_URL_RIAS = "PortalLoginURL_Rias";

  public static final String CUSTOMER_CREDENTIALS = "CustomerCredentials";
  public static final String EMAIL = "Email";
  public static final String PASSWORD = "Password";
  public static final String SALES_DETAILS_VAR = "SalesDetails";
  public static final String INSURANCE_DETAILS = "InsuranceDetails";
  public static final String PROPOSER_PERSONAL_DETAILS = "ProposerPersonalDetails";
  public static final String PROPOSER_CONTACT_DETAILS = "ProposerContactDetails";
  public static final String PRIMARY_EMPLOYMENT_STATUS_VAR = "PrimaryEmploymentStatus";
  public static final String PRIMARY_EMPLOYMENT_TYPE_VAR = "Type";
  public static final String SECOND_EMPLOYMENT_STATUS_VAR = "SecondaryEmploymentStatus";


  public static final String HOME_QUOTE = "Home";
  public static final String MOTOR_QUOTE = "Motor";
  public static final String PRIVATE_CAR = "Private car";
  public static final String VAN_QUOTE = "Van";
  public static final String QUOTE_DETAILS = "QuotesDetails";
  public static final String EIS_CLIENT_DETAILS = "EisClientDetails";
  public static final String POLICY_DETAILS="PolicyDetails";
  public static final String EIS_VEHICLE_DETAILS = "EisVehicleDetails";
  public static final String QUOTE_DET = "QuoteDetails";
  public static final String QUOTE_REF = "QuoteReference";
  public static final String QUOTE_VALUE = "QuoteValue";
  public static final String DECLINES = "Declines";
  public static final String REFERRALS = "Referrals";
  public static final String BUILDING_EXCESS = "BuildingExcess";
  public static final String MONTHLY_PAYMENT = "MonthlyPayment";
  public static final String CONTENT_EXCESS = "ContentExcess";
  public static final String ANNUAL_PAYMENT = "AnnualPayment";
  public static final String EXTRA_HOME_COVER_VALUE = "ExtraHomeCoverValue";
  public static final String INSURANCE_TYPE = "Type";
  public static final String POLICY_NUMBER = "PolicyNumber";
  public static final String STATUS = "Status";
  public static final String IS_PAYMENT_SUCCESSFUL = "PaymentSuccessful";
  public static final String CUSTOMER_NUMBER = "CustomerNumber";
  public static final String FIRST_NAME = "Firstname";
  public static final String JPH_FIRST_NAME_VAR = "What'sTheirFirstName?";
  public static final String LAST_NAME = "Lastname";
  public static final String POSTCODE = "Postcode";
  public static final String CLIENT_NUM = "ClientNumber";
  public static final String WEB_REF = "WebReference";
  public static final String DATE_OF_BIRTH = "DateOfBirth";
  public static final String EMAIL_ADDRESS_VAR = "Emailaddress";
  public static final String EMAIL_ADDRESS = "EmailAddress";
  public static final String VEHICLE_DETAILS = "VehicleDetails";
  public static final String VEHICLE_CLAIMS_CONVICTION_SUMMARY = "VehicleClaims&ConvictionsSummary";
  public static final String HOME_CLAIMS_SUMMARY = "HomeClaimsSummary";
  public static final String INTERESTED_PARTIES = "InterestedParties";
  public static final String CLAIMS = "Claims";
  public static final String CONVICTIONS = "Convictions";

  // HOME POLICY VARIABLE:
  public static final String OWNERSHIP_TYPE = "OwnershipType";
  public static final String PROPERTY_LET_SUBLET_VAR = "IsThePropertyLet/sublet?";
  public static final String PROPERTY_LET_SUBLET_FLAG = "PropertyLetSublet";
  public static final String BUILDING_WORK_FLAG_VAR = "AnyBuildingWork?";
  public static final String BUILDING_WORK_FLAG = "BuildingWork";
  public static final String GOOD_REPAIR_VAR = "InGoodRepair?";
  public static final String GOOD_REPAIR_FLAG = "GoodRepair";
  public static final String CONSTRUCTION_TYPE = "ConstructionType";
  public static final String OCCUPANCY_TYPE = "OccupancyType";
  public static final String PROPERTY_LEFT_UNOCCUPIED_VAR = "HowLongIsThePropertyLeftUnoccupied?";
  public static final String PROPERTY_LEFT_UNOCCUPIED = "PropertyLeftUnoccupiedDuration";
  public static final String PROPERTY_LEFT_OCCUPIED_VAR ="WhenIsYourHomeNormallyOccupied?";
  public static final String BUSINESS_USE = "BusinessUse";
  public static final String HOME_BUSINESS_PURPOSE_FLAG_VAR =
      "IsAnyPartOfYourHomeUsedForBusinessPurposes?";
  public static final String DOOR_LOCKS_VAR = "Door/windowLocks";
  public static final String DOOR_LOCKS = "DoorOrWindowLocks";
  public static final String INTRUDER_ALARM_VAR = "IsAnIntruderAlarmInstalled?";
  public static final String INTRUDER_ALARM = "IntruderAlarm";
  public static final String NEIGHBOURHOOD_WATCH = "NeighbourhoodWatch";
  public static final String BRUSH_FIRE_SURCHARGE_VAR = "BrushFireSurcharge?";
  public static final String BRUSH_FIRE_SURCHARGE = "BrushFireSurcharge";
  public static final String FREE_SUBSIDENCE_LANDSLIP_FLAG_VAR =
      "FreeFromSubsidence,Heave,LandslipAndFreeFromNeighboringSubsidencePast/presentSubsidenceMonitoring?";
  public static final String FREE_SUBSIDENCE_LANDSLIP_FLAG = "FreeFromOtherThreats";

  public static final String LISTED_BUILDING_VAR = "IsYourHomeAListedBuilding?";
  public static final String LISTED_BUILDING_FLAG = "ListedBuilding";
  public static final String WALL_CONSTRUCTION = "TypeOfWallConstruction";
  public static final String EXTERNAL_WALL_MADE_FROM = "WhatAreTheExternalWallsMadeFrom?";
  public static final String EXTERNAL_ROOF_MADE_FROM ="What’sTheRoofMadeOf?";
  public static final String ROOF_CONSTRUCTION = "TypeOfRoofConstruction";
  public static final String PERCENTAGE_FLAT_ROOF_VAR =
      "ApproximatelyWhatPercentageOfYourRoofIsFlat?";
  public static final String PERCENTAGE_FLAT_ROOF = "ApproxPercentageOfFlatRoof";
  public static final String PERCENT_FLAT_ROOF_VAR =
      "ApproximatelyWhatPercentageOfTheRoofIsFlat?";
  public static final String TYPE_OF_HOUSE_HOLDE_COVER = "TypeOfHouseHoldCover";
  public static final String BUILDING_TYPE_VAR = "BuildingType";
  public static final String SEARCH_CRITERIA = "SearchCriteria";
  public static final String QUOTE_REFERENCE = "QuoteReference";
  public static final String CLIENT_NUMBER = "ClientNumber";
  public static final String EFFECTIVE_DATE = "EffectiveDate";
  public static final String MTAEFFECTIVEDATE = "MTAEffectiveDate";
  public static final String ADJUSTMENT = "Adjustment";
  public static final String MTA_TOTAL_SELLING_PRICE = "MTATotalSellingPrince";
  public static final String CONSENT_TO_RENEW = "ConsentToRenew";
  public static final String CLAIM_HIST_FLAG = "ClaimHistoryAvailable";
  public static final String OPTIONAL_EXTRAS = "OptionalExtras";
  public static final String PREMIUM_DETAILS = "PremiumDetails";
  public static final String EXCESS_PROTECTION = "ExcessProtection";
  public static final String HOME_EMERGENCY = "HomeEmergency";
  public static final String LEGAL_EXPENSES = "LegalExpenses";
  public static final String ENDORSEMENT = "Endorsement";

  public static final String NUM_OF_BEDROOM = "NumberOfBedrooms";
  public static final String NUM_OF_BEDROOM_VAR = "Bedrooms";
  public static final String NUM_OF_BATHROOMS_VAR = "Bathrooms";
  public static final String NUM_OF_BATHROOM_VAR = "NumberOfBathrooms/ensuites";
  public static final String NUM_OF_BATHROOM = "NumberOfBathrooms";
  public static final String BUILDING_VAR = "Buildings";
  public static final String BUILDING_INCLUDING_ACCIDENTAL_DAMAGE = "Buildings" +
      "(includingAccidentalDamage)";
  public static final String CONTENTS_VAR = "Contents";
  public static final String TYPE_OF_HOUSEHOLD_COVER = "TypeOfHouseHoldCover";
  public static final String TYPE_OF_HOUSEHOLD_COVER_VAR = "TypeOfHouseholdCoverRequired";
  public static final String BUILDING_DETAILS = "BuildingDetails";
  public static final String BUILDING_TYPE = "BuildingType";
//  public static final String BUILDING_TYPE_VAR = "WhatTypeOfBungalowIsIt?";

  public static final String BUILDING_TYPE_BUNGLOW_TYPE_VAR = "WhatTypeOfBungalowIsIt?";
  public static final String HOUSE_TYPE_VAR = "WhatTypeOfHouseIsIt?";
  public static final String HOUSE_TYPE = "HouseType";
  public static final String TOWN_HOUSE_TYPE_VAR = "WhatTypeOfTownHouseIsIt?";
  public static final String TOWN_HOUSE_TYPE = "TownHouseType";
  public static final String TYPE_OF_FLAT_VAR ="WhatTypeOfFlatIsIt?";
  public static final String TYPE_OF_FLAT ="FlatType";
  public static final String PRIMARY_RESIDENCE_VAR = "PrimaryResidence?";
  public static final String PRIMARY_RESIDENCE = "PrimaryResidence";
  public static final String ADDRESS = "Address";
  public static final String RISK_ADDRESS = "RiskAddress";
  public static final String  INSURED_ADDRESS = "InsuredAddress";
  public static final String INSURED_HOME_SPECIFIC_DETAILS = "InsuredHomeSpecificDetails";
  public static final String CORRESPONDENCE_ADDRESS = "CorrespondenceAddress";
  public static final String RISK_ADD_SAME_AS_CORRESPONDENCE_ADDRESS =
      "IsTheRiskAddressTheSameAsCorrespondenceAddress?";
  public static final String RISK_ADD_SAME_AS_CORRESPONDENCE_ADDRESS_FLAG =
      "RiskAddressSameAsCorrespondenceAddress";
  public static final String ADDITIONAL_INFORMATION_VAR = "AdditionalInformation";
  public static final String HOUSE_IDENTIFIER_VAR = "HouseIdentifier";

  public static final String CATEGORY_VAR = "Category";
  public static final String PRIM_JOB_CATEGORY_EMPLOYEE_VAR = "Employee";
  public static final String PRIM_JOB_CATEGORY_SELF_EMPLOYEE_VAR = "Self Employee";
  public static final String PRIM_JOB_CATEGORY_SELF_EMPLOYED_VAR = "Self Employed";
  public static final String JOB_CATEGORY_EMPLOYED_VAR = "Employed";
  public static final String PRIM_JOB_CATEGORY_UNEMPLOYED_VAR = "Unemployed";
  public static final String JOINT_POLICY_HOLDER_STATUS = "JointPolicyHolderStatus";

  public static final String OTHER_DETAILS = "OtherDetails";
  public static final String SUFFERED_LOSS_NOT_RESULTED_CLAIM = "SufferedLossNotResultedInClaim";
  public static final String SUFFERED_LOSS_NOT_RESULTED_CLAIM_VAR =
      "HaveYouOrAnyoneLivingWithYouSufferedLossesOrIncidentsWhichDidNotResultInAClaim";
  public static final String OTHER_VAR = "Other";
  public static final String NUM_PEOPLE_LIVE = "NumberOfPeopleLive";
  public static final String NON_FAMILY_LODGER = "NonFamilyLodger";
  public static final String NON_FAMILY_LODGER_VAR = "NonFamilyLodgers";
  public static final String ADULT_VAR = "Adult";
  public static final String CHILDREN_VAR = "Children";
  public static final String PET_VAR = "Pet";
  public static final String CAT_VAR = "Cat";
  public static final String DOG_VAR = "Dog";


  public static final String TITLE = "Title";
  public static final String FIRST_NAME_VAR = "FirstName";
  public static final String LAST_NAME_VAR = "LastName";
  public static final String JPH_LAST_NAME_VAR = "What’sTheirSurname?";
  public static final String JPH_MARITAL_STATUS = "What'sTheirMaritalStatus?";
  public static final String SURNAME = "Surname";
  public static final String GENDER = "Gender";
  public static final String MARITAL_STATUS_VAR = "MaritalStatus";
  public static final String JOINT_POLICY_HOLDER_DET = "JointPolicyHolderDetails";


  public static final String MARKETING_CHOICE_VAR = "MarketingChoice";
  public static final String MARKETING_CHOICE_SMS_VAR = "SMS";
  public static final String MARKETING_CHOICE_EMAIL_VAR = "Email";
  public static final String MARKETING_CHOICE_POSTAL_VAR = "Postal";
  public static final String MARKETING_CHOICE_TELEPHONE_VAR = "Telephone";
  public static final String POST_CODE_VAR = "Postcode";
  public static final String POST_CODE_REGEX = "([A-Z]{1,2}\\d[A-Z\\d]? ?\\d[A-Z]{2}|GIR ?0A{2})$";

  public static final String PREMIUM_AFTER_PREMIUM_AFFECTING_OPERATION = "premium";
  public static final String EIS_CORE_USERNAME = "EisUserName";
  public static final String EIS_CORE_PASSWORD = "EisPassword";
  public static final String EIS_CORE_CREDENTIALS = "EisCredentials";

  public static final String PRIMARY_EMPLOYMENT_DET = "Primary";
  public static final String SECOND_EMPLOYMENT_DET = "Secondary";
  public static final String EMPLOYMENT_DET = "EmploymentDetails";
  public static final String EMPLOYMENT_STATUS = "EmploymentStatus";
  public static final String OCCUPATION = "Occupation";
  public static final String INDUSTRY = "Industry";
  public static final String POLICY_HOLDER_PERSONAL_DET = "PolicyHolderPersonalDetails";
  public static final String POLICY_HOLDER_MOTOR_SPECIFIC_DET = "PolicyHolderMotorSpecificDetails";
  public static final String INSURANCE_DET = "InsuranceDetails";
  public static final String PREFERRED_DELIVERY_METHOD = "PreferredDeliveryMethod";
  public static final String VEHICLE = "Vehicle";
  public static final String PERMANENT_DRIVER = "PermanentDriver";
  public static final String EMPLOYED = "Employed";
  public static final String EMP_CATEGORY = "Category";
  public static final String EMP_TYPE = "Type";
  public static final String EMP_INDUSTRY = "Industry";
  public static final String SECOND_EMPLOYMENT_STATUS = "SecondEmploymentStatus";
  public static final String MARITAL_STATUS = "MaritalStatus";
  public static final String AGE = "Age";

  public static final String NUM_CHILD_UNDER_16_VAR = "HowManyChildrenOrDependentsUnderTheAgeOf16?";
  public static final String NUM_CHILD_VAR = "HowManyChildrenLiveInTheProperty?";
  public static final String PET_LIVING_IN_PROPERTY_VAR = "DoYouHaveAPetLivingAtTheProperty?";
  public static final String PET_LIVING_IN_HOME_VAR = "DoYouHaveAnyPetsLivingAtYourHome?";
  public static final String NUM_CHILD_UNDER_16 = "ChildrenOrDependentsUnder16";
  public static final String PROPOSER_IAM_OTHER_ORGANISATION = "ProposerOfIamOrOtherOrganisation";
  public static final String PROPOSER_IAM_OTHER_ORGANISATION_VAR =
      "IsProposerMemberOfIamOrOtherOrganisation";
  public static final String IAM_MEMBER = "IamMember";
  public static final String POLICY_INFORMATION = "PolicyInformation";
  public static final String CUSTOMER_DETAILS = "CustomerDetails";
  public static final String CUSTOMER_PERSONAL_DET = "CustomerPersonalDetails";
  public static final String DRIVER_DETAILS = "DriverDetails";
  public static final String MAIN_DRIVER = "MainDriver";
  public static final String MAIN_USAGE = "MainUsage";
  public static final String ADDITIONAL_DRIVER = "AdditionalDriver";
  public static final String DRIVER = "Driver";
  public static final String TEMP_DRIVER = "TemporaryDriver";
  public static final String COVER_DET = "CoverDetails";
  public static final String OTHER_COVER_DET = "OtherCoverDetails";
  public static final String EXCESS_DET = "ExcessDetails";
  public static final String EXCESS_VAR = "Excess";
  public static final String EXCESSES = "Excesses";
  public static final String MY_COVER_VAR = "MyCover";
  public static final String BUILDING_VOLUNTARY_EXCESS = "BuildingVoluntaryExcess";
  public static final String BUILDING_VOLUNTARY_EXCESS_VAR = "BuildingVolXs";
  public static final String VEHICLE_VOLUNTARY_EXCESS = "VechileVoluntaryExcess";
  public static final String MOTOR_COVERAGE_CODES = "MotorCoverageCodes";
  public static final String CONTENT_VOLUNTARY_EXCESS = "ContentVoluntaryExcess";

  public static final String BUILDING_ACCIDENTAL_DAMAGE_COVER = "BuildingAccidentalDamageCover";
  public static final String CONTENT_ACCIDENTAL_DAMAGE_COVER = "ContentAccidentalDamageCover";
  public static final String VOLUNTARY_EXCESS = "VoluntaryExcess";
  public static final String COVERAGE_CODE = "CoverageCode";
  public static final String YEAR_NCD = "NCDYears";

  public static final String BUILDING_CONTENT_INSURANCE_TYPE = "Buildings & Contents";
  public static final String CONTENT_COVER_OPTIONS ="Content cover options";
  public static final String BUILDING_COVER_OPTIONS ="Building cover options";

  public static final String NUMBER_OF_CARS_EXCLUDING_CURRENT_VAR =
      "HowManyCarsAreThereInYourHousehold,ExcludingThisOne?";
  public static final String NUMBER_OF_CARS_EXCLUDING_CURRENT = "NumberOfCardExcludingCurrentCar";

  public static final String FULL_NAME = "FullName";
  public static final String PHONE_NUMBER = "PhoneNumber";
  public static final String PHONE_NUMBER_VAR = "Phone#";
  public static final String DRIVER_NAME = "DriverName";
  public static final String NAME = "Name";
  public static final String DRIVER_PARTY_SELECTION = "DriverPartySelection";
  public static final String TYPE = "ConvictionType";
  public static final String TYPE_VAR = "Type";
  public static final String DRIVER_TYPE = "DriverType";
  public static final String RESIDENCE_IN_UK_SINCE = "ResidenceInUkSince";
  public static final String PREFERRED_DELIVERY = "PreferredDelivery";
  public static final String UNSPENT_CRIMINAL_CONVICTION = "UnspentCriminalConviction";
  public static final String UNSPENT_CRIMINAL_CONVICTIONS = "UnspentCriminalConvictions";
  public static final String UNSPENT_CRIMINAL_CONVICTION_VAR = "UnspentCriminalConvictions";
  public static final String PREFERRED_PAYMENT_METHOD = "PreferredPaymentMethod";
  public static final String AFFORDABILITY_THRESHOLD_VAR = "HasAffordabilityThresholdBeenReached?";
  public static final String AFFORDABILITY_THRESHOLD = "AffordabilityThresholdBeenReached";
  public static final String PREMIUM_FINANCE_REKEY_VAR = "U/wOnlyPremiumFinanceRekey?";
  public static final String PREMIUM_FINANCE_REKEY = "U/wOnlyPremiumFinanceRekey";
  public static final String FCA_CLASS = "Fcaclass";
  public static final String LICENCE_DET = "LicenceDetails";
  public static final String LICENCE_TYPE = "LicenceType";
  public static final String LICENCE_OBTAIN = "LicenceObtain";
  public static final String LICENCE_OBTAIN_VAR = "OnWhatDateDidYouGetYourLicence?";
  public static final String HELD_DRIVING_LICENCE_VAR = "HowLongHaveYouHeldYourDrivingLicence?";
  public static final String ACCESS_TO_OTHER_VEHICLE = "AccessToOtherVehicles";
  public static final String ACCESS_TO_OTHER_VEHICLE_FLAG_VAR =
      "DoYouHaveAccessToAnyOtherVehicles?";

  //Claim
  public static final String CLAIM_HISTORY = "ClaimHistory";

  public static final String INCIDENT_SOURCE = "IncidentSource";
  public static final String INCIDENT_DATE = "IncidentDate";
  public static final String CLAIM_STATUS = "Status";
  public static final String CLAIM_TYPE = "ClaimType";
  public static final String CLAIM_CAUSE = "Cause";
  public static final String COST = "Cost";
  public static final String CLAIM_COST_VAR = "ClaimCost";
  public static final String CLAIM_NUM = "ClaimNumber";
  public static final String OWN_DAMAGE_COST = "OwnDamageCosts";
  public static final String THIRD_PARTY_DAMAGE_COST = "ThirdPartyDamageCosts";
  public static final String OWN_DAMAGE_COST_VAR = "OwnDamageCost";
  public static final String THIRD_PARTY_DAMAGE_COST_VAR = "ThirdPartyDamageCost";
  public static final String NCD_AFFECTED_VAR="NCDAffected";
  public static final String NCD_AFFECTED = "NcdAffected";
  public static final String POLICY_HOLDER_COVER = "PolicyholderCover";
  public static final String PERSONAL_INJURY = "PersonalInjury";

  // Conviction
  public static final String CONVICTION_HISTORY_AVAILABLE = "ConvictionHistoryAvailable";
  public static final String CONVICTION_HISTORY = "ConvictionHistory";
  public static final String OFFENCE_DATE = "OffenceDate";
  public static final String CONVICTION_DATE = "ConvictionDate";
  public static final String POINTS = "Points";
  public static final String DISQUALIFIED = "Disqualified";
  public static final String MONTHS_SUSPENDED = "MonthsSuspended";
  public static final String OVERNIGHT_LOCATION = "OvernightLocation";
  public static final String FINE = "Fine";
  public static final String NON_RTA_CONVICTIONS = "nonRTAConvictions";

  //ADDITIONAL DRIVER
  public static final String RELATIONSHIP_TO_PROPOSER = "RelationshipToProposer";

  public static final String SECOND_EMP_FLAG = "SecondEmpFlag";
  public static final String LICENCE_ACQUIRED = "LicenceAcquired";
  public static final String HELD_DRIVING_LICENCE = "LicenceHeld";
  public static final String DRIVING_LICENCE_NUMBER = "DriverLicenceNumber";
  public static final String LICENCE_NUMBER = "LicenceNumber";

  public static final String TEMP_VEHICLE = "TemporaryVehicle";
  public static final String VEHICLE_REG_NUMBER_VAR = "VehicleRegistrationNumber";
  public static final String VEHICLE_REG_NUMBER = "RegistrationNumber";
  public static final String VEHICLE_TYPE = "VehicleType";
  public static final String VEHICLE_MAKE_VAR = "Make";
  public static final String VEHICLE_MAKE = "VehicleMake";
  public static final String VEHICLE_MODEL_VAR = "Model";
  public static final String VEHICLE_MODEL = "VehicleModel";
  public static final String VEHICLE_YEAR_OF_MANUFACTURE_VAR = "VehicleYearOfManufacture";
  public static final String YEAR_OF_MANUFACTURE_VAR = "YearOfManufacture";
  public static final String VEHICLE_YEAR_OF_MANUFACTURE = "YearOfManufacture";
  public static final String VEHICLE_FULE_TYPE = "FuelType";
  public static final String VEHICLE_TRANSMISSION = "Transmission";
  public static final String VEHICLE_BODY_STYLE = "BodyStyle";
  public static final String VEHICLE_NUM_DOORS = "NumberOfDoors";
  public static final String VEHICLE_NUM_SEAT = "NumberOfSeats";
  public static final String VEHICLE_ENGINE_CC_VAR = "EngineCc";
  public static final String VEHICLE_ENGINE_CC = "EngineCC";
  public static final String VEHICLE_ABI_CODE_VAR = "AbiCode";
  public static final String VEHICLE_ABI_CODE = "ABICode";
  public static final String VEHICLE_MARKET_VALUE = "MarketValue";
  public static final String VEHICLE_ALARM = "Alarm";
  public static final String VEHICLE_IMMOBILISER_VAR = "DoesYourVehicleHaveAnImmobiliserFitted?";
  public static final String VEHICLE_IMMOBILISER_FLAG = "ImmobiliserFitted";
  public static final String VEHICLE_IMMOBILISER = "Immobiliser";
  public static final String VEHICLE_TRACKER_VAR = "DoesYourVehicleHaveATrackerFitted?";
  public static final String VEHICLE_TRACKER_FLAG = "TrackerFitted";
  public static final String VEHICLE_TRACKER = "Tracker";
  public static final String VEHICLE_LEFT_HAND_DRIVE = "LeftHandDrive";
  public static final String VEHICLE_MODIFIED_VAR = "HasTheCarBeenModifiedFromTheManufacturer" +
      "'sStandardSpecification?";
  public static final String VEHICLE_MODIFIED = "Modified";
  public static final String VEHICLE_MODIFICATION_DETAILS = "ModificationDetails";
  public static final String VEHICLE_FEATURE = "VehicleFeature";
  public static final String VEHICLE_CHARACTERISTICS = "VehicleCharacteristics";
  public static final String VEHICLE_RACKING_VAR = "IsTheVehicleFittedWithRacking?";
  public static final String VEHICLE_RACKING = "FittedWithRacking";
  public static final String VEHICLE_SIGNAGE_VAR = "DoesTheVehicleCarryAnySignage?";
  public static final String VEHICLE_SIGNAGE = "CarryAnySignage";
  public static final String VEHICLE_USE_FOR_BY_PROPOSER_VAR = "UseOfVehicleByProposer";
  public static final String VEHICLE_USE_FOR_VAR = "WhatDoYouUseYourCarFor?";
  public static final String VEHICLE_USE_FOR = "VehicleUseFor";
  public static final String VEHICLE_USE_BY_PROPOSER = "VehicleUseByProposer";
  public static final String VEHICLE_USE = "VehicleUse";
  public static final String VEHICLE_USE_TYPE_FOR_VAR =
      "IsThisPurelyForSocialDomesticAndPleasureUse?";
  public static final String VEHICLE_USE_TYPE = "VehicleUseType";
  public static final String CAR_MODIFICATION_DET = "CarModificationDetails";
  public static final String PREVIOUS_POLICY_EXPIRY_DATE = "PreviousPolicyExpiryDate";
  public static final String PREVIOUS_POLICY_EXPIRY_DATE_VAR = "PreviousPolicyExpirationDate";

  public static final String PREVIOUS_COVER_TYPE = "PreviousCoverType";
  public static final String NCD_BUILDING = "NcdBuildings"; //Continuous Years for Buildings
  public static final String NCD_BUILDING_VAR = "ContinuousYearsForBuildings"; //Previous Policy Expiration Date
  public static final String PROTECT_NCD = "ProtectNCD";
  public static final String TYPE_OF_INSURANCE = "InsuranceType";
  public static final String TYPE_OF_INSURANCE_VAR = "TypeOfInsurance";
  public static final String INSURANCE_REFUSED_VAR = "InsuranceRefused?"; // Specific to Home

  public static final String PREV_INSURANCE_REFUSED_VAR = "InsurancePreviouslyRefused?";
  public static final String PREV_INSURANCE_REFUSED = "InsurancePreviouslyRefused";
  public static final String PREVIOUS_EXPERIENCE = "PreviousExperienceDetails";

  public static final String EXPERIENCE_TYPE = "ExperienceType";
  public static final String PREV_INSURANCE = "PreviousInsurance";
  public static final String VEHICLE_IMPORTED_VAR = "IsTheVehicleImported?";
  public static final String VEHICLE_IMPORTED = "VehicleImported";
  public static final String VEHICLE_ANNUAL_MILEAGE = "AnnualMileage";
  public static final String VEHICLE_BUSINESS_MILEAGE = "BusinessMileage";
  public static final String VEHICLE_PURCHASE_DATE_VAR = "WhenDidYouBuyYourCar?";
  public static final String VEHICLE_PURCHASE_DATE = "VehiclePurchaseDate";
  public static final String VEHICLE_PUBLIC_LIABILITY_IN_FORCE_VAR =
      "DoYouHavePublicLiabilityInForce?";
  public static final String PUBLIC_LIABILITY_IN_FORCE = "PublicLiabilityInForce";
  public static final String VEHICLE_HAZARDOUSE_GOOD_VAR = "WillTheVehicleCarryAnyHazardousGoods?";
  public static final String VEHICLE_HAZARDOUSE_GOOD = "HazardousGoods?";
  public static final String VEHICLE_KEPT_DURING_DAY_LOC_VAR = "WhereIsTheVehicleKeptDuringTheDay?";
  public static final String VEHICLE_KEPT_DURING_DAY_LOC = "VehicleKeptDuringDayLoc";
  public static final String VEHICLE_KEPT_DURING_NIGHT_LOC_VAR =
      "WhereIsTheVehicleKeptDuringTheNight?";
  public static final String VEHICLE_KEPT_DURING_NIGHT_LOC = "VehicleKeptDuringNightLoc";
  public static final String VEHICLE_OVER_NIGHT_LOC_VAR = "OvernightLocation";
  public static final String VEHICLE_KEPT_DURING_NIGHT_POSTCODE = "WhereKeptPostcode";
  public static final String VEHICLE_OWNER = "VehicleOwner";
  public static final String VEHICLE_REGISTER_OWNER = "VehicleRegisterOwner";
  public static final String PARKING_DETAILS = "ParkingDetails";
  public static final String HOME_OWNER_VAR = "AreYouAHomeOwner?";
  public static final String HOME_OWNER = "HomeOwner";
  public static final String VEHICLE_PROPOSER_REGISTER_KEEPER = "ProposerRegisteredKeeper";
  public static final String VEHICLE_DASH_CAM_FITTED_VAR = "DoYouHaveADashcamFittedToYourVehicle?";
  public static final String VEHICLE_DASH_CAM_FITTED = "DashCamFitted";
  public static final String CARD_DETAILS = "CreditCardDetails";
  public static final String ENQUIRY = "Enquiry";
  public static final String SALES_CHANNEL = "SalesChannel";
  public static final String SOURCE_OF_BUSINESS = "SourceOfBusiness";
  public static final String FINANCIAL_STATUS = "FinancialStatus";
  public static final String BRAND = "Brand";
  public static final String PROD_TYPE = "ProductType";
  public static final String SCHEME = "Scheme";
  public static final String AFFINITY_CODE = "AffinityCode";
  public static final String AFFINITY = "Affinity";
  public static final String COVER_TYPE = "CoverType";
  public static final String COVER_SECTIONS = "CoverSections";
  public static final String ORIGINAL_QUOTE_DATE = "OriginalQuoteDate";
  public static final String INCEPTION_DATE_VAR = "OriginalPolicyInceptionDate";
  public static final String INCEPTION_DATE = "InceptionDate";
  public static final String POLICY_PERIOD = "PolicyPeriod";
  public static final String DRIVING_RESTRICTION = "DrivingRestrictions";
  public static final String RENEWAL_COUNT = "RenewalCount";

  public static final String NCD_FLAG_VAR = "NcdChaseFlag";
  public static final String NCD_FLAG = "NcdFlag";
  public static final String NCD_BEING_MIRRORED_FROM = "NcdMirroredFrom";
  public static final String NCD_BEING_MIRRORED_FROM_VAR =
      "WhatTypeOfPolicyIsTheNcdBeingMirroredFrom?";
  public static final String NCD_YEAR_APPLIED_TO_ANY_OTHER_VEHICLE_VAR = "HowManyYears" +
      "'NcdDoYouHaveOnYourOtherVehicle";
  public static final String NCD_APPLIED_TO_ANOTHER_VEHICLE = "NCDAppliedToAnyOtherVehicle";
  public static final String NCD_APPLIED_TO_ANOTHER_VEHICLE_VAR = "NcdAppliedToAnyOtherVehicle";
  public static final String NCD_APPLIED_TO_ANY_OTHER_VEHICLE = "NcdAppliedOtherVehicle";
  public static final String NCD_YEAR_APPLIED_TO_ANY_OTHER_VEHICLE = "NcdYearAppliedOtherVehicle";
  public static final String NCD_CLAIM_YEAR = "NcdClaimed";
  public static final String NCD_CLAIM_YEARS = "NCDClaimYears";
  public static final String CLAIM_FREE_YEARS = "ClaimFreeYears";
  public static final String NCD_DETAILS = "NCDDetails";

  public static final String PROTECT_NCD_VAR = "WouldYouLikeToProtectYourNoClaimsDiscount?";
  public static final String CONCERN_FLAG = "ConcernFlag";
  public static final String POLICY_START_DATE = "PolicyStartDate";
  public static final String POLICY_END_DATE = "PolicyEndDate";
  public static final String NUM_OF_DAYS_IN_A_TERM_VAR = "TotalNumberOfDaysInATerm";
  public static final String NUM_OF_DAYS_IN_A_TERM = "NumberOfDaysInATerm";
  public static final String AGENCY_NUMBER = "AgencyNumber";
  public static final String NET_PREMIUM = "NetPremium";
  public static final String GROSS_PREMIUM = "GrossPremium";
  public static final String SELLING_PRICE = "SellingPrice";
  public static final String INSURED_AMOUNT = "InsuredAmount";
  public static final String INSURANCE_HISTORY = "InsuranceHistory";
  public static final String PREVIOUS_INSURANCE_DETAILS = "PreviousInsuranceDetails";
  public static final String PREVIOUS_INSURANCE_AVAILABLE = "PreviousInsuranceAvailable";
  public static final String PREVIOUS_INSURANCE = "PreviousInsurance";
  public static final String PREVIOUS_INSURANCE_VAR = "PreviousInsurance?"; // Specific to Home
  public static final String HOME_INSURANCE_INFORMATION = "HomeInsurance";
  public static final String MOTOR_INSURANCE_INFORMATION = "MotorInsurance";
  public static final String VAN_INSURANCE_INFORMATION = "VanInsurance";
  public static final String POST_CODE = "Postcode";
  public static final String BUILDING_NAME_NUMBER_VAR = "BuildingNameOrNumber";


  public static final String HOUSE_IDENTIFIER = "HouseIdentifier";
  public static final String CONST_TYPE_DETACHED_VAR = "Detached";
  public static final String CONST_TYPE_DETACHED_HOUSE_VAR = "Detached House";
  public static final String BUILDING_TYPE_HOUSE_VAR = "House";
  public static final String CONST_TYPE_TERRACED_VAR = "Terraced";
  public static final String BUILDING_SUB_TYPE_END_TERRACED_HOUSE_VAR = "End Terraced House";
  public static final String CONST_TYPE_SEMI_DETACHED_VAR = "Semi-Detached";
  public static final String BUILDING_SUB_TYPE_SEMI_DETACHED_HOUSE_VAR = "Semi-Detached House";
  public static final String CONST_TYPE_DETACHED_BUNGALOW_VAR = "Detached Bungalow";
  public static final String BUILDING_TYPE_BUNGLOW_VAR = "Bungalow";
  public static final String BUNGLOW_TYPE_VAR = "BungalowType";
  public static final String BUILDING_SUB_TYPE_SEMI_DETACHED_BUNGLOW_VAR = "Semi Detached Bungalow";
  public static final String BUILDING_SUB_TYPE_SEMI_DETACHED_BUNGLOW_DD_VAL_VAR = "Semi-Detached "
      + "Bungalow";


  //public static final String BUNGALOW = "Bungalow";
  //public static final String HOUSE = "House";
  public static final String BUILDING_TYPE_TOWN_HOUSE_VAR = "Town House";
  public static final String BUILDING_TYPE_SELF_CONTAINED_FLAT_VAR = "Self-contained flat";
  public static final String BUILDING_TYPE_MAISONETTE_VAR = "Maisonette";
  public static final String BEST_DESC_YOUR_HOME = "StructureType";
  //public static final String DETACHED = "Detached";
  //public static final String SEMI_DETACHED = "Semi-Detached";
  //public static final String END_TERRACED = "End Terraced";
  //public static final String BUILDING_TYPE_MID_TERRACED_VAR = "Mid-Terraced";
  public static final String CONST_TYPE_STANDARD_VAR = "Standard";
  public static final String CONST_STANDARD_VAR = "IsYourHomeBuiltOfStandardConstruction?";

  public static final String BATHROOM_NUM_VAR = "NumberOfBathroom";
//  public static final String BEDROOM_NUM_VAR = "NumberOfBedrooms";
  public static final String YEAR_BUILT_VAR = "YearBuilt";
//  public static final String YEAR_BUILT = "YearBuilt";
  public static final String DYNAMIC_UNDERWRITER_QUESTIONS = "DynamicUnderwriterQuestions";
  public static final String FREE_FLOODING_THREAT_VAR = "FreeFromFloodingThreats";
  public static final String FREE_FLOODING_VAR = "FreeFromFlooding?";
  public static final String LISTING_STATUS = "ListingStatus";
  public static final String LISTING_STATUS_VAR = "Listings";
  public static final String ALARMS_VAR = "Alarms";
  public static final String BASIC_ALARMS_VAR = "Basic DIY Alarm";
  public static final String TELEPHONE_LINK_VAR = "Telephone Link";
  public static final String APPROVED_AND_MAINTAINED_ALARM_VAR = "Approved And Maintained Alarm";
  public static final String NO_ALARM_VAR = "No";

  public static final String OTHER_ALARMS_VAR = "Other";
  public static final String LOCKS_VAR = "Locks";
  public static final String PROPERTY_OWNED_VAR = "PropertyOwned";
  public static final String PAYMENT_STATUS_VAR = "PaymentType";
  public static final String OCCUPANCY_VAR = "Occupancy";
  public static final String USAGE = "Usage";
  public static final String INSURED_AMOUNT_VAR = "InsuredAmount";

  //public static final String SPECIFIED_ITEM_VAR = "SpecifiedItems";
  public static final String CONTENT_DETAILS_VAR = "ContentDetails";
  public static final String INSURANCE_HISTORY_VAR = "InsuranceHistory";
  public static final String CONTENT_SUM_VAR = "ContentSum";
  public static final String CONTENT_CLAIM_FREE_YEARS_VAR = "ContentClaimFreeYears";
  public static final String CONTENT_ACCIDENTAL_DAMAGE_VAR = "ContentAccidentalDamage";

  public static final String BUILDING_ACCIDENTAL_DAMAGE_VAR = "BuildingAccidentalDamage";
  public static final String PREV_INSURANCE_VAR = "PreviousInsurance";
  public static final String PROD_TYPE_HOME_VAR = "Home";
  public static final String PROD_TYPE_MOTOR_VAR = "Motor";
  public static final String PROD_TYPE_PRIVATE_CAR = "Private car";
  public static final String PROD_TYPE_VAN_VAR = "Van";

  public static final String UNSATISFIED_COUNTY_JUDGEMENTS = "UnsatisfiedCountyJudgement";
  public static final String UNSATISFIED_COUNTY_JUDGEMENTS_VAR =
      "HasAnyResidentHadAnyUnsatisfiedCountyCourtJudgements?";
  public static final String DECLARED_BANKRUPT = "DeclaredBankrupt";
  public static final String DECLARED_BANKRUPT_VAR = "HasAnyResidentBeenDeclaredBankrupt?";
  public static final String FULL_ACCIDENTAL_COVER_ON_BUILDING_VAR =
      "WouldYouLikeFullAccidentalDamageCoverOnYourBuildings?";
  public static final String FULL_ACCIDENTAL_COVER_ON_CONTENT_VAR =
      "WouldYouLikeFullAccidentalDamageCoverOnYourContents?";
  public static final String FULL_ACCIDENTAL_COVER_ON_BUILDING =
      "BuildingFullAccidentalDamageCover";
  //public static final String FULL_ACCIDENTAL_COVER_ON_CONTENT =
  // "ContentFullAccidentalDamageCover";
  public static final String REBUILDING_COST = "RebuildCost";
  public static final String BUILDING_CLAIM_FREE_YEAR_VAR =
      "HowManyBuildingsClaimFreeYearsHaveYouHad?";
  public static final String BUILDING_CLAIM_FREE_YEAR = "BuildingsNcd";
  public static final String CONTENT_CLAIM_FREE_YEAR = "NoClaimDiscount";
  public static final String CONTENT_SUM_INSURED_VAR = "ContentsSumInsured";
  public static final String CONTENT_SUM_INSURED = "ContentSumInsured";
  public static final String CONTENT_VOLUNTARY_EXCESS_VAR = "ContentsVolXs";
  public static final String CONTENTS_CLAIM_FREE_YEAR_VAR =
      "HowManyContentsClaimFreeYearsHaveYouHad?";
  public static final String SAFE_INSTALLED = "SafeInstalled";
  public static final String UNSPECIFIED_ITEM_TAKE_OUTSIDE_HOME_VAR =
      "WouldYouLikeCoverForOtherUnspecifiedItemsYouTakeOutsideTheHome?";
  public static final String UNSPECIFIED_ITEM_TAKE_OUTSIDE_HOME =
      "CoverUnspecifiedItemsYouTakeOutsideTheHome";
  public static final String VALUABLE_IN_HOME_FLAG_VAR =
      "WouldYouLikeToSpecifyAnyValuablesInTheHome?";
  public static final String VALUABLE_IN_HOME_FLAG = "ValuablesInTheHome";
  public static final String SPECIFIED_ITEM_FLAG = "SpecifiedItemsAvailable";
  public static final String VALUABLE_AWAY_FROM_HOME_FLAG_VAR =
      "WouldYouLikeToSpecifyAnyValuablesAwayFromHome?";
  public static final String ITEM_VALUE_VAR = "ValueOfTheSpecifiedItem";
  public static final String ITEM_VALUE = "SpecifiedItemValue";
  public static final String SPECIFIED_ITEM = "SpecifiedItem";
  public static final String ITEM_DESCRIPTION = "ItemDescription";
  public static final String BEST_DESCRIBE_YOUR_HOME = "WhatBestDescribesYourHome?";
  public static final String LIMIT_AMOUNT = "LimitAmount";
  public static final String SPECIFIED_ITEMS_SUM_INSURED = "ItemsAwayFromHomeSumInsured";
  public static final String ITEMS_AWAY_FROM_HOME = "ItemsAwayFromHome";
  public static final String ITEMS_IN_HOME = "ItemsInHome";
//  public static final String MTA_ADDITIONAL_PREMIUM_AMOUNT = "AdditionalPremium";
//  public static final String BICYCLE_DET ="BicycleDetails";
  public static final String VALUABLE_AWAY_FROM_HOME_FLAG = "ValuablesAwayFromHome";
  public static final String BICYCLES_FLAG_VAR = "DoYouWantToCoverBicyclesAwayFromHome?";
  public static final String BICYCLES_FLAG = "BicyclesCoverAwayFromHome";
  public static final String ADDITIONAL_PREMIUM = "AdditionalPremium";
  public static final String DEFAULT_ADDED_ENDORSEMENT = "DefaultEndorsement";
  //  public static final String CUSTOMER_DETAILS = "CustomerDetails";
  public static final String ENHANCE_EXCESS_DETAILS = "EnhanceMyCover";

  public static final String OUTSTANDING_BALANCE = "OutstandingBalance";
  public static final String USE_DETAILS = "UseDetails";
  public static final String PROPERTY_TYPE = "PropertyType";
  public static final String OWNERSHIP_VAR = "Ownership";
  public static final String OCCUPANCY_DETAILS = "OccupancyDetails";
  public static final String NUM_ADULTS = "NumberOfAdult";
  public static final String NUM_ADULTS_VAR = "HowManyAdultsLiveInTheProperty?";
  public static final String NUM_ADULTS_LIVE_HOME_VAR = "HowManyAdultsLiveAtYourHome?";
  public static final String NUM_CHILD_LIVE_HOME_VAR ="HowManyChildrenLiveAtYourHome?";
  public static final String NUM_CHILD = "NumberOfChild";
  public static final String OCCUPIED = "Occupied";
  public static final String PAYING_GUEST_DET = "PayingGuestDetails";
  public static final String PAYING_GUEST_DET_VAR = "DoYouHaveAnyPayingGuestsLivingAtYourHome?";
  public static final String PET_DET = "PetDetails";
  public static final String BUILDING_COMPULSORY_EXCESS = "BuildingCompulsoryExcess";
  public static final String CONTENT_COMPULSORY_EXCESS = "ContentCompulsoryExcess";
  public static final String BUILDING_COVER = "BuildingsCover";
  public static final String CONTENT_COVER = "ContentCover";
  public static final String FLOOD = "Flood";
  public static final String EXTRA_HOME_EMERGENCY = "AgeasExtraHomeEmergency";
  public static final String EXCESS_PROTECTION_SUBSIDENCE = "HomeExcessProtectionSubsidence";
  public static final String EXCESS_PROTECTION_SUBSIDENCE_VAR = "ExcessProtectionWithSubsidence";
//  public static final String BUILDING_ACCIDENTAL_DAMAGE_COVER = "BuildingAccidentalDamageCover";
  public static final String SUBSIDENCE_GROUND_HEAVE_LAND_SLIP = "SubsidenceGroundHeaveLandslip";
  public static final String SUBSIDENCE_GROUND_HEAVE_LAND_SLIP_VAR = "Subsidence," +
      "groundheaveandlandslip";
  public static final String BUILT_DETAILS = "BuiltDetails";
  public static final String EXTENSION_DETAILS = "Extension";
  public static final String EXTENSION_DETAILS_VAR = "HasThePropertyBeenExtended?";
  public static final String HOME_EXTENSION_DETAILS_VAR = "HasYourHomeBeenExtended?";
  public static final String INTRUDER_DETAILS = "IntruderAlarmDetails";
  public static final String LISTING_DETAILS = "Listing";
  public static final String LOCKING_DETAILS = "Locking";
  public static final String LOCKING_DETAILS_VAR = "IsYourHomeFittedWithFive" +
      "-leverMorticeDeadlocksOrAMulti-pointLockingSystemOnAllExternalDoors," +
      "AndKey-operatedWindowLocksOnAllGround-levelWindowsAndAccessibleUpperFloorWindows?";
  public static final String LEAKING_FREEZING = "LeakingFreezing";
  public static final String LEAKING_FREEZING_VAR = "Leakingorfreezingofwaterorleakingoil";
  public static final String ACCIDENTAL_DAMAGE_COVER = "AccidentalDamageCover";
  public static final String INSURANCE_HELD = "InsuranceHeld"; //ContentInsuranceHeld


  public static final String INDIVIDUAL_ITEM_COVER = "IndividualItemCover";
  public static final String INDIVIDUAL_SPECIFIED_ITEMS = "IndividualSpecifiedItems";
  public static final String PERSONAL_BELONGING_AWAY_FROM_HOME_COST =
      "PersonalBelongingAwayFromHomeCost";
  public static final String PERSONAL_BELONGING_AWAY_FROM_HOME = "PersonalBelongingAwayFromHome";
  public static final String PERSONAL_BELONGING_AWAY_FROM_HOME_VAR =
      "WouldYouLikeExtraCoverForPersonalBelongingsAwayFromTheHome?";
  public static final String PERSONAL_BELONGING_AWAY_FROM_HOME_COST_VAR =
      "HowMuchCoverWouldYouLikeForPersonalBelongingsAwayFromTheHome?";
  public static final String IN_HOME_COUNT = "InHomeCount";
  public static final String AWAY_FROM_HOME_COUNT = "AwayHomeCount";
  public static final String IN_HOME = "InHome";
  public static final String ITEM = "Item";
  public static final String DESCRIPTION = "Description";
  public static final String VALUE = "Value";
  public static final String AWAY_HOME = "AwayHome";
  public static final String INSURED_HOUSE_HOLD_CONENT_LIMIT = "InsuredHouseHoldContentLimit";
  public static final String VALUABLE_OVER_2000£_FLAG = "ValuableOver2000£";
  public static final String VALUABLE_OVER_2000£_ITEMS = "ValuableOver2000£Items";
  public static final String CORRESPONDANCE = "Correspondance";
  public static final String PRIMARY_EMPLOYMENT = "PrimaryEmployment";
  public static final String SECONDARY_EMPLOYMENT = "SecondaryEmployment";
  public static final String INDUSTRY_TYPE = "IndustryType";
  public static final String JOINT_POLICY_HOLDER_FLAG = "JointPolicyHolderFlag";
  public static final String RELATIONSHIP_STATUS = "RelationshipStatus";
  public static final String POLICY_EXPIRES_IN = "PolicyExpiresIn";
  public static final String POLICY_ID = "PolicyId";

  public static final String JPH_DETAILS = "JointPolicyHolderDetails";

  public static final String BICYLCE_TYPE_VAR = "SpecifiedBicycleAwayFromHome";
  public static final String BICYLCE_TYPE = "BicycleType";

  public static final String BICYCLE_DESCRIPTION = "BicycleDescription";
  public static final String VALUE_OF_SPECIFIED_ITEM = "ValueOfTheSpecifiedItem";

}

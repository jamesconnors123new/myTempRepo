package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import PageObjects.EisModel.Root;
import activities.CommonControlDataDefns;
import helpers.CdlEisHelpers;
import helpers.CommonHelper;
import helpers.SelectOptions;
import helpers.SyncType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;

import static activities.CommonControlDataDefns.PROD_TYPE_VAN_VAR;

public class EisMotorQuoteCreationStepDefinition extends CdlEisHelpers {
    public static final String QUOTE_DETAILS = "QuotesDetails";
    public static final String INSURANCE_DETAILS = "InsuranceDetails";
    public static final String ENQUIRY = "Enquiry";
    public static final String SALES_CHANNEL = "SalesChannel";

    public static final String AFFINITY = "Affinity";
    public static final String BRAND = "Brand";
    public static final String PRODUCT_TYPE = "ProductType";
    public static final String PRODUCT = "Product";
    public static final String LINE_OF_BUSINESS = "LineOfBusiness";
    public static final String INCEPTION_DATE = "InceptionDate";
    public static final String SCHEME = "Scheme";
    public static final String COVER_TYPE = "CoverType";
    public static final String DRIVING_RESTRICTIONS = "DrivingRestrictions";




    public static final String DRIVING_EXPERIENCE_NOT_IN_PROPOSER_NAME = "DrivingExperienceInProposerName";

    public static final String INSURANCE_TYPE = "InsuranceType";


    public static final String DELIVERY_METHOD = "PreferredDeliveryMethod";
    public static final String VEHICLE = "Vehicle";
    public static final String REGISTRATION_NUMBER = "RegistrationNumber";
    public static final String VEHICLE_MAKE = "VehicleMake";
    public static final String VEHICLE_MODEL = "VehicleModel";
    public static final String FUEL_TYPE = "FuelType";
    public static final String YEAR_OF_MANUFACTURE = "YearOfManufacture";
    public static final String ABI_CODE = "AbiCode";
    public static final String VEHICLE_DETAILS = "VehicleDetails";
    public static final String MARKET_VALUE = "MarketValue";
    public static final String NUMBER_OF_SEATS = "NumberOfSeats";
    public static final String NUMBER_OF_DOORS = "NumberOfDoors";
    public static final String VEHICLE_FEATURES = "VehicleFeatures";
    public static final String ALARM = "Alarm";
    public static final String IMMOBILISER = "Immobiliser";
    public static final String TRACKER = "Tracker";
    public static final String DASHCAM = "Dashcam";
    public static final String LEFT_HAND_DRIVE = "LeftHandDrive";
    public static final String VEHICLE_IMPORTED = "VehicleImported";
    public static final String CAR_MODIFICATION = "CarModificationDetails";
    public static final String MODIFICATION = "modification";
    public static final String MODIFICATION_DETAILS = "modificationDetails";
    public static final String VEHICLE_USE = "VehicleUse";
    public static final String USAGE = "MainUsage";
    public static final String ANNUAL_MILEAGE = "AnnualMileage";
    public static final String BUSINESS_MILEAGE = "BusinessMileage";

    public static final String CAR_PURCHASE_DATE = "CarPurchaseDate";
    public static final String PARKING_DETAILS = "ParkingDetails";
    public static final String PARKING_DURING_DAY = "ParkingDuringDay";
    public static final String PARKING_DURING_NIGHT = "ParkingDuringNight";
    public static final String POSTCODE = "Postcode";
    public static final String LICENCE = "Licence";
    public static final String LICENCE_TYPE = "Type";
    public static final String LICENCE_VALID_SINCE = "LicenceValidSince";
    public static final String LICENCE_NUMBER = "Number";
    public static final String REGISTERED_OWNER = "RegisteredOwner";
    public static final String REGISTERED_OWNER_DETAILS = "RegisteredOwnerDetails";
    public static final String REGISTERED_KEEPER = "RegisteredKeeper";
    public static final String OWNER = "Owner";
    public static final String PROPOSER_REGISTERED_KEEPER = "ProposerRegisteredKeeper";
    public static final String PROPOSER_PERSONAL_DETAILS = "ProposerPersonalDetails";
    public static final String UK_RESIDENCY = "UkResidentSince";

    public static final String DUQ = "DynamicUnderwriterQuestions";
    public static final String I_AM_MEMBER = "IamMember";
    public static final String ADDITIONAL_CARS = "AdditionalCars";
    public static final String VEHICLE_USE_BY_PROPOSER = "VehicleUseByProposer";
    public static final String PREVIOUS_INSURANCE_REFUSED = "PreviousInsuranceRefused";
    public static final String PAYMENT_FREQUENCY = "PaymentType";
    public static final String HOME_OWNER = "HomeOwner";
    public static final String AFFORDABILITY = "AffordabilityThresholdReached";
    public static final String UW_FINANCE_REKEY = "UWOnlyPremiumFinance";
    public static final String ACCESS_TO_OTHER_VEHICLES = "AccessToOtherVehicles";
    public static final String ADDITIONAL_DRIVER_DETAILS = "AdditionalDriverDetails";
    public static final String ADDITIONAL_DRIVER = "AdditionalDriver";
    public static final String DRIVER_TYPE = "DriverType";
    public static final String RELATIONSHIP_TO_PROPOSER = "RelationshipToProposer";
    public static final String AD_TITLE = "Title";
    public static final String AD_FIRST_NAME = "FirstName";
    public static final String AD_LAST_NAME = "LastName";
    public static final String AD_DOB = "DateOfBirth";
    public static final String AD_GENDER = "Gender";
    public static final String AD_MARITAL_STATUS = "MaritalStatus";
    public static final String EXCESS = "Excess";

    public static final String CLAIMS_HISTORY_AVAILABLE = "ClaimHistoryAvailable";
    public static final String CLAIMS_HISTORY = "ClaimHistory";

    public static final String WHAT_TYPE_OF_POLICY_NCD_MIRRORED_FROM = "WhatTypeOfPolicyIsTheNCDBeingMirroredFrom";
    public static final String NCD_MANY_YEARS_ON_OTHER_VEHICLE = "NCDHowManyYearsOnOtherVehicle";

    public static final String VEHICLE_FITTED_WITH_RACKING = "VehicleFittedWithRacking";
    public static final String DOES_VEHICLE_CARRY_SIGNAGE = "DoesVehicleCarrySignage";
    public static final String VEHICLE_ADDITIONAL_INFORMATION = "VehicleAdditionalInformation";

    public static final String PUBLIC_LIABILITY_IN_FORCE = "PublicLiabilityInForce";

    public static final String FOR_SOCIAL_AND_PLEASURE = "ForSocialAndPleasureUse";

    public static final String WHEN_DID_YOU_BUY_YOUR_CAR = "WhenDidYouBuyYourCar";
    public static final String WILL_VEHICLE_CARRY_HAZARDOUS_GOODS = "WillVehicleCarryHazardousGoods";

    public static final String VAN = "Van";

    public static final long waitDuration = 60000L;
    EisGeneralStepDefinitions eisGeneralStepDefinitions;
    EisHomeQuoteCreationStepDefinition eisHomeQuoteCreationStepDefinition;
    private final helpers.CommonHelper CommonHelper;
    CommonControlDataDefns commonControlDataDef = new CommonControlDataDefns();

    public EisMotorQuoteCreationStepDefinition(WebDriver pDriver, Root pageObjectOfEis) {
        super(pDriver, pageObjectOfEis);
        eisGeneralStepDefinitions = new EisGeneralStepDefinitions(pDriver, pageObjectOfEis);
        eisHomeQuoteCreationStepDefinition = new EisHomeQuoteCreationStepDefinition(pDriver, pageObjectOfEis);
        this.CommonHelper = new CommonHelper(pDriver);
    }

    public void motorQuoteCreation(Map<String, Object> salesDetails) throws CustomE2eException {
        var quotesDetails = (Map<String, Object>) salesDetails.get(QUOTE_DETAILS);
        if (((String) quotesDetails.get(PRODUCT_TYPE)).equalsIgnoreCase(commonControlDataDef.MOTOR_QUOTE)) {
            enterMotorPolicyInformation(salesDetails);
        } else if (((String) quotesDetails.get(PRODUCT_TYPE)).equalsIgnoreCase(commonControlDataDef.VAN_QUOTE)) {
            //enterVanPolicyInformation(salesDetails); Need to revisit once code is merge in
            // integration branch - 03/01/2024
        }
    }

    public void enterMotorPolicyInformation(Map<String, Object> salesDetails) throws CustomE2eException {
        var quotesDetails = (Map<String, Object>) salesDetails.get(QUOTE_DETAILS);
        var insuranceDetails = (Map<String, Object>) salesDetails.get(INSURANCE_DETAILS);
        var dynamicUnderwriterQuestions = ((Map<String, Object>) salesDetails.get(DUQ));
        var proposerDrivingDetails = (Map<String, Object>) salesDetails.get(LICENCE);

        eisHomeQuoteCreationStepDefinition.selectProduct(quotesDetails.get(PRODUCT_TYPE));
        //Enquiry
        selectEnquiry((String) quotesDetails.get(ENQUIRY));
        //Sales Channel
        selectSalesChannel((String) quotesDetails.get(SALES_CHANNEL));
        //Brand
//        selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().BRAND_PAGE(),
//                quotesDetails.get(QuoteCreationInEis.BRAND_VAR),
//                SelectOptions.TEXT);
        //Product Type - Motor
        selectMotorProduct((String) insuranceDetails.get(PRODUCT));
        //Select scheme
        selectScheme((String) insuranceDetails.get(SCHEME));
        //Select affinity
        selectAffinity((String) quotesDetails.get(AFFINITY));
        selectCover((String) insuranceDetails.get(COVER_TYPE));
        //Policy start date
        enterPolicyStartDate((String) insuranceDetails.get(INCEPTION_DATE));
        //Driving Restrictions
        selectDrivingRestrictions((String) insuranceDetails.get(DRIVING_RESTRICTIONS));
        eisGeneralStepDefinitions.saveQuote();
        eisGeneralStepDefinitions.navigateToNextPage();
        provideInsuredDetails(salesDetails);
        eisGeneralStepDefinitions.saveQuote();
        eisGeneralStepDefinitions.navigateToNextPage();
        provideDriverDetails(salesDetails);
        selectNonRTAConviction((Boolean) dynamicUnderwriterQuestions.get(CommonControlDataDefns.NON_RTA_CONVICTIONS));

        var claimDetails = salesDetails.get(CLAIMS_HISTORY_AVAILABLE);
        if (claimDetails instanceof String) {
            claimDetails = Boolean.parseBoolean((String) salesDetails.get(CLAIMS_HISTORY_AVAILABLE));
        } else if (claimDetails instanceof Boolean) {
            claimDetails = salesDetails.get(CLAIMS_HISTORY_AVAILABLE);
        }
        if ((Boolean) claimDetails) {
            ArrayList<Map<String, Object>> claimHistoryDetails = (ArrayList<Map<String, Object>>) salesDetails.get(CLAIMS_HISTORY);
            for (var claim : claimHistoryDetails) {
                addClaim();
                enterClaimIncidentDate(claim.get(CommonControlDataDefns.INCIDENT_DATE));
                cancelClaimError();
                selectClaimStatus(claim.get(CommonControlDataDefns.CLAIM_STATUS));
                selectClaimType(claim.get(CommonControlDataDefns.CLAIM_TYPE));
                selectClaimCause(claim.get(CommonControlDataDefns.CLAIM_CAUSE));
                enterOwnDamageCost(claim.get(CommonControlDataDefns.OWN_DAMAGE_COST_VAR));
                enterThirdPartyDamageCost(claim.get(CommonControlDataDefns.THIRD_PARTY_DAMAGE_COST_VAR));
                selectNCDAffected((Boolean) claim.get(CommonControlDataDefns.NCD_AFFECTED_VAR));
                selectPolicyholderCover((Boolean) claim.get(CommonControlDataDefns.POLICY_HOLDER_COVER));
                selectPersonalInjury((Boolean) claim.get(CommonControlDataDefns.PERSONAL_INJURY));
            }
        }
        var convictionDetails =
            salesDetails.get(CommonControlDataDefns.CONVICTION_HISTORY_AVAILABLE);
        if (convictionDetails instanceof String) {
            convictionDetails =
                Boolean.parseBoolean((String) salesDetails.get(CommonControlDataDefns.CONVICTION_HISTORY_AVAILABLE));
        } else if (convictionDetails instanceof Boolean) {
            convictionDetails =
                salesDetails.get(CommonControlDataDefns.CONVICTION_HISTORY_AVAILABLE);
        }
        if ((Boolean) convictionDetails) {
            ArrayList<Map<String, Object>> convictionHistoryDetails = (ArrayList<Map<String,
                Object>>) salesDetails.get(CommonControlDataDefns.CONVICTION_HISTORY);
            for (var conviction : convictionHistoryDetails) {
                addConviction();
                selectConvictionType(conviction.get(CommonControlDataDefns.TYPE));
                enterPoints(conviction.get(CommonControlDataDefns.POINTS));
                enterOffenceDate(conviction.get(CommonControlDataDefns.OFFENCE_DATE));
                enterConvictionDate(conviction.get(CommonControlDataDefns.CONVICTION_DATE));

                selectDisqualified((Boolean) conviction.get(CommonControlDataDefns.DISQUALIFIED));
                if ((Boolean) conviction.get(CommonControlDataDefns.DISQUALIFIED)) {
                    enterSuspensionMonths(conviction.get(CommonControlDataDefns.MONTHS_SUSPENDED));
                }
                enterFine(conviction.get(CommonControlDataDefns.FINE));
            }
        }

        var additionalDriverDetails = salesDetails.get(ADDITIONAL_DRIVER_DETAILS);
        if (additionalDriverDetails instanceof String) {
            additionalDriverDetails = Boolean.parseBoolean((String) salesDetails.get(ADDITIONAL_DRIVER_DETAILS));
        } else if (additionalDriverDetails instanceof Boolean) {
            additionalDriverDetails = salesDetails.get(ADDITIONAL_DRIVER_DETAILS);
        }
        if ((Boolean) additionalDriverDetails) {
            var additionalDrivers = (ArrayList<Map<String, Object>>) salesDetails.get(ADDITIONAL_DRIVER);
            for (var additionalDriver : additionalDrivers) {
                addAdditionalDriver(salesDetails, additionalDriver);
            }
        }
        eisGeneralStepDefinitions.saveQuote();
        eisGeneralStepDefinitions.navigateToNextPage();
        addVehicleDetails(salesDetails);
        eisGeneralStepDefinitions.saveQuote();
        eisGeneralStepDefinitions.navigateToNextPage();
        addExcess(salesDetails);
        if ((salesDetails.get(commonControlDataDef.OPTIONAL_EXTRAS) != null)) {
            eisHomeQuoteCreationStepDefinition.addOptionalExtras((String) salesDetails.get(commonControlDataDef.OPTIONAL_EXTRAS));
            clickOpexOkButton();
        }

        //      eisGeneralStepDefinitions.navigateToNextPage();
    }

    public void clickOpexOkButton() throws CustomE2eException {
        if (isElementVisible(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().OPEX_EXTRAS_OK())) {
            waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().OPEX_EXTRAS_OK(), SyncType.CLICKABLE, waitDuration);
            clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().OPEX_EXTRAS_OK(), SyncType.CLICKABLE);
        }
    }

    public void provideDriverDetails(Map<String, Object> salesDetails) throws CustomE2eException {
        var proposerLicenceDetails = (Map<String, Object>) salesDetails.get(LICENCE);
        selectLicenceType(proposerLicenceDetails.get(LICENCE_TYPE));
        licenceAcquisitionDate(proposerLicenceDetails.get(LICENCE_VALID_SINCE));
        //       enterLicenceNumber(proposerLicenceDetails.get(LICENCE_NUMBER));

    }

    public void addAdditionalDriver(Map<String, Object> salesDetails, Map<String, Object> additionalDriver) throws CustomE2eException {
        var primaryEmployment = (Map<String, Object>) additionalDriver.get(CommonControlDataDefns.PRIMARY_EMPLOYMENT_STATUS_VAR);
        var secondaryEmployment = (Map<String, Object>) additionalDriver.get(CommonControlDataDefns.SECOND_EMPLOYMENT_STATUS_VAR);
        var dynamicUnderwriterQuestions = ((Map<String, Object>) salesDetails.get(DUQ));
        var licenceDetails = (Map<String, Object>) additionalDriver.get(LICENCE);
        String drivingRestrictions = (String) ((Map<String, Object>) salesDetails.get(INSURANCE_DETAILS)).get(DRIVING_RESTRICTIONS);
        if (!drivingRestrictions.equalsIgnoreCase("Insured Only")) {
            addNewDriver();
            selectDriverParty("Create New Driver");
            selectDriverType(additionalDriver.get(DRIVER_TYPE));
            relationshipToProposer(additionalDriver.get(RELATIONSHIP_TO_PROPOSER));
            driverTitle(additionalDriver.get(AD_TITLE));
            enterAdditionalDriverFirstName(additionalDriver.get(AD_FIRST_NAME));
            enterAdditionalDriverLastName(additionalDriver.get(AD_LAST_NAME));
            cancelPartySearch();
            enterAdditionalDriverDOB(additionalDriver.get(AD_DOB));
            additionalDriverGender(additionalDriver.get(AD_GENDER));
            additionalDriverMaritalStatus(additionalDriver.get(AD_MARITAL_STATUS));
            additionalDriverResidencyInUK(additionalDriver.get(UK_RESIDENCY));
            //Full time occupation
            additionalDriverOccupation(primaryEmployment.get(CommonControlDataDefns.EMP_TYPE));
            // Full time job status
            additionalDriverJobCategory(primaryEmployment.get(CommonControlDataDefns.EMP_CATEGORY));
            //Full time Employer Industry
            additionalDriverJobIndustry(primaryEmployment.get(CommonControlDataDefns.EMP_INDUSTRY));
            selectADSecondaryEmployment((boolean) secondaryEmployment.get(CommonControlDataDefns.EMPLOYED));
            if ((boolean) secondaryEmployment.get(CommonControlDataDefns.EMPLOYED)) {
                additionalDriverSecondaryOccupation(secondaryEmployment.get(CommonControlDataDefns.EMP_TYPE));
                additionalDriverSecondaryJobCategory(secondaryEmployment.get(CommonControlDataDefns.EMP_CATEGORY));
                additionalDriverSecondaryJobIndustry(secondaryEmployment.get(CommonControlDataDefns.EMP_INDUSTRY));
            }

            selectLicenceType(licenceDetails.get(LICENCE_TYPE));
            licenceAcquisitionDate(licenceDetails.get(LICENCE_VALID_SINCE));
            // enterLicenceNumber(licenceDetails.get(LICENCE_NUMBER));
//            additionalDriverAccessToAnotherVehicle(licenceDetails.get(ACCESS_TO_OTHER_VEHICLES));
            selectNonRTAConviction((Boolean) dynamicUnderwriterQuestions.get(CommonControlDataDefns.NON_RTA_CONVICTIONS));
        }
    }

    public void provideInsuredDetails(Map<String, Object> salesDetails) throws CustomE2eException {
        var quotesDetails = (Map<String, Object>) salesDetails.get(QUOTE_DETAILS);
        var dynamicUnderwriterQuestions = ((Map<String, Object>) salesDetails.get(DUQ));
        var proposerPersonalDetails = (Map<String, Object>) salesDetails.get(PROPOSER_PERSONAL_DETAILS);
        var insuranceDetails = (Map<String, Object>) salesDetails.get(INSURANCE_DETAILS);
        var primaryEmploymentStatus = (Map<String, Object>) proposerPersonalDetails.get(CommonControlDataDefns.PRIMARY_EMPLOYMENT_STATUS_VAR);
        var proposerSecondaryEmployment = (Map<String, Object>) proposerPersonalDetails.get(CommonControlDataDefns.SECOND_EMPLOYMENT_STATUS_VAR);
        var previousInsurance =
            (Map<String, Object>) ((Map<String, Object>) insuranceDetails.get(CommonControlDataDefns.INSURANCE_HISTORY)).get(CommonControlDataDefns.PREVIOUS_INSURANCE_DETAILS);
        var ncdDetails =
            (Map<String, Object>) previousInsurance.get(CommonControlDataDefns.NCD_DETAILS);
        var previousExperienceDetails =
            (Map<String, Object>) previousInsurance.get(CommonControlDataDefns.PREVIOUS_EXPERIENCE);
        //Residence in UK
        residencyInUK(proposerPersonalDetails.get(UK_RESIDENCY));
        //Full time occupation
        proposerOccupation(primaryEmploymentStatus.get(CommonControlDataDefns.EMP_TYPE));
        // Full time job status
        proposerJobCategory(primaryEmploymentStatus.get(CommonControlDataDefns.EMP_CATEGORY));
        //Full time Employer Industry
        proposerJobIndustry(primaryEmploymentStatus.get(CommonControlDataDefns.EMP_INDUSTRY));
        preferredDelivery(salesDetails.get(DELIVERY_METHOD));
        selectSecondaryEmployment((boolean) proposerSecondaryEmployment.get(CommonControlDataDefns.EMPLOYED));
        if ((boolean) proposerSecondaryEmployment.get(CommonControlDataDefns.EMPLOYED)) {
            proposerSecondaryOccupation(proposerSecondaryEmployment.get(CommonControlDataDefns.EMP_TYPE));
            proposerSecondaryJobCategory(proposerSecondaryEmployment.get(CommonControlDataDefns.EMP_CATEGORY));
            proposerSecondaryJobIndustry(proposerSecondaryEmployment.get(CommonControlDataDefns.EMP_INDUSTRY));
        }
        selectIamMember((Boolean) dynamicUnderwriterQuestions.get(I_AM_MEMBER));
        enterNumberOfOtherCars(dynamicUnderwriterQuestions.get(ADDITIONAL_CARS));
        selectPreviousInsuranceRefused((Boolean) dynamicUnderwriterQuestions.get(PREVIOUS_INSURANCE_REFUSED));
        useOfVehicleByProposer(dynamicUnderwriterQuestions.get(VEHICLE_USE_BY_PROPOSER));
        preferredPaymentMethod(dynamicUnderwriterQuestions.get(PAYMENT_FREQUENCY));
        proposerHomeOwner(dynamicUnderwriterQuestions.get(HOME_OWNER));
        selectAffordabilityThreshold(dynamicUnderwriterQuestions.get(AFFORDABILITY));
        selectFinanceRekey((Boolean) dynamicUnderwriterQuestions.get(UW_FINANCE_REKEY));
        var previousInsuranceDetails =
            previousInsurance.get(CommonControlDataDefns.PREVIOUS_INSURANCE);
        var drivingExperienceDetails = previousInsurance.get(DRIVING_EXPERIENCE_NOT_IN_PROPOSER_NAME);
        if (previousInsuranceDetails instanceof String) {
            previousInsuranceDetails =
                Boolean.parseBoolean((String) previousInsurance.get(CommonControlDataDefns.PREVIOUS_INSURANCE));
        } else if (previousInsuranceDetails instanceof Boolean) {
            previousInsuranceDetails =
                previousInsurance.get(CommonControlDataDefns.PREVIOUS_INSURANCE);
        }
        selectPreviousInsurance((Boolean) previousInsuranceDetails);
        if ((Boolean) previousInsuranceDetails) {
            var ncd = ncdDetails.get(CommonControlDataDefns.NCD_APPLIED_TO_ANOTHER_VEHICLE);
            if (ncd instanceof String) {
                ncd = Boolean.parseBoolean((String) ncdDetails.get(CommonControlDataDefns.NCD_APPLIED_TO_ANOTHER_VEHICLE));
            } else if (ncd instanceof Boolean) {
                ncd = ncdDetails.get(CommonControlDataDefns.NCD_APPLIED_TO_ANOTHER_VEHICLE);
            }
            selectNcdApplied((Boolean) ncd);
            if (!(Boolean) ncd) {
                previousPolicyExpiryDate(ncdDetails.get(CommonControlDataDefns.PREVIOUS_POLICY_EXPIRY_DATE));
                enterNumberOfNCDClaimYears(ncdDetails.get(CommonControlDataDefns.NCD_CLAIM_YEARS));
                selectPreviousInsuranceType(ncdDetails.get(INSURANCE_TYPE));

                protectNCD((Boolean) ncdDetails.get(CommonControlDataDefns.PROTECT_NCD));
            }

        } else {
            selectDrivingExperienceNotInProposerName((Boolean) drivingExperienceDetails);
            if ((Boolean) drivingExperienceDetails) {
                enterClaimFreeYears(previousExperienceDetails.get(CommonControlDataDefns.CLAIM_FREE_YEARS));
                selectTypeOfExperience(previousExperienceDetails.get(CommonControlDataDefns.EXPERIENCE_TYPE));

            }
        }
        selectAccessToAnotherVehicle(dynamicUnderwriterQuestions.get(ACCESS_TO_OTHER_VEHICLES));
        //Specific to Van
        if (((String) insuranceDetails.get(PRODUCT)).equalsIgnoreCase(VAN)) {
            waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NCD_MANY_YEARS_ON_OTHER_VEHICLE(),
                    SyncType.CLICKABLE, waitDuration);
            enterNumberOfNCDYearsOnOtherVehicles(ncdDetails.get(NCD_MANY_YEARS_ON_OTHER_VEHICLE));
            selectTypeOfPolicyNCDMirroredFrom(ncdDetails.get(WHAT_TYPE_OF_POLICY_NCD_MIRRORED_FROM));
        }

    }

    public void enterNumberOfNCDYearsOnOtherVehicles(Object ncdYears) throws CustomE2eException {
        if (isElementVisible(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NCD_MANY_YEARS_ON_OTHER_VEHICLE())) {
            typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NCD_MANY_YEARS_ON_OTHER_VEHICLE(), ncdYears, SyncType.CLICKABLE, true, false, "NCD do you have on your other vehicles");
        }
    }

    public void selectTypeOfPolicyNCDMirroredFrom(Object ncdMirrored) throws CustomE2eException {
        if (isElementVisible(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().WHAT_TYPE_OF_POLICY_NCD_MIRRORED_FROM())) {
            selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().WHAT_TYPE_OF_POLICY_NCD_MIRRORED_FROM(), ncdMirrored, SelectOptions.TEXT);
        }
    }

    public void addNewDriver() throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADD_NEW_DRIVER(),
                SyncType.CLICKABLE, waitDuration);
        RetryOnStaleElementException(5,
                () -> smartClickElement(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADD_NEW_DRIVER(),
                        this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DRIVER_PARTY_SELECTION(), "Add new driver"), "");
    }

    public void addNewVehicle() throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADD_NEW_VEHICLE(),
                SyncType.CLICKABLE, waitDuration);
        RetryOnStaleElementException(5,
                () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADD_NEW_VEHICLE(),
                        SyncType.CLICKABLE), "");
    }

    public void addClaim() throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADD_CLAIM(),
                SyncType.CLICKABLE, waitDuration);
        RetryOnStaleElementException(5,
                () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADD_CLAIM(),
                        SyncType.CLICKABLE), "");
    }

    public void enterClaimIncidentDate(Object claimDate) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CLAIM_INCIDENT_DATE(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CLAIM_INCIDENT_DATE(), claimDate, SyncType.CLICKABLE, true);
        refreshPage();
    }

    public void selectClaimStatus(Object status) throws CustomE2eException {
        if (isElementVisible(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CLAIM_STATUS())) {
            waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CLAIM_STATUS(), SyncType.CLICKABLE, waitDuration);
            selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CLAIM_STATUS(), status, SelectOptions.TEXT);
        }
    }

    public void selectClaimType(Object type) throws CustomE2eException {
        if (isElementVisible(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CLAIM_TYPE())) {
            waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CLAIM_TYPE(), SyncType.CLICKABLE, waitDuration);
            selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CLAIM_TYPE(), type, SelectOptions.TEXT);
        }
    }

    public void selectClaimCause(Object cause) throws CustomE2eException {
        refreshPage();
        if (isElementVisible(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CLAIM_CAUSE())) {
            waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CLAIM_CAUSE(), SyncType.CLICKABLE, waitDuration);
            selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CLAIM_CAUSE(), cause, SelectOptions.TEXT);
            refreshPage();
        }
    }

    public void enterOwnDamageCost(Object cost) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().OWN_DAMAGE_COST(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().OWN_DAMAGE_COST(), cost, SyncType.CLICKABLE, true);
    }

    public void enterThirdPartyDamageCost(Object cost) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().THIRD_PARTY_DAMAGE_COST(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().THIRD_PARTY_DAMAGE_COST(), cost, SyncType.CLICKABLE, true);
    }

    public void selectNCDAffected(boolean ncd) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(ncd);
        waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NCD_AFFECTED(), String.valueOf(value)), SyncType.CLICKABLE, waitDuration);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NCD_AFFECTED(), String.valueOf(value)), SyncType.CLICKABLE);

    }

    public void selectPolicyholderCover(boolean cover) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(cover);
        waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().UNDER_POLICYHOLDERS_COVER(), String.valueOf(value)), SyncType.CLICKABLE, waitDuration);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().UNDER_POLICYHOLDERS_COVER(), String.valueOf(value)), SyncType.CLICKABLE);

    }

    public void selectPersonalInjury(boolean injury) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(injury);
        waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PERSONAL_INJURY(), String.valueOf(value)), SyncType.CLICKABLE, waitDuration);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PERSONAL_INJURY(), String.valueOf(value)), SyncType.CLICKABLE);

    }

    public void addConviction() throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADD_CONVICTIONS(),
                SyncType.CLICKABLE, waitDuration);
        RetryOnStaleElementException(5,
                () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADD_CONVICTIONS(),
                        SyncType.CLICKABLE), "");
    }

    public void enterOffenceDate(Object offenceDate) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().OFFENCE_DATE(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().OFFENCE_DATE(), offenceDate, SyncType.CLICKABLE, true);
    }

    public void enterConvictionDate(Object convictionDate) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CONVICTION_DATE(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CONVICTION_DATE(), convictionDate, SyncType.CLICKABLE, true);
    }

    public void selectConvictionType(Object type) throws CustomE2eException {
        if (isElementVisible(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CONVICTION_TYPE())) {
            waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CONVICTION_TYPE(), SyncType.CLICKABLE, waitDuration);
            var value = getMatchingValueFromDropDown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CONVICTION_TYPE(), (String) type);
            selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CONVICTION_TYPE(), value, SelectOptions.TEXT);
        }
    }

    public void enterPoints(Object points) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().MOTORING_POINTS(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().MOTORING_POINTS(), points, SyncType.CLICKABLE, true);
    }

    public void enterSuspensionMonths(Object months) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SUSPENSION_MONTH(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SUSPENSION_MONTH(), months, SyncType.CLICKABLE, true);
    }

    public void enterFine(Object fine) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().MOTORING_FINE(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().MOTORING_FINE(), fine, SyncType.CLICKABLE, true);
    }

    public void selectDisqualified(boolean disqualified) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(disqualified);
        waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DISQUALIFIED(), String.valueOf(value)), SyncType.CLICKABLE, waitDuration);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DISQUALIFIED(), String.valueOf(value)), SyncType.CLICKABLE);

    }


    public void addVehicleDetails(Map<String, Object> salesDetails) throws CustomE2eException {
        var quotesDetails = (Map<String, Object>) salesDetails.get(QUOTE_DETAILS);
        var insuranceDetails = (Map<String, Object>) salesDetails.get(INSURANCE_DETAILS);
        var vehicle = (Map<String, Object>) salesDetails.get(VEHICLE);
        var vehicleFeatures = (Map<String, Object>) vehicle.get(VEHICLE_FEATURES);
        var vehicleUse = (Map<String, Object>) vehicle.get(VEHICLE_USE);
        var vehicleAdditionalInformation = (Map<String, Object>) vehicle.get(VEHICLE_ADDITIONAL_INFORMATION);
        var parkingDetails = (Map<String, Object>) vehicle.get(PARKING_DETAILS);
        var registeredOwner = (Map<String, Object>) salesDetails.get(REGISTERED_OWNER);
        var registeredOwnerDetails = (Map<String, Object>) registeredOwner.get(REGISTERED_OWNER_DETAILS);
        var carModificationDetails = (Map<String, Object>) vehicleFeatures.get(CAR_MODIFICATION);
        addNewVehicle();
        enterVRN(vehicle.get(REGISTRATION_NUMBER));

  //      clickManualSearchButton();


//        String str = (String) vehicle.get(VEHICLE_DETAILS);
//        Map<String, String> vehicleDetails = Arrays.stream(str.substring(1, str.length() - 1).split(", "))
//                .map(s -> s.split("=", 2)).collect(Collectors.toMap(s -> s[0].trim(), s -> s[1].trim()));

//        var vehicleModel = enterVehicleDetails(vehicleDetails.get(VEHICLE_MAKE), vehicleDetails.get(VEHICLE_MODEL),
//                vehicleDetails.get(FUEL_TYPE), vehicleDetails.get(YEAR_OF_MANUFACTURE), insuranceDetails);
//        clickVehicleSearchOnPopup();
//        selectVehicleFromList(vehicleDetails.get(ABI_CODE), vehicleModel);
//        refreshPage();
        searchVehicle();
        enterNumberOfSeats(vehicle.get(NUMBER_OF_SEATS));
        enterNumberOfDoors(vehicle.get(NUMBER_OF_DOORS));
//        enterVehicleMarketValue((String) vehicle.get(MARKET_VALUE));
        enterVehicleMarketValue(String.valueOf(vehicle.get(MARKET_VALUE)));

        //Specific to Van
        if (((String) insuranceDetails.get(PRODUCT)).equalsIgnoreCase(VAN)) {
           // enterNumberOfSeats(vehicleFeatures.get(NUMBER_OF_SEATS));
 //           enterVehicleMarketValue((String) vehicle.get(MARKET_VALUE));
            selectVehicleFittedWithRacking((boolean) vehicleFeatures.get(VEHICLE_FITTED_WITH_RACKING));
            selectVehicleCarrySignage((boolean) vehicleFeatures.get(DOES_VEHICLE_CARRY_SIGNAGE));
        }


        selectAlarm(vehicleFeatures.get(ALARM));
 //       selectImmobiliser(vehicleFeatures.get(IMMOBILISER));
 //       selectTracker(vehicleFeatures.get(TRACKER));
        selectDashcam(vehicleFeatures.get(DASHCAM));
        leftHandDrive((Boolean) vehicleFeatures.get(LEFT_HAND_DRIVE));
       vehicleImported(vehicleFeatures.get(VEHICLE_IMPORTED));
        carModification((Boolean) carModificationDetails.get(MODIFICATION));
        if ((Boolean) carModificationDetails.get(MODIFICATION)) {
            var modificationDetails = (String) carModificationDetails.get(MODIFICATION_DETAILS);
            var details = modificationDetails.split(",");
            selectModification(details[0].trim());
            for (var modificationCount = 1; modificationCount < details.length; modificationCount++) {
                addModification();
                selectModification(details[modificationCount].trim());
            }

        }
        vehicleUsage(vehicleUse.get(USAGE));
        enterAnnualMileage(vehicleUse.get(ANNUAL_MILEAGE));
        enterBusinessMileage(vehicleUse.get(BUSINESS_MILEAGE));


        //For Van
        if (((String) insuranceDetails.get(PRODUCT)).equalsIgnoreCase(VAN)) {
            selectUseForSocialAndPleasure((boolean) vehicleUse.get(FOR_SOCIAL_AND_PLEASURE));
            enterWhenDidYouBuyYourCar(vehicleAdditionalInformation.get(WHEN_DID_YOU_BUY_YOUR_CAR));
            selectPublicLiabilityInForce((boolean) vehicleAdditionalInformation.get(PUBLIC_LIABILITY_IN_FORCE));
            selectWillVehicleCarryHazardousGoods((boolean) vehicleAdditionalInformation.get(WILL_VEHICLE_CARRY_HAZARDOUS_GOODS));
        }

        enterVehiclePurchaseDate(vehicleUse.get(CAR_PURCHASE_DATE));
        vehicleDayParking(parkingDetails.get(PARKING_DURING_DAY));
        vehicleNightParking(parkingDetails.get(PARKING_DURING_NIGHT));
        enterParkingPostcode(parkingDetails.get(POSTCODE));
        if (parkingDetails.get(PARKING_DURING_NIGHT).toString().equalsIgnoreCase("Roadside")) {
            overNightLocation(parkingDetails.get(CommonControlDataDefns.OVERNIGHT_LOCATION));
        }
        vehicleOwner(registeredOwner.get(OWNER));
        registeredKeeper((Boolean) registeredOwnerDetails.get(PROPOSER_REGISTERED_KEEPER));
        if (!(Boolean) registeredOwnerDetails.get(PROPOSER_REGISTERED_KEEPER)) {
            selectRegisteredKeeper(registeredOwnerDetails.get(REGISTERED_KEEPER));
        }

    }

    public void selectVehicleFromList(String abiCode, String model) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().MANUAL_SEARCH(),
                SyncType.CLICKABLE, waitDuration);
        var count = 0;

        do {
            RetryOnStaleElementException(2,
                    () ->
                            scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_LIST()), "");
            int vehicleCount = getElementsMatchingToLocator(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_LIST()).size();
            for (var row = 1; row <= vehicleCount; row++) {
                var getAbiCode = getText(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ABI_CODE_LIST(), String.valueOf(row)));
                if (getAbiCode.equalsIgnoreCase(abiCode)) {
                    int finalRow = row;
                    RetryOnStaleElementException(2,
                            () -> clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SELECT_VEHICLE_FROM_LIST(), String.valueOf(finalRow)), SyncType.CLICKABLE), "");
                    count = count + 1;
                    break;
                }
            }
            if (count == 0) {
                RetryOnStaleElementException(2,
                        () ->
                                scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NAVIGATE_VEHICLE_LIST()), "");
                if (isElementEnabled(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NAVIGATE_VEHICLE_LIST())) {
                    RetryOnStaleElementException(2,
                            () ->
                                    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NAVIGATE_VEHICLE_LIST(), SyncType.CLICKABLE), "");
                }
            }

        } while (count == 0 && isElementVisible(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NAVIGATE_VEHICLE_LIST()));
        if(count==0){
            var vehicleModel = getVehicleModelFromDropdown(model);
            RetryOnStaleElementException(5,
                    () -> selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SELECT_VEHICLE_MODEL(), vehicleModel, SelectOptions.TEXT), "");
            clickVehicleSearchOnPopup();

            do {
                RetryOnStaleElementException(5,
                        () ->
                                scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_LIST()), "");
                int vehicleCount = getElementsMatchingToLocator(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_LIST()).size();
                for (var row = 1; row <= vehicleCount; row++) {
                    var getAbiCode = getText(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ABI_CODE_LIST(), String.valueOf(row)));
                    if (getAbiCode.equalsIgnoreCase(abiCode)) {
                        int finalRow = row;
                        RetryOnStaleElementException(5,
                                () -> clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SELECT_VEHICLE_FROM_LIST(), String.valueOf(finalRow)), SyncType.CLICKABLE), "");
                        count = count + 1;
                        break;
                    }
                }
                if (count == 0) {
                    RetryOnStaleElementException(5,
                            () ->
                                    scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NAVIGATE_VEHICLE_LIST()), "");
                    if (isElementEnabled(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NAVIGATE_VEHICLE_LIST())) {
                        RetryOnStaleElementException(5,
                                () ->
                                        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NAVIGATE_VEHICLE_LIST(), SyncType.CLICKABLE), "");
                    }
                }

            } while (count == 0 && isElementVisible(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NAVIGATE_VEHICLE_LIST()));

        }
    }


    public void clickManualSearchButton() throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().MANUAL_SEARCH(),
                SyncType.CLICKABLE, waitDuration);
        RetryOnStaleElementException(5,
                () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().MANUAL_SEARCH(),
                        SyncType.CLICKABLE), "");
    }

    public String enterVehicleDetails(String make, String model, String fuel, String yearOfManufacture, Map<String, Object> insuranceDetails) throws CustomE2eException {
        String vehicleModel;
        if (isElementVisible(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_MANUAL_SEARCH_POPUP())) {
            waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SELECT_VEHICLE_MAKE(), SyncType.CLICKABLE, waitDuration);
            selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SELECT_VEHICLE_MAKE(), make.trim(), SelectOptions.TEXT);
            vehicleModel = getVehicleModelFromDropdown(model.trim());
            RetryOnStaleElementException(5,
                    () -> selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SELECT_VEHICLE_MODEL(), vehicleModel, SelectOptions.TEXT), "");


//            selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SELECT_VEHICLE_MODEL(), vehicleModel, SelectOptions.TEXT);
//            selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SELECT_VEHICLE_MODEL(), model, SelectOptions.TEXT);
            if (((String) insuranceDetails.get(PRODUCT)).equalsIgnoreCase(VAN)) {
                typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ENTER_YEAR_OF_MANUFACTURE_VAN(), yearOfManufacture, SyncType.CLICKABLE, true);
            } else {
                waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SELECT_FUEL_TYPE(), SyncType.CLICKABLE, waitDuration);
                selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SELECT_FUEL_TYPE(), fuel, SelectOptions.TEXT);
                waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ENTER_YEAR_OF_MANUFACTURE(), SyncType.CLICKABLE, waitDuration);
                typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ENTER_YEAR_OF_MANUFACTURE(), yearOfManufacture, SyncType.CLICKABLE, true);
            }
            return vehicleModel;
        }
        return null;
    }

    public String getVehicleModelFromDropdown(String model) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SELECT_VEHICLE_MODEL(), SyncType.CLICKABLE, waitDuration);
        var modelList = RetryOnStaleElementException(5,
                () ->
                        getAllValuesFromDropDown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SELECT_VEHICLE_MODEL(), ""), "");

        String matchingVal = null;
        var modelValue = model.split(" ");
        var modelCount = 0;
        for(int modelStringCount=0;modelStringCount<modelValue.length;modelStringCount++){
            for (var currVal : modelList) {
                if (currVal.getText().trim().equalsIgnoreCase(model)) {
                    matchingVal = currVal.getText();
                    modelCount++;
                    break;
                }
            }
            if(modelCount==0) {
                int lastDelimiter = model.lastIndexOf(" ");
                model = model.substring(0, lastDelimiter);
                for (var currVal : modelList) {
                    if (currVal.getText().trim().equalsIgnoreCase(model)) {
                        matchingVal = currVal.getText();
                        break;
                    }
                }
            }
        }
        return matchingVal;

    }

    public void searchVehicle() throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SEARCH_VEHICLE(),
                SyncType.CLICKABLE, waitDuration);
        RetryOnStaleElementException(5,
                () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SEARCH_VEHICLE(),
                        SyncType.CLICKABLE), "");
    }


    public void enterVehicleMarketValue(String marketValue) throws CustomE2eException {
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_MARKET_VALUE(), marketValue, SyncType.CLICKABLE, true, false, "Market value of vehicle not known");
    }


    public void enterNumberOfDoors(Object nOfDoors) throws CustomE2eException {
        if (isElementEnabled(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NUMBER_OF_DOORS())) {
            typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NUMBER_OF_DOORS(), String.valueOf(nOfDoors), SyncType.CLICKABLE, true);
        }
    }

    public void clickVehicleSearchOnPopup() throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_SEARCH_POPUP(),
                SyncType.CLICKABLE, waitDuration);
        RetryOnStaleElementException(5,
                () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_SEARCH_POPUP(),
                        SyncType.CLICKABLE), "");
    }

    public String getVehicleMake() throws CustomE2eException {
        var makeValue = getAttribute(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_MAKE(), "value", "Vehicle make not found");
        var make = makeValue.split(" ");
        make[0] = make[0].substring(0, 1).toUpperCase() + make[0].substring(1).toLowerCase();
        return make[0];
    }

    public String getVehicleMarketValue() throws CustomE2eException {
        return getAttribute(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_MARKET_VALUE(), "value", "Market value of vehicle not known");
    }

    public String getNumberOfSeats() throws CustomE2eException {
        return getAttribute(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NUMBER_OF_SEATS(), "value", "Number of seats for vehicle not known");
    }

    public String getVehicleModel() throws CustomE2eException {
        var model = getAttribute(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_MODEL(), "value", "Vehicle model not found");
//        var modelValue = model.split(" ")[0];
//        model = modelValue.substring(0, 1).toUpperCase() + modelValue.substring(1).toLowerCase();
        return model;
    }

    public String getFuelType() throws CustomE2eException {
        var fuel = getAttribute(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().FUEL_TYPE(), "value", "Fuel type not known");
        if (fuel.contains("DIESEL")||fuel.contains("Diesel")) {
            return "Diesel";
        } else if (fuel.contains("PETROL")||fuel.contains("Petrol")) {
            return "Petrol";
        } else {
            throw new CustomE2eException("Fuel type doesn't match");
        }
    }

    public String getYearOfManufacture() throws CustomE2eException {
        return getAttribute(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().YEAR_OF_MANUFACTURE(), "value", "Year of manufacture");
    }

    public String getABICode() throws CustomE2eException {
        return getAttribute(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ABI_CODE(), "value", "ABI code missing");
    }

    public void addExcess(Map<String, Object> salesDetails) throws CustomE2eException {
        var excess = (Map<String, Object>) salesDetails.get(EXCESS);
        String drivingRestrictions = (String) ((Map<String, Object>) salesDetails.get(INSURANCE_DETAILS)).get(DRIVING_RESTRICTIONS);
        addVoluntaryExcess(excess.get(CommonControlDataDefns.VOLUNTARY_EXCESS));
        calculatePremium();
        clickPackageChange();
        clickPackageConfirm();
        calculatePremium();
        //       addAccidentalDamage(excess.get(ACCIDENTAL_DAMAGE));
//        if (drivingRestrictions.equalsIgnoreCase("Insured Only")) {
//            addOptionalExtras((String) salesDetails.get(OPTIONAL_EXTRAS));
//        }
        var consent = salesDetails.get(CommonControlDataDefns.CONSENT_TO_RENEW);
        if (consent instanceof String) {
            consent =
                Boolean.parseBoolean((String) salesDetails.get(CommonControlDataDefns.CONSENT_TO_RENEW));
        } else if (consent instanceof Boolean) {
            consent = salesDetails.get(CommonControlDataDefns.CONSENT_TO_RENEW);
        }
        consentToRenew((Boolean) consent);
    }

    public void addVoluntaryExcess(Object excess) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VOLUNTARY_EXCESS(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VOLUNTARY_EXCESS(), String.valueOf(excess), SelectOptions.TEXT);

    }

    public void selectRegisteredKeeper(Object keeper) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().TYPE_REGISTERED_KEEPER(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().TYPE_REGISTERED_KEEPER(), keeper, SelectOptions.TEXT);
    }

    public void consentToRenew(boolean renew) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(renew);
        waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CONSENT_TO_RENEW(), String.valueOf(value)), SyncType.CLICKABLE, waitDuration);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CONSENT_TO_RENEW(), String.valueOf(value)), SyncType.CLICKABLE);

    }

    public void calculatePremium() throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CALCULATE_PREMIUM(),
                SyncType.CLICKABLE, waitDuration);
        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(20),
                () -> clickElement(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().CALCULATE_PREMIUM(),
                        SyncType.CLICKABLE));
    }

    public void clickPackageChange() throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PACKAGE_CHANGE(),
                SyncType.CLICKABLE, waitDuration);
        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(20),
                () -> clickElement(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PACKAGE_CHANGE(),
                        SyncType.CLICKABLE));
    }

    public void clickPackageConfirm() throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PACKAGE_CONFIRM(),
                SyncType.CLICKABLE, waitDuration);
        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(20),
                () -> clickElement(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PACKAGE_CONFIRM(),
                        SyncType.CLICKABLE));
    }

    public void enterVehiclePurchaseDate(Object purchase) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_PURCHASE_DATE(),SyncType.CLICKABLE,waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_PURCHASE_DATE(), purchase, SyncType.CLICKABLE, true);
    }

    public void leftHandDrive(boolean drive) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(drive);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().LEFT_HAND_DRIVE(), String.valueOf(value)), SyncType.CLICKABLE);

    }

    public void vehicleImported(Object imported) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoString((Boolean) imported);
        if (isElementVisible(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().IS_VEHICLE_IMPORTED())) {
            waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().IS_VEHICLE_IMPORTED(), SyncType.CLICKABLE, waitDuration);
            selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().IS_VEHICLE_IMPORTED(), value, SelectOptions.TEXT);
        }
    }

    public void vehicleOwner(Object owner) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_OWNER(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_OWNER(), owner, SelectOptions.TEXT);
    }

    public void registeredKeeper(boolean keeper) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(keeper);
//        waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PROPOSER_REGISTERED_KEEPER(), String.valueOf(value)), SyncType.CLICKABLE, waitDuration);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PROPOSER_REGISTERED_KEEPER(), String.valueOf(value)), SyncType.CLICKABLE);

    }

    public void vehicleDayParking(Object parking) throws CustomE2eException {
        if (isElementVisible(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DAY_PARKING())) {
            waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DAY_PARKING(), SyncType.CLICKABLE, waitDuration);
            selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DAY_PARKING(), parking, SelectOptions.TEXT);
        }
    }

    public void vehicleNightParking(Object parking) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NIGHT_PARKING(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NIGHT_PARKING(), parking, SelectOptions.TEXT);
//        refreshPage();
    }

    public void overNightLocation(Object location) throws CustomE2eException {
        if (isElementVisible(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().OVERNIGHT_PARKING())) {
            waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().OVERNIGHT_PARKING(), SyncType.CLICKABLE, waitDuration);
            selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().OVERNIGHT_PARKING(), location, SelectOptions.TEXT);
        }
    }

    public void enterParkingPostcode(Object postcode) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PARKING_POSTCODE(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PARKING_POSTCODE(), postcode, SyncType.CLICKABLE, true);
    }

    public void vehicleUsage(Object usage) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_USAGE(), SyncType.CLICKABLE, waitDuration);
        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(10),
                () -> selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_USAGE(), usage, SelectOptions.TEXT));
    }

    public void enterAnnualMileage(Object mileage) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ANNUAL_MILEAGE(), SyncType.CLICKABLE, waitDuration);
        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(10),
                () -> typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ANNUAL_MILEAGE(), mileage, SyncType.CLICKABLE, true));
    }

    public void enterBusinessMileage(Object mileage) throws CustomE2eException {
        if (isElementVisible(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().BUSINESS_MILEAGE())) {
            waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().BUSINESS_MILEAGE(), SyncType.CLICKABLE, waitDuration);
            typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().BUSINESS_MILEAGE(), mileage, SyncType.CLICKABLE, true);
        }
    }

    public void carModification(boolean modification) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(modification);
        if (isElementVisible(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().IS_VEHICLE_MODIFIED(), String.valueOf(value)))) {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().IS_VEHICLE_MODIFIED(), String.valueOf(value)), SyncType.CLICKABLE);
        }
    }

    public void selectModification(Object details) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_MODIFICATION(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_MODIFICATION(), details, SelectOptions.TEXT);
    }

    public void addModification() throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADD_MODIFICATION(), SyncType.CLICKABLE, waitDuration);
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADD_MODIFICATION(), SyncType.CLICKABLE);
    }

    public void enterVRN(Object vrn) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADD_VEHICLE_REG_NUMBER(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADD_VEHICLE_REG_NUMBER(), vrn, SyncType.CLICKABLE, true);
    }

    public void selectDriverParty(Object driverParty) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DRIVER_PARTY_SELECTION(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DRIVER_PARTY_SELECTION(), driverParty, SelectOptions.TEXT);
    }

    public void selectAlarm(Object alarm) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_ALARM(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_ALARM(), alarm, SelectOptions.TEXT);
    }

    public void selectImmobiliser(Object immobiliser) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().IMMOBILISER(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().IMMOBILISER(), immobiliser, SelectOptions.TEXT);
    }

    public void selectTracker(Object tracker) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().TRACKER(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().TRACKER(), tracker, SelectOptions.TEXT);
    }

    public void selectDashcam(Object dashcam) throws CustomE2eException {
        if (isElementVisible(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DASHCAM())) {
            waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DASHCAM(), SyncType.CLICKABLE, waitDuration);
            selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DASHCAM(), dashcam, SelectOptions.TEXT);
        }
    }


    public void selectDriverType(Object driverType) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DRIVER_TYPE(), SyncType.CLICKABLE, 60000L);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DRIVER_TYPE(), driverType, SelectOptions.TEXT);
    }

    public void relationshipToProposer(Object relationship) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DRIVER_RELATIONSHIP_TO_PROPOSER(), SyncType.CLICKABLE, 60000L);
//        if(isElementEnabled(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DRIVER_RELATIONSHIP_TO_PROPOSER())) {
//            selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DRIVER_RELATIONSHIP_TO_PROPOSER(), relationship, SelectOptions.TEXT);
//        }

        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DRIVER_RELATIONSHIP_TO_PROPOSER(), relationship, SelectOptions.TEXT);
    }

    public void driverTitle(Object title) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_TITLE(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_TITLE(), title, SelectOptions.TEXT);
    }

    public void additionalDriverGender(Object gender) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_GENDER(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_GENDER(), gender, SelectOptions.TEXT);
    }

    public void additionalDriverMaritalStatus(Object marital) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_MARITAL_STATUS(), SyncType.CLICKABLE, waitDuration);
        if(isElementEnabled(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_MARITAL_STATUS())) {
            selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_MARITAL_STATUS(), marital, SelectOptions.TEXT);
        }
    }

    public void selectLicenceType(Object licence) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().LICENCE_TYPE(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().LICENCE_TYPE(), licence, SelectOptions.TEXT);
    }

    public void enterAdditionalDriverFirstName(Object firstName) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_FIRSTNAME(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_FIRSTNAME(), firstName, SyncType.CLICKABLE);
    }

    public void enterAdditionalDriverLastName(Object lastName) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_LASTNAME(), SyncType.CLICKABLE, waitDuration);
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_LASTNAME(), SyncType.CLICKABLE);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_LASTNAME(), lastName, SyncType.CLICKABLE, true);
    }

    public void enterAdditionalDriverDOB(Object dob) throws CustomE2eException {
//        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_DOB(), SyncType.CLICKABLE, waitDuration);
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_DOB(), SyncType.CLICKABLE);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_DOB(), dob, SyncType.CLICKABLE, true);
    }

    public void licenceAcquisitionDate(Object licenceDate) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().LICENCE_ISSUE_DATE(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().LICENCE_ISSUE_DATE(), licenceDate, SyncType.CLICKABLE, true);
    }

    public void enterLicenceNumber(Object licenceNumber) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().LICENCE_NUMBER(), SyncType.CLICKABLE, waitDuration);
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().LICENCE_NUMBER(), SyncType.CLICKABLE);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().LICENCE_NUMBER(), licenceNumber, SyncType.CLICKABLE, true);
    }

    public void selectAccessToAnotherVehicle(Object access) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ACCESS_TO_OTHER_VEHICLES(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ACCESS_TO_OTHER_VEHICLES(), access, SelectOptions.TEXT);
    }

    public void additionalDriverAccessToAnotherVehicle(Object access) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_ACCESS_TO_OTHER_VEHICLES(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_ACCESS_TO_OTHER_VEHICLES(), access, SelectOptions.TEXT);
    }

    public void selectPreviousInsuranceRefused(boolean insurance) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(insurance);
        if (isElementVisible(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PREVIOUS_INSURANCE_REFUSED(), String.valueOf(value)))) {
            waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PREVIOUS_INSURANCE_REFUSED(), String.valueOf(value)), SyncType.CLICKABLE, waitDuration);
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PREVIOUS_INSURANCE_REFUSED(), String.valueOf(value)), SyncType.CLICKABLE);
        }
    }

    public void selectNonRTAConviction(boolean conviction) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(conviction);
        if (isElementVisible(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NON_RTA_CONVICTIONS(), String.valueOf(value)))) {
            waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NON_RTA_CONVICTIONS(), String.valueOf(value)), SyncType.CLICKABLE, waitDuration);
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NON_RTA_CONVICTIONS(), String.valueOf(value)), SyncType.CLICKABLE);
        }
    }

    public void selectNcdApplied(boolean ncdApplied) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(ncdApplied);
        waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NCD_APPLIED_TO_OTHER_VEHICLES(), String.valueOf(value)), SyncType.CLICKABLE, waitDuration);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NCD_APPLIED_TO_OTHER_VEHICLES(), String.valueOf(value)), SyncType.CLICKABLE);

    }

    public void enterNumberOfNCDClaimYears(Object ncdYears) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NCD_DISCOUNT_YEARS(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NCD_DISCOUNT_YEARS(), ncdYears, SyncType.CLICKABLE, true);
    }

    public void protectNCD(boolean ncd_yes_no) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(ncd_yes_no);
        //scrollElementIntoCenterOfScreen(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PROTECT_NCD_CLAIM(), String.valueOf(value)));
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PROTECT_NCD_CLAIM(), String.valueOf(value)), SyncType.CLICKABLE);
    }

    public void selectDrivingExperienceNotInProposerName(boolean drivingExperience) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(drivingExperience);
        //scrollElementIntoCenterOfScreen(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PROTECT_NCD_CLAIM(), String.valueOf(value)));
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DRIVING_EXPERIENCE_NOT_IN_PROPOSER_NAME(), String.valueOf(value)), SyncType.CLICKABLE);
    }

    public void selectTypeOfExperience(Object experience) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().TYPE_OF_EXPERIENCE(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().TYPE_OF_EXPERIENCE(), experience, SelectOptions.TEXT);
    }

    public void enterClaimFreeYears(Object years) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CLAIM_FREE_YEARS(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CLAIM_FREE_YEARS(), years, SyncType.CLICKABLE, true, false, "Claim free years not tabbed");
    }


    public void selectPreviousInsurance(boolean previousInsurance) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(previousInsurance);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PREVIOUS_MOTOR_INSURANCE(), String.valueOf(value)), SyncType.CLICKABLE);

    }

    public void cancelPartySearch() throws CustomE2eException {
        if (isElementVisible(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PARTY_SEARCH_CANCEL())) {
            waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PARTY_SEARCH_CANCEL(), SyncType.CLICKABLE, waitDuration);
            clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PARTY_SEARCH_CANCEL(), SyncType.CLICKABLE);
        }

    }

    public void cancelClaimError() throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CLAIM_ERROR_POPUP(), SyncType.CLICKABLE, waitDuration);
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().CLAIM_ERROR_POPUP(), SyncType.CLICKABLE);

    }

    public void selectIamMember(boolean iAmMember) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(iAmMember);
        if (isElementVisible(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().IAM_ORGANISATION(), String.valueOf(value)))) {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().IAM_ORGANISATION(), String.valueOf(value)), SyncType.CLICKABLE);
        }
    }

    public void selectAffordabilityThreshold(Object affordability) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger((Boolean) affordability);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().AFFORDABILITY_THRESHOLD(), String.valueOf(value)), SyncType.CLICKABLE);
    }

    public void selectFinanceRekey(boolean financeRekey) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(financeRekey);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PREMIUM_FINANCE_REKEY(), String.valueOf(value)), SyncType.CLICKABLE);
    }

    public void enterNumberOfOtherCars(Object numberOfCars) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().EXTRA_CARS(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().EXTRA_CARS(), numberOfCars, SyncType.CLICKABLE, true);
    }

    public void useOfVehicleByProposer(Object vehicleUse) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_USAGE_BY_PROPOSER(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_USAGE_BY_PROPOSER(), vehicleUse, SelectOptions.TEXT);
    }

    public void selectPreviousInsuranceType(Object type) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().TYPE_OF_INSURANCE(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().TYPE_OF_INSURANCE(), type, SelectOptions.TEXT);
    }

    public void preferredPaymentMethod(Object payment) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PREFERRED_PAYMENT_METHOD(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PREFERRED_PAYMENT_METHOD(), payment, SelectOptions.TEXT);
    }

    public void proposerHomeOwner(Object homeOwner) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().HOME_OWNER(), SyncType.CLICKABLE, waitDuration);
        if (homeOwner.toString().equalsIgnoreCase("Unknown")) {
            selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().HOME_OWNER(), homeOwner.toString(), SelectOptions.TEXT);
        } else {
            var value = this.CommonHelper.convertBooleanIntoString((Boolean) homeOwner);
            selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().HOME_OWNER(), value, SelectOptions.TEXT);
        }
    }

    public void selectSecondaryEmployment(boolean secondaryEmployment) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(secondaryEmployment);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SECONDARY_JOB(), String.valueOf(value)), SyncType.CLICKABLE);
    }

    public void selectADSecondaryEmployment(boolean secondaryEmployment) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(secondaryEmployment);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_SECOND_JOB(), String.valueOf(value)), SyncType.CLICKABLE);
    }

    public void preferredDelivery(Object deliveryMethod) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PREFERRED_DELIVERY(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().PREFERRED_DELIVERY(), deliveryMethod, SelectOptions.TEXT);
    }

    public void residencyInUK(Object ukResidencyDate) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().RESIDENCY_SINCE_DATE(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().RESIDENCY_SINCE_DATE(), ukResidencyDate, SyncType.CLICKABLE, true);
    }

    public void additionalDriverResidencyInUK(Object ukResidencyDate) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().AD_RESIDENCE_IN_UK(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().AD_RESIDENCE_IN_UK(), ukResidencyDate, SyncType.CLICKABLE);
    }

    public void previousPolicyExpiryDate(Object prevPolicyExpDate) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PREVIOUS_POLICY_END_DATE(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PREVIOUS_POLICY_END_DATE(), prevPolicyExpDate, SyncType.CLICKABLE, true);
    }

    public void proposerOccupation(Object occupation) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().FULLTIME_OCCUPATION(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().FULLTIME_OCCUPATION(), occupation, SelectOptions.TEXT);
    }

    public void additionalDriverOccupation(Object occupation) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_OCCUPATION(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_OCCUPATION(), occupation, SelectOptions.TEXT);
    }

    public void proposerJobCategory(Object jobStatus) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PROPOSER_EMP_STATUS(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PROPOSER_EMP_STATUS(), jobStatus, SelectOptions.TEXT);
    }

    public void additionalDriverJobCategory(Object jobStatus) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_EMP_STATUS(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_EMP_STATUS(), jobStatus, SelectOptions.TEXT);
    }

    public void proposerJobIndustry(Object jobIndustry) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().EMPLOYMENT_INDUSTRY(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().EMPLOYMENT_INDUSTRY(), jobIndustry, SelectOptions.TEXT);
    }

    public void additionalDriverJobIndustry(Object jobIndustry) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_EMP_BUSINESS(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().ADDITIONAL_DRIVER_EMP_BUSINESS(), jobIndustry, SelectOptions.TEXT);
    }

    public void proposerSecondaryOccupation(Object occupation) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SECOND_JOB_OCCUPATION(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SECOND_JOB_OCCUPATION(), occupation, SelectOptions.TEXT);
    }

    public void additionalDriverSecondaryOccupation(Object occupation) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().AD_SECOND_JOB_DESCRIPTION(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().AD_SECOND_JOB_DESCRIPTION(), occupation, SelectOptions.TEXT);
    }

    public void proposerSecondaryJobCategory(Object jobStatus) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SECOND_EMPLOYMENT_STATUS(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SECOND_EMPLOYMENT_STATUS(), jobStatus, SelectOptions.TEXT);
    }

    public void additionalDriverSecondaryJobCategory(Object jobStatus) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().AD_SECOND_JOB_STATUS(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().AD_SECOND_JOB_STATUS(), jobStatus, SelectOptions.TEXT);
    }

    public void proposerSecondaryJobIndustry(Object jobIndustry) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SECOND_JOB_INDUSTRY(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().SECOND_JOB_INDUSTRY(), jobIndustry, SelectOptions.TEXT);
    }

    public void additionalDriverSecondaryJobIndustry(Object jobIndustry) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().AD_SECOND_JOB_BUSINESS(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().AD_SECOND_JOB_BUSINESS(), jobIndustry, SelectOptions.TEXT);
    }

    public void proposerEmployerBusiness(Object industry) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().EMPLOYMENT_INDUSTRY(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().EMPLOYMENT_INDUSTRY(), industry, SelectOptions.TEXT);
    }

    public void selectEnquiry(String enquiry) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SELECT_ENQUIRY(), SyncType.CLICKABLE, waitDuration);
        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(10),
                () ->clickElement(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SELECT_ENQUIRY(),
                        SyncType.CLICKABLE));
        scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SELECT_ENQUIRY());
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SELECT_ENQUIRY(), enquiry, SelectOptions.TEXT);
    }

    public void selectSalesChannel(String salesChannel) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SALES_CHANNEL(), SyncType.CLICKABLE, waitDuration);
        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(10),
                () -> clickElement(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SALES_CHANNEL(),
                        SyncType.CLICKABLE));
        scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SALES_CHANNEL());
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().SALES_CHANNEL(), salesChannel, SelectOptions.TEXT);
    }

    public void selectMotorProduct(String productType) throws CustomE2eException {
        String prodType;
        if (productType.trim().equalsIgnoreCase(EisGeneralStepDefinitions.PROD_TYPE_PRIVATE_CAR)) {
            prodType = EisGeneralStepDefinitions.PROD_TYPE_PRIVATE_CAR;
        } else {
            prodType = PROD_TYPE_VAN_VAR;
        }
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().MOTOR_PRODUCT_TYPE(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().MOTOR_PRODUCT_TYPE(), prodType
                , SelectOptions.TEXT);
        refreshPage();
    }

    public void selectScheme(String scheme) throws CustomE2eException {
        if (isElementEnabled(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().MOTOR_SCHEME())) {
            waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().MOTOR_SCHEME(), SyncType.CLICKABLE, waitDuration);
            var value = getMatchingValueStartWithFromDropDown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().MOTOR_SCHEME(), scheme);
            RetryOnException("Select Scheme", CustomE2eException.class, 500L, 50,
                    () -> selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().MOTOR_SCHEME(), value, SelectOptions.TEXT));
        }

    }

    private void selectAffinity(String affinity) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().AFFINITY_CODE(), SyncType.CLICKABLE, waitDuration);
        var value =
                getMatchingValueStartWithFromDropDown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().AFFINITY_CODE(), affinity);
        RetryOnException("Select affinity", CustomE2eException.class, 500L, 50,
                () -> selectDropdown(this.pageObjectOfEis.getEisQuoteCreationLocatorModel().AFFINITY_CODE(), value, SelectOptions.TEXT));
    }

    public void selectCover(String cover) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().COVER_TYPE(), SyncType.CLICKABLE, waitDuration);
        var value = getMatchingValueStartWithFromDropDown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().COVER_TYPE(), cover);
        if (isElementEnabled(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().COVER_TYPE())) {
            RetryOnException("Select Cover", CustomE2eException.class, 500L, 50,
                    () -> selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().COVER_TYPE(), value, SelectOptions.TEXT));

        }
    }

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

    public String getMatchingValueFromDropDown(By byLocator, String value) throws CustomE2eException {
        String matchingVal = null;
        var options = getAllValuesFromDropDown(byLocator, "selectDropdown failed");
        for (var currVal : options) {
            if ((currVal.getText() != "") && (currVal.getText().toLowerCase().contains(value.toLowerCase()))) {
                matchingVal = currVal.getText();
                break;
            }
        }
        return matchingVal;
    }

    public void enterPolicyStartDate(String date) throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().POLICY_START_DATE(), SyncType.CLICKABLE, waitDuration);
        typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().POLICY_START_DATE(), date, SyncType.CLICKABLE, true);
    }

    public void selectDrivingRestrictions(String drivingRestrictions) throws CustomE2eException {
        refreshPage();
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DRIVING_RESTRICTIONS(), SyncType.CLICKABLE, waitDuration);
        selectDropdown(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DRIVING_RESTRICTIONS(), drivingRestrictions
                , SelectOptions.TEXT);
    }


    public void enterNumberOfSeats(Object nOfDoors) throws CustomE2eException {
        if(isElementEnabled(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NUMBER_OF_SEATS())) {
            waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NUMBER_OF_SEATS(),
                    SyncType.CLICKABLE, waitDuration);
            typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().NUMBER_OF_SEATS(), nOfDoors, SyncType.CLICKABLE, true, false, "Number of Seats for the van");
        }
    }

    public void selectVehicleFittedWithRacking(boolean selectRackingFlag) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(selectRackingFlag);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_FITTED_WITH_RACKING(), String.valueOf(value)), SyncType.CLICKABLE);
    }

    public void selectVehicleCarrySignage(boolean selectSignageFlag) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(selectSignageFlag);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().DOES_VEHICLE_CARRY_SIGNAGE(), String.valueOf(value)), SyncType.CLICKABLE);
    }

    public void selectUseForSocialAndPleasure(boolean selectUseForSocialAndPleasureFlag) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(selectUseForSocialAndPleasureFlag);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().FOR_SOCIAL_AND_PLEASURE(), String.valueOf(value)), SyncType.CLICKABLE);
    }

    public void enterWhenDidYouBuyYourCar(Object dateCarBought) throws CustomE2eException {
        if (isElementVisible(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().WHEN_DID_YOU_BUY_YOUR_CAR())) {
            typeText(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().WHEN_DID_YOU_BUY_YOUR_CAR(), dateCarBought, SyncType.CLICKABLE, true, false, "When did you buy your car");
        }
    }

    public void selectPublicLiabilityInForce(boolean selectPublicLiabilityInForceFlag) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(selectPublicLiabilityInForceFlag);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().PUBLIC_LIABILITY_IN_FORCE(), String.valueOf(value)), SyncType.CLICKABLE);
    }

    public void selectWillVehicleCarryHazardousGoods(boolean selectWillVehicleCarryHazardousGoodsFlag) throws CustomE2eException {
        var value = this.CommonHelper.convertBooleanIntoInteger(selectWillVehicleCarryHazardousGoodsFlag);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().WILL_VEHICLE_CARRY_HAZARDOUS_GOODS(), String.valueOf(value)), SyncType.CLICKABLE);
    }


}

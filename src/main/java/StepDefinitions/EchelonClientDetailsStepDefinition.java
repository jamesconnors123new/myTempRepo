package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import activities.CommonControlDataDefns;
import activities.GetCustomerDetailsPortal;
import activities.GetPolicyInformationPortal;
import helpers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static activities.PolicyCreationOnEchelonUI.HOUSE_HOLD;
import static activities.PolicyCreationOnEchelonUI.PRIVATE_CAR;

//import static activities.QuoteCreationInEchelonUI.HOUSE_HOLD;

public class EchelonClientDetailsStepDefinition extends CdlEchelonHelpers {

  private final long waitDuration = 60000L;
  private final CommonHelper CommonHelper;


  public EchelonClientDetailsStepDefinition(WebDriver driver,
                                            PageObjects.EchelonModel.Root echelonModelRoot) {
    super(driver, echelonModelRoot);
    this.CommonHelper = new CommonHelper(driver);
  }

  public List<String> getCarPolicyDetailsInPortalFormat(Map<String, String> searchCriteria) throws ParseException, CustomE2eException {

    //Variable declarations
    List<Map<String, Object>> listofPolicies = new ArrayList<>();
    Map<String, Object> individualPolicy = new HashMap<>();
    Map<String, Object> proposerDetails = new HashMap<>();
    Map<String, Object> vehicleDetails = new HashMap<>();
    Map<String, Object> excesses = new HashMap<>();
    Map<String, Object> optionalExtras = new HashMap<>();
    Map<String, Object> additionalDriver = new HashMap<>();

    var policyId = searchCriteria.get(CommonStepDefinitions.SEARCH_BY_POLICY_NUMBER);

    // Summary Details
    this.clickViewPolicyDetails(policyId);
    this.redirectToRiskTab();
    this.clickShowAllDetailsLink();

    //Proposer Details
    proposerDetails.put(GetPolicyInformationPortal.NAME, this.getCarPolicyDetailsName());
    proposerDetails.put(GetPolicyInformationPortal.EMAIL_ADDRESS,
        this.getCarPolicyDetailsEmailAddress());
    proposerDetails.put(GetPolicyInformationPortal.MOBILE_TELEPHONE_NUMBER,
        this.getCarPolicyDetailsMobileTelephoneNumber());
    proposerDetails.put(GetPolicyInformationPortal.ADDRESS, this.getCarPolicyDetailsAddress());
    proposerDetails.put(GetPolicyInformationPortal.DATE_OF_BIRTH,
        this.getCarPolicyDetailsDateOfBirth());
    proposerDetails.put(GetPolicyInformationPortal.MARITAL_STATUS,
        this.getCarPolicyDetailsMaritalStatus());
    proposerDetails.put(GetPolicyInformationPortal.EMPLOYMENT_STATUS,
        this.getCarPolicyDetailsEmploymentStatus());
    proposerDetails.put(GetPolicyInformationPortal.OCCUPATION,
        this.getCarPolicyDetailsOccupation());
    proposerDetails.put(GetPolicyInformationPortal.DRIVING_LICENSE_TYPE,
        this.getCarPolicyDetailsDrivingLicenseType());
    proposerDetails.put(GetPolicyInformationPortal.YEARS_NO_CLAIMS_DISCOUNT,
        this.getCarPolicyDetailsYearsNoClaimsDiscount());

    if (isElementVisible(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_NAME())) {
      additionalDriver.put((GetPolicyInformationPortal.AD_NAME), this.getCarPolicyDetailsAD_Name());
      additionalDriver.put((GetPolicyInformationPortal.AD_GENDER),
          this.getCarPolicyDetailsAD_Gender());
      additionalDriver.put((GetPolicyInformationPortal.AD_DATE_OF_BIRTH),
          this.getCarPolicyDetailsAD_DateofBirth());
      additionalDriver.put((GetPolicyInformationPortal.AD_AGE), this.getCarPolicyDetailsAD_Age());
      additionalDriver.put((GetPolicyInformationPortal.AD_FULL_TIME_OCCUPATION),
          this.getCarPolicyDetailsAD_FullTimeOccupation());
      additionalDriver.put((GetPolicyInformationPortal.AD_PART_TIME_OCCUPATION),
          this.getCarPolicyDetailsAD_PartTimeOccupation());
      additionalDriver.put((GetPolicyInformationPortal.AD_LICENSE_TYPE),
          this.getCarPolicyDetailsAD_LicenceType());
      additionalDriver.put((GetPolicyInformationPortal.AD_LICENSE_DATE),
          this.getCarPolicyDetailsAD_LicenceDate());
      additionalDriver.put((GetPolicyInformationPortal.AD_ACCESS_TO_VEHICLES),
          this.getCarPolicyDetailsAD_AccessToOtherVehicles());
      additionalDriver.put((GetPolicyInformationPortal.AD_RELATIONSHIP_TO_PROPOSER),
          this.getCarPolicyDetailsAD_RelationshipToProposer());
      additionalDriver.put((GetPolicyInformationPortal.AD_MARITAL_STATUS),
          this.getCarPolicyDetailsAD_MaritalStatus());
      additionalDriver.put((GetPolicyInformationPortal.AD_DATE_OF_RESIDENCY),
          this.getCarPolicyDetailsAD_DateOfResidency());
      additionalDriver.put((GetPolicyInformationPortal.AD_VEHICLE_USE),
          this.getCarPolicyDetailsAD_VehicleUse());
      additionalDriver.put((GetPolicyInformationPortal.AD_INSURANCE_PREVIOUSLY_REFUSED),
          this.getCarPolicyDetailsAD_InsurancePreviouslyRefused());
    } else {
      proposerDetails.put(GetPolicyInformationPortal.AD_NAME, false);
    }

    //Vehicle Details
    vehicleDetails.put(GetPolicyInformationPortal.CAR_MAKE, this.getCarPolicyDetailsCarMake());
    vehicleDetails.put(GetPolicyInformationPortal.CAR_MODEL, this.getCarPolicyDetailsCarModel());
    vehicleDetails.put(GetPolicyInformationPortal.YEAR_OF_MAKE,
        this.getCarPolicyDetailsYearOfMake());
    vehicleDetails.put(GetPolicyInformationPortal.TRANSMISSION,
        this.getCarPolicyDetailsTransmission());
    vehicleDetails.put(GetPolicyInformationPortal.FUEL_TYPE, this.getCarPolicyDetailsFuelType());
    vehicleDetails.put(GetPolicyInformationPortal.CURRENT_MARKET_VALUE,
        this.getCarPolicyDetailsCurrentMarketValue());
    vehicleDetails.put(GetPolicyInformationPortal.CAR_OWNER, this.getCarPolicyDetailsCarOwner());
    vehicleDetails.put(GetPolicyInformationPortal.REGISTERED_KEEPER,
        this.getCarPolicyDetailsRegisteredKeeper());
    vehicleDetails.put(GetPolicyInformationPortal.CLASS_OF_USE,
        this.getCarPolicyDetailsClassOfUse());
    vehicleDetails.put(GetPolicyInformationPortal.ANNUAL_MILEAGE,
        this.getCarPolicyDetailsAnnualMileage());

    //Excesses
    excesses.put(GetPolicyInformationPortal.LEVEL_OF_VOLUNTARY_EXCESS,
        this.getCarPolicyDetailsLevelOfVoluntaryExcess());
    this.navigateToResultTab();
    this.clickShowAllDetailsLink();
    excesses.put(GetPolicyInformationPortal.COMPULSORY,
        this.getCompulsoryExcessesAccDamageAndMalDamage());

    //Optional Extras
    optionalExtras = this.getCarOptionalExtrasAdded();

    //Return list of policy details
    individualPolicy.put(CommonStepDefinitions.POLICY_ID, policyId);
    individualPolicy.put(CommonStepDefinitions.MY_DETAILS, proposerDetails);
    individualPolicy.put(CommonStepDefinitions.MY_COVER, vehicleDetails);
    individualPolicy.put(CommonStepDefinitions.EXCESSES, excesses);
    individualPolicy.put(CommonStepDefinitions.ENHANCE_MY_COVER, optionalExtras);
    individualPolicy.put(CommonStepDefinitions.ADDITIONAL_DRIVER, additionalDriver);

    return (List<String>) individualPolicy;
    //return true;


  }


  // --------------------------------------------- Get Car Policy Details
  // ---------------------------------------------


  public SortedMap<String, Object> getCarOptionalExtrasAdded() throws CustomE2eException {
    var myEnhancedCoverDetails = new TreeMap<String, Object>();
    myEnhancedCoverDetails.put(CommonStepDefinitions.LEGAL_EXPENSES, false);
    myEnhancedCoverDetails.put(CommonStepDefinitions.KEY_PROTECTION, false);
    myEnhancedCoverDetails.put(CommonStepDefinitions.BREAKDOWN_COVER, false);
    if (isElementVisible(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().OPTIONAL_EXTRAS_LINE_ITEMS())) {
      List<WebElement> rows =
          getElementsMatchingToLocator(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().OPTIONAL_EXTRAS_LINE_ITEMS());
      for (int enhanceCoverRows = 1; enhanceCoverRows <= rows.size(); enhanceCoverRows++) {
        String description =
            getText(xpathBuilder(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().OPTIONAL_EXTRAS_TABLE_DESCRIPTION_COLUMN(), String.valueOf(enhanceCoverRows)));
        switch (description) {
          case "Motor Legal Expenses":
            myEnhancedCoverDetails.put(CommonStepDefinitions.LEGAL_EXPENSES, true);
            break;
          case "Motor Key Protection":
            myEnhancedCoverDetails.put(CommonStepDefinitions.KEY_PROTECTION, true);
            break;
          case "Motor Roadside Plus":
            myEnhancedCoverDetails.put(CommonStepDefinitions.BREAKDOWN_COVER, true);
            break;
          default:
        }
      }
    }
    return myEnhancedCoverDetails;
  }

  // Proposer Details//
  public String getCarPolicyDetailsName() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().NAME(),
        SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().NAME(), "Car Policy Details Name");
  }

  public String getCarPolicyDetailsEmailAddress() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().EMAIL_ADDRESS(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().EMAIL_ADDRESS(), "Car Policy Details Email Address");
  }

  public String getCarPolicyDetailsMobileTelephoneNumber() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().MOBILE_TELEPHONE_NUMBER(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().MOBILE_TELEPHONE_NUMBER(), "Car Policy Details Mobile Number");
  }

  public String getCarPolicyDetailsAddress() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().ADDRESS(),
        SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().ADDRESS(), "Car Policy Details Address");
  }

  public String getCarPolicyDetailsDateOfBirth() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().DATE_OF_BIRTH(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().DATE_OF_BIRTH(), "Car Policy Details Date of Birth");
  }

  public String getCarPolicyDetailsMaritalStatus() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().MARITAL_STATUS(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().MARITAL_STATUS(), "Car Policy Details Marital Status");
  }

  public String getCarPolicyDetailsEmploymentStatus() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().EMPLOYMENT_STATUS(), SyncType.VISIBLE);
    // return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel()
    // .EMPLOYMENT_STATUS, "Car Policy Details Employment Status");
    return getText(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().EMPLOYMENT_STATUS()).split(",")[1].trim();
  }


  public String getCarPolicyDetailsOccupation() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().OCCUPATION()
        , SyncType.VISIBLE);
    //return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel()
    // .OCCUPATION, "Car Policy Details Occupation");
    return getText(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().OCCUPATION()).split(",")[0].trim();
  }

  public String getCarPolicyDetailsDrivingLicenseType() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().DRIVING_LICENSE_TYPE(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().DRIVING_LICENSE_TYPE(), "Car Policy Details Driving License Type");
  }

  public String getCarPolicyDetailsYearsNoClaimsDiscount() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().YEARS_NO_CLAIMS_DISCOUNT(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().YEARS_NO_CLAIMS_DISCOUNT(), "Car Policy Details NCD");
  }

  public String getCarPolicyDetailsJointPolicyHolderName() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().JOINT_POLICY_HOLDER_NAME(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().JOINT_POLICY_HOLDER_NAME(), "Car Policy Details Joint Policy Holder Name");
  }

  // Vehicle Section
  public String getCarPolicyDetailsCarMake() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().CAR_MAKE(),
        SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().CAR_MAKE(), "Car Policy Details Car Make");
  }

  public String getCarPolicyDetailsCarModel() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().CAR_MODEL(),
        SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().CAR_MODEL(), "Car Policy Details Car Model");
  }

  public String getCarPolicyDetailsYearOfMake() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().YEAR_OF_MAKE(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().YEAR_OF_MAKE(), "Car Policy Details Years of Make");
  }

  public String getCarPolicyDetailsTransmission() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().TRANSMISSION(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().TRANSMISSION(), "Car Policy Details Transmission");
  }

  public String getCarPolicyDetailsFuelType() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().FUEL_TYPE(),
        SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().FUEL_TYPE(), "Car Policy Details Fuel Type");
  }

  public String getCarPolicyDetailsCurrentMarketValue() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().CURRENT_MARKET_VALUE(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().CURRENT_MARKET_VALUE(), "Car Policy Details Current Market Value");
  }

  public String getCarPolicyDetailsCarOwner() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().CAR_OWNER(),
        SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().CAR_OWNER(), "Car Policy Details Car Onwer");
  }

  public String getCarPolicyDetailsRegisteredKeeper() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().REGISTERED_KEEPER(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().REGISTERED_KEEPER(), "Car Policy Details Registered Keeper");
  }

  public String getCarPolicyDetailsCarLocationOvernight() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().CAR_LOCATION_OVERNIGHT(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().CAR_LOCATION_OVERNIGHT(), "Car Policy Details Car Location Overnight");
  }

  public String getCarPolicyDetailsClassOfUse() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().CLASS_OF_USE(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().CLASS_OF_USE(), "Car Policy Details Class of Use");
  }

  //public String getCarPolicyDetailsChangesEffectiveDate() throws CustomE2eException {
  //waitForSpinnerToDisappear();
  //  waitForPageLoad();
  //  waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel()
  //  .CHANGES_EFFECTIVE_DATE, SyncType.VISIBLE);
  //  return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel()
  //  .CHANGES_EFFECTIVE_DATE, "Car Policy Details Effective Date");
  // }

  public String getCarPolicyDetailsAnnualMileage() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().ANNUAL_MILEAGE(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().ANNUAL_MILEAGE(), "Car Policy Details Annual Mileage");
  }

  // Excesses
  public String getCarPolicyDetailsLevelOfVoluntaryExcess() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().LEVEL_OF_VOLUNTARY_EXCESS(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().LEVEL_OF_VOLUNTARY_EXCESS(), "Car Policy Details Voluntary Excess");
  }

  //public String getCarPolicyDetailsCompulsory() throws CustomE2eException {
  //   waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel()
  //   .COMPULSORY, SyncType.VISIBLE);
  //  return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel()
  //  .COMPULSORY, "Car Policy Details Compulsory Excess");
  // }

  public String getCompulsoryExcessesAccDamageAndMalDamage() throws CustomE2eException {
    waitForPageLoad();
    //waitForElement2(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel()
    // .CE_ACCIDENTAL_DAMAGE_AND_MALICIOUS_DAMAGE , SyncType.VISIBLE, waitDuration);
    return getText(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().CE_ACCIDENTAL_DAMAGE_AND_MALICIOUS_DAMAGE_VALUE());
  }

  // ------------------- Additional Driver --------------------------------------
  public String getCarPolicyDetailsAD_Name() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_NAME(),
        SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_NAME(), "Additional Driver Name");
  }


  public String getCarPolicyDetailsAD_Gender() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_GENDER(),
        SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_GENDER(), "Additional Driver Gender");
  }


  public String getCarPolicyDetailsAD_DateofBirth() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_DATE_OF_BIRTH(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_DATE_OF_BIRTH(), "Additional Driver Date of Birth");
  }


  public String getCarPolicyDetailsAD_Age() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_AGE(),
        SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_AGE(), "Additional Driver Age");
  }


  public String getCarPolicyDetailsAD_FullTimeOccupation() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_FULL_TIME_OCCUPATION(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_FULL_TIME_OCCUPATION(), "Additional Driver Full Time Occupation");
  }


  public String getCarPolicyDetailsAD_PartTimeOccupation() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_PART_TIME_OCCUPATION(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_PART_TIME_OCCUPATION(), "Additional Driver Part time Occupatin");
  }


  public String getCarPolicyDetailsAD_LicenceType() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_LICENSE_TYPE(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_LICENSE_TYPE(), "Additional Driver License Type");
  }


  public String getCarPolicyDetailsAD_LicenceDate() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_LICENSE_DATE(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_LICENSE_DATE(), "Additional Driver License Date");
  }


  public String getCarPolicyDetailsAD_AccessToOtherVehicles() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_ACCESS_TO_VEHICLES(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_ACCESS_TO_VEHICLES(), "Additional Driver Access To Other Vehicles");
  }


  public String getCarPolicyDetailsAD_RelationshipToProposer() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_RELATIONSHIP_TO_PROPOSER(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_RELATIONSHIP_TO_PROPOSER(), "Additional Driver Relationship To Proposer");
  }


  public String getCarPolicyDetailsAD_MaritalStatus() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_MARITAL_STATUS(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_MARITAL_STATUS(), "Additional Driver Marital Status");
  }


  public String getCarPolicyDetailsAD_DateOfResidency() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_DATE_OF_RESIDENCY(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_DATE_OF_RESIDENCY(), "Additional Driver Date of Residency");
  }


  public String getCarPolicyDetailsAD_VehicleUse() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_VEHICLE_USE(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_VEHICLE_USE(), "Additional " + "Driver Vehicle Use");
  }

  public String getCarPolicyDetailsAD_InsurancePreviouslyRefused() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_INSURANCE_PREVIOUSLY_REFUSED(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonCarPolicyDetailsLocatorModel().AD_INSURANCE_PREVIOUSLY_REFUSED(), "Additional Driver Insurance " + "Previously Refused");
  }
  // -------------------------------------------------------------------------------------------------


  public String getName() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().NAME(),
        SyncType.VISIBLE, waitDuration);
    var fullName = getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().NAME());
    if (fullName.contains("Doctor")) {
      fullName = fullName.replace("Doctor", "Dr");
    }
    return fullName;
  }

  public String getSalutation() throws CustomE2eException {
    return getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().SALUTATION());
  }

  public String getAddress() throws CustomE2eException {
    return getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().MAIN_ADDRESS());
  }

  public String getMainAddressPostcode() throws CustomE2eException {
    return getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().MAIN_ADDRESS_POSTCODE());
  }

  public String getGender() throws CustomE2eException {
    return getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().GENDER());
  }

  public String getDateOfBirth() {
    String dateOfBirth = null;
    try {
      dateOfBirth =
          Formatting.changeDateFormatIntoExpected(getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().DATE_OF_BIRTH()), "dd-MMM-yyyy", "dd/mm/yyyy");
    } catch (Exception e) {
    }
    return dateOfBirth;

  }

  public String getAge() throws CustomE2eException {
    return getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().AGE());
  }

  public String getMobileTelephoneNumber() throws CustomE2eException {
    return RetryOnException("getMobileTelephoneNumber", CustomE2eException.class, 500L, 10,
        () -> getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().MOBILE_TELEPHONE_NUMBER(), ""));
  }

  public String getEmailAddress() throws CustomE2eException {
    return getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().EMAIL_ADDRESS(), "");
  }

  public Integer getValuableStatus() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CONTENT_INSURANCE_HELD_LAST_2_YEARS_SHRINK(), SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CONTENT_INSURANCE_HELD_LAST_2_YEARS_SHRINK(), SyncType.CLICKABLE);
    return (Integer.parseInt(getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().COUNT_OF_SPECIFID_CONTENT(), "").replaceAll("[()]", "")) > 0) ? Integer.parseInt(getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().COUNT_OF_SPECIFID_CONTENT(), "").replaceAll("[()]", "")) : 0;
  }

  public ArrayList<SortedMap<String, Object>> getItemsInHome() throws CustomE2eException {
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CONTENT_INSURANCE_HELD_LAST_2_YEARS_SHRINK(), SyncType.CLICKABLE);
    var allItems = new ArrayList<SortedMap<String, Object>>();
    var listOfItems =
        getElementsMatchingToLocator(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().LIST_OF_VALUABLE_ITEMS());
    int items = 1;
    for (var item : listOfItems) {
      var list = new TreeMap<String, Object>();
      var rowDetails =
          getTextAllWebElementMatchingLocator(xpathBuilder(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().LIST_OF_VALUABLE_ITEM_DATA(), String.valueOf(items)));
      list.put(CommonControlDataDefns.ITEM, rowDetails.get(0));
      //  list.put(CommonControlDataDefns.DESCRIPTION, rowDetails.get(1));
      list.put(CommonControlDataDefns.VALUE, Double.parseDouble(rowDetails.get(2).replaceAll("[£,"
          + "]", "")));
      items++;
      allItems.add(list);
    }
    return allItems;
  }

  private ArrayList<SortedMap<String, Object>> getItemsAwayFromHome() throws CustomE2eException {
    var allItems = new ArrayList<SortedMap<String, Object>>();
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().COUNT_OF_INDIVIDUAL_ITEMS(), SyncType.VISIBLE, waitDuration);
    var listOfIndItems =
        getElementsMatchingToLocator(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().COUNT_OF_INDIVIDUAL_ITEMS());
    int items = 1;
    for (var item : listOfIndItems) {
      var list = new TreeMap<String, Object>();
      var itemDet =
          getTextAllWebElementMatchingLocator(xpathBuilder(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().LIST_OF_INDIVIDUAL_ITEMS(), String.valueOf(items)));
      var itemName = itemDet.get(0).toString();
      list.put(CommonControlDataDefns.ITEM, itemName);
      //list.put(CommonControlDataDefns.DESCRIPTION, itemDet.get(1));
      list.put(CommonControlDataDefns.VALUE, Double.parseDouble(itemDet.get(2).replaceAll("[,£]",
          "")));
      items++;
      allItems.add(list);
    }
    return allItems;
  }

  public Integer getIndividualItemCover() throws CustomE2eException {
    String specifiedAllRiskItems = "0";
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().SPECIFIED_ALL_RISK_ITEM_TAB_SHRINK(), SyncType.CLICKABLE, 3000L);
    if (isElementVisible(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().SPECIFIED_ALL_RISK_ITEM_TAB_SHRINK())) {
      expandSpecifiedItems();
      specifiedAllRiskItems = RetryOnException("getIndividualItemCover", CustomE2eException.class
          , 500L, 10,
          () -> getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().SPECIFIED_ALL_RISK_ITEM_COUNT()));
      waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().SPECIFIED_ALL_RISK_ITEM_TAB_SHRINK(), SyncType.CLICKABLE, waitDuration);
      expandSpecifiedItems();
    }

    return (Integer.parseInt(specifiedAllRiskItems.replaceAll("[()]", "")) > 0) ?
        Integer.parseInt(specifiedAllRiskItems.replaceAll("[()]", "")) : 0;
  }

  private void expandSpecifiedItems() throws CustomE2eException {
//    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().SPECIFIED_ALL_RISK_ITEM_TAB_SHRINK(), SyncType.CLICKABLE);
    clickElement(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().SPECIFIED_ALL_RISK_ITEM_TAB_SHRINK(), SyncType.CLICKABLE);
//    NoThrowSleep(Duration.ofSeconds(20));

  }

  public Boolean getContentInsuranceHeld2Years() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CONTENT_INSURANCE_TAB_SHRINK(), SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CONTENT_INSURANCE_TAB_SHRINK(), SyncType.CLICKABLE);
    var contentInsurance = RetryOnException("getContentInsuranceHeld2Years",
        CustomE2eException.class, 500L, 10,
        () -> getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CONTENT_INSURANCE_HELD_LAST_2_YEARS(), ""));
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CONTENT_INSURANCE_TAB_SHRINK(), SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CONTENT_INSURANCE_TAB_SHRINK(), SyncType.CLICKABLE);
    if (Double.parseDouble(contentInsurance.replaceAll("[()]", "")) > 0) {
      return true;
    } else {
      return false;
    }
  }

  public Boolean getPreviousInsurance() throws CustomE2eException {
    return (Double.parseDouble(getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().PREVIOUS_INSURANCE()).replaceAll("[()]", "")) > 0.0) ? true : false;
  }

  public String getOwnership() throws CustomE2eException {
    String ownerShip =
        getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().OWNERSHIP());
    if (ownerShip.isEmpty()) {
      ownerShip =
          getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().RENT_FROM()).toLowerCase();
    }
    return ownerShip;
  }

  private TreeMap<String, Object> getEmpDetails() throws CustomE2eException {
    var primaryEmp = new TreeMap<String, Object>();
    var secondaryEmp = new TreeMap<String, Object>();
    var empDetails = new TreeMap<String, Object>();

    var primaryDet =
        getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().PRIMARY_EMP_DET(), "");
    var secondaryDet =
        getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().SECONDARY_EMP_DET(), "");

    primaryEmp.put(GetCustomerDetailsPortal.OCCUPATION, primaryDet.split(",")[0]);
    primaryEmp.put(CommonControlDataDefns.EMPLOYMENT_STATUS, primaryDet.split(",")[1]);
    primaryEmp.put(CommonControlDataDefns.INDUSTRY, primaryDet.split(",")[2]);
    empDetails.put(CommonControlDataDefns.PRIMARY_EMPLOYMENT, primaryEmp);

    var secondEmpFlag = secondaryDet.equals("None") ? false : true;
    secondaryEmp.put(CommonControlDataDefns.SECOND_EMP_FLAG, secondEmpFlag);
    if (secondEmpFlag) {
      secondaryEmp.put(CommonControlDataDefns.EMPLOYMENT_STATUS, secondaryDet.split(",")[1]);
      secondaryEmp.put(CommonControlDataDefns.OCCUPATION, secondaryDet.split(",")[0]);
      secondaryEmp.put(CommonControlDataDefns.INDUSTRY, secondaryDet.split(",")[2]);
    }
    empDetails.put(CommonControlDataDefns.SECONDARY_EMPLOYMENT, secondaryEmp);

    return empDetails;
  }

  public String getPropertyType() throws CustomE2eException {
    return getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().PROPERTY_TYPE(), "");
  }

  public String getCorrespondenceAddress() throws CustomE2eException {
    return getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CORRESPONDENCE_ADDRESS(), "").trim().replaceAll("\n", " ").replace("United Kingdom", "").replaceAll("\s{2,}", " ");
  }

  public String getRelationshipStatus() throws CustomE2eException {
    return getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().RELATIONSHIP_STATUS(), "");
  }

  public String getOccupation() throws CustomE2eException {
    return getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().PRIMARY_EMP_DET(), "").split(",")[0];
  }

  public String getInsuredAddress() throws CustomE2eException {
    return getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().INSURED_ADDRESS(), "").trim().replaceAll("\n", " ").replace("United Kingdom", "").replaceAll("\s{2,}", " ");
  }

  public Object getBedrooms() throws CustomE2eException {
    Object numberOfBedrooms =
        getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BEDROOMS(), "");
    numberOfBedrooms = (Formatting.isNumeric(numberOfBedrooms.toString())) ?
        Integer.parseInt(numberOfBedrooms.toString()) : "NoValue";
//    if (Formatting.isNumeric(numberOfBedrooms.toString())) {
//      numberOfBedrooms =  ;
//    } else {
//      numberOfBedrooms = 0;
//    }
    return numberOfBedrooms;
  }

  public Object getCountOfBathroom() throws CustomE2eException {
    Object numberOfBathroom =
        getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BATHROOMS());
    numberOfBathroom = Formatting.isNumeric(numberOfBathroom.toString()) ?
        Integer.parseInt(numberOfBathroom.toString()) : "NoValue";
//    if (Formatting.isNumeric(numberOfBathroom.toString())) {
//      numberOfBathroom = Integer.parseInt(numberOfBathroom.toString());
//    } else {
//      numberOfBathroom = 0;
//    }
    return numberOfBathroom;
  }

  public String getJointPolicyHolder() throws CustomE2eException {
    return tryGetInformation(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().JOINT_POLICY_HOLDER());
  }


  interface By2String {
    String doit(By element, String problem) throws CustomE2eException;
  }

  public String tryGetInformation(By element) {
    try {
      return internalGetInformation((elm, s) -> tryGetText(elm), element, "");
    } catch (CustomE2eException e) {
      return null;
    }
  }

  public String getInformation(By jointPolicyHolder, String s) throws CustomE2eException {
    return internalGetInformation((elm, s1) -> getText(elm, s1), jointPolicyHolder, s);
  }

  private String internalGetInformation(By2String getTextMethod, By jointPolicyHolder, String s) throws CustomE2eException {
    try {
      return getTextMethod.doit(jointPolicyHolder, s);
    } catch (TimeoutException exception) {
      String errorMessage = String.format("%s Information on echelon is missing", s);
      throw new CustomE2eException(errorMessage);
    } catch (Exception exception) {
      throw new CustomE2eException(exception.getMessage());
    }
  }


  public String getYearBuilt() throws CustomE2eException {
    return getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().YEAR_BUILT(), "");
  }


  public String getInceptionDate() throws CustomE2eException {
    String FullInceptionValue =
        getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().INCEPTION_DATE(), "");
    String InCeptionDate = getFirstStringValue(FullInceptionValue);
    return InCeptionDate;
  }

  public String getPolicyExpiresDate() throws CustomE2eException {
    String policyExpireDate =
        getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().POLICY_END_DATE(), "");
    String policyDateFormatted = getFirstStringValue(policyExpireDate);
    return policyDateFormatted;
  }

  public String getTypeOfHouseholdCover() throws CustomE2eException {
    String FullTypeOfHouseholdCover =
        getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().TYPE_OF_HOUSEHOLD_COVER(), "");
    return (FullTypeOfHouseholdCover.contains(CommonControlDataDefns.BUILDING_VAR) && FullTypeOfHouseholdCover.contains(CommonControlDataDefns.CONTENTS_VAR)) ? CommonControlDataDefns.BUILDING_CONTENT_INSURANCE_TYPE : getFirstStringValue(FullTypeOfHouseholdCover);
//    if (FullTypeOfHouseholdCover.contains(CommonControlDataDefns.BUILDING_VAR) &&
//    FullTypeOfHouseholdCover.contains(CommonControlDataDefns.CONTENTS_VAR)) {
//      return CommonControlDataDefns.BUILDING_CONTENT_INSURANCE_TYPE;
//    } else {
//      return getFirstStringValue(FullTypeOfHouseholdCover);
//    }
  }

  public String getTypeCover(String typeOfCover) {
    String type = null;
    if (typeOfCover.equalsIgnoreCase("Buildings, Contents and All Risks")) {
      type = "Buildings & Contents";
    } else if (typeOfCover.equalsIgnoreCase("Buildings")) {
      type = "Buildings";
    } else if (typeOfCover.equalsIgnoreCase("Contents")) {
      type = "Contents";
    }
    return type;
  }

  public String getRebuildingCost() throws CustomE2eException {
    return getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().REBUILDING_COST()).replaceAll("[£,]", "");
  }

  public String getLevelOfCompulsoryBuildingExcess() throws CustomE2eException {
    return getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUILDING_COMPULSORY_EXCESS(), "").replace("£", "");
  }

  public String getLevelOfCompulsoryContentExcess() throws CustomE2eException {
    return getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CONTENT_COMPULSORY_EXCESS(), "").replace("£", "");
  }

  public String getEscapeOfWaterExcess() throws CustomE2eException {
    return getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().ESCAPE_OF_WATER_EXCESS(), "");
  }

  public String getSubsidenceCompulsoryExcess() throws CustomE2eException {
    return (isElementVisible(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().SUBSIDENCE_COMPULSORY_EXCESS())) ? getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().SUBSIDENCE_COMPULSORY_EXCESS(), "").replace(",", "") : "NoValue";
//    if (isElementVisible(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel()
//    .SUBSIDENCE_COMPULSORY_EXCESS())) {
//      return getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel()
//      .SUBSIDENCE_COMPULSORY_EXCESS()).replace(",", "");
//    } else {
//      return "0.0";
//    }
  }

  public String getJointPolicyHolderName() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().JP_FULLNAME(), SyncType.VISIBLE, waitDuration);
    return getInformation(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().JP_FULLNAME(), "Joint policy " + "holder full name");
  }

  public String getJointPolicyHolderDateOfBirth() throws CustomE2eException, ParseException {
    return Formatting.changeDateFormatIntoExpected(getInformation(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().JP_DATE_OF_BIRTH(), "Joint policy holder date of birth"), "dd-MMM-yyyy", "dd/MM/yyyy");
  }


  public String getJointPolicyHolderEmploymentDetails() throws CustomE2eException {
    return getInformation(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().JP_EMPLOYMENT_DETAILS(), "Joint " + "policy holder employment details");
  }


  public String getJointPolicyHolderMaritalStatus() throws CustomE2eException {
    return getInformation(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().JP_MARITAL_STATUS(), "Joint " + "policy holder marital status");
  }

  public String getJointPolicyHolderTitle() throws CustomE2eException {
    return getInformation(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().JP_TITLE(), "Joint policy " + "holder" + " title");
  }

  public String getJointPolicyHolderRelationshipStatus() throws CustomE2eException {
    return getInformation(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().JP_RELATIONSHIP_STATUS(), "Joint" + " policy holder relationship status").replaceAll("[/(/)]", "");
  }

  public SortedMap<String, Object> getJointPolicyHolderSecondJobDetails() throws CustomE2eException {
    var secondEmpDetails = new TreeMap<String, Object>();
    var details =
        getInformation(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().JP_PART_TIME_OCCUPATION(), "Joint policy holder second job details");
    if (details.split(",").length > 1) {
      secondEmpDetails.put(GetPolicyInformationPortal.EMPLOYMENT_STATUS, details.split(",")[1]);
      secondEmpDetails.put(GetPolicyInformationPortal.SECOND_JOB_OCCUPATION, details.split(",")[0]);
      secondEmpDetails.put(GetPolicyInformationPortal.SECOND_JOB_INDUSTRY_TYPE,
          details.split(",")[2]);
    }
    return secondEmpDetails;
  }

  public String effectiveDate() throws CustomE2eException, ParseException {
    return Formatting.changeDateFormatIntoExpected(getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().EFFECTIVE_DATE()).split(" ")[0], "dd-MMM-yyyy", "dd/MM/yyyy");
  }

  public String earliestMtaDate() throws CustomE2eException {
    var vLatestPreceedingMtaDateText =
        getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().EFFECTIVE_DATE()).split(" ")[0];
    var vLatestPreceedingMtaDate = LocalDate.parse(vLatestPreceedingMtaDateText,
        DateTimeFormatter.ofPattern("dd-MMM-yyyy").withLocale(Locale.US)); // Handling Parsing issue
    var vToday = LocalDate.now();
    var vEarliestMtaDate = (vToday.isAfter(vLatestPreceedingMtaDate)) ? vToday :
        vLatestPreceedingMtaDate;
    return vEarliestMtaDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  }

  public double adjustmentPremium() throws CustomE2eException {
    double adjustmentNumeric = 0.00;
    try {
      var businessEventRow = getExpectedBusinessEventRow();
      var targetBusinessEventRef =
          getText(xpathBuilder(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENTS_TABLE_REF_ID(), String.valueOf(businessEventRow)));
      var businessEventName =
          getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_BREADCRUMB()).substring(0, 3);

      if (!targetBusinessEventRef.equals(businessEventName)) {
        this.clickBusinessEventsTableRow(businessEventRow);
        waitForPageLoad();
      }
      navigateToSummaryTab();
      waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().MTA_TOTAL_SELLING_PRICE(), SyncType.VISIBLE, waitDuration);
    } catch (CustomE2eException exception) {

    }

    if (isElementVisible(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().MTA_TOTAL_SELLING_PRICE())) {
      adjustmentNumeric =
          Double.parseDouble(getInformation(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().MTA_TOTAL_SELLING_PRICE(), "Adjustment").replace("£", ""));
      if (adjustmentNumeric < 0) {
        adjustmentNumeric = 0.00;
      }
    }
    return adjustmentNumeric;
  }

  public double PolicyPaymentDueAmount() throws CustomE2eException {
    return Math.max(0.0, PolicyBalance());
  }

  public double PolicyBalance() throws CustomE2eException {
    var vPolicyBalance = 0.0;
    if (isElementVisible(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().ADJUSTMENT())) {
      vPolicyBalance =
          Double.parseDouble(getInformation(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().ADJUSTMENT(), "Adjustment").replace("£", ""));
    }
    return vPolicyBalance;
  }

  public String mtaTotalSellingPrice() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().MTA_TOTAL_SELLING_PRICE(), SyncType.VISIBLE);
    return getInformation(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().MTA_TOTAL_SELLING_PRICE(), "MTA " + "Total Selling Price");
  }

  public void clickCreateQuotes() throws CustomE2eException {
    waitForElement(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CLIENT_ACTIONS(), SyncType.VISIBLE);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CLIENT_ACTIONS(), SyncType.CLICKABLE);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().QUOTE_CREATION(), SyncType.CLICKABLE);
  }

  public void isItNewCustomer() throws CustomE2eException {
    if (!isElementVisible(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().NEW_CUSTOMER_QUOTE())) {
      waitForElement2(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().CLIENT_SELECT_BTN(),
          SyncType.VISIBLE, 20000L);
    }
    if (!isElementVisible(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().CLIENT_SELECT_BTN())) {
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().NEW_CUSTOMER_QUOTE(), SyncType.CLICKABLE);
    } else {
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().CLIENT_SELECT_BTN(), SyncType.CLICKABLE);
      clickCreateQuotes();
      selectPolicyType(HOUSE_HOLD);
    }
  }

  public void isItNewCustomerMotor() throws CustomE2eException {
    if (!isElementVisible(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().NEW_CUSTOMER_QUOTE())) {
      waitForElement2(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().CLIENT_SELECT_BTN(),
          SyncType.VISIBLE, 20000L);
    }
    if (!isElementVisible(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().CLIENT_SELECT_BTN())) {
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().NEW_CUSTOMER_QUOTE(), SyncType.CLICKABLE);
      selectPolicyType(PRIVATE_CAR);
    } else {
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().CLIENT_SELECT_BTN(), SyncType.CLICKABLE);
      clickCreateQuotes();
      selectPolicyType(PRIVATE_CAR);
    }
  }

  public void clickNextPageEchelon() throws CustomE2eException {
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NEXT_PAGE(), SyncType.CLICKABLE);
  }


  public void selectPolicyType(String policyType) throws CustomE2eException {
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().POLICY_TYPE_DROPDOWN(), SyncType.VISIBLE, waitDuration);
    selectDropdown(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().POLICY_TYPE_DROPDOWN(), policyType, SelectOptions.TEXT);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CONTINUE_BUTTON(), SyncType.CLICKABLE);
  }


  public void redirectToPolicyDetails(Map<String, String> searchCriteria) throws CustomE2eException {
    this.clickViewPolicyDetails(searchCriteria.get(CommonControlDataDefns.POLICY_ID));
    waitForElement(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().POLICY_NUMBER(),
        SyncType.VISIBLE);
  }

  public SortedMap<String, Object> getCustomerDetails() throws CustomE2eException {
    var myDetails = new TreeMap<String, Object>();

    this.redirectToRiskTab(); //click Risk link
    this.clickShowAllDetailsLink();
    myDetails.put(Formatting.capitalizeAllFirstCapitalizeRemoveSpace(GetCustomerDetailsPortal.DATE_OF_BIRTH), this.getDateOfBirth());
    myDetails.put(CommonControlDataDefns.OWNERSHIP_TYPE, this.getOwnership());
    //myDetails.put(GetCustomerDetailsPortal.MAIN_ADDRESS, this.getAddress());
    myDetails.put(GetPolicyInformationPortal.EMPLOYMENT_DETAILS, this.getEmpDetails());
    myDetails.put(GetCustomerDetailsPortal.CORRESPONDENCE_ADDRESS, this.getCorrespondenceAddress());
    //myDetails.put(GetCustomerDetailsPortal.RELATIONSHIP_STATUS, this.getRelationshipStatus());
    myDetails.put(Formatting.capitalizeAllFirstCapitalizeRemoveSpace(GetCustomerDetailsPortal.EMAIL_ADDRESS), this.getEmailAddress());
    var fullName = this.getName();
    myDetails.put(CommonControlDataDefns.TITLE, fullName.split(" ")[0]);
    myDetails.put(CommonControlDataDefns.FIRST_NAME, fullName.split(" ")[1]);
    myDetails.put(CommonControlDataDefns.LAST_NAME, fullName.split(" ")[2]);

    myDetails.put(Formatting.capitalizeAllFirstCapitalizeRemoveSpace(GetCustomerDetailsPortal.PHONE_NUMBER), this.getMobileTelephoneNumber().trim());
    return myDetails;
  }

  //Duplicate function.. Need to work on it. 04/04/2024


  public SortedMap<String, Object> getEchelonPolicyData(LocalDate pPolicyStatusDate, Map<String,
      String> searchCriteria) throws ParseException, CustomE2eException {

    var vSourceViewOfPolicy = new TreeMap<String, Object>();
    var custDetails = new TreeMap<String, Object>();
    var coverDetails = new TreeMap<String, Object>();
    var excessDetails = new TreeMap<String, Object>();
    var vUniversalPolicyView = new TreeMap<String, Object>();
    var vAdditionalPolicyInfo = new TreeMap<String, Object>();
    var data = new TreeMap<String, Object>();
    SortedMap<String, Object> enhancedOptions = new TreeMap<>() {
    };
    var jPHDetails = new TreeMap<String, Object>();
    var policyId = searchCriteria.get(PortalGeneralStepDefinitions.SEARCH_BY_POLICY_NUMBER);
    String insuranceType = null;
    if (policyId.startsWith("HE")) {
      insuranceType = CommonControlDataDefns.HOME_INSURANCE_INFORMATION;
    } else if (policyId.startsWith("GD")) {
      insuranceType = CommonControlDataDefns.MOTOR_INSURANCE_INFORMATION;
    } else if (policyId.startsWith("MM")) {
      insuranceType = CommonControlDataDefns.VAN_INSURANCE_INFORMATION;
    }
    if (insuranceType.equalsIgnoreCase(CommonControlDataDefns.HOME_INSURANCE_INFORMATION)) {
      // Select first policy in Policies list on Customer Details page
      this.clickViewPolicyDetails(policyId);
      waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_BREADCRUMB(), SyncType.VISIBLE, waitDuration);

//      vUniversalPolicyView.put(PortalGeneralStepDefinitions.MTA_ADDITIONAL_PREMIUM_AMOUNT,
//      this.adjustmentPremium());
      var businessEventRow = getExpectedBusinessEventRow(pPolicyStatusDate);
      var targetBusinessEventRef =
          getText(xpathBuilder(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENTS_TABLE_REF_ID(), String.valueOf(businessEventRow)));
      var businessEventName =
          getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_BREADCRUMB()).substring(0, 3);

      if (!targetBusinessEventRef.equals(businessEventName)) {
        this.clickBusinessEventsTableRow(businessEventRow);
        waitForPageLoad();
        while (!targetBusinessEventRef.equals(businessEventName)) {
          businessEventName =
              getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_BREADCRUMB()).substring(0, 3);
        }
      }

      vAdditionalPolicyInfo.put(CommonControlDataDefns.EARLIEST_ALLOWED_MTA_DATE,
          this.earliestMtaDate());

      vUniversalPolicyView.put(PortalGeneralStepDefinitions.POLICY_START_DATE,
          Formatting.changeDateFormatIntoExpected(this.getInceptionDate(), "dd-MMM-yyyy",
              "dd/MM" + "/yyyy"));
      vUniversalPolicyView.put(PortalGeneralStepDefinitions.POLICY_END_DATE,
          Formatting.changeDateFormatIntoExpected(this.getPolicyExpiresDate(), "dd-MMM-yyyy", "dd"
              + "/MM/yyyy"));
      vUniversalPolicyView.put(CommonControlDataDefns.POLICY_PERIOD,
          this.CommonHelper.getPolicyExpiresInDays((String) vUniversalPolicyView.get(PortalGeneralStepDefinitions.POLICY_END_DATE)));
      vUniversalPolicyView.put(CommonControlDataDefns.POLICY_ID, this.getHomePolicyNumber());

      custDetails = (TreeMap<String, Object>) getCustomerDetails();
      vUniversalPolicyView.put(CommonControlDataDefns.CUSTOMER_DETAILS, custDetails);
      vUniversalPolicyView.put(CommonControlDataDefns.CLAIM_HISTORY, this.getClaimDetails());

      jPHDetails =
          (!getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().JP_DETAILS()).equalsIgnoreCase("Joint Proposer Details (None)")) ? (TreeMap<String, Object>) getJointPolicyHolderDetails() : null;

      vUniversalPolicyView.put(CommonControlDataDefns.INSURED_HOME_SPECIFIC_DETAILS,
          getInsuredAddressDetails());
      //Home PolicyDetails
      coverDetails = (TreeMap<String, Object>) getCoverDetails();
      navigateToResultTab();
      //clickShowAllDetailsLink();
      excessDetails = (TreeMap<String, Object>) getExcessDetails();  //Excess Details

      excessDetails.put(PortalGeneralStepDefinitions.BUILDING_VOLUNTARY_EXCESS,
          coverDetails.get(PortalGeneralStepDefinitions.BUILDING_VOLUNTARY_EXCESS));
      coverDetails.remove(PortalGeneralStepDefinitions.BUILDING_VOLUNTARY_EXCESS);

      excessDetails.put(PortalGeneralStepDefinitions.CONTENT_VOLUNTARY_EXCESS,
          coverDetails.get(PortalGeneralStepDefinitions.CONTENT_VOLUNTARY_EXCESS));
      coverDetails.remove(PortalGeneralStepDefinitions.CONTENT_VOLUNTARY_EXCESS);

      enhancedOptions = this.getOptionalExtrasAdded();       //Extra options
    } else if (insuranceType.equalsIgnoreCase(CommonControlDataDefns.MOTOR_INSURANCE_INFORMATION)) {
      // Need to add Additional Driver logic
    }


    vUniversalPolicyView.put(CommonControlDataDefns.EXCESS_DET, excessDetails);
    vUniversalPolicyView.put(CommonControlDataDefns.COVER_DET, coverDetails);
    vUniversalPolicyView.put(PortalGeneralStepDefinitions.JPH_PRESENT_FLAG, jPHDetails != null);
    if (jPHDetails != null) {
      vUniversalPolicyView.put(PortalGeneralStepDefinitions.JPH_DETAILS, jPHDetails);
    }
    vUniversalPolicyView.put(PortalGeneralStepDefinitions.ENHANCE_COVER_DET, enhancedOptions);
    vUniversalPolicyView.put(CommonControlDataDefns.POLICY_ID, policyId);

    vAdditionalPolicyInfo.put(PortalGeneralStepDefinitions.POLICY_BALANCE, PolicyBalance());
    data.put(CommonControlDataDefns.HOME_INSURANCE_INFORMATION, vUniversalPolicyView);
    if (data == null || vSourceViewOfPolicy == null) {
      throw new CustomE2eException("Policy not found.");
    }
    return data;
  }

  private ArrayList<SortedMap<String, Object>> getClaimDetails() throws CustomE2eException,
      ParseException {
    var claimDetails = new TreeMap<String, Object>();
    var claim = new ArrayList<SortedMap<String, Object>>();

    if (isElementVisible(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CLAIM_LIST())) {

      var rowCount =
          getCountOfElementsMatchingToLocator(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CLAIM_LIST());

      for (int claimRowCount = 1; claimRowCount <= rowCount; claimRowCount++) {
        var claimDet = new TreeMap<String, Object>();
        var details =
            getTextAllWebElementMatchingLocator(xpathBuilder(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CLAIM_DETAILS(), String.valueOf(claimRowCount)));

        claimDet.put(EchelonGeneralStepDefinitions.BROKER_CLAIM_REF, details.get(0));
        claimDet.put(CommonControlDataDefns.INCIDENT_DATE,
            Formatting.changeDateFormatIntoExpected(details.get(1), "dd/MM/yyyy", "MM/dd/yyyy"));
        claimDet.put(EchelonGeneralStepDefinitions.SETTLED_DATE,
            Formatting.changeDateFormatIntoExpected(details.get(2), "dd/MM/yyyy", "MM/dd/yyyy"));
        claimDet.put(CommonControlDataDefns.CLAIM_STATUS, details.get(3));
        claimDet.put(EchelonGeneralStepDefinitions.TYPE_OF_CLAIM, details.get(4));
        claimDet.put(CommonControlDataDefns.CLAIM_CAUSE, details.get(5));
        claimDet.put(CommonControlDataDefns.CLAIM_COST_VAR, Float.parseFloat(details.get(6)));
        claimDet.put(EchelonGeneralStepDefinitions.COVERED_IN_SAME_CLAIM,
            CommonHelper.convertStringIntoBoolean(details.get(7)));
        claim.add(claimDet);
      }
    }
    return claim;
  }

  private SortedMap<String, Object> getExcessDetails() throws CustomE2eException {
    var excessDetails = new TreeMap<String, Object>();
    excessDetails.put(CommonControlDataDefns.BUILDING_COMPULSORY_EXCESS,
       this.getLevelOfCompulsoryBuildingExcess());
    excessDetails.put(CommonControlDataDefns.CONTENT_COMPULSORY_EXCESS,
        this.getLevelOfCompulsoryContentExcess());
    excessDetails.put(GetCustomerDetailsPortal.ESCAPE_OF_WATER_EXCESS,
        this.getEscapeOfWaterExcess());
    excessDetails.put(CommonControlDataDefns.SUBSIDENCE_GROUND_HEAVE_LAND_SLIP,
        this.getSubsidenceCompulsoryExcess());
    //excessDetails.put(CommonControlDataDefns.FLOOD, "TBA");  -> Bug on UI. Do not Delete.
    return excessDetails;
  }

  private SortedMap<String, Object> getCoverDetails() throws CustomE2eException {
    var coverDetails = new TreeMap<String, Object>();
    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    coverDetails.put(CommonControlDataDefns.REBUILDING_COST, this.getRebuildingCost());
//    information is not on portal
    coverDetails.put(CommonControlDataDefns.TYPE_VAR, this.getTypeOfHouseholdCover());
    coverDetails.put(CommonControlDataDefns.BUILDING_ACCIDENTAL_DAMAGE_COVER,
        CommonHelper.convertStringIntoBoolean(getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().ACCIDENTAL_DAMAGE_BUILDING())));

    coverDetails.put(CommonControlDataDefns.CONTENT_ACCIDENTAL_DAMAGE_VAR,
        CommonHelper.convertStringIntoBoolean(getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().ACCIDENTAL_DAMAGE_CONTENT(), "")));
    redirectToResultTab();
    this.clickShowAllDetailsLink();
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUILDING_VOLUNTARY_EXCESS(), SyncType.VISIBLE, waitDuration);
    coverDetails.put(CommonControlDataDefns.BUILDING_VOLUNTARY_EXCESS,
        getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUILDING_VOLUNTARY_EXCESS(), "").replace("£", ""));
    coverDetails.put(CommonControlDataDefns.CONTENT_VOLUNTARY_EXCESS,
        getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CONTENT_VOLUNTARY_EXCESS(), "").replace("£", ""));
    coverDetails.put(PortalGeneralStepDefinitions.BUILDINGS_MY_COVER,
        getTextNotPresetBecomesEmpty(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUILDIND_SUM_INSURED(), "").replaceAll("[£,]", ""));
        float personalBelongingVal = 0;
    if (isElementVisible(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().PERSONAL_BELONGING_AWAY_FROM_HOME())) {
      scrollElementIntoCenterOfScreen(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().PERSONAL_BELONGING_AWAY_FROM_HOME());
      personalBelongingVal =
          Float.parseFloat(Formatting.getTextFromRegex(getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().PERSONAL_BELONGING_AWAY_FROM_HOME()).replaceAll("[£,]", ""), "\\d*\\.?\\d"));
      if (personalBelongingVal > 0) {
        coverDetails.put(CommonControlDataDefns.PERSONAL_BELONGING_AWAY_FROM_HOME_COST,
            decimalFormat.format(personalBelongingVal));
      }
    }
    coverDetails.put(CommonControlDataDefns.PERSONAL_BELONGING_AWAY_FROM_HOME,
        getPersonalBelonging(decimalFormat.format(personalBelongingVal)));
    coverDetails.put(CommonControlDataDefns.INSURED_HOUSE_HOLD_CONENT_LIMIT,
        (getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().INSURE_HOUSE_HOLD_CONTENT_LIMIT()).replaceAll("[£,]", "")));
    coverDetails.put(CommonControlDataDefns.ACCIDENTAL_DAMAGE_COVER,
       getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CONTENT_MY_COVER()).replaceAll("[£,]", ""));
    redirectToRiskTab();
    coverDetails.put(PortalGeneralStepDefinitions.CONTENT_INSURANCE_HELD,
        getContentInsuranceHeld2Years()); //Have you held contents insurance within the last
    // 2-Status years?
    coverDetails.put(CommonControlDataDefns.PREVIOUS_INSURANCE, getPreviousInsurance());
    var specifiedItems = new TreeMap<String, Object>();

    var haveIndividualItems = getIndividualItemCover(); //away from the home?
    specifiedItems.put(CommonControlDataDefns.AWAY_FROM_HOME_COUNT, haveIndividualItems);
    if (haveIndividualItems != 0) {
      specifiedItems.put(CommonControlDataDefns.ITEMS_AWAY_FROM_HOME, getItemsAwayFromHome());
    }
    var valuableContentStatus = getValuableStatus();  //Do you have any valuables over £2,000
    // that you don't take outside of the home?
    specifiedItems.put(CommonControlDataDefns.IN_HOME_COUNT, valuableContentStatus);
    if (valuableContentStatus != 0) {
      //Do you have any valuables over £2,000 that you don't take outside of the home?
      specifiedItems.put(CommonControlDataDefns.ITEMS_IN_HOME, getItemsInHome());
    }
    coverDetails.put(CommonControlDataDefns.SPECIFIED_ITEM, specifiedItems);
    return coverDetails;
  }


  private Boolean getPersonalBelonging(String personalBelongingVal) {
    if (Double.parseDouble(personalBelongingVal) > 0) {
      return true;
    } else {
      return false;
    }
  }

  private SortedMap<String, Object> getInsuredAddressDetails() throws CustomE2eException {
    var addressAdditionalDetails = new TreeMap<String, Object>();
    addressAdditionalDetails.put(CommonControlDataDefns.NUM_OF_BEDROOM, this.getBedrooms());
    addressAdditionalDetails.put(CommonControlDataDefns.NUM_OF_BATHROOM, this.getCountOfBathroom());
    addressAdditionalDetails.put(CommonControlDataDefns.YEAR_BUILT_VAR, this.getYearBuilt());
    addressAdditionalDetails.put(CommonControlDataDefns.BUILDING_TYPE, this.getPropertyType());
    addressAdditionalDetails.put(CommonControlDataDefns.EXTENSION_DETAILS, getExtensionDetails());
    addressAdditionalDetails.put(CommonControlDataDefns.LISTED_BUILDING_FLAG,
        CommonHelper.convertStringIntoBoolean(getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().LISTING_DETAILS())));
    addressAdditionalDetails.put(CommonControlDataDefns.OCCUPANCY_VAR,
        getOccupiedDetails(getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().HOME_OCCUPIED_DETAILS())));
    addressAdditionalDetails.put(CommonControlDataDefns.LOCKING_DETAILS,
        CommonHelper.convertStringIntoBoolean(getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().HOME_LOCKING())));
    //Free From Flooding
//    addressAdditionalDetails.put(CommonControlDataDefns.FREE_FLOODING_THREAT_VAR,
//        CommonHelper.convertStringIntoBoolean(getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().FREE_FROM_FLOOD_THREAT())));
// DO NOT DELETE - Option in Echelon is Owned, Owned on mortgage and Owned outright. however in
// Portal is more than that.
//    addressAdditionalDetails.put(GetCustomerDetailsPortal.HOME_OWN_RENT_DETAILS,
//        Formatting.capitalizeAllFirstCapitalize(getText(this.pageObjectOfEchelon
//        .getEchelonClientPolicyDetailsLocatorModel()
//        .HOME_OWN_RENT_DET)));
    addressAdditionalDetails.put(GetCustomerDetailsPortal.HOME_BUILT_DETAILS,
        getHouseConstructionDetail(getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().HOME_BUILT_DET())));
//    addressAdditionalDetails.put(GetCustomerDetailsPortal.HOME_ROOF_DETAILS,
//        getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel()
//        .HOME_ROOF_DETAILS)); Details not available
//        on Portal
    addressAdditionalDetails.put(GetCustomerDetailsPortal.HOME_USE_DETAILS,
        CommonHelper.convertStringIntoBoolean(getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().BUSINESS_USE())));
//    addressAdditionalDetails.put(GetCustomerDetailsPortal.HOME_BEST_DESCRIBE,
//          getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel()
//          .HOME_BEST_DESC_DET));
    addressAdditionalDetails.put(CommonControlDataDefns.INTRUDER_ALARM,
        getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().HOME_ALARM_DETAILS()));
    if (isElementVisible(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().HOME_ROOF_MADE_OF()) && !getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().HOME_ROOF_MADE_OF()).isEmpty()) {
      addressAdditionalDetails.put(GetCustomerDetailsPortal.HOME_ROOF_MADE_OF_DETAILS,
          getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().HOME_ROOF_MADE_OF()));
      addressAdditionalDetails.put(GetCustomerDetailsPortal.HOME_WALL_OF_DETAILS,
          getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().HOME_WALL_MADE_OF()));
    }
    addressAdditionalDetails.put(CommonControlDataDefns.NUM_ADULTS,
        Integer.parseInt(getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().NUMBER_OF_ADULT())));
    addressAdditionalDetails.put(CommonControlDataDefns.NUM_CHILD,
        Integer.parseInt(getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().NUMBER_OF_CHILD())));
    addressAdditionalDetails.put(CommonControlDataDefns.NON_FAMILY_LODGER,
        CommonHelper.convertStringIntoBoolean(getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().NON_FAMILY_LODGER())));
    addressAdditionalDetails.put(CommonControlDataDefns.PET_DET,
        getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().PET_DET()));

    //Sarah added
    if (isElementVisible(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().CLERICAL_USE())) {
      var clericalUse =
              getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().CLERICAL_USE());
      if (!clericalUse.isEmpty()) {
        addressAdditionalDetails.put(GetCustomerDetailsPortal.HOME_CLERICAL_USE_DETAILS, clericalUse);
      }
    }
//    addressAdditionalDetails.put(CommonControlDataDefns.RISK_ADDRESS, );
    addressAdditionalDetails.put(CommonControlDataDefns.RISK_ADDRESS, this.getInsuredAddress());
    return addressAdditionalDetails;
  }

  public Object getExtensionDetails() throws CustomE2eException {
    if (getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().HOME_EXTENSION_DET()).equalsIgnoreCase("Unknown")) {
      return "NoValueSelected";
    } else {
      return CommonHelper.convertStringIntoBoolean(getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().HOME_EXTENSION_DET()));
    }
  }

  private String getOccupiedDetails(String text) {
    String occupiedDet = null;
    switch (text) {
      case "Occupied":
        occupiedDet = "Day and Night";
        break;
      case "Daily Unoccupancy":
        occupiedDet = "Unoccupied";
        break;
      case "Nightly Unoccupancy":
        occupiedDet = "During the day";
        break;
      case "Lengthy Unoccupancy":
        occupiedDet = "During the night";
        break;
      default:
    }
    return occupiedDet;
  }

  private Boolean getHouseConstructionDetail(String constDetails) {
    if (constDetails.equalsIgnoreCase("Standard")) {
      return true;
    } else {
      return false;
    }
  }

  private SortedMap<String, Object> getJointPolicyHolderDetails() throws CustomE2eException,
      ParseException {
    var jPHDetails = new TreeMap<String, Object>();
    var nameOfJph = getJointPolicyHolderName();

    jPHDetails.put(GetCustomerDetailsPortal.TITLE, nameOfJph.split(" ")[0]);
    jPHDetails.put(GetCustomerDetailsPortal.NAME, nameOfJph.split(" ")[1]);
    jPHDetails.put(GetCustomerDetailsPortal.LAST_NAME, nameOfJph.split(" ")[2]);
    jPHDetails.put(GetPolicyInformationPortal.MARITAL_STATUS, getJointPolicyHolderMaritalStatus());
    jPHDetails.put(GetPolicyInformationPortal.DATE_OF_BIRTH, getJointPolicyHolderDateOfBirth());

    var employmentDetails = getJointPolicyHolderEmploymentDetails();

    var empDetail = new TreeMap<String, Object>();
    var primEmp = new TreeMap<String, Object>();
    var secondEmp = new TreeMap<String, Object>();
    primEmp.put(CommonControlDataDefns.EMPLOYMENT_STATUS, employmentDetails.split(",")[1].trim());
    primEmp.put(GetPolicyInformationPortal.OCCUPATION, employmentDetails.split(",")[0]);
    primEmp.put(CommonControlDataDefns.INDUSTRY, employmentDetails.split(",")[2].trim());
    empDetail.put(CommonControlDataDefns.PRIMARY_EMPLOYMENT, primEmp);

    var jphSecondJobDetails =
        getInformation(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().JP_PART_TIME_OCCUPATION(), "Joint " + "policy holder second job details");
    if (!jphSecondJobDetails.equalsIgnoreCase("None")) {
      secondEmp.put(CommonControlDataDefns.SECOND_EMP_FLAG, true);
      secondEmp.put(CommonControlDataDefns.EMPLOYMENT_STATUS, jphSecondJobDetails.split(",")[1]);
      secondEmp.put(CommonControlDataDefns.OCCUPATION, jphSecondJobDetails.split(",")[0]);
      secondEmp.put(CommonControlDataDefns.INDUSTRY, jphSecondJobDetails.split(",")[2]);
    } else {
      secondEmp.put(CommonControlDataDefns.SECOND_EMP_FLAG, false);
    }
    empDetail.put(CommonControlDataDefns.SECONDARY_EMPLOYMENT, secondEmp);
    jPHDetails.put(CommonControlDataDefns.EMPLOYMENT_DET, empDetail);
    jPHDetails.put(GetPolicyInformationPortal.RELATIONSHIP_STATUS,
        getJointPolicyHolderRelationshipStatus());
    return jPHDetails;
  }


  private int getExpectedBusinessEventRow(LocalDate pTargetDate) throws CustomE2eException {
    var businessEventRow = -1;

    var found = false;
    do {
      waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENTS_TABLE_DATE(), SyncType.VISIBLE, waitDuration);
      var businessEventDate =
          getTextAllWebElementMatchingLocator(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENTS_TABLE_DATE());
      waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENTS_TABLE_STATUS(), SyncType.VISIBLE, waitDuration);
      var policyStatus =
          getTextAllWebElementMatchingLocator(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENTS_TABLE_STATUS());
      waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_TABLE_HEADING_TEXT(), SyncType.VISIBLE, waitDuration);
      String headingText = RetryOnException("Get text BUSINESS_EVENT_TABLE_HEADING_TEXT",
          CustomE2eException.class, 500L, 10,
          () -> getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_TABLE_HEADING_TEXT()));
      for (var businessEventRows = 0; businessEventRows < businessEventDate.size(); businessEventRows++) {
        var parseBusinessEventDate = LocalDate.parse(businessEventDate.get(businessEventRows),
            DateTimeFormatter.ofPattern("dd-MMM-yyyy").localizedBy(Locale.US));
        if ((parseBusinessEventDate.isBefore(pTargetDate) || parseBusinessEventDate.isEqual(pTargetDate)) && (policyStatus.get(businessEventRows).equalsIgnoreCase("Taken Up"))) {
          businessEventRow = businessEventRows + 1;
          found = true;
          break;
        }
      }
      if (!found) {
        if (isElementVisible(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_TABLE_NEXT_BUTTON())) {
          clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_TABLE_NEXT_BUTTON(), SyncType.CLICKABLE);
          do {
            waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_TABLE_HEADING_TEXT(), SyncType.VISIBLE, waitDuration);
            var latestHeadingText = RetryOnException("Get text BUSINESS_EVENT_TABLE_HEADING_TEXT"
                , CustomE2eException.class, 500L, 10,
                () -> getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_TABLE_HEADING_TEXT()));
            if (!latestHeadingText.equalsIgnoreCase(headingText)) {
              break;
            }
            try {
              Thread.sleep(100L);
            } catch (InterruptedException e) {

            }
          } while (true);
        }
      }
    } while (!found && isElementEnabled(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_TABLE_NEXT_BUTTON()));
    if (businessEventRow == -1) {
      throw new CustomE2eException("Business event for date earlier than " + pTargetDate + " not "
          + "found");
    }
    return businessEventRow;
  }


  private int getExpectedBusinessEventRow() throws CustomE2eException {
    var businessEventRow = -1;
    var numberOfPages =
        getElementsMatchingToLocator(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().PAGE_INDEX());
    int currPage = 1;
    var found = false;
    do {
      var businessEventDate =
          getTextAllWebElementMatchingLocator(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENTS_TABLE_DATE());
      var policyStatus =
          getTextAllWebElementMatchingLocator(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENTS_TABLE_STATUS());
      waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_TABLE_HEADING_TEXT(), SyncType.VISIBLE, waitDuration);
      String headingText =
          getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_TABLE_HEADING_TEXT());
      //     if (!policyStatus.contains("Taken Up")||!policyStatus.contains("Void") ) {
      for (var businessEventRows = 0; businessEventRows < businessEventDate.size(); businessEventRows++) {
        if (!policyStatus.get(businessEventRows).contains("Taken Up") || !policyStatus.get(businessEventRows).contains("Void")) {
          businessEventRow = businessEventRows + 1;
          found = true;
          break;
        }
      }
      //     }
      if (!found) {
        if (isElementVisible(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_TABLE_NEXT_BUTTON())) {
          clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_TABLE_NEXT_BUTTON(), SyncType.CLICKABLE);
          NoThrowSleep(Duration.ofMillis(600L));
          currPage++;
          if (currPage > numberOfPages.size()) {
            break;
          }
          do {
            waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_TABLE_HEADING_TEXT(), SyncType.VISIBLE, waitDuration);
            var latestHeadingText =
                getText(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_TABLE_HEADING_TEXT());
            if (!latestHeadingText.equalsIgnoreCase(headingText)) {
              break;
            }
            try {
              Thread.sleep(100L);
            } catch (InterruptedException e) {

            }
          } while (true);
        }
      }
    } while (!found && isElementEnabled(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_TABLE_NEXT_BUTTON()));
    if (isElementVisible(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().NEXT_PAGE())) {
      scrollIntoView(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_TABLE_FIRST_PAGE());
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENT_TABLE_FIRST_PAGE(), SyncType.VISIBLE);
      NoThrowSleep(Duration.ofMillis(600L));
      waitForPageLoad();
    }
    if (businessEventRow == -1) {
      throw new CustomE2eException("Business event not found");
    }
    return businessEventRow;
  }


  public void navigateToResultTab() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().RESULT_TAB(), SyncType.CLICKABLE, waitDuration);
    RetryOnException("navigateToResultTab", CustomE2eException.class, 500L, 50,
        () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().RESULT_TAB(), SyncType.CLICKABLE));
    waitForPageLoad();
    //NoThrowSleep(Duration.ofMillis(3000L));
  }

  public void navigateToSummaryTab() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().SUMMARY_TAB(), SyncType.CLICKABLE, waitDuration);
    //NoThrowSleep(Duration.ofMillis(6000L)); // need fixes
    RetryOnClickInterceptedException(50,
        () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().SUMMARY_TAB(), SyncType.CLICKABLE));
  }

  public void navigateToRiskTab() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().RISK_TAB(), SyncType.CLICKABLE, waitDuration);
    waitForPageLoad();
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().RISK_TAB(),
        SyncType.CLICKABLE);
    //NoThrowSleep(Duration.ofMillis(3000L));
  }

  public String getHomePolicyNumber() throws CustomE2eException {
    return RetryOnException("getHomePolicyNumber", CustomE2eException.class, 500L, 50,
        () -> getText(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().POLICY_NUMBER()));
  }

  private void clickViewPolicyDetails(String policyID) throws CustomE2eException {
    List<WebElement> rows =
        getElementsMatchingToLocator(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().POLICIES_TABLE());
    String actualPolicyId;
    for (int numberOfRows = 1; numberOfRows <= rows.size(); numberOfRows++) {
      var loop = numberOfRows;
      RetryOnException("clickViewPolicyDetails", CustomE2eException.class, 500L, 10,
          () -> clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().VIEW_POLICY_DETAILS_BUTTON(), String.valueOf(loop)), SyncType.CLICKABLE));
      waitForPageLoad();
      waitForElement2(this.pageObjectOfEchelon.getEchelonClientDetailLocatorModel().POLICY_NUMBER(), SyncType.VISIBLE, waitDuration);
      actualPolicyId = getHomePolicyNumber();
      if (policyID.equalsIgnoreCase(actualPolicyId)) {
        break;
      }
      waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CLIENT_ID_BREADCRUM(), SyncType.CLICKABLE, waitDuration);
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().CLIENT_ID_BREADCRUM(), SyncType.CLICKABLE);
      waitForPageLoad();
      NoThrowSleep(Duration.ofMillis(3000L));
    }
  }

  public void clickBusinessEventsTableRow(int businessEventRow) throws CustomE2eException {
    waitForElement2(xpathBuilder(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENTS_TABLE_ROW(), String.valueOf(businessEventRow)), SyncType.VISIBLE, waitDuration);
    scrollIntoView(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENTS_TABLE_HEADER());
    scrollIntoView(xpathBuilder(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENTS_TABLE_ROW(), String.valueOf(businessEventRow)));
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().BUSINESS_EVENTS_TABLE_ROW(), String.valueOf(businessEventRow)), SyncType.CLICKABLE);
    waitForPageLoad();
  }


  private void redirectToRiskTab() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().RISK_TAB(), SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().RISK_TAB(), SyncType.CLICKABLE);
    NoThrowSleep(Duration.ofMillis(600L));
  }

  private void redirectToResultTab() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().RESULT_TAB(), SyncType.CLICKABLE, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().RESULT_TAB(), SyncType.CLICKABLE);
    NoThrowSleep(Duration.ofMillis(600L));
  }


  private void clickShowAllDetailsLink() throws CustomE2eException {
    waitForElement2(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().SHOW_DETAILS_LINK(),
            SyncType.CLICKABLE, waitDuration);

    waitForPageLoad();
    if (isElementVisible(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().SHOW_DETAILS_LINK())) {
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().SHOW_DETAILS_LINK(), SyncType.CLICKABLE);
      waitForPageLoad();
    }
  }

  public String getFirstStringValue(String input) {
    int spaceIndex = input.indexOf(" ");
    if (spaceIndex != -1) {
      return input.substring(0, spaceIndex);
    } else {
      return input; // If there is no space, return the entire input string
    }
  }


  public SortedMap<String, Object> getOptionalExtrasAdded() throws CustomE2eException {
    var myEnhancedCoverDetails = new TreeMap<String, Object>();
    myEnhancedCoverDetails.put(CommonControlDataDefns.EXCESS_PROTECTION, false);
    myEnhancedCoverDetails.put(CommonControlDataDefns.LEGAL_EXPENSES, false);
    myEnhancedCoverDetails.put(CommonControlDataDefns.EXTRA_HOME_EMERGENCY, false);
    myEnhancedCoverDetails.put(CommonControlDataDefns.EXCESS_PROTECTION_SUBSIDENCE_VAR, false);
    if (isElementVisible(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().OPTIONAL_EXTRAS_LINE_ITEMS())) {
      List<WebElement> rows =
          getElementsMatchingToLocator(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().OPTIONAL_EXTRAS_LINE_ITEMS());
      for (int enhanceCoverRows = 1; enhanceCoverRows <= rows.size(); enhanceCoverRows++) {
        String description =
            getText(xpathBuilder(this.pageObjectOfEchelon.getEchelonClientPolicyDetailsLocatorModel().OPTIONAL_EXTRAS_TABLE_DESCRIPTION_COLUMN(), String.valueOf(enhanceCoverRows)));
        myEnhancedCoverDetails.put(getKeyValue(description), true);
      }
      waitForPageLoad();
    }
    return myEnhancedCoverDetails;
  }

  private String getKeyValue(String text) {
    String enhanceKey = null;
    switch (text) {
      case "Home Excess Protection":
      case "Excess Protection":
        enhanceKey =
            Formatting.capitalizeAllFirstCapitalizeRemoveSpace(PortalGeneralStepDefinitions.EXCESS_PROTECTION);
        break;
      case "Legal Expenses":
        enhanceKey =
            Formatting.capitalizeAllFirstCapitalizeRemoveSpace(PortalGeneralStepDefinitions.LEGAL_EXP);
        break;
      case "Home Emergency":
      case "Ageas Extra Home Emergency":
        enhanceKey =
            Formatting.capitalizeAllFirstCapitalizeRemoveSpace(PortalGeneralStepDefinitions.EXTRA_HOME_EMERGENCY);
        break;
      case "Home Excess Protection Subsidence":
        enhanceKey =
            Formatting.capitalizeAllFirstCapitalizeRemoveSpace(PortalGeneralStepDefinitions.EXCESS_PROTECTION_SUBSIDENCE);
        break;
      default:
    }
    return enhanceKey;
  }


//    public void PrintRawCustomerDetails() {
//        Map<String, Object> populatedMap = getRawCustomerDetails();
//        System.out.println(populatedMap);
//    }
//
//    public void PrintCustomerDetailsInPortalFormat() {
//        Map<String, Object> populatedMap = getCustomerDetailsInPortalFormat();
//        System.out.println(populatedMap);
//    }

//
//    public static String formatName(String input) {
//        String[] nameParts = input.split(","); // Split the input by commas
//
//        String lastName = nameParts[0].trim();
//        String firstName = nameParts[1].trim().split(" ")[0]; // Extract the first name
//
//        return lastName + ", " + firstName;
//    }
//
//    public static String formatDate(String input) {
//        SimpleDateFormat inputFormat = new SimpleDateFormat("DD-MMM-YYYY");
//        SimpleDateFormat outputFormat = new SimpleDateFormat("DD MMM YYYY");
//
//        try {
//            Date date = inputFormat.parse(input);
//            return outputFormat.format(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

}

package PageObjects.EchelonVersion.V01;

import PageObjects.EchelonModel.EchelonQuoteCreationLocatorModel;
import org.openqa.selenium.By;


public class EchelonQuoteCreationLocatorLib implements EchelonQuoteCreationLocatorModel {
  public By PROPOSER_SURNAME() {return By.cssSelector("[name=\"proposerPersonalDetails" +
      ":surname\"]");}
  @Override
  public By PROPOSER_FORENAME() {return By.cssSelector("[name=\"proposerPersonalDetails" +
      ":forename\"]");}
  @Override
  public By PROPOSER_GENDER() {return By.cssSelector("[name=\"proposerPersonalDetails:gender"
      + "\"]");}
  @Override
  public By PROPOSE_MARITAL_STATUS() {return By.cssSelector("[name=\"proposerPersonalDetails"
      + ":maritalStatus\"]");}
  @Override
  public By PROPOSE_TITLE() {return By.cssSelector("[name=\"proposerPersonalDetails:title\"]");}
  @Override
  public By PROPOSE_DATE_OF_BIRTH() {return By.cssSelector("[name=\"proposerPersonalDetails" + ":dateOfBirth\"]");}
  @Override
  public By PROPOSE_UK_RESIDENT_SINCE() {return By.cssSelector("[name" +
      "=\"proposerPersonalDetails:ukResidency\"]");}
  @Override

  public By JPH_SURNAME() {return By.cssSelector("[name=\"jointProposer:jointProposer" +
      ":toggleComponent:surname\"]");}
  @Override
  public By JPH_FORENAME() {return By.cssSelector("[name=\"jointProposer:jointProposer" +
      ":toggleComponent:forename\"]");}
  @Override
  public By JPH_GENDER() {return By.cssSelector("[name=\"jointProposer:jointProposer" +
      ":toggleComponent:gender\"]");}
  @Override
  public By JPH_MARITAL_STATUS() {return By.cssSelector("[name=\"jointProposer:jointProposer"
      + ":toggleComponent:maritalStatus\"]");}
  @Override
  public By JPH_TITLE() {return By.cssSelector("[name=\"proposerPersonalDetails:title\"]");}
  @Override
  public By JPH_DATE_OF_BIRTH() {return By.cssSelector("[name=\"jointProposer:jointProposer" + ":toggleComponent:dateOfBirth\"]");}
  @Override
  public By JPH_UK_RESIDENT_SINCE() {return By.cssSelector("[name=\"jointProposer" +
      ":jointProposer:toggleComponent:ukResidency\"]");}
  @Override
  public By JPH_RELATIONSHIP_WITH_POLICY_HOLDER() {return By.cssSelector("[name" +
      "=\"jointProposer:jointProposer:toggleComponent:jointRelationshipToProposer\"]");}
  @Override
  public By JPH_INSURANCE_REFUSED_PREVIOUSLY() {return By.cssSelector("[name=\"jointProposer"
      + ":jointProposer:toggleComponent:jointLifeStyle:declinedInsuranceIndicator\"]");}
  @Override

  public By EMP_OCCUPATION_DET() {return By.name("occupation:ftOccupation:occupation");}
  @Override
  public By EMP_EMP_STATUS() {return By.name("occupation:ftOccupation:employmentStatus");}
  @Override
  public By EMP_INDUSTRY() {return By.name("occupation:ftOccupation:employer");}
  @Override
  public By PART_TIME_OCCUPATION() {return By.name("occupation:ptOccupation:occupation");}
  @Override
  public By PART_TIME_EMP_STATUS() {return By.name("occupation:ptOccupation:employmentStatus");}
  @Override
  public By PART_TIME_INDUSTRY() {return By.name("occupation:ptOccupation:employer");}
  @Override

  public By JPH_EMP_OCCUPATION_DET() {return By.name("jointProposer:jointProposer" +
      ":toggleComponent:jointOccupation:ftOccupation:occupation");}
  @Override
  public By JPH_EMP_EMP_STATUS() {return By.name("jointProposer:jointProposer" +
      ":toggleComponent:jointOccupation:ftOccupation:employmentStatus");}
  @Override
  public By JPH_EMP_INDUSTRY() {return By.name("jointProposer:jointProposer:toggleComponent" + ":jointOccupation:ftOccupation" +
          ":employer");}
  @Override
  public By JPH_PART_TIME_OCCUPATION() {return By.name("jointProposer:jointProposer" +
      ":toggleComponent:jointOccupation:ptOccupation:occupation");}
  @Override
  public By JPH_PART_TIME_EMP_STATUS() {return By.name("jointProposer:jointProposer" +
      ":toggleComponent:jointOccupation:ptOccupation:employmentStatus");}
  @Override
  public By JPH_PART_TIME_INDUSTRY() {return By.name("jointProposer:jointProposer" +
      ":toggleComponent:jointOccupation:ftOccupation:employer");}
  @Override

  public By OPTION() {return By.xpath("((//ul[contains(@style,\"display\")])" + "/li[1])" +
      "[last()]");}
  @Override
  public By POST_CODE() {return By.cssSelector("[name=\"address:address:pafForm:postCode\"]");}
  @Override
  public By FIND_ADDRES() {return By.cssSelector("[name=\"address:address:pafForm:pafSearch" + "\"]");}
  @Override
  public By HOUSE_INDENTIFIER() {return By.cssSelector("[name=\"address:address:houseNumber" + "\"]");}
  @Override
  public By CONTACT_TYPE() {return By.xpath("//select[contains(@name, " + "\"contactDetails" + ":phoneNumbers:container" +
          ":details\")]");}
  @Override
  public By CONTACT_INPUT_FIELD() {return By.xpath("//input[contains(@name, " +
      "\"contactDetails:phoneNumbers:container\")]");}
  @Override
  public By PREFFERED_DELIVERY() {return By.cssSelector("[name=\"contactDetails:emailAddress"
      + ":prefferedDeliveryEmailAddress:preferredDeliveryMethod\"]");}
  @Override
  public By PROPOSER_EMAIL() {return By.cssSelector("[name=\"contactDetails:emailAddress" +
      ":prefferedDeliveryEmailAddress:emailAddress\"]");}
  @Override

  public By BUILDING_TYPE() {return By.cssSelector("[name=\"propertyMainBuildingDetails" +
      ":typeOfPropertyCM\"]");}
  @Override

  public By CONSTRUCTION_TYPE() {return By.cssSelector("[name=\"propertyMainBuildingDetails" + ":typeOfConstructionCM" + "\"]");}
  @Override
  public By YEAR_BUILT() {return By.cssSelector("[name=\"propertyMainBuildingDetails" +
      ":yearsBuilt\"]");}
  @Override
  public By NUMBER_OF_BEDROOM() {return By.cssSelector("[name=\"propertyMainBuildingDetails" + ":numberOfBedrooms\"]");}
  @Override
  public By NUMBER_OF_BATHROOM() {return By.xpath("//label[normalize-space(text())=\"How " + "Many Bathrooms/En-Suites Do You " +
          "Have?\"]/following::input[1]");}
  @Override
  public By OWNERSHIP() {return By.cssSelector("[name=\"propertyMainBuildingDetails" +
      ":ownershipCM\"]");}
  @Override
  public By LISTING_STATUS() {return By.cssSelector("[name=\"propertyStructuralDetails" +
      ":listedBuildingCM\"]");}
  @Override
  public By BUILDING_WORK_STATUS() {return By.cssSelector("[name=\"propertyStructuralDetails"
      + ":buildingWorkInProgressCM\"]");}
  @Override
  public By REPAIR_STATUS() {return By.cssSelector("[name=\"propertyStructuralDetails" +
      ":buildingGoodStateRepairCM" + "\"]");}
  @Override
  public By GEOLOGICAL_STATUS() {return By.cssSelector("[name=\"propertyStructuralDetails" + ":subsidenceCM\"]");}
  @Override
  public By FLOODING_THREAT() {return By.cssSelector("[name=\"propertyStructuralDetails" +
      ":freeFromFloodingCM\"]");}
  @Override
  public By BUILDING_REBUILDING_COST() {return By.cssSelector("[name=\"basicBuildingsDetail" + ":rebuildingCost\"]");}
  @Override
  public By BUILDING_ACCIDENTAL_DAMAGE() {return By.cssSelector("[name" +
      "=\"basicBuildingsDetail" + ":buildingsAccidentalDamageCM\"]");}
  @Override
  public By BUILDING_VOLUNTARY_EXCESS() {return By.cssSelector("[name=\"basicBuildingsDetail"
      + ":buildingsVoluntaryExcess\"]");}
  @Override
  public By CONTENT_ACCIDENTAL_DAMAGE() {return By.cssSelector("[name=\"contents" +
      ":accidentalDamage\"]");}
  @Override
  public By CONTENT_VOLUNTARY_EXCESS() {return By.cssSelector("[name=\"contents" +
      ":voluntaryExcess\"]");}
  @Override
  public By INTERESTED_PARTY() {return By.cssSelector("[name=\"interestedPartiesContainer" + ":interestedParties" +
          ":toggleQuestion\"]");}
  @Override
  public By SUM_INSURED() {return By.cssSelector("[name=\"contents:sumInsured\"]");}
  @Override
  public By SAFE_INSTALLED() {return By.cssSelector("[name=\"contents:safeInstalled\"]");}
  @Override
  public By SPECIFIED_CONTENT() {return By.cssSelector("[name=\"specifiedContents" +
      ":containedComponent:toggleQuestion\"]");}
  @Override
  public By RTA_CONVICTION_DETAILS() {return By.xpath("//select[contains(@name, " +
      "\"convictions:containedComponent:convictionsComponent:convictions\")]");}
  @Override
  public By JPH_RTA_CONVICTION_DETAILS() {return By.xpath("(//label[normalize-space(text())" +
      "=\"Non-RTA Convictions:\"])[2]/following::select[1]");}
  @Override
  public By NON_FAMILY_LEDGERS() {return By.cssSelector("[name=\"propertyUsageDetails" +
      ":nonFamilyLodgers\"]");}
  @Override
  public By LET_SUB_LET() {return By.cssSelector("[name=\"propertyUsageDetails:letSublet\"]");}
  @Override
  public By BUSINESS_USE() {return By.cssSelector("[name=\"propertyUsageDetails:businessUse" + "\"]");}
  @Override
  public By HOLIDAY_HOME_STATUS() {return By.cssSelector("[name=\"propertyUsageDetails" +
      ":holidayHome\"]");}
  @Override
  public By OCCUPANCY() {return By.cssSelector("[name=\"propertyUsageDetails:occupancy\"]");}
  @Override
  public By SECURITY_LOCKS() {return By.cssSelector("[name=\"propertySecurityDetails" +
      ":doorAndWindowLocksCM\"]");}
  @Override
  public By ALARMS() {return By.cssSelector("[name=\"propertySecurityDetails:burglarAlarmCM" + "\"]");}
  @Override
  public By NEIGHBOURHOOD_WATCH() {return By.cssSelector("[name=\"propertySecurityDetails" + ":neighbourhoodWatchCM\"]");}
  @Override
  public By RISK_DROPDOWN() {return By.cssSelector("[name=\"allRisks:allRisksComponent" +
      ":toggleQuestion\"]");}
  @Override
  public By MARKETING_POSTAL() {return By.cssSelector("[name=\"clientUserFields" +
      ":UserFieldContainer:userFields:0:userField\"]");}
  @Override
  public By MARKETING_EMAIL() {return By.cssSelector("[name=\"clientUserFields" +
      ":UserFieldContainer:userFields:1:userField\"]");}
  @Override
  public By MARKETING_TELEPHONE() {return By.cssSelector("[name=\"clientUserFields" +
      ":UserFieldContainer:userFields:2:userField\"]");}
  @Override
  public By MARKETING_SMS() {return By.cssSelector("[name=\"clientUserFields" +
      ":UserFieldContainer:userFields:3:userField\"]");}
  @Override
  public By SUFFERED_LOSS() {return By.cssSelector("[name=\"policyUserFields" +
      ":UserFieldContainer:userFields:0:userField\"]");}
  @Override
  public By SOURCE_CUSTOMER() {return By.cssSelector("[name=\"policyUserFields" +
      ":UserFieldContainer:userFields:1:userField\"]");}
  @Override
  public By NEXT_PAGE() {return By.cssSelector("[value=\"Next Page\"]");}
  @Override
  public By JOINT_POLICY_HOLDER() {return By.cssSelector("[name=\"jointProposer" +
      ":jointProposer:toggleQuestion\"]");}
  @Override
  public By RISK_FIND_ADDRES() {return By.cssSelector("[name=\"riskAddress:address:pafForm" + ":pafSearch\"]");}
  @Override
  public By RISK_HOUSE_INDENTIFIER() {return By.cssSelector("[name=\"riskAddress:address" +
      ":houseNumber\"]");}
  @Override
  public By RISK_POST_CODE() {return By.cssSelector("[name=\"riskAddress:address:pafForm" +
      ":postCode\"]");}
  @Override
  public By USE_CONTACT_ADDRESS() {return By.cssSelector("[name=\"riskAddress" +
      ":useClientAddressForm:sameAsClientAddress\"]");}
  @Override
    public By UPDATE_RISK_ADDRESS() {return By.cssSelector("[value=\"Update Risk Address\"]");}
  @Override
  public By WALL_CONSTRUCTION_TYPE() {return By.xpath("(//label[" + "contains" + "(normalize"
      + "-space(text()),\"wall " + "construction\")]/following::select)[1]");}
  @Override
  public By ROOF_CONSTRUCTION_TYPE() {return By.xpath("(//label[contains(normalize-space" +
      "(text()),\"roof " + "construction\")]/following::select)[1]");}
  @Override
  public By PET_DETAILS() {return By.xpath("(//label[contains(normalize-space(text())," + "\"pet living\")" +
          "]/following::select)[1]");}
  @Override
  public By PAYMENT_TYPE() {return By.xpath("(//label[contains(normalize-space(text())," +
      "\"Payment Type\")" + "]/following::select)[1]");}
  @Override
  public By EXTENDED_HOUSE() {return By.xpath("(//label[contains(normalize-space(text())," + "\"extended\")]/following::select)" + "[1]");}
  @Override
  public By COUNTY_COURT_JUDGEMENT() {return By.xpath("(//label[contains(normalize-space" +
      "(text()),\"County " + "Court\")]/following::select)[1]");}
  @Override
  public By DECLARED_BANKRUPT() {return By.xpath("(//label[contains(normalize-space(text()),"
      + "\"bankrupt\")" + "]/following::select)[1]");}
  @Override
  public By NUMBER_OF_ADULT() {return By.xpath("(//label[contains(normalize-space(text())," + "\"adults live\")" + "]/following" + "::select)[1]");}
  @Override
  public By NUMBER_OF_CHILDREN() {return By.xpath("(//label[contains(normalize-space(text())"
      + ",\"children live\")" + "]/following::select)[1]");}
  @Override
  public By ROOF_PERCENTAGE() {return By.xpath("(//label[contains(normalize-space(text())," + "\"percentage of the " + "roof\")" + "]/following::select)[1]");}
  @Override
  public By LEFT_UNOCCUPIED() {return By.xpath("(//label[contains(normalize-space(text())," + "\"left unoccupied\")" +
          "]/following::select)[1]");}
  @Override
  public By PROPERTY_OWNER() {return By.xpath("(//label[contains(normalize-space(text())," + "\"property owned\")" +
          "]/following::select)[1]");}
  @Override
  public By GET_QUOTES() {return By.cssSelector("[value=\"Get Quote\"]");}
  @Override
  public By QUOTE_VALUE() {return By.xpath("(//label[contains(text(),\"Selling Price\")" +
      "]/following::label)[1]");}
  @Override
  public By STORE_QUOTE() {return By.cssSelector("[value=\"Store Quote\"]");}
  @Override
  public By QUOTE_REFERENCE() {return By.cssSelector("#stored-quote-ref");}
  @Override
  public By STORE_QUOTE_DURATION() {return By.xpath("//div[@class=\"alert alert-success " +
      "quoteStoreConfirmation\"]/child::span[3]");}
  @Override
  public By VIEW_QUOTE() {return By.cssSelector("[value=\"View Quote\"]");}
  @Override
  public By WEB_REFERENCE() {return By.xpath("//label[text()=\"Web " + "Reference" +
      ":\"]/following::label[1]");}
  @Override
  public By SELECT_CREDIT_CARD() {return By.xpath("(//span[@class=\"selectCardLabelText\"])[1]");}
  @Override
  public By PREV_CARD_EXPIRY_DATE() {return By.xpath("//table[@data-id=\"previousCards\"]/tbody" +
      "/tr[1" +
      "]/td[4]");}
  @Override
  public By PAYMENT_BACK() {return By.cssSelector("[name=\"back.y\"]");}
  @Override
  public By CONTINUE_WRAP_UP_WITHOUT_PAYMENT() {return By.cssSelector("[value=\"Continue " + "Wrap Up Without Taking Payment\"]");}
  @Override
  public By CARD_HOLDER_NAME() {return By.cssSelector("#PayCardHolder");}
  @Override
  public By CARD_EXPIRY_DATE() {return By.cssSelector("#PayCardExpireSplitMM");}
  @Override
  public By CARD_EXPIRY_YEAR() {return By.cssSelector("#PayCardExpireSplitYY");}
  @Override
  public By CARD_BELONG_TO_YOU() {return By.cssSelector("#ProposerIsCardHolder");}
  @Override
  public By MANUAL_PAYMENT() {return By.cssSelector("#IsManualPayment");}
  @Override
  public By PERMISSION_TO_STORED_CARD_DETAILS() {return By.cssSelector(
      "#SelectedPreviousCardAutoReuseConsent");}
  @Override
  public By LIST_OF_QUESTION() {return By.xpath("//fieldset[@class=\"section\"]//div[@class" + "=\"controls \"]/*[1][not" +
          "(@disabled)]/parent::div/preceding::label[1]");}
  @Override
  public By PAYMENT_SUMMARY() {return By.cssSelector("[data-id=\"paymentStatusMessage\"]");}

  @Override
  public By PAYMENT_STATUS() {return By.xpath("//label[text()=\"Policy " +
      "Status:\"]/following::label[1]");}

  //// MOTOR DETAILS ////

  // VEHICLE SECTION
  public By LICENSE_TYPE(){
    return By.xpath("//label[contains(text(),\"Licence Type\")]/following::select[1]");
  }

  @Override
  public By LICENSE_DATE(){
    return By.xpath("//label[contains(text(),\"Licence Date\")]/following::input[1]");
  }

  @Override
  public By REGISTRATION(){
    return By.xpath("//label[contains(text(),\"Registration Number\")]/following::input[1]");
  }

  @Override
  public By FIND_VEHICLE(){
    return By.xpath("//input[@value=\"Find Vehicle\"]");
  }

  @Override
  public By LEFT_HAND_DRIVE(){
    return By.xpath("//label[contains(text(),\"Left Hand Drive:\")]/following::select[1]");
  }

  @Override
  public By NUMBER_OF_SEATS(){
    return By.xpath("//label[contains(text(),\"Number of Seats\")]/following::input[1]");
  }

  @Override
  public By PURCHASE_DATE(){
    return By.xpath("//label[contains(text(),\"Purchase Date\")]/following::input[1]");
  }

  @Override
  public By CURRENT_MARKET_VALUE(){
    return By.xpath("//label[contains(text(),\"Current Market Value\")]/following::input[1]");
  }

  @Override
  public By VEHICLE_OWNER(){
    return By.xpath("//label[contains(text(),\"Vehicle Owner\")]/following::select[1]");
  }

  @Override
  public By PROPOSER_REGISTERED_KEEPER(){
    return By.xpath("//label[contains(text(),\"Proposer Registered Keeper\")]/following::select[1]");
  }

  @Override
  public By WHERE_KEPT_OVERNIGHT(){
    return By.xpath("//label[contains(text(),\"Where Kept Overnight\")]/following::select[1]");
  }

  @Override
  public By WHERE_KEPT_POSTCODE(){
    return By.xpath("//label[contains(text(),\"Where Kept Postcode\")]/following::input[1]");
  }

  @Override
  public By MODIFICATIONS(){
    return By.xpath("//label[contains(text(),\"Modifications\")]/following::select[1]");
  }


  @Override
  public By ALARM(){
    return By.xpath("//label[contains(text(),\"Alarm\")]/following::select[1]");
  }

  @Override
  public By IMMOBILISER(){
    return By.xpath("//label[contains(text(),\"Immobiliser\")]/following::input[1]");
  }

  @Override
  public By TRACKER(){
    return By.xpath("//label[contains(text(),\"Tracker\")]/following::input[1]");
  }


  //MOTORING DETAILS SECTION
  @Override
  public By CLASS_OF_USE(){
    return By.xpath("//label[contains(text(),\"Class of Use\")]/following::select[1]");
  }


  @Override
  public By ANNUAL_MILEAGE(){
    return By.xpath("//label[contains(text(),\"Annual Mileage\")]/following::input[1]");
  }

  @Override
  public By LEVEL_OF_VOLUNTARY_EXCESS(){
    return By.xpath("//label[contains(text(),\"Level of Voluntary Excess\")]/following::input[1]");
  }

  @Override
  public By USE_OF_VEHICLE_BY_PROPOSER(){
    return By.xpath("//label[contains(text(),\"Use of Vehicle by Proposer\")]/following::select[1]");
  }

  @Override
  public By NUMBER_OF_OTHER_VEHICLES_IN_HOUSEHOLD(){
    return By.xpath("//label[contains(text(),\"Number of Other Vehicles in Household\")]/following::input[1]");
  }

  @Override
  public By ACCESS_TO_OTHER_VEHICLES(){
    return By.xpath("//label[contains(text(),\"Access to Other Vehicles\")]/following::select[1]");
  }

  //PREVIOUS INSURANCE SECTION
  @Override
  public By PREVIOUS_INSURANCE(){
    return By.xpath("//label[contains(text(),\"Previous Insurance\")]/following::select[1]");
  }

  @Override
  public By DRIVING_EXPERIENCE_NOT_IN_YOUR_NAME(){
    return By.xpath("//label[contains(text(),\"Driving Experience Not in Your Name\")]/following::select[1]");
  }

  @Override
  public By DRIVING_RESTRICTIONS(){
    return By.xpath("//label[contains(text(),\"Driving Restrictions\")]/following::select[1]");
  }

  @Override
  public By  ANY_CLAIMS(){
    return By.xpath("//label[contains(text(),\"Any Claims\")]/following::select[1]");
  }

  @Override
  public By  HOW_DO_YOU_PAY_FOR_YOUR_INSURANCE(){
    return By.xpath("//label[contains(text(),\"How do you pay for your insurance\")]/following::select[1]");
  }
  @Override
  public By   WHERE_DID_YOU_HEAR_ABOUT_US(){
    return By.xpath("//label[contains(text(),\"Where did you hear about us\")]/following::select[1]");
  }

  @Override
  public By   NCD_APPLIED_TO_ANY_OTHER_VEHICLE(){
    return By.xpath("//label[contains(text(),\"NCD Applied to Any Other Vehicle\")]/following::select[1]");
  }

  @Override
  public By   TYPE_OF_INSURANCE(){
    return By.xpath("//label[contains(text(),\"Type of Insurance\")]/following::select[1]");
  }

  @Override
  public By   NCD_CLAIMED(){
    return By.xpath("//label[contains(text(),\"NCD Claimed\")]/following::input[1]");
  }

  @Override
  public By   NCD_CURRENTLY_PROTECTED(){
    return By.xpath("//label[contains(text(),\"NCD Currently Protected\")]/following::select[1]");
  }

  @Override
  public By   PROTECTED_NCD_REQUIRED(){
    return By.xpath("//label[contains(text(),\"Protected NCD Required\")]/following::select[1]");
  }

  @Override
  public By   POLICY_EXPIRY_DATE(){
    return By.xpath("//label[contains(text(),\"Policy Expiry Date\")]/following::input[1]");
  }

  @Override
  public By   WHAT_IS_DAY_TIME_LOCATION_OF_VEHICLE(){
    return By.xpath("//label[contains(text(),\"What is the daytime location of the vehicle\")]/following::select[1]");
  }

  @Override
  public By   HOW_MANY_CHILDREN_ARE_IN_THE_HOUSEHOLD(){
    return By.xpath("//label[contains(text(),\"How many children are in the household\")]/following::input[1]");
  }

  @Override
  public By   IS_THE_PROPOSER_MEMBER_OF_IAM(){
    return By.xpath("//label[contains(text(),\"Is the proposer a member of the IAM or other organisation\")]/following::select[1]");
  }

  @Override
  public By   ARE_YOU_A_HOMEOWNER(){
    return By.xpath("//label[contains(text(),\"Are you a Home Owner\")]/following::select[1]");
  }

  @Override
  public By   DO_YOU_REGULARLY_USE_THE_CAR_IN_PEAKTIME(){
    return By.xpath("//label[contains(text(),\"Do you REGULARLY use the car in peak time e.g. rush hour\")]/following::select[1]");
  }

  @Override
  public By   IS_THE_VEHICLE_IMPORTED(){
    return By.xpath("//label[contains(text(),\"Is the vehicle imported\")]/following::select[1]");
  }


  @Override
  public By   DO_YOU_HAVE_A_DASHCAM_FITTED_TO_YOUR_CAR(){
    return By.xpath("//label[contains(text(),\"Do you have a dashcam fitted to your car\")]/following::select[1]");
  }

  @Override
  public By   DRIVING_LICENCE_NUMBER(){
    return By.xpath("//label[contains(text(),\"Driving Licence Number\")]/following::input[1]");
  }

  @Override
  public By   PROPERTY_TYPE(){
    return By.xpath("//label[contains(text(),\"Property Type\")]/following::select[1]");
  }

  @Override
  public By SPECIFIED_CONTENT_LIST() {
    return By.xpath("(//select[contains(@name,\"specifiedAllRisks:containedComponent:\")])[2]");
  }

  @Override
  public By PERSONAL_BELONGING_COVER() {
    return By.cssSelector("[name=\"allRisks:allRisksComponent:toggleComponent" +
        ":unspecifiedItemsValue\"]");
  }

  @Override
  public By SPECIFIED_CONTENT_AWAY_FROM_HOME() {
    return By.cssSelector("[name=\"specifiedAllRisks:containedComponent:toggleQuestion\"]");
  }
  //For Van
  @Override
  public By NUMBER_OF_DOORS() {return  By.xpath("//label[contains(text(),\"Number of Doors:\")]/following::input[1]");}

  @Override
  public By PRICE_PAID(){return  By.xpath("//label[contains(text(),\"Price Paid:\")]/following::input[1]");}

  @Override
  public By NUMBER_OF_YEARS_HELD_CONTINUOUSLY(){return  By.xpath("//label[contains(text(), \"Number of Years Held Continuously\")]/following::input[1]");}

  @Override
  public By TYPE_OF_COVER(){return  By.xpath("//label[contains(text(), \"Type of Cover\")]/following::select[1]");}

  @Override
  public By WHAT_IS_ANNUAL_MILEAGE_OF_THE_VEHICLE(){return  By.xpath("//label[contains(text(), \"What is the annual mileage of the vehicle\")]/following::input[1]");}

  @Override
  public By IS_VEHICLE_FITTED_WITH_RACKING(){return  By.xpath("//label[contains(text(),\"Is the vehicle fitted with racking\")]/following::select[1]");}

  @Override
  public By DOES_VICHICLE_HAVE_SIGNAGE(){return  By.xpath("//label[contains(text(),\"Does the vehicle carry signage\")]/following::select[1]");}

  @Override
  public By IS_PROPOSER_A_HOUSE_OWNER(){return  By.xpath("//label[contains(text(),\"Is the proposer a house owner\")]/following::select[1]");}

  @Override
  public By PUBLIC_LIABILITY_IN_FORCE(){return  By.xpath("//label[contains(text(),\"Do you have Public Liability in force\")]/following::select[1]");}

  @Override
  public By IS_POLICY_SOLELY_FOR_SOCIAL_DOMESTIC_AND_PLEASURE_USE(){return  By.xpath("//label[contains(text(),\"Is this policy solely for social domestic and pleasure use\")]/following::select[1]");}

  @Override
  public By WILL_VEHICLE_CARRY_HAZARDOUS_GOODS(){return  By.xpath("//label[contains(text(),\"Will the vehicle carry any hazardous goods\")]/following::select[1]");}


  @Override
  public By  DASHCAM_FITTED_TO_YOUR_VEHICLE(){return  By.xpath("//label[contains(text(),\"Do you have a dashcam fitted to your vehicle\")]/following::select[1]");}

  @Override
  public By WHERE_IS_VEHICLE_KEPT_DURING_THE_DAY(){return  By.xpath("//label[contains(text(),\"Where is the vehicle kept during the day\")]/following::select[1]");}

  @Override
  public By WHERE_IS_VEHICLE_KEPT_OVERNIGHT(){return  By.xpath("//label[contains(text(),\"Where is the vehicle kept overnight\")]/following::select[1]");}


  @Override
  public By HOW_MANY_CHILDREN_OR_DEPENDANTS_UNDER_AGE_OF_16(){return  By.xpath("//label[contains(text(), \"How many children or dependants under the age of 16\")]/following::input[1]");}

  @Override
  public By IS_VEHICLE_DRIVEN_AT_PEAK_TIMES(){return  By.xpath("//label[contains(text(),\"Is the vehicle driven at peak times\")]/following::select[1]");}

  @Override
  public By WHO_OWNS_THE_VEHICLE(){return  By.xpath("//label[contains(text(),\"Who owns the Vehicle\")]/following::select[1]");}

  @Override
  public By LICENSE_NO_DECLARED(){return  By.xpath("//label[contains(text(),\"Licence No. Declared\")]/following::select[1]");}


}

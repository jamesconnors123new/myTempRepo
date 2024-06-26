package PageObjects.PortalVersion.V01;

import PageObjects.PortalModel.PerformMTALocatorModel;
import org.openqa.selenium.By;

public class PerformMTALocatorLib implements PerformMTALocatorModel {

  @Override
  public By EDIT_PERSONAL_DETAILS() {return By.xpath("//a[@href=\"/my_home/change_personal_details\"]");}
  @Override
  public By EDIT_COVER_DETAILS() {return By.xpath("//a[@href=\"/my_home/change_cover\"]");}
  @Override
  public By EDIT_ADDRESS() {return By.xpath("//a[@href=\"/my_home/change_address\"]");}
  @Override
  public By CONFIRM_CONTINUE_BTN() {return By.cssSelector("[data-testid=\"assumptionsConfirmed\"]");}
  @Override
  public By EFFECTIVE_DATE_SELECTION() {return By.name("effectiveDate");}
  @Override
  public By CONTINUE_EFFECTIVE_BTN() {return By.xpath("//*[contains(@data-testid,\"ContinueButton\")]");}
  @Override
  public By CHANGE_POLICY_HOLDER_DETAILS() {return By.xpath("//label[@class='sc-lnrBVv hFWgGf']");}
  @Override
  public By CHANGE_ADDRESS_DETAILS() {return By.xpath("//label[@class='sc-lnrBVv jELXG']");}
  @Override
  public By CHANGE_BED_BATH_NUMBER() {return By.xpath("//label[@class='sc-bsbRJL dTvsXB']");}
  @Override
  public By CHANGE_COVER_DETAILS() {return By.xpath("//label[@class='sc-lnrBVv jELXG']");}
  @Override
  public By CHANGE_JOINT_POLICYHOLDER_DETAILS() {return By.xpath("//label[@class='sc-lnrBVv hFWgGf']");}
  @Override
  public By CHANGE_ADDRESS_EDIT_BUTTON() {return By.xpath("//*[@id='react-tabs-1']/div[1]/div/div[1]/div[2]/div[2]/a/button");}
  @Override
  public By CHANGE_COVER_EDIT_BUTTON() {return By.xpath("//*[@id='react-tabs-1']/div[1]/div/div[2]/div[2]/div[2]/a/button");}
  @Override
  public By CHANGE_PERSONAL_DETAILS_EDIT_BUTTON() {return By.xpath("//*[@id='react-tabs-1']/div[1]/div/div[3]/div[2]/div[2]/a/button");}
  @Override
  public By CONFIRM_AND_CONTINUE_BUTTON() {return By.xpath("//button[text()='Confirm and Continue']");}
  @Override
  public By SELECT_MTA_EFFECTIVE_DATE() {return By.id("effectiveDate");}
  @Override
  public By EDIT_POLICYHOLDER_DETAILS() {return By.xpath("//h1[contains(text(),\"Main Policyholder\")]/following-sibling::a[contains(text(),\"Edit\")][1]");}
  @Override
  public By EDIT_JOINT_POLICYHOLDER_DETAILS() {return By.xpath("//a[contains(@href,'/my_home/edit_joint_policyholder')]");}
  @Override
  public By ADD_JOINT_POLICYHOLDER() {return By.xpath("//a[contains(@href,'/my_home/add_joint_policyholder')]");}
  @Override
  public By CORRESPONDENCE_ADDRESS_SAME_BUTTON() {return By.xpath("//*[@id='correspondenceAddressCheck']/div[2]/label");}
  @Override
  public By SECOND_JOB_YES_BUTTON() {return By.xpath("//*[@id='secondJob']/div[1]/label");}
  @Override
  public By BUSINESS_USE_BUTTON() {return By.xpath("//*[@id='businessUse']/div[1]/label");}
  @Override
  public By STANDARD_CONSTRUCTION_BUTTON() {return By.xpath("//*[@id='homeConstructionType']/div[2]/label");}
  @Override
  public By PREVIOUS_COVER_BUTTON() {return By.xpath("//*[@id='buildingsPreviousInsurance']/div[1]/label");}
  @Override
  public By CONTENTS_COVER_BUTTON() {return By.xpath("//*[@id='contentsPreviousInsurance']/div[1]/label");}
  @Override
  public By EXTRA_COVER_BUTTON() {return By.xpath("//*[@id='personalBelongingsAwayFromHome']/div[1]/label");}
  @Override
  public By POLICYHOLDER_TITLE() {return By.cssSelector("[data-testid=\"titleRadioGroupWrapper\"]");}
  @Override
  public By SUBMIT_EDIT_POLICYHOLDER_BUTTON() {return By.cssSelector("[data-testid=\"addPolicyHolderFormSubmitButton\"]");}
  @Override
  public By CONTINUE_EDIT_BUTTON() {return By.cssSelector("[data-testid=\"continueButton\"]");}
  @Override
  //public By CONTINUE_SUMMARY_CHANGE_BUTTON() {return By.xpath("//*[contains(text(),\"Continue\")]");}
  //public By CONTINUE_SUMMARY_CHANGE_BUTTON() {return By.xpath("//*[contains(text(),\"Confirm your change(s)\")]");}
  public By CONTINUE_SUMMARY_CHANGE_BUTTON() {return By.xpath("//button[text()='Confirm your change(s)']");}
  @Override
  public By PREMIUM_AMOUNT() {return By.cssSelector("[data-testid=\"additionalPaymentHome\"]");}
  @Override
  public By REFUND_AMOUNT() {return By.xpath("//p[@data-testid=\"negativePayment\"]");}
  @Override
  public By HOME_MTA_ELEMENTS() {return By.xpath("//a[contains(@href,\"/my_home/\")]/parent::div/parent::div/child::div[1]");}
  @Override
  public By MOTOR_MTA_ELEMENTS() {return By.xpath("//a[contains(@href,\"/my_car/\")]/parent::div/parent::div/child::div[1]");}
  @Override
  public By COVER_CONTENT_AMOUNT() {return By.xpath("//select[@data-testid=\"contentsSumInsured-dropdown\"]");}
  @Override
  public By BUILDING_ACCIDENTAL_COVER() {return By.xpath("//*[@id=\"buildingsAccidentalDamage\"]/child::div/label[@for=\"buildingsAccidentalDamage-<variable>\"]");}
  @Override
  public By VOLUNTARY_XS_BUILDING() {return By.cssSelector("[data-testid=\"voluntaryXsBuildings\"]");}
  @Override
  public By NEW_ADDRESS_HOUSE_NAME_OR_NUMBER() {return By.cssSelector("[data-testid=\"houseNameOrNumberInput\"]");}
  @Override
  public By NEW_ADDRESS_POSTCODE() {return By.cssSelector("[data-testid=\"postcodeLookup\"]");}
  @Override
  public By FIND_ADDRESS_BUTTON() {return By.xpath("//button[contains(text(),\"Find address\")]");}
  @Override
  public By SELECT_0_14_DAYS_BUTTON() {return By.cssSelector("[data-testid=occupancyDateDaysRadioLabel0]");}
  @Override
  public By SELECT_15_60_DAYS_BUTTON() {return By.cssSelector("[data-testid=\"occupancyDateDaysRadioLabel1\"]");}
  @Override
  public By SELECT_61_DAYS_BUTTON() {return By.cssSelector("[data-testid=\"occupancyDateDaysRadioLabel2\"]");}
  @Override
  public By SELECT_PROPERTY_TYPE_HOUSE() {return By.cssSelector("[data-testid=\"propertyTypeRadioLabel1\"]");}
  @Override
  public By SELECT_HOME_DESCRIPTION() {return By.cssSelector("[data-testid=\"duq_787\"]");}
  @Override
  public By STANDARD_CONSTRUCTION_YES() {return By.cssSelector("[data-testid=\"homeConstructionTypeRadioLabel0\"]");}
  @Override
  public By NUMBER_OF_BEDROOMS() {return By.cssSelector("[data-testid=\"numberOfBedrooms\"]");}
  @Override
  public By NUMBER_OF_BATHS() {return By.cssSelector("[data-testid=\"numberOfBathrooms\"]");}
  @Override
  public By HOME_BUILT_YEAR() {return By.cssSelector("[data-testid=\"homeBuilt-dropdown\"]");}
  @Override
  public By HOME_EXTENDED_NO() {return By.cssSelector("#duq_660 > div:nth-child(2)");}
  @Override
  public By GRADED_BUILDING_NO() {return By.cssSelector("[data-testid=\"listedBuildingOptionsRadioLabel3\"]");}
  //public By GRADED_BUILDING_NO() {return By.cssSelector("[data-testid=\"listedBuildingOptionsRadioButton0\"]");}
  @Override
  public By FLOODING_NO() {return By.cssSelector("[data-testid=\"hasYourHomeFloodedRadioButton1\"]");}
  @Override
  public By WINDOW_AND_DOOR_LOCKS_YES() {return By.cssSelector("[data-testid=\"doorAndWindowLocksRadioLabel0\"]");}

  @Override
  public By INTRUDER_ALARM() {return By.cssSelector("[data-testid=\"intruderAlarm-dropdown\"]");}
  @Override
  public By OWNED_ON_MORTGAGE() {return By.cssSelector("[data-testid=\"duq_791_792RadioLabel1\"]");}
  @Override
  public By HOME_OCCUPIED_DAY_AND_NIGHT() {return By.cssSelector("[data-testid=\"occupancyRadioButton0\"]");}
  @Override
  public By CORRESPONDENCE_ADDRESS_YES() {return By.cssSelector("[data-testid=\"correspondenceAddressCheckRadioButton0\"]");}
  @Override
  public By NUMBER_OF_ADULTS() {return By.cssSelector("[data-testid=\"duq_686\"]");}
  @Override
  public By NUMBER_OF_CHILDREN() {return By.cssSelector("[data-testid=\"duq_685\"]");}
  @Override
  public By PETS() {return By.cssSelector("[data-testid=\"duq_790\"]");}
  @Override
  public By PAYING_GUESTS() {return By.cssSelector("[data-testid=\"duq_400\"]");}
  @Override
  public By BUSINESS_PURPOSE_NO() {return By.cssSelector("[data-testid=\"businessPurposeRadioLabel1\"]");}
  @Override
  public By PAST_CONTENTS_COVER() {return By.xpath("//label[@for=\"contentsPreviousInsurance-<variable>\"]//parent::div");}
  @Override
  public By CLAIM_FREE_YEARS() {return By.cssSelector("[data-testid=\"claimFreeYears-dropdown\"]");}
  @Override
  public By CONTENT_COVER_AMOUNT() {return By.cssSelector("[data-testid=\"contentsSumInsured-dropdown\"]");}
  @Override
  public By VOLUNTARY_XS_CONTENT() {return By.cssSelector("[data-testid=\"voluntaryXsContents\"]");}
  @Override
  public By CONTENT_ACCIDENTAL_COVER() {return By.xpath("//label[@for=\"contentsAccidentalDamage-<variable>\"]//parent::div");}
  @Override
  public By PERSONAL_BELONGING_AWAY_FROM_HOME() {return By.xpath("//label[@for=\"personalBelongingsAwayFromHome-yes\"]//parent::div");}
  @Override
  public By PERSONAL_BELONGING_AWAY_FROM_HOME_COVER_AMOUNT() {return By.cssSelector("[data-testid=\"personalBelongingsSumInsured-dropdown\"]");}

  //OPEX Locators
  @Override
  public By EMC_MORE_BUTTON() {return By.xpath("//button[text()=\"Find out more\"]");}
  @Override
  public By EMC_ADDED_SECTION_EXCESS_PROTECTION() {return By.xpath("//p[text()='Added']/following::p[text()='Excess Protection']");}
  @Override
  public By EMC_NOT_ADDED_SECTION_LEGAL_EXPENSES() {return By.xpath("//p[text()='Not added']/following::p[text()='Legal Expenses']");}
  @Override
  public By EMC_NOT_ADDED_SECTION_EXTRA_HOME_EMERGENCY() {return By.xpath("//p[text()='Not added']/following::p[text()='Ageas Extra Home Emergency']");}
  @Override
  public By EMC_EFFECTIVE_DATE() {return By.xpath("//select[@data-testid='effectiveDate-dropdown']");}
  @Override
  public By EMC_LEGAL_EXPENSES_YES() {return By.xpath("(//h1[text()='Legal Expenses']//following::input[@value='Y']/following::label[text()='Yes'])[1]");}
  @Override
  public By EMC_LEGAL_EXPENSES_NO() {return By.xpath("(//h1[text()='Legal Expenses']//following::input[@value='Y']/following::label[text()='No'])[1]");}
  @Override
  public By EMC_ADD_LEGAL_EXPENSES() {return By.xpath("(//h1[text()='Legal Expenses']//following::button[text()='Add'])[1]");}
  @Override
  public By EMC_EXTRA_HOME_EMERGENCY_NO() {return By.xpath("(//h1[text()='Ageas Extra Home Emergency']//following::input[@value='N']/following::label[text()='No'])[1]");}
  @Override
  public By EMC_ADD_EXTRA_HOME_EMERGENCY() {return By.xpath("(//h1[text()='Ageas Extra Home Emergency']//following::button[text()='Add'])[1]");}
  @Override
  public By EMC_EXTRA_HOME_EMERGENCY_YES() {return By.xpath("(//h1[text()='Ageas Extra Home Emergency']//following::input[@value='Y']/following::label[text()='Yes'])[1]");}
  @Override
  public By EMC_EXCESS_PROTECTION_NO() {return By.xpath("(//h1[text()='Excess Protection']//following::input[@value='N']/following::label[text()='No'])[1]");}
  @Override
  public By EMC_EXCESS_PROTECTION_YES() {return By.xpath("(//h1[text()='Excess Protection']//following::input[@value='Y']/following::label[text()='Yes'])[1]");}
  @Override
  public By EMC_ADD_EXCESS_PROTECTION() {return  By.xpath("(//h1[text()='Excess Protection']//following::button[text()='Add'])[1]");}
  @Override
  public By EMC_CONTINUE_BUTTON() {return By.xpath("//button[text()=\"Continue\"]");}
  @Override
  public By EMCS_SAVE_BUTTON() {return By.xpath("//button[text()=\"Save\"]");}
  @Override
  public By EMC_OPEX_MTA_PREMIUM() {return By.xpath("(//p[@data-testid='additionalPaymentHome']//following::strong)[1]");}


  //Insured Property Details
  @Override
  public By IPD_NUMBER_OF_BEDROOMS() {return By.xpath("//select[@data-testid='numberOfBedrooms']");}
  @Override
  public By IPD_NUMBER_OF_BATHROOMS() {return By.xpath("//select[@data-testid='numberOfBathrooms']");}
  @Override
  public By IPD_NUMBER_OF_ADULTS_AT_PROPERTY() {return By.xpath("//select[@data-testid='duq_686']");}
  @Override
  public By IPD_NUMBER_OF_CHILDREN_AT_PROPERTY() {return By.xpath("//select[@data-testid='duq_685']");}
  @Override
  public By IPD_OWNER_RENT_STATUS_OWNED_ON_MORTGAGE() {return By.xpath("//label[text()=\"Owned on Mortgage\"]");}
  @Override
  public By IPD_OWNER_RENT_STATUS_PRIVATELY_RENTED() {return By.xpath("//label[text()=\"Privately Rented\"]");}
  @Override
  public By  IPD_OWNER_RENT_STATUS_OWNED_OUTRIGHT() {return By.xpath("//label[text()=\"Owned Outright\"]");}
  @Override
  public By  IPD_OWNER_RENT_STATUS_COUNCIL_RENTED() {return By.xpath("//label[text()=\"Council Rented\"]");}
  @Override
  public By  IPD_OWNER_RENT_STATUS_HOUSING_ASSOCIATION() {return By.xpath("//label[text()=\"Housing Association\"]");}
  @Override
  public By EDIT_INSURED_PROPERTY_ADDRESS() {return By.xpath("(//h1[text()='Insured Address']//following::a[text()='Edit'])[1]");}
  @Override
  public By IPD_SAVE_BUTTON() {return By.xpath("//button[text()=\"Save\"]");}
  @Override
  public By IPD_CONTINUE_BUTTON() {return By.xpath("//button[text()=\"Continue\"]");}
  @Override
  public By IPD_MTA_PREMIUM() {return By.xpath("(//p[@data-testid='additionalPaymentHome' or @data-testid='negativePayment']//following::strong)[1]");}
  @Override
  public By IPD_HOME_EXTENDED_NO() {return By.xpath("//label[@data-testid='duq_660RadioLabel1']");}
  @Override
  public By IPD_HOME_EXTENDED_YES() {return By.xpath("//label[@data-testid='duq_660RadioLabel0']");}
  @Override
  public By IPD_HOME_LISTED_BUILDING_NO() {return By.xpath("//label[@data-testid='listedBuildingOptionsRadioLabel0']");}
  @Override
  public By IPD_HOME_LISTED_BUILDING_GRADE1() {return By.xpath("//label[@data-testid='listedBuildingOptionsRadioLabel1']");}
  @Override
  public By IPD_HOME_LISTED_BUILDING_GRADE2() {return By.xpath("//label[@data-testid='listedBuildingOptionsRadioLabel2']");}
  @Override
  public By IPD_HOME_LISTED_BUILDING_GRADE22() {return By.xpath("//label[@data-testid='listedBuildingOptionsRadioLabel3']");}
  @Override
  public By IPD_WHEN_IS_YOUR_HOME_OCCUPIED_DAYANDNIGHT() {return By.xpath("//label[@data-testid='occupancyRadioLabel0']");}
  @Override
  public By IPD_WHEN_IS_YOUR_HOME_OCCUPIED_DURINGTHEDAY() {return By.xpath("//label[@data-testid='occupancyRadioLabel1']");}
  @Override
  public By IPD_WHEN_IS_YOUR_HOME_OCCUPIED_DURINGTHENIGHT() {return By.xpath("//label[@data-testid='occupancyRadioLabel2']");}
  @Override
  public By IPD_WHEN_IS_YOUR_HOME_OCCUPIED_UNOCCUPIED() {return By.xpath("//label[@data-testid='occupancyRadioLabel3']");}
  @Override
  public By IPD_PROPERTY_TYPE_BUNGALOW() {return By.xpath("//label[@data-testid='propertyTypeRadioLabel0']");}
  @Override
  public By IPD_PROPERTY_TYPE_HOUSE() {return By.xpath("//label[@data-testid='propertyTypeRadioLabel1']");}
  @Override
  public By IPD_PROPERTY_TYPE_TOWNHOUSE() {return By.xpath("//label[@data-testid='propertyTypeRadioLabel2']");}
  @Override
  public By IPD_PROPERTY_TYPE_SELFCONTAINEDFLAT() {return By.xpath("//label[@data-testid='propertyTypeRadioLabel3']");}
  @Override
  public By IPD_PROPERTY_TYPE_MAISONETTE() {return By.xpath("//label[@data-testid='propertyTypeRadioLabel4']");}
  @Override
  public By IPD_HOME_FITTED_WITH_DEAD_LOCKS_NO() {return By.xpath("//label[@data-testid='doorAndWindowLocksRadioLabel1']");}
  @Override
  public By IPD_HOME_FITTED_WITH_DEAD_LOCKS_YES() {return By.xpath("//label[@data-testid='doorAndWindowLocksRadioLabel0']");}
  @Override
  public By IPD_WHAT_BEST_DESCRIBES_YOUR_HOME() {return By.xpath("//select[@data-testid='duq_787']");}
  @Override
  public By IPD_INTRUDER_ALARM() {return By.xpath("//select[@data-testid='intruderAlarm-dropdown']");}
  @Override
  public By IPD_STANDARD_CONSTRUCTION_YES() {return By.xpath("//label[@data-testid='homeConstructionTypeRadioLabel0']");}
  @Override
  public By IPD_STANDARD_CONSTRUCTION_NO() {return By.xpath("//label[@data-testid='homeConstructionTypeRadioLabel1']");}
  @Override
  public By IPD_PETS_AT_PROPERTY() {return By.xpath("//select[@data-testid='duq_790']");}
  @Override
  public By IPD_DO_YOU_HAVE_ANY_PAYING_GUESTS() {return By.xpath("//select[@data-testid='duq_400']");}
  @Override
  public By  IPD_USED_FOR_BUSINESS_NO() {return By.xpath("//label[@data-testid='businessPurposeRadioLabel1']");}
  @Override
  public By  IPD_USED_FOR_BUSINESS_YES() {return By.xpath("//label[@data-testid='businessPurposeRadioLabel0']");}
}

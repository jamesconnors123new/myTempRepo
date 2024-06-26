package PageObjects.PortalVersion.V01;

import PageObjects.PortalModel.PortalQuoteCreationLocatorModel;
import org.openqa.selenium.By;

public class PortalQuoteCreationLocatorLib implements PortalQuoteCreationLocatorModel {
  @Override
  public By CONTINUE_BUTTON() { return By.xpath("//button[normalize-space(text())" +
      "=\"Continue\"]");}
  @Override
  public By PAY_BUTTON() { return By.xpath("//button[text()=\"Pay\"]");}
  public By BUILDING_AND_CONTENT() { return By.cssSelector("label[for=\"coverType-buildings-and-contents\"]");}
  @Override
  public By POLICY_SECTION() { return By.xpath("//label[text()=\"<variable>\"]");}
  @Override
  public By BUILDING_ONLY() { return By.xpath("//label[@for=\"coverType-buildings-only\"]");}
  @Override
  public By CONTENTS_ONLY() { return By.xpath("//label[@for=\"coverType-contents-only\"]");}
  @Override
  public By HOUSE_NUM() { return By.xpath("//input[contains(@id,\"_houseNameOrNumber\")]");}
  @Override
  public By POST_CODE() { return By.xpath("//input[contains(@name,\"address_postCode\")]");}
  public By ADDRESS_LIST() { return By.cssSelector("select[name=\"postcodeLookupResultsDropdown\"]");}
  @Override
  public By FIND_ADDRESS_BTN() { return By.xpath("//button[text() =\"Find Address\"]");}
  @Override
  public By FIND_ADDRESS() { return By.xpath("//button[@data-testid=\"buttonTestId\" and text() =\"Find Address\"]");}
  @Override
  public By COMPLETE_ADDRESS() { return By.cssSelector("[data-test-id=\"addressDetailsCurrentAddress\"]");}
  @Override
  public By BEST_DESC_HOME() { return By.xpath("//div[contains(text(),\"describes your home?\")]/following::select[1]");}
  @Override
  public By PROPER_TYPE_BUNGLOW() { return By.cssSelector("[for=\"propertyType-Bungalow\"]");}
  @Override
  public By PROPER_TYPE_HOUSE() { return By.cssSelector("[for=\"propertyType-House\"]");}
  @Override
  public By PROPER_TYPE_TOWN_HOUSE() { return By.cssSelector("[for=\"propertyType-Town House\"]");}
  @Override
  public By PROPER_TYPE_SELF_CONTAINED_FLAT() { return By.cssSelector("[for=\"propertyType-Self-contained flat\"]");}
  @Override
  public By PROPER_TYPE_MAISONETTE() { return By.cssSelector("[for=\"propertyType-Maisonette\"]");}
  @Override
  public By HOUSE_DESCRIBE() { return By.xpath("//div[text()=\"What best describes your home?\"]/following::select[1]");}
  @Override
  public By BUILT_STANDARD_CONSTRUCTION_NO() { return By.cssSelector("[for=\"risk_property_construction-OtherCons\"]");}
  @Override
  public By BUILT_STANDARD_CONSTRUCTION_YES() { return By.cssSelector("[for=\"risk_property_construction-Standard\"]");}
  @Override
  public By EXTERNAL_WALLS_MADE_OF() { return By.xpath("//div[contains(text(), \"external walls made\")]/following::select[1]");}
  @Override
  public By ROOF_MADE_OF() { return By.xpath("//div[contains(text(), \"roof made\")]/following::select[1]");}
  @Override
  //Approximately what percentage of your roof is flat?
  public By OPTION1() { return By.xpath("//label[text()= \"0% to 33%\"]");}
  @Override
  public By OPTION2() { return By.xpath("//label[text()= \"34% to 50%\"]");}
  @Override
  public By OPTION3() { return By.xpath("//label[text()= \"50%+\"]");}
  @Override
  //How many bedrooms and bathrooms does your home have? // Select from list
  public By NUMBER_OF_BEDROOM() { return By.cssSelector("[name=\"risk_property_bedrooms\"]");}
  @Override
  public By NUMBER_OF_BATHROOMS() { return By.cssSelector("select[name=\"numberOfBathrooms\"]");}
  @Override
  //When was your home built?
  public By HOUSE_BUILT_YEAR() { return By.cssSelector("[id=\"risk_property_yearBuilt\"]");}
  @Override
  //Is your home a listed building?
  public By HOME_EXTENDED_YES() { return By.xpath("(//div[text()=\"Has your home been extended?\"]/following::label[text()=\"Yes\"])[1]");}
  @Override
  public By HOME_EXTENDED_NO() { return By.xpath("(//div[text()=\"Has your home been extended?\"]/following::label[text()=\"No\"])[1]");}
  @Override

  public By GRADE1() { return By.cssSelector("label[for=\"risk_property_listed_english-English1\"]");}
  @Override
  public By GRADE2() { return By.xpath("//input[@value=\"English2\"]/following::label[1]");}
  @Override
  public By GRADE2_STAR() { return By.xpath("//input[@value=\"English2*\"]/following::label[1]");}
  @Override
  public By NO_GRADE() { return By.xpath("//input[@value=\"NoGrade\" or @id=\"risk_property_listed_english-03\"]/following::label[1]");}
  @Override
  //Has your home flooded at any time in the last 25 years?
  public By FLOODED_YES() { return By.xpath("//div[contains(@data-testid,\"risk_property_freeFromFloodingRadioButton\")]/following::label[text()=\"Yes\"]");}
  @Override
  public By FLOODED_NO() { return By.xpath("//label[@data-testid=\"risk_property_freeFromFloodingRadioLabel1\" and text()=\"No\"]");}
  @Override

  //Is your home fitted with five-lever mortice deadlocks or a multi-point locking system
  // on all external doors, and key-operated window locks on all ground-level windows and
  // accessible upper floor windows?
  public By MULTI_LOCK_SYSTEM_YES() { return By.cssSelector("[for=\"risk_property_doorAndWindowLocks-true\"]");}
  @Override
  public By MULTI_LOCK_SYSTEM_NO() { return By.cssSelector("[for=\"risk_property_doorAndWindowLocks-false\"]");}
  @Override


  //Is an intruder alarm installed?
  public By INTRUDER_ALARM() { return By.cssSelector("select[name=\"risk_property_alarm\"]");}
  @Override

  //Do you own or rent your home?
  public By OWNED_OUTRIGHT() { return By.xpath("//label[normalize-space(text())=\"Owned Outright\"]");}
  @Override
  public By OWNED_ON_MORTGAGE() { return By.xpath("//label[normalize-space(text())=\"Owned on Mortgage\"]");}
  @Override
  public By PRIVATELY_RENTED() { return By.xpath("//label[normalize-space(text())=\"Privately Rented\"]");}
  @Override
  public By COUNCIL_RENTED() { return By.xpath("//label[normalize-space(text())=\"Council Rented\"]");}
  @Override
  public By HOUSING_ASSOCIATION() { return By.xpath("//label[normalize-space(text())=\"Housing Association\"]");}
  @Override

  //Is your home furnished?
  public By FURNISHED_QUESTION() { return By.xpath("//div[text()=\"Is your home furnished?\"]");}
  @Override
  public By FURNISHED() { return By.xpath("//div[normalize-space(text())=\"Is your home furnished?\"]/following::label[text()=\"Yes\"]");}
  @Override
  public By UNFURNISHED() { return By.xpath("//div[normalize-space(text())=\"Is your home furnished?\"]/following::label[text()=\"No\"]");}
  @Override
  //When do you want your cover to start?
  public By COVER_START_DATE() { return By.cssSelector("[name=\"risk_startDate\"]");}
  @Override
  //How do you usually pay for your insurance?
  public By ANNUALLY() { return By.xpath("//label[text()= \"Annually\"]");}
  @Override
  public By MONTHLY() { return By.xpath("//label[text()= \"Monthly\"]");}
  @Override
  //When is your home normally occupied?
  public By DAY_AND_NIGHT() { return By.xpath("//label[text()=\"Day and night\"]");}
  @Override
  public By DURING_THE_DAY() { return By.xpath("//label[text()=\"During the day\"]");}
  @Override
  public By DURING_THE_NIGHT() { return By.xpath("//label[text()=\"During the night\"]");}
  @Override
  public By UNOCCUPIED() { return By.xpath("//label[text()=\"Unoccupied\"]");}
  @Override
  // Contents cover
  //Have you held Contents Insurance within the last 2 years?
  public By HELD_CONTENTS_INSURANCE_YES() { return By.xpath("//div[contains(@data-testid,\"contentInsuranceRadioButton\")]//label[text()=\"Yes\"]");}
  @Override
  public By HELD_CONTENTS_INSURANCE_NO() { return By.xpath("//div[contains(@data-testid,\"contentInsuranceRadioButton\")]//label[text()=\"No\"]");}
  @Override
  public By CLAIM_FREE_YEARS_CONTENT_BUILDING() { return By.xpath("(//select[contains(@id,\"NcbYears\")])[last()]");}
  @Override

  //How much would it cost to replace the entire contents of your home as new?
  public By COST_REPLACE_ENTIRE_CONTENTS() { return By.cssSelector("[name=\"risk_contents_sumInsured\"]");}
  @Override

  public By HELD_BUILDING_INSURANCE_YES() { return By.cssSelector("[for=\"buildingInsurance-true\"]");}
  @Override
  public By HELD_BUILDING_INSURANCE_NO() { return By.cssSelector("[for=\"buildingInsurance-false\"]");}
  @Override

  //Would you like accidental damage cover?

  public By CONTENTS_ACCIDENTAL_DAMAGE_COVER_YES() { return By.cssSelector("[for=\"risk_contents_accidentalDamage-true\"]");}
  @Override
  public By CONTENTS_ACCIDENTAL_DAMAGE_COVER_NO() { return By.cssSelector("[for=\"risk_contents_accidentalDamage-false\"]");}
  @Override
  public By VALUABLE_ITEMS_OVER_2000£_YES() { return By.cssSelector("[for=\"hasHighRiskItemsCover-true\"]");}
  @Override
  public By VALUABLE_ITEMS_OVER_2000£_NO() { return By.cssSelector("[for=\"hasHighRiskItemsCover-false\"]");}
  @Override
  public By VALUABLE_ITEMS_CATEGORY() { return By.xpath("//div[text()=\"Category\"]/following::select[1]");}
  @Override
  public By VALUABLE_ITEMS_DESCRIPTION() { return By.xpath("//div[text()=\"Description\"]/following::textarea");}
  @Override
  public By VALUABLE_ITEMS_COST() { return By.xpath("//div[contains(text(),\"estimated cost\")]/following::input[1]");}
  @Override
  public By CANCEL_BUTTON() { return By.cssSelector("[data-testid=\"closeHighRiskItemButton\"]");}
  @Override
  public By SAVE_BUTTON() { return By.xpath("//button[text()=\"Save\"]");}
  @Override
  public By ADD_ANOTHER_ITEM() { return By.xpath("(//button[text()=\"Add another item\"])[last()]");}

  @Override
  public By ITEM_EDIT_BUTTON() { return By.xpath("(//a[text()=\"Edit\"])[last()]"); }

  @Override
  public By ITEM_DELETE_BUTTON() { return By.xpath("(//a[text()=\"Delete\"])[last()]"); }

  @Override
  public By ADD_CLAIM() { return By.cssSelector("[data-testid=\"submitClaimButton\"]");}
  @Override
  public By ADD_NEW_CLAIM() { return By.xpath("//a[text()=\"Add new claim\"]");}
  @Override


  //Would you like extra cover for personal belongings away from the home?
  public By EXTRA_COVER_FOR_BELONGINGS_YES() { return By.cssSelector("[for=\"personalBelongingsAwayFromHome-true\"]");}
  @Override
  public By EXTRA_COVER_FOR_BELONGINGS_NO() { return By.cssSelector("[for=\"personalBelongingsAwayFromHome-false\"]");}
  @Override

  //How much cover would you like for personal belongings away from the home?
  public By COVER_COST_FOR_BELONGINGS() { return By.cssSelector("#risk_allRisks_unspecifiedSumInsured");}
  @Override

  public By INDIVIDUAL_ITEM_COVER_YES() { return By.cssSelector("[for=\"hasItemsCover-true\"]");}
  @Override
  public By INDIVIDUAL_ITEM_COVER_NO() { return By.cssSelector("[for=\"hasItemsCover-false\"]");}
  @Override
  public By BUILDING_ACCIDENTAL_DAMAGE_COVER_NEEDED_YES() { return By.cssSelector("[for=\"risk_buildings_accidentalDamage-true\"]");}
  @Override
  public By BUILDING_ACCIDENTAL_DAMAGE_COVER_NEEDED_NO() { return By.cssSelector("[for=\"risk_buildings_accidentalDamage-false\"]");}
  @Override

  //Tell us About Yourself
  public By TITLE() { return By.xpath("(//label[contains(@for,\"name_title-<variable>\")])[last()] | (//input[@name='risk_proposer_name_title']//following::label[text()=\"<variable>\"])[last()]");}
  public By GENDER() { return By.xpath("(//label[contains(@for,\"proposer_gender-<variable>\")])[last()]");}
  @Override
  public By POLICYHOLDER_TITLE() { return By.xpath("(//label[@for=\"title-<variable>\"])[last()]");}
  @Override
  public By TITLE_ADDITIONAL_POLICY_HOLDER() { return By.xpath("//label[@for=\"risk_additionalInsuredSet_additionalInsured_name_title-<variable>\"]");}
  @Override

  public By FIRST_NAME() { return By.xpath("(//input[contains(@id,\"name_forenames\")])[last()]");}
  @Override
  public By LAST_NAME() { return By.xpath("(//input[contains(@id,\"name_surname\")])[last()]");}
  @Override
  public By EMAIL() { return By.cssSelector("#risk_proposer_email");}
  @Override
  public By PREFERRED_PHONE_NUM() { return By.cssSelector("[name=\"risk_proposer_telephoneNumbers_telephone_phoneNumber\"]");}
  @Override
  public By CORRESPONDENCE_ADDRESS() { return By.xpath("//label[@for=\"correspondenceAddressCheck-<variable>\"]");}
  @Override
  public By BIRTH_DATE() { return By.xpath("(//input[contains(@id,\"_dateOfBirthday\")])[last()]");}
  @Override
  public By BIRTH_MONTH() { return By.xpath("(//input[contains(@id,\"_dateOfBirthmonth\")])[last()]");}
  @Override
  public By BIRTH_YEAR() { return By.xpath("(//input[contains(@id,\"_dateOfBirthyear\")])[last()]");}
  @Override
  //public By MARITAL_STATUS() { return By.xpath("(//label[contains(text(),\"<variable>\")])[last()]");}
  public By MARITAL_STATUS() { return By.cssSelector("select#risk_proposer_maritalStatus");}
  @Override
  public By JOINT_HOLDER_MARITAL_STATUS() { return By.cssSelector("select#risk_additionalInsuredSet_additionalInsured_maritalStatus");}
  @Override
  public By RELATIONSHIP_WITH_YOU() { return By.cssSelector("#risk_additionalInsuredSet_additionalInsured_relationshipToProposer");}
  @Override
  public By EMPLOYMENT_STATUS() { return By.xpath("(//select[contains(@name,\"fullTimeOccupation_type\")])[last()]");}
  @Override
  public By JOB_TYPE() { return By.xpath("(//input[contains(@name,\"Occupation_occCode\")])[last()]");}
  @Override
  public By JOB_INDUSTRY() { return By.xpath("(//input[contains(@name,\"Occupation_empCode\")])[last()]");}
  @Override
  public By JOB_TYPE_SUGGESTION() { return By.cssSelector("[data-testid=\"suggestion-0\"]");}
  @Override
  public By STUDENT_JOB_TYPE() { return By.cssSelector("[name=\"fullTimeOccupationStudent\"]");}
  public By SECOND_JOB_EMPLOYMENT_STATUS() { return By.xpath("(//select[contains(@name,\"Occupation_type\")])[last()]");}
  @Override
  public By SECOND_JOB() { return By.xpath("(//label[contains(@for,\"PartTimeOccupation-false\")])[last()]");}
  @Override
  public By JOINT_POLICY_HOLDER() { return By.xpath("//label[@for=\"hasAdditionalInsuredJoint-<variable>\"]");}
  @Override

  public By ADULT_COUNT() { return By.xpath("//div[contains(text(),\"adults live\")]/following::select[1]");}
  @Override

  public By CHILD_COUNT() { return By.xpath("//div[contains(text(),\"children live\")]/following::select[1]");}
  @Override
  public By PETS_LIVING() { return By.xpath("(//div[contains(text(),\"pets living\")]/following::select[1])[1]");}
  @Override
  public By PAYING_GUEST_LIVING() { return By.xpath("(//div[contains(text(),\"paying guests living\")]/following::select[1])[1]");}
  @Override
  public By HOME_USED() { return By.xpath("//label[@for=\"risk_property_businessUse-<variable>\"]");}
  @Override
  public By CLERICAL_BUSINESS_USE_YES() { return By.xpath("(//div[contains(text(),\"clerical business\")]/following::label[text()=\"Yes\"])[2]");}
  @Override
  public By CLERICAL_BUSINESS_USE_NO() { return By.xpath("(//div[contains(text(),\"clerical business\")]/following::label[text()=\"No\"])[2]");}
  @Override
  public By SUFFERED_LOSS_YES() { return By.xpath("//div[contains(text(),\"USUALLY living with you suffered losses\")]/following::label[1]");}
  @Override
  public By SUFFERED_LOSS_NO() { return By.xpath("//div[contains(text(),\"USUALLY living with you suffered losses\")]/following::label[2]");}
  @Override
  public By INSURANCE_RENEWAL() { return By.cssSelector("select#carRenewalMonth");}
  @Override
  public By CLAIM_LAST_FIVE_YEARS() { return By.xpath("//label[@for=\"hasClaims-<variable>\"]");}
  @Override
  public By CLAIM_DESC() { return By.cssSelector("#claimDescription");}
  @Override
  public By VALUE_CLAIM() { return By.cssSelector("#claimValue");}
  @Override
  public By MONTH_INCIDENT() { return By.cssSelector("[name=\"dateOfIncidentmonth\"]");}
  @Override
  public By YEAR_INCIDENT() { return By.cssSelector("[name=\"dateOfIncidentyear\"]");}
  @Override
  public By CONTACT_EMAIL_PREFERENCE() { return By.xpath("(//input[@id=\"switch\"]/following-sibling::label)[1]");}
  @Override
  public By CONTACT_TEXT_PREFERENCE() { return By.xpath("(//input[@id=\"switch\"]/following-sibling::label)[2]");}
  @Override
  public By CONTACT_POST_PREFERENCE() { return By.xpath("(//input[@id=\"switch\"]/following-sibling::label)[3]");}
  @Override
  public By CONTACT_PHONE_PREFERENCE() { return By.xpath("(//input[@id=\"switch\"]/following-sibling::label)[4]");}
  @Override
  public By CAR_INSURANCE() { return By.cssSelector("#carRenewalMonth");}
  @Override
  public By LEGAL_COST() { return By.xpath("//label[@for=\"legalOpexQuestion-<variable>\"]");}
  @Override
  public By LEGAL_COST_ADD_BTN() { return By.xpath("(//button[@data-testid=\"toggleOpexItemBtn\"])[1]");}
  @Override
  public By RECALCULATE_SCREEN_MSG() { return By.xpath("(//*[text()='Recalculating']");}
  @Override
  public By HOME_EMERGENCY() { return By.xpath("//label[@for=\"extraHomeOpexQuestion-<variable>\"]");}
  @Override
  public By HOME_EMERGENCY_ADD_BTN() { return By.xpath("(//button[@data-testid=\"toggleOpexItemBtn\"])[2]");}
  @Override
  public By EXCESS_PROTECTION() { return By.xpath("//label[@for=\"excessOpexQuestion-<variable>\"]");}
  @Override
  public By AGREED_AND_PROCEED() { return By.cssSelector("[data-testid=\"quoteSubmit\"]");}
  @Override
  public By QUOTE_REFERENCE_NUMBER() { return By.xpath("(//h1[text()=\"Quote reference\"]/following::div/h1)[1]");}
  @Override
  public By ANNUAL_PAYMENT_VALUE() { return By.xpath("//h1[normalize-space()=\"Total Annual Payment\"]/following-sibling::h1");}
  @Override
  public By MONTHLY_PAYMENT_VALUE() { return By.xpath("(//span[@data-testid='instalments-Summary']/preceding-sibling::span)[1]");}
  @Override
  public By EXTRA_HOME_COVER_VALUE() { return By.xpath("//h1[normalize-space()=\"Ageas Extra Home Insurance\"]/following-sibling::h1");}
  @Override
  public By BUILDING_EXCESS_COMPULSORY() { return By.xpath("(//h4[text()='Compulsory'])[1]/following-sibling::span");}
  @Override
  public By CONTENT_EXCESS_COMPULSORY() { return By.xpath("(//h4[text()='Compulsory'])[2]/following-sibling::span");}
  @Override
  public By PERSONAL_DETAILS_CONFIRMATION_MESSAGE() { return By.cssSelector("[data-testid=\"generic-personalDetail-change\"]");}
  @Override
  public By ZERO_PREMIUM() { return By.cssSelector("[data-testid=\"zeroPayment\"]");}
  @Override
  public By POLICY_NUMBER() { return By.cssSelector("[data-testid=\"policyNumberDisplay\"]");}
  @Override
  public By CHANGE_TEXT() { return By.cssSelector("[data-testid=\"changePanelText\"]");}
  @Override
  public By EFFECTIVE_DATE() { return By.xpath("(//p[text()=\"Changes effective date\"]/following::p)[1]/span/span");}
  @Override
  public By QUOTE_REFERENCE_INPUT() { return By.cssSelector("input#quoteReference");}
  @Override
  public By QUOTE_REFERENCE_TEXT() { return By.xpath("//h1[text()='Quote reference']//following::h1[@data-testid='titleTestId']");}
  @Override
  public By YOUR_POSTCODE_INPUT() { return By.cssSelector("input#postcode");}
  @Override
  public By PROPERTY_POSTCODE_EDIT() { return By.xpath("//button[@data-testid='editMyAddress']/preceding::p[1]");}
  @Override
  public By YOUR_DOB_DAY() { return By.cssSelector("input#risk_proposer_dateOfBirthday");}
  @Override
  public By YOUR_DOB_MONTH() { return By.cssSelector("input#risk_proposer_dateOfBirthmonth");}
  @Override
  public By YOUR_DOB_YEAR() { return By.cssSelector("input#risk_proposer_dateOfBirthyear");}
  @Override
  public By RETRIEVE_QUOTE_BTN() { return By.xpath("//button[text()=\"Retrieve Quote\"]");}
  public By BACK_BTN() { return By.xpath("//button[text()=\"Back\"]");}
  @Override
  public By PROPERTY_EDIT_BTN() { return By.xpath("//button[@data-testid='editMyAddress']");}
  @Override
  public By POSTCODE_LOOKUP_ADDRESS_LINK() { return By.xpath("//a[text()='Click here to try the post code lookup again']"); }

}

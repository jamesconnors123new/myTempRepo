package PageObjects.PortalModel;

import org.openqa.selenium.By;

public interface PortalQuoteCreationLocatorModel {

  public By CONTINUE_BUTTON();
  public By PAY_BUTTON();
  public By BUILDING_AND_CONTENT ();
  public By POLICY_SECTION ();
  public By BUILDING_ONLY ();
  public By CONTENTS_ONLY ();
  public By HOUSE_NUM ();
  public By POST_CODE ();
  public By ADDRESS_LIST ();
  public By FIND_ADDRESS_BTN ();
  public By FIND_ADDRESS ();
  public By COMPLETE_ADDRESS ();
  public By BEST_DESC_HOME ();
  public By PROPER_TYPE_BUNGLOW ();
  public By PROPER_TYPE_HOUSE ();
  public By PROPER_TYPE_TOWN_HOUSE ();
  public By PROPER_TYPE_SELF_CONTAINED_FLAT ();
  public By PROPER_TYPE_MAISONETTE ();
  public By HOUSE_DESCRIBE ();
  public By BUILT_STANDARD_CONSTRUCTION_NO ();
  public By BUILT_STANDARD_CONSTRUCTION_YES ();
  public By EXTERNAL_WALLS_MADE_OF ();
  public By ROOF_MADE_OF ();
  //Approximately what percentage of your roof is flat?
  public By OPTION1 ();
  public By OPTION2 ();
  public By OPTION3 ();
  //How many bedrooms and bathrooms does your home have?
  public By NUMBER_OF_BEDROOM ();
  public By NUMBER_OF_BATHROOMS ();
  //When was your home built?
  public By HOUSE_BUILT_YEAR ();
  //Is your home a listed building?
  public By HOME_EXTENDED_YES ();
  public By HOME_EXTENDED_NO ();

  public By GRADE1 ();
  public By GRADE2 ();
  public By GRADE2_STAR ();
  public By NO_GRADE ();
  //Has your home flooded at any time in the last 25 years?
  public By FLOODED_YES ();
  public By FLOODED_NO ();

  //Is your home fitted with five-lever mortice deadlocks or a multi-point locking system
  // on all external doors, and key-operated window locks on all ground-level windows and
  // accessible upper floor windows?
  public By MULTI_LOCK_SYSTEM_YES ();
  public By MULTI_LOCK_SYSTEM_NO ();


  //Is an intruder alarm installed?
  public By INTRUDER_ALARM ();

  //Do you own or rent your home?
  public By OWNED_OUTRIGHT ();
  public By OWNED_ON_MORTGAGE ();
  public By PRIVATELY_RENTED ();
  public By COUNCIL_RENTED ();
  public By HOUSING_ASSOCIATION ();

  //Is your home furnished?
  public By FURNISHED_QUESTION ();
  public By FURNISHED ();
  public By UNFURNISHED ();

  //When do you want your cover to start?
  public By COVER_START_DATE ();
  //How do you usually pay for your insurance?
  public By ANNUALLY ();
  public By MONTHLY ();
  //When is your home normally occupied?
  public By DAY_AND_NIGHT ();
  public By DURING_THE_DAY ();
  public By DURING_THE_NIGHT ();
  public By UNOCCUPIED ();
  // Contents cover
  //Have you held Contents Insurance within the last 2 years?
  public By HELD_CONTENTS_INSURANCE_YES ();
  public By HELD_CONTENTS_INSURANCE_NO ();
  public By CLAIM_FREE_YEARS_CONTENT_BUILDING ();

  //How much would it cost to replace the entire contents of your home as new?
  public By COST_REPLACE_ENTIRE_CONTENTS ();

  public By HELD_BUILDING_INSURANCE_YES ();
  public By HELD_BUILDING_INSURANCE_NO ();

  //Would you like accidental damage cover?

  public By CONTENTS_ACCIDENTAL_DAMAGE_COVER_YES ();
  public By CONTENTS_ACCIDENTAL_DAMAGE_COVER_NO ();
  public By VALUABLE_ITEMS_OVER_2000£_YES ();
  public By VALUABLE_ITEMS_OVER_2000£_NO ();
  public By VALUABLE_ITEMS_CATEGORY ();
  public By VALUABLE_ITEMS_DESCRIPTION ();
  public By VALUABLE_ITEMS_COST ();
  public By CANCEL_BUTTON ();
  public By SAVE_BUTTON ();
  public By ADD_ANOTHER_ITEM ();
  public By ITEM_EDIT_BUTTON ();
  public By ITEM_DELETE_BUTTON ();
  public By ADD_CLAIM ();
  public By ADD_NEW_CLAIM ();


  //Would you like extra cover for personal belongings away from the home?
  public By EXTRA_COVER_FOR_BELONGINGS_YES ();
  public By EXTRA_COVER_FOR_BELONGINGS_NO ();

  //How much cover would you like for personal belongings away from the home?
  public By COVER_COST_FOR_BELONGINGS ();

  public By INDIVIDUAL_ITEM_COVER_YES ();
  public By INDIVIDUAL_ITEM_COVER_NO ();
  public By BUILDING_ACCIDENTAL_DAMAGE_COVER_NEEDED_YES ();
  public By BUILDING_ACCIDENTAL_DAMAGE_COVER_NEEDED_NO ();

  public By TITLE ();
  public By GENDER ();
  public By POLICYHOLDER_TITLE ();
  public By TITLE_ADDITIONAL_POLICY_HOLDER ();

  public By FIRST_NAME ();
  public By LAST_NAME ();
  public By EMAIL ();
  public By PREFERRED_PHONE_NUM ();
  public By CORRESPONDENCE_ADDRESS ();
  public By BIRTH_DATE ();
  public By BIRTH_MONTH ();
  public By BIRTH_YEAR ();
  public By MARITAL_STATUS ();
  public By JOINT_HOLDER_MARITAL_STATUS ();
  public By RELATIONSHIP_WITH_YOU ();
  public By EMPLOYMENT_STATUS ();
  public By JOB_TYPE ();
  public By JOB_INDUSTRY ();
  public By JOB_TYPE_SUGGESTION ();
  public By STUDENT_JOB_TYPE ();
  public By SECOND_JOB ();
  public By SECOND_JOB_EMPLOYMENT_STATUS ();
  public By JOINT_POLICY_HOLDER ();

  public By ADULT_COUNT ();

  public By CHILD_COUNT ();
  public By PETS_LIVING ();
  public By PAYING_GUEST_LIVING ();
  public By HOME_USED ();
  public By CLERICAL_BUSINESS_USE_YES ();
  public By CLERICAL_BUSINESS_USE_NO ();
  public By SUFFERED_LOSS_YES ();
  public By SUFFERED_LOSS_NO ();
  public By INSURANCE_RENEWAL ();

  public By CLAIM_LAST_FIVE_YEARS ();
  public By CLAIM_DESC ();
  public By VALUE_CLAIM ();
  public By MONTH_INCIDENT ();
  public By YEAR_INCIDENT ();

  public By CONTACT_EMAIL_PREFERENCE ();
  public By CONTACT_TEXT_PREFERENCE ();
  public By CONTACT_POST_PREFERENCE ();
  public By CONTACT_PHONE_PREFERENCE ();

  public By CAR_INSURANCE ();
  public By LEGAL_COST ();
  public By LEGAL_COST_ADD_BTN ();
  public By RECALCULATE_SCREEN_MSG ();
  public By HOME_EMERGENCY ();
  public By HOME_EMERGENCY_ADD_BTN ();
  public By EXCESS_PROTECTION ();
  public By AGREED_AND_PROCEED ();
  public By QUOTE_REFERENCE_NUMBER ();
  public By ANNUAL_PAYMENT_VALUE ();
  public By MONTHLY_PAYMENT_VALUE ();
  public By EXTRA_HOME_COVER_VALUE ();
  public By BUILDING_EXCESS_COMPULSORY ();
  public By CONTENT_EXCESS_COMPULSORY ();

  public By PERSONAL_DETAILS_CONFIRMATION_MESSAGE ();
  public By ZERO_PREMIUM ();
  public By POLICY_NUMBER ();
  public By CHANGE_TEXT ();
  public By EFFECTIVE_DATE ();
  public By QUOTE_REFERENCE_INPUT ();
  public By QUOTE_REFERENCE_TEXT ();
  public By YOUR_POSTCODE_INPUT ();
  public By PROPERTY_POSTCODE_EDIT ();
  public By YOUR_DOB_DAY ();
  public By YOUR_DOB_MONTH ();
  public By YOUR_DOB_YEAR ();
  public By RETRIEVE_QUOTE_BTN ();
  public By BACK_BTN ();
  public By PROPERTY_EDIT_BTN ();
  public By POSTCODE_LOOKUP_ADDRESS_LINK ();


}

package PageObjects.PortalModel;

import org.openqa.selenium.By;

public interface PerformMTALocatorModel {
  
  public By EDIT_PERSONAL_DETAILS();
  
  public By EDIT_COVER_DETAILS();
  
  public By EDIT_ADDRESS();
  
  public By CONFIRM_CONTINUE_BTN();
  
  public By EFFECTIVE_DATE_SELECTION();
  
  public By CONTINUE_EFFECTIVE_BTN();
  
  public By CHANGE_POLICY_HOLDER_DETAILS();
  
  public By CHANGE_ADDRESS_DETAILS();
  
  public By CHANGE_BED_BATH_NUMBER();
  
  public By CHANGE_COVER_DETAILS();
  
  public By CHANGE_JOINT_POLICYHOLDER_DETAILS();
  
  public By CHANGE_ADDRESS_EDIT_BUTTON();
  
  public By CHANGE_COVER_EDIT_BUTTON();
  
  public By CHANGE_PERSONAL_DETAILS_EDIT_BUTTON();
  
  public By CONFIRM_AND_CONTINUE_BUTTON();
  
  public By SELECT_MTA_EFFECTIVE_DATE();
  
  public By EDIT_POLICYHOLDER_DETAILS();
  
  public By EDIT_JOINT_POLICYHOLDER_DETAILS();
  
  public By ADD_JOINT_POLICYHOLDER();
  
  public By CORRESPONDENCE_ADDRESS_SAME_BUTTON();
  
  public By SECOND_JOB_YES_BUTTON();
  
  public By BUSINESS_USE_BUTTON();
  
  public By STANDARD_CONSTRUCTION_BUTTON();
  
  public By PREVIOUS_COVER_BUTTON();
  
  public By CONTENTS_COVER_BUTTON();
  
  public By EXTRA_COVER_BUTTON();
  
  public By POLICYHOLDER_TITLE();
  
  public By SUBMIT_EDIT_POLICYHOLDER_BUTTON();
  
  public By CONTINUE_EDIT_BUTTON();
  
  public By CONTINUE_SUMMARY_CHANGE_BUTTON();
  
  public By PREMIUM_AMOUNT();
  
  public By REFUND_AMOUNT();
  
  public By HOME_MTA_ELEMENTS();
  
  public By MOTOR_MTA_ELEMENTS();
  
  public By COVER_CONTENT_AMOUNT();
  
  public By BUILDING_ACCIDENTAL_COVER();
  
  public By VOLUNTARY_XS_BUILDING();
  
  public By NEW_ADDRESS_HOUSE_NAME_OR_NUMBER();
  
  public By NEW_ADDRESS_POSTCODE();
  
  public By FIND_ADDRESS_BUTTON();
  
  public By SELECT_0_14_DAYS_BUTTON();
  
  public By SELECT_15_60_DAYS_BUTTON();
  
  public By SELECT_61_DAYS_BUTTON();
  
  public By SELECT_PROPERTY_TYPE_HOUSE();
  
  public By SELECT_HOME_DESCRIPTION();
  
  public By STANDARD_CONSTRUCTION_YES();
  
  public By NUMBER_OF_BEDROOMS();
  
  public By NUMBER_OF_BATHS();
  
  public By HOME_BUILT_YEAR();
  
  public By HOME_EXTENDED_NO();
  
  public By GRADED_BUILDING_NO();
  
  public By FLOODING_NO();
  
  public By WINDOW_AND_DOOR_LOCKS_YES();
  //public By WINDOW_AND_DOOR_LOCKS_YES();
  
  public By INTRUDER_ALARM();
  
  public By OWNED_ON_MORTGAGE();
  
  public By HOME_OCCUPIED_DAY_AND_NIGHT();
  
  public By CORRESPONDENCE_ADDRESS_YES();
  
  public By NUMBER_OF_ADULTS();
  
  public By NUMBER_OF_CHILDREN();
  
  public By PETS();
  
  public By PAYING_GUESTS();
  
  public By BUSINESS_PURPOSE_NO();
  
  public By PAST_CONTENTS_COVER();
  
  public By CLAIM_FREE_YEARS();
  
  public By CONTENT_COVER_AMOUNT();
  
  public By VOLUNTARY_XS_CONTENT();
  
  public By CONTENT_ACCIDENTAL_COVER();

  
  public By PERSONAL_BELONGING_AWAY_FROM_HOME();
  
  public By PERSONAL_BELONGING_AWAY_FROM_HOME_COVER_AMOUNT();

  //OPEX Locators
  public By EMC_MORE_BUTTON();
  public By EMC_ADDED_SECTION_EXCESS_PROTECTION();
  public By EMC_NOT_ADDED_SECTION_LEGAL_EXPENSES();
  public By EMC_NOT_ADDED_SECTION_EXTRA_HOME_EMERGENCY();
  public By EMC_EFFECTIVE_DATE();
  public By EMC_LEGAL_EXPENSES_YES();
  public By EMC_LEGAL_EXPENSES_NO();
  public By EMC_ADD_LEGAL_EXPENSES();
  public By EMC_EXTRA_HOME_EMERGENCY_NO();
  public By EMC_ADD_EXTRA_HOME_EMERGENCY();
  public By EMC_EXTRA_HOME_EMERGENCY_YES();
  public By EMC_EXCESS_PROTECTION_NO();
  public By EMC_EXCESS_PROTECTION_YES();
  public By EMC_ADD_EXCESS_PROTECTION();
  public By EMC_CONTINUE_BUTTON();
  public By EMCS_SAVE_BUTTON();
  public By EMC_OPEX_MTA_PREMIUM();

  //Insured Property Details
  public By IPD_NUMBER_OF_BEDROOMS();
  public By IPD_NUMBER_OF_BATHROOMS();
  public By IPD_NUMBER_OF_ADULTS_AT_PROPERTY();
  public By IPD_NUMBER_OF_CHILDREN_AT_PROPERTY();
  public By IPD_OWNER_RENT_STATUS_OWNED_ON_MORTGAGE();
  public By IPD_OWNER_RENT_STATUS_PRIVATELY_RENTED();
  public By  IPD_OWNER_RENT_STATUS_OWNED_OUTRIGHT();
  public By  IPD_OWNER_RENT_STATUS_COUNCIL_RENTED();
  public By  IPD_OWNER_RENT_STATUS_HOUSING_ASSOCIATION();
  public By EDIT_INSURED_PROPERTY_ADDRESS();
  public By IPD_SAVE_BUTTON();
  public By IPD_CONTINUE_BUTTON();
  public By IPD_MTA_PREMIUM();
  public By IPD_HOME_EXTENDED_NO();
  public By IPD_HOME_EXTENDED_YES();
  public By IPD_HOME_LISTED_BUILDING_NO();
  public By IPD_HOME_LISTED_BUILDING_GRADE1();
  public By IPD_HOME_LISTED_BUILDING_GRADE2();
  public By IPD_HOME_LISTED_BUILDING_GRADE22();
  public By IPD_WHEN_IS_YOUR_HOME_OCCUPIED_DAYANDNIGHT();
  public By IPD_WHEN_IS_YOUR_HOME_OCCUPIED_DURINGTHEDAY();
  public By IPD_WHEN_IS_YOUR_HOME_OCCUPIED_DURINGTHENIGHT();
  public By IPD_WHEN_IS_YOUR_HOME_OCCUPIED_UNOCCUPIED();
  public By IPD_PROPERTY_TYPE_BUNGALOW();
  public By IPD_PROPERTY_TYPE_HOUSE();
  public By IPD_PROPERTY_TYPE_TOWNHOUSE();
  public By IPD_PROPERTY_TYPE_SELFCONTAINEDFLAT();
  public By IPD_PROPERTY_TYPE_MAISONETTE();
  public By IPD_HOME_FITTED_WITH_DEAD_LOCKS_NO();
  public By IPD_HOME_FITTED_WITH_DEAD_LOCKS_YES();
  public By IPD_WHAT_BEST_DESCRIBES_YOUR_HOME();
  public By IPD_INTRUDER_ALARM();
  public By IPD_STANDARD_CONSTRUCTION_YES();
  public By IPD_STANDARD_CONSTRUCTION_NO();
  public By IPD_PETS_AT_PROPERTY();
  public By IPD_DO_YOU_HAVE_ANY_PAYING_GUESTS();
  public By  IPD_USED_FOR_BUSINESS_NO();
  public By  IPD_USED_FOR_BUSINESS_YES();
}
package PageObjects.EisModel;

import org.openqa.selenium.By;

public interface EisHomeQuoteCreationLocatorModel {

  //EIS Core Insurance Software
  public By USER_NAME();

  public By PASSWORD();

  public By SUBMIT_BUTTON();

  //Policy Page
  public By ADD_NEW_QUOTE();

  public By SELECT_PRODUCT(); //Home (Preconfigured)

  public By NEXT_BUTTON();

  public By BRAND_PAGE(); // Ageas

  public By TYPE_HOUSEHOLD_INSURANCE(); //Buildings & Contents

  public By PRODUCT_TYPE();

  public By INSURANCE_TYPE(); // Home

  public By AFFINITY_CODE(); // AHCC Ageas Direct Extra Telephony (AHCC)

  //Has any resident had any unsatisfied County Court Judgements?
  public By UNSATISFIED_COUNTY_COURT_JUDGEMENTS();

  public By DECLARED_BANKRUPT_YES_NO();

  public By NEXT_PAGE();

  public By SAVE_QUOTE();

  public By SAVE_AND_EXIT();

  public By PAYMENT_CANCEL();


  //Insured Page
  //JointPolicyHolder
  public By JPH_ADD_JOINT_POLICY_HOLDER_BUTTON();

  public By JPH_RELATIIONSHIP_TO_PROPOSER();

  public By JPH_TITLE();

  public By JPH_FIRST_NAME();

  public By JPH_LAST_NAME();

  public By JPH_DATE_OF_BIRTH();

  public By JPH_RESIDENCE_IN_UK();

  public By JPH_GENDER();

  public By JPH_MARITAL_STATUS();

  public By JPH_FULL_TIME_OCCUPATION();

  public By JPH_EMPLOYMENT_STATUS();

  public By JPH_EMPLOYER_BUSINESS();

  public By JPH_SECONDARY_JOB();

  public By JPH_UNSPENT_CRIMINAL_CONVITIONS();

  public By JPH_INSURANCE_REFUSED();

  public By FULLTIME_OCCUPATION(); // Bakery Assistant

  public By EMPLOYMENT_STATUS(); //Employed

  public By EMPLOYMENT_INDUSTRY(); //Fast Food

  public By SECOND_EMPLOYMENT_YES_NO();

  public By SECOND_EMPLOYMENT_STATUS();

  public By SECOND_JOB_OCCUPATION();

  public By SECOND_JOB_INDUSTRY();

  public By UNSPENT_CRIMINAL_CONVICTIONS_YES_NO();

  public By INSURANCE_REFUSED();

  public By PREFERRED_DELIVERY(); //Download, Print

  public By PREFERRED_PAYMENT_METHOD();

  public By PREVIOUS_INSURANCE();

  public By BOTTOM_PAGE();

  public By PREVIOUS_INSURANCE_HEADER();

  public By PREVIOUS_INSURANCE_SECTION();

  public By RISK_ADDRESS();

  public By RISK_ADDRESS_POST_CODE();

  public By RISK_ADDRESS_HOUSE_IDENTIFIER();

  public By RISK_ADDRESS_ADDRESS_LINE1();

  public By RISK_ADDRESS_FIND_POSTCODE();

  public By LIST_OF_RISK_HOME_ADDRESS();

  public By DEFAULT_RISK_HOME_ADDRESS();

  public By RISK_ADDRESS_SELECTION_OK();

  public By RESIDENCY_TYPE();

  public By PRIMARY_RESIDENCY_TYPE();

  public By NUM_BATHROOM();

  public By YEAR_BUILT();

  public By PROPERTY_FURNISHED();

  public By BUILDING_WORK();

  public By BUILDING_WORK_END_DATE();

  public By PROPERTY_UNOCCUPIED_DURING_WORK();

  public By HAS_JCT_SIGNED();

  public By NUM_BEDROOM();

  public By EXTENDED_HOME(); //Has the property been extended?

  public By OWNERSHIP_TYPE();//Ownership Type

  public By LET_SUBLET();

  public By GOOD_REPAIR();

  public By OCCUPANCY_TYPE();

  public By LODGER_OCCUPANCY_TYPE();

  public By PROPERTY_LEFT_OCCUPIED();

  public By BUSINESS_USE();
  public By CLERICAL_USE();
  public By PROPERTY_USE();

  public By DOOR_WINDOW_LOCKS();

  public By ALARM();

  public By NEIGHBOURHOOD_WATCH();

  public By NON_FAMILY_LODGER();

  public By NUM_ADULTS();

  public By NUM_CHILD();

  public By PET_DETAILS();

  public By BUILDING_TYPE();

  public By TYPE_OF_HOUSE(); //Detached House

  public By STRUCTURE_TYPE();

  public By TYPE_OF_BUNGLOW(); //

  public By TYPE_OF_TOWN_HOUSE();

  public By TYPE_OF_FLAT();

  public By FREE_FROM_FLOODING();

  public By STANDARD_CONSTRUCTION();

  public By ROOF_CONSTRUCTION();

  public By GEOLOGICAL_STATUS();

  public By HOME_LISTED();

  public By HOME_LISTED_STATUS();

  public By WALL_CONSTRUCTION();

  public By PERCENTAGE_FLAT_ROOF();

  //Claims
  public By ADD_CLAIM();

  public By INCIDENT_DATE();

  public By INCIDENT_SOURCE();

  public By CLAIM_STATUS();

  public By CLAIM_TYPE();

  public By CLAIM_CAUSE();

  public By CLAIM_COST();

  public By CLAIM_NUMBER();

  public By CLAIM_OK_BUTTON();

  //Have you or anyone living with you suffered losses or incidents which did not result in a claim
  public By SUFFERED_LOSS_NOT_RESULTED_IN_CLAIM();

  //Cover page
  public By BUILDING_ACCIDENTAL_DAMAGE_COVER();

  public By BUILDING_CLAIM_FREE_YEARS();

  public By BUILDING_VOLUNTARY_EXCESS();

  public By REBUILDING_COST();

  public By CONTENT_ACCIDENTAL_DAMAGE_COVER();

  public By CONTENT_CLAIM_FREE_YEARS();

  public By CONTENTS_SUM_INSURED();

  public By CONTENT_VOLUNTARY_EXCESS();

  public By SAFE_INSTALLED();

  public By COVER_FOR_OTHER_UNSPECIFIED_ITEMS();

  public By UNSPECIFIED_ITEMS_AMOUNT();

  public By VALUABLES_IN_HOME();

  public By VALUABLE_ITEMS();

  public By VALUABLE_ITEMS_DESCRIPTION();

  public By VALUABLE_ITEMS_VALUE();

  public By VALUABLES_AWAY_HOME();

  public By ADD_ITEMS();

  public By OK_BUTTON_VALUABLE_SECTION();

  public By BICYCLE_AWAY_HOME();

  public By BICYCLE_DESCRIPTION();

  public By VALUE_OF_BICYCLE();

  public By CALCULATE_PREMIUM();

  public By CONSENT_TO_RENEW();

  public By PURCHASE_POLICY();

  public By CONFIRMATION_PURCHASE_POLICY();

  public By COVERAGE_AND_PREMIUM_TAB();

  //Payment Process
  public By ADD_PAYMENT_METHOD();

  public By CARD_BELONGS_TO_POLICY_HOLDER();

  public By PERMISSION_TO_STORE_CARD();

  public By POLICY_AMOUNT_REQUIRED_FIELD();

  public By AMOUNT_COL();

  public By ALL_AMOUNT_COL();

  public By CREDIT_CARD_AMOUNT();

  public By CHEQUE_AMOUNT();

  public By CHEQUE_REFERENCE_NUM();

  public By CREDIT_CARD_REFERENCE();

  public By TAKE_PAYMENT();

  public By PAYMENT_METHOD();

  public By CARD_TYPE();

  public By CARD_NUMBER();

  public By CARD_USER_NAME();

  public By CARD_EXPIRY_MONTH();

  public By CARD_EXPIRY_YEAR();

  public By ADD_UPDATE_CARD_DETAILS();

  public By BACK_BUTTON();

  public By AMOUNT_REMAINING_DUE();

  public By FINISH_PAYMENT();

  public By CONFIRM_PAYMENT();

  public By CONFIRM_PAYMENT_NEW();


  public By PAYMENT_SUCCESSFUL_OK();

  public By POLICY_NUMBER_VAR();

  public By POLICY_NUMBER();

  public By QUOTE_REF_NUMBER();

  public By POLICY_EFFECTIVE_DATE();

  public By ENDORSEMENT_CODE();

  public By ENDORSEMENT_LIST();

  public By ADD_ENDORSEMENT();

  public By ENDORSEMENT_CLOSE();

  public By QUOTE_REF_VALUE();

  public By CUSTOMER_NUMBER();

  public By POLICY_STATUS();

  public By POLICY_ID();

  public By ALL_OPTIONAL_EXTRAS_CODE();

  public By OPTIONAL_EXTRAS_DESC();

  public By OPTIONAL_EXTRAS_CODE_YES_ANSWER();

  public By OPEX_OK_BUTTON();


}

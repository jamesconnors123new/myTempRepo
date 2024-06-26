package PageObjects.EisModel;

import org.openqa.selenium.By;

public interface EisMotorPolicyPersonalDetailsLocatorModel {
  public By TITLE();

  public By FIRST_NAME();

  public By SURNAME();

  public By DATE_OF_BIRTH();

  public By GENDER();

  public By MARITAL_STATUS();
  public By AGE();

  public By PRIMARY_OCCUPATION();

  public By PRIMARY_EMPLOYMENT_STATUS();

  public By PRIMARY_JOB_INDUSTRY();

  public By SECOND_JOB_OCCUPATION();

  public By SECOND_JOB_EMPLOYMENT_FLAG();

  public By SECOND_JOB_INDUSTRY();

  public By ADDRESS_POSTCODE();

  public By ADDRESS_HOUSE_IDENTIFIER();

  public By PHONE_NUMBER();

  public By EMAIL_ADDRESS();

  public By PREFERRED_PAYMENT_METHOD();

  public By NCD_CLAIM_FREE_YEARS();

  public By IAM_PROPOSER();

  public By PREV_POLICY_EXPIRY_DATE();
  public By PREV_POLICY_EXPIRATION_DATE();
  public By PREVIOUS_COVER_TYPE();

  public By NCD_BUILDING();
  //How many children or dependents under the age of 16?
  public By DEPENDENTS_CHILD_UNDER_16();

  //How many cars are there in your household, excluding this one?
  public By NUM_CARS_EXCLUDING_CURRENT();

  //Insurance previously refused ?
  public By PREV_INSURANCE_REFUSED();

  public By INSURANCE_REFUSED();
  //Use of vehicle by proposer
  public By USE_VEHICLE_BY_PROPOSER();

  //  //Preferred Payment Method
//  public By PREFERRED_PAYMENT_METHOD();
  //Are you a Home owner?
  public By ARE_YOU_HOME_OWNER();

  //Has affordability threshold been reached ?
  public By AFFORDABILITY_THRESHOLD();

  // U/w only premium finance rekey ?
  public By U_W_PREMIUM_FINANCE_REKEY();

  //    Previous Insurance
  public By PREVIOUS_INSURANCE();
  public By PREV_INSURANCE();
  //    NCD Applied to Any Other Vehicle
  public By NCD_APPLIED_OTHER_VEHICLE();

  //How many years' NCD do you have on your other vehicle
  public By YEARS_OF_NCD_APPLIED_OTHER_VEHICLE();

  //What type of policy is the NCD being mirrored from?
  public By NCD_MIRRORED_FROM();

  //  public By PREV_POLICY_EXPIRY_DATE();
  //    Type of Insurance
  public By INSURANCE_TYPE();

  //    NCD claimed
  public By NCD_CLAIMED();

  //    Would you like to protect your No Claims Discount?
  public By PROTECT_NCD_CLAIMS_DISCOUNT();
}
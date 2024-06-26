package PageObjects.EchelonModel;

import org.openqa.selenium.By;

public interface EchelonCarPolicyDetailsLocatorModel {
  public By NAME ();
    public By EMAIL_ADDRESS ();
  public By MOBILE_TELEPHONE_NUMBER();
  public By ADDRESS ();

  public By DATE_OF_BIRTH();
  public By MARITAL_STATUS();
  public By EMPLOYMENT_STATUS();
  public By OCCUPATION ();
  public By DRIVING_LICENSE_TYPE();
  public By YEARS_NO_CLAIMS_DISCOUNT();
  public By JOINT_POLICY_HOLDER_NAME();

  //Vehicle Section (Risk Tab)
  public By CAR_MAKE();
  public By CAR_MODEL();
  public By YEAR_OF_MAKE();
  public By TRANSMISSION();
  public By FUEL_TYPE();
  public By CURRENT_MARKET_VALUE();
  public By CAR_OWNER();
  public By REGISTERED_KEEPER();
  public By CAR_LOCATION_OVERNIGHT();
  public By CLASS_OF_USE();
  //public By  CHANGES_EFFECTIVE_DATE ();
  public By ANNUAL_MILEAGE();
  //Excesses
  public By LEVEL_OF_VOLUNTARY_EXCESS();
  // public By  COMPULSORY ();

  public By CE_ACCIDENTAL_DAMAGE_AND_MALICIOUS_DAMAGE();
  public By EC_POLICY_SCHEME ();
  public By CE_ACCIDENTAL_DAMAGE_AND_MALICIOUS_DAMAGE_VALUE();

  //-------------- Additional Driver ------------------------------
  public By AD_NAME();
  public By AD_GENDER();
  public By AD_DATE_OF_BIRTH();
  public By AD_AGE();
  public By AD_FULL_TIME_OCCUPATION();
  public By AD_PART_TIME_OCCUPATION();
  public By AD_LICENSE_TYPE();
  public By AD_LICENSE_DATE ();
  public By AD_ACCESS_TO_VEHICLES();
  public By AD_RELATIONSHIP_TO_PROPOSER();
  public By AD_MARITAL_STATUS();
  public By AD_DATE_OF_RESIDENCY();
  public By AD_VEHICLE_USE();
  public By AD_INSURANCE_PREVIOUSLY_REFUSED();

}

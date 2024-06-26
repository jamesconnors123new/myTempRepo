package PageObjects.EisVersion.V01;

import PageObjects.EisModel.EisMotorPolicyPersonalDetailsLocatorModel;
import org.openqa.selenium.By;

public class EisMotorPolicyPersonalDetailsLocatorLib implements EisMotorPolicyPersonalDetailsLocatorModel {


  @Override
  public By TITLE() {
    return By.xpath("//label[text()=\"Title\"]/following::span[1]");
  }

  @Override
  public By FIRST_NAME() {
    return By.xpath("//label[text()=\"First Name\"]/following::span[1]");
  }

  @Override
  public By SURNAME() {
    return By.xpath("//label[text()=\"Surname\"]/following::span[1]");
  }

  @Override
  public By DATE_OF_BIRTH() {
    return By.xpath("//label[text()=\"Date of Birth\"]/following::span[1]/input[1]");
  }

  @Override
  public By GENDER() {
    return By.xpath("//label[text()=\"Gender\"]/following::span[1]");
  }

  @Override
  public By MARITAL_STATUS() {
    return By.xpath("//label[text()=\"Marital Status\"]/following::span[1]");
  }

  @Override
  public By AGE() {
    return By.xpath("//label[text()=\"Age\"]/following::span[1]");
  }

  @Override
  public By PRIMARY_OCCUPATION() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_PreconfigInsuredPersonInfoProxy_person_occupationCd\"]");
  }

  @Override
  public By PRIMARY_EMPLOYMENT_STATUS() {
    return By.xpath("//label[text()=\"Employment Status\"]/following::span[1]");
  }

  @Override
  public By PRIMARY_JOB_INDUSTRY() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_PreconfigInsuredPersonInfoProxy_person_businessTypeCd\"]");
  }

  @Override
  public By SECOND_JOB_OCCUPATION() {
    return null; // Open Defect as of now
  }

  @Override
  public By SECOND_JOB_EMPLOYMENT_FLAG() {
    return By.xpath("//label[text()=\"Secondary job?\"]/following::span[1]");
  }

  @Override
  public By PREVIOUS_COVER_TYPE() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_PreconfigPolicyPriorCarrier_previousCoverTypeCd\"]");
  }

  @Override
  public By NCD_BUILDING() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_PreconfigPolicyPriorCarrier_buildingContinuousYears\"]");
  }
  @Override
  public By SECOND_JOB_INDUSTRY() {
    return null; // Open Defect as of now
  }

  @Override
  public By ADDRESS_POSTCODE() {
    return By.xpath("//label[text()=\"Postcode\"]/following::span[1]");
  }

  @Override
  public By ADDRESS_HOUSE_IDENTIFIER() {
    return By.xpath("//label[text()=\"Building Name or Number\"]/following::span[1]");
  }

  @Override
  public By PHONE_NUMBER() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_PreconfigInsuredPersonPhoneContactProxy_phoneEntity_phoneNumber\"]");
  }


  @Override
  public By EMAIL_ADDRESS() {
    return By.xpath("(//label[text()=\"Email\"]/following::span[1])[2]");
  }

  @Override
  public By PREFERRED_PAYMENT_METHOD() {
    return By.xpath("//label[text()=\"Preferred Payment Method\"]/following::span[1]");
  }

  @Override
  public By NCD_CLAIM_FREE_YEARS() {
    return By.xpath("//label[text()=\"NCD claimed\"]/following::span[1]");
  }

  @Override
  public By IAM_PROPOSER() {
    return By.xpath("//label[contains(text(),\"IAM or other organisation\")]/following::span[1]");
  }

  @Override
  public By PREV_POLICY_EXPIRY_DATE() {
    return By.xpath("//label[text()=\"Previous Policy Expiry Date\"]/following::input[1]");
  }

  //Previous Policy Expiration Date-Insured tab
  @Override
    public By PREV_POLICY_EXPIRATION_DATE() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_PreconfigPolicyPriorCarrier_carrierPolicyExpirationDateInputDate\"]");
  }

  @Override
  public By DEPENDENTS_CHILD_UNDER_16() {
    return By.xpath("//label[contains(text() ,\"dependents under the age of 16?\")" +
        "]/following::span[1]");
  }

  @Override
  public By NUM_CARS_EXCLUDING_CURRENT() {
    return By.xpath("//label[contains(text() ,\"ars are there in your household, excluding this " + "one?\")]/following::span[1]");
  }

  @Override
  public By PREV_INSURANCE_REFUSED() {
    return By.xpath("//label[contains(text() , \"Insurance previously refused\")" +
        "]/following::span[1]");
  }

  //Specific to Home
  @Override
  public By INSURANCE_REFUSED() {
    return By.xpath("//label[contains(text() , \"Insurance refused?\")]/following::span[1]");
  }

  @Override
  public By USE_VEHICLE_BY_PROPOSER() {
    return By.xpath("//label[contains(text(), \"vehicle by proposer\")]/following::span[1]");
  }

  @Override
  public By ARE_YOU_HOME_OWNER() {
    return By.xpath("//label[contains(text(), \"home owner\")]/following::span[1]");
  }

  @Override
  public By AFFORDABILITY_THRESHOLD() {
    return By.xpath("//label[contains(text(), \"affordability threshold\")]/following::span[1]");
  }

  @Override
  public By U_W_PREMIUM_FINANCE_REKEY() {
    return By.xpath("//label[contains(text(), \"premium finance rekey\")]/following::span[1]");
  }

  @Override
  public By PREVIOUS_INSURANCE() {
    return By.xpath("//label[contains(text(), \"Previous Insurance\")]/following::span[1]");
  }

  @Override //No attribute is common across Home/Van/Motor
  public By PREV_INSURANCE(){
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_PreconfigPolicyPriorCarrier_previousInsuranceInd\"]");
  }

  @Override
  public By NCD_APPLIED_OTHER_VEHICLE() {
    return By.xpath("//label[text() = \"NCD Applied to Any Other Vehicle\"]/following::span[1]");
  }

  @Override
  public By YEARS_OF_NCD_APPLIED_OTHER_VEHICLE() {
    return By.xpath("//label[contains(text(), \"NCD do you have on your other vehicle\")" +
        "]/following::span[1]");
  }

  @Override
  public By NCD_MIRRORED_FROM() {
    return By.xpath("//label[contains(text() ,\"NCD being mirrored from?\")]/following::span[1]");
  }

  @Override
  public By INSURANCE_TYPE() {
    return By.xpath("//label[text()= \"Type of Insurance\"]/following::span[1]");
  }

  @Override
  public By NCD_CLAIMED() {
    return By.xpath("//label[text()= \"NCD claimed\"]/following::span[1]");
  }

  @Override
  public By PROTECT_NCD_CLAIMS_DISCOUNT() {
    return By.xpath("//label[contains(text(), \"protect your No Claims Discount?\")" +
        "]/following::span[1]");
  }
}
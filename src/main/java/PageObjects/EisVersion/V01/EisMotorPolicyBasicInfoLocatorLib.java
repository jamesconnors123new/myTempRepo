package PageObjects.EisVersion.V01;

import PageObjects.EisModel.EisMotorPolicyBasicInfoLocatorModel;
import org.openqa.selenium.By;

public class EisMotorPolicyBasicInfoLocatorLib implements EisMotorPolicyBasicInfoLocatorModel {
  @Override
  public By ENQUIRY() {
    return By.xpath("//label[text()=\"Enquiry\"]/following::span[1]");
  }

  @Override
  public By SALES_CHANNEL() {
    return By.xpath("//label[text()=\"Sales Channel\"]/following::span[1]");
  }

  @Override
  public By BRAND() {
    return By.xpath("//label[text()=\"Brand\"]/following::span[1]");
  }

  @Override
  public By PROD_TYPE() {
    return By.xpath("//label[text()=\"Product Type\"]/following::span[1]");
  }

  @Override
  public By SCHEME() {
    return By.xpath("//label[text()=\"Scheme\"]/following::span[1]");
  }

  @Override
  public By AFFINITY_CODE() {
    return By.xpath("//label[text()=\"Affinity Code\"]/following::span[1]");
  }

  @Override
  public By COVER_TYPE() {
    return By.xpath("//label[text()=\"Cover Type\"]/following::span[1]");
  }

  @Override
  public By COVER_SECTIONS() {
    return By.xpath("//label[text()=\"Cover Sections\"]/following::span[1]");
  }

  @Override
  public By ORIGINAL_QUOTE_DATE() {
    return By.xpath("(//label[text()=\"Original Quote Date\"]/following::span[1]/input)[1]");
  }

  @Override
  public By POLICY_PERIOD() {
    return By.xpath("//label[text()=\"Policy Period\"]/following::span[1]");
  }

  @Override
  public By INCEPTION_DATE() {
    return By.xpath("(//label[text()=\"Original Policy Inception " + "Date\"]/following::span[1" + "]/input)[1]");
  }

  @Override
  public By DRIVING_RESTRICTION() {
    return By.xpath("//label[text()=\"Driving restrictions\"]/following::span[1]");
  }

  @Override
  public By RENEWAL_COUNT() {
    return By.xpath("//label[text()=\"Renewal Count\"]/following::span[1]");
  }

  @Override
  public By NCD_FLAG() {
    return By.xpath("//label[text()=\"NCD chase flag\"]/following::span[1]");
  }

  @Override
  public By CONCERN_FLAG() {
    return By.xpath("//label[text()=\"Concern flag\"]/following::span[1]");
  }

  @Override
  public By POLICY_START_DATE() {
    return By.xpath("(//label[text()=\"Policy Start Date\"]/following::span[1]/input)[1]");
  }

  @Override
  public By POLICY_END_DATE() {
    return By.xpath("(//label[text()=\"Policy End Date\"]/following::span[1]/input)[1]");
  }

  @Override
  public By AGENCY_NUMBER() {
    return By.xpath("//label[text()=\"Agency Number\"]/following::span[1]");
  }

  @Override
  public By NUM_OF_DAYS_IN_A_TERM() {
    return By.xpath("//label[text()=\"Total number of days in a term\"]/following::span[1]");
  }

}

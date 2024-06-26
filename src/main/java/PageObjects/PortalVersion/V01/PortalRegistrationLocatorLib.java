package PageObjects.PortalVersion.V01;

import PageObjects.PortalModel.PortalRegistrationLocatorModel;
import org.openqa.selenium.By;

public class PortalRegistrationLocatorLib implements PortalRegistrationLocatorModel {
  @Override 
  public By REGISTER_BUTTON() { return By.xpath("//button[text()='Create my online account']");}
//  changed the registration button as per the portal change.
  @Override
  public By POLICY_ID() { return By.xpath("//input[@name=\"policyId\"]");}
  @Override
  public By POLICYHOLDER_DOB_DAY() { return By.xpath("//select[@data-testid=\"registrationDobDayPicker\"]");}
  @Override
  public By POLICYHOLDER_DOB_MONTH() { return By.xpath("//select[@data-testid=\"registrationDobMonthPicker\"]");}
  @Override
  public By POLICYHOLDER_DOB_YEAR() { return By.xpath("//select[@data-testid=\"registrationDobYearPicker\"]");}
  @Override
  public By POSTCODE() { return By.xpath("//input[@data-testid=\"postcode\"]");}
  @Override
  public By USERNAME() { return By.xpath("//input[@data-testid=\"username\"]");}
  @Override
  public By PASSWORD() { return By.xpath("//input[@data-testid=\"password\"]");}
  @Override
  public By CREATEACCOUNT_BUTTON() { return By.xpath("//button[@data-testid=\"createAccountButton\"]");}
  @Override
  public By EMAIL_SENT_MESSAGE() { return By.xpath("//h1[text()=\"Email Sent\"]");}
  @Override
  public By CONFIRMATION_BUTTON() { return By.cssSelector("[data-testid=\"confirmationButton" +
      "\"]");}
  @Override
  public By ALREADY_REGISTERED_DAILOG() { return By.cssSelector("[data-testid" +
      "=\"modalContent\"] >p");}
  @Override
  public By LOGIN_BUTTON() { return By.cssSelector("[data-testid=\"loginButton\"]");}

}

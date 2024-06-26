package PageObjects.PortalVersion.V01;

import PageObjects.PortalModel.PortalLoginLocatorModel;
import org.openqa.selenium.By;

public class PortalLoginLocatorLib implements PortalLoginLocatorModel {

  @Override
  public By EMAIL_INPUT() { return By.xpath("//input[@id=\"username\"]");}
  @Override
  public By PASSWORD_INPUT() { return By.xpath("//input[@id=\"password\"]");}
  @Override
  public By LOG_IN_BTN() { return By.cssSelector("[name=\"Log in\"]");}
  @Override
  public By RETRIEVE_QUOTE() { return By.xpath("//button[text()=\"Retrieve Quote\"]"); }
  @Override
  public By UNSUCCESSFUL_LOGIN_INDICATOR() { return By.cssSelector("#password-error-area-selector");}
  @Override
  public By MY_HOME_TAB() { return By.cssSelector("[href=\"/my_home\"]");}
  @Override
  public By TAB_HEADER() { return By.xpath("//h1[@data-testid=\"titleTestId\"]");}

  @Override
  public By DASHBOARD_TAB() {
    return By.xpath("//a[@data-testid=\"desktopLink\" and @href=\"/dashboard\"]");
  }
  @Override
  public By POLICY_DETAILS_TAB() {
    return By.xpath("//li[contains(text(), 'Policy Details')]");
  }

  @Override
  public By MY_MOTOR_TAB() { return By.cssSelector("[href=\"/my_car\"]");}
  @Override
  public By MY_VAN_TAB() { return By.cssSelector("[href=\"/my_van\"]");}

}

package PageObjects.EchelonVersion.V01;

import PageObjects.EchelonModel.EchelonLoginLocatorModel;
import org.openqa.selenium.By;

public class EchelonLoginLocatorLib implements EchelonLoginLocatorModel {
  @Override
  public By EMAIL_INPUT() {return By.cssSelector("[name=\"username\"]");}

  @Override
  public By PASSWORD_INPUT() {
    return By.cssSelector("[name=\"password\"]");
  }

  @Override
  public By LOG_IN_BTN() {
    return By.cssSelector("[value=\"Log In\"]");
  }

  @Override
  public By UNSUCCESSFUL_LOGIN_INDICATOR() {
    return By.cssSelector("[class=\"feedbackPanelERROR\"]");
  }

  @Override
  public By POLICY_NUMBER() {
    return  By.name("policyNumber");
  }
}

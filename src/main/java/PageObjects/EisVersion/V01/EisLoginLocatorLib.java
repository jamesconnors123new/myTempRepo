package PageObjects.EisVersion.V01;

import PageObjects.EisModel.EisLoginLocatorModel;
import org.openqa.selenium.By;

public class EisLoginLocatorLib implements EisLoginLocatorModel {


  @Override
  public By USER_ID() {
    return By.cssSelector("#username");
  }

  @Override
  public By PASSWORD_INPUT() {
    return By.cssSelector("#password");
  }

  @Override
  public By LOG_IN_BTN() {
    return By.cssSelector("[type=\"submit\"]");
  }

  @Override
  public By UNSUCCESSFUL_LOGIN_INDICATOR() {
    return By.cssSelector("[role=\"alert\"]");
  }

  @Override
  public By CUSTOMER_DETAILS() {
    return By.cssSelector("[class=\"gen-dashboard-view-customer-tab-pane-container\"]");
  }

  @Override
  public By EIS_PROFILE_BUTTON() {
    return By.cssSelector("[aria-label=\"Avatar\"]");
  }

  @Override
  public By LOGOUT_BUTTON() {
    return By.cssSelector("[name=\"logoutForm:logout_link\"]");
  }

  @Override
  public By LOGOUT_CONFIRMATION() {
    return By.cssSelector("[id=\"logoutConfirmDialogDialog_form" + ":buttonYes\"]");
  }

  @Override
  public By EIS_LOGOUT_BUTTON() {
    return By.xpath("//*[text()=\"Sign Out\"]");
  }

  public By EIS_CORE_USERNAME() {
    return By.xpath("//input[@id=\"loginForm:j_username\"]");
  }

  @Override
  public By EIS_CORE_PASSWORD() {
    return By.xpath("//input[@id=\"loginForm:j_password\"]");
  }

  @Override
  public By EIS_CORE_LOGIN_BUTTON() {
    return By.xpath("//input[@id=\"loginForm:submitForm\"]");
  }

  @Override
  public By EIS_CORE_CUSTOMER_DETAILS() {
    return By.xpath("//div[@class=\"gen-customer-overview-name\"]");
  }

  @Override
  public By EIS_CORE_UNSUCCESSFUL_LOGIN_INDICATOR() {
    return By.xpath("//span[@class=\"error_message\"]");
  }
}

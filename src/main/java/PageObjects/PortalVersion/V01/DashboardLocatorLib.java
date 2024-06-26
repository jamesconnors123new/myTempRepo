package PageObjects.PortalVersion.V01;

import PageObjects.PortalModel.DashboardLocatorModel;
import org.openqa.selenium.By;

public class DashboardLocatorLib implements DashboardLocatorModel {

  @Override
  public By WELCOME_BANNER() {
    return By.cssSelector("[data-testid=\"titleTestId\"]");
  }
  @Override
  public By POLICY_NUMBER() {return By.cssSelector("[data-testid=\"policyNumberDisplay\"]");
  }
  @Override
  public By LOGOUT_BTN() {return By.xpath("//button[text()='Log out']");}
  @Override
  public By READ_BTN() {return By.xpath("//button[text()='Read']");}
  @Override
  public By CHANGE_POLICY_DETAILS_BTN() {return By.xpath("//button[text()='Change Policy Details']");}
  @Override
  public By MY_DOCUMENTS_BTN() {return By.xpath("//button[text()='My Documents']");}
  @Override
  public By OPTIONAL_EXTRAS_BTN() {return By.xpath("//button[text()='Optional Extras']");}
  @Override
  public By HOMEPAGE_LINK() {return By.xpath("//*[@title='homepageIcon']");}
  @Override
  public By MY_CAR_LINK() {return By.xpath("//*[@title='carIcon']");}
  @Override
  public By CONTACT_US_LINK() {return By.xpath("//*[@title='contactIcon']");}
  @Override
  public By MY_ACCOUNT_DETAILS_LINK() {return By.linkText("My account details");}
  @Override
  public By AUTO_RENEWALS_SETTINGS_LINK() {return By.xpath("//*[@title='auto-renewal']");}
  @Override
  public By NEED_TO_MAKE_A_CLAIM_LINK() {return By.linkText("Need to make a claim?");}
  @Override
  public By WELCOME_HEADER() {return By.xpath("//h1[text()='Hello ' and text()='<variable>']");}
  @Override
  public By TAB_REDIRECT() {return By.xpath("//li[normalize-space(text())=\"<variable>\"]");}
  @Override
  public By GET_STATUS_CHANGE_OF_POLICY() {return By.xpath("(//p[contains(normalize-space(text()),\"Confirmation of change to your policy\")][1]/following::span[1])[1]");}
  @Override
  public By GET_PAYMENT_STATUS() {return By.xpath("(//div[@role=\"tabpanel\"])[3]/p");}
  @Override
  public By COMPLETE_PAYMENT() {return By.xpath("//button[@data-testid=\"buttonTestId\"][normalize-space(text())=\"Complete\"]");}
  @Override
  public By PREMIUM_PAYMENT() {return By.cssSelector("[data-testid=\"additionalPaymentHome\"]");}
  @Override
  public By POLICY_DETAILS() {return By.xpath("(//div[contains(@class,\"PolicySummary\")])[2]");}
  @Override
  public By HOME_POLICY_START_DATE() {return By.xpath("//p[text()=\"Policy start\"]/parent::div/p/strong");}
  @Override
  public By HOME_POLICY_END_DATE() {return By.xpath("//p[text()=\"Policy end\"]/parent::div/p/strong");}

  @Override
  public By POLICY_START_DATE() {return By.xpath("//span[contains(@class,\"PolicyStartValue\")]");}
  @Override
  public By POLICY_END_DATE() {return By.xpath("//span[contains(@class,\"PolicyEndValue\")]");}
  @Override
  public By POLICY_EXPIRES_IN() {return By.cssSelector("[data-testid=\"countdown-text\"]");}


}

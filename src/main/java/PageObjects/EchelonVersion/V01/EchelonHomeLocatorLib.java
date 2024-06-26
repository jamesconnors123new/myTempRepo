package PageObjects.EchelonVersion.V01;

import PageObjects.EchelonModel.EchelonHomeLocatorModel;
import org.openqa.selenium.By;

public class EchelonHomeLocatorLib implements EchelonHomeLocatorModel {
  
  public By LOGIN_USERNAME () {return By.name("username");}
 @Override
  
  public By LOGIN_PASSWORD () {return By.name("password");}
 @Override
  
  public By LOGIN_BUTTON () {return By.cssSelector("[value=\"Log In\"]");}
 @Override
  public By ECHELON_LOGOUT_BUTTON () {return By.cssSelector("[title=\"Log Out\"]");}
 @Override
  
  public By CLIENT_NUMBER () {return By.name("partyID");}
 @Override
  public By POLICY_NUMBER () {return By.name("policyNumber");}
 @Override
  public By WEB_REFERENCE_NUMBER () {return By.name("webReference");}
 @Override
  public By SURNAME () {return By.name("clientName");}
 @Override
  public By FORENAME () {return By.name("foreNames");}
 @Override
  public By DATE_OF_BIRTH () {return By.name("dateOfBirth");}
 @Override
  public By CALENDAR_BUTTON () {return By.xpath("//label[@for=\"idd\" and " +
      "@class=\"input-group-addon\"]");}
 @Override
  public By CALENDAR_TEXT_INPUT () {return By.className("ant-calendar-input");}
 @Override
  public By POSTCODE () {return By.name("postCode");}
 @Override
  public By ADDRESS_SEARCH () {return By.name("addressLine");}
 @Override
  public By REGISTRATION_NUMBER () {return By.name("vehicleRegistrationNumber");}
 @Override
  public By EMAIL_ADDRESS () {return By.name("emailAddress");}
 @Override
  public By CLEAR_BUTTON () {return By.name("newSearch");}
 @Override
  public By SEARCH_BUTTON () {return By.xpath("//input[@name=\"searchNow\" and " +
      "@value=\"Search\"]");}
 @Override
  public By CLIENT_SELECT_BTN () {return By.xpath("//a[contains(@href,\"" +
      "./viewClient?clientId=\")]");}
 @Override
  public By CLIENT_ACTIONS_LINK () {return By.xpath("//span[text()=\"Client Actions " +
      "|\"]/parent::a");}
 @Override
  public By AMEND_CLIENT_NON_RATING_DETAILS () {return By.xpath("//a[text()=\"Amend Client " +
      "Non-Rating Details\"]");}
 @Override
  public By CREATE_IMPORTANT_CLIENT_NOTE () {return By.xpath("//a[text()=\"Create Important " +
      "Client Note\"]");}
 @Override
  public By CREATE_CLIENT_COMMENT () {return By.xpath("//a[text()=\"Create Client Comment\"]");}
 @Override
  public By MANAGE_CARDS () {return By.xpath("//a[text()=\"Manage Cards\"]");}
 @Override
  public By CREATE_QUOTES () {return By.xpath("//a[text()=\"Create Quote Based on This " +
      "Client\"]");}
 @Override

  public By VIEW_POLICY_DETAILS () {return By.xpath("//a[@data-id=\"viewPolicyDetails\"]");}
 @Override
  public By POLICY_ACTION () {return By.xpath("//span[text()=\"Policy Actions |\"]");}
 @Override

  public By CREATE_PERMANENT_MTA_QUOTE () {return By.xpath("//a[text()=\"Create Permanent MTA" +
      " Quote\"]");}
 @Override
  public By RENEWAL_QUOTE () {return By.xpath("//a[text()=\"Renewal Quote\"]");}
 @Override
  public By SUMMARY_TAB () {return By.cssSelector("[data-id=\"summaryTab\"]");}
 @Override
  public By ACCOUNT_TAB () {return By.cssSelector("[data-id=\"accountSummaryTab\"]");}
 @Override
  public By NEW_CUSTOMER_QUOTE () {return By.cssSelector("[data-id=\"newQuote\"]");}

  @Override
  public By CLIENT_TABLE() {
    return By.cssSelector("//span[text()=\"Clients\"]");}

}

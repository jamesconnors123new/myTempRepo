package PageObjects.EisVersion.V01;

import PageObjects.EisModel.EisClientCreationLocatorModel;
import org.openqa.selenium.By;

public class EisClientCreationLocatorLib implements EisClientCreationLocatorModel {

  @Override
  public By BRAND_DROP_DOWN() {
    return By.xpath("//div[@id='customer.brandCd']");
  }

  @Override
  public By BRAND_SELECTION() {
    return By.xpath("//li[@title='<variable>']");
  }

  @Override
  public By TITLE() {
    return By.xpath("//label[text()='Title']/following::div[1]");
  }

  @Override
  public By TITLE_TEXT_FIELD() {
    return By.xpath("//div[@id='customer.details.person.salutation']");
  }

  @Override
  public By TITLE_SELECTION() {
    return By.xpath("//li[text()='<variable>']");
  }

  @Override
  public By FIRST_NAME() {
//    return By.cssSelector("[id='customer.details.person.firstName']");
    return By.xpath("//input[@id = 'customer.details.person.firstName']");
  }

  @Override
  public By LAST_NAME() {
//    return By.cssSelector("[id='customer.details.person.lastName']");
    return By.xpath("//input[@id = 'customer.details.person.lastName']");
  }

  @Override
  public By DATE_OF_BIRTH_INPUT() {
    return By.xpath("(//input[@placeholder='DD/MM/YYYY'])" + "[2]");
  }

  @Override
  public By DOB_HEADER() {
    return By.cssSelector("[for='customer.details.person.birthDate']");
  }

  @Override
  public By DATE_OF_BIRTH() {
    return By.cssSelector("[placeholder='DD/MM/YYYY']");
  }

  @Override
  public By DOB_YEAR() {
    return By.cssSelector("[title='Choose a year']");
  }

  @Override
  public By PREV_YEARS() {
    return By.cssSelector("[title='Last decade']");
  }

  @Override
  public By LIST_OF_YEARS_TO_SELECT() {
    return By.xpath("//td[@role='gridcell' and not" + "(@class='ant-calendar-year-panel-cell " +
        "ant-calendar-year-panel-last-decade-cell') and not" + "(@class='ant-calendar-year" +
        "-panel-cell ant-calendar-year-panel-next-decade-cell')]//a");
  }

  @Override
  public By GENDER() {
    return By.xpath("//div[@id='customer.details.person.genderCd']");
  }

  @Override
  public By GENDER_SELECTION() {
    return By.xpath("//li[@title='<variable>']");
  }

  @Override
  public By MARTIAL() {
    return By.xpath("//div[@id='customer.details.person.maritalStatus']");
  }

  @Override
  public By CHOOSE_YEAR() {
    return By.xpath("//a[text()='<variable>']");
  }

  @Override
  public By CHOOSE_MONTH() {
    return By.cssSelector("[title='Choose a month']");
  }

  @Override
  public By SELECT_MONTH() {
    return By.xpath("//td[@title='<variable>']");
  }

  @Override
  public By DATE_SELECTION() {
    return By.xpath("//td[@title='<variable>']");
  }

  @Override
  public By MARTIAL_SELECTION() {
    return By.xpath("//li[@title='<variable>']");
  }

  @Override
  public By ADD_NEW_ADDRESS() {
    return By.xpath("//span[normalize-space(text())='Add New " + "Address']/parent::button");
  }

  @Override
  public By POST_CODE() {
    return By.xpath("//div[contains(@id,'location.postalCodeToFind')" + "]//input");
  }

  @Override
  public By LIST_POST_CODE() {
    return By.xpath("//span[contains(@id," + "'auto-complete-container')]//li[1]");
  }

  @Override
  public By HOME_IDENTIFIER() {
    return By.xpath("//input[contains(@id,'location" + ".addressLine1')]");
  }

  @Override
  public By CONFIRM_BUTTON() {
    return By.xpath("(//span[text()='Confirm']/parent::button)" + "[last()]");
  }

  @Override
  public By ADD_NEW_PHONE() {
    return By.xpath("//span[normalize-space(text())='Add New " + "Phone']/parent::button");
  }

  @Override
  public By CONTACT_HEADER() {
    return By.xpath("//div[normalize-space(text())='Contacts']");
  }

  @Override
  public By PHONE_NUMBER() {
    return By.xpath("//input[contains(@id, 'customer" + ".communicationInfo.phones[0].value')]");
  }

  @Override
  public By ADD_NEW_EMAIL() {
    return By.xpath("//span[normalize-space(text())='Add New " + "Email']/parent::button");
  }

  @Override
  public By EMAIL() {
    return By.xpath("//input[contains(@id,'customer.communicationInfo" + ".emails[0].value')]");
  }

  @Override
  public By MARKETING_PERMISSION_HEADING() {
    return By.xpath("//span[text()='Add New Email']");
  }

  @Override
  public By SMS_MARKETING_CHOICE() {
    return By.xpath("//div[@id='smsMarketingPermissionStringValue']");
  }

  @Override
  public By EMAIL_MARKETING_CHOICE() {
    return By.xpath("//div[@id='emailMarketingPermissionStringValue']");
  }

  @Override
  public By POST_MARKETING_CHOICE() {
    return By.xpath("//div[@id='postMarketingPermissionStringValue']");
  }

  @Override
  public By TELEPHONE_MARKETING_CHOICE() {
    return By.xpath("//div[@id='phoneMarketingPermissionStringValue']");
  }

  @Override
  public By MARKETING_SELECTION() {
    return By.xpath("(//li[contains(text(),'<variable>')])[last()]");
  }

  @Override
  public By SAVE_AND_EXIT() {
    return By.xpath("//span[text()='Save & Exit']/parent::button");
  }

  @Override
  public By SAVE() {
    return By.xpath("//span[text()='Save']/parent::button");
  }

  @Override
  public By CANCEL() {
    return By.xpath("(//span[text()='Cancel'])[1]/parent::button[1]");
  }

  @Override
  public By CANCEL_MERGE_CLIENT() {
    return By.xpath("//span[text()='Cancel']/parent::button");
  }

  @Override
  public By ACCEPT_CANCEL_MERGE() {
    return By.xpath("//span[text() ='Yes']/parent::button");
  }

  @Override
  public By LOST_DATA_POP_UP_YES() {
    return By.cssSelector("[class='ant-btn " + "ant-btn-primary']");
  }

  @Override
  public By LOST_DATA_POP_UP_NO() {
    return By.cssSelector("[class='ant-btn']");
  }

  @Override
  public By CLIENT_NUMBER() {
    return By.cssSelector("[class='gen-customer-overview-customer-number']");
  }

//  $x("//*[@class = 'gen-customer-overview-customer-number']")

  @Override
  public By DUPLICATE_CLIENT_MESSAGE() {
    return By.cssSelector("[class='gen-page-header" + "-title']");
  }

  @Override
  public By POTENTIAL_DUPLICATE_CLIENT_NUMBERS() {
    return By.xpath("//div[contains(@class,'customer-details')]/span[2]");
  }

  @Override
  public By NEXT_PAGE() {
    return By.xpath("//span[text()='Next']/parent::button");
  }

  @Override
  public By SELECT_CLIENT() {
    return By.xpath("//input[@value='<variable>']");
  }

  @Override
  public By CLOSE_CONFIRMATION_MESSAGE() {
    return By.cssSelector("[aria-label='icon: " + "close']");
  }
}

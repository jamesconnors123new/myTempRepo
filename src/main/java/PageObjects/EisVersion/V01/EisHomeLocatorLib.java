package PageObjects.EisVersion.V01;

import PageObjects.EisModel.EisHomeLocatorModel;
import org.openqa.selenium.By;

public class EisHomeLocatorLib implements EisHomeLocatorModel {

  @Override
  public By ADD_NEW_CLIENT() {
    return By.cssSelector("[type=\"submit\"]");
  }

  @Override
  public By SEARCH_BUTTON() {
    return By.cssSelector("[class=\"anticon toggle-search-button\"]");
  }

  @Override
  public By SEARCH_FIELD() {
    return By.cssSelector("[type=\"search\"]");
  }

  @Override
  public By SUGGESTION_LIST() {
    return By.xpath("//ul[@class=\"ant-select-dropdown-menu  ant-select-dropdown-menu-root " +
        "ant-select-dropdown-menu-vertical\"]");
  }

  @Override
  public By POLICY_SUGGESTION_LIST() {
    return By.xpath("//div[@class=\"gen-global-search-quote-policy-suggestion-details-policy" +
        "-dates\"]");
  }

  @Override
  public By VIEW_ALL_MATCHING() {
    return By.xpath("//button[@class=\"ant-btn eis-search-input__view-all-btn ant-btn-link\"]");
  }

  @Override
  public By SWITCH_SEARCH_CRITERIA() {
    return By.cssSelector("[class=\"ant-select-show-arrow ant-select ant-select-enabled\"]");
  }

  @Override
  public By SEARCH_BY_POLICIES() {
    return By.xpath("//li[text()=\"Quotes/Policies\"]");
  }

  @Override
  public By SELECT_FIRST_SUGGESTION() {
    return By.xpath("//div[@class=\"gen-global-search" + "-suggestion-label\"]");
  }


  @Override
  public By SEARCH_CUSTOMER() {
    return By.cssSelector("input[class=\"ant-input search-bar__input ant-select-search__field\"]");
  }

  @Override
  public By SEARCH_FILTER() {
    return By.cssSelector("//div[@class=\"search-suffix__actions\"]//i[2]");
  }

  @Override
  public By SEARCH_BY_POLICY_NUMBER() {
    return By.cssSelector("//input[@id=\"policyNumberIgnoreCase\"]");
  }

  @Override
  public By SEARCH_SUBMIT_BUTTON() {
    return By.cssSelector("//button[@class=\"ant-btn ant-btn-primary ant-btn-sm\"]");
  }

  @Override
  public By ADVANCE_FILTER_CRITERIA() {
    return By.cssSelector("//div[@class=\"advanced-search__filters\"]");
  }

  @Override
  public By SEARCH_BY_CUSTOMER_NUMBER() {
    return By.cssSelector("//input[@id=\"customerNumberIgnoreCase\"]");
  }

  @Override
  public By SEARCH_BY_FIRST_NAME() {
    return By.cssSelector("//input[@id=\"firstNameIgnoreCase\"]");
  }

  @Override
  public By SEARCH_BY_LAST_NAME() {
    return By.cssSelector("//input[@id=\"lastNameIgnoreCase\"]");
  }

  @Override
  public By SEARCH_BY_POSTCODE() {
    return By.cssSelector("//input[@id=\"postalCodeIgnoreCase\"]");
  }

  @Override
  public By SEARCH_BY_ADDRESS() {
    return By.cssSelector("//input[@id=\"addressLine1IgnoreCase\"]");
  }

  @Override
  public By SEARCH_BY_CITY() {
    return By.cssSelector("//input[@id=\"cityIgnoreCase\"]");
  }

  @Override
  public By SEARCH_BY_PHONE_NUMBER() {
    return By.cssSelector("//input[@id=\"phoneNumberIgnoreCase\"]");
  }

  @Override
  public By SEARCH_BY_EMAIL() {
    return By.cssSelector("//input[@id=\"emailIgnoreCase\"]");
  }

  @Override
  public By SEARCH_BY_VEHICLE_REG() {
    return By.cssSelector("//input[@id=\"vehicleRegistrationNumberIgnoreCase\"]");
  }

  @Override
  public By SELECT_CLIENT() {
    return By.cssSelector("//td[@class=\"gen-lead-table-column gen-lead-table-customer-header\"]");
  }
}

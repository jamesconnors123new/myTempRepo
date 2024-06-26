package PageObjects.PortalVersion.V01;

import PageObjects.PortalModel.PortalSharedLocatorModel;
import org.openqa.selenium.By;

public class PortalSharedLocatorLib implements PortalSharedLocatorModel {
  @Override
  public By USERNAME() { return By.cssSelector("#username");}
  @Override
  public By PASSWORD() { return By.cssSelector("#password");}
  @Override

  public By EMAIL_INPUT() { return By.cssSelector("#email");}
  @Override
  public By SUBMIT_BTM() { return By.xpath("//button[@type='submit']");}
  @Override
  public By CONTINUE_BUTTON() { return By.xpath("//button[normalize-space(text())" +
      "=\"Continue\"]");}
  @Override
  public By SAVE_BUTTON() { return By.xpath("//button[normalize-space(text())=\"Save\"]");}
  @Override
  public By QUOTE_SUBMITTED() { return By.cssSelector("[data-testid=\"quoteSubmit\"]");}
  @Override
  public By ACCEPT_COOKIE_BTN() { return By.cssSelector("#onetrust-accept-btn-handler");}
  @Override
  public By MY_DETAILS_FIELD_NAME_AND_VALUE() { return By.xpath("//div[@data-testid" +
      "=\"MyDetailsAccordion\"]/following::div[1]/child::div/p");}
  @Override
  public By MY_COVER_FIELD_NAME_AND_VALUE() { return By.xpath("//div[@data-testid" +
      "=\"coverDetailsAccordion\"]/following::div[1]/child::div/p");}
  @Override
  public By EXCESS_FIELD_NAME_AND_VALUE() { return By.xpath("//div[@data-testid" +
      "=\"policyExcessesAccordion\"]/following::div[1]/child::div/p");}
  @Override
  public By ENHANCE_COVER_ADDED() { return By.xpath("//div[@data-testid" +
      "=\"listContainerApplied\"]");}

  @Override
  public By ENHANCE_COVER_NOT_ADDED() { return By.xpath("//div[@data-testid" +
      "=\"listContainerAvailable\"]//child::p");}
  @Override
  public By MY_COVER_SECTION() { return By.cssSelector("[data-testid=\"coverDetailsAccordion" +
      "\"]");}
  @Override
  public By MY_COVER_SEC_INFO() { return By.xpath("//div[@data-testid" +
      "=\"coverDetailsAccordion\"]/following::div[1]");}
  @Override
  public By EXCESSES_SECTION() { return By.cssSelector("[data-testid" +
      "=\"policyExcessesAccordion\"]");}
  @Override
  public By EXCESSES_SEC_INFO() { return By.xpath("//div[@data-testid" +
      "=\"policyExcessesAccordion\"]/following::div[1]");}
  @Override
  public By ENHANCE_MY_COVER_SECTION() { return By.cssSelector("[data-testid" +
      "=\"optionalExtrasAccordion\"]");}
  @Override
  public By ENHANCE_MY_COVER_SEC_INFO() { return By.xpath("//div[@data-testid" +
      "=\"optionalExtrasAccordion\"]/following::div[1]");}
  @Override
  public By MY_DETAILS_SECTION() { return By.cssSelector("[data-testid=\"MyDetailsAccordion" +
      "\"]");}
  @Override
  public By MY_DET_SEC_INFO() { return By.xpath("//div[@data-testid=\"MyDetailsAccordion" +
      "\"]/following::div[1]");}
  @Override
  public By POLICY_START_DATE_MOTOR() { return By.xpath("//span[contains(@class," +
      "\"PolicyStartValue\")]");}
  @Override
  public By POLICY_END_DATE_MOTOR() { return By.xpath("//span[contains(@class," +
      "\"PolicyEndValue\")]");}
  @Override
  public By POLICY_START_DATE_HOME() { return By.xpath("//select[contains(@data-testid," +
      "\"Dropdown\")]/following::p[2]");}
  @Override
  public By POLICY_END_DATE_HOME() { return By.xpath("//select[contains(@data-testid," +
      "\"Dropdown\")]/following::p[4]");}
  @Override
  public By POLICY_NUMBER() { return By.cssSelector("[data-testid=\"policyNumberDisplay\"]");}
  @Override
  public By POLICY_DROP_DOWN() { return By.xpath("//select[contains(@data-testid," +
      "\"Dropdown\")]");}
  @Override
  public By SIGN_OUT_BUTTON() { return By.cssSelector("[data-testid=\"logOutButton\"]");}
  @Override
  public By ACCEPT_SIGNOUT() { return By.cssSelector("[data-testid=\"acceptButton\"]");}
  @Override
  public By PAYMENT_NEXT_BUTTON() { return By.cssSelector("//button[@name=\"next.y\"]");}
  @Override
  public By EDIT_COVER() { return By.xpath("//a[@href=\"/my_home/change_cover\"]");}
  @Override
  public By ADD_MORE_CHANGES() { return By.cssSelector("[data-testid=\"addMoreChangesBtn\"]");}
  @Override
  public By EDIT_PERSONAL_DETAILS() { return By.cssSelector("[href=\"/my_home" +
      "/change_personal_details\"]");}
  @Override
  public By EDIT_ADDRESS() { return By.cssSelector("[href=\"/my_home/change_address\"]");}
  @Override
  public By GET_COVER_QUESTIONS() { return By.xpath("//div[@data-testid" +
      "=\"containerHidden\"]/child::label");}
  @Override
  public By GET_COMPONENT() { return By.xpath("(//div[@data-testid=\"containerHidden\"]/child" +
      "::label/following-sibling::div)");}
  @Override
  public By COVER_ANSWER_COMPONENT() { return By.xpath("(//div[@data-testid" +
      "=\"containerHidden\"]/child::label/following-sibling::div)[<variable>]");}
  @Override

  public By ANSWER_DROP_DOWN() { return By.xpath("(//div[@data-testid=\"containerHidden" +
      "\"]/child::label/following-sibling::div)[<variable>]//select");}
  @Override
  public By HOUSE_IDENTIFIER() { return By.cssSelector("[name" +
      "=\"newAddressInput_houseNameOrNumber\"]");}
  @Override
  public By POST_CODE() { return By.cssSelector("[name=\"newAddressInput_postCode\"]");}
  @Override

  public By CHOICE_ANSWER_SELECTED() { return By.xpath("(//div[@data-testid" +
      "=\"containerHidden\"]/child::label/following-sibling::div)[<variable>]//input");}

  //    public By CHOICE_ANSWER_SELECTED_INSURED_ADDRESS() { return By.xpath("(//div[@data" +
//        "-testid=\"containerHidden\"])[<variable>]//child::input[@type=\"radio\"]");}
  @Override
  public By CHOICE_ANSWER_SELECTED_INSURED_ADDRESS() { return By.xpath("//div[text()" +
      "=\"<variable>\"]/ancestor::div[1]/div//input");}
  @Override
  public By DROP_DOWN_VALUE_ANWER() { return By.xpath("//div[text()=\"<variable>\"]/ancestor" +
      "::div[1]/div" + "//select");}
  @Override
  public By VOLUNTARY_DROP_DOWN() { return By.xpath("(//select[contains(@id," +
      "\"voluntaryXs\")])[<variable>]");}
  @Override
  public By COVER_BACK_BUTTON() { return By.cssSelector("[data-testid=\"backButton\"]");}
  @Override
  public By YES_DIALOG_BOX() { return By.cssSelector("[data-testid=\"backModalYes\"]");}
  @Override
  public By SECTION_OF_VALUABLE_ITEMS() { return By.xpath("((//div[@id=\"claimsContainer" +
      "\"])[1]/div)");}
  @Override
  public By SECTION_OF_SPECIFIED_ITEMS() { return By.xpath("((//div[@id=\"claimsContainer" +
      "\"])[2]/div)");}
  @Override
  public By GET_HOME_POLICY_LIST_DROPDOWN() { return By.cssSelector("[data-testid" +
      "=\"homePolicyDropdown\"]");}
  @Override
  public By BUILDING_VOLUNTARY_EXCESS() { return By.xpath("(//p[@data-testid=\"voluntaryValue\"])[1]");}

  @Override
  public By BUILDING_COMPULSORY_EXCESS() { return By.xpath("(//p[@data-testid=\"compulsoryValue" +
      "\"])[1]");}

  @Override
  public By CONTENT_VOLUNTARY_EXCESS() { return By.xpath("(//p[@data-testid=\"voluntaryValue\"])[2]");}
  @Override
  public By CONTENT_COMPULSORY_EXCESS() { return By.xpath("(//p[@data-testid=\"compulsoryValue" +
      "\"])[2]");}

  @Override
  public By EDIT_MAIN_POLICY_HOLDER() {
    return By.xpath("(//h1[text()=\"Main Policyholder\"]/following::a[text()=\"Edit\"])[1]");
  }

  @Override
  public By PRIMARY_EMP_STATUS() {
    return By.cssSelector("[id=\"employmentStatus\"]");
  }

  @Override
  public By PRIMARY_EMP_OCCUPATION() {
    return By.cssSelector("[id=\"occupation\"]");
  }

  @Override
  public By PRIMARY_EMP_INDUSTRY() {
    return By.cssSelector("[id=\"industryType\"]");
  }

  @Override
  public By SECONDARY_EMP_STATUS() {
    return By.cssSelector("[id=\"secondOccupationEmploymentStatus\"]");
  }

  @Override
  public By SECONDARY_EMP_OCCUPATION() {
    return By.cssSelector("[id=\"secondOccupation\"]");
  }

  @Override
  public By SECONDARY_EMP_INDUSTRY() {
    return By.cssSelector("[id=\"secondIndustryType\"]");
  }

}

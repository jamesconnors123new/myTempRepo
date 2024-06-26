package PageObjects.EchelonVersion.V01;

import PageObjects.EchelonModel.EchelonClientPolicyDetailsLocatorModel;
import org.openqa.selenium.By;


public class EchelonClientPolicyDetailsLocatorLib implements EchelonClientPolicyDetailsLocatorModel {
  public By NAME () {return  By.xpath("//label[@class='infolabel' and contains(text(),'Name:')"
      + "]/following-sibling::label[@class='infocontent']");}
 @Override
  public By MAIN_ADDRESS_LINE1 () {return  By.cssSelector("[data-id=\"address\"]");}
 @Override
  public By SUMMARY_TAB () {return  By.xpath("//a[text()='Summary']");}
 @Override
  public By RISK_TAB () {return  By.xpath("//a[@data-id=\"riskSummaryTab\"]");}
 @Override
  public By RESULT_TAB () {return  By.xpath("//a[text()='Result']");}
 @Override
  public By OPTIONAL_EXTRAS_TAB () {return  By.xpath("//div[contains(text(),'Optional Extras')"
      + "]");}
 @Override
  public By OPTIONAL_EXTRAS_LINE_ITEMS () {return  By.xpath("//div[@data-id" +
      "=\"optionalExtrasGrid\"]/div/div[2]/div/div/table/tbody/tr");}
 @Override
  public By BUSINESS_EVENT_BREADCRUMB () {return  By.cssSelector("[data-id=\"breadCrumb" +
      ".businessEvent\"]");}
 @Override
  public By CLIENT_ID_BREADCRUM () {return  By.cssSelector("[data-id=\"breadCrumb.party\"]");}
 @Override
  public By SHOW_DETAILS_LINK () {return  By.xpath("//a[text()='Show All Details']");}
 @Override
  public By OWNERSHIP () {return  By.xpath("//label[contains(text(),\"property owned\")" +
      "]/following::label[1]");}
 @Override
  public By RENT_FROM () {return  By.xpath("//label[contains(text(),\"Who do you rent from?\")" +
      "]/following::label[1]");}
 @Override
  public By EMPLOYMENT_STATUS () {return  By.xpath("");}
 @Override
  public By PROPERTY_TYPE () {return  By.xpath("//label[@class='infolabel' and contains(text()"
      + ",'Building Type:')]/following-sibling::label[@class='infocontent']");}
 @Override
  public By CORRESPONDENCE_ADDRESS () {return  By.cssSelector("[data-id=\"address\"]");}
 @Override
  public By RELATIONSHIP_STATUS  () {return By.xpath("//label[@class='infolabel' and contains" + "(text(),'Marital Status:')" +
          "]/following-sibling::label[@class='infocontent']");}
 @Override
  public By PRIMARY_EMP_DET() {return  By.cssSelector("[data-id=\"fullTimeOccupation\"]");}

 @Override
 public By SECONDARY_EMP_DET() {
  return By.xpath("(//div[@data-id=\"partTimeOccupation\"]//span[1])[1]");
 }

 @Override
  public By INSURED_ADDRESS () {return  By.cssSelector("[data-id=\"riskAddress\"]");}
 @Override
  public By BEDROOMS () {return  By.xpath("//label[@class='infolabel' and contains(text()," +
      "'Number of Bedrooms:')]/following-sibling::label[@class='infocontent']");}
 @Override
  public By JOINT_POLICY_HOLDER () {return  By.xpath("(//label[@class='infolabel' and " +
      "contains" + "(text(),'Name:')]/following-sibling::label[@class='infocontent'])[2]");}
 @Override
  public By BATHROOMS () {return  By.xpath("//label[contains(text(),\"Bathrooms\")" +
      "]/following::label[1]");}

 @Override
  public By YEAR_BUILT () {return  By.xpath("(//label[@class='infolabel' and contains(text()," + "'Year Built:')" +
          "]/following-sibling::label[@class='infocontent'])");}

 @Override
  public By INCEPTION_DATE () {return  By.xpath("//label[contains(text(),\"Inception Date:\")" + "]/following::label[1]");}

 @Override
  public By POLICY_END_DATE () {return  By.xpath("//label[contains(text(),\"Expiry Date:\")" + "]/following::label[1]  ");}
 @Override
  public By TYPE_OF_HOUSEHOLD_COVER  () {return  By.xpath("//label[contains(text(),\"Type of " + "Household Cover:\")]/following::label[1]");}
 @Override// In Portal - Type
  public By REBUILDING_COST () {return  By.xpath("//label[contains(text(),\"Rebuilding " +
      "Cost:\")]/following::label[1]");}
 @Override // In portal - Building
  public By CONTENT_COMPULSORY_EXCESS () {return  By.xpath("(//label[text()=\"Contents " +
      "Compulsory Excess:\"])/following::label[1]");}
 @Override
  public By BUILDING_COMPULSORY_EXCESS () {return  By.xpath("(//label[text()=\"Buildings " +
      "Compulsory Excess:\"])/following::label[1]");}
 @Override
  public By ACCIDENTAL_DAMAGE_BUILDING () {return  By.xpath("(//label[text()=\"Accidental " +
      "Damage:\"])[1]/following-sibling::label[1]");}
 @Override
  public By CONTENT_INSURANCE_HELD_LAST_2_YEARS () {return  By.xpath("//div[@data-id" +
      "=\"previousInsuranceGrid\"]//h3/span[2]");}
 @Override
  public By CONTENT_INSURANCE_TAB_SHRINK () {return  By.xpath("//span[text()=\"Previous " +
      "Insurance\"]/following-sibling::span[2]");}
 @Override
  public By SPECIFIED_ALL_RISK_ITEM_TAB_SHRINK () {return  By.xpath("//div[@data-id" +
      "=\"allRisksSpecifiedItems\"]//span[3]");}
 @Override
  public By SPECIFIED_ALL_RISK_ITEM_COUNT () {return  By.xpath("//div[@data-id" +
      "=\"allRisksSpecifiedItems\"]//span[2]");}
 @Override
  public By CONTENT_INSURANCE_HELD_LAST_2_YEARS_SHRINK  () {return  By.xpath("//span[text()" +
      "=\"Specified Contents Items\"]/following-sibling::span[2]");}
 @Override
  public By LIST_OF_VALUABLE_ITEMS () {return  By.xpath("//span[text()=\"Specified Contents " +
     "Items\"]/following::table[1]//tbody/tr");}

 @Override
 public By LIST_OF_VALUABLE_ITEM () {return  By.xpath("//span[text()=\"Specified Contents " +
     "Items\"]/following::table[1]//tbody/tr[<variable>]");}

@Override
public By LIST_OF_VALUABLE_ITEM_DATA(){return By.xpath("//span[text()=\"Specified Contents " +
    "Items\"]/following::table[1]//tbody/tr[<variable>]/td");}
 @Override
  public By COUNT_OF_INDIVIDUAL_ITEMS () {return  By.xpath("//div[@data-id" +
     "=\"allRisksSpecifiedItems\"]//tbody//tr");}
 @Override
  public By LIST_OF_INDIVIDUAL_ITEMS () {return  By.xpath("//div[@data-id" +
     "=\"allRisksSpecifiedItems\"]//tbody//tr[<variable>]/td");}
 @Override
  public By LIST_OF_INDIVIDUAL_ITEMS_COST () {return  By.xpath("(//div[@data-id" +
      "=\"allRisksSpecifiedItems\"]//tr[not" +
      "(@class)])[<variable>]/td[3]");}
  @Override
  public By LIST_OF_VALUABLE_ITEM_COST () {return  By.xpath("(//div[@data-id" +
      "=\"specifiedContentsGrid\"]//tr[not(@class)])[<variable>]/td[3]");}
 @Override
  public By COUNT_OF_SPECIFID_CONTENT () {return  By.xpath("//span[text()=\"Specified Contents" +
      " Items\"]/following-sibling::span[1]");}
 @Override
  public By ACCIDENTAL_DAMAGE_CONTENT () {return  By.xpath("(//label[text()=\"Accidental " +
      "Damage:\"])[2]/following-sibling::label[1]");}
 @Override
  public By COVER_TYPE () {return  By.xpath("//label[text()=\"Type of Household Cover" +
      ":\"]/following-sibling::label");}
 @Override
  public By LEVEL_OF_VOLUNTARY_EXCESS  () {return By.xpath("(//label[@class='infolabel' and contains(text(),'Level of Buildings " +
          "Voluntary Excess:')" + "]/following-sibling::label[@class='creditAmount infocontent'])" +
          "[1]");}
 @Override//In Risk Tab
  public By ESCAPE_OF_WATER_EXCESS () {return  By.xpath("(//span[text()=\"Escape of Water " +
      "Excess\"]/parent::td/following::td[contains(@class,\"currency-cell\")])[1]");}
 @Override //In Risk
  // Tab - LeakingFreezing in Portal
  public By SUBSIDENCE_COMPULSORY_EXCESS () {return  By.xpath("(//span[text()=\"Buildings " +
      "Subsidence Excess\"]/parent::td/following::td[contains(@class,\"currency-cell\")])[1]");}
 @Override
  //In Risk Tab - SubsidenceGroundHeaveLandslip in Portal

  public By OPTIONAL_EXTRAS_TABLE () {return  By.xpath("//table[@class=\"datatable table " +
      "table-bordered table-hover\"]");}
 @Override//In Optional Extras Tab
  public By OPTIONAL_EXTRAS_TABLE_ROWS () {return  By.xpath("//table/tbody/tr[contains(@class,"
      + " \"Opex\")]");}
 @Override
  public By INDIVIDUAL_ROWS () {return  By.xpath("(//table[@class=\"datatable table " + "table" +
      "-bordered table-hover\"]/tbody/tr[contains(@class,\"availableOpex\")])[<variable>]");}
 @Override
  public By OPTIONAL_EXTRAS_TABLE_DESCRIPTION_COLUMN () {return  By.xpath("(//div[@data-id" +
      "=\"optionalExtrasGrid\"]/div/div[2]/div/div/table/tbody/tr/td[2])[<variable>]");}
 @Override
  public By OPTIONAL_EXTRAS_TABLE_APPLIED_COLUMN () {return  By.xpath("(//div[@class" +
      "=\"bootstrap-switch-square\"]/div)[<variable>]");}
 @Override

  public By EFFECTIVE_DATE  () {return By.xpath("//label[contains(text(),\"Effective Date:\")" + "]/following::label[1]");}
 @Override
  public By ADJUSTMENT () {return  By.xpath("//label[contains(text(),\"Adjustment:\")" +
      "]/following::label[1]");}
 @Override
  public By MTA_TOTAL_SELLING_PRICE () {return  By.xpath("//label[contains(text(),\"MTA Total "
      + "Selling Price:\")]/following::label[1]");}
 @Override
  public By BUSINESS_EVENTS_TABLE_HEADER () {return  By.xpath("//span[text()=\"Business " +
      "Events\"]");}
 @Override
  public By BUSINESS_EVENTS_TABLE_ROW () {return  By.xpath("(//div[@data-id" +
      "=\"businessEventGrid\"]/div/div[2]/div/table/tbody/tr[<variable>]/td[@class=\"col5" +
      "\"]/span)[1]");}
 @Override
  public By BUSINESS_EVENTS_TABLE_DATE () {return  By.xpath("//div[@data-id" +
      "=\"businessEventGrid\"]/div/div[2]/div/table/tbody/tr/td[@class=\"col6\"]");}
 @Override
  public By BUSINESS_EVENTS_TABLE_STATUS () {return  By.xpath("//div[@data-id" +
      "=\"businessEventGrid\"]/div/div[2]/div/table/tbody/tr/td[@class=\"col5\"]");}
 @Override
  public By BUSINESS_EVENTS_TABLE_REF_ID () {return  By.xpath("//div[@data-id" +
      "=\"businessEventGrid\"]/div/div[2]/div/table/tbody/tr[<variable>]/td[@class=\"col1\"]");}
 @Override
  public By BUSINESS_EVENT_TABLE_NEXT_BUTTON () {return  By.xpath("(//a[@class=\"next\"])[1]");}
 @Override
  public By BUSINESS_EVENT_TABLE_FIRST_PAGE () {return  By.cssSelector("[class=\"first\"]");}
 @Override
  public By BUSINESS_EVENT_TABLE_HEADING_TEXT () {return  By.xpath("(//span[@class" +
      "=\"tableInfoCaption\"])[1]");}
 @Override

  public By JP_FULLNAME () {return  By.xpath("(//label[contains(text(),'Name:')" +
      "]/following-sibling::label)[2]");}
 @Override
  public By JP_DETAILS () {return  By.cssSelector("[data-id=\"jointProposerDetailsTitle\"]");}
 @Override
  public By JP_TAB () {return  By.xpath("//span[text()=\"Joint Proposer\"]");}
 @Override
  public By JP_DATE_OF_BIRTH  () {return By.xpath("(//label[contains(text(),'Date of Birth:')" + "]/following-sibling::label)[2]");}
 @Override
  public By JP_EMPLOYMENT_DETAILS () {return By.xpath("(//div[@data-id=\"fullTimeOccupation" + "\"])[2]");}
 @Override
  public By JP_MARITAL_STATUS() {return By.xpath("(//label[contains(text(),'Marital " +
      "Status:')]/following-sibling::label)[2]");}
 @Override
  public By JP_TITLE () {return  By.xpath("(//label[contains(text(),'Name:')" + "]/following" +
      "-sibling::label)[2][1]");}
 @Override
  public By JP_RELATIONSHIP_STATUS () {return  By.xpath("//label[contains(text()," +
      "'Relationship" + " to Proposer:')]/following-sibling::label");}
 @Override
  public By JP_PART_TIME_OCCUPATION () {return  By.xpath("(//div[@data-id=\"partTimeOccupation"
      + "\"])[2]");}
 @Override
  public By POLICIES_TABLE () {return  By.xpath("(//span[text()=\"Policies\"])" +
     "[2]/parent::h3/following::table/tbody/tr[@id]");}
 @Override
  public By PAGE_INDEX () {return  By.cssSelector("[title=\"page\"]");}
 @Override
  public By VIEW_POLICY_DETAILS_BUTTON () {return  By.xpath("(//a[@data-id=\"viewPolicyDetails"
      + "\"])[<variable>]");}
 @Override
  public By QUOTE_CREATION () {return By.xpath("//a[normalize-space(text())=\"Create Quote " + "Based on This Client\"]");}
 @Override
  public By CLIENT_ACTIONS () {return  By.xpath("//span[normalize-space(text())=\"Client " +
      "Actions |\"]/parent::a");}
 @Override
  public By POLICY_ACTIONS () {return  By.xpath("//span[contains(normalize-space(text())," +
      "\"Policy Actions\")]");}
 @Override
  public By WRAP_UP_POLICY () {return  By.xpath("//a[normalize-space(text())=\"Wrap Up " +
      "Policy\"]");}
 @Override
  public By BACK_DATED_POP_UP () {return  By.xpath("//h3[contains(@id,\"modaldialog\")]");}
 @Override
  public By ACCEPT_BACK_DATED_POP_UP () {return  By.cssSelector("[name=\"ok\"]");}
 @Override
  public By POLICY_TYPE_DROPDOWN () {return  By.cssSelector("[name=\"quoteTypes\"]");}
 @Override
  public By CONTINUE_BUTTON () {return  By.cssSelector("[name=\"btnContinue\"]");}
 @Override
  public By POLICY_REFERENCE () {return  By.xpath("(//table[@class='table datatable " + "table"
      + "-bordered table-hover']/tbody/tr/td[1]/span)[<variable>]");}
 @Override
  public By POLICY_STATUS () {return  By.xpath("//div[@class=\"sectionHead " + "toggle" +
      "\"]/following::table[1]//tr[<variable>]/td[@class=\"col3\"]");}
 @Override
  public By POLICY_QUOTE_REF () {return  By.xpath("//div[@class=\"sectionHead toggle\"]/following::table[1]//tr[<variable>]/td[@class=\"col1\"]");}
 @Override
  public By NEXT_PAGE () {return  By.cssSelector("[name=\"continueButton\"]");}
 @Override
  public By NEXT_PAGE_POLICIES () {return  By.cssSelector("[class=\"next\"]");}
 @Override
  public By PREVIOUS_PAGE_POLICIES () {return  By.cssSelector("[class=\"prev\"]");}
 @Override
  public By LAST_PAGE_POLICIES () {return  By.cssSelector("[title=\"Last\"]");}
 @Override
  public By PAY_BY_CARD() {return  By.cssSelector("[name=\"wrapupPaymentPanel" +
      ":paymentMethodRadioGroup:payInFullPanel:payInFull\"]");}
 @Override
  public By NEW_CARD_DETAIL_BTN () {return  By.cssSelector("[name=\"showCardDetails\"]");}
 @Override
  public By CALL_DTMF() {return  By.cssSelector("#callSemafone");}
 @Override
  public By CONFIRMATION_RESOLVED(){return  By.cssSelector("[value=\"OK\"]");}
 @Override
  public By PAYMENT_NEXT_PAGE () {return  By.cssSelector("[name=\"nextreusecc.y\"]");}
 @Override
  public By PAYMENT_SUMMARY () {return  By.cssSelector("[data-id=\"paymentStatusMessage\"]");}
 @Override
  public By POLICY_BALACE () {return  By.xpath("(//label[@class=\"debitAmount infocontent\"])" + "[1]");}
 @Override
  public By CONTINUE_WRAPUP_BUTTON () {return  By.cssSelector("[name=\"wrapupButtons" +
      ":continueWrapup\"]");}
 @Override
  public By COMPLETE_WRAPUP_BUTTON () {return  By.cssSelector("[name=\"wrapupButtons" +
      ":completeWrapup\"]");}
 @Override
  public By POLICY_ID () {return  By.xpath("//label[text()=\"Policy " + "Number:\"]/following" + "::label[1]");}
 @Override
  public By BUILDING_VOLUNTARY_EXCESS () {return  By.xpath("(//label[text()=\"Level of " +
      "Buildings Voluntary Excess:\"])[2]/following::label[1]");}
 @Override
  public By CONTENT_VOLUNTARY_EXCESS () {return  By.xpath("(//label[text()=\"Level of Contents" +
      " Voluntary Excess:\"])[2]/following::label[1]");}
 @Override
  public By BUILDIND_SUM_INSURED () {return  By.xpath("(//label[text()=\"Buildings Sum " +
      "Insured:\"])[1]/following::label[1]");}
 @Override
  public By PERSONAL_BELONGING_AWAY_FROM_HOME () {return  By.xpath("//p[contains(text()," +
      "\"Unspecified All Risks Sum Insured\")]");}
 @Override
  public By INSURE_HOUSE_HOLD_CONTENT () {return  By.xpath("(//label[text()=\"Contents Sum Insured:\"])[2]/following::label[1]");}
 @Override
 public By INSURE_HOUSE_HOLD_CONTENT_LIMIT () {return  By.xpath("//span[text()=\"Max. Claim Limit" +
     " for High Risk Property In The Home\"]/following::td[2]/span");}
 @Override
  public By CONTENT_MY_COVER () {return  By.xpath("(//label[text()=\"Contents Sum Insured:\"])[1]/following::label[1]");}

 @Override
 public By CORRESPONDENCE_TYPE() {return By.cssSelector("[name=\"diaryType\"]");}
 @Override
 public By CREATE_DOCUMENT() {return By.cssSelector("[value=\"Create\"]");}

 @Override
 public By CLAIM_LIST() {
  return By.xpath("(//span[text()=\"Claims\"])[3]/following::table[1]/tbody/tr");
 }

 @Override
 public By CLAIM_DETAILS() {
  return By.xpath("(//span[text()=\"Claims\"])[3]/following::table[1]/tbody/tr[<variable>]/td");
 }

 @Override
 public By PREVIOUS_INSURANCE() {
  return By.xpath("(//span[text()=\"Previous Insurance\"]/following-sibling::span[1])[2]");
 }

 @Override
 public By LEAKING_FREEING() {
  return By.xpath("//span[contains(*, \"Escape of water excess\")]");
 }


}

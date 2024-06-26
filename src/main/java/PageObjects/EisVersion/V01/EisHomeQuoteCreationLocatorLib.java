package PageObjects.EisVersion.V01;

import PageObjects.EisModel.EisHomeQuoteCreationLocatorModel;
import org.openqa.selenium.By;

public class EisHomeQuoteCreationLocatorLib implements EisHomeQuoteCreationLocatorModel {

  @Override
  public By USER_NAME() {
    return By.cssSelector("[name=\"loginForm:j_username\"]");
  }

  @Override
  public By PASSWORD() {
    return By.cssSelector("[name=\"loginForm:j_password\"]");
  }

  @Override
  public By SUBMIT_BUTTON() {
    return By.cssSelector("[name=\"loginForm:submitForm\"]");
  }

  @Override
  //Policy Page
  public By ADD_NEW_QUOTE() {
    return By.cssSelector("[name=\"quoteForm:newQuoteButton\"]");
  }

  @Override
  public By SELECT_PRODUCT() {
    return By.cssSelector("[id=\"quoteForm" + ":quoteCreationPopupMultiEdit_productCd\"]");
  }

  @Override //Home (Preconfigured)
  public By NEXT_BUTTON() {
    return By.cssSelector("[id=\"quoteForm:createQuoteButton\"]");
  }

  @Override
  public By BRAND_PAGE() {
    return By.cssSelector("[id=\"policyDataGatherForm" + ":sedit_Policy_brandCd\"]");
  }

  @Override // Ageas
  public By TYPE_HOUSEHOLD_INSURANCE() {
    return By.cssSelector("[id=\"policyDataGatherForm" + ":sedit_Policy_coverageTypeCd\"]");
  }

  @Override //Buildings & Contents
  public By PRODUCT_TYPE() {
    return By.xpath("//label[text()=\"Product\"]/following::select[1]");
  }

  @Override
  public By INSURANCE_TYPE() {
    return By.xpath("//label[contains(text(),\"Product\")" + "]/following::select[1]");
  }

  @Override // Home
  public By AFFINITY_CODE() {
    return By.cssSelector("[id=\"policyDataGatherForm" + ":sedit_Policy_affinityCd\"]");
  }

  @Override // AHCC Ageas Direct Extra Telephony (AHCC)
  //Has any resident had any unsatisfied County Court Judgements?
  public By UNSATISFIED_COUNTY_COURT_JUDGEMENTS() {
    return By.xpath("(//label[contains(text(),\"unsatisfied County Court Judgements?\")" +
        "]/following::label[normalize-space(text())=\"<variable>\"])[1]");
  }

  @Override
  public By DECLARED_BANKRUPT_YES_NO() {
    return By.xpath("(//label[contains(text(),\"declared bankrupt?\")" + "]/following::label" +
        "[normalize-space(text())=\"<variable>\"])[1]");
  }

  @Override
  public By NEXT_PAGE() {
    return By.xpath("(//input[@value=\"Next\"])[2]");
  }

  @Override
  public By SAVE_QUOTE() {
    return By.cssSelector("[id=\"topSaveLink\"]");
  }

  @Override
  public By SAVE_AND_EXIT() {
    return By.cssSelector("[id=\"topSaveAndExitLink\"]");
  }

  @Override
  public By PAYMENT_CANCEL() {
    return By.xpath("(//input[@value=\"Cancel\" and @onclick and " + "@id=\"purchaseForm" +
        ":noButton_footer\"])");
  }

  @Override
  public By JPH_ADD_JOINT_POLICY_HOLDER_BUTTON() {
    return By.cssSelector("[value=\"Add joint policyholder\"]");
  }

  @Override
  public By JPH_RELATIIONSHIP_TO_PROPOSER() {
    return By.xpath("//label[text()=\"Relationship to Proposer\"]/following::select[1]");
  }

  @Override
  public By JPH_TITLE() {
    return By.xpath("//label[text()=\"Title\"]/following::select[1]");
  }

  @Override
  public By JPH_FIRST_NAME() {
    return By.xpath("//label[text()=\"First Name\"]/following::input[1]");
  }

  @Override
  public By JPH_LAST_NAME() {
    return By.xpath("//label[text()=\"Surname\"]/following::input[1]");
  }

  @Override
  public By JPH_DATE_OF_BIRTH() {
    return By.xpath("//label[text()=\"Date of Birth\"]/following::input[1]");
  }

  @Override
  public By JPH_RESIDENCE_IN_UK() {
    return By.xpath("//label[text()=\"Residence in UK since\"]/following::input[1]");
  }

  @Override
  public By JPH_GENDER() {
    return By.xpath("//label[text()=\"Gender\"]/following::select[1]");
  }

  @Override
  public By JPH_MARITAL_STATUS() {
    return By.xpath("//label[text()=\"Marital Status\"]/following::select[1]");
  }

  @Override
  public By JPH_FULL_TIME_OCCUPATION() {
    return By.xpath("//label[text()=\"Full Time Occupation\"]/following::select[1]");
  }

  @Override
  public By JPH_EMPLOYMENT_STATUS() {
    return By.xpath("//label[text()=\"Employment Status\"]/following::select[1]");
  }

  @Override
  public By JPH_EMPLOYER_BUSINESS() {
    return By.xpath("//label[text()=\"Employer's Business\"]/following::select[1]");
  }

  @Override
  public By JPH_SECONDARY_JOB() {
    return By.xpath("//label[text()=\"Secondary job?\"]/following::label[normalize-space(text())" + "=\"<variable>\"][1]");
  }

  @Override
  public By JPH_UNSPENT_CRIMINAL_CONVITIONS() {
    return By.xpath("//label[text()=\"Unspent Criminal " + "Convictions\"]/following::label" +
        "[normalize-space(text())=\"<variable>\"][1]");
  }

  @Override
  public By JPH_INSURANCE_REFUSED() {
    return By.xpath("//label[text()=\"Insurance refused?\"]/following::label[normalize-space" +
        "(text" + "())=\"<variable>\"][1]");
  }


  @Override
  //Insured Page
  public By FULLTIME_OCCUPATION() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_PreconfigInsuredPersonInfoProxy_person_occupationCd\"]");
  }

  @Override // Bakery Assistant
  public By EMPLOYMENT_STATUS() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_PreconfigInsuredPersonInfoProxy_person_occupationOptionsCd\"]");
  }

  @Override //Employed
  public By EMPLOYMENT_INDUSTRY() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_PreconfigInsuredPersonInfoProxy_person_businessTypeCd\"]");
  }

  @Override //Fast Food
  public By SECOND_EMPLOYMENT_YES_NO() {
    return By.xpath("(//label[contains(text(),\"Secondary job?\")" + "]/following::label" +
        "[normalize-space(text())=\"<variable>\"])[1]");
  }

  @Override
  public By SECOND_EMPLOYMENT_STATUS() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_PreconfigInsuredPersonInfoProxy_person_secondJobOptionCd\"]");
  }

  @Override
  public By SECOND_JOB_OCCUPATION() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_PreconfigInsuredPersonInfoProxy_person_secondJobDescriptionCd\"]");
  }

  @Override
  public By SECOND_JOB_INDUSTRY() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_PreconfigInsuredPersonInfoProxy_person_secondJobBusinessTypeCd\"]");
  }

  @Override
  public By UNSPENT_CRIMINAL_CONVICTIONS_YES_NO() {
    return By.xpath("(//label[contains(text(),\"Unspent Criminal Convictions\")" + "]/following" +
        "::label[normalize-space(text())=\"<variable>\"])[1]");
  }

  @Override
  public By INSURANCE_REFUSED() {
    return By.xpath("(//label[contains(text(),\"Insurance refused?\")" + "]/following::label" +
        "[normalize-space(text())=\"<variable>\"])[1]");
  }

  @Override
  public By PREFERRED_DELIVERY() {
    return By.cssSelector("[id=\"policyDataGatherForm" +
        ":sedit_PreconfigInsuredPersonInfoProxy_person_preferredDeliveryCd\"]");
  }

  //Download, Print
  @Override
  public By PREFERRED_PAYMENT_METHOD() {
    return By.xpath("//label[text()=\"Preferred Payment Method\"]/following::select[1]");
  }

  @Override
  public By PREVIOUS_INSURANCE() {
    return By.xpath("(//label[contains(text(),\"Previous Insurance?\")" + "]/following::label" +
        "[normalize-space(text())=\"<variable>\"])[1]");
  }

  @Override
  public By BOTTOM_PAGE() {
    return By.xpath("(//input[@name=\"policyDataGatherForm:actionBarSpacer\"])[1]");
  }

  @Override
  public By PREVIOUS_INSURANCE_HEADER() {
    return By.xpath("//label[text()=\"Previous Insurer Information\"]");
  }

  @Override
  public By PREVIOUS_INSURANCE_SECTION() {
    return By.xpath("//div[@id=\"policyDataGatherForm" +
        ":componentView_PreconfigPolicyPriorCarrier_body\"]");
  }

  @Override
  public By RISK_ADDRESS() {
    return By.xpath("//label[text()=\"Is the risk address the same as Correspondence " +
        "Address?\"]/following::input[<variable>]");
  }


  @Override
  public By LIST_OF_RISK_HOME_ADDRESS() {
    return By.xpath("(//td[@role=\"gridcell\" and contains(text(), \"<variable>\")])[1]");
  }

  @Override
  public By DEFAULT_RISK_HOME_ADDRESS() {
    return By.xpath("(//td[@role=\"gridcell\"])[1]");
  }

  @Override
  public By RISK_ADDRESS_SELECTION_OK() {
    return By.cssSelector("[id=\"addressListPreconfigHomeRiskItemAddressContact:okBtn\"]");
  }

  @Override
  public By RISK_ADDRESS_POST_CODE() {
    return By.xpath("//label[text()=\"Postcode\"]/following::input[1]");
  }

  @Override
  public By RISK_ADDRESS_ADDRESS_LINE1() {
    return By.xpath("//label[text()=\"Address Line 1\"]/following::input[1]");
  }

  @Override
  public By RISK_ADDRESS_HOUSE_IDENTIFIER() {
    return By.xpath("//label[text()=\"Building Name or Number\"]/following::input[1]");
  }

  @Override
  public By RISK_ADDRESS_FIND_POSTCODE() {
    return By.cssSelector("[id=\"policyDataGatherForm:addressSearch\"]");
  }

  @Override
  public By NUM_BATHROOM() {
    return By.xpath("//label[text()=\"Number of " + "bathrooms/ensuites\"]/following::select[1]");
  }

  @Override
  public By NUM_BEDROOM() {
    return By.xpath("//label[text()=\"Number of " + "Bedrooms\"]/following::select[1]");
  }

  @Override
  public By YEAR_BUILT() {
    return By.xpath("//label[text()=\"Year Built\"]/following::input[1]");
  }

  @Override
  public By BUILDING_WORK() {
    return By.xpath("(//label[text()=\"Any building work?\"]/following::label[normalize-space" +
        "(text())=\"<variable>\"])[1]");
  }

  @Override
  public By PROPERTY_FURNISHED() {
    return By.xpath("//label[text()=\"Is the property furnished?\"]/following::input" +
        "[<variable>]");
  }

  @Override
  public By LET_SUBLET() {
    return By.xpath("(//label[text()=\"Is the property " +
        "let/sublet?\"]/following::label[normalize-space(text())=\"<variable>\"])[1]");
  }

  @Override
  public By GOOD_REPAIR() {
    return By.xpath("(//label[text()=\"In good repair?\"]/following::label[normalize-space(text()" +
        ")=\"<variable>\"])[1]");
  }

  @Override
  public By EXTENDED_HOME() {
    return By.xpath("//label[text()=\"Has the property been extended?\"]/following::select[1]");
  } //Has the property been extended?

  @Override
  public By OWNERSHIP_TYPE() {
    return By.xpath("//label[text()=\"Ownership Type\"]/following::select[1]");
  }

  @Override
  public By RESIDENCY_TYPE() {
    return By.xpath("//label[text()=\"Residency type\"]/following::select[1]");
  }

  @Override
  public By PRIMARY_RESIDENCY_TYPE() {
    return By.xpath("(//label[text()=\"Primary Residence?\"]/following::label[normalize-space" +
        "(text())=\"<variable>\"])[1]");
  }

  @Override
  public By BUILDING_WORK_END_DATE() {
    return By.xpath("//label[text()=\"End " + "Date\"]/following::input[1]");
  }

  @Override
  public By PROPERTY_UNOCCUPIED_DURING_WORK() {
    return By.xpath("//label[text()=\"Will property be " + "unoccupied for duration of the " +
        "works?\"]/following::input[<variable>]");
  }

  @Override
  public By HAS_JCT_SIGNED() {
    return By.xpath("//label[text()=\"Has JCT been " + "signed?\"]/following::input[<variable>]");
  }

  @Override
  public By OCCUPANCY_TYPE() {
    return By.xpath("//label[text()=\"Occupancy Type\"]/following::select[1]");
  }

  @Override
  public By LODGER_OCCUPANCY_TYPE() {
    return By.xpath("//label[text()=\"Type of Occupancy\"]/following::select[1]");
  }

  @Override
  public By PROPERTY_LEFT_OCCUPIED() {
    return By.xpath("//label[text()=\"How long is the property " + "left unoccupied?\"]/following"
        + "::select[1]");
  }

  @Override
  public By BUSINESS_USE() {
    return By.xpath("//*[@id=\"policyDataGatherForm:sedit_PreconfigBusinessConductedQuestionAnswer_yesNoAnswer:<variable>\"]");
  }

  @Override
  public By CLERICAL_USE(){
    return By.xpath("//*[@id=\"policyDataGatherForm:sedit_AgeaBusinessUseClericalQuestionAnswer_yesNoAnswer:<variable>\"]");
  }
  @Override
  public By PROPERTY_USE(){
      return By.xpath("//*[@id=\"policyDataGatherForm:sedit_AgeaPropertyUsedForQuestionAnswer_otherAnswer\"]");
  }
  @Override
  public By DOOR_WINDOW_LOCKS() {
    return By.xpath("(//label[text()=\"Door/Window Locks\"]/following::label[normalize-space" +
        "(text" + "())=\"<variable>\"])[1]");
  }

  @Override
  public By ALARM() {
    return By.xpath("//label[text()=\"Is an intruder alarm " + "installed?\"]/following::select[1"
        + "]");
  }

  @Override
  public By NEIGHBOURHOOD_WATCH() {
    return By.xpath("(//label[text()=\"Neighbourhood Watch\"]/following::label[normalize-space" + "(text())=\"<variable>\"])[1]");
  }

  @Override
  public By NON_FAMILY_LODGER() {
    return By.xpath("(//label[text()=\"Non Family Lodgers\"]/following::label[normalize-space" +
        "(text())=\"<variable>\"])[1]");
  }

  @Override
  public By NUM_ADULTS() {
    return By.xpath("//label[text()=\"How many adults live in the " + "property?\"]/following" +
        "::select[1]");
  }

  @Override
  public By NUM_CHILD() {
    return By.xpath("//label[text()=\"How many children live in the " + "property?\"]/following" + "::select[1]");
  }

  @Override
  public By PET_DETAILS() {
    return By.xpath("//label[text()=\"Do you have a pet living at the " + "property?\"]/following"
        + "::select[1]");
  }

  @Override
  public By BUILDING_TYPE() {
    return By.xpath("//label[text()=\"Building Type\"]/following::select[1]");
  }

  @Override
  public By TYPE_OF_HOUSE() {
    return By.xpath("//label[text()=\"What type of House is it?\"]/following::select[1]");
  }

  @Override
  public By STRUCTURE_TYPE() {
    return By.xpath("//label[text()= \"Building Type\"]/following::label[contains(text(),\"What " + "type of\")][1]/following::select[@class=\" required\"]");
  }

  @Override
  public By TYPE_OF_BUNGLOW() {
    return By.xpath("//label[text()=\"What type of Bungalow is it?\"]/following::select[1]");
  }

  @Override
  public By TYPE_OF_TOWN_HOUSE() {
    return By.xpath("//label[text()=\"What type of Town House is it?\"]/following::select[1]");
  }

  @Override
  public By TYPE_OF_FLAT() {
    return By.xpath("//label[text()=\"What type of Flat is it?\"]/following::select[1]");
  }

  @Override
  public By FREE_FROM_FLOODING() {
    return By.xpath("(//label[text()=\"Free from flooding?\"]/following::label[normalize-space" + "(text())=\"<variable>\"])[1]");
  }

  @Override
  public By STANDARD_CONSTRUCTION() {
    return By.xpath("(//label[text()=\"Is your home built of standard " + "construction" +
        "?\"]/following::label[normalize-space(text())=\"<variable>\"])[1]");
  }

  @Override
  public By ROOF_CONSTRUCTION() {
    return By.xpath("//label[text()=\"Type of Roof Construction\"]/following::select[1]");
  }

  @Override
  public By GEOLOGICAL_STATUS() {
    return By.xpath("(//label[contains(text(),\"subsidence, heave, landslip\")" + "]/following" +
        "::label[normalize-space(text())=\"<variable>\"])[1]");
  }

  @Override
  public By HOME_LISTED() {
    return By.xpath("(//label[contains(text(),\"home a listed building?\")" + "]/following::label" +
        "[normalize-space(text())=\"<variable>\"])[1]");
  }

  @Override
  public By HOME_LISTED_STATUS() {
    return By.xpath("//label[text()=\"Listed Status\"]/following::select[1]");
  }

  @Override
  public By WALL_CONSTRUCTION() {
    return By.xpath("//label[text()=\"Type of Wall Construction\"]/following::select[1]");
  }

  @Override
  public By PERCENTAGE_FLAT_ROOF() {
    return By.xpath("//label[contains(text(),\"percentage of your roof\")]/following::select[1]");
  }

  @Override
  public By ADD_CLAIM() {
    return By.cssSelector("[value=\"Add Claim\"]");
  }

  @Override
  public By INCIDENT_DATE() {
    return By.xpath("//label[text()=\"Incident Date\"]/following::input[1]");
  }

  @Override
  public By INCIDENT_SOURCE() {
    return By.xpath("//label[text()=\"Incident Source\"]/following::select[1]");
  }

  @Override
  public By CLAIM_STATUS() {
    return By.xpath(" //label[text()=\"Status\"]/following::select[1]");
  }

  @Override
  public By CLAIM_TYPE() {
    return By.xpath("//label[text()=\"Claim Type\"]/following::select[1]");
  }

  @Override
  public By CLAIM_CAUSE() {
    return By.xpath("//label[text()=\"Cause\"]/following::select[1]");
  }

  @Override
  public By CLAIM_COST() {
    return By.xpath("//label[text()=\"Claim Cost\"]/following::input[1]");
  }

  @Override
  public By CLAIM_NUMBER() {
    return By.xpath("//label[text()=\"Claim Number\"]/following::input[1]");
  }

  @Override
  public By CLAIM_OK_BUTTON() {
    return By.xpath("//input[@value=\"Ok\"]");
  }

  @Override
  public By SUFFERED_LOSS_NOT_RESULTED_IN_CLAIM() {
    return By.xpath("(//label[contains(text(),\"suffered losses or incidents which did not " +
        "result" + " in a claim\")]/following::label[normalize-space(text())=\"<variable>\"])[1]");
  }

  @Override
  public By BUILDING_ACCIDENTAL_DAMAGE_COVER() {
//    return By.xpath("//label[contains(text(), \"accidental damage cover on your buildings?\")" +
//        "]/following::input[<variable>]");

    return By.xpath("(//label[contains(text(),\"accidental damage cover on your buildings?\")" +
            "]/following::label[normalize-space(text())=\"<variable>\"])[1]");
  }

  @Override
  public By BUILDING_CLAIM_FREE_YEARS() {
    return By.xpath("//label[contains(text(), \"buildings claim free years have you had?\")" +
        "]/following::input[1]");
  }

  @Override
  public By BUILDING_VOLUNTARY_EXCESS() {
    return By.xpath("//label[contains(text(), \"Building Vol XS\")]/following::select[1]");
  }

  @Override
  public By REBUILDING_COST() {
    return By.xpath("//label[contains(text(), \"Rebuild cost\")]/following::input[1]");
  }

  @Override
  public By CONTENT_ACCIDENTAL_DAMAGE_COVER() {
    return By.xpath("(//label[contains(text(),\"accidental damage cover on your contents?\")" +
        "]/following::label[normalize-space(text())=\"<variable>\"])[1]");
  }

  @Override
  public By CONTENT_CLAIM_FREE_YEARS() {
    return By.xpath("//label[contains(text(), \"contents claim free years\")]/following::input[1]");
  }

  @Override
  public By CONTENTS_SUM_INSURED() {
    return By.xpath("//label[contains(text(), \"Contents Sum Insured\")]/following::input[1]");
  }

  @Override
  public By CONTENT_VOLUNTARY_EXCESS() {
    return By.xpath("//label[contains(text(), \"Contents Vol XS\")]/following::select[1]");
  }

  @Override
  public By SAFE_INSTALLED() {
    return By.xpath("(//label[contains(text(),\"Safe installed\")" + "]/following::label" +
        "[normalize-space(text())=\"<variable>\"])[1]");
  }

  @Override
  public By COVER_FOR_OTHER_UNSPECIFIED_ITEMS() {
    return By.xpath("//*[@id=\"policyDataGatherForm:sedit_AgeaHomeContentCoverOptions_coverForOtherUnspecifiedItemsInd:<variable>\"]");
  }

  @Override
  public By UNSPECIFIED_ITEMS_AMOUNT() {
    return By.xpath("//*[@id=\"policyDataGatherForm:sedit_AgeaHomeContentCoverOptions_unspecifiedItemsAmount\"]");
  }

  @Override
  public By VALUABLES_IN_HOME() {
    return By.xpath("//label[contains(text(), \"specify any valuables in the home?\")" +
        "]/following::label[normalize-space(text()) =\"<variable>\"][1]");
  }

  @Override
  public By VALUABLE_ITEMS() {
    return By.xpath("//label[text()=\"Specified Item\"]/following::select[1]");
  }

  @Override
  public By VALUABLE_ITEMS_DESCRIPTION() {
    return By.xpath("//label[text()=\"Item Description\"]/following::input[1]");
  }

  @Override
  public By VALUABLE_ITEMS_VALUE() {
    return By.xpath("//label[text()=\"Value of the Specified Item\"]/following::input[1]");
  }

  @Override
  public By VALUABLES_AWAY_HOME() {
    return By.xpath("//label[contains(text(), \"valuables away from home?\")" + "]/following" +
        "::label[normalize-space(text()) =\"<variable>\"][1]");
  }


//  @Override
//  public By VALUABLE_AWAY_HOME_ITEMS(){
//    return By.xpath("//label[text()=\"Specified Item\"]/following::select[1]");
//  }
//  @Override
//  public By VALUABLE_AWAY_HOME_ITEMS_DESCRIPTION(){
//    return By.xpath("//label[text()=\"Item Description\"]/following::input[1]");
//  }
//  @Override
//  public By VALUABLE_AWAY_HOME_ITEMS_VALUE(){
//    return By.xpath("//label[text()=\"Value of the Specified Item\"]/following::input[1]");
//  }

  @Override
  public By OK_BUTTON_VALUABLE_SECTION() {
    return By.cssSelector("[value=\"Ok\"]");
  }

  @Override
  public By ADD_ITEMS() {
    return By.cssSelector("[value=\"Add\"]");
  }

  @Override
  public By BICYCLE_AWAY_HOME() {
    return By.xpath("//label[contains(text(), \"Bicycles away from home?\")" + "]/following" +
        "::label[normalize-space(text()) =\"<variable>\"][1]");
  }

  @Override
  public By BICYCLE_DESCRIPTION() {
    return By.xpath("//label[text()=\"Bicycle Description\"]/following::input[1]");
  }

  @Override
  public By VALUE_OF_BICYCLE() {
    return By.xpath("//label[text()=\"Value of the Specified Item\"]/following::input[1]");
  }

  @Override
  public By CALCULATE_PREMIUM() {
    return By.cssSelector("[value=\"Calculate Premium\"]");
  }

  @Override
  public By CONSENT_TO_RENEW() {
    return By.xpath("(//label[text()=\"Consent to Renew\"])[2]/following::label[normalize-space" + "(text())=\"<variable>\"]");
  }

  @Override
  public By PURCHASE_POLICY() {
    return By.xpath("(//input[@value=\"Purchase\"])[2]");
  }

  @Override
  public By CONFIRMATION_PURCHASE_POLICY() {
    return By.xpath("//input[@id=\"policyDataGatherForm:okBtn\"]");
  }


  // PAYMENT
  @Override
  public By CARD_BELONGS_TO_POLICY_HOLDER() {
    return By.xpath("//label[contains(text(),\"belong to the policyholder?\")" + "]/following" +
        "::label[normalize-space(text())=\"<variable>\"]");
  }

  @Override
  public By PERMISSION_TO_STORE_CARD() {
//    return By.xpath("//label[contains(text(),\"Does the cardholder give permission\")" +
    return By.xpath("//label[contains(text(),\" give permission\")" +
        "]/following::label[normalize-space(text())=\"<variable>\"]");
  }

  @Override
  public By POLICY_AMOUNT_REQUIRED_FIELD() {
    return By.cssSelector("[name=\"purchaseForm" +
        ":downpaymentComponent_minimumRequiredAmount_disabled\"]");
  }

  @Override
  public By AMOUNT_COL() {
    return By.xpath("//tbody[@id=\"purchaseForm:downpaymentComponent_PaymentDetailsTable:tb" +
        "\"]/tr[<variable>]/td[2]/input");
  }

  @Override
  public By ALL_AMOUNT_COL() {
    return By.xpath("//tbody[@id=\"purchaseForm:downpaymentComponent_PaymentDetailsTable:tb\"]/tr" +
        "/td[2]");
  }

  @Override
  public By TAKE_PAYMENT() {
    return By.cssSelector("[id=\"purchaseForm:takePaymentPopupBtn\"]");
  }

  @Override
  public By ADD_PAYMENT_METHOD() {
    return By.cssSelector("[id=\"purchaseForm:addPaymentMethodBtn\"]");
  }

  @Override
  public By PAYMENT_METHOD() {
    return By.cssSelector("[id=\"paymentMethodTypeFormSwitch:paymentMethodType\"]");
  }

  @Override
  public By CARD_TYPE() {
    return By.cssSelector("[id=\"paymentMethodForm:generalPaymentMethod_displayType\"]");
  }

  @Override
  public By CARD_NUMBER() {
    return By.cssSelector("[name=\"paymentMethodForm:generalPaymentMethod_fullNumber\"]");
  }

  @Override
  public By CARD_USER_NAME() {
    return By.cssSelector("[name=\"paymentMethodForm:generalPaymentMethod_fullName\"]");
  }

  @Override
  public By CARD_EXPIRY_MONTH() {
    return By.cssSelector("[id=\"paymentMethodForm:expMonth\"]");
  }

  @Override
  public By CARD_EXPIRY_YEAR() {
    return By.cssSelector("[id=\"paymentMethodForm:expYear\"]");
  }

  @Override
  public By ADD_UPDATE_CARD_DETAILS() {
    return By.cssSelector("[id=\"paymentMethodForm:saveBtn\"]");
  }

  @Override
  public By BACK_BUTTON() {
    return By.cssSelector("[id=\"primaryButtonsForm:backButton_footer\"]");
  }

  @Override
  public By CREDIT_CARD_AMOUNT() {
//    return By.xpath("//input[contains(@value,\"Credit Card Visa ****\")]/following::input[1]");
    return By.xpath("//input[contains(@value,' Card')]/following::input[1]");
  }

  @Override
  public By CHEQUE_AMOUNT() {
    return By.xpath("//input[contains(@value,\"Cheque\")]/following::input[1]");
  }

  @Override
  public By CHEQUE_REFERENCE_NUM() {
    return By.xpath("//input[contains(@value,\"Cheque\")]/following::input[2]");
  }

  @Override
  public By CREDIT_CARD_REFERENCE() {
//    return By.xpath("//input[contains(@value,\"Credit Card Visa ****1111\")]/following::input[2]");
//    return By.xpath("//input[contains(@value,\"Credit Card Visa ****\")]/following::input[2]");
    return By.xpath("//input[contains(@value,' Card')]/following::input[2]");
  }

  @Override
  public By AMOUNT_REMAINING_DUE() {
    return By.xpath("//span[text()=\"Total Remaining " + "Due:\"]/following::span[1]");
  }

  @Override
  public By FINISH_PAYMENT() {
    return By.xpath("(//span[text()=\"Finish\"])[2]");
  }

  @Override
  public By CONFIRM_PAYMENT() {
//    return By.cssSelector("[name=\"purchaseForm:depositPaymentConfirmation_ok\"]");
//    return By.xpath("//*[contains(name(), 'depositPaymentConfirmation')]");
    return By.xpath("//button[contains(@name, 'depositPaymentConfirmation')]");


  }

  @Override
  public By CONFIRM_PAYMENT_NEW() {
    return By.cssSelector("[name=\"purchaseForm:depositPaymentConfirmationQuick_ok\"]");
  }

  @Override
  public By PAYMENT_SUCCESSFUL_OK() {
    return By.cssSelector("[name=\"purchaseForm" + ":depositPaymentValidateStatuId_close\"]");
  }

  @Override
  public By POLICY_NUMBER_VAR() {
    return By.xpath("//a[contains(@id,\"policyNumber\")]");
  }

  @Override
  public By QUOTE_REF_NUMBER() {
    return By.xpath("//label[contains(text(), \"Quote\")" + "]/following::span[1]");
  }

  @Override
  public By POLICY_EFFECTIVE_DATE() {
    return By.xpath("//label[text()=\"Effective " + "Date:\"]/following::span[1]");
  }

  @Override
  public By ENDORSEMENT_CLOSE() {
    return By.xpath("//input[@value=\"Close\"]");
  }

  @Override
  public By ENDORSEMENT_CODE() {
    return By.xpath("//tbody[@id=\"policyDataGatherForm" +
        ":availableTable_AgeaHomeManualEndorsementsFormManager:tb\"]/tr[<variable>]/td[1]/span");
  }

  @Override
  public By ENDORSEMENT_LIST() {
    return By.xpath("//tbody[@id=\"policyDataGatherForm" +
        ":availableTable_AgeaHomeManualEndorsementsFormManager:tb\"]/tr/td[2]/span");
  }

  @Override
  public By ADD_ENDORSEMENT() {
    return By.xpath("//tbody[@id=\"policyDataGatherForm" +
        ":availableTable_AgeaHomeManualEndorsementsFormManager:tb\"]/tr[<variable>]/td[2]/span" + "/following::a[1]");
  }

  @Override
  public By QUOTE_REF_VALUE() {
    return By.xpath("//strong[normalize-space(text())=\"Total Selling " + "Price\"]/following::td" +
        "[1]");
  }

  @Override
  public By POLICY_NUMBER() {
    return By.xpath("//span[text() =\"<variable>\"]/parent::a");
  }

  @Override
  public By COVERAGE_AND_PREMIUM_TAB() {
    return By.xpath("//span[contains(text(),\"Coverages\")]/parent::a");
  }

  @Override
  public By CUSTOMER_NUMBER() {
    return By.xpath("//label[text()=\"Customer#:\"]/following::span[1" + "]");
  }

  @Override
  public By POLICY_STATUS() {
    return By.xpath("//label[text()=\"Status:\"]/following::span[1]");
  }

  @Override
  public By POLICY_ID() {
    return By.xpath("//label[contains(normalize-space(text())," + "\"Policy\")]/following::span[1" +
        "]");
  }

  @Override
  public By OPTIONAL_EXTRAS_CODE_YES_ANSWER() {
    return By.xpath("//tbody[contains(@id," + "\"optionalExtraExcessTable\")]//td[normalize-space" +
        "(text())=\"<variable>\"]/parent::tr[1]/td[4]//label[normalize-space(text())=\"Yes\"]");
  }

  @Override
  public By ALL_OPTIONAL_EXTRAS_CODE() {
    return By.xpath("//tbody[contains(@id," + "\"optionalExtraExcessTable\")]/tr/td[1]");
  }

  @Override
  public By OPTIONAL_EXTRAS_DESC() {
    return By.xpath("//tbody[contains(@id," + "\"optionalExtraExcessTable\")" +
        "]/tr[<variable>]/td[2]");
  }

  @Override
  public By OPEX_OK_BUTTON() {
    return By.cssSelector("[value=\"Ok\"][id=\"policyDataGatherForm:okBtn\"]");
  }

}

package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import UiWrappers.Browser;
import helpers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import sqc.bstof.operationhelp.interactive.RobustnessHelp;

import java.text.ParseException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;


public class PerformMTAStepDefinition extends AgeasDigitalReactPortalHelpers {

    private String MAIN_POLICY_HOLDER = "MainPolicyHolder";
    private String JOINT_POLICY_HOLDER = "JointPolicyHolder";
    private String HOME_POLICY_COVER = "HomePolicyCover";
    private String HOME_POLICY_ADDRESS = "HomePolicyAddress";
    private String PERSONAL_DETAILS = "PersonalDetails";
    private String MTATYPE = "MTAType";
    private String TITLE = "Title";
    private String FIRSTNAME = "FirstName";
    private String LASTNAME = "LastName";
    private String MARITALSTATUS = "MaritalStatus";
    private String DATEOFBIRTH = "DateOfBirth";
    private String EMPLOYMENTSTATUS = "EmploymentStatus";
    private String PRIMARYEMPLOYMENTSTATUS = "PrimaryEmploymentStatus";
    private String SECONDARYEMPLOYMENTSTATUS = "SecondaryEmploymentStatus";
    private String EMPLOYED = "Employed";
    private String CATEGORY = "Category";
    private String TYPE = "Type";
    private String INDUSTRY = "Industry";
    private String RELATIONSHIP = "Relationship";
    private String ACTION = "Action";
    private String PREMIUM_AMOUNT = null;
    private String BUILDING_COVER = "BuildingCover";
    private String BUILDING_COVER_AMOUNT = "BuildingCoverAmount";
    private String ACCIDENTAL_COVER = "AccidentalCover";
    private String BUILDING_VOLUNTARY_EXCESS = "BuildingVoluntaryExcess";
    private String RISK_ADDRESS = "RiskAddress";
    private String HOUSE_IDENTIFIER = "HouseIdentifier";
    private String POSTCODE = "Postcode";
    private String CONTENTS_COVER = "ContentsCover";
    private String CONTENT_COVER_WITHIN_TWO_YEARS = "ContentCoverWithin2Years";
    private String CLAIM_FREE_YEARS = "ClaimFreeYears";
    private String CONTENT_COVER_AMOUNT = "ContentCoverAmount";
    private String MOVE_IN_DAYS = "MoveInDays";
    private String CONTENT_VOLUNTARY_EXCESS = "ContentVoluntaryExcess";
    private String PERSONAL_BELONGING_AWAY_FROM_HOME="PersBelongAwayFromHomCoverChange";
    private String PERSONAL_BELONGING_AWAY_FROM_HOME_AMOUNT = "PersBelongingCoverAmount";
    private String OPEX = "OPEX";
    private String OPEX_COVER = "OpexCover";
    private String EXCESS_PROTECTION = "ExcessProtection";
    private String HOME_EMERGENCY = "HomeEmergency";
    private String LEGAL_EXPENSES = "LegalExpenses";
    private String MTA_EFFECTIVE_DATE = "MtaEffectiveDate";
    private String EMC_OPEX_MTA_PREMIUM_AMOUNT = "PremiumAmount";

    private String PROPERTY_DETAILS = "PropertyDetails";
    private String INSURED_ADDRESS_DETAILS = "InsuredAddressDetails";
    private String IPD_NUMBER_OF_BEDROOMS = "NoOfBedrooms";
    private String IPD_NUMBER_OF_BATHROOMS = "NoOfBathrooms";
    private String IPD_NUMBER_OF_ADULTS_AT_PROPERTY = "NoOfAdultsAtProperty";
    private String IPD_NUMBER_OF_CHILDREN_AT_PROPERTY = "NoOfChildrenAtProperty";
    private String IPD_OWNER_RENT_STATUS = "OwnerOrRentStatus";
    private String IPD_OWNED_ON_MORTGAGE = "OwnedOnMortgage";
    private String IPD_MTA_PREMIUM_AMOUNT = "PremiumAmount";
    private String IPD_HOME_EXTENDED  = "HasYourHomeBeenExtended";
    private String IPD_HOME_LISTED_BUILDING  = "IsYourHomeAListedBuilding";
    private String IPD_WHEN_IS_YOUR_HOME_OCCUPIED  = "WhenIsYourHomeNormallyOccupied";
    private String IPD_PROPERTY_TYPE  = "PropertyType";
    private String IPD_HOME_FITTED_WITH_DEAD_LOCKS  = "IsYourHomeFittedWithDeadlocksOrLockingSystem";
    private String IPD_WHAT_BEST_DESCRIBES_YOUR_HOME = "WhatBestDescribesYourHome";
    private String IPD_INTRUDER_ALARM = "IntruderAlarm";
    private String IPD_STANDARD_CONSTRUCTION = "StandardConstruction";
    private String IPD_PETS_AT_PROPERTY = "PetsAtProperty";
    private String IPD_DO_YOU_HAVE_ANY_PAYING_GUESTS = "DoYouHaveAnyPayingGuests";
    private String IPD_USED_FOR_BUSINESS = "PartOfHomeUsedForBusinessPurposes";
    private String IPD_WHAT_BEST_DESCRIBES_YOUR_HOME_DETACHED = "Detached";
    private String IPD_WHAT_BEST_DESCRIBES_YOUR_HOME_SEMIDETACHED = "Semi-Detached";
    private String IPD_WHAT_BEST_DESCRIBES_YOUR_HOME_ENDOFTERRACED = "End Terraced House";
    private String IPD_WHAT_BEST_DESCRIBES_YOUR_HOME_MIDTERRACED = "Mid-Terraced House";
    private String IPD_INTRUDER_ALARM_BASICDIYALARM = "Basic DIY Alarm";
    private String IPD_INTRUDER_ALARM_TELEPHONELINK = "Telephone Link";
    private String IPD_INTRUDER_ALARM_APPROVEDANDMAINTAINEDALARM = "Approved and Maintained Alarm";
    private String IPD_INTRUDER_ALARM_NO = "No";
    private String IPD_PETS_AT_PROPERTY_NO = "No";
    private String IPD_PETS_AT_PROPERTY_CATS = "Yes - Cats";
    private String IPD_PETS_AT_PROPERTY_CATSANDDOGS = "Yes - Cats and Dogs";
    private String IPD_PETS_AT_PROPERTY_DOGS = "Yes - Dogs";
    private String IPD_PETS_AT_PROPERTY_OTHER = "Yes - Other";
    private String IPD_DO_YOU_HAVE_ANY_PAYING_GUESTS_NO = "No";
    private String IPD_DO_YOU_HAVE_ANY_PAYING_GUESTS_LODGERS = "Yes - Lodgers";
    private String IPD_DO_YOU_HAVE_ANY_PAYING_GUESTS_STUDENTS = "Yes - Students";
    private String IPD_DO_YOU_HAVE_ANY_PAYING_GUESTS_STUDENTANDLODGERS = "Yes - Students & Lodgers";

    private final long waitDuration = 10000L;

    private final PortalGeneralStepDefinitions portalGeneralStepDefinition;
    private final Browser mBrowser;

    public PerformMTAStepDefinition(Browser pBrowser, PageObjects.PortalModel.Root pageObjectOfPortal) {
        super(pBrowser.Wd(), pageObjectOfPortal);
        mBrowser = pBrowser;
        this.portalGeneralStepDefinition = new PortalGeneralStepDefinitions(this.getCurrentWebDriverInstance(), pageObjectOfPortal);
    }

    public Map<String, Object> performMTA(String policyNumber, Map<String, Object> mtaToChange, String effectiveDate) throws CustomE2eException, ParseException {
        SortedMap<String, Object> myDetails;
        List<String> homeMTABeforeFormatting = null;
        Map<String, Object> returnData = null;
        if (policyNumber.trim().startsWith("HE")||(policyNumber.trim().startsWith("HH"))) {
            isElementVisible(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_HOME_TAB());
            redirectToHomeTab();
            portalGeneralStepDefinition.selectPolicyFromDropDown(policyNumber);

            // Based on MTA type navigate to perform change
            String mtaType = (String) mtaToChange.get(MTATYPE);

            if (mtaType.equalsIgnoreCase("MainPolicyHolder") ||
                    mtaType.equalsIgnoreCase("JointPolicyHolder") ||
                    mtaType.equalsIgnoreCase("InsuredAddressDetails")) {
                editPersonalDetailsInHomeTab();
                importantInformationPage();
                selectEffectiveDate(effectiveDate);
                if (isElementEnabled(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EFFECTIVE_BTN())) {
                    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EFFECTIVE_BTN(), SyncType.CLICKABLE);
                    // var effectiveDate = getSelectedValueFromDropDown(this.pageObjectOfPortal.getPerformMTALocatorModel().EFFECTIVE_DATE_SELECTION());
                    if (mtaType.equalsIgnoreCase("MainPolicyholder")) {
                        returnData = editPolicyHolderDetails(mtaToChange);
                        waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().SUBMIT_EDIT_POLICYHOLDER_BUTTON(), SyncType.VISIBLE, waitDuration);
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().SUBMIT_EDIT_POLICYHOLDER_BUTTON(), SyncType.CLICKABLE);
                        waitForPageLoad();
                        waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EDIT_BUTTON(), SyncType.VISIBLE, waitDuration);
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EDIT_BUTTON(), SyncType.CLICKABLE);
                        waitForPageLoad();
                    // needs to end up on confirm your changes page
                    } else if (mtaType.equalsIgnoreCase("JointPolicyholder")) {
                        returnData = jointPolicyHolderDetails(mtaToChange);
                        waitForPageLoad();
                        premiumAmountAfterMTA(returnData);
                    } else if (mtaType.equalsIgnoreCase("InsuredAddressDetails")) {
                        returnData = new HashMap<>();
                        if (isElementEnabled(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_CONTINUE_BUTTON())) {
                            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EDIT_INSURED_PROPERTY_ADDRESS(), SyncType.CLICKABLE);
                            waitForPageLoad();
                            editInsuredAddressDetails(mtaToChange);
                            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_SAVE_BUTTON(), SyncType.CLICKABLE);
                            waitForPageLoad();
                            waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_CONTINUE_BUTTON(), SyncType.VISIBLE, waitDuration);

                            //clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_CONTINUE_BUTTON(), SyncType.CLICKABLE);
                            waitForPageLoad();
                            premiumAmountAfterMTA(returnData);
                        }
                    }

                    //waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_SUMMARY_CHANGE_BUTTON(), SyncType.VISIBLE, waitDuration);
                    PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(120), ()->
                            clickElement(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_SUMMARY_CHANGE_BUTTON(), SyncType.CLICKABLE));
                    //clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_SUMMARY_CHANGE_BUTTON(), SyncType.CLICKABLE);

                }
            } else if (mtaType.equalsIgnoreCase("HomeCover")) {
                editCoverInHomeTab();
                importantInformationPage();
                selectEffectiveDate(effectiveDate);
                if (isElementEnabled(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EFFECTIVE_BTN())) {
                    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EFFECTIVE_BTN(), SyncType.CLICKABLE);

                    returnData = editHomePolicyCoverDetails(mtaToChange);
                    waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EDIT_BUTTON(), SyncType.VISIBLE, waitDuration);
                    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EDIT_BUTTON(), SyncType.CLICKABLE);
                    waitForPageLoad();
                    premiumAmountAfterMTA(returnData);
                    waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_SUMMARY_CHANGE_BUTTON(), SyncType.VISIBLE, waitDuration);
                    PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300), ()->
                            clickElement(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_SUMMARY_CHANGE_BUTTON(), SyncType.CLICKABLE));
                }
            } else if (mtaType.equalsIgnoreCase("HomeAddress")) {
                PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300), ()-> clickElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().MY_DETAILS_SECTION(), SyncType.CLICKABLE));
                myDetails =
                    portalGeneralStepDefinition.getDetails(this.pageObjectOfPortal.getPortalSharedLocatorModel().MY_DETAILS_FIELD_NAME_AND_VALUE());
                editMainPolicyHolderAddressInHomeTab();
                importantInformationPage();
                selectEffectiveDate(effectiveDate);
                if (isElementEnabled(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EFFECTIVE_BTN())) {
                    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EFFECTIVE_BTN(), SyncType.CLICKABLE);
                    returnData = editHomePolicyAddressDetails(myDetails, mtaToChange);
                    waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EDIT_BUTTON(), SyncType.VISIBLE, waitDuration);
                        isElementEnabled(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EDIT_BUTTON());
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EDIT_BUTTON(), SyncType.CLICKABLE);
                        waitForPageLoad();

                        premiumAmountAfterMTA(returnData);
                        //waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_SUMMARY_CHANGE_BUTTON(), SyncType.VISIBLE, waitDuration);
                        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300), ()->
                            clickElement(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_SUMMARY_CHANGE_BUTTON(), SyncType.CLICKABLE));


                }

                //premiumAmountAfterMTA(returnData);
                //PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300), ()->
                       // clickElement(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_SUMMARY_CHANGE_BUTTON(), SyncType.CLICKABLE));


            } else if (mtaType.equalsIgnoreCase("OPEX")) {
                returnData = new HashMap<>();
                PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300), ()->
                        clickElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().ENHANCE_MY_COVER_SECTION(), SyncType.CLICKABLE));
                //clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalSharedLocatorModel().ENHANCE_MY_COVER_SECTION(), SyncType.CLICKABLE);
                waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_MORE_BUTTON(), SyncType.CLICKABLE, waitDuration);
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_MORE_BUTTON()
                    , SyncType.CLICKABLE);
                waitForPageLoad();
                selectEffectiveDate(effectiveDate);
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_CONTINUE_BUTTON(), SyncType.CLICKABLE);
                var coverDetailsToChange = (Map<String, Object>) mtaToChange.get(OPEX_COVER);
                for (String opexItem : coverDetailsToChange.keySet()) {
                    if (opexItem.equalsIgnoreCase("HomeEmergency")) {
                        String mtaAction = ((Map<?, ?>) mtaToChange.get(OPEX_COVER)).get(HOME_EMERGENCY).toString();
                        if (mtaAction.toString().equalsIgnoreCase("yes") || String.valueOf(mtaAction).equalsIgnoreCase("true")) {
                            addOPEXInHomeTab(opexItem);
                            break;
                        }
                    } else  if (opexItem.equalsIgnoreCase("ExcessProtection")) {
                        String mtaAction = ((Map<?, ?>) mtaToChange.get(OPEX_COVER)).get(EXCESS_PROTECTION).toString();
                        if (mtaAction.toString().equalsIgnoreCase("yes") || String.valueOf(mtaAction).equalsIgnoreCase("true")) {
                            addOPEXInHomeTab(opexItem);
                            break;
                        }
                    }else if (opexItem.equalsIgnoreCase("LegalExpenses")) {
                        String mtaAction = ((Map<?, ?>) mtaToChange.get(OPEX_COVER)).get(LEGAL_EXPENSES).toString();
                        if (mtaAction.toString().equalsIgnoreCase("yes") || String.valueOf(mtaAction).equalsIgnoreCase("true")) {
                            addOPEXInHomeTab(opexItem);
                            break;
                        }
                    }
                }
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_CONTINUE_BUTTON(), SyncType.CLICKABLE);
                waitForPageLoad();
                //waitForElement(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_OPEX_MTA_PREMIUM(), SyncType.VISIBLE);
                var vPremiumAmount = PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300), ()->
                        getText(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_OPEX_MTA_PREMIUM()));
                returnData.put(EMC_OPEX_MTA_PREMIUM_AMOUNT,
                        vPremiumAmount);
                premiumAmountAfterMTA(returnData);

                waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_SUMMARY_CHANGE_BUTTON(), SyncType.VISIBLE, waitDuration);
                PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300), ()->
                        clickElement(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_SUMMARY_CHANGE_BUTTON(), SyncType.CLICKABLE));
                //clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_CONTINUE_BUTTON(), SyncType.CLICKABLE);
                //waitForElement(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_CONTINUE_BUTTON(), SyncType.CLICKABLE);
                waitForPageLoad();
            }
        }
        return returnData;
    }

    public void addOPEXInHomeTab(String keyName) throws CustomE2eException, ParseException {
            if (keyName.equalsIgnoreCase("ExcessProtection")) {
                    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_EXCESS_PROTECTION_YES(), SyncType.CLICKABLE);
                    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_ADD_EXCESS_PROTECTION(), SyncType.CLICKABLE);
                    if (isElementVisible(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_LEGAL_EXPENSES_NO())==true){
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_LEGAL_EXPENSES_NO(), SyncType.CLICKABLE);
                    }
                    if (isElementVisible(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_EXTRA_HOME_EMERGENCY_NO())==true){
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_EXTRA_HOME_EMERGENCY_NO(), SyncType.CLICKABLE);
                    }
            } else if (keyName.equalsIgnoreCase("HomeEmergency")) {
                    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_EXTRA_HOME_EMERGENCY_YES(), SyncType.CLICKABLE);
                    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_ADD_EXTRA_HOME_EMERGENCY(), SyncType.CLICKABLE);
                    if (isElementVisible(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_LEGAL_EXPENSES_NO())==true){
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_LEGAL_EXPENSES_NO(), SyncType.CLICKABLE);
                    }
                    if (isElementVisible(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_EXCESS_PROTECTION_NO())==true){
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_EXCESS_PROTECTION_NO(), SyncType.CLICKABLE);
                    }
            }else if (keyName.equalsIgnoreCase("LegalExpenses")) {
                    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_LEGAL_EXPENSES_YES(), SyncType.CLICKABLE);
                    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_ADD_LEGAL_EXPENSES(), SyncType.CLICKABLE);
                    if (isElementVisible(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_EXTRA_HOME_EMERGENCY_NO())==true){
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_EXTRA_HOME_EMERGENCY_NO(), SyncType.CLICKABLE);
                    }
                    if (isElementVisible(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_EXCESS_PROTECTION_NO())==true){
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EMC_EXCESS_PROTECTION_NO(), SyncType.CLICKABLE);
                    }
            } else {
                throw new CustomE2eException("No OPEX added");
            }
    }

    public void editPersonalDetailsInHomeTab() throws CustomE2eException {
        waitForPageLoad();
        //waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().EDIT_PERSONAL_DETAILS(), SyncType.CLICKABLE, waitDuration);
        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(30), ()->
                clickElement(this.pageObjectOfPortal.getPerformMTALocatorModel().EDIT_PERSONAL_DETAILS(), SyncType.CLICKABLE));
    }

    private void premiumAmountAfterMTA(Map<String, Object> returnData) throws CustomE2eException {
//        try {
//            //sleep(30000L);
//            waitForPageLoad();
//        } catch (InterruptedException e) {
//            waitForPageLoad();
//        }

        Map<String, Object> FinancialImpactAssessment = new HashMap<>();

        //SLC Rather than hard coded wait.. wait for log out to be clickable
        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300), ()->
                waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().SIGN_OUT_BUTTON(), SyncType.CLICKABLE, waitDuration));
        //Check on the confirm your changs page
        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300), ()->
                waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_SUMMARY_CHANGE_BUTTON(), SyncType.CLICKABLE, waitDuration));

        if (waitForElement2(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().ZERO_PREMIUM(), SyncType.VISIBLE, waitDuration)) {
            PREMIUM_AMOUNT = String.valueOf('0');
            returnData.put("asNumeric", Double.parseDouble(PREMIUM_AMOUNT));
            returnData.put("asString", PREMIUM_AMOUNT);
            FinancialImpactAssessment.put("Refund", false);
            FinancialImpactAssessment.put("Charge", String.valueOf('0'));


        } else if (waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().PREMIUM_AMOUNT(), SyncType.VISIBLE, waitDuration)) {
            PREMIUM_AMOUNT = getText(this.pageObjectOfPortal.getPerformMTALocatorModel().PREMIUM_AMOUNT());
            PREMIUM_AMOUNT = Formatting.getTextFromRegex(PREMIUM_AMOUNT, "[0-9]{1,3}.[0-9]{1,2}");
            returnData.put("asNumeric", Double.parseDouble(PREMIUM_AMOUNT));
            returnData.put("asString", PREMIUM_AMOUNT);
            FinancialImpactAssessment.put("Refund", false);
            FinancialImpactAssessment.put("Charge", Double.parseDouble(PREMIUM_AMOUNT));
        } else if (waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().REFUND_AMOUNT(), SyncType.VISIBLE, waitDuration)) {
            PREMIUM_AMOUNT = getText(this.pageObjectOfPortal.getPerformMTALocatorModel().REFUND_AMOUNT());
            PREMIUM_AMOUNT = Formatting.getTextFromRegex(PREMIUM_AMOUNT, "[0-9]{1,3}.[0-9]{1,2}");
            returnData.put("asNumeric", Double.parseDouble(PREMIUM_AMOUNT));
            returnData.put("asString", PREMIUM_AMOUNT);
            FinancialImpactAssessment.put("Refund", true);
            FinancialImpactAssessment.put("Charge", Double.parseDouble(PREMIUM_AMOUNT));
        } else {
            throw new CustomE2eException("Could not find result in expected form");
        }

        returnData.put("FinancialImpact", FinancialImpactAssessment);
    }

    private Map<String, Object> editInsuredAddressDetails(Map<String, Object> mtaToChange) throws CustomE2eException {
        Map<String, Object> returnData = null;
        Map<String, Object> mtaAction = (Map<String, Object>) ((Map<String, Object>) mtaToChange.get(PROPERTY_DETAILS)).get(INSURED_ADDRESS_DETAILS);
        for (String keyName : mtaAction.keySet()) {
            mtaToChange.keySet().toString();
            switch (keyName) {
                case "NoOfBedrooms":
                    ChangeNumberOfBedroomsForInsuredAddress(this.mBrowser, mtaAction.get(IPD_NUMBER_OF_BEDROOMS));
                    break;
                case "NoOfBathrooms":
                    ChangeNumberOfBathroomsForInsuredAddress(this.mBrowser, mtaAction.get(IPD_NUMBER_OF_BATHROOMS));
                    break;
                case "NoOfChildrenAtProperty":
                    ChangeNumberOfChildrenForInsuredAddress(this.mBrowser, mtaAction.get(IPD_NUMBER_OF_CHILDREN_AT_PROPERTY));
                    break;
                case "OwnerOrRentStatus":
                    Map<String, Object> insuredAddressDetailsOwnerOrRentStatus = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) mtaToChange.get(PROPERTY_DETAILS)).get(INSURED_ADDRESS_DETAILS));
                    String OwnerRentItem = insuredAddressDetailsOwnerOrRentStatus.get(IPD_OWNER_RENT_STATUS).toString();
                    switch (OwnerRentItem) {
                        case "Owned on Mortgage":
                            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_OWNER_RENT_STATUS_OWNED_ON_MORTGAGE(), SyncType.CLICKABLE);
                            break;
                        case "Privately Rented":
                            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_OWNER_RENT_STATUS_PRIVATELY_RENTED(), SyncType.CLICKABLE);
                            break;
                        case "Owned Outright":
                            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_OWNER_RENT_STATUS_OWNED_OUTRIGHT(), SyncType.CLICKABLE);
                            break;
                        case "Council Rented":
                            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_OWNER_RENT_STATUS_COUNCIL_RENTED(), SyncType.CLICKABLE);
                            break;
                        case "Housing Association":
                            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_OWNER_RENT_STATUS_HOUSING_ASSOCIATION(), SyncType.CLICKABLE);
                            break;
                    }
                    break;
                case "NoOfAdultsAtProperty":
                    ChangeNumberOfAdultsForInsuredAddress(this.mBrowser, mtaAction.get(IPD_NUMBER_OF_ADULTS_AT_PROPERTY));
                    break;
                case "HasYourHomeBeenExtended":
                    Map<String, Object> hasYourHomeBeenExtended = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) mtaToChange.get(PROPERTY_DETAILS)).get(INSURED_ADDRESS_DETAILS));
                    String HasYourHomeBeenExtendedItem = hasYourHomeBeenExtended.get(IPD_HOME_EXTENDED).toString();
                    if (HasYourHomeBeenExtendedItem.toString().equalsIgnoreCase("yes") || String.valueOf(HasYourHomeBeenExtendedItem).equalsIgnoreCase("true")) {
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_HOME_EXTENDED_YES(), SyncType.CLICKABLE);
                    } else if (HasYourHomeBeenExtendedItem.toString().equalsIgnoreCase("no") || String.valueOf(HasYourHomeBeenExtendedItem).equalsIgnoreCase("false")) {
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_HOME_EXTENDED_NO(), SyncType.CLICKABLE);
                    }
                    break;
                case "WhenIsYourHomeNormallyOccupied":
                    Map<String, Object> whenIsYourHomeNormallyOccupied = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) mtaToChange.get(PROPERTY_DETAILS)).get(INSURED_ADDRESS_DETAILS));
                    String WhenIsYourHomeNormallyOccupiedItem = whenIsYourHomeNormallyOccupied.get(IPD_WHEN_IS_YOUR_HOME_OCCUPIED).toString().trim();
                    switch (WhenIsYourHomeNormallyOccupiedItem) {
                        case "Day and Night":
                            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_WHEN_IS_YOUR_HOME_OCCUPIED_DAYANDNIGHT(), SyncType.CLICKABLE);
                            break;
                        case "During the Day":
                            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_WHEN_IS_YOUR_HOME_OCCUPIED_DURINGTHEDAY(), SyncType.CLICKABLE);
                            break;
                        case "During the Night":
                            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_WHEN_IS_YOUR_HOME_OCCUPIED_DURINGTHENIGHT(), SyncType.CLICKABLE);
                            break;
                        case "Unocupied":
                            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_WHEN_IS_YOUR_HOME_OCCUPIED_UNOCCUPIED(), SyncType.CLICKABLE);
                            break;
                    }
                    break;
                case "PropertyType":
                    Map<String, Object> propertyType = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) mtaToChange.get(PROPERTY_DETAILS)).get(INSURED_ADDRESS_DETAILS));
                    String PropertyTypeItem = propertyType.get(IPD_PROPERTY_TYPE).toString().trim();
                    switch (PropertyTypeItem) {
                        case "Bungalow":
                            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_PROPERTY_TYPE_BUNGALOW(), SyncType.CLICKABLE);
                            break;
                        case "House":
                            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_PROPERTY_TYPE_HOUSE(), SyncType.CLICKABLE);
                            break;
                        case "Town House":
                            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_PROPERTY_TYPE_TOWNHOUSE(), SyncType.CLICKABLE);

                            break;
                        case "Self-contained flat":
                            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_PROPERTY_TYPE_SELFCONTAINEDFLAT(), SyncType.CLICKABLE);
                            break;
                        case "Maisonette":
                            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_PROPERTY_TYPE_MAISONETTE(), SyncType.CLICKABLE);
                            break;
                    }
                    break;
                case "IsYourHomeFittedWithDeadlocksOrLockingSystem":
                    Map<String, Object> isYourHomeFittedWithDeadlocksOrLockingSystem = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) mtaToChange.get(PROPERTY_DETAILS)).get(INSURED_ADDRESS_DETAILS));
                    String IsYourHomeFittedWithDeadlocksOrLockingSystemItem = isYourHomeFittedWithDeadlocksOrLockingSystem.get(IPD_HOME_FITTED_WITH_DEAD_LOCKS).toString();
                    if (IsYourHomeFittedWithDeadlocksOrLockingSystemItem.toString().equalsIgnoreCase("yes") || String.valueOf(IsYourHomeFittedWithDeadlocksOrLockingSystemItem).equalsIgnoreCase("true")) {
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_HOME_FITTED_WITH_DEAD_LOCKS_YES(), SyncType.CLICKABLE);
                    } else if (IsYourHomeFittedWithDeadlocksOrLockingSystemItem.toString().equalsIgnoreCase("no") || String.valueOf(IsYourHomeFittedWithDeadlocksOrLockingSystemItem).equalsIgnoreCase("false")) {
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_HOME_FITTED_WITH_DEAD_LOCKS_NO(), SyncType.CLICKABLE);
                    }
                    break;
                case "WhatBestDescribesYourHome":
                    Map<String, Object> whatBestDescribesYourHome = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) mtaToChange.get(PROPERTY_DETAILS)).get(INSURED_ADDRESS_DETAILS));
                    String WhatBestDescribesYourHomeItem = whatBestDescribesYourHome.get(IPD_WHAT_BEST_DESCRIBES_YOUR_HOME).toString().trim();
                    switch (WhatBestDescribesYourHomeItem) {
                        case "Detached":
                            ChangeWhatBestDescribesYourHome(IPD_WHAT_BEST_DESCRIBES_YOUR_HOME_DETACHED);
                            break;
                        case "Semi-Detached":
                            ChangeWhatBestDescribesYourHome(IPD_WHAT_BEST_DESCRIBES_YOUR_HOME_SEMIDETACHED);
                            break;
                        case "End Terraced House":
                            ChangeWhatBestDescribesYourHome(IPD_WHAT_BEST_DESCRIBES_YOUR_HOME_ENDOFTERRACED);
                            break;
                        case "Mid-Terraced House":
                            ChangeWhatBestDescribesYourHome(IPD_WHAT_BEST_DESCRIBES_YOUR_HOME_MIDTERRACED);
                            break;
                    }
                    break;
                case "IntruderAlarm":
                    Map<String, Object> intruderAlarm = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) mtaToChange.get(PROPERTY_DETAILS)).get(INSURED_ADDRESS_DETAILS));
                    String IntruderAlarmItem = intruderAlarm.get(IPD_INTRUDER_ALARM).toString().trim();
                    switch (IntruderAlarmItem) {
                        case "Basic DIY Alarm":
                            ChangeIntruderAlarm(IPD_INTRUDER_ALARM_BASICDIYALARM);
                            break;
                        case "Telephone Link":
                            ChangeIntruderAlarm(IPD_INTRUDER_ALARM_TELEPHONELINK);
                            break;
                        case "Approved And Maintained Alarm":
                            ChangeIntruderAlarm(IPD_INTRUDER_ALARM_APPROVEDANDMAINTAINEDALARM);
                            break;
                        case "No":
                            ChangeIntruderAlarm(IPD_INTRUDER_ALARM_NO);
                            break;
                    }
                    break;
                case "PetsAtProperty":
                    Map<String, Object> petsAtProperty = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) mtaToChange.get(PROPERTY_DETAILS)).get(INSURED_ADDRESS_DETAILS));
                    String PetsAtPropertyItem = petsAtProperty.get(IPD_PETS_AT_PROPERTY).toString().trim();
                    switch (PetsAtPropertyItem) {
                        case "No":
                            ChangePetsAtProperty(IPD_PETS_AT_PROPERTY_NO);
                            break;
                        case "Yes - Cats":
                            ChangePetsAtProperty(IPD_PETS_AT_PROPERTY_CATS);
                            break;
                        case "Yes - Cats and Dogs":
                            ChangePetsAtProperty(IPD_PETS_AT_PROPERTY_CATSANDDOGS);
                            break;
                        case "Yes - Dogs":
                            ChangePetsAtProperty(IPD_PETS_AT_PROPERTY_DOGS);
                            break;
                        case "Yes - Other":
                            ChangePetsAtProperty(IPD_PETS_AT_PROPERTY_OTHER);
                            break;
                    }
                    break;
                case "DoYouHaveAnyPayingGuests":
                    Map<String, Object> doYouHaveAnyPayingGuests = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) mtaToChange.get(PROPERTY_DETAILS)).get(INSURED_ADDRESS_DETAILS));
                    String DoYouHaveAnyPayingGuestsItem = doYouHaveAnyPayingGuests.get(IPD_DO_YOU_HAVE_ANY_PAYING_GUESTS).toString().trim();
                    switch (DoYouHaveAnyPayingGuestsItem) {
                        case "No":
                            ChangeDoYouHaveAnyPayingGuests(IPD_DO_YOU_HAVE_ANY_PAYING_GUESTS_NO);
                            break;
                        case "Yes - Lodgers":
                            ChangeDoYouHaveAnyPayingGuests(IPD_DO_YOU_HAVE_ANY_PAYING_GUESTS_LODGERS);
                            break;
                        case "Yes - Students":
                            ChangeDoYouHaveAnyPayingGuests(IPD_DO_YOU_HAVE_ANY_PAYING_GUESTS_STUDENTS);
                            break;
                        case "Yes - Students & Lodgers":
                            ChangeDoYouHaveAnyPayingGuests(IPD_DO_YOU_HAVE_ANY_PAYING_GUESTS_STUDENTANDLODGERS);
                            break;
                    }
                    break;
                case "IsYourHomeAListedBuilding":
                    Map<String, Object> isYourHomeAListedBuilding = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) mtaToChange.get(PROPERTY_DETAILS)).get(INSURED_ADDRESS_DETAILS));
                    String IsYourHomeAListedBuildingItem = isYourHomeAListedBuilding.get(IPD_HOME_LISTED_BUILDING).toString().trim().toLowerCase();
                    if (IsYourHomeAListedBuildingItem.toString().equalsIgnoreCase("no") || String.valueOf(IsYourHomeAListedBuildingItem).equalsIgnoreCase("false")) {
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_HOME_LISTED_BUILDING_NO(), SyncType.CLICKABLE);
                    } else {
                        switch (IsYourHomeAListedBuildingItem) {

                            case "grade1":
                                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_HOME_LISTED_BUILDING_GRADE1(), SyncType.CLICKABLE);
                                break;
                            case "grade2":
                                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_HOME_LISTED_BUILDING_GRADE2(), SyncType.CLICKABLE);
                                break;
                            case "grade22", "grade2*":
                                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_HOME_LISTED_BUILDING_GRADE22(), SyncType.CLICKABLE);
                                break;
                        }
                    }
                    break;
                case "StandardConstruction":
                    Map<String, Object> isYourHouseBuiltFromStandardConstruction = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) mtaToChange.get(PROPERTY_DETAILS)).get(INSURED_ADDRESS_DETAILS));
                    String IsYourHouseBuiltFromStandardConstruction = isYourHouseBuiltFromStandardConstruction.get(IPD_STANDARD_CONSTRUCTION).toString();
                    if (IsYourHouseBuiltFromStandardConstruction.toString().equalsIgnoreCase("yes") || String.valueOf(IsYourHouseBuiltFromStandardConstruction).equalsIgnoreCase("true")) {
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_STANDARD_CONSTRUCTION_YES(), SyncType.CLICKABLE);
                    } else if (IsYourHouseBuiltFromStandardConstruction.toString().equalsIgnoreCase("no") || String.valueOf(IsYourHouseBuiltFromStandardConstruction).equalsIgnoreCase("false")) {
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_STANDARD_CONSTRUCTION_NO(), SyncType.CLICKABLE);
                    }
                    break;
                case "PartOfHomeUsedForBusinessPurposes":
                    Map<String, Object> isPartOfHomeUsedForBusinessPurposes = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) mtaToChange.get(PROPERTY_DETAILS)).get(INSURED_ADDRESS_DETAILS));
                    String IsPartOfHomeUsedForBusinessPurposes = isPartOfHomeUsedForBusinessPurposes.get(IPD_USED_FOR_BUSINESS).toString();
                    if (IsPartOfHomeUsedForBusinessPurposes.toString().equalsIgnoreCase("yes") || String.valueOf(IsPartOfHomeUsedForBusinessPurposes).equalsIgnoreCase("true")) {
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_USED_FOR_BUSINESS_YES(), SyncType.CLICKABLE);
                    } else if (IsPartOfHomeUsedForBusinessPurposes.toString().equalsIgnoreCase("no") || String.valueOf(IsPartOfHomeUsedForBusinessPurposes).equalsIgnoreCase("false")) {
                        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_USED_FOR_BUSINESS_NO(), SyncType.CLICKABLE);
                    }
                    break;
                default:
            }
        }
        return returnData;
    }
    DropDownNumericListUpdater.ChangeDetails ChangeNumberOfAdultsForInsuredAddress(Browser pBrowser, Object pChangeSpecification) throws CustomE2eException {
        var vControlLocator =
            this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_NUMBER_OF_ADULTS_AT_PROPERTY();
        return ChangeNumberOfAdultsForm01DropDownSelector(vControlLocator, pBrowser, pChangeSpecification);
    }
    DropDownNumericListUpdater.ChangeDetails ChangeNumberOfChildrenForInsuredAddress(Browser pBrowser, Object pChangeSpecification) throws CustomE2eException {
        var vControlLocator =
            this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_NUMBER_OF_CHILDREN_AT_PROPERTY();
        return ChangeNumberOfChildirenForm01DropDownSelector(vControlLocator, pBrowser, pChangeSpecification);
    }
    DropDownNumericListUpdater.ChangeDetails ChangeNumberOfBedroomsForInsuredAddress(Browser pBrowser, Object pChangeSpecification) throws CustomE2eException {
        var vControlLocator =
            this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_NUMBER_OF_BEDROOMS();
        return ChangeNumberOfBedRoomsForm01DropDownSelector(vControlLocator, pBrowser, pChangeSpecification);
    }
    DropDownNumericListUpdater.ChangeDetails ChangeNumberOfBathroomsForInsuredAddress(Browser pBrowser, Object pChangeSpecification) throws CustomE2eException {
        var vControlLocator =
            this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_NUMBER_OF_BATHROOMS();
        return ChangeNumberOfBathRoomsForm01DropDownSelector(vControlLocator, pBrowser, pChangeSpecification);
    }
    public void ChangeWhatBestDescribesYourHome(String dropDownItem) throws CustomE2eException {
        try {
            selectDropdown(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_WHAT_BEST_DESCRIBES_YOUR_HOME(),dropDownItem, SelectOptions.TEXT);
        } catch (Exception e) {
            throw new CustomE2eException("Change What Best Describes Your Home not listed");
        }
    }
    public void ChangeIntruderAlarm(String dropDownItem) throws CustomE2eException {
        try {
            selectDropdown(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_INTRUDER_ALARM(), dropDownItem, SelectOptions.TEXT);
        } catch (Exception e) {
            throw new CustomE2eException("Change Intruder Alarm not listed");
        }
    }
    public void ChangePetsAtProperty(String dropDownItem) throws CustomE2eException {
        try {
            selectDropdown(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_PETS_AT_PROPERTY(), dropDownItem, SelectOptions.TEXT);
        } catch (Exception e) {
            throw new CustomE2eException("Change Pets At Property not listed");
        }
    }
    public void ChangeDoYouHaveAnyPayingGuests(String dropDownItem) throws CustomE2eException {
        try {
            selectDropdown(this.pageObjectOfPortal.getPerformMTALocatorModel().IPD_DO_YOU_HAVE_ANY_PAYING_GUESTS(), dropDownItem, SelectOptions.TEXT);
        } catch (Exception e) {
            throw new CustomE2eException("Change Do You Have Any Paying Guests not listed");
        }
    }
    DropDownNumericListUpdater.ChangeDetails ChangeNumberOfChildirenForm01DropDownSelector(By pControlLocator, Browser pBrowser, Object pChangeSpecification) throws CustomE2eException {
        return DropDownNumericListUpdater.ChangeNumericDropDownSelector(
                // Tailoring parameter
                pControlLocator,
                (Browser pBrowserInner, By pLocator) -> {
                    var currentValueStr = pBrowserInner.Sh().getSelectedValueFromDropDown(pLocator, "Unable to read the value for the number of children");
                    if (currentValueStr.equalsIgnoreCase("none")) {
                        return 0;


                    }
                    var currentValue = Integer.parseInt(currentValueStr.substring(0, 1));
                    return currentValue;
                },
                (int pValue) -> {
                    if (pValue == 0) {
                        return "none";
                    } else if (pValue == 9) {
                        return "9+";
                    } else {
                        return String.valueOf(pValue);
                    }
                },
                (String pUiValue) -> {
                    if (pUiValue.equalsIgnoreCase("none")) {
                        return 0;
                    }
                    var currentValue = Integer.parseInt(pUiValue.substring(0, 1));
                    return currentValue;
                },
                (int pProposedValue) -> true,
                DropDownNumericListUpdater.ListOperatingMode.ValueIsMin,
                true,
                // Use parameters
                pBrowser,
                pChangeSpecification);
    }
    DropDownNumericListUpdater.ChangeDetails ChangeNumberOfAdultsForm01DropDownSelector(By pControlLocator, Browser pBrowser, Object pChangeSpecification) throws CustomE2eException {
        return DropDownNumericListUpdater.ChangeNumericDropDownSelector(
                // Tailoring parameter
                pControlLocator,
                (Browser pBrowserInner, By pLocator) -> {
                    var currentValueStr = pBrowserInner.Sh().getSelectedValueFromDropDown(pLocator, "Unable to read the value for the number of adults");
                    if (currentValueStr.equalsIgnoreCase("none")) {
                        return 0;
                    }
                    var currentValue = Integer.parseInt(currentValueStr.substring(0, 1));
                    return currentValue;
                },
                (int pValue) -> {
                    if (pValue == 0) {
                        return "none";
                    } else if (pValue == 9) {
                        return "9+";
                    } else {
                        return String.valueOf(pValue);
                    }
                },
                (String pUiValue) -> {
                    if (pUiValue.equalsIgnoreCase("none")) {
                        return 0;
                    }
                    var currentValue = Integer.parseInt(pUiValue.substring(0, 1));
                    return currentValue;
                },
                (int pProposedValue) -> true,
                DropDownNumericListUpdater.ListOperatingMode.ValueIsMin,
                true,
                // Use parameters
                pBrowser,
                pChangeSpecification);
    }
    DropDownNumericListUpdater.ChangeDetails ChangeNumberOfBedRoomsForm01DropDownSelector(By pControlLocator, Browser pBrowser, Object pChangeSpecification) throws CustomE2eException {
        return DropDownNumericListUpdater.ChangeNumericDropDownSelector(
                // Tailoring parameter
                pControlLocator,
                (Browser pBrowserInner, By pLocator) -> {
                    var currentValueStr = pBrowserInner.Sh().getSelectedValueFromDropDown(pLocator, "Unable to read the value for the number of bedrooms");
                    if (currentValueStr.equalsIgnoreCase("none")) {
                        return 0;
                    }
                    var currentValue = Integer.parseInt(currentValueStr.substring(0, 1));
                    return currentValue;
                },
                (int pValue) -> {
                    if (pValue == 0) {
                        return "none";
                    } else if (pValue == 7) {
                        return "7 or more";
                    } else {
                        return String.valueOf(pValue);
                    }
                },
                (String pUiValue) -> {
                    if (pUiValue.equalsIgnoreCase("none")) {
                        return 0;
                    }
                    var currentValue = Integer.parseInt(pUiValue.substring(0, 1));
                    return currentValue;
                },
                (int pProposedValue) -> true,
                DropDownNumericListUpdater.ListOperatingMode.ValueIsMin,
                true,
                // Use parameters
                pBrowser,
                pChangeSpecification);
    }


    DropDownNumericListUpdater.ChangeDetails ChangeNumberOfBathRoomsForm01DropDownSelector(By pControlLocator, Browser pBrowser, Object pChangeSpecification) throws CustomE2eException {
        return DropDownNumericListUpdater.ChangeNumericDropDownSelector(
                // Tailoring parameter
                pControlLocator,
                (Browser pBrowserInner, By pLocator) -> {
                    var currentValueStr = pBrowserInner.Sh().getSelectedValueFromDropDown(pLocator, "Unable to read the value for the number of bathrooms");
                    if (currentValueStr.equalsIgnoreCase("Please select...")) {
                        return 0;
                    }
                    var currentValue = Integer.parseInt(currentValueStr.substring(0, 1));
                    return currentValue;
                },
                (int pValue) -> {
                    if (pValue == 0) {
                        return "Please select...";
                    } else if (pValue == 5) {
                        return "5 or more";
                    } else {
                        return String.valueOf(pValue);
                    }
                },
                (String pUiValue) -> {
                    if (pUiValue.equalsIgnoreCase("Please select...")) {
                        return 0;
                    }
                    var currentValue = Integer.parseInt(pUiValue.substring(0, 1));
                    return currentValue;
                },
                (int pProposedValue) -> true,
                DropDownNumericListUpdater.ListOperatingMode.ValueIsMin,
                true,
                // Use parameters
                pBrowser,
                pChangeSpecification);
    }


    private Map<String, Object> editPolicyHolderDetails(Map<String, Object> mtaToChange) throws CustomE2eException {
        Map<String, Object> returnData;
        editMainPolicyHolderDetails();
        Map<String, Object> personalDetails = (Map<String, Object>) ((Map<String, Object>) mtaToChange.get(MAIN_POLICY_HOLDER)).get(PERSONAL_DETAILS);
        returnData = new HashMap<>();
        for (String keyName : personalDetails.keySet()) {
            mtaToChange.keySet().toString();
            switch (keyName) {
                case "Title":
                    changeTitle((String) personalDetails.get(TITLE));
                    break;
                default:
            }
        }
        return returnData;
    }

    private Map<String, Object> editHomePolicyCoverDetails(Map<String, Object> mtaToChange) throws CustomE2eException {
        Map<String, Object> returnData = new HashMap<>();
        var coverDetailsToChange = (Map<String, Object>) mtaToChange.get(HOME_POLICY_COVER);
        for (String keyName : coverDetailsToChange.keySet()) {
            if (keyName.equalsIgnoreCase("BuildingCover")) {
                Map<String, Object> mtaAction = (Map<String, Object>) ((Map<String, Object>) mtaToChange.get(HOME_POLICY_COVER)).get(BUILDING_COVER);
                for (String buildingCover : mtaAction.keySet()) {
                    switch (buildingCover) {
                        case "BuildingCoverAmount":
                            //editCoverAmount(this.pageObjectOfPortal.getPerformMTALocatorModel().COVER_CONTENT_AMOUNT(), (String) mtaAction.get(BUILDING_COVER_AMOUNT));
                            ChangeBuildingCoverAmount(this.mBrowser, mtaAction.get(BUILDING_COVER_AMOUNT));
                            break;
                        case "AccidentalCover":
                            editCover(this.pageObjectOfPortal.getPerformMTALocatorModel().BUILDING_ACCIDENTAL_COVER(), mtaAction.get(ACCIDENTAL_COVER));
                            break;
                        case "BuildingVoluntaryExcess":
                            //editVoluntaryXsBuilding((String) mtaAction.get(BUILDING_VOLUNTARY_EXCESS));
                            ChangeBuildingVoluntaryExcess(this.mBrowser, mtaAction.get(BUILDING_VOLUNTARY_EXCESS));
                            break;
                    }
                }
            } else if (keyName.equalsIgnoreCase("ContentsCover")) {
                Map<String, Object> mtaAction = (Map<String, Object>) ((Map<String, Object>) mtaToChange.get(HOME_POLICY_COVER)).get(CONTENTS_COVER);
                for (String contentsCover : mtaAction.keySet()) {
                    switch (contentsCover) {
                        case "ContentCoverWithin2Years":
                            editCover(this.pageObjectOfPortal.getPerformMTALocatorModel().PAST_CONTENTS_COVER(), mtaAction.get(CONTENT_COVER_WITHIN_TWO_YEARS));
                            break;
                        case "ClaimFreeYears":
                            if(portalGeneralStepDefinition.isElementSelected(xpathBuilder(this.pageObjectOfPortal.getPerformMTALocatorModel().PAST_CONTENTS_COVER(), "no"))) {
                            throw new CustomE2eException("Claim free years cannot be claimed for no content cover in past 2 years");
                            }else{
                            ChangeClaimFreeYears(this.mBrowser, mtaAction.get(CLAIM_FREE_YEARS));
                            }
                        break;
                        case "ContentCoverAmount":
                            ChangeContentCoverAmount(this.mBrowser, mtaAction.get(CONTENT_COVER_AMOUNT));
                            break;
                        case "ContentVoluntaryExcess":
                            ChangeContentVoluntaryExcess(this.mBrowser, mtaAction.get(CONTENT_VOLUNTARY_EXCESS));
                            break;
                        case "AccidentalCover":
                            editCover(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTENT_ACCIDENTAL_COVER(), mtaAction.get(ACCIDENTAL_COVER));
                            break;
                        case "PersBelongAwayFromHomCoverChange":
                            editCover(this.pageObjectOfPortal.getPerformMTALocatorModel().PERSONAL_BELONGING_AWAY_FROM_HOME(), mtaAction.get(PERSONAL_BELONGING_AWAY_FROM_HOME));
                            break;
                        case "PersBelongingCoverAmount":
                                if(portalGeneralStepDefinition.isElementSelected(xpathBuilder(this.pageObjectOfPortal.getPerformMTALocatorModel().PERSONAL_BELONGING_AWAY_FROM_HOME(),"no"))){
                                    throw new CustomE2eException("Personal Belonging Cover amount cannot be added for the selection");
                                }else{
                                    ChangePersonalBelongingCoverAmount(this.mBrowser,mtaAction.get(PERSONAL_BELONGING_AWAY_FROM_HOME_AMOUNT));
                                }
                                break;
                    }
                }
            }
        }
        return returnData;
    }

    private Map<String, Object> editHomePolicyAddressDetails(Map<String, Object> policyholderDetails, Map<String, Object> mtaToChange) throws CustomE2eException {
        Map<String, Object> returnData = new HashMap<>();
        var addressDetailsToChange = (Map<String, Object>) mtaToChange.get(HOME_POLICY_ADDRESS);
        var insuredAddress = (String) policyholderDetails.get("InsuredAddress");
        var insuredAddressArray = insuredAddress.split(",");
        var insuredAddressLength = insuredAddressArray.length;
        insuredAddressLength = insuredAddressLength - 1;
            try {
                for (String keyName : addressDetailsToChange.keySet()) {
                    switch (keyName) {
                        case "RiskAddress":
                            if (insuredAddressArray[0].trim().equalsIgnoreCase(String.valueOf(((Map<String,Object>)addressDetailsToChange.get(RISK_ADDRESS)).get(HOUSE_IDENTIFIER)))
                                    && insuredAddressArray[insuredAddressLength].trim().equalsIgnoreCase((String) ((Map<String,Object>)addressDetailsToChange.get(RISK_ADDRESS)).get(POSTCODE))) {
                                throw new CustomE2eException("Current Address is same as new address, MTA is not executed");
                            } else {
                                editHomeAddress(String.valueOf(((Map<String,Object>)addressDetailsToChange.get(RISK_ADDRESS)).get(HOUSE_IDENTIFIER)),(String)((Map<String,Object>)addressDetailsToChange.get(RISK_ADDRESS)).get(POSTCODE));
                            }

                            break;
                        case "MoveInDays":
                            editMoveInDays(Integer.parseInt(addressDetailsToChange.get(MOVE_IN_DAYS).toString().substring(0, 2)));
                            break;
                    }
                    }
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().SELECT_PROPERTY_TYPE_HOUSE(), SyncType.CLICKABLE);
                selectDropdown(this.pageObjectOfPortal.getPerformMTALocatorModel().SELECT_HOME_DESCRIPTION(), "1", SelectOptions.INDEX);
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().STANDARD_CONSTRUCTION_YES(), SyncType.CLICKABLE);
                selectDropdown(this.pageObjectOfPortal.getPerformMTALocatorModel().NUMBER_OF_BEDROOMS(), "3", SelectOptions.INDEX);
                selectDropdown(this.pageObjectOfPortal.getPerformMTALocatorModel().NUMBER_OF_BATHS(), "2", SelectOptions.INDEX);
                selectDropdown(this.pageObjectOfPortal.getPerformMTALocatorModel().HOME_BUILT_YEAR(), "2005-2009", SelectOptions.TEXT);
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().HOME_EXTENDED_NO(), SyncType.CLICKABLE);
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().GRADED_BUILDING_NO(), SyncType.CLICKABLE);
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().FLOODING_NO(), SyncType.CLICKABLE);
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().WINDOW_AND_DOOR_LOCKS_YES(), SyncType.CLICKABLE);
                selectDropdown(this.pageObjectOfPortal.getPerformMTALocatorModel().INTRUDER_ALARM(), "1", SelectOptions.INDEX);
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().OWNED_ON_MORTGAGE(), SyncType.CLICKABLE);
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().HOME_OCCUPIED_DAY_AND_NIGHT(), SyncType.CLICKABLE);
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().CORRESPONDENCE_ADDRESS_YES(), SyncType.CLICKABLE);
                selectDropdown(this.pageObjectOfPortal.getPerformMTALocatorModel().NUMBER_OF_ADULTS(), "2", SelectOptions.TEXT);
                selectDropdown(this.pageObjectOfPortal.getPerformMTALocatorModel().NUMBER_OF_CHILDREN(), "2", SelectOptions.TEXT);
                selectDropdown(this.pageObjectOfPortal.getPerformMTALocatorModel().PETS(), "No", SelectOptions.TEXT);
                selectDropdown(this.pageObjectOfPortal.getPerformMTALocatorModel().PAYING_GUESTS(), "No", SelectOptions.TEXT);
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().BUSINESS_PURPOSE_NO(), SyncType.CLICKABLE);
            } catch (CustomE2eException e) {
                throw new CustomE2eException("changeDetailsOfThePropertyThatIsBeingInsured");
            }


        return returnData;
    }

    private void editHomeAddress(String houseIdentifier, String postcode) throws CustomE2eException {
       typeText(this.pageObjectOfPortal.getPerformMTALocatorModel().NEW_ADDRESS_HOUSE_NAME_OR_NUMBER(),houseIdentifier,SyncType.CLICKABLE);
       typeText(this.pageObjectOfPortal.getPerformMTALocatorModel().NEW_ADDRESS_POSTCODE(),postcode,SyncType.CLICKABLE);
        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().FIND_ADDRESS_BUTTON(), SyncType.CLICKABLE);

    }
    private void editMoveInDays(int moveInDays) throws CustomE2eException {
        if (moveInDays >= 0 && moveInDays <= 14) {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().SELECT_0_14_DAYS_BUTTON(), SyncType.CLICKABLE);
        } else if (moveInDays > 14 && moveInDays <= 60) {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().SELECT_15_60_DAYS_BUTTON(), SyncType.CLICKABLE);
        } else if (moveInDays > 60) {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().SELECT_61_DAYS_BUTTON(), SyncType.CLICKABLE);
        } else {
            throw new CustomE2eException("Move in date is not valid");
        }
    }


    private void editCover(By byLocator, Object cover) throws CustomE2eException {
        var coverValue = "yes";
        var instance = cover instanceof String;
        if (cover.toString().equalsIgnoreCase("add") || String.valueOf(cover).equalsIgnoreCase("true")) {
            coverValue = "yes";
            if (portalGeneralStepDefinition.isElementSelected(xpathBuilder(byLocator, coverValue))) {
                throw new CustomE2eException("Element is already selected, MTA is not allowed");
            } else {
                clickElementRetryX3onClickIntEx(xpathBuilder(byLocator, coverValue), SyncType.CLICKABLE);
            }
        } else if (cover.toString().equalsIgnoreCase("remove") || String.valueOf(cover).equalsIgnoreCase("false")) {
            coverValue = "no";
            if (portalGeneralStepDefinition.isElementSelected(xpathBuilder(byLocator, coverValue))) {
                throw new CustomE2eException("Element is already selected, MTA is not allowed");
            } else {
                clickElementRetryX3onClickIntEx(xpathBuilder(byLocator, coverValue), SyncType.CLICKABLE);
            }
        } else {
            int selectValue = (int) Math.random() * 2;
            switch (selectValue) {
                case 1:
                    coverValue = "yes";
                    clickElementRetryX3onClickIntEx(xpathBuilder(byLocator, coverValue), SyncType.CLICKABLE);
                    break;
                case 2:
                    coverValue = "no";
                    clickElementRetryX3onClickIntEx(xpathBuilder(byLocator, coverValue), SyncType.CLICKABLE);
                    break;
            }
        }

    }


    private Map<String, Object> jointPolicyHolderDetails(Map<String, Object> mtaToChange) throws CustomE2eException {
        Map<String, Object> returnData = new HashMap<>();
        String action = (String) ((Map<String, Object>) mtaToChange.get(JOINT_POLICY_HOLDER)).get(ACTION);
        if (action.equalsIgnoreCase("Add")) {
            addJointPolicyHolderDetailsButton();
        } else if (action.equalsIgnoreCase("Change")) {
            changeJointPolicyHolderDetailsButton();
        } else if (action.equalsIgnoreCase("Delete")) {
            removeJointPolicyHolderDetailsButton();
        }
        if (action.equalsIgnoreCase("Add")) {
            Map<String, Object> jointPolicyholderPersonalDetails = (Map<String, Object>) ((Map<String, Object>) mtaToChange.get(JOINT_POLICY_HOLDER)).get(PERSONAL_DETAILS);
            mtaToChange.keySet().toString();
            changeTitle((String) jointPolicyholderPersonalDetails.get(TITLE));
            jointPolicyHolderFirstName((String) jointPolicyholderPersonalDetails.get(FIRSTNAME));
            jointPolicyHolderLastName((String) jointPolicyholderPersonalDetails.get(LASTNAME));
            changeMaritalStatus((String) jointPolicyholderPersonalDetails.get(MARITALSTATUS));
            dateOfBirth((String) jointPolicyholderPersonalDetails.get(DATEOFBIRTH));
            Map<String, Object> primaryEmploymentDetails = (Map<String, Object>) jointPolicyholderPersonalDetails.get(PRIMARYEMPLOYMENTSTATUS);

//            RobustnessHelp.PerformWithRetries(
//                    2, Duration.ofMillis(100L), 2.0, Duration.ofMillis(1000L),
//                    ()->{},
//                    Duration.ofMillis(10l),
//                    ()-> {
//                        selectPrimaryEmploymentType((Boolean) primaryEmploymentDetails.get(EMPLOYED),
//                                (String) primaryEmploymentDetails.get(TYPE),
//                                (String) primaryEmploymentDetails.get(CATEGORY));
//                        return true;
//                    },
//                    ()->selectPrimaryEmploymentCategory((String) primaryEmploymentDetails.get(CATEGORY))
//            );


            Map<String, Object> secondaryEmploymentDetails = (Map<String, Object>) jointPolicyholderPersonalDetails.get(SECONDARYEMPLOYMENTSTATUS);
            RobustnessHelp.PerformSpacedOpSequenceWithRetries(
                    2, Duration.ofMillis(100L), 2.0, Duration.ofMillis(1000L),
                    () -> { return true;},
                    Duration.ofMillis(10l),
                    () -> selectPrimaryEmploymentCategory((String) primaryEmploymentDetails.get(CATEGORY)),
                    () -> selectPrimaryEmploymentType((Boolean) primaryEmploymentDetails.get(EMPLOYED),
                            (String) primaryEmploymentDetails.get(TYPE),
                            (String) primaryEmploymentDetails.get(CATEGORY)),
                    () -> selectPrimaryEmploymentIndustry((Boolean) primaryEmploymentDetails.get(EMPLOYED),
                            (String) primaryEmploymentDetails.get(INDUSTRY)),
                    () -> isSecondEmployment((Boolean) secondaryEmploymentDetails.get(EMPLOYED)),
                    () -> selectSecondaryEmploymentCategory((Boolean) secondaryEmploymentDetails.get(EMPLOYED),
                            (String) secondaryEmploymentDetails.get(CATEGORY)),
                    () -> selectSecondaryEmploymentType((Boolean) secondaryEmploymentDetails.get(EMPLOYED),
                            (String) secondaryEmploymentDetails.get(TYPE)),
                    () -> selectSecondaryEmploymentIndustry((Boolean) secondaryEmploymentDetails.get(EMPLOYED),
                            (String) secondaryEmploymentDetails.get(INDUSTRY))
            );

//            selectPrimaryEmploymentCategory((String) primaryEmploymentDetails.get(CATEGORY));
//            try {
//               sleep(100L);
//            } catch (InterruptedException e) {
//            }
//            selectPrimaryEmploymentType((Boolean) primaryEmploymentDetails.get(EMPLOYED),
//                    (String) primaryEmploymentDetails.get(TYPE),
//                    (String) primaryEmploymentDetails.get(CATEGORY));
//            selectPrimaryEmploymentIndustry((Boolean) primaryEmploymentDetails.get(EMPLOYED),
//                    (String) primaryEmploymentDetails.get(INDUSTRY));
//            Map<String, Object> secondaryEmploymentDetails = (Map<String, Object>) jointPolicyholderPersonalDetails.get(SECONDARYEMPLOYMENTSTATUS);
//            isSecondEmployment((Boolean) secondaryEmploymentDetails.get(EMPLOYED));
//            selectSecondaryEmploymentCategory((Boolean) secondaryEmploymentDetails.get(EMPLOYED),
//                    (String) secondaryEmploymentDetails.get(CATEGORY));
//            selectSecondaryEmploymentType((Boolean) secondaryEmploymentDetails.get(EMPLOYED),
//                    (String) secondaryEmploymentDetails.get(TYPE));
//            selectSecondaryEmploymentIndustry((Boolean) secondaryEmploymentDetails.get(EMPLOYED),
//                    (String) secondaryEmploymentDetails.get(INDUSTRY));
            selectRelationship((String) ((Map<String, Object>) mtaToChange.get(JOINT_POLICY_HOLDER)).get(RELATIONSHIP));
        } else if (action.equalsIgnoreCase("Change")) {
            Map<String, Object> jointPolicyholderPersonalDetails = (Map<String, Object>) ((Map<String, Object>) mtaToChange.get(JOINT_POLICY_HOLDER)).get(PERSONAL_DETAILS);
            for (var key : jointPolicyholderPersonalDetails.keySet()) {
                switch (key) {
                    case "Title":
                        changeTitle((String) jointPolicyholderPersonalDetails.get(TITLE));
                        break;
                    case "FirstName":
                        jointPolicyHolderFirstName((String) jointPolicyholderPersonalDetails.get(FIRSTNAME));
                        break;
                    case "LastName":
                        jointPolicyHolderLastName((String) jointPolicyholderPersonalDetails.get(LASTNAME));
                        break;
                    case "MaritalStatus":
                        changeMaritalStatus((String) jointPolicyholderPersonalDetails.get(MARITALSTATUS));
                        break;
                    case "DateOfBirth":
                        dateOfBirth((String) jointPolicyholderPersonalDetails.get(DATEOFBIRTH));
                        break;
                    case "PrimaryEmploymentStatus":
                        Map<String, Object> primaryEmploymentDetails = (Map<String, Object>) jointPolicyholderPersonalDetails.get(PRIMARYEMPLOYMENTSTATUS);
                        selectPrimaryEmploymentCategory((String) primaryEmploymentDetails.get(CATEGORY));
                        selectPrimaryEmploymentType((Boolean) primaryEmploymentDetails.get(EMPLOYED),
                                (String) primaryEmploymentDetails.get(TYPE),
                                (String) primaryEmploymentDetails.get(CATEGORY));
                        selectPrimaryEmploymentIndustry((Boolean) primaryEmploymentDetails.get(EMPLOYED),
                                (String) primaryEmploymentDetails.get(INDUSTRY));
                        break;
                    case "SecondaryEmploymentStatus":
                        Map<String, Object> secondaryEmploymentDetails = (Map<String, Object>) jointPolicyholderPersonalDetails.get(SECONDARYEMPLOYMENTSTATUS);
                        isSecondEmployment((Boolean) secondaryEmploymentDetails.get(EMPLOYED));
                        selectSecondaryEmploymentCategory((Boolean) secondaryEmploymentDetails.get(EMPLOYED),
                                (String) secondaryEmploymentDetails.get(CATEGORY));
                        selectSecondaryEmploymentType((Boolean) secondaryEmploymentDetails.get(EMPLOYED),
                                (String) secondaryEmploymentDetails.get(TYPE));
                        selectSecondaryEmploymentIndustry((Boolean) secondaryEmploymentDetails.get(EMPLOYED),
                                (String) secondaryEmploymentDetails.get(INDUSTRY));
                        break;
                    case "Relationship":
                        selectRelationship((String) ((Map<String, Object>) mtaToChange.get(JOINT_POLICY_HOLDER)).get(RELATIONSHIP));
                        break;
                    default:
                        throw new CustomE2eException("Unrecognised data member: " + key);
                }
            }
        }

        //waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().SUBMIT_EDIT_POLICYHOLDER_BUTTON(), SyncType.VISIBLE,waitDuration);
        //SLC Repeated failures on this screenshot shows spinner increased duration
        //Also added if as not required for Delete op
        if (action.equalsIgnoreCase("Add")|| action.equalsIgnoreCase("Change")) {
            PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300), () ->
                    clickElement(this.pageObjectOfPortal.getPerformMTALocatorModel().SUBMIT_EDIT_POLICYHOLDER_BUTTON(), SyncType.CLICKABLE));
        }

        //waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EDIT_BUTTON(), SyncType.VISIBLE,waitDuration);
        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300), ()->
                clickElement(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EDIT_BUTTON(), SyncType.CLICKABLE));
        return returnData;
    }


    public void editCoverInHomeTab() throws CustomE2eException {
        waitForPageLoad();
        waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().EDIT_COVER_DETAILS(), SyncType.CLICKABLE, waitDuration);
        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(30), () ->
                clickElement(this.pageObjectOfPortal.getPerformMTALocatorModel().EDIT_COVER_DETAILS(), SyncType.CLICKABLE));
    }

    public void editMainPolicyHolderAddressInHomeTab() throws CustomE2eException {
        waitForPageLoad();
        try {
            waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().EDIT_ADDRESS(), SyncType.CLICKABLE, waitDuration);
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EDIT_ADDRESS(), SyncType.CLICKABLE);
        } catch (ElementClickInterceptedException e) {
            waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().EDIT_ADDRESS(), SyncType.CLICKABLE, waitDuration);
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EDIT_ADDRESS(), SyncType.CLICKABLE);
        }

    }

    public void editMainPolicyHolderCoverInHomeTab() throws CustomE2eException {
        waitForPageLoad();
        waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().EDIT_COVER_DETAILS(), SyncType.CLICKABLE, waitDuration);
        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EDIT_COVER_DETAILS(), SyncType.CLICKABLE);
    }

    public void editMainPolicyHolderDetails() throws CustomE2eException {
        waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().EDIT_POLICYHOLDER_DETAILS(), SyncType.VISIBLE, waitDuration);
        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().EDIT_POLICYHOLDER_DETAILS(), SyncType.CLICKABLE);

    }

    public void importantInformationPage() throws CustomE2eException {

        PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(30), () ->
                clickElement(this.pageObjectOfPortal.getPerformMTALocatorModel().CONFIRM_CONTINUE_BTN(), SyncType.CLICKABLE));
        //waitForElement(this.pageObjectOfPortal.getPerformMTALocatorModel().CONFIRM_CONTINUE_BTN(), SyncType.VISIBLE);
        //clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().CONFIRM_CONTINUE_BTN(), SyncType.CLICKABLE);
    }


    public void selectEffectiveDate(String effectiveDate) throws ParseException, CustomE2eException {
        //selectFromDropdown(EFFECTIVE_DATE_SELECTION, effectiveDate, SelectOptions.TEXT);

        waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().EFFECTIVE_DATE_SELECTION(), SyncType.VISIBLE, waitDuration);
        String formattedDate = Formatting.changeDateFormatIntoExpected(effectiveDate, "dd/MM/yyyy", "EEEE, d MMMM");
        selectDropdown(this.pageObjectOfPortal.getPerformMTALocatorModel().EFFECTIVE_DATE_SELECTION(), formattedDate, SelectOptions.TEXT);
    }

    public void selectEffectiveDateFromList(int indexInList) throws CustomE2eException {
        //selectFromDropdown(EFFECTIVE_DATE_SELECTION, effectiveDate, SelectOptions.TEXT);
        waitForElement(this.pageObjectOfPortal.getPerformMTALocatorModel().EFFECTIVE_DATE_SELECTION(), SyncType.VISIBLE);
        selectDropdown(this.pageObjectOfPortal.getPerformMTALocatorModel().EFFECTIVE_DATE_SELECTION(), indexInList, SelectOptions.INDEX);
    }


    public void changeTitle(String title) throws CustomE2eException {
        if (title.length() >= 1) {
            if(title.equalsIgnoreCase("Doctor")||title.equalsIgnoreCase("Dr")){
                title="Dr";
            }
            if(isElementSelected(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().POLICYHOLDER_TITLE(), Formatting.capitalizeFirstCharacter(title)))){
                throw new CustomE2eException("Title is same as already selected.");
            }
            String finalTitle = title;
            PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(30), () ->
                    clickElement(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().POLICYHOLDER_TITLE(), Formatting.capitalizeFirstCharacter(finalTitle)), SyncType.CLICKABLE));
        }

    }

    public void jointPolicyHolderFirstName(String firstname) throws CustomE2eException {
        try {
            typeText(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().FIRST_NAME(),
                firstname, SyncType.CLICKABLE);
        } catch (Exception e) {
            throw new CustomE2eException("First name is not clickable");
        }
    }

    public void jointPolicyHolderLastName(String lastname) throws CustomE2eException {
        try {
            typeText(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().SURNAME_NAME(),
                lastname, SyncType.CLICKABLE);
        } catch (Exception e) {
            throw new CustomE2eException("First name is not clickable");
        }
    }

    public void changeMaritalStatus(String maritalStatus) throws CustomE2eException {
        maritalStatus = maritalStatus.substring(0, 1);
        if (maritalStatus.equalsIgnoreCase("C")) {
            maritalStatus = "V";
        }
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().MARITAL_STATUS(), Formatting.capitalizeFirstCharacter(maritalStatus)), SyncType.CLICKABLE);
    }

    public void addJointPolicyHolderDetailsButton() throws CustomE2eException {
        try {
            waitForElement2(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().ADD_JOINT_POLICY_HOLDER_BUTTON(), SyncType.VISIBLE, waitDuration);
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().ADD_JOINT_POLICY_HOLDER_BUTTON(), SyncType.CLICKABLE);

        } catch (Exception e) {
            throw new CustomE2eException("Add Joint policyholder not available");
        }
    }

    public void changeJointPolicyHolderDetailsButton() throws CustomE2eException {
        try {
            waitForElement2(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().JOINT_POLICY_HOLDER_EDIT_LINK(), SyncType.VISIBLE, waitDuration);
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().JOINT_POLICY_HOLDER_EDIT_LINK(), SyncType.CLICKABLE);

        } catch (Exception e) {
            throw new CustomE2eException("Edit Joint policyholder not available");
        }
    }

    public void removeJointPolicyHolderDetailsButton() throws CustomE2eException {
        try {
            waitForElement2(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().REMOVE_JOINT_POLICYHOLDER(), SyncType.VISIBLE, waitDuration);
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().REMOVE_JOINT_POLICYHOLDER(), SyncType.CLICKABLE);
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().UPDATE_CHANGES(), SyncType.CLICKABLE);
        } catch (Exception e) {
            throw new CustomE2eException("Remove Joint policyholder not available");
        }
    }

    public void dateOfBirth(String dateofbirth) throws CustomE2eException {
        String[] date = CommonHelper.splitDate(dateofbirth);
        try {
            typeText(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().DATE_OF_BIRTH(),
                date[0], SyncType.CLICKABLE);
            typeText(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().DATE_OF_MONTH(),
                date[1], SyncType.CLICKABLE);
            typeText(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().DATE_OF_YEAR(),
                date[2], SyncType.CLICKABLE);
        } catch (Exception e) {
            throw new CustomE2eException("Date of birth is not valid");
        }

    }

    public void selectPrimaryEmploymentCategory(String category) throws CustomE2eException {
        try {
            selectDropdown(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().EMPLOYMENT_STATUS(), category, SelectOptions.TEXT);
        } catch (Exception e) {
            throw new CustomE2eException("Employment category not listed");
        }
    }

    public void selectPrimaryEmploymentType(boolean employed, String employmentType, String category) throws CustomE2eException {
        String[] employmentTypeValue = employmentType.split("(?=\\p{Lu})");
        employmentType = String.join(" ", employmentTypeValue);
        if (employed) {
            typeText(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().OCCUPATION(),
                employmentType.trim(), SyncType.CLICKABLE);
            waitForElement2(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().JOB_TYPE_SUGGESTION(), SyncType.CLICKABLE, waitDuration);
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().JOB_TYPE_SUGGESTION(), SyncType.CLICKABLE);
        } else {
            if (category.equalsIgnoreCase("Full Time Education")) {
                typeText(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().OCCUPATION(),
                    employmentType.trim(), SyncType.CLICKABLE);
                waitForElement2(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().JOB_TYPE_SUGGESTION(), SyncType.CLICKABLE, waitDuration);
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().JOB_TYPE_SUGGESTION(), SyncType.CLICKABLE);
            }
        }
    }

    public void selectPrimaryEmploymentIndustry(boolean employed, String employmentIndustry) throws CustomE2eException {
        String[] industry = employmentIndustry.split("(?=\\p{Lu})");
        employmentIndustry = String.join(" ", industry);
        if (employed) {
            typeText(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().INDUSTRY_TYPE(),
                employmentIndustry.trim(), SyncType.CLICKABLE);
            waitForElement2(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().JOB_TYPE_SUGGESTION(), SyncType.CLICKABLE, waitDuration);
            PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(30), () ->
                    clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().JOB_TYPE_SUGGESTION(), SyncType.CLICKABLE));
        }
    }

    public void isSecondEmployment(boolean employed) throws CustomE2eException {
        try {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().SECOND_JOB(), String.valueOf(employed)), SyncType.CLICKABLE);
        } catch (Exception e) {
            throw new CustomE2eException("Second job not selectable");
        }

    }

    public void selectSecondaryEmploymentCategory(boolean employed, String category) throws CustomE2eException {
        try {
            if (employed) {
                selectDropdown(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().SECOND_EMPLOYMENT_STATUS(), category, SelectOptions.TEXT);
            }

        } catch (Exception e) {
            throw new CustomE2eException("Second job Employment category not listed");
        }
    }

    public void selectSecondaryEmploymentType(boolean employed, String employmentType) throws CustomE2eException {
        String[] employmentTypeValue = employmentType.split("(?=\\p{Lu})");
        employmentType = String.join(" ", employmentTypeValue);
        try {

            if (employed) {
                typeText(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().SECOND_JOB_OCCUPATION(), employmentType.trim(), SyncType.CLICKABLE);
                waitForElement2(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().JOB_TYPE_SUGGESTION(), SyncType.CLICKABLE, waitDuration);
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().JOB_TYPE_SUGGESTION(), SyncType.CLICKABLE);
            }
        } catch (Exception e) {
            throw new CustomE2eException("Not able to select Second job occupation");
        }
    }

    public void selectSecondaryEmploymentIndustry(boolean employed, String employmentIndustry) throws CustomE2eException {
        String[] industry = employmentIndustry.split("(?=\\p{Lu})");
        employmentIndustry = String.join(" ", industry);
        try {
            if (employed) {
                typeText(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().SECOND_JOB_INDUSTRY_TYPE(), employmentIndustry.trim(), SyncType.CLICKABLE);
                waitForElement2(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().JOB_TYPE_SUGGESTION(), SyncType.CLICKABLE, waitDuration);
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().JOB_TYPE_SUGGESTION(), SyncType.CLICKABLE);
            }
        } catch (Exception e) {
            throw new CustomE2eException("Not able to select Second job industry");
        }
    }

    public void selectRelationship(String relationship) throws CustomE2eException {
        try {
            selectDropdown(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().RELATIONSHIP_STATUS(), relationship.trim(), SelectOptions.TEXT);
        } catch (Exception e) {
            throw new CustomE2eException("Relationship status not available - " + e.getMessage());
        }
    }


    DropDownNumericListUpdater.ChangeDetails ChangeBuildingCoverAmount(Browser pBrowser, Object pChangeSpecification) throws CustomE2eException {
        var vControlLocator = this.pageObjectOfPortal.getPerformMTALocatorModel().COVER_CONTENT_AMOUNT();
        return portalGeneralStepDefinition.ChangeCurrencyAmountForm01DropDownSelector(vControlLocator, pBrowser, pChangeSpecification);
    }

    DropDownNumericListUpdater.ChangeDetails ChangeBuildingVoluntaryExcess(Browser pBrowser, Object pChangeSpecification) throws CustomE2eException {
        var vControlLocator = this.pageObjectOfPortal.getPerformMTALocatorModel().VOLUNTARY_XS_BUILDING();
        return portalGeneralStepDefinition.ChangeCurrencyAmountForm01DropDownSelector(vControlLocator, pBrowser, pChangeSpecification);
    }

    DropDownNumericListUpdater.ChangeDetails ChangeContentCoverAmount(Browser pBrowser, Object pChangeSpecification) throws CustomE2eException {
        var vControlLocator = this.pageObjectOfPortal.getPerformMTALocatorModel().CONTENT_COVER_AMOUNT();
        return portalGeneralStepDefinition.ChangeCurrencyAmountForm01DropDownSelector(vControlLocator, pBrowser, pChangeSpecification);
    }

    DropDownNumericListUpdater.ChangeDetails ChangeContentVoluntaryExcess(Browser pBrowser, Object pChangeSpecification) throws CustomE2eException {
        var vControlLocator = this.pageObjectOfPortal.getPerformMTALocatorModel().VOLUNTARY_XS_CONTENT();
        return portalGeneralStepDefinition.ChangeCurrencyAmountForm01DropDownSelector(vControlLocator, pBrowser, pChangeSpecification);
    }



    DropDownNumericListUpdater.ChangeDetails ChangeClaimFreeYears(Browser pBrowser, Object pChangeSpecification) throws CustomE2eException {
        var vControlLocator = this.pageObjectOfPortal.getPerformMTALocatorModel().CLAIM_FREE_YEARS();
        return ChangeNumberOfYearsForm01DropDownSelector(vControlLocator, pBrowser, pChangeSpecification);
    }

    DropDownNumericListUpdater.ChangeDetails ChangeNumberOfYearsForm01DropDownSelector(By pControlLocator, Browser pBrowser, Object pChangeSpecification) throws CustomE2eException {
        return DropDownNumericListUpdater.ChangeNumericDropDownSelector(
                // Tailoring parameter
                pControlLocator,
                (Browser pBrowserInner, By pLocator) -> {
                    var currentValueStr = pBrowserInner.Sh().getSelectedValueFromDropDown(pLocator, "Unable to read the value for Claim free years");
                    if (currentValueStr.equalsIgnoreCase("None")) {
                        return 0;
                    }
                    var currentValue = Integer.parseInt(currentValueStr.substring(0, 1));
                    return currentValue;
                },
                (int pValue) -> {
                    if (pValue == 0) {
                        return "None";
                    } else if (pValue == 9) {
                        return "9+ years";
                    } else if (pValue == 1) {
                        return "1 year";
                    } else {
                        return String.format("%d years", pValue);
                    }
                },
                (String pUiValue) -> {
                    if (pUiValue.equalsIgnoreCase("None")) {
                        return 0;
                    }
                    var currentValue = Integer.parseInt(pUiValue.substring(0, 1));
                    return currentValue;
                },
                (int pProposedValue) -> true,
                DropDownNumericListUpdater.ListOperatingMode.ValueIsMin,
                true,
                // Use parameters
                pBrowser,
                pChangeSpecification);
    }

    DropDownNumericListUpdater.ChangeDetails ChangePersonalBelongingCoverAmount(Browser pBrowser, Object pChangeSpecification) throws CustomE2eException {
        var vControlLocator = this.pageObjectOfPortal.getPerformMTALocatorModel().PERSONAL_BELONGING_AWAY_FROM_HOME_COVER_AMOUNT();
        return portalGeneralStepDefinition.ChangeCoverAmountForm01DropDownSelector(vControlLocator, pBrowser,
            pChangeSpecification);
    }

}


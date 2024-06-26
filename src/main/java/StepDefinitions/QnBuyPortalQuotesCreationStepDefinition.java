package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import activities.CommonControlDataDefns;
import activities.QuoteCreationOnQnBuyPortal;
import helpers.*;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import static activities.CommonControlDataDefns.*;


public class QnBuyPortalQuotesCreationStepDefinition extends AgeasDigitalReactPortalHelpers {

    PortalGeneralStepDefinitions portalGeneralStepDefinitions;
    CommonControlDataDefns commonControlDataDef = new CommonControlDataDefns();
    public QnBuyPortalQuotesCreationStepDefinition(WebDriver driver,
                                                   PageObjects.PortalModel.Root pageObjectOfPortal) {
        super(driver, pageObjectOfPortal);
        portalGeneralStepDefinitions = new PortalGeneralStepDefinitions(driver, pageObjectOfPortal);
    }


    public void enterHomeDetails(Map<String, Object> salesDetails, Map<String, Object> householdCoverType,
                                 Map<String, Object> correspondenceAddress, Map<String, Object> buildingDetails,
                                 Map<String, Object> dynamicUnderwriterQuestions, Map<String, Object> additionalInformation) throws CustomE2eException {
        var homeSecurity = (Map<String, Object>)((Map<Object, Object>)salesDetails.get(INSURANCE_DETAILS)).get(EisHomeQuoteCreationStepDefinition.SECURITY);
        coverType(CommonHelper.convertStringIntoBoolean(householdCoverType.get(CommonControlDataDefns.CONTENTS_VAR))
                , CommonHelper.convertStringIntoBoolean(householdCoverType.get(commonControlDataDef.BUILDING_VAR)));
        enterAddress(String.valueOf(correspondenceAddress.get(commonControlDataDef.HOUSE_IDENTIFIER_VAR)),
                (String) correspondenceAddress.get(commonControlDataDef.POSTCODE));
        selectPropertyType(buildingDetails);
        homeBuiltOfStandardConstruction((String)buildingDetails.get(QuoteCreationOnQnBuyPortal.BUILT_STD_CONST));
        enterNumberOfBathroomAndBedroom(buildingDetails.get(commonControlDataDef.NUM_OF_BEDROOM),
                dynamicUnderwriterQuestions.get(commonControlDataDef.BATHROOM_NUM_VAR));
        enterBuiltYear(buildingDetails.get(commonControlDataDef.YEAR_BUILT_VAR));
        isHomeExtended(Objects.requireNonNull(CommonHelper.convertStringIntoBoolean(dynamicUnderwriterQuestions.get(QuoteCreationOnQnBuyPortal.HOME_EXTENSION).toString())));
        selectGrade(CommonHelper.convertBooleanIntoString(additionalInformation.get(commonControlDataDef.LISTING_STATUS)));
        isHomeFloodedInLast25Years((Boolean) additionalInformation.get(commonControlDataDef.FREE_FLOODING_THREAT_VAR));
        isHomeFittedWithMultiPointLockingSystem(Objects.requireNonNull(CommonHelper.convertStringIntoBoolean(homeSecurity.get(LOCKS_VAR))));
        selectTypeIntruderAlarm((String)homeSecurity.get(ALARMS_VAR));
        ownOrRentHome(dynamicUnderwriterQuestions);
        portalGeneralStepDefinitions.continueButton();
    }


    public void enterCoverDetails(Map<String, Object> salesDetails) throws ParseException, CustomE2eException {
        var insuranceDetails = (Map<String, Object>)salesDetails.get(INSURANCE_DETAILS);
        //When do you want your cover to start? Friday, 16 June
        selectCoverStartDate(Formatting.changeDateFormatIntoExpected((String)(((Map<String, Object>)salesDetails.get(commonControlDataDef.QUOTE_DETAILS))
                .get(QuoteCreationOnQnBuyPortal.COVER_START_DATE)), "dd/MM/yyyy", "EEEE, d MMMM"));
        //How do you usually pay for your insurance?
        selectPaymentFrequency((String) ((Map<String, Object>)salesDetails.get(commonControlDataDef.DYNAMIC_UNDERWRITER_QUESTIONS)).get(commonControlDataDef.PAYMENT_STATUS_VAR));
        //When is your home normally occupied?
        normallyOccupiedAt((String) ((Map<String, Object>)insuranceDetails.get(commonControlDataDef.USAGE)).get(commonControlDataDef.OCCUPANCY_VAR));
        navigateThroughCoverDetailsPage();


    }

    private void navigateThroughCoverDetailsPage() throws CustomE2eException {
        portalGeneralStepDefinitions.continueButton();
    }

    public void enterContentCover(Map<String, Object> insuranceDetails) throws CustomE2eException {
        var typeOfHouseHoldCover = (Map<String, Object>)insuranceDetails.get(commonControlDataDef.TYPE_OF_HOUSE_HOLDE_COVER);
        var contentCoverQuestions  = (Map<String, Object>)insuranceDetails.get(commonControlDataDef.CONTENT_DETAILS_VAR);
        var insuranceHistory = (Map<String, Object>)insuranceDetails.get(commonControlDataDef.INSURANCE_HISTORY_VAR);
        var awayCostValue = ((Map<String, Object>)(contentCoverQuestions.get(QuoteCreationOnQnBuyPortal.IND_AWAY_HOME_SPECIFIED_ITEMS)));
        var valuablesCostValue = ((Map<String, Object>)(contentCoverQuestions.get(QuoteCreationOnQnBuyPortal.VALUABLE_IN_HOME_SPECIFIED_ITEMS)));

        heldContentInsuranceLast2Years(insuranceHistory);
        costToReplaceEntireContents(String.valueOf(((Map<String, Object>) insuranceDetails.get(commonControlDataDef.INSURED_AMOUNT_VAR)).get(commonControlDataDef.CONTENT_SUM_VAR)));
        contentsAccidentalDamageCover((CommonHelper.convertBooleanIntoString(typeOfHouseHoldCover.get(commonControlDataDef.CONTENT_ACCIDENTAL_DAMAGE_VAR))));
        valuablesOver2000£((ArrayList) valuablesCostValue.get(commonControlDataDef.IN_HOME),
                CommonHelper.convertBooleanIntoString(contentCoverQuestions.get(QuoteCreationOnQnBuyPortal.VALUABLES_OVER_2000£_SPECIFIED_ITEMS_AVAIL)));
        extraCoverForPersonalBelongingAwayFromHome(String.valueOf((contentCoverQuestions).get(QuoteCreationOnQnBuyPortal.PERSONAL_BELONGINGS_AWAY_COST)),
                CommonHelper.convertBooleanIntoString(contentCoverQuestions.get(QuoteCreationOnQnBuyPortal.PERS_BELONGINGS_SPECIFIED_ITEMS_AVAIL)));
        coverForIndividualBelongingAwayFromHome((ArrayList) awayCostValue.get(commonControlDataDef.AWAY_HOME),
                CommonHelper.convertBooleanIntoString(contentCoverQuestions.get(QuoteCreationOnQnBuyPortal.IND_BELONGINGS_SPECIFIED_ITEMS_AVAIL)));
        navigateThroughContentCover();
    }

    private void navigateThroughContentCover() throws CustomE2eException {
        portalGeneralStepDefinitions.continueButton();
    }

    public void navigateToPreviousPageOnQnB() throws CustomE2eException {
        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().BACK_BTN(), SyncType.CLICKABLE);
    }

    public void agreedAndProceedToQuote() throws CustomE2eException {
        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().AGREED_AND_PROCEED(), SyncType.CLICKABLE);
    }

    public void navigateBackToAboutYouPage() throws CustomE2eException {
        waitForPageLoad();
        navigateToPreviousPageOnQnB();
    }

    public void navigateBackToYourHomePage() throws CustomE2eException {
        waitForPageLoad();
        navigateBackToAboutYouPage();
        navigateToPreviousPageOnQnB();
    }

    public void enterBuildingCover(Map<String, Object> insuranceDetails) throws CustomE2eException {
        var typeOfHouseHoldCover = (Map<String, Object>)insuranceDetails.get(commonControlDataDef.TYPE_OF_HOUSE_HOLDE_COVER);
        haveYouEverHeldBuildingInsurance((Map<String, Object>)insuranceDetails.get(commonControlDataDef.INSURANCE_HISTORY_VAR));
        doYouNeedBuildingAccidentalDamage(CommonHelper.convertBooleanIntoString(typeOfHouseHoldCover.get(commonControlDataDef.BUILDING_ACCIDENTAL_DAMAGE_VAR)));

        navigateThroughBuildingCoverPage();
    }

    public void enterAboutYouDetails(Map<String, Object> salesDetails, Map<String, Object> insuranceDetails, Map<String, Object> proposerPersonalDetails,
                                    Map<String, Object> proposerContactDetails, Map<String, Object> marketingChoice) throws CustomE2eException {
        enterPersonalDetails(proposerPersonalDetails,
                (String) proposerPersonalDetails.get(commonControlDataDef.FIRST_NAME_VAR),
                (String) proposerPersonalDetails.get(commonControlDataDef.LAST_NAME_VAR));
        enterEmailAndPreferredNum((String) proposerContactDetails.get(commonControlDataDef.EMAIL_ADDRESS),
                (String) proposerContactDetails.get(QuoteCreationOnQnBuyPortal.MAIN_TELEPHONE_NUM));
        confirmCorrespondenceAddress((Map<String, Object>) ((Map<String, Object>)insuranceDetails.get(commonControlDataDef.BUILDING_DETAILS)).get(EisHomeQuoteCreationStepDefinition.BUILDING_ADDRESS_VAR),
                (Map<String, Object>)proposerContactDetails.get(commonControlDataDef.CORRESPONDENCE_ADDRESS));
        enterDateOfBirth((String) proposerPersonalDetails.get(QuoteCreationOnQnBuyPortal.DATE_OF_BIRTH));
        selectMaritalStatus((String) proposerPersonalDetails.get(QuoteCreationOnQnBuyPortal.MARITAL_STATUS));
        selectEmploymentStatus((Map<String, Object>) marketingChoice.get(commonControlDataDef.PRIMARY_EMPLOYMENT_STATUS_VAR));
        selectSecondJobDetails((Map<String, Object>) marketingChoice.get(commonControlDataDef.SECOND_EMPLOYMENT_STATUS_VAR));
        enterPolicyHolderDetails(String.valueOf(salesDetails.get(commonControlDataDef.JOINT_POLICY_HOLDER_STATUS)),
                (Map<String, Object>)salesDetails.get(commonControlDataDef.JOINT_POLICY_HOLDER_DET));
         portalGeneralStepDefinitions.continueButton();
    }

    public String enterAdditionalInformation(Map<String, Object> salesDetails, Map<String, Object> dynamicUnderwriterQuestions, Map<String, Object> houseUsage, Map<String, Object> otherDetails) throws CustomE2eException {
        var numberOfPeopleLive = (Map<String, Object>)dynamicUnderwriterQuestions.get(commonControlDataDef.NUM_PEOPLE_LIVE);
        selectAdultCountAtHome(numberOfPeopleLive.get(QuoteCreationOnQnBuyPortal.ADULT_NUMBER));
        selectChildCountAtHome(numberOfPeopleLive.get(QuoteCreationOnQnBuyPortal.CHILD_NUMBER));
        selectPetCountAtHomer((Map<String, Object>)numberOfPeopleLive.get(commonControlDataDef.PET_VAR)); //Do you have any pets living at your home?

        //Sarah changed to align with Quote and Buy Lodgers in usage section
        payingGuestLivingAtHome((String) houseUsage.get("NonFamilyLodger"));
        //payingGuestLivingAtHome((String) dynamicUnderwriterQuestions.get(QuoteCreationOnQnBuyPortal.TYPE_OF_LODGERS));  //Do you have any paying guests living at your home?
        homeUseBusinessPurpose((Boolean) houseUsage.get(QuoteCreationOnQnBuyPortal.HOUSE_USED_BUSINESS_PURPOSE));
        claimsInLastFiveYear(salesDetails);
        sufferedLosses((Boolean)(((Map<String, Object>) salesDetails.get(commonControlDataDef.OTHER_DETAILS)).get(commonControlDataDef.SUFFERED_LOSS_NOT_RESULTED_CLAIM)));
        //Have you or any persons USUALLY living with you suffered losses or incidents in the last five years where it did not result in a claim?
        selectContactPreferences((Map<String, Object>) salesDetails.get(commonControlDataDef.MARKETING_CHOICE_VAR));
        carInsuranceRenewalDate((Boolean) salesDetails.get(commonControlDataDef.CONSENT_TO_RENEW));
         portalGeneralStepDefinitions.continueButton();
        return viewQuote();
    }

    public String viewQuote() throws CustomE2eException {
        String quoteNumber = "";
        clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().AGREED_AND_PROCEED(), SyncType.CLICKABLE);
        waitForPageLoad();
        try {
            Thread.sleep(1000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        PerformActionThatMightBeBlockedByBusySpinner( Duration.ofSeconds(120), ()->
                clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().QUOTE_REFERENCE_NUMBER(), SyncType.VISIBLE));
        //waitForElement2(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().QUOTE_REFERENCE_NUMBER(), SyncType.VISIBLE, waitDuration);
        quoteNumber = getText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().QUOTE_REFERENCE_NUMBER(), "Quote Creation Failed");
        return quoteNumber;
    }

    public Map<?,?> enhancePolicyCover(Map<?, ?> optionalExtras, Map<String, Object>dataResult) throws CustomE2eException {
        var monthlyPayment = "";
        waitForPageLoad();
        PerformActionThatMightBeBlockedByBusySpinner( Duration.ofSeconds(300), ()->
                waitForElement2(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CONTINUE_BUTTON(), SyncType.CLICKABLE, waitDuration));

        addIncidentLegalCost((Boolean) optionalExtras.get(commonControlDataDef.LEGAL_EXPENSES));
        emergencyCover((Boolean) optionalExtras.get(commonControlDataDef.HOME_EMERGENCY));
        //addTotalExcessForClaim((Boolean) optionalExtras.get(commonControlDataDef.EXCESS_PROTECTION)); //Option missing on UI
        monthlyPayment = getText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().MONTHLY_PAYMENT_VALUE(), "Monthly Payment Value not Found");
        var buildingExcess = getText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().BUILDING_EXCESS_COMPULSORY(), "Building Excess Value not Found");
        var contentExcess = getText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CONTENT_EXCESS_COMPULSORY(), "Content Excess Value not Found");

        portalGeneralStepDefinitions.continueButton();
        //wait for pay button to be clickable
        PerformActionThatMightBeBlockedByBusySpinner( Duration.ofSeconds(300), ()->
                waitForElement2(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PAY_BUTTON(), SyncType.CLICKABLE,  waitDuration));

        var AnnualPayment = getText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().ANNUAL_PAYMENT_VALUE(), "Annual Payment Value not Found");
        var extraHomeCoverValue = getText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().EXTRA_HOME_COVER_VALUE(), "Extra Home Cover Value not Found");
        dataResult.put(commonControlDataDef.MONTHLY_PAYMENT, monthlyPayment);
        dataResult.put(commonControlDataDef.BUILDING_EXCESS, buildingExcess);
        dataResult.put(commonControlDataDef.CONTENT_EXCESS, contentExcess);
        dataResult.put(commonControlDataDef.ANNUAL_PAYMENT, AnnualPayment);
        dataResult.put(commonControlDataDef.EXTRA_HOME_COVER_VALUE, extraHomeCoverValue);
        return dataResult;
    }

    private void addIncidentLegalCost(Boolean addLegalExpenses) throws CustomE2eException {
        if(addLegalExpenses) {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().LEGAL_COST(), "Y"), SyncType.CLICKABLE);
            waitForElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().LEGAL_COST_ADD_BTN(), SyncType.VISIBLE);
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().LEGAL_COST_ADD_BTN(), SyncType.CLICKABLE);
        }else {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().LEGAL_COST(), "N"), SyncType.CLICKABLE);
        }
    }

    private void emergencyCover(Boolean homeEmergency) throws CustomE2eException {
        if(homeEmergency) {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOME_EMERGENCY(), "Y"), SyncType.CLICKABLE);
            //clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOME_EMERGENCY(), SyncType.CLICKABLE); //To be updated
        }else {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOME_EMERGENCY(), "N"), SyncType.CLICKABLE);
        }
    }

    private void addTotalExcessForClaim(Boolean totalExcess) throws CustomE2eException {
        if(totalExcess) {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().EXCESS_PROTECTION(), "Y"), SyncType.CLICKABLE);
            //clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().EXCESS_PROTECTION(), SyncType.CLICKABLE); //To be updated
        }else {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().EXCESS_PROTECTION(), "N"), SyncType.CLICKABLE);
        }
    }

    private void carInsuranceRenewalDate(Boolean carInsuranceDate) throws CustomE2eException {
        if(carInsuranceDate){
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CAR_INSURANCE(), CommonHelper.getCurrentMonth("MMMM"), SelectOptions.TEXT);
        }else {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CAR_INSURANCE(), QuoteCreationOnQnBuyPortal.NO_CAR_INSURANCE, SelectOptions.TEXT);
        }
    }

    private void sufferedLosses(Boolean sufferedLosses) throws CustomE2eException {
        var sufferedClaim = CommonHelper.convertBooleanIntoString(sufferedLosses);
        if (sufferedClaim.equalsIgnoreCase(PortalGeneralStepDefinitions.YES)) {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().SUFFERED_LOSS_YES(), sufferedClaim), SyncType.CLICKABLE);
        } else {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().SUFFERED_LOSS_NO(), sufferedClaim), SyncType.CLICKABLE);
        }
    }

    private void payingGuestLivingAtHome(String guestLiving) throws CustomE2eException {
        switch (guestLiving) {
            case "Lodgers":
                selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PAYING_GUEST_LIVING(), QuoteCreationOnQnBuyPortal.GUEST_LIVING_LODGERS, SelectOptions.TEXT);
                break;
            case "Students":
                selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PAYING_GUEST_LIVING(), QuoteCreationOnQnBuyPortal.GUEST_LIVING_STUDENTS, SelectOptions.TEXT);
                break;
            case "Students and Lodgers":
                selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PAYING_GUEST_LIVING(), QuoteCreationOnQnBuyPortal.GUEST_LIVING_STUDENTS_AND_LODGERS, SelectOptions.TEXT);
                break;
            case "No":
                selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PAYING_GUEST_LIVING(), QuoteCreationOnQnBuyPortal.GUEST_LIVING_NO, SelectOptions.TEXT);
                break;
            default:
        }
    }

    private void selectPetCountAtHomer(Map<String, Object> petDetails) throws CustomE2eException {
        waitForElement2(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PETS_LIVING(),
                SyncType.VISIBLE, waitDuration);
        boolean cat = (boolean) petDetails.get(commonControlDataDef.CAT_VAR);
        boolean dog = (boolean) petDetails.get(commonControlDataDef.DOG_VAR);
        boolean otherAnimal = (boolean) petDetails.get(commonControlDataDef.OTHER_VAR);
        if (cat && dog) {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PETS_LIVING(), QuoteCreationOnQnBuyPortal.CAT_AND_DOG_LIVING,
                    SelectOptions.TEXT);
        } else if (cat) {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PETS_LIVING(), QuoteCreationOnQnBuyPortal.CAT_LIVING,
                    SelectOptions.TEXT);
        } else if (dog) {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PETS_LIVING(), QuoteCreationOnQnBuyPortal.DOG_LIVING,
                    SelectOptions.TEXT);
        } else if (otherAnimal) {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PETS_LIVING(), QuoteCreationOnQnBuyPortal.OTHER_ANIMAL_LIVING,
                    SelectOptions.TEXT);
        } else {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PETS_LIVING(), QuoteCreationOnQnBuyPortal.NO_PET,
                    SelectOptions.TEXT);
        }
    }

    private void selectChildCountAtHome(Object numberOfChild) throws CustomE2eException {
        selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CHILD_COUNT(),
                String.valueOf(numberOfChild), SelectOptions.TEXT);
    }

    private void selectAdultCountAtHome(Object numberOfAdult) throws CustomE2eException{
        selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().ADULT_COUNT(),
                String.valueOf(numberOfAdult), SelectOptions.TEXT);
    }

    private void claimsInLastFiveYear(Map<String, Object> salesDetails) throws CustomE2eException {
        var claimHistInLastFiveYear = String.valueOf(salesDetails.get(commonControlDataDef.CLAIM_HIST_FLAG));
        var claimInLast5Year = CommonHelper.convertBooleanIntoString(claimHistInLastFiveYear);
        if(claimInLast5Year.equals(PortalGeneralStepDefinitions.NO)) {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CLAIM_LAST_FIVE_YEARS(), claimHistInLastFiveYear), SyncType.CLICKABLE);
        }else {
            /*var claimDetails = (ArrayList) salesDetails.get(INSTANCE_CLAIM_HISTORY);
            int countOfClaims = claimDetails.size();
            for (var incident : claimDetails) {
                selectIncidentDate(((Map<String, Object>) incident).get(QuoteCreationInPortalUI.DATE_OF_INCIDENT));
                clickElement(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().POLICY_SECTION(), (String) ((Map<String, Object>) incident).get(QuoteCreationInPortalUI.SECTION_POLICY)), SyncType.CLICKABLE);
                selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CLAIM_DESC(), ((Map<String, Object>) incident).get(QuoteCreationInPortalUI.CLAIM_DESC), SelectOptions.TEXT);
                typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().VALUE_CLAIM(),
                        ((Map<String, Object>) incident).get(QuoteCreationInPortalUI.CLAIM_COST), SyncType.CLICKABLE, "claimsInLastFiveYear failed");
                countOfClaims--;
                clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().ADD_CLAIM(), SyncType.CLICKABLE);
                if (countOfClaims != 0) {
                    clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().ADD_NEW_CLAIM(), SyncType.CLICKABLE);
                }
            }*/
        }
    }

    private void selectIncidentDate(Object incidentDate) throws CustomE2eException{
        selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().MONTH_INCIDENT(), Formatting.covertNumberIntoMonths(Integer.parseInt(String.valueOf(incidentDate).split("/")[0])), SelectOptions.TEXT);
        selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().YEAR_INCIDENT(), incidentDate.toString().split("/")[1], SelectOptions.TEXT);
    }

    private void homeUseBusinessPurpose(Boolean homeUsed)  throws CustomE2eException{
        var homeUsePurpose = String.valueOf(homeUsed);
        if (homeUsed) {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOME_USED(), homeUsePurpose), SyncType.CLICKABLE);
            /*if("Cleaical use") {
                //Is this clerical business use only (no employees or visitors)?
                clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CLERICAL_BUSINESS_USE_YES(), SyncType.CLICKABLE);
            }else { //---->> To be completed when Yaml has Business Clerical field
                clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CLERICAL_BUSINESS_USE_NO(), SyncType.CLICKABLE);
            }*/
        } else {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOME_USED(), homeUsePurpose), SyncType.CLICKABLE);
        }
    }

    private void selectContactPreferences(Map<String, Object> contactPreference) throws CustomE2eException{
        var listOfPreference = contactPrefernce(contactPreference.values().toString());
        for (var preference : listOfPreference) {
            if(preference.toString().trim().equalsIgnoreCase("email") && (Boolean) contactPreference.get(commonControlDataDef.MARKETING_CHOICE_EMAIL_VAR)) {
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CONTACT_EMAIL_PREFERENCE(), SyncType.CLICKABLE);
            }if (preference.toString().trim().equalsIgnoreCase("phone") && (Boolean) contactPreference.get(commonControlDataDef.MARKETING_CHOICE_TELEPHONE_VAR)) {
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CONTACT_PHONE_PREFERENCE(), SyncType.CLICKABLE);
            }if (preference.toString().trim().equalsIgnoreCase("post") && (Boolean) contactPreference.get(commonControlDataDef.MARKETING_CHOICE_POSTAL_VAR)) {
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CONTACT_POST_PREFERENCE(), SyncType.CLICKABLE);
            }if (preference.toString().trim().equalsIgnoreCase("text") && (Boolean) contactPreference.get(commonControlDataDef.MARKETING_CHOICE_SMS_VAR)) {
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CONTACT_TEXT_PREFERENCE(), SyncType.CLICKABLE);
            }
        }
    }

    private ArrayList contactPrefernce(String listOfPreference) {
        ArrayList userPref = new ArrayList(Arrays.asList(listOfPreference.split(",")));
        ArrayList allAvailPref = new ArrayList();
        allAvailPref.add(QuoteCreationOnQnBuyPortal.CONTACT_PREFERENCE_POST);
        allAvailPref.add(QuoteCreationOnQnBuyPortal.CONTACT_PREFERENCE_EMAIL);
        allAvailPref.add(QuoteCreationOnQnBuyPortal.CONTACT_PREFERENCE_PHONE);
        allAvailPref.add(QuoteCreationOnQnBuyPortal.CONTACT_PREFERENCE_TEXT);
        for (var prefernce : userPref) {
            allAvailPref.remove(prefernce.toString().trim());
        }
        return allAvailPref;
    }

    private void enterEmailAndPreferredNum(String email, String preferredNum) throws CustomE2eException {
        typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().EMAIL(), email,
            SyncType.VISIBLE, "enterEmailAndPreferredNum failed");
        typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PREFERRED_PHONE_NUM(), preferredNum, SyncType.VISIBLE, "enterEmailAndPreferredNum failed");
    }

    private void enterPolicyHolderDetails(String jointHolderStatus, Map<String,Object>jointHolderDetails) throws CustomE2eException {
        waitForPageLoad();
        if (CommonHelper.convertStringIntoBoolean(jointHolderStatus)) {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().JOINT_POLICY_HOLDER(), String.valueOf(jointHolderStatus)), SyncType.CLICKABLE);
            addJointPolicyHolderDetails(jointHolderDetails);
        }else {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().JOINT_POLICY_HOLDER(), String.valueOf(jointHolderStatus)), SyncType.CLICKABLE);
        }
    }

    public void addJointPolicyHolderDetails(Map<String,Object>jointHolderDetails) throws CustomE2eException {
        enterPersonalDetails(jointHolderDetails,
                (String) jointHolderDetails.get(QuoteCreationOnQnBuyPortal.FIRST_NAME),
                (String) jointHolderDetails.get(QuoteCreationOnQnBuyPortal.LAST_NAME));
        enterDateOfBirth((String) jointHolderDetails.get(QuoteCreationOnQnBuyPortal.DATE_OF_BIRTH));
        selectJointHolderMaritalStatus((String) jointHolderDetails.get(QuoteCreationOnQnBuyPortal.MARITAL_STATUS));
        selectRelationshipWithPolicyHolder((String) jointHolderDetails.get(QuoteCreationOnQnBuyPortal.RELATIONSHIP));
        selectEmploymentStatus((Map<String, Object>) jointHolderDetails.get(CommonControlDataDefns.PRIMARY_EMPLOYMENT_STATUS_VAR));
        selectSecondJobDetails((Map<String, Object>) jointHolderDetails.get(CommonControlDataDefns.SECOND_EMPLOYMENT_STATUS_VAR));
    }

    private void selectRelationshipWithPolicyHolder(String relationship) throws CustomE2eException{
        selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().RELATIONSHIP_WITH_YOU(), relationship, SelectOptions.TEXT);
    }

    private void selectSecondJobDetails(Map<String, Object> secondJobDetails) throws CustomE2eException {
        var secondJobStatus = secondJobDetails.get(commonControlDataDef.JOB_CATEGORY_EMPLOYED_VAR);
        if ((Boolean) secondJobStatus == true) {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().SECOND_JOB(),
                    String.valueOf(secondJobStatus)), SyncType.CLICKABLE);
            selectSecondJobStatusDetails(secondJobDetails);
        }else {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().SECOND_JOB(),
                    String.valueOf(secondJobStatus)), SyncType.CLICKABLE);
        }
    }

    private void selectEmploymentStatus(Map<String, Object> employmentDetails) throws CustomE2eException {
        String employmentStatus = (String) employmentDetails.get(commonControlDataDef.CATEGORY_VAR);
        selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().EMPLOYMENT_STATUS(), employmentStatus, SelectOptions.TEXT);
        employmentStatus(employmentStatus, employmentDetails);
    }

    private void selectSecondJobStatusDetails(Map<String, Object> employmentDetails) throws CustomE2eException {
        String employmentStatus = (String) employmentDetails.get(commonControlDataDef.CATEGORY_VAR);
        selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().SECOND_JOB_EMPLOYMENT_STATUS(), employmentStatus, SelectOptions.TEXT);
        employmentStatus(employmentStatus, employmentDetails);
    }

    private void employmentStatus(String employmentStatus, Map<String, Object> employmentDetails) throws CustomE2eException {
        if (employmentStatus.equalsIgnoreCase(QuoteCreationOnQnBuyPortal.PRIM_JOB_CATEGORY_EMPLOYEE_VAR)
                || employmentStatus.equalsIgnoreCase(QuoteCreationOnQnBuyPortal.SELF_EMPLOYED)
                || employmentStatus.equalsIgnoreCase(QuoteCreationOnQnBuyPortal.COMP_DIRECTOR)
                || employmentStatus.equalsIgnoreCase(QuoteCreationOnQnBuyPortal.GOVT_EMPLOYEE)
                || employmentStatus.equalsIgnoreCase(QuoteCreationOnQnBuyPortal.BUSINESS_OWNER)) {
            typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().JOB_TYPE(),
                (String) employmentDetails.get(QuoteCreationOnQnBuyPortal.JOB_TYPE), SyncType.CLICKABLE, "Entering job type failed");
            clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().JOB_TYPE_SUGGESTION(), SyncType.CLICKABLE);
            typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().JOB_INDUSTRY(),
                (String) employmentDetails.get(QuoteCreationOnQnBuyPortal.JOB_INDUSTRY), SyncType.CLICKABLE, "Entering job industry failed");
            clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().JOB_TYPE_SUGGESTION(), SyncType.CLICKABLE);
        } else if (employmentStatus.equalsIgnoreCase(QuoteCreationOnQnBuyPortal.FULL_TIME_EDUCATION)) {
            typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().STUDENT_JOB_TYPE(), (String) employmentDetails.get(QuoteCreationOnQnBuyPortal.JOB_TYPE), SyncType.CLICKABLE, "Entering full time education failed");
        }
    }

    private void selectMaritalStatus(String s) throws CustomE2eException {
        selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().MARITAL_STATUS(), s, SelectOptions.TEXT);
    }

    private void selectJointHolderMaritalStatus(String s) throws CustomE2eException {
        selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().JOINT_HOLDER_MARITAL_STATUS(), s, SelectOptions.TEXT);
    }

    private void enterDateOfBirth(String dateOfBirth) throws CustomE2eException {
        typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().BIRTH_DATE(),
            dateOfBirth.split("/")[0], SyncType.CLICKABLE, "enterDateOfBirth day failed" );
        typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().BIRTH_MONTH(),
            dateOfBirth.split("/")[1], SyncType.CLICKABLE, "enterDateOfBirth month failed");
        typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().BIRTH_YEAR(),
            dateOfBirth.split("/")[2], SyncType.CLICKABLE, "enterDateOfBirth year failed");
    }

    public void confirmCorrespondenceAddress(Map<String, Object> buildingAddress, Map<String, Object> correspondenceAdd) throws CustomE2eException {
        var riskAddressHouseIdentifier = String.valueOf(buildingAddress.get(commonControlDataDef.HOUSE_IDENTIFIER));
        var correspondenceAddressHouseIdentifier = String.valueOf(correspondenceAdd.get(commonControlDataDef.HOUSE_IDENTIFIER));
        var riskAddressPostCode = String.valueOf(buildingAddress.get(commonControlDataDef.POSTCODE));
        var correspondenceAddressPostCode = String.valueOf(correspondenceAdd.get(commonControlDataDef.POSTCODE));

        //clickElement(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CORRESPONDENCE_ADDRESS(), String.valueOf(correspondenceAdd.get(QuoteCreationInPortalUI.YES_OR_NO))), SyncType.CLICKABLE);
        if (riskAddressHouseIdentifier.equalsIgnoreCase(correspondenceAddressHouseIdentifier) && riskAddressPostCode.equalsIgnoreCase(correspondenceAddressPostCode)) {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CORRESPONDENCE_ADDRESS(), "true"), SyncType.CLICKABLE);
        }else {
            clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CORRESPONDENCE_ADDRESS(), "false"), SyncType.CLICKABLE);
        }

    }

    private void enterPersonalDetails(Map<String, Object>proposerPersonalDetails, String firstName, String lastName) throws CustomE2eException {
        var title = (String) proposerPersonalDetails.get(commonControlDataDef.TITLE);
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().TITLE(),
                Formatting.capitalizeFirstCharacter(title)), SyncType.CLICKABLE);
        if (title.equalsIgnoreCase("Dr") || title.equalsIgnoreCase("Doctor")) {
            selectGender((String) proposerPersonalDetails.get(commonControlDataDef.GENDER));
        }
        typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().FIRST_NAME(),
            firstName, SyncType.VISIBLE, "enterPersonalDetails failed");
        typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().LAST_NAME(),
            lastName, SyncType.VISIBLE, "enterPersonalDetails failed");
    }

    private void selectGender(String gender) throws CustomE2eException {
        clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().GENDER(),
                Formatting.capitalizeFirstCharacter(gender)), SyncType.CLICKABLE);
    }

    private void navigateThroughBuildingCoverPage() throws CustomE2eException {
         portalGeneralStepDefinitions.continueButton();
    }

    private void haveYouEverHeldBuildingInsurance(Map<String, Object> heldBuildingInsurance) throws CustomE2eException {
        String heldBuildingInsuranceAns = CommonHelper.convertBooleanIntoString(heldBuildingInsurance.get(commonControlDataDef.PREV_INSURANCE_VAR));
        if (heldBuildingInsuranceAns.equalsIgnoreCase(PortalGeneralStepDefinitions.YES)) {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HELD_BUILDING_INSURANCE_YES(), SyncType.CLICKABLE);
            selectClaimFreeYears(heldBuildingInsurance.get(QuoteCreationOnQnBuyPortal.BUILDING_CLAIM_FREE_YEARS));
        } else {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HELD_BUILDING_INSURANCE_NO(), SyncType.CLICKABLE);
        }
    }

    private void doYouNeedBuildingAccidentalDamage(String buildingAccidentalCoverNeeded) throws CustomE2eException {
        if (buildingAccidentalCoverNeeded.equalsIgnoreCase(PortalGeneralStepDefinitions.YES)) {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().BUILDING_ACCIDENTAL_DAMAGE_COVER_NEEDED_YES(), SyncType.CLICKABLE);
        } else {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().BUILDING_ACCIDENTAL_DAMAGE_COVER_NEEDED_NO(), SyncType.CLICKABLE);
        }
    }

    private void coverForIndividualBelongingAwayFromHome(ArrayList individualItemsCover, String individualCover) throws CustomE2eException {
        addCoverForIndividualItems(individualItemsCover, individualCover);
    }

    private void addCoverForIndividualItems(ArrayList individualItemsCover, String individualCover) throws CustomE2eException {
        if (individualCover.equalsIgnoreCase(PortalGeneralStepDefinitions.YES)) {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().INDIVIDUAL_ITEM_COVER_YES(), SyncType.CLICKABLE);
            addValuableItems(individualItemsCover);
        } else {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().INDIVIDUAL_ITEM_COVER_NO(), SyncType.CLICKABLE);
        }
    }

    private void valuablesOver2000£(ArrayList valuablesDetails, String doYouHaveValuablesOver2000£) throws CustomE2eException {
        if (doYouHaveValuablesOver2000£.equalsIgnoreCase(PortalGeneralStepDefinitions.YES)) {
            clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().VALUABLE_ITEMS_OVER_2000£_YES(), SyncType.CLICKABLE);
            addValuableItems(valuablesDetails);
        } else {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().VALUABLE_ITEMS_OVER_2000£_NO(), SyncType.CLICKABLE);
        }
         //Do you have any valuables over £2,000 that you don’t take outside of the home? - NO
        //LOOP - Category, Description, Estimated Cost. - YES
    }

    public void addValuableItems(ArrayList listOfDetails) throws CustomE2eException {
        int detailCount = listOfDetails.size();
        for (var details : listOfDetails) {
            String category = ((Map<String, Object>) details).get(QuoteCreationOnQnBuyPortal.ITEM).toString();
            String description = ((Map<String, Object>) details).get(QuoteCreationOnQnBuyPortal.DESCRIPTION).toString();
            String cost = ((Map<String, Object>) details).get(QuoteCreationOnQnBuyPortal.VALUE).toString();

            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().VALUABLE_ITEMS_CATEGORY(), category, SelectOptions.TEXT);
            typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().VALUABLE_ITEMS_DESCRIPTION(), description, SyncType.VISIBLE, "enterValuableDetails failed");
            typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().VALUABLE_ITEMS_COST(), cost, SyncType.VISIBLE, "enterValuableDetails failed");
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().SAVE_BUTTON(), SyncType.CLICKABLE);
            detailCount--;
            if (detailCount == 0) {
                break;
            }else {
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().ADD_ANOTHER_ITEM(), SyncType.CLICKABLE);
            }
        }
    }

    private void extraCoverForPersonalBelongingAwayFromHome(String extraCoverCost, String likesExtraCover) throws CustomE2eException {
        if (likesExtraCover.equalsIgnoreCase(PortalGeneralStepDefinitions.YES)) {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().EXTRA_COVER_FOR_BELONGINGS_YES(), SyncType.CLICKABLE);
            //How much cover would you like for personal belongings away from the home? YES
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().COVER_COST_FOR_BELONGINGS(), Formatting.getCurrencyValue(Integer.parseInt(extraCoverCost)), SelectOptions.TEXT);
        } else {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().EXTRA_COVER_FOR_BELONGINGS_NO(), SyncType.CLICKABLE);
        }
    }

    private void contentsAccidentalDamageCover(String accidentalDamageCover) throws CustomE2eException {
        if (accidentalDamageCover.equalsIgnoreCase(PortalGeneralStepDefinitions.YES)) {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CONTENTS_ACCIDENTAL_DAMAGE_COVER_YES(), SyncType.CLICKABLE);
        } else {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CONTENTS_ACCIDENTAL_DAMAGE_COVER_NO(), SyncType.CLICKABLE);
        }
    }

    private void costToReplaceEntireContents(String costOfReplacement) throws CustomE2eException {
        var costToReplace = formatDropDownAmount(costOfReplacement);  //Future Implementation required to use $$ feature (18/01/24)
        selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().COST_REPLACE_ENTIRE_CONTENTS(), costToReplace, SelectOptions.TEXT);
    }

    private void heldContentInsuranceLast2Years(Map<String, Object> heldContentInsurance) throws CustomE2eException {
        if (!heldContentInsurance.get(commonControlDataDef.CONTENT_CLAIM_FREE_YEARS_VAR).equals(QuoteCreationOnQnBuyPortal.CLAIM_FREE_YEARS_VAR)) {
            clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HELD_CONTENTS_INSURANCE_YES(), SyncType.CLICKABLE);
            selectClaimFreeYears(heldContentInsurance.get(commonControlDataDef.CONTENT_CLAIM_FREE_YEARS_VAR));
        } else {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HELD_CONTENTS_INSURANCE_NO(), SyncType.CLICKABLE);
        }
    }

    public void selectClaimFreeYears(Object claimFreeYears) throws CustomE2eException {
        int claimFreeYear = Integer.parseInt(String.valueOf(claimFreeYears));
        if (claimFreeYear < 1) {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CLAIM_FREE_YEARS_CONTENT_BUILDING(), 0, SelectOptions.VALUE);
        } else if (claimFreeYear >= 9) {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CLAIM_FREE_YEARS_CONTENT_BUILDING(), 9, SelectOptions.VALUE);
        } else {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CLAIM_FREE_YEARS_CONTENT_BUILDING(), claimFreeYears, SelectOptions.VALUE);
        }
    }

    private void normallyOccupiedAt(String occupiedTime) throws CustomE2eException {
        By byLocator = null;
        switch (occupiedTime) {
            case QuoteCreationOnQnBuyPortal.NORMALLY_OCCUPIED:
                byLocator =
                    this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().DAY_AND_NIGHT();
                break;
            case QuoteCreationOnQnBuyPortal.DURING_DAY:
                byLocator =
                    this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().DURING_THE_DAY();
                break;
            case QuoteCreationOnQnBuyPortal.DURING_NIGHT:
                byLocator =
                    this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().DURING_THE_NIGHT();
                break;
            case QuoteCreationOnQnBuyPortal.UNOCCUPIED:
                byLocator =
                    this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().UNOCCUPIED();
        }
        clickElementRetryX3onClickIntEx(byLocator, SyncType.CLICKABLE);
    }

    public void selectPaymentFrequency(String frequencyPay) throws CustomE2eException {
        waitForPageLoad();
        if (frequencyPay.equalsIgnoreCase(QuoteCreationOnQnBuyPortal.ANNUALLY)) {
            clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().ANNUALLY(),
                SyncType.CLICKABLE);
        } else if (frequencyPay.equalsIgnoreCase(QuoteCreationOnQnBuyPortal.MONTHLY)){
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().MONTHLY(),
                SyncType.CLICKABLE);
        }
    }

    public void selectCoverStartDate(String effectiveDate) throws CustomE2eException, ParseException {
        waitForElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().COVER_START_DATE(), SyncType.VISIBLE);
        String changeDateFormatIntoExpected = Formatting.changeDateFormatIntoExpected(effectiveDate, "dd/MM/yyyy", "EEEE, d MMMM");
        selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().COVER_START_DATE(), changeDateFormatIntoExpected, SelectOptions.TEXT);
    }


    public void enterNumberOfBathroomAndBedroom(Object bedroomNum, Object bathroomNum) throws CustomE2eException {
        waitForElement2(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().NUMBER_OF_BEDROOM(),SyncType.CLICKABLE,waitDuration);
        selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().NUMBER_OF_BEDROOM(), String.valueOf(bedroomNum), SelectOptions.TEXT);
        selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().NUMBER_OF_BATHROOMS(), String.valueOf(bathroomNum), SelectOptions.TEXT);
    }

    private void enterBuiltYear(Object builtYear) throws CustomE2eException {
        int year = Integer.parseInt(String.valueOf(builtYear));

        if (year < 1750) {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOUSE_BUILT_YEAR(), "1749", SelectOptions.VALUE);
        } else if (year == 1750 && year <= 1869) {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOUSE_BUILT_YEAR(), "1750", SelectOptions.VALUE);
        } else if (year >= 1870 && year <= 1899) {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOUSE_BUILT_YEAR(), "1870", SelectOptions.VALUE);
        } else if (year >= 1900 && year <= 1919) {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOUSE_BUILT_YEAR(), "1900", SelectOptions.VALUE);
        } else if (year >= 1920 && year <= 1945) {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOUSE_BUILT_YEAR(), "1920", SelectOptions.VALUE);
        } else if (year >= 1946 && year <= 1959) {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOUSE_BUILT_YEAR(), "1946", SelectOptions.VALUE);
        } else if (year >= 1960 && year <= 1979) {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOUSE_BUILT_YEAR(), "1960", SelectOptions.VALUE);
        } else if (year >= 1980 && year <= 1989) {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOUSE_BUILT_YEAR(), "1980", SelectOptions.VALUE);
        } else if (year >= 1990 && year <= 1999) {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOUSE_BUILT_YEAR(), "1990", SelectOptions.VALUE);
        } else if (year >= 2000 && year <= 2004) {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOUSE_BUILT_YEAR(), "2000", SelectOptions.VALUE);
        } else if (year >= 2005 && year <= 2009) {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOUSE_BUILT_YEAR(), "2005", SelectOptions.VALUE);
        } else {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOUSE_BUILT_YEAR(), "2010", SelectOptions.VALUE);
        }

    }

    private void isHomeExtended(Boolean homeExtended) throws CustomE2eException {
        //scrollElementIntoCenterOfScreen(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOME_EXTENDED_YES());
        if (homeExtended) {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOME_EXTENDED_YES(), SyncType.CLICKABLE);
        } else {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOME_EXTENDED_NO(), SyncType.CLICKABLE);
        }
    }

    private void selectGrade(String gradeOfHouse) throws CustomE2eException {
        switch (gradeOfHouse) {
            case QuoteCreationOnQnBuyPortal.GRADE1:
                clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().GRADE1()
                    , SyncType.CLICKABLE);
                break;
            case QuoteCreationOnQnBuyPortal.GRADE2:
                clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().GRADE2()
                    , SyncType.CLICKABLE);
                break;
            case QuoteCreationOnQnBuyPortal.GRADE2_STAR:
                clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().GRADE2_STAR(), SyncType.CLICKABLE);
                break;
            case QuoteCreationOnQnBuyPortal.NO_GRADE:
                clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().NO_GRADE(), SyncType.CLICKABLE);
                break;
            default:
        }
    }

    private void isHomeFloodedInLast25Years(Boolean homeIsNotFlooded) throws CustomE2eException {
        if (homeIsNotFlooded) {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().FLOODED_NO(), SyncType.CLICKABLE);
        } else {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().FLOODED_YES()
                , SyncType.CLICKABLE);
        }
    }

    private void isHomeFittedWithMultiPointLockingSystem(Boolean multiLockingSystem) throws CustomE2eException {
        if (multiLockingSystem) {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().MULTI_LOCK_SYSTEM_YES(), SyncType.CLICKABLE);
        } else {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().MULTI_LOCK_SYSTEM_NO(), SyncType.CLICKABLE);
        }
    }

    private void selectTypeIntruderAlarm(String intruderAlarm) throws CustomE2eException {
        String IntruderAlarmItem = StringUtils.deleteWhitespace(intruderAlarm);
        switch (IntruderAlarmItem) {
            case "BasicDIYAlarm":
                setIntruderAlarm(CommonControlDataDefns.BASIC_ALARMS_VAR);
                break;
            case "TelephoneLink":
                setIntruderAlarm(CommonControlDataDefns.TELEPHONE_LINK_VAR);
                break;
            case "ApprovedAndMaintainedAlarm":
                setIntruderAlarm(CommonControlDataDefns.APPROVED_AND_MAINTAINED_ALARM_VAR);
                break;
            case "No":
                setIntruderAlarm(CommonControlDataDefns.NO_ALARM_VAR);
                break;
        }
    }

    private void ownOrRentHome(Map<String, Object> ownOrRent) throws CustomE2eException {
        String typeOfHome = (String) ownOrRent.get(QuoteCreationOnQnBuyPortal.PROPERTY_OWNED);
        switch (typeOfHome) {
            case QuoteCreationOnQnBuyPortal.OWNED_OUTRIGHT:
                clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().OWNED_OUTRIGHT(), SyncType.CLICKABLE);
                break;
            case QuoteCreationOnQnBuyPortal.OWNED_ON_MORTGAGE:
                clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().OWNED_ON_MORTGAGE(), SyncType.CLICKABLE);
                break;
            case QuoteCreationOnQnBuyPortal.PRIVATELY_RENTED:
                clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PRIVATELY_RENTED(), SyncType.CLICKABLE);
                isItFurnished((String) ownOrRent.get(QuoteCreationOnQnBuyPortal.FURNISHED_HOME));
                break;
            case QuoteCreationOnQnBuyPortal.HOUSING_ASSOCIATION:
                clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOUSING_ASSOCIATION(), SyncType.CLICKABLE);
                isItFurnished((String) ownOrRent.get(QuoteCreationOnQnBuyPortal.FURNISHED_HOME));
                break;
            case QuoteCreationOnQnBuyPortal.COUNCIL_RENTED:
                clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().COUNCIL_RENTED(), SyncType.CLICKABLE);
                isItFurnished((String) ownOrRent.get(QuoteCreationOnQnBuyPortal.FURNISHED_HOME));
                break;
            default:
        }


    }

    public void setIntruderAlarm(String dropDownItem) throws CustomE2eException {
        try {
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().INTRUDER_ALARM(), dropDownItem, SelectOptions.TEXT);
        } catch (Exception e) {
            throw new CustomE2eException("Intruder Alarm not listed");
        }
    }

    private void isItFurnished(String furnishedOrNot) throws CustomE2eException {
        if (furnishedOrNot.equalsIgnoreCase(PortalGeneralStepDefinitions.YES)) {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().FURNISHED(),
                SyncType.CLICKABLE);
        } else {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().UNFURNISHED(), SyncType.CLICKABLE);
        }
    }

    private void homeBuiltOfStandardConstruction(String builtStdConst) throws CustomE2eException {
        if (builtStdConst.equalsIgnoreCase(commonControlDataDef.CONST_TYPE_STANDARD_VAR)) {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().BUILT_STANDARD_CONSTRUCTION_YES(), SyncType.CLICKABLE);
        } else {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().BUILT_STANDARD_CONSTRUCTION_NO(), SyncType.CLICKABLE);
            //selectConstructionDetails(builtStdConst);
        }
    }

    private void selectConstructionDetails(Map<String, Object> builtStdConst) throws CustomE2eException {
        selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().EXTERNAL_WALLS_MADE_OF(), builtStdConst.get(QuoteCreationOnQnBuyPortal.EXTERNAL_WALL_MADE_OF), SelectOptions.TEXT);
        selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().ROOF_MADE_OF(), builtStdConst.get(QuoteCreationOnQnBuyPortal.ROOF_MADE_OF), SelectOptions.TEXT);
        if ((Integer) builtStdConst.get(QuoteCreationOnQnBuyPortal.PERCENTAGE_OF_FLAT_ROOF) < 34) {
            clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().OPTION1(),
                SyncType.CLICKABLE);
        } else if ((Integer) builtStdConst.get(QuoteCreationOnQnBuyPortal.PERCENTAGE_OF_FLAT_ROOF) < 51) {
            clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().OPTION2(),
                SyncType.CLICKABLE);
        } else {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().OPTION3(),
                SyncType.CLICKABLE);
        }

    }

    private void selectPropertyType(Map<String, Object> homeDetails) throws CustomE2eException {
        String propertyType = (String) homeDetails.get(QuoteCreationOnQnBuyPortal.BUILDING_TYPE);
        switch (propertyType) {
            case BUILDING_TYPE_BUNGLOW_VAR:
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PROPER_TYPE_BUNGLOW(), SyncType.CLICKABLE);
                whatBestDescribesYourHome(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().BEST_DESC_HOME(), (String) homeDetails.get(commonControlDataDef.BEST_DESC_YOUR_HOME));
                break;
            case BUILDING_TYPE_HOUSE_VAR:
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PROPER_TYPE_HOUSE(), SyncType.CLICKABLE);
                whatBestDescribesYourHome(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().BEST_DESC_HOME(), (String) homeDetails.get(commonControlDataDef.BEST_DESC_YOUR_HOME));
                break;
            case BUILDING_TYPE_TOWN_HOUSE_VAR:
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PROPER_TYPE_TOWN_HOUSE(), SyncType.CLICKABLE);
                whatBestDescribesYourHome(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().BEST_DESC_HOME(), (String) homeDetails.get(commonControlDataDef.BEST_DESC_YOUR_HOME));
                break;
            case BUILDING_TYPE_SELF_CONTAINED_FLAT_VAR:
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PROPER_TYPE_SELF_CONTAINED_FLAT(), SyncType.CLICKABLE);
                whatBestDescribesYourHome(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().BEST_DESC_HOME(), (String) homeDetails.get(commonControlDataDef.BEST_DESC_YOUR_HOME));    //Detached/Semi-Detached/End Terraced/Mid-Terraced
                break;
            case BUILDING_TYPE_MAISONETTE_VAR:
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().PROPER_TYPE_MAISONETTE(), SyncType.CLICKABLE);
                break;
            default:
        }
    }

    private void whatBestDescribesYourHome(By byLocator, String selectOption) throws CustomE2eException {
        selectDropdown(byLocator, selectOption, SelectOptions.TEXT);
    }

    private void enterAddress(String houseNo, String postcode) throws CustomE2eException {
        if (!isElementVisible(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOUSE_NUM(), String.valueOf(houseNo)))) {
            findAddress(postcode);
            waitForPageLoad();
            selectDropdown(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().ADDRESS_LIST(), 1, SelectOptions.INDEX);
        }else {
            typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOUSE_NUM(), houseNo
                    , SyncType.VISIBLE, "enterAddress failed");
            findAddress(postcode);
        }
        /*typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().POST_CODE(),
            postcode, SyncType.VISIBLE, "enterAddress failed");
        waitForPageLoad();
        PerformActionThatMightBeBlockedByBusySpinner( Duration.ofSeconds(30), ()->
        clickElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().FIND_ADDRESS_BTN(), SyncType.CLICKABLE));

        waitForElement(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().COMPLETE_ADDRESS(), SyncType.CLICKABLE);*/
    }

    public void findAddress(String postcode) throws CustomE2eException {
        typeText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().POST_CODE(), postcode, SyncType.VISIBLE, "enterAddress failed");
        waitForPageLoad();
        PerformActionThatMightBeBlockedByBusySpinner( Duration.ofSeconds(30), ()->
                clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().FIND_ADDRESS_BTN(), SyncType.CLICKABLE));
    }

    public void coverType(Boolean coverType, Boolean buildingType) throws CustomE2eException {
        if(coverType && buildingType){
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().BUILDING_AND_CONTENT() , SyncType.CLICKABLE);
        } else if(coverType) {
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CONTENTS_ONLY(), SyncType.CLICKABLE);
        } else if(buildingType){
            clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().BUILDING_ONLY(), SyncType.CLICKABLE);
        }
    }

}

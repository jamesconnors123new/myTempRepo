package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import UiWrappers.Browser;
import helpers.AgeasDigitalReactPortalHelpers;
import helpers.CommonHelper;
import helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetMTAListFromPortalStepDefinition extends AgeasDigitalReactPortalHelpers {

    private final WebDriver driver;
    private static String HOME_POLICYHOLDER_DETAILS = "PolicyHolderDetails";
    private static String RISK_ADDRESS = "RiskAddress";
    private static String HOME_COVER = "CoverDetails";
    private static String CAR_DRIVER_DETAILS = "VehicleDrivers";
    private static String CAR_COVER = "CoverDetails";
    private static String MOTOR = "Car";
    private static String HOME = "Home";
    private final long waitDuration = 30000L;
    private static String CUSTOMER_ID;


    private final PortalLoginStepDefinition PortalLoginPage;
    private final PerformMTAStepDefinition PerformMTAStepDefinition;

    public GetMTAListFromPortalStepDefinition(Browser pBrowser, PageObjects.PortalModel.Root pageObjectOfPortal) {
        super(pBrowser.Wd(), pageObjectOfPortal);
        this.driver = pBrowser.Wd();
        this.PortalLoginPage = new PortalLoginStepDefinition(pBrowser.Wd(), pageObjectOfPortal);
        this.PerformMTAStepDefinition = new PerformMTAStepDefinition(pBrowser,
            pageObjectOfPortal);
    }


    public Map<String, Object> getMTAList(WebDriver pDriver, String policyNumber, String effectiveDate, String customerEmail) throws CustomE2eException, ParseException {

        var vSelHelper = new SeleniumHelper(pDriver);

        List<String> homeMTABeforeFormatting = null;
        List<String> motorMTABeforeFormatting = null;

        var motorDriversDetailsMTA = false;
        var motorChangeCarMTA = false;
        var motorAddressMTA = false;
        var homePersonalDetailsMTA = false;
        var homeAddressMTA = false;
        var homeCoverMTA = false;
        var effectiveDateValue = LocalDate.parse(effectiveDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (policyNumber.trim().startsWith("GD")) {
            vSelHelper.isElementVisible(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_MOTOR_TAB());
            redirectToCarTab();
            var policyNumberOnPortal =
                vSelHelper.getText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().POLICY_NUMBER());
            if (policyNumberOnPortal.equalsIgnoreCase(policyNumber.trim())) {
                motorMTABeforeFormatting = vSelHelper.getTextAllWebElementMatchingLocator(this.pageObjectOfPortal.getPerformMTALocatorModel().MOTOR_MTA_ELEMENTS());
                if(vSelHelper.isElementVisible(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CHANGE_TEXT())) {
                    var changeTextOnPortal = vSelHelper.getText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CHANGE_TEXT());
                    var extractedDate = CommonHelper.extractDateFromString(LocalDate.now(), changeTextOnPortal);
                    if (extractedDate.isAfter(LocalDate.parse(effectiveDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"))) ||
                            LocalDate.parse(effectiveDate).isBefore(LocalDate.now())) {
                        throw new CustomE2eException("MTA for effective date is not allowed");
                    } else {
                        for (var question : motorMTABeforeFormatting) {
                            if (question.contains("address")) {
                                motorAddressMTA = true;
                            } else if (question.contains("driver details")) {
                                motorDriversDetailsMTA = true;
                            } else if (question.contains("car")) {
                                motorChangeCarMTA = true;
                            }
                        }
                    }
                }else{
                        for (var question : motorMTABeforeFormatting) {
                            if (question.contains("address")) {
                                motorAddressMTA = true;
                            } else if (question.contains("driver details")) {
                                motorDriversDetailsMTA = true;
                            } else if (question.contains("car")) {
                                motorChangeCarMTA = true;
                            }
                    }
                }
            } else {
                throw new CustomE2eException("Policy with the policy number "+ policyNumber + " is not available for the current customer id: " + customerEmail);
            }


        } else if (policyNumber.trim().startsWith("HE")) {
            PortalLoginPage.redirectToHomeTab();
            var policyNumberOnPortal = vSelHelper.getText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().POLICY_NUMBER());
            if (policyNumberOnPortal.equalsIgnoreCase(policyNumber.trim())) {
                homeMTABeforeFormatting = vSelHelper.getTextAllWebElementMatchingLocator(this.pageObjectOfPortal.getPerformMTALocatorModel().HOME_MTA_ELEMENTS());
                if (vSelHelper.isElementVisible(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CHANGE_TEXT())) {
                    var changeTextOnPortal = vSelHelper.getText(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().CHANGE_TEXT());
                    var extractedDate = CommonHelper.extractDateFromString(LocalDate.now(), changeTextOnPortal);
                    if (extractedDate.isAfter(LocalDate.parse(effectiveDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")))) {
                        throw new CustomE2eException("MTA for effective date is not allowed because current MTA date is: " + extractedDate + " but requested MTA date is: " + effectiveDate + " and it is before the current date.");
                    }
                }
                else if(effectiveDateValue.isBefore(LocalDate.now())){
                    throw new CustomE2eException("MTA for effective date is not allowed because the: "+effectiveDateValue+" is in the past");

                }else {
                        for (var question : homeMTABeforeFormatting) {
                            if (question.contains("address")) {
                                vSelHelper.isElementVisible(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_HOME_TAB());
                                PerformMTAStepDefinition.editMainPolicyHolderAddressInHomeTab();
                                PerformMTAStepDefinition.importantInformationPage();
                                PerformMTAStepDefinition.selectEffectiveDate(effectiveDate);
                                try {
                                    homeAddressMTA = isElementEnabled(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EFFECTIVE_BTN());
                                } catch (Exception e) {
                                    homeAddressMTA = false;
                                }
                            } else if (question.contains("personal details")) {
                                vSelHelper.isElementVisible(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_HOME_TAB());
                                PortalLoginPage.redirectToHomeTab();
                                PerformMTAStepDefinition.editPersonalDetailsInHomeTab();
                                // PerformMTAStepDefinitions.importantInformationPage();
                                PerformMTAStepDefinition.selectEffectiveDate(effectiveDate);
                                try {
                                    homePersonalDetailsMTA = isElementEnabled(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EFFECTIVE_BTN());
                                } catch (Exception e) {
                                    homePersonalDetailsMTA = false;
                                }
                            } else if (question.contains("cover")) {
                                vSelHelper.isElementVisible(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_HOME_TAB());
                                PortalLoginPage.redirectToHomeTab();
                                PerformMTAStepDefinition.editMainPolicyHolderCoverInHomeTab();
                                //   PerformMTAStepDefinitions.importantInformationPage();
                                PerformMTAStepDefinition.selectEffectiveDate(effectiveDate);
                                try {
                                    homeCoverMTA = isElementEnabled(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EFFECTIVE_BTN());
                                } catch (Exception e) {
                                    homeCoverMTA = false;
                                }
                            }
                        }
                    }
            }
            else {
                throw new CustomE2eException("Policy with the policy number " + policyNumber + " is not available for the current customer id: " + customerEmail);
            }
        }else {
            throw new CustomE2eException("Policy number doesn't have recognised prefixes of GD for Car or HE for Home Policy");
        }

        var motorResults = new HashMap<String, Object>();
        motorResults.put(CAR_DRIVER_DETAILS, motorDriversDetailsMTA);
        motorResults.put(RISK_ADDRESS, motorAddressMTA);
        motorResults.put(CAR_COVER, motorChangeCarMTA);

        var homeResults = new HashMap<String, Object>();
        homeResults.put(HOME_POLICYHOLDER_DETAILS, homePersonalDetailsMTA);
        homeResults.put(RISK_ADDRESS, homeAddressMTA);
        homeResults.put(HOME_COVER, homeCoverMTA);

        var allResults = new HashMap<String, Object>();
        allResults.put(MOTOR, motorResults);
        allResults.put(HOME, homeResults);
        return allResults;
    }

}


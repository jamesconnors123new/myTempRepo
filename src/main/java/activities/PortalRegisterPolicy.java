package activities;

//import PageObjects.eService.SharedLocatorLibrary;

import helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import sqc.bstof.skeleton.ActivityEndpoint;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;
import sqc.bstof.skeletonhelp.LocalActionRecordingServices;
import sqc.bstof.skeletonhelp.LocalSettingsAndVariableAccessService;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class PortalRegisterPolicy implements ActivityEndpoint {
    private static final String YAML_POLICY_IDENTIFIER = "PolicyIdentifier";
    private static final String YAML_USERNAME = "Email";
    private static final String YAML_PASSWORD = "Password";
    private static final String YAML_POSTCODE = "Postcode";
    private static final String YAML_DOB = "Dob";


//    public boolean tryOneOffInitialisation() {
//        return true;
//    }

    LocalActionRecordingServices actionRecordingService;

    @Override
    public ActivityExecPeriodReturn execute(
            SequencerFaceToActivity sequencerFaceToActivity,
            UUID uuid,
            Map<String, Object> controlData,
            ActivityInterimState activityInterimState,
            PrintStream printStream) {
        WebDriver driver = null;
        boolean successfulRegistrationVisible = false;
        boolean invalidPolicyRecordVisible = false;
        boolean invalidDobVisible = false;
        boolean invalidPostcodeVisible = false;
        boolean alreadyRegistered = false;

        var dataAccess = new LocalSettingsAndVariableAccessService(sequencerFaceToActivity);
        var portalRootUrl = (String) dataAccess.getActivitySpecificSetting(CommonControlDataDefns.WEBSITE_ROOT);

        actionRecordingService = new LocalActionRecordingServices(sequencerFaceToActivity);

        String strLogLine = getClass().getSimpleName() + " Activity.execute";
        actionRecordingService.recordStartOfAnActivityInCaseInstRecord(strLogLine);

        var ui = new HashMap<String,Object>();
        var portalRegistration = new HashMap<String, Object>();
        var resultsData = new HashMap<String, Object>();
        var credentials = (Map)controlData.get(CommonControlDataDefns.CUSTOMER_CREDENTIALS);

        //var portalRootUrl = "https://azportaltestfd.brokerwebservice.co.uk/";
        try {
             driver = SeleniumHelper.openBrowser(portalRootUrl);
//            var registerPage = new RegisterLocatorLibrary(driver);
//            var sharedLocatorLib = new SharedLocatorLibrary(driver);

            var currentTime = System.currentTimeMillis();
            var timeLimit = currentTime + 30000;
            while (System.currentTimeMillis() < timeLimit){
                try {
//                    registerPage.getRegisterBtn().click();
                    //commonPageObject.acceptCookieBtn();
                    break;
                } catch (org.openqa.selenium.NoSuchElementException ex) {}
            }

//            registerPage.getRegisterBtn().click();
//
//            registerPage.getPolicyNumber().sendKeys(credentials.get(YAML_POLICY_IDENTIFIER).toString());
//
//            var dob = CommonHelper.splitDate(credentials.get(YAML_DOB).toString());
//
//            SeleniumHelper.selectFromDropDown(registerPage.getDobDay()).selectByValue(dob[2]);
//            SeleniumHelper.selectFromDropDown(registerPage.getDobMonth()).selectByValue(dob[1]);
//            SeleniumHelper.selectFromDropDown(registerPage.getDobYear()).selectByValue(dob[0]);
//
//            registerPage.getPostcode().sendKeys(credentials.get(YAML_POSTCODE).toString());
//            sharedLocatorLib.getUsername().sendKeys(credentials.get(YAML_USERNAME).toString());
//            sharedLocatorLib.getPassword().sendKeys(credentials.get(YAML_PASSWORD).toString());
//            registerPage.getCreateAccountBtn().click();

            currentTime = System.currentTimeMillis();
            timeLimit = currentTime+60000;

            while (System.currentTimeMillis()<timeLimit){

                try{
//                    registerPage.getAlreadyRegisteredIndicator().isDisplayed();
                    alreadyRegistered = true;
                    break;
                }catch(org.openqa.selenium.NoSuchElementException e){}

                try{
//                    registerPage.getInvalidPolicyRecordIndicator().isDisplayed();
                    invalidPolicyRecordVisible = true;
                    break;
                }catch (org.openqa.selenium.NoSuchElementException e){}

                try{
//                    registerPage.getInvalidPostcodeIndicator().isDisplayed();
                    invalidPostcodeVisible = true;
                    break;
                }catch (org.openqa.selenium.NoSuchElementException e){}

                try{
//                    registerPage.getInvalidDobIndicator().isDisplayed();
                    invalidDobVisible = true;
                    break;
                }catch (org.openqa.selenium.NoSuchElementException e){}

                try{
//                    registerPage.getGoToYourAccountBtn().isDisplayed();
                    successfulRegistrationVisible = true;
                    break;
                }catch (org.openqa.selenium.NoSuchElementException e){}
            }

            portalRegistration.put("Registered", successfulRegistrationVisible);
            portalRegistration.put("InvalidPolicyRecord", invalidPolicyRecordVisible);
            portalRegistration.put("InvalidPostcode", invalidPostcodeVisible);
            portalRegistration.put("InvalidDob", invalidDobVisible);
            portalRegistration.put("AlreadyRegistered", alreadyRegistered);
            ui.put("PortalRegistration",portalRegistration);
            resultsData.put("UI", ui);

            driver.quit();
            actionRecordingService.recordEndOfAnActivityInCaseInstRecord();
            return ActivityExecPeriodReturnImpl.completed(uuid, resultsData);

        } catch (Exception e) {
            actionRecordingService.writeToTestCaseInstanceRecord(getClass().getSimpleName() + "Activity failed; \n\n" + e.getStackTrace());
            driver.quit();
            return ActivityExecPeriodReturnImpl.faulted(uuid);
        }
    }
}

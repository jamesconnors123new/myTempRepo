package activities;

//import PageObjects.eService.SharedLocatorLibrary;

import helpers.CommonHelper;
import helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sqc.bstof.skeleton.ActivityEndpoint;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;
import sqc.bstof.skeletonhelp.LocalActionRecordingServices;
import sqc.bstof.skeletonhelp.LocalSettingsAndVariableAccessService;

import java.io.PrintStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class ForgotUsername implements ActivityEndpoint {
    private static final String WEB_DRIVER_HOME = "WebDriverHome";
    private static final String WEBSITE_ROOT = "ForgotUsernameRootURL";
    private static final String YAML_EMAIL = "Email";
    private static final String YAML_INCORRECT_EMAIL = "IncorrectEmail";
    private static final String YAML_POSTCODE = "Postcode";
    private static final String YAML_LAST_NAME = "LastName";
    private static final String YAML_DOB = "Dob";
    private static final String YAML_POLICY_IDENTIFIER = "PolNum";
    private WebDriverWait wait;

    public boolean tryOneOffInitialisation() {
        return true;
    }

    LocalActionRecordingServices actionRecordingService;

    @Override
    public ActivityExecPeriodReturn execute(
            SequencerFaceToActivity sequencerFaceToActivity,
            UUID uuid,
            Map<String, Object> controlData,
            ActivityInterimState activityInterimState,
            PrintStream printStream) {
        WebDriver driver = null;
        var dataAccess = new LocalSettingsAndVariableAccessService(sequencerFaceToActivity);
        var rootUrl = (String) dataAccess.getGlobalSetting(WEBSITE_ROOT);

        actionRecordingService = new LocalActionRecordingServices(sequencerFaceToActivity);
        String strLogLine = getClass().getSimpleName() + " Activity.execute";
        actionRecordingService.recordStartOfAnActivityInCaseInstRecord(strLogLine);

        var credentials = (Map)controlData.get(CommonControlDataDefns.CUSTOMER_CREDENTIALS);
        var resultsData = new HashMap<String,Object>();
        var ui = new HashMap<String,Object>();



        try {
             driver = SeleniumHelper.openBrowser(rootUrl);
//            var forgottenUsernamePage = new ForgottenUsernameLocatorLibrary(driver);
//            var sharedLocatorLib = new SharedLocatorLibrary(driver);

            //new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
            // .visibilityOf(sharedLocatorLib.getAcceptCookieBtn()));//.click();
            //Thread Sleep as last resort because Selenium is too quick to click the button once condition met.
            Thread.sleep(1500);
//            sharedLocatorLib.getAcceptCookieBtn().click();

            if(credentials.get(YAML_INCORRECT_EMAIL) != null){
//                sharedLocatorLib.getEmailInput().sendKeys(credentials.get(YAML_INCORRECT_EMAIL).toString());
//                sharedLocatorLib.getSubmitButton().click();
//                new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(forgottenUsernamePage.getLastNameIndicator()));
//                forgottenUsernamePage.getLastNameInput().sendKeys(credentials.get(YAML_LAST_NAME).toString());
                var dob = CommonHelper.splitDate(credentials.get(YAML_DOB).toString());
//                SeleniumHelper.selectFromDropDown(forgottenUsernamePage.getDobDay()).selectByValue(dob[2]);
//                SeleniumHelper.selectFromDropDown(forgottenUsernamePage.getDobMonth()).selectByValue(dob[1]);
//                SeleniumHelper.selectFromDropDown(forgottenUsernamePage.getDobYear()).selectByValue(dob[0]);
            //    forgottenUsernamePage.getPOSTCODE().sendKeys(credentials.get(YAML_POSTCODE)
                //    .toString());
            //    sharedLocatorLib.getSubmitButton().click();
                if(credentials.get(YAML_POLICY_IDENTIFIER)!=null){
                    new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.urlContains("multiplePolicy"));
                   // new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                    // .elementToBeClickable(forgottenUsernamePage.getPolicyNumberIdentifier()));
                   // forgottenUsernamePage.getPolicyNumber().sendKeys(credentials.get
                    // (YAML_POLICY_IDENTIFIER).toString());
               //     sharedLocatorLib.getSubmitButton().click();
                }
            }else{
              //  sharedLocatorLib.getEmailInput().sendKeys(credentials.get(YAML_EMAIL).toString());
               // sharedLocatorLib.getSubmitButton().click();
            }

            var currentTime = System.currentTimeMillis();
            var timeLimit = currentTime + 30000;

            ui.put(YAML_EMAIL, "No Username found");
            ui.put("UserNotFoundIndicator", FALSE);

            while(System.currentTimeMillis() < timeLimit){
                try{
                    if(driver.getCurrentUrl().contains("retrieveUsername")){
                       // new WebDriverWait(driver, Duration.ofSeconds(15)).until
                        // (ExpectedConditions.visibilityOfElementLocated(forgottenUsernamePage.getPageIndicator()));
                       // ui.replace(YAML_EMAIL,forgottenUsernamePage.getUsername().getText());
                        break;
                    }
                }catch (Exception ex){}

                try{
                    if(driver.getCurrentUrl().contains("userNotFound")){
                        ui.replace("UserNotFoundIndicator",TRUE);
                        break;
                    }
                }catch (Exception ex){}
            }

            resultsData.put("UI",ui);

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

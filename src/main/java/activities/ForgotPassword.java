package activities;

import helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class ForgotPassword implements ActivityEndpoint {
    private static final String WEB_DRIVER_HOME = "WebDriverHome";
    private static final String WEBSITE_ROOT = "PortalForgottenPasswordRootURL";
    private static final String YAML_EMAIL = "Email";

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
           // var forgotPassword = new ForgottenPasswordLocatorLibrary(driver);
            //new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
          // .visibilityOf(forgotPassword.getAcceptCookieBtn()));//.click();
            //Thread Sleep as last resort because Selenium is too quick to click the button once condition met.
            Thread.sleep(1500);
           // forgotPassword.getAcceptCookieBtn().click();

          //  forgotPassword.getEmailInput().sendKeys(credentials.get(YAML_EMAIL).toString());
          //  forgotPassword.getSubmitButton().click();

            ui.put("TechnicalError", FALSE);
            ui.put("PasswordEmailError", FALSE);
            ui.put("PasswordEmailSent", FALSE);

            var currentTime = System.currentTimeMillis();
            var timeLimit = currentTime + 30000;

            while (System.currentTimeMillis()<timeLimit){
                try {
                //    forgotPassword.getEmailErrorMsg().isDisplayed();
                    ui.replace("PasswordEmailError", TRUE);
                    break;
                }catch (org.openqa.selenium.NoSuchElementException ex){}

                try {
                  //  forgotPassword.getEmailSentMsg().isDisplayed();
                    ui.replace("PasswordEmailSent", TRUE);
                    break;
                }catch (org.openqa.selenium.NoSuchElementException ex){}

                try {
                    //forgotPassword.getTechnicalErrorMsg().isDisplayed();
                    ui.replace("TechnicalError", TRUE);
                    break;
                }catch (org.openqa.selenium.NoSuchElementException ex){}
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

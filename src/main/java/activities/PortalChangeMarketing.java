package activities;

import Generic.customExceptions.CustomE2eException;
import PageObjects.PortalModel.Root;
import StepDefinitions.PortalGeneralStepDefinitions;
import UiWrappers.Browser;
import UiWrappers.Portal.Site.PortalVer001;
import activities.bases.AgeasPortalLoggedInBase;
import helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import sqc.bstof.skeleton.ActivityEndpoint;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;
import sqc.bstof.skeletonhelp.StandardReportingPatterns;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class PortalChangeMarketing extends AgeasPortalLoggedInBase<PortalVer001> implements ActivityEndpoint {
  private static final String WEB_DRIVER_HOME = "WebDriverHome";
  private static final String WEBSITE_ROOT = "PortalRootUrl";
  private static final String YAML_POLICY_IDENTIFIER = "PolicyIdentifier";
  private static final String YAML_USERNAME = "Email";
  private static final String YAML_PASSWORD = "Password";
  private static final String YAML_POSTCODE = "Postcode";
  private static final String YAML_DOB = "Dob";

  private WebDriverWait wait;

  public boolean tryOneOffInitialisation() {
    return true;
  }

  StandardReportingPatterns actionRecordingService;

  @Override
  protected WebDriver ProvideWebDriver() throws CustomE2eException {
    return SeleniumHelper.openBrowser();
  }


    @Override
    protected boolean requiresLogin() {
        return false;
    }

  @Override
  public ActivityExecPeriodReturn performActionLoggedIntoPortal(Root pageObjectOfPortal, Browser<Root, PortalGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) {


    boolean successfulRegistrationVisible = false;
    boolean invalidPolicyRecordVisible = false;
    boolean invalidDobVisible = false;
    boolean invalidPostcodeVisible = false;
    boolean alreadyRegistered = false;


//        var dataAccess = new LocalSettingsAndVariableAccessService(sequencerFaceToActivity);
//        var webDriverHome = (String) dataAccess.getGlobalSetting(WEB_DRIVER_HOME);
//        var portalRootUrl = (String) dataAccess.getActivitySpecificSetting(WEBSITE_ROOT);

    actionRecordingService = new StandardReportingPatterns(sequencerFaceToActivity);

    String strLogLine = getClass().getSimpleName() + " Activity.execute";
    actionRecordingService.recordStartOfAnActivityInCaseInstRecord(strLogLine);

//        var ui = new HashMap<String,Object>();
//        var portalRegistration = new HashMap<String, Object>();
//        var credentials = (Map)controlData.get(CommonControlDataDefns.CUSTOMER_CREDENTIALS);

    var resultsData = new HashMap<String, Object>();


    var driver = (WebDriver) null;

    try {
//            driver = SeleniumHelper.openBrowser(portalRootUrl);
//            var dashboardPage = new DashboardLocatorLibrary(driver);
      //   new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions
      //   .visibilityOfElementLocated(dashboardPage.getMyAccountDetailsLinkIndicator()));
//            var currentTime = System.currentTimeMillis();
//            var timeLimit = currentTime + 15000;
//            while (System.currentTimeMillis() < timeLimit){
//                try{
//                    dashboardPage.getMyAccountDetailsLink().click();
//                    break;
//                }catch (org.openqa.selenium.StaleElementReferenceException ex){}
//            }

//            var myAccountsDetailsPage = new MyAccountsDetailsLocatorLibrary(driver);
//            new WebDriverWait(driver,Duration.ofSeconds(20000)).until(ExpectedConditions
//            .urlContains("my_account"));
//            myAccountsDetailsPage.getTextMarketing().click();
//            myAccountsDetailsPage.getEmailMarketing().click();
//            myAccountsDetailsPage.getPhoneMarketing().click();
//            myAccountsDetailsPage.getPostMarketing().click();
//            myAccountsDetailsPage.getSaveButton().click();

      return ActivityExecPeriodReturnImpl.completed(uuid, resultsData);

    } catch (Exception e) {
      actionRecordingService.reportMalfunctionIssue(getClass().getSimpleName() + "Activity " +
          "failed; \n\n" + e.getStackTrace());
      if (driver != null) {
        driver.quit();
      }
      return ActivityExecPeriodReturnImpl.faulted(uuid);
    }
  }
}

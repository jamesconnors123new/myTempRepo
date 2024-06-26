package activities.bases;

import Generic.customExceptions.CustomE2eException;
import StepDefinitions.EisGeneralStepDefinitions;
import UiWrappers.Browser;
import UiWrappers.Eis.Site.EisVer001;
import UiWrappers.SiteWrapper;
import activities.CommonControlDataDefns;
import helpers.ControlDataHelpers;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;

import java.io.PrintStream;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

public abstract class EisLoggedInBase<EisSite extends SiteWrapper> extends SingleBrowserSessionBase<PageObjects.EisModel.Root,
    EisGeneralStepDefinitions>{
  public static final String WEBSITE_ROOT = "EISLoginURL";
  public static final String USER_CREDENTIALS = "UserCredentials";
  public static final String CORE_USER_CREDENTIALS = "CoreAppUserCredentials";
  public static final String LOGIN_EMAIL = "Email";
  public static final String PASSWORD = "Password";

  private final String CHILD_ACTIVITY_IDENTIFYING_MSGPART = "performActionLoggedIntoEis";

  private final PageObjects.EisModel.Root EIS_PAGE_OBJECT_ROOT =
      new PageObjects.EisVersion.V01.Root();

  @Override
  protected PageObjects.EisModel.Root ProvidePom(){
    return EIS_PAGE_OBJECT_ROOT;
  }

  @Override
  protected Function<WebDriver, EisGeneralStepDefinitions> ProvideCommonStep() {
    return (WebDriver pDriver)-> new EisGeneralStepDefinitions(pDriver, ProvidePom());
  }


  protected abstract ActivityExecPeriodReturn performActionLoggedIntoEis(PageObjects.EisModel.Root pageObjectOfEis, Browser<PageObjects.EisModel.Root, EisGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream)
      throws CustomE2eException;

  private static String FormEisUrlMessage(CommonControlDataDefns.E_ControlDataSource pSource, String pUrl) {
    return "Using eis url from "+pSource.name()+" value: " + pUrl;
  }

  @Override
  protected ActivityExecPeriodReturn executeUsingBrowser(Browser<PageObjects.EisModel.Root,
      EisGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity,
                                                         UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) {
    // Website url
    var vFaulted = false;
    var rootUrl = (String)null;
    if(ControlDataHelpers.ValidateMapContainsFieldWithNonEmptyStringValue(controlData,
        WEBSITE_ROOT)) {
      rootUrl = ((String)controlData.get(WEBSITE_ROOT)).trim();
      useActionRecordingService().writeToTestCaseInstanceRecord(FormEisUrlMessage(CommonControlDataDefns.E_ControlDataSource.ControlData, rootUrl));
    } else {
      var rootUrlAsObject = useSettingsAndVariableAccess().getRuntimeValue(WEBSITE_ROOT);
      if(rootUrlAsObject!=null && rootUrlAsObject instanceof String && !StringUtils.isBlank((String)rootUrlAsObject)) {
        rootUrl = ((String)rootUrlAsObject).trim();
        useActionRecordingService().writeToTestCaseInstanceRecord(FormEisUrlMessage(CommonControlDataDefns.E_ControlDataSource.TestInstanceDataStore, rootUrl));
      } else {
        vFaulted = true;
        useActionRecordingService().reportControlDataIssue(ControlDataHelpers.MissingValueErrorMessage(WEBSITE_ROOT));
      }
    }

    // Credentials
    if(!ControlDataHelpers.ValidateMapContainsNonEmptyStringValueAtPath(controlData,USER_CREDENTIALS, LOGIN_EMAIL)) {
      useActionRecordingService().reportControlDataIssue(ControlDataHelpers.MissingValueErrorMessage(LOGIN_EMAIL));
      vFaulted = true;
    }
    if(!ControlDataHelpers.ValidateMapContainsNonEmptyStringValueAtPath(controlData,USER_CREDENTIALS, PASSWORD)) {
      useActionRecordingService().reportControlDataIssue(ControlDataHelpers.MissingValueErrorMessage(PASSWORD));
      vFaulted = true;
    }
    if(vFaulted) {
      return ActivityExecPeriodReturnImpl.faulted(uuid);
    }
    // Extract values
    var vCredentials = (Map<String,Object>)controlData.get(USER_CREDENTIALS);
    // Perform login
    var vSite = new EisVer001(ProvidePom(), useActionRecordingService());
    if(!vSite.GoToEisAndLogin(pBrowser,rootUrl,vCredentials)) {
      useActionRecordingService().reportRuntimeFaultIssue("Failed to goto and login to EIS");
      return ActivityExecPeriodReturnImpl.faulted(uuid);
    }
    // Execute logged on action
    try {
      return performActionLoggedIntoEis(EIS_PAGE_OBJECT_ROOT, pBrowser,
          sequencerFaceToActivity,uuid, controlData, activityInterimState, printStream);
    } catch(CustomE2eException pCustomE2eException) {
      useActionRecordingService().reportRuntimeFaultIssue(CHILD_ACTIVITY_IDENTIFYING_MSGPART+": " + pCustomE2eException.getMessage());
      return ActivityExecPeriodReturnImpl.faulted(uuid);
    } catch(Throwable pThrown) {
      useActionRecordingService().reportMalfunctionIssue(CHILD_ACTIVITY_IDENTIFYING_MSGPART+": " +pThrown.getMessage());
      return ActivityExecPeriodReturnImpl.faulted(uuid);
    } finally {

    }
  }

}

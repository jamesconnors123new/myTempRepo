package activities.bases;


import Generic.customExceptions.CustomE2eException;
import PageObjects.EchelonModel.Root;
import StepDefinitions.EchelonGeneralStepDefinitions;
import UiWrappers.Browser;
import UiWrappers.Echelon.Site.EchelonVer001;
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

public abstract class EchelonLoggedInBase <EchelonSite extends SiteWrapper> extends SingleBrowserSessionBase<Root, EchelonGeneralStepDefinitions>{
  private static final String WEBSITE_ROOT = "EchelonLoginURL";
  public static final String USER_CREDENTIALS = "UserCredentials";
  public static final String LOGIN_EMAIL = "Email";
  public static final String PASSWORD = "Password";

  private final String CHILD_ACTIVITY_IDENTIFYING_MSGPART = "performActionLoggedIntoEchelon";

  private final Root ECHELON_PAGE_OBJECT_ROOT =
      new PageObjects.EchelonVersion.V01.Root();

  @Override
  protected Root ProvidePom(){
    return ECHELON_PAGE_OBJECT_ROOT;
  }

  @Override
  protected Function<WebDriver, EchelonGeneralStepDefinitions> ProvideCommonStep() {
    return (WebDriver pDriver)-> new EchelonGeneralStepDefinitions(pDriver, ProvidePom());
  }

  protected abstract ActivityExecPeriodReturn performActionLoggedIntoEchelon(Root pageObjectOfEchelon, Browser<Root, EchelonGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream)
      throws CustomE2eException;

  private static String FormEchelonUrlMessage(CommonControlDataDefns.E_ControlDataSource pSource, String pUrl) {
    return "Using Echelon url from "+pSource.name()+" value: " + pUrl;
  }

  @Override
  protected ActivityExecPeriodReturn executeUsingBrowser(Browser<Root, EchelonGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity,
                                                         UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) {
    // Website url
    var vFaulted = false;
    var rootUrl = (String)null;
    if(ControlDataHelpers.ValidateMapContainsFieldWithNonEmptyStringValue(controlData,
        WEBSITE_ROOT)) {
      rootUrl = ((String)controlData.get(WEBSITE_ROOT)).trim();
      useActionRecordingService().writeToTestCaseInstanceRecord(FormEchelonUrlMessage(CommonControlDataDefns.E_ControlDataSource.ControlData, rootUrl));
    } else {
      var rootUrlAsObject = useSettingsAndVariableAccess().getRuntimeValue(WEBSITE_ROOT);
      if(rootUrlAsObject!=null && rootUrlAsObject instanceof String && !StringUtils.isBlank((String)rootUrlAsObject)) {
        rootUrl = ((String)rootUrlAsObject).trim();
        useActionRecordingService().writeToTestCaseInstanceRecord(FormEchelonUrlMessage(CommonControlDataDefns.E_ControlDataSource.TestInstanceDataStore, rootUrl));
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
    var vSite = new EchelonVer001(ProvidePom(), useActionRecordingService());
    if(!vSite.GoToEchelonAndLogin(pBrowser,rootUrl,vCredentials)) {
      useActionRecordingService().reportRuntimeFaultIssue("Failed to goto and login to Echelon");
      return ActivityExecPeriodReturnImpl.faulted(uuid);
    }
    // Execute logged on action
    try {
      return performActionLoggedIntoEchelon(ECHELON_PAGE_OBJECT_ROOT, pBrowser,
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

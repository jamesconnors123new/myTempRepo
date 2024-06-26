package activities.bases;

import Generic.customExceptions.CustomE2eException;
import StepDefinitions.PortalGeneralStepDefinitions;
import UiWrappers.Browser;
import UiWrappers.Portal.Site.PortalVer001;
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

public abstract class AgeasPortalLoggedInBase<PortalSite extends SiteWrapper> extends SingleBrowserSessionBase<PageObjects.PortalModel.Root, PortalGeneralStepDefinitions> {

    private final String CHILD_ACTIVITY_IDENTIFYING_MSGPART = "performActionLoggedIntoPortal";

    private final PageObjects.PortalModel.Root PORTAL_PAGE_OBJECT_ROOT =
            new PageObjects.PortalVersion.V01.Root();

    @Override
    protected PageObjects.PortalModel.Root ProvidePom() {
        return PORTAL_PAGE_OBJECT_ROOT;
    }

    @Override
    protected Function<WebDriver, PortalGeneralStepDefinitions> ProvideCommonStep() {
        return (WebDriver pDriver) -> new PortalGeneralStepDefinitions(pDriver, ProvidePom());
    }

    protected abstract boolean requiresLogin();

    protected abstract ActivityExecPeriodReturn performActionLoggedIntoPortal(PageObjects.PortalModel.Root pageObjectOfPortal, Browser<PageObjects.PortalModel.Root, PortalGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream)
            throws CustomE2eException;

    private static String FormPortalUrlMessage(CommonControlDataDefns.E_ControlDataSource pSource, String pUrl) {
        return "Using portal url from " + pSource.name() + " value: " + pUrl;
    }

    @Override
    protected ActivityExecPeriodReturn executeUsingBrowser(Browser<PageObjects.PortalModel.Root,
            PortalGeneralStepDefinitions> pBrowser,
                                                           SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) {
        // Website url
        var vFaulted = false;
        var rootUrl = (String) null;
        if (ControlDataHelpers.ValidateMapContainsFieldWithNonEmptyStringValue(controlData, CommonControlDataDefns.WEBSITE_ROOT)) {
            rootUrl = ((String) controlData.get(CommonControlDataDefns.WEBSITE_ROOT)).trim();
            useActionRecordingService().writeToTestCaseInstanceRecord(FormPortalUrlMessage(CommonControlDataDefns.E_ControlDataSource.ControlData, rootUrl));
        } else {
            var rootUrlAsObject = useSettingsAndVariableAccess().getRuntimeValue(CommonControlDataDefns.WEBSITE_ROOT);
            if (rootUrlAsObject != null && rootUrlAsObject instanceof String && !StringUtils.isBlank((String) rootUrlAsObject)) {
                rootUrl = ((String) rootUrlAsObject).trim();
                useActionRecordingService().writeToTestCaseInstanceRecord(FormPortalUrlMessage(CommonControlDataDefns.E_ControlDataSource.TestInstanceDataStore, rootUrl));
            } else {
                vFaulted = true;
                useActionRecordingService().reportControlDataIssue(ControlDataHelpers.MissingValueErrorMessage(CommonControlDataDefns.WEBSITE_ROOT));
            }
        }

        // Extract values
        //var rootUrl = (String)controlData.get(CommonControlDataDefns.WEBSITE_ROOT);
        var vSite = new PortalVer001(ProvidePom(), useActionRecordingService());
        if (requiresLogin()) {
            // Credentials
            if (!ControlDataHelpers.ValidateMapContainsNonEmptyStringValueAtPath(controlData, CommonControlDataDefns.CUSTOMER_CREDENTIALS, CommonControlDataDefns.EMAIL)) {
                useActionRecordingService().reportControlDataIssue(ControlDataHelpers.MissingValueErrorMessage(CommonControlDataDefns.EMAIL));
                vFaulted = true;
            }
            if (!ControlDataHelpers.ValidateMapContainsNonEmptyStringValueAtPath(controlData, CommonControlDataDefns.CUSTOMER_CREDENTIALS, CommonControlDataDefns.PASSWORD)) {
                useActionRecordingService().reportControlDataIssue(ControlDataHelpers.MissingValueErrorMessage(CommonControlDataDefns.PASSWORD));
                vFaulted = true;
            }
            if (vFaulted) {
                return ActivityExecPeriodReturnImpl.faulted(uuid);
            }
            var vCredentials = (Map<String, Object>) controlData.get(CommonControlDataDefns.CUSTOMER_CREDENTIALS);

            if (!vSite.GoToPortalAndLogin(pBrowser, rootUrl, vCredentials) && vCredentials != null) {
                useActionRecordingService().reportRuntimeFaultIssue("Failed to goto and login to portal");
                return ActivityExecPeriodReturnImpl.faulted(uuid);
            }

        } else if (!vSite.GoToPortal(pBrowser, rootUrl)) {
            useActionRecordingService().reportRuntimeFaultIssue("Failed to goto portal");
            return ActivityExecPeriodReturnImpl.faulted(uuid);
        }


        // Perform login

        // Execute logged on action

        try {
            return performActionLoggedIntoPortal(PORTAL_PAGE_OBJECT_ROOT, pBrowser,
                    sequencerFaceToActivity, uuid, controlData, activityInterimState, printStream);
        } catch (CustomE2eException pCustomE2eException) {
            useActionRecordingService().reportRuntimeFaultIssue(CHILD_ACTIVITY_IDENTIFYING_MSGPART + ": " + pCustomE2eException.getMessage());
            return ActivityExecPeriodReturnImpl.faulted(uuid);
        } catch (Throwable pThrown) {
            useActionRecordingService().reportMalfunctionIssue(CHILD_ACTIVITY_IDENTIFYING_MSGPART + ": " + pThrown.getMessage());
            return ActivityExecPeriodReturnImpl.faulted(uuid);
        } finally {

        }
    }
}
